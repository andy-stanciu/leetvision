import Foundation

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
    
    static func execute(
        code: String?,
        language: String?,
        question: String,
        questionId: Int
    ) async throws -> ExecuteResponse {
        var payload: [String: Any] = [
            "question": question,
            "question_id": questionId,
            "LEETCODE_SESSION": AppConstants.LeetCode.leetcode_session,
            "csrftoken": AppConstants.LeetCode.csrftoken,
            "cf_clearance": AppConstants.LeetCode.cf_clearance
        ]
        
        // Only add 'code' and 'language' if non-nil.
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
        // Construct URL using constants
        let urlString = "http://\(AppConstants.Network.host):\(AppConstants.Network.port)\(endpoint)"
        guard let url = URL(string: urlString) else {
            throw NetworkError.invalidURL
        }
        
        // Configure request
        var request = URLRequest(url: url)
        request.httpMethod = "POST"
        request.addValue("application/json", forHTTPHeaderField: "Content-Type")
        request.httpBody = try JSONSerialization.data(withJSONObject: body)
        
        // Send request
        let (data, response) = try await URLSession.shared.data(for: request)
        
        // Validate HTTP response
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
