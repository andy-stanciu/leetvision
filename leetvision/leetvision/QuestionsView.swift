import SwiftUI

struct QuestionsView: View {
    let classifyResponse: ClassifyResponse

    // State for managing visible questions count
    @State private var visibleCount: Int = 1
    // To show a progress indicator for the tapped question
    @State private var loadingQuestionId: Int? = nil
    // For navigating to the ExecuteResponseView
    @State private var selectedExecuteResponse: ExecuteResponse?
    @State private var shouldNavigateToExecuteResponse: Bool = false

    var body: some View {
        ScrollView {  // Wrap entire content in vertical ScrollView
            VStack(alignment: .leading, spacing: 20) {
                Text("What're you solving?")
                    .font(.system(size: 34, weight: .bold))
                    .padding(.bottom, 20)
                
                // Render visible questions
                ForEach(0..<min(visibleCount, classifyResponse.questions.count), id: \.self) { index in
                    let question = classifyResponse.questions[index]
                    Button(action: {
                        loadingQuestionId = question.id
                        Task {
                            do {
                                let response = try await handleQuestionTap(for: question, classifyResponse: classifyResponse)
                                DispatchQueue.main.async {
                                    selectedExecuteResponse = response
                                    shouldNavigateToExecuteResponse = true
                                    loadingQuestionId = nil
                                }
                            } catch {
                                print("Error handling question tap: \(error)")
                                loadingQuestionId = nil
                            }
                        }
                    }) {
                        HStack {
                            // Display question id and formatted question text that wraps.
                            Text("\(question.id). \(prettyText(for: question.question))")
                                .font(.headline)
                                .multilineTextAlignment(.leading)
                                .fixedSize(horizontal: false, vertical: true)
                            Spacer()
                            if loadingQuestionId == question.id {
                                ProgressView()
                            }
                        }
                        .padding()
                        .frame(maxWidth: .infinity, alignment: .leading)
                        .background(Color.blue.opacity(0.1))
                        .cornerRadius(8)
                    }
                    .buttonStyle(PlainButtonStyle())
                }
                
                // See more button if not all questions are visible
                if visibleCount < classifyResponse.questions.count {
                    Button(action: {
                        let remaining = classifyResponse.questions.count - visibleCount
                        if remaining > 5 {
                            visibleCount += 5
                        } else {
                            visibleCount = classifyResponse.questions.count
                        }
                    }) {
                        Text("See more...")
                            .font(.headline)
                            .padding()
                            .frame(maxWidth: .infinity)
                            .background(Color.gray.opacity(0.2))
                            .cornerRadius(8)
                    }
                }
                
                // Hidden NavigationLink to navigate to ExecuteResponseView when a question is selected
                NavigationLink(
                    destination: Group {
                        if let response = selectedExecuteResponse {
                            ExecuteResponseView(executeResponse: response)
                        } else {
                            EmptyView()
                        }
                    },
                    isActive: $shouldNavigateToExecuteResponse,
                    label: { EmptyView() }
                )
                
                Spacer()
            }
            .padding(20)
        }
    }
    
    // Helper: Transform a question string by splitting on "-" and capitalizing each word.
    private func prettyText(for text: String) -> String {
        text.split(separator: "-")
            .map { $0.capitalized }
            .joined(separator: " ")
    }
    
    // MARK: - Networking for Question Handling
    private func handleQuestionTap(
        for question: ClassifyResponse.Question,
        classifyResponse: ClassifyResponse
    ) async throws -> ExecuteResponse {
        return try await NetworkService.execute(
            code: classifyResponse.code,
            language: classifyResponse.language,
            question: question.question,
            questionId: question.id
        )
    }
}
