import SwiftUI

struct ResultsView: View {
    let classifyResponse: ClassifyResponse
    let executeResponse: ExecuteResponse?  // Optional if needed elsewhere

    // New state to drive navigation to the execute response view
    @State private var selectedExecuteResponse: ExecuteResponse?
    @State private var shouldNavigateToExecuteResponse = false

    var body: some View {
        VStack(alignment: .leading, spacing: 20) {
            // Display extracted code if available
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
            
            // Display questions as buttons
            ForEach(classifyResponse.questions, id: \.id) { question in
                Button(action: {
                    Task {
                        do {
                            let response = try await handleQuestionTap(
                                for: question,
                                classifyResponse: classifyResponse
                            )
                            // Update state on the main thread to trigger navigation
                            DispatchQueue.main.async {
                                self.selectedExecuteResponse = response
                                self.shouldNavigateToExecuteResponse = true
                            }
                        } catch {
                            print("Error handling question tap: \(error)")
                        }
                    }
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
            
            // Hidden NavigationLink that activates when shouldNavigateToExecuteResponse is true
            NavigationLink(
                destination: executeResponseDestination,
                isActive: $shouldNavigateToExecuteResponse,
                label: { EmptyView() }
            )
        }
    }
    
    // Computed property for the destination view.
    private var executeResponseDestination: some View {
        if let response = selectedExecuteResponse {
            return AnyView(ExecuteResponseView(executeResponse: response))
        } else {
            return AnyView(EmptyView())
        }
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
