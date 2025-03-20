import SwiftUI

struct ResultsView: View {
    let classifyResponse: ClassifyResponse

    // Navigation trigger to go to QuestionsView
    @State private var navigateToQuestions: Bool = false
    
    // Environment dismiss to pop back to Home (for retake)
    @Environment(\.dismiss) var dismiss

    var body: some View {
        VStack(alignment: .leading, spacing: 20) {
            // Title
            Text("Here's what we got")
                .font(.system(size: 34, weight: .bold))
                .padding(.bottom, 4)
            
            // Code block display: non-editable with horizontal scrolling
            ScrollView(.horizontal, showsIndicators: true) {
                CodeBlockView(code: extractedCode, language: languageName)
                    .frame(minHeight: 150)
            }
            .background(Color(UIColor.systemGray6))
            .cornerRadius(8)
            
            // Single "Looks good!" button spanning full width
            Button("Looks good!") {
                navigateToQuestions = true
            }
            .font(.title2)
            .buttonStyle(.borderedProminent)
            .frame(maxWidth: .infinity, alignment: .leading)
            .padding(.top, 20)
            
            // NavigationLink to go to QuestionsView
            NavigationLink(
                destination: Group {
                    if classifyResponse.questions.isEmpty {
                        AnyView(EmptyView())
                    } else {
                        AnyView(QuestionsView(classifyResponse: classifyResponse))
                    }
                },
                isActive: $navigateToQuestions,
                label: { EmptyView() }
            )
            
            Spacer()
        }
        .padding(.horizontal, 20)
        .padding(.vertical, 10)
    }
    
    // Computed property: explicitly trim trailing whitespace and newlines
    private var extractedCode: String {
        let code = classifyResponse.code ?? ""
        return code.trimmingCharacters(in: .whitespacesAndNewlines)
    }
    
    private var languageName: String {
        classifyResponse.language ?? "plaintext"
    }
}

struct ResultsView_Previews: PreviewProvider {
    static var previews: some View {
        ResultsView(classifyResponse: ClassifyResponse(code: "print(\"Hello, world!\")\n\n", language: "swift", questions: []))
    }
}
