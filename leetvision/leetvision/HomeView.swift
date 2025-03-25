import SwiftUI
import PhotosUI
import WebKit

struct AnalyzingView: View {
    @State private var animate = false

    var body: some View {
        ZStack {
            // Vibrant gradient background.
            LinearGradient(
                gradient: Gradient(colors: [Color.blue, Color.purple]),
                startPoint: .topLeading,
                endPoint: .bottomTrailing
            )
            .ignoresSafeArea()
            
            VStack(spacing: 40) {
                // Custom spinning circular indicator.
                ZStack {
                    Circle()
                        .stroke(Color.white.opacity(0.3), lineWidth: 8)
                        .frame(width: 120, height: 120)
                    
                    Circle()
                        .trim(from: 0.15, to: 0.85)
                        .stroke(Color.white, style: StrokeStyle(lineWidth: 8, lineCap: .round))
                        .frame(width: 120, height: 120)
                }
                .frame(width: 120, height: 120)
                .rotationEffect(Angle(degrees: animate ? 360 : 0))
                .animation(Animation.linear(duration: 1.5).repeatForever(autoreverses: false), value: animate)
                
                // Analyzing message.
                Text("Analyzing your LeetCode solution...")
                    .font(.title2)
                    .fontWeight(.bold)
                    .foregroundColor(.white)
                    .multilineTextAlignment(.center)
                    .padding(.horizontal, 40)
            }
        }
        .toolbar(.hidden, for: .tabBar)
        .onAppear {
            animate = true
        }
    }
}

struct HomeView: View {
    // MARK: - UI State
    @State private var selectedItem: PhotosPickerItem?
    @State private var selectedImageData: Data?
    @State private var errorMessage: String?
    
    // MARK: - Server Responses
    @State private var classifyResponse: ClassifyResponse?
    @State private var executeResponse: ExecuteResponse?
    
    // MARK: - Transition States
    @State private var isLoading = false
    @State private var shouldNavigate = false
    
    // MARK: - OAuth State
    @State private var oauthCookies: OAuthCookies? = nil
    @State private var isShowingOAuth = false
    
    var body: some View {
        ZStack {
            NavigationView {
                ScrollView {
                    VStack(alignment: .leading, spacing: 20) {
                        
                        // OAuth Section – show sign in button if not logged in.
                        if oauthCookies == nil {
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
                            // Signed In Box with Sign Out Button.
                            if let cookies = oauthCookies {
                                HStack {
                                    // Left side: Signed In component.
                                    HStack(alignment: .center, spacing: 12) {
                                        if let avatarURL = URL(string: cookies.avatar), !cookies.avatar.isEmpty {
                                            AsyncImage(url: avatarURL) { image in
                                                image
                                                    .resizable()
                                                    .aspectRatio(contentMode: .fill)
                                            } placeholder: {
                                                ProgressView()
                                            }
                                            .frame(width: 50, height: 50)
                                            .clipShape(Circle())
                                        }
                                        VStack(alignment: .leading, spacing: 2) {
                                            Text("Signed in as:")
                                                .fontWeight(.semibold)
                                                .foregroundColor(.black)
                                            Text(cookies.username)
                                                .foregroundColor(.black)
                                        }
                                    }
                                    
                                    Spacer()
                                    
                                    // Right side: Sign Out button.
                                    Button("Sign out") {
                                        oauthCookies = nil
                                        selectedImageData = nil
                                        selectedItem = nil
                                        AppConstants.LeetCode.csrftoken = ""
                                        AppConstants.LeetCode.cf_clearance = ""
                                        AppConstants.LeetCode.leetcode_session = ""
                                        
                                        // Clear all cookies from the default website data store.
                                        WKWebsiteDataStore.default().httpCookieStore.getAllCookies { cookies in
                                            for cookie in cookies {
                                                WKWebsiteDataStore.default().httpCookieStore.delete(cookie)
                                            }
                                        }
                                    }
                                    .padding(8)
                                    .background(Color.red.opacity(0.8))
                                    .foregroundColor(.white)
                                    .cornerRadius(8)
                                }
                                .padding()
                                .background(Color.white)
                                .cornerRadius(12)
                                .shadow(color: Color.black.opacity(0.1), radius: 4, x: 0, y: 2)
                            }
                            
                            // Image Selection Section.
                            VStack {
                                if let imageData = selectedImageData,
                                   let uiImage = UIImage(data: imageData) {
                                    Image(uiImage: uiImage)
                                        .resizable()
                                        .scaledToFit()
                                        .frame(maxHeight: 300)
                                        .cornerRadius(12)
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
                                .onChange(of: selectedItem) { newItem in
                                    loadImageData(from: newItem)
                                }
                                
                                if selectedImageData != nil {
                                    Button("Execute code") {
                                        // Start analysis.
                                        shouldNavigate = true
                                        withAnimation(.easeOut(duration: 0.3)) {
                                            isLoading = true
                                        }
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
                        
                        // Error Message.
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
                        
                        // NavigationLink to push the ResultsView.
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
            .sheet(isPresented: $isShowingOAuth) {
                NavigationView {
                    OAuthWebView { cookies in
                        oauthCookies = cookies
                        isShowingOAuth = false
                        AppConstants.LeetCode.update(with: cookies)
                        print("OAuth Cookies:")
                        print("csrftoken: \(AppConstants.LeetCode.csrftoken)")
                        print("cf_clearance: \(AppConstants.LeetCode.cf_clearance)")
                        print("LEETCODE_SESSION: \(AppConstants.LeetCode.leetcode_session)")
                    }
                }
            }
            
            // Overlay: Show AnalyzingView when isLoading is true.
            if isLoading {
                AnalyzingView()
                    .transition(.opacity)
            }
        }
    }
    
    // Computed Destination View: Renders ResultsView on a new page if analysis is successful.
    private var destinationView: some View {
        Group {
            if let response = classifyResponse {
                ResultsView(classifyResponse: response)
            } else {
                VStack {
                    Text("Analysis failed. Please try again.")
                        .foregroundColor(.red)
                        .padding()
                    Button("Return") {
                        shouldNavigate = false
                    }
                    .padding()
                    .background(Color.blue.opacity(0.7))
                    .foregroundColor(.white)
                    .cornerRadius(8)
                }
            }
        }
    }
    
    // Helper Methods.
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
            let response = try await NetworkService.classify(imageData: imageData)
            DispatchQueue.main.async {
                self.classifyResponse = response
                withAnimation(.easeOut(duration: 0.3)) {
                    self.isLoading = false
                }
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
