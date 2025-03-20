import SwiftUI

struct ExecuteResponseView: View {
    let executeResponse: ExecuteResponse

    var body: some View {
        ScrollView {
            if runtimeDisplay == "N/A" {
                if lastTestcaseText == "N/A" {
                    // Third case: Incorrect solution with no testcase available
                    VStack(alignment: .leading, spacing: 12) {
                        Text("Incorrect solution")
                            .font(.largeTitle)
                            .fontWeight(.bold)
                            .foregroundColor(.red)
                            .padding(.vertical, 8)
                        
                        // Runtime Error
                        VStack(alignment: .leading, spacing: 4) {
                            Text("Runtime Error:")
                                .fontWeight(.semibold)
                            Text(runtimeErrorText)
                                .padding(8)
                                .background(Color.red.opacity(0.1))
                                .cornerRadius(8)
                        }
                        
                        // Compile Error
                        VStack(alignment: .leading, spacing: 4) {
                            Text("Compile Error:")
                                .fontWeight(.semibold)
                            Text(compileErrorText)
                                .padding(8)
                                .background(Color.red.opacity(0.1))
                                .cornerRadius(8)
                        }
                        
                        // Code snippet with horizontal scrolling
                        Text("Code")
                            .font(.headline)
                            .padding(.bottom, 4)
                        ScrollView(.horizontal, showsIndicators: true) {
                            CodeBlockView(code: extractedCode, language: languageName)
                                .frame(minHeight: 150)
                        }
                        .background(Color(UIColor.systemGray6))
                        .cornerRadius(8)
                        
                        // User Info
                        HStack(alignment: .center, spacing: 12) {
                            if let avatarURL = URL(string: userAvatar), !userAvatar.isEmpty {
                                AsyncImage(url: avatarURL) { image in
                                    image
                                        .resizable()
                                        .aspectRatio(contentMode: .fill)
                                } placeholder: {
                                    ProgressView()
                                }
                                .frame(width: 50, height: 50)
                                .clipShape(Circle())
                            }
                            VStack(alignment: .leading, spacing: 2) {
                                Text("Submitting as:")
                                    .fontWeight(.semibold)
                                Text(username)
                            }
                        }
                        
                        Spacer()
                    }
                    .padding(.horizontal, 20)
                    .padding(.vertical, 10)
                } else {
                    // Existing incorrect solution layout with testcase available
                    VStack(alignment: .leading, spacing: 12) {
                        Text("Incorrect solution")
                            .font(.largeTitle)
                            .fontWeight(.bold)
                            .foregroundColor(.red)
                            .padding(.vertical, 8)
                        
                        // Last Testcase
                        HStack {
                            Text("Testcase:")
                                .fontWeight(.semibold)
                            Text(lastTestcaseText)
                        }
                        
                        // Code Output
                        VStack(alignment: .leading, spacing: 4) {
                            Text("Code Output:")
                                .fontWeight(.semibold)
                            Text(codeOutputText)
                                .font(.system(.body, design: .monospaced))
                                .padding(8)
                                .background(Color.gray.opacity(0.1))
                                .cornerRadius(8)
                        }
                        
                        // Expected Output
                        VStack(alignment: .leading, spacing: 4) {
                            Text("Expected Output:")
                                .fontWeight(.semibold)
                            Text(expectedOutputText)
                                .font(.system(.body, design: .monospaced))
                                .padding(8)
                                .background(Color.gray.opacity(0.1))
                                .cornerRadius(8)
                        }
                        
                        // Test Cases Info
                        HStack {
                            Text("Test Cases:")
                                .fontWeight(.semibold)
                            Text("\(totalCorrectText) / \(totalTestcasesText)")
                        }
                        
                        // Runtime Error
                        VStack(alignment: .leading, spacing: 4) {
                            Text("Runtime Error:")
                                .fontWeight(.semibold)
                            Text(runtimeErrorText)
                                .padding(8)
                                .background(Color.red.opacity(0.1))
                                .cornerRadius(8)
                        }
                        
                        // Compile Error
                        VStack(alignment: .leading, spacing: 4) {
                            Text("Compile Error:")
                                .fontWeight(.semibold)
                            Text(compileErrorText)
                                .padding(8)
                                .background(Color.red.opacity(0.1))
                                .cornerRadius(8)
                        }
                        
                        // Code snippet with horizontal scrolling
                        Text("Code")
                            .font(.headline)
                            .padding(.bottom, 4)
                        ScrollView(.horizontal, showsIndicators: true) {
                            CodeBlockView(code: extractedCode, language: languageName)
                                .frame(minHeight: 150)
                        }
                        .background(Color(UIColor.systemGray6))
                        .cornerRadius(8)
                        
                        // User Info
                        HStack(alignment: .center, spacing: 12) {
                            if let avatarURL = URL(string: userAvatar), !userAvatar.isEmpty {
                                AsyncImage(url: avatarURL) { image in
                                    image
                                        .resizable()
                                        .aspectRatio(contentMode: .fill)
                                } placeholder: {
                                    ProgressView()
                                }
                                .frame(width: 50, height: 50)
                                .clipShape(Circle())
                            }
                            VStack(alignment: .leading, spacing: 2) {
                                Text("Submitting as:")
                                    .fontWeight(.semibold)
                                Text(username)
                            }
                        }
                        
                        Spacer()
                    }
                    .padding(.horizontal, 20)
                    .padding(.vertical, 10)
                }
            } else {
                // Correct solution layout
                VStack(alignment: .leading, spacing: 12) {
                    Text("Solution accepted!")
                        .font(.largeTitle)
                        .fontWeight(.bold)
                        .foregroundColor(.green)
                        .padding(.vertical, 8)
                    
                    // Runtime Details
                    HStack {
                        Text("Runtime:")
                            .fontWeight(.semibold)
                        Text(runtimeDisplay)
                        Spacer()
                        Text("Percentile: \(runtimePercentileString)%")
                    }
                    
                    // Memory Details
                    HStack {
                        Text("Memory:")
                            .fontWeight(.semibold)
                        Text(memoryDisplay)
                        Spacer()
                        Text("Percentile: \(memoryPercentileString)%")
                    }
                    
                    // Test Cases Info
                    HStack {
                        Text("Test Cases:")
                            .fontWeight(.semibold)
                        Text("\(totalCorrectText) / \(totalTestcasesText)")
                    }
                    
                    // Code snippet with horizontal scrolling
                    Text("Code")
                        .font(.headline)
                        .padding(.bottom, 4)
                    ScrollView(.horizontal, showsIndicators: true) {
                        CodeBlockView(code: extractedCode, language: languageName)
                            .frame(minHeight: 150)
                    }
                    .background(Color(UIColor.systemGray6))
                    .cornerRadius(8)
                    
                    // User Info
                    HStack(alignment: .center, spacing: 12) {
                        if let avatarURL = URL(string: userAvatar), !userAvatar.isEmpty {
                            AsyncImage(url: avatarURL) { image in
                                image
                                    .resizable()
                                    .aspectRatio(contentMode: .fill)
                            } placeholder: {
                                ProgressView()
                            }
                            .frame(width: 50, height: 50)
                            .clipShape(Circle())
                        }
                        VStack(alignment: .leading, spacing: 2) {
                            Text("Submitted as:")
                                .fontWeight(.semibold)
                            Text(username)
                        }
                    }
                    
                    Spacer()
                }
                .padding(.horizontal, 20)
                .padding(.vertical, 10)
            }
        }
        .navigationTitle("LeetCode execution")
        .navigationBarTitleDisplayMode(.inline)
    }
    
