import Foundation

struct ClassifyResponse: Decodable {
    let code: String?
    let language: String?
    let questions: [Question]
    
    struct Question: Decodable, Identifiable {
        let id: Int
        let question: String
    }
}

struct ExecuteResponse: Codable {
    let data: SubmissionData

    struct SubmissionData: Codable {
        let submissionDetails: SubmissionDetails
    }

    struct SubmissionDetails: Codable {
        let runtime: Int
        let runtimeDisplay: String
        let runtimePercentile: Double?
        let runtimeDistribution: String?
        
        let memory: Int
        let memoryDisplay: String
        let memoryPercentile: Double?
        let memoryDistribution: String?
        
        let code: String
        let timestamp: Int
        let statusCode: Int
        
        let user: User
        let lang: Language
        let question: Question
        
        let notes: String?
        let flagType: String
        let topicTags: [String]
        
        let runtimeError: String?
        let compileError: String?
        let lastTestcase: String?
        let codeOutput: String?
        let expectedOutput: String?
        let totalCorrect: Int?
        let totalTestcases: Int?
        let fullCodeOutput: String?
        let testDescriptions: String?
        let testBodies: String?
        let testInfo: String?
        let stdOutput: String?
    }

    struct User: Codable {
        let username: String
        let profile: UserProfile
    }

    struct UserProfile: Codable {
        let realName: String
        let userAvatar: String
    }

    struct Language: Codable {
        let name: String
        let verboseName: String
    }

    struct Question: Codable {
        let questionId: String
        let titleSlug: String
        let hasFrontendPreview: Bool
    }
}
