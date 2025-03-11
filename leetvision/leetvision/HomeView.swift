import SwiftUI
import PhotosUI

struct HomeView: View {
    // State variables for UI
    @State private var selectedItem: PhotosPickerItem?
    @State private var selectedImageData: Data?
    @State private var isLoading = false
    @State private var errorMessage: String?
    
    // State variables for server responses
    @State private var classifyResponse: ClassifyResponse?
    @State private var executeResponse: ExecuteResponse?
    
    var body: some View {
        ScrollView {
            VStack(alignment: .leading, spacing: 20) {
                // Title
                Text("Code Analyzer")
                    .font(.largeTitle)
                    .fontWeight(.bold)
                    .padding(.bottom, 10)
                
                // Image selection
                VStack(alignment: .center) {
                    if let selectedImageData, let uiImage = UIImage(data: selectedImageData) {
                        Image(uiImage: uiImage)
                            .resizable()
                            .scaledToFit()
                            .frame(maxHeight: 300)
                            .cornerRadius(8)
                    } else {
                        RoundedRectangle(cornerRadius: 12)
                            .fill(Color.gray.opacity(0.2))
                            .frame(height: 200)
                            .overlay(
                                Text("Select an image containing code")
                                    .foregroundColor(.gray)
                            )
                    }
                    
                    PhotosPicker(
                        selection: $selectedItem,
                        matching: .images
                    ) {
                        Text("Select Image")
                            .padding()
                            .background(Color.blue)
                            .foregroundColor(.white)
                            .cornerRadius(8)
                    }
                    .padding(.top, 10)
                    
                    if selectedImageData != nil {
                        Button("Analyze Code") {
                            Task {
                                await analyzeImage()
                            }
                        }
                        .padding()
                        .background(Color.green)
                        .foregroundColor(.white)
                        .cornerRadius(8)
                        .padding(.top, 5)
                    }
                }
                .padding()
                .background(Color.white)
                .cornerRadius(12)
                .shadow(radius: 2)
                
                // Loading indicator
                if isLoading {
                    HStack {
                        Spacer()
                        ProgressView("Processing...")
                        Spacer()
                    }
                }
                
                // Error message
                if let errorMessage = errorMessage {
                    Text(errorMessage)
                        .foregroundColor(.red)
                        .padding()
                        .background(Color.red.opacity(0.1))
                        .cornerRadius(8)
                }
                
                // Results
                if let classifyResponse = classifyResponse {
                    ResultsView(classifyResponse: classifyResponse, executeResponse: executeResponse)
                }
                
                Spacer()
            }
            .padding()
        }
        .onChange(of: selectedItem) { newItem in
            loadImageData(from: newItem)
        }
    }
    
