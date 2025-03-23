import SwiftUI
import PhotosUI
import WebKit

// MARK: - OAuthWebView
struct OAuthWebView: UIViewRepresentable {
    /// Completion handler returns the filtered cookies upon successful login.
    var completion: ([HTTPCookie]) -> Void

    func makeCoordinator() -> Coordinator {
        Coordinator(self)
    }
    
    func makeUIView(context: Context) -> WKWebView {
        let config = WKWebViewConfiguration()
        
        // Set up a user content controller to inject JavaScript and capture messages.
        let userContentController = WKUserContentController()
        userContentController.add(context.coordinator, name: "networkLogger")
        
        // JavaScript to override fetch and XMLHttpRequest.
        let scriptSource = """
        (function() {
            function logRequest(method, url, requestHeaders, responseHeaders) {
                window.webkit.messageHandlers.networkLogger.postMessage({
                    method: method,
                    url: url,
                    requestHeaders: requestHeaders,
                    responseHeaders: responseHeaders,
                    cookies: document.cookie
                });
            }
            
            // Override fetch.
            const originalFetch = window.fetch;
            window.fetch = async function(resource, init) {
                let reqHeaders = {};
                if (init && init.headers) {
                    // If headers is a Headers object, convert it to a plain object.
                    if (init.headers.forEach) {
                        init.headers.forEach((value, key) => {
                            reqHeaders[key] = value;
                        });
                    } else {
                        reqHeaders = init.headers;
                    }
                }
                let response = await originalFetch.apply(this, arguments);
                let clonedResponse = response.clone();
                let headers = {};
                clonedResponse.headers.forEach((value, key) => {
                    headers[key] = value;
                });
                logRequest("fetch", resource.toString(), reqHeaders, headers);
                return response;
            };
            
            // Override XMLHttpRequest.
            let origOpen = XMLHttpRequest.prototype.open;
            let origSend = XMLHttpRequest.prototype.send;
            XMLHttpRequest.prototype.open = function(method, url) {
                this._method = method;
                this._url = url;
                return origOpen.apply(this, arguments);
            };
            XMLHttpRequest.prototype.send = function(body) {
                this.addEventListener('load', function() {
                    let headers = {};
                    let allHeaders = this.getAllResponseHeaders();
                    if (allHeaders) {
                        allHeaders.split("\\r\\n").forEach(function(line) {
                            let parts = line.split(': ');
                            if (parts.length === 2) {
                                headers[parts[0]] = parts[1];
                            }
                        });
                    }
                    logRequest(this._method, this._url, body || {}, headers);
                });
                return origSend.apply(this, arguments);
            };
        })();
        """
        
        let userScript = WKUserScript(source: scriptSource,
                                      injectionTime: .atDocumentStart,
                                      forMainFrameOnly: false)
        userContentController.addUserScript(userScript)
        config.userContentController = userContentController
        
        let webView = WKWebView(frame: .zero, configuration: config)
        webView.navigationDelegate = context.coordinator
        
        // Load LeetCode's login page.
        if let url = URL(string: "https://leetcode.com/accounts/login") {
            let request = URLRequest(url: url)
            webView.load(request)
        }
        return webView
    }
    
    func updateUIView(_ uiView: WKWebView, context: Context) {
        // No update logic required.
    }
    
    // MARK: - Coordinator
    class Coordinator: NSObject, WKNavigationDelegate, WKScriptMessageHandler {
        var parent: OAuthWebView
        
        init(_ parent: OAuthWebView) {
            self.parent = parent
        }
        
        // Capture messages from the injected JS.
        func userContentController(_ userContentController: WKUserContentController,
                                   didReceive message: WKScriptMessage) {
            if message.name == "networkLogger" {
                if let dict = message.body as? [String: Any],
                   let urlString = dict["url"] as? String {
                    // Filter for GraphQL network calls.
                    if urlString.contains("leetcode.com/graphql") {
                        print("Captured GraphQL Request/Response:")
                        print("Method: \(dict["method"] ?? "N/A")")
                        print("URL: \(urlString)")
                        print("Request Headers: \(dict["requestHeaders"] ?? "N/A")")
                        print("Response Headers: \(dict["responseHeaders"] ?? "N/A")")
                        print("Cookies: \(dict["cookies"] ?? "N/A")")
                    }
                }
            }
        }
        
        // For document navigations, print response headers.
        func webView(_ webView: WKWebView,
                     decidePolicyFor navigationResponse: WKNavigationResponse,
                     decisionHandler: @escaping (WKNavigationResponsePolicy) -> Void) {
            if let httpResponse = navigationResponse.response as? HTTPURLResponse,
               let url = httpResponse.url {
                print("Response Headers for \(url.absoluteString):")
                print(httpResponse.allHeaderFields)
            }
            decisionHandler(.allow)
        }
        
        // Detect login success and retrieve cookies.
        func webView(_ webView: WKWebView,
                     decidePolicyFor navigationAction: WKNavigationAction,
                     decisionHandler: @escaping (WKNavigationActionPolicy) -> Void) {
            if let url = navigationAction.request.url {
                if url.absoluteString.contains("loginSuccess") {
                    webView.configuration.websiteDataStore.httpCookieStore.getAllCookies { cookies in
                        let filteredCookies = cookies.filter { cookie in
                            return cookie.name == "LEETCODE_SESSION" ||
                                   cookie.name == "cf_clearance" ||
                                   cookie.name == "csrftoken"
                        }
                        DispatchQueue.main.async {
                            self.parent.completion(filteredCookies)
                        }
                    }
                    decisionHandler(.cancel)
                    return
                }
            }
            decisionHandler(.allow)
        }
    }
}

