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
            
            // TODO: use classifyResponse
            
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
                        Button(action: {
                            // Handle the button tap
                            handleQuestionTap(for: question, classifyResponse: classifyResponse)
                        }) {
                            Text(question.question)
                                .padding()
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .background(Color.blue.opacity(0.1))
                                .cornerRadius(8)
                        }
                        .buttonStyle(PlainButtonStyle())
                        .padding(.vertical, 4)
                    }
                }
            }
        }
    }

    private func handleQuestionTap(for question: ClassifyResponse.Question, classifyResponse: ClassifyResponse) async throws -> ExecuteResponse {
        return try await NetworkService.execute(
            code: classifyResponse.code,
            language: classifyResponse.language,
            question: question.question,
            questionId: question.id
        )
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
    
    static func execute(code: String?, language: String?, question: String, questionId: Int) async throws -> ExecuteResponse {
        var payload: [String: Any] = [
            "question": question,
            "question_id": questionId
        ]
        
        // Only add 'code' and 'language' if they are non-nil.
        if let code = code {
            payload["code"] = code
        }
        if let language = language {
            payload["language"] = language
        }
        
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
        let id: Int
        let question: String
    }
}

struct ExecuteResponse: Decodable {
    let data: SubmissionData

    struct SubmissionData: Decodable {
        let submissionDetails: SubmissionDetails
    }

    struct SubmissionDetails: Decodable {
        let code: String
        let codeOutput: String?
        let compileError: String?
        let expectedOutput: String?
        let flagType: String
        let fullCodeOutput: String?
        let lang: Language
        let lastTestcase: String?
        let memory: Int
        let memoryDisplay: String
        let memoryDistribution: String?
        let memoryPercentile: Double
        let notes: String?
        let question: Question
        let runtime: Int
        let runtimeDisplay: String
        let runtimeDistribution: String?
        let runtimeError: String?
        let runtimePercentile: Double
        let statusCode: Int
        let stdOutput: String?
        let testBodies: String?
        let testDescriptions: String?
        let testInfo: String?
        let timestamp: Int
        let topicTags: [String]
        let totalCorrect: Int
        let totalTestcases: Int
        let user: User
    }

    struct Language: Decodable {
        let name: String
        let verboseName: String
    }

    struct Question: Decodable {
        let hasFrontendPreview: Bool
        let questionId: String
        let titleSlug: String
    }

    struct User: Decodable {
        let profile: UserProfile
        let username: String
    }

    struct UserProfile: Decodable {
        let realName: String
        let userAvatar: String
    }
}


struct HomeView_Previews: PreviewProvider {
    static var previews: some View {
        HomeView()
    }
}