    // MARK: - Computed Properties for Extracted Data
    private var submissionDetails: ExecuteResponse.SubmissionDetails {
        executeResponse.data.submissionDetails
    }
    
    private var extractedCode: String {
        submissionDetails.code
    }
    
    private var languageName: String {
        submissionDetails.lang.name
    }
    
    private var memoryDisplay: String {
        submissionDetails.memoryDisplay
    }
    
    private var memoryPercentileString: String {
        if let mp = submissionDetails.memoryPercentile {
            return String(format: "%.2f", mp)
        }
        return "N/A"
    }
    
    private var runtimeDisplay: String {
        submissionDetails.runtimeDisplay
    }
    
    private var runtimePercentileString: String {
        if let rp = submissionDetails.runtimePercentile {
            return String(format: "%.2f", rp)
        }
        return "N/A"
    }
    
    private var totalCorrectText: String {
        if let tc = submissionDetails.totalCorrect {
            return String(tc)
        }
        return "N/A"
    }
    
    private var totalTestcasesText: String {
        if let tt = submissionDetails.totalTestcases {
            return String(tt)
        }
        return "N/A"
    }
    
    private var userAvatar: String {
        submissionDetails.user.profile.userAvatar ?? ""
    }
    
    private var username: String {
        submissionDetails.user.username
    }
    
    private var lastTestcaseText: String {
        submissionDetails.lastTestcase ?? "N/A"
    }
    
    private var codeOutputText: String {
        submissionDetails.codeOutput ?? "N/A"
    }
    
    private var expectedOutputText: String {
        submissionDetails.expectedOutput ?? "N/A"
    }
    
    private var runtimeErrorText: String {
        submissionDetails.runtimeError ?? "None"
    }
    
    private var compileErrorText: String {
        submissionDetails.compileError ?? "None"
    }
}