// MARK: - HomeView
struct HomeView: View {
    // MARK: - UI State
    @State private var selectedItem: PhotosPickerItem?
    @State private var selectedImageData: Data?
    @State private var isLoading = false
    @State private var errorMessage: String?
    
    // MARK: - Server Responses
    @State private var classifyResponse: ClassifyResponse?
    @State private var executeResponse: ExecuteResponse?
    
    // MARK: - Navigation Trigger
    @State private var shouldNavigate = false
    
    // MARK: - OAuth State
    @State private var oauthCookies: [HTTPCookie]? = nil
    @State private var isShowingOAuth = false
    
    var body: some View {
        NavigationView {
            ScrollView {
                VStack(alignment: .leading, spacing: 20) {
                    
                    // OAuth Section
                    if oauthCookies != nil {
                        Button("Sign in with LeetCode") {
                            isShowingOAuth = true
                        }
                        .font(.headline)
                        .padding()
                        .frame(maxWidth: .infinity)
                        .background(Color.blue.opacity(0.7))
                        .foregroundColor(.white)
                        .cornerRadius(12)
                        .padding()
                    } else {
                        // Image Selection Section
                        VStack {
                            if let imageData = selectedImageData,
                               let uiImage = UIImage(data: imageData) {
                                Image(uiImage: uiImage)
                                    .resizable()
                                    .scaledToFit()
                                    .frame(maxHeight: 300)
                                    .cornerRadius(12)
                            } else {
                                RoundedRectangle(cornerRadius: 12)
                                    .fill(Color(.systemGray5))
                                    .frame(height: 220)
                                    .overlay(
                                        Text("Select an image containing code")
                                            .font(.headline)
                                            .foregroundColor(.gray)
                                    )
                            }
                            
                            PhotosPicker(
                                selection: $selectedItem,
                                matching: .images
                            ) {
                                Text("Select image")
                                    .font(.headline)
                                    .padding()
                                    .frame(maxWidth: .infinity)
                                    .background(Color.blue.opacity(0.7))
                                    .foregroundColor(.white)
                                    .cornerRadius(12)
                            }
                            .padding(.top, 10)
                            
                            if selectedImageData != nil {
                                Button("Execute code") {
                                    Task {
                                        await analyzeImage()
                                    }
                                }
                                .font(.headline)
                                .padding()
                                .frame(maxWidth: .infinity)
                                .background(Color.green.opacity(0.7))
                                .foregroundColor(.white)
                                .cornerRadius(12)
                                .padding(.top, 5)
                            }
                        }
                        .padding()
                        .background(Color.white)
                        .cornerRadius(12)
                        .shadow(color: Color.black.opacity(0.1), radius: 4, x: 0, y: 2)
                    }
                    
                    // Additional UI Components
                    if isLoading {
                        HStack {
                            Spacer()
                            ProgressView("Processing...")
                            Spacer()
                        }
                    }
                    
                    if let errorMessage = errorMessage {
                        Text(errorMessage)
                            .font(.body)
                            .foregroundColor(.red)
                            .padding()
                            .background(Color.red.opacity(0.1))
                            .cornerRadius(12)
                    }
                    
                    Image("leetvision")
                        .resizable()
                        .scaledToFill()
                        .clipped()
                        .cornerRadius(12)
                        .padding(.bottom, 20)
                    
                    NavigationLink(
                        destination: destinationView,
                        isActive: $shouldNavigate,
                        label: { EmptyView() }
                    )
                    
                    Spacer()
                }
                .padding()
            }
            .background(Color(red: 194/255, green: 209/255, blue: 215/255, opacity: 1.0))
            .ignoresSafeArea(.all, edges: .bottom)
            .navigationBarHidden(false)
        }
        // Present the OAuthWebView when needed.
        .sheet(isPresented: $isShowingOAuth) {
            OAuthWebView { cookies in
                oauthCookies = cookies
                isShowingOAuth = false
                // For debugging: print all filtered cookies.
                print("Filtered OAuth Cookies:")
                cookies.forEach { print("\($0.name): \($0.value)") }
            }
        }
    }
    
    // Computed Destination View
    private var destinationView: some View {
        Group {
            if let classifyResponse = classifyResponse {
                ResultsView(classifyResponse: classifyResponse)
            } else {
                EmptyView()
            }
        }
    }
    
    // Helper Methods
    private func loadImageData(from item: PhotosPickerItem?) {
        guard let item = item else { return }
        item.loadTransferable(type: Data.self) { result in
            switch result {
            case .success(let data):
                DispatchQueue.main.async {
                    self.selectedImageData = data
                    self.classifyResponse = nil
                    self.executeResponse = nil
                    self.errorMessage = nil
                }
            case .failure(let error):
                DispatchQueue.main.async {
                    self.errorMessage = "Failed to load image: \(error.localizedDescription)"
                }
            }
        }
    }
    
    private func analyzeImage() async {
        guard let imageData = selectedImageData else {
            errorMessage = "Please select an image first"
            return
        }
        
        do {
            DispatchQueue.main.async {
                self.isLoading = true
                self.errorMessage = nil
            }
            
            let response = try await NetworkService.classify(imageData: imageData)
            
            DispatchQueue.main.async {
                self.classifyResponse = response
                self.isLoading = false
                self.shouldNavigate = true
            }
        } catch {
            DispatchQueue.main.async {
                self.isLoading = false
                self.errorMessage = "Error: \(error.localizedDescription)"
            }
        }
    }
}

// MARK: - Preview
struct HomeView_Previews: PreviewProvider {
    static var previews: some View {
        HomeView()
    }
}
