import SwiftUI
import UIKit
import HighlightSwift

struct CodeBlockView: View {
    let code: String
    let language: String
    let typewriterEffect: Bool

    @State private var result: String? = nil
    @State private var showCopied: Bool = false

    var body: some View {
        VStack {
            if let result = result {
                if result.count == code.count {
                    ZStack(alignment: .bottomTrailing) {
                        // Final render with proper highlighting.
                        CodeText(result)
                            .highlightLanguage(getHighlightLanguage())
                            .codeTextColors(.theme(.github))
                            .font(.system(size: 12, weight: .regular))
                            .padding(.all, 12)
                        
                        // Button & "Copied!" label in a VStack
                        HStack(spacing: 4) {
                            if showCopied {
                                Text("Copied!")
                                    .font(.caption)
                                    .padding(6)
                                    .background(Color.black.opacity(0.2))
                                    .foregroundColor(.white)
                                    .cornerRadius(8)
                                    .transition(.opacity)
                            }
                            Button(action: {
                                // Copy the displayed code or fallback to original code.
                                UIPasteboard.general.string = result ?? code
                                withAnimation {
                                    showCopied = true
                                }
                                // Hide "Copied!" after 1.5 seconds.
                                DispatchQueue.main.asyncAfter(deadline: .now() + 1.5) {
                                    withAnimation {
                                        showCopied = false
                                    }
                                }
                            }) {
                                Image(systemName: "doc.on.doc")
                                    .foregroundColor(.primary)
                                    .padding(8)
                                    .background(Color.black.opacity(0.2))
                                    .clipShape(RoundedRectangle(cornerRadius: 8))
                            }
                        }
                        .padding(8)
                    }
                } else {
                    // Typewriter render (forcing a re-initialization by using .id(result)).
                    CodeText(result)
                        .highlightLanguage(.plaintext)
                        .id(result)
                        .font(.system(size: 12, weight: .regular))
                        .padding(.all, 12)
                }
            }
        }
        .task {
            if typewriterEffect {
                result = ""
                let groupSize = 8  // Change this value to control how many characters appear at once.
                var index = code.startIndex
                while index < code.endIndex {
                    let nextIndex = code.index(index, offsetBy: groupSize, limitedBy: code.endIndex) ?? code.endIndex
                    let group = code[index..<nextIndex]
                    result?.append(contentsOf: group)
                    index = nextIndex
                    // Wait 0.1 seconds between groups.
                    try? await Task.sleep(nanoseconds: 10_000_000)
                }
            } else {
                result = code
            }
        }
    }
    
    func getHighlightLanguage() -> HighlightLanguage {
        switch language {
        case "java":
            return .java
        case "c++", "cpp":
            return .cPlusPlus
        case "c":
            return .c
        case "c#", "csharp":
            return .cSharp
        case "javascript", "js":
            return .javaScript
        case "typescript", "ts":
            return .typeScript
        case "python3", "python":
            return .python
        case "golang", "go":
            return .go
        default:
            return .plaintext
        }
    }
}

struct CodeBlockView_Previews: PreviewProvider {
    static var previews: some View {
        CodeBlockView(code: "hello, world!\n", language: "java", typewriterEffect: true)
            .frame(minHeight: 150)
    }
}
