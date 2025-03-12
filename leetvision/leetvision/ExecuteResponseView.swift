import SwiftUI

struct ExecuteResponseView: View {
    let executeResponse: ExecuteResponse

    var body: some View {
        ScrollView {
            if runtimeDisplay == "N/A" {
                // Incorrect solution layout
                VStack(alignment: .leading, spacing: 16) {
                    Text("Incorrect Solution")
                        .font(.largeTitle)
                        .fontWeight(.bold)
                    
                    // Language Name
                    HStack {
                        Text("Language:")
                            .fontWeight(.semibold)
                        Text(languageName)
                    }
                    
                    // Last Testcase
                    HStack {
                        Text("Last Testcase:")
                            .fontWeight(.semibold)
                        Text(lastTestcaseText)
                    }
                    
                    // Code Output
                    VStack(alignment: .leading) {
                        Text("Code Output:")
                            .fontWeight(.semibold)
                        Text(codeOutputText)
                            .font(.system(.body, design: .monospaced))
                            .padding()
                            .background(Color.gray.opacity(0.1))
                            .cornerRadius(8)
                    }
                    
                    // Expected Output
                    VStack(alignment: .leading) {
                        Text("Expected Output:")
                            .fontWeight(.semibold)
                        Text(expectedOutputText)
                            .font(.system(.body, design: .monospaced))
                            .padding()
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
                    VStack(alignment: .leading) {
                        Text("Runtime Error:")
                            .fontWeight(.semibold)
                        Text(runtimeErrorText)
                            .padding()
                            .background(Color.red.opacity(0.1))
                            .cornerRadius(8)
                    }
                    
                    // Compile Error
                    VStack(alignment: .leading) {
                        Text("Compile Error:")
                            .fontWeight(.semibold)
                        Text(compileErrorText)
                            .padding()
                            .background(Color.red.opacity(0.1))
                            .cornerRadius(8)
                    }
                    
                    // User Info
                    HStack(alignment: .center, spacing: 12) {
                        if let avatarURL = URL(string: userAvatar) {
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
                        VStack(alignment: .leading) {
                            Text("Username:")
                                .fontWeight(.semibold)
                            Text(username)
                        }
                    }
                    
                    Spacer()
                }
                .padding()
            } else {
                // Correct solution layout
                VStack(alignment: .leading, spacing: 16) {
                    // Code snippet
                    Text("Code")
                        .font(.headline)
                    Text(extractedCode)
                        .font(.system(.body, design: .monospaced))
                        .padding()
                        .background(Color.gray.opacity(0.1))
                        .cornerRadius(8)
                    
                    // Language Name
                    HStack {
                        Text("Language:")
                            .fontWeight(.semibold)
                        Text(languageName)
                    }
                    
                    // Memory Details
                    HStack {
                        Text("Memory:")
                            .fontWeight(.semibold)
                        Text(memoryDisplay)
                        Spacer()
                        Text("Percentile: \(memoryPercentileString)%")
                    }
                    
                    // Runtime Details
                    HStack {
                        Text("Runtime:")
                            .fontWeight(.semibold)
                        Text(runtimeDisplay)
                        Spacer()
                        Text("Percentile: \(runtimePercentileString)%")
                    }
                    
                    // Test Cases Info
                    HStack {
                        Text("Test Cases:")
                            .fontWeight(.semibold)
                        Text("\(totalCorrectText) / \(totalTestcasesText)")
                    }
                    
                    // User Info (Avatar & Username)
                    HStack(alignment: .center, spacing: 12) {
                        if let avatarURL = URL(string: userAvatar) {
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
                        VStack(alignment: .leading) {
                            Text("Username:")
                                .fontWeight(.semibold)
                            Text(username)
                        }
                    }
                    
                    Spacer()
                }
                .padding()
            }
        }
        .navigationTitle("Execute Response")
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
        submissionDetails.user.profile.userAvatar
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
