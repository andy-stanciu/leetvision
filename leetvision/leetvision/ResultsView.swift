import SwiftUI

struct ResultsView: View {
    let classifyResponse: ClassifyResponse

    // State for managing visible questions count.
    @State private var visibleCount: Int = 1
    // For navigating to the ExecuteResponseView.
    @State private var selectedExecuteResponse: ExecuteResponse?
    @State private var shouldNavigateToExecuteResponse: Bool = false
    // New state for showing the ExecutingView.
    @State private var isExecuting: Bool = false

    var body: some View {
        // Overlay: Show ExecutingView while isExecuting is true.
        if isExecuting {
            ExecutingView()
                .transition(.opacity)
                .animation(.easeInOut(duration: 0.3), value: isExecuting)
        } else {
            ScrollView {
                VStack(alignment: .leading, spacing: 10) {
                    // Title
                    Text("What're you solving?")
                        .font(.system(size: 34, weight: .bold))
                    
                    VStack(alignment: .leading, spacing: 4) {
                        Text("Your solution")
                            .font(.title3)
                            .padding(.bottom, 6)
                            .foregroundColor(Color(UIColor.white))
                        
                        // Code block display: non-editable with horizontal scrolling
                        ScrollView(.horizontal, showsIndicators: true) {
                            CodeBlockView(code: extractedCode, language: languageName, typewriterEffect: true)
                        }
                        .background(Color(UIColor.systemGray6))
                        .cornerRadius(8)
                    }
                    .padding(12)
                    .background(Color(UIColor.blackAccent))
                    .cornerRadius(8)
                    .shadow(color: Color.black.opacity(0.1), radius: 5)
                    
                    VStack(alignment: .leading, spacing: 4) {
                        Text("Similar LeetCode questions")
                            .font(.title3)
                            .padding(.bottom, 6)
                            .foregroundColor(Color(UIColor.white))
                        
                        ZStack {
                            ScrollView {  // Entire content is wrapped in a vertical ScrollView.
                                VStack(alignment: .leading, spacing: 20) {
                                    // Render visible questions.
                                    ForEach(0..<min(visibleCount, classifyResponse.questions.count), id: \.self) { index in
                                        let question = classifyResponse.questions[index]
                                        Button(action: {
                                            // When a question is tapped, show the full-screen ExecutingView.
                                            withAnimation(.easeInOut(duration: 0.3)) {
                                                isExecuting = true
                                            }
                                            Task {
                                                do {
                                                    let response = try await handleQuestionTap(for: question, classifyResponse: classifyResponse)
                                                    DispatchQueue.main.async {
                                                        selectedExecuteResponse = response
                                                        shouldNavigateToExecuteResponse = true
                                                        withAnimation(.easeInOut(duration: 0.3)) {
                                                            isExecuting = false
                                                        }
                                                    }
                                                } catch {
                                                    print("Error handling question tap: \(error)")
                                                    DispatchQueue.main.async {
                                                        withAnimation(.easeInOut(duration: 0.3)) {
                                                            isExecuting = false
                                                        }
                                                    }
                                                }
                                            }
                                        }) {
                                            HStack {
                                                // Display question id and formatted text.
                                                Text("LeetCode #\(question.id): \(prettyText(for: question.question))")
                                                    .font(.headline)
                                                    .multilineTextAlignment(.leading)
                                                    .fixedSize(horizontal: false, vertical: true)
                                                Spacer()
                                            }
                                            .padding()
                                            .frame(maxWidth: .infinity, alignment: .leading)
                                            .background(Color.blue.opacity(0.1))
                                            .cornerRadius(8)
                                        }
                                        .buttonStyle(PlainButtonStyle())
                                    }
                                    
                                    // "See more" button if there are more questions.
                                    if visibleCount < classifyResponse.questions.count {
                                        Button(action: {
                                            let remaining = classifyResponse.questions.count - visibleCount
                                            visibleCount += (remaining > 5 ? 5 : remaining)
                                        }) {
                                            Text("See more...")
                                                .font(.headline)
                                                .padding()
                                                .frame(maxWidth: .infinity)
                                                .background(Color.gray.opacity(0.2))
                                                .cornerRadius(8)
                                        }
                                    }
                                    
                                    // Hidden NavigationLink to navigate to ExecuteResponseView when a question is selected.
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
                            }
                        }
                    }
                    .padding(12)
                    .background(Color(UIColor.blackAccent))
                    .cornerRadius(8)
                    .shadow(color: Color.black.opacity(0.1), radius: 5)
                }
                .padding(.horizontal, 10)
            }
        }
    }
    
    // Computed property: explicitly trim trailing whitespace and newlines
    private var extractedCode: String {
        let code = classifyResponse.code ?? ""
        return code.trimmingCharacters(in: .whitespacesAndNewlines)
    }
    
    private var languageName: String {
        classifyResponse.language ?? "plaintext"
    }
    
    private func prettyText(for text: String) -> String {
        return text.split(separator: "-")
            .map { substring -> String in
                let word = String(substring)
                if word.allSatisfy({ $0.lowercased() == "i" }) {
                    return word.uppercased()
                } else {
                    return word.capitalized
                }
            }
            .joined(separator: " ")
    }
    
    // Networking function for handling question tap.
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

struct ResultsView_Previews: PreviewProvider {
    static var previews: some View {
        ResultsView(classifyResponse: ClassifyResponse(code: "print(\"Hello, world!\")\n\n", language: "swift", questions: []))
    }
}

// New ExecutingView with different gradient colors.
struct ExecutingView: View {
    @State private var animate = false

    var body: some View {
        ZStack {
            // Background gradient that already ignores safe areas.
            LinearGradient(
                gradient: Gradient(colors: [Color.orange, Color.red]),
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
                .rotationEffect(Angle(degrees: animate ? 360 : 0))
                .animation(Animation.linear(duration: 1.5).repeatForever(autoreverses: false), value: animate)
                
                // Executing message.
                Text("Executing your solution...")
                    .font(.title2)
                    .fontWeight(.bold)
                    .foregroundColor(.white)
                    .multilineTextAlignment(.center)
                    .padding(.horizontal, 40)
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity) // Force full-screen size.
        .toolbar(.hidden, for: .tabBar)
        .navigationBarBackButtonHidden(true)
        .onAppear {
            animate = true
        }
    }
}

extension UIColor {
    static let blackAccent = UIColor(red: 10/255, green: 10/255, blue: 10/255, alpha: 1)
}
