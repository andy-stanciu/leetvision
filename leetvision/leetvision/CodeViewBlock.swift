import SwiftUI
import UIKit
import HighlightSwift

struct CodeBlockView: View {
    let code: String
    let language: String
    let typewriterEffect: Bool
    
    @State private var result: String? = nil
    
    var body: some View {
        VStack {
            if let result = result {
                if result.count == code.count {
                    // Final render with proper highlighting.
                    CodeText(result)
                        .highlightLanguage(.java)
                        .codeTextColors(.theme(.github))
                        .font(.system(size: 12, weight: .regular))
                        .padding(.all, 12)
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
}

struct CodeBlockView_Previews: PreviewProvider {
    static var previews: some View {
        CodeBlockView(code: "hello, world!\n", language: "java", typewriterEffect: true)
            .frame(minHeight: 150)
    }
}