    private func loadImageData(from item: PhotosPickerItem?) {
        guard let item = item else { return }
        
        item.loadTransferable(type: Data.self) { result in
            switch result {
            case .success(let data):
                DispatchQueue.main.async {
                    self.selectedImageData = data
                    // Reset previous results
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
            
            // Call classify endpoint
            let classifyResponse = try await NetworkService.classify(imageData: imageData)
            
            DispatchQueue.main.async {
                self.classifyResponse = classifyResponse
            }
            
            // Check if we have a valid question to execute
            if let firstQuestion = classifyResponse.questions.first,
               let code = classifyResponse.code,
               let language = classifyResponse.language {
                
                // Call execute endpoint
                let executeResponse = try await NetworkService.execute(
                    code: code,
                    language: language,
                    question: firstQuestion.question,
                    questionId: firstQuestion.id
                )
                
                DispatchQueue.main.async {
                    self.executeResponse = executeResponse
                }
            }
            
            DispatchQueue.main.async {
                self.isLoading = false
            }
        } catch {
            DispatchQueue.main.async {
                self.isLoading = false
                self.errorMessage = "Error: \(error.localizedDescription)"
            }
        }
    }
}

// MARK: - Supporting Views

struct ResultsView: View {
    let classifyResponse: ClassifyResponse
    let executeResponse: ExecuteResponse?
    
    var body: some View {
        VStack(alignment: .leading, spacing: 20) {
            // Code section
            if let code = classifyResponse.code, let language = classifyResponse.language {
                VStack(alignment: .leading) {
                    Text("Extracted Code (\(language))")
                        .font(.headline)
                    
                    Text(code)
                        .font(.system(.body, design: .monospaced))
                        .padding()
                        .background(Color.gray.opacity(0.1))
                        .cornerRadius(8)
                }
            }
            
            // Questions section
            if !classifyResponse.questions.isEmpty {
                VStack(alignment: .leading) {
                    Text("Questions")
                        .font(.headline)
                    
                    ForEach(classifyResponse.questions, id: \.id) { question in
                        Text(question.question)
                            .padding()
                            .background(Color.blue.opacity(0.1))
                            .cornerRadius(8)
                    }
                }
            }
            
            // Execution results
            if let executeResponse = executeResponse {
                VStack(alignment: .leading) {
                    Text("Execution Results")
                        .font(.headline)
                    
                    VStack(alignment: .leading, spacing: 10) {
                        HStack {
                            Text("Status:")
                                .fontWeight(.bold)
                            Text(executeResponse.status)
                                .foregroundColor(executeResponse.status == "success" ? .green : .red)
                        }
                        
                        if let output = executeResponse.output {
                            Text("Output:")
                                .fontWeight(.bold)
                            Text(output)
                                .font(.system(.body, design: .monospaced))
                                .padding()
                                .background(Color.gray.opacity(0.1))
                                .cornerRadius(8)
                        }
                        
                        if let error = executeResponse.error {
                            Text("Error:")
                                .fontWeight(.bold)
                            Text(error)
                                .foregroundColor(.red)
                                .font(.system(.body, design: .monospaced))
                                .padding()
                                .background(Color.red.opacity(0.1))
                                .cornerRadius(8)
                        }
                    }
                    .padding()
                    .background(Color.gray.opacity(0.05))
                    .cornerRadius(8)
                }
            }
        }
    }
}

// MARK: - Network Service

struct NetworkService {
    static func classify(imageData: Data) async throws -> ClassifyResponse {
        let base64String = imageData.base64EncodedString()
        let payload = ["image": base64String]
        
        return try await sendRequest(
            endpoint: "/classify",
            body: payload,
            responseType: ClassifyResponse.self
        )
    }
    
    static func execute(code: String, language: String, question: String, questionId: String) async throws -> ExecuteResponse {
        let payload: [String: Any] = [
            "code": code,
            "language": language,
            "question": question,
            "question_id": questionId
        ]
        
        return try await sendRequest(
            endpoint: "/execute",
            body: payload,
            responseType: ExecuteResponse.self
        )
    }
    
    private static func sendRequest<T: Decodable>(
        endpoint: String,
        body: [String: Any],
        responseType: T.Type
    ) async throws -> T {
        // Construct URL from constants
        let urlString = "http://\(AppConstants.Network.host):\(AppConstants.Network.port)\(endpoint)"
        guard let url = URL(string: urlString) else {
            throw NetworkError.invalidURL
        }
        
        // Prepare request
        var request = URLRequest(url: url)
        request.httpMethod = "POST"
        request.addValue("application/json", forHTTPHeaderField: "Content-Type")
        
        // Convert body to JSON data
        request.httpBody = try JSONSerialization.data(withJSONObject: body)
        
        // Send request
        let (data, response) = try await URLSession.shared.data(for: request)
        
        // Check for HTTP errors
        guard let httpResponse = response as? HTTPURLResponse else {
            throw NetworkError.unknownResponse
        }
        
        guard (200...299).contains(httpResponse.statusCode) else {
            throw NetworkError.serverError(statusCode: httpResponse.statusCode)
        }
        
        // Decode response
        return try JSONDecoder().decode(responseType, from: data)
    }
}

enum NetworkError: Error, LocalizedError {
    case invalidURL
    case invalidResponse
    case unknownResponse
    case serverError(statusCode: Int)
    
    var errorDescription: String? {
        switch self {
        case .invalidURL:
            return "Invalid URL"
        case .invalidResponse:
            return "Invalid response from server"
        case .unknownResponse:
            return "Unknown response type"
        case .serverError(let statusCode):
            return "Server error with status code: \(statusCode)"
        }
    }
}

// MARK: - Models

struct ClassifyResponse: Decodable {
    let code: String?
    let language: String?
    let questions: [Question]
    
    struct Question: Decodable {
        let id: String
        let question: String
    }
}

struct ExecuteResponse: Decodable {
    let status: String
    let output: String?
    let error: String?
}

struct HomeView_Previews: PreviewProvider {
    static var previews: some View {
        HomeView()
    }
}
