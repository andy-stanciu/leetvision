import SwiftUI

// New ExecutingView with different gradient colors.
struct ExecutingView: View {
    @State private var animate = false

    var body: some View {
        ZStack {
            // Use a different gradient (orange to red).
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
                .frame(width: 120, height: 120)
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
        .toolbar(.hidden, for: .tabBar)
        .navigationBarBackButtonHidden(true)
        .onAppear {
            animate = true
        }
    }
}

struct QuestionsView: View {
    let classifyResponse: ClassifyResponse

    // State for managing visible questions count.
    @State private var visibleCount: Int = 1
    // For navigating to the ExecuteResponseView.
    @State private var selectedExecuteResponse: ExecuteResponse?
    @State private var shouldNavigateToExecuteResponse: Bool = false
    
    // New state for showing the ExecutingView.
    @State private var isExecuting: Bool = false

    var body: some View {
        ZStack {
            ScrollView {  // Entire content is wrapped in a vertical ScrollView.
                VStack(alignment: .leading, spacing: 20) {
                    Text("What're you solving?")
                        .font(.system(size: 34, weight: .bold))
                        .padding(.bottom, 20)
                    
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
                                Text("\(question.id). \(prettyText(for: question.question))")
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
                .padding(20)
            }
            
            // Overlay: Show ExecutingView while isExecuting is true.
            if isExecuting {
                ExecutingView()
                    .transition(.opacity)
                    .animation(.easeInOut(duration: 0.3), value: isExecuting)
            }
        }
    }
    
    // Helper: Transform a question string by splitting on "-" and capitalizing each word.
    private func prettyText(for text: String) -> String {
        text.split(separator: "-")
            .map { $0.capitalized }
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
