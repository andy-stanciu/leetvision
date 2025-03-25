import SwiftUI
import WebKit

/// Struct to hold the three cookies of interest plus user info.
struct OAuthCookies {
    let csrftoken: HTTPCookie
    let cf_clearance: HTTPCookie
    let leetcodeSession: HTTPCookie
    let username: String
    let avatar: String
}

// MARK: - OAuthWebView
struct OAuthWebView: UIViewRepresentable {
    /// Completion handler returns the OAuthCookies upon successful login.
    var completion: (OAuthCookies) -> Void

    func makeCoordinator() -> Coordinator {
        Coordinator(self)
    }
    
    func makeUIView(context: Context) -> WKWebView {
        let config = WKWebViewConfiguration()
        
        // Set up a user content controller to inject JavaScript.
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
        
        // Flag to ensure we complete only once.
        var didComplete = false
        
        init(_ parent: OAuthWebView) {
            self.parent = parent
        }
        
        // No logging needed.
        func userContentController(_ userContentController: WKUserContentController,
                                   didReceive message: WKScriptMessage) {
            // No logging.
        }
        
        func webView(_ webView: WKWebView,
                     decidePolicyFor navigationResponse: WKNavigationResponse,
                     decisionHandler: @escaping (WKNavigationResponsePolicy) -> Void) {
            decisionHandler(.allow)
        }
        
        // Allow all navigation actions.
        func webView(_ webView: WKWebView,
                     decidePolicyFor navigationAction: WKNavigationAction,
                     decisionHandler: @escaping (WKNavigationActionPolicy) -> Void) {
            decisionHandler(.allow)
        }
        
        // After each navigation, check the internal cookie store and extract user info.
        func webView(_ webView: WKWebView, didFinish navigation: WKNavigation!) {
            webView.configuration.websiteDataStore.httpCookieStore.getAllCookies { cookies in
                print("Internal Cookie Store State:")
                for cookie in cookies {
                    print("Name: \(cookie.name), Value: \(cookie.value), Domain: \(cookie.domain)")
                }
                
                // Check if all required cookies are present.
                if let csrf = cookies.first(where: { $0.name == "csrftoken" }),
                   let clearance = cookies.first(where: { $0.name == "cf_clearance" }),
                   let session = cookies.first(where: { $0.name == "LEETCODE_SESSION" }),
                   !self.didComplete {
                    
                    // Evaluate JavaScript to extract userStatus.
                    webView.evaluateJavaScript("window.LeetCodeData.userStatus") { result, error in
                        if let userStatus = result as? [String: Any],
                           let username = userStatus["username"] as? String,
                           let avatar = userStatus["avatar"] as? String {
                            self.didComplete = true
                            DispatchQueue.main.async {
                                let oauthCookies = OAuthCookies(csrftoken: csrf,
                                                                cf_clearance: clearance,
                                                                leetcodeSession: session,
                                                                username: username,
                                                                avatar: avatar)
                                self.parent.completion(oauthCookies)
                            }
                        } else {
                            print("Failed to extract userStatus: \(error?.localizedDescription ?? "unknown error")")
                        }
                    }
                }
            }
        }
    }
}
