import SwiftUI
import Charts

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
                            CodeBlockView(code: extractedCode, language: languageName, typewriterEffect: false)
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
                            CodeBlockView(code: extractedCode, language: languageName, typewriterEffect: false)
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
                        .padding(.vertical, 4)
                    
                    VStack(alignment: .leading, spacing: 12) {
                        // Test Cases Info
                        HStack {
                            Text("Test Cases:")
                                .fontWeight(.semibold)
                            Text("\(totalCorrectText) / \(totalTestcasesText)")
                        }
                    }
                    .padding(12)
                    .background(Color(UIColor.blackAccent))
                    .cornerRadius(8)
                    .shadow(color: Color.black.opacity(0.1), radius: 5)
                    
                    VStack(alignment: .leading, spacing: 12) {
                        // Runtime Details
                        HStack {
                            Text("Runtime:")
                                .fontWeight(.semibold)
                            Text(runtimeDisplay)
                            Spacer()
                            Text("Percentile:")
                                .fontWeight(.semibold)
                            Text("\(runtimePercentileString)%")
                        }
                        
                        // Runtime Distribution Chart with Avatar Overlay
                        if let runtimeDistribution = runtimeDistributionData {
                            let maxX = runtimeDistribution.distribution
                                    .compactMap { Double($0.x) }
                                    .max() ?? 100.0
                            let maxXScaled = maxX + 10
                            
                            VStack(alignment: .leading, spacing: 8) {
                                Chart {
                                    // Draw each bar from the distribution.
                                    ForEach(runtimeDistribution.distribution) { entry in
                                        if let xValue = Double(entry.x) {
                                            BarMark(
                                                x: .value("Runtime (ms)", xValue),
                                                y: .value("%", entry.percent)
                                            )
                                        }
                                    }
                                    // Overlay the user's avatar icon.
                                    let userRuntime = Double(runtime)
                                        if let closestEntry = runtimeDistribution.distribution.min(by: { first, second in
                                           let firstValue = Double(first.x) ?? 0
                                           let secondValue = Double(second.x) ?? 0
                                           return abs(firstValue - userRuntime) < abs(secondValue - userRuntime)
                                       }) {
                                        let userY = closestEntry.percent
                                        PointMark(
                                            x: .value("Runtime (ms)", userRuntime),
                                            y: .value("%", userY)
                                        )
                                        .annotation(position: .top) {
                                            AsyncImage(url: URL(string: userAvatar)) { image in
                                                image.resizable()
                                                     .frame(width: 20, height: 20)
                                                     .clipShape(Circle())
                                            } placeholder: {
                                                Circle().fill(Color.gray).frame(width: 20, height: 20)
                                            }
                                        }
                                    }
                                }
                                .chartXAxisLabel("Runtime (ms)")
                                .chartYAxisLabel("%")
                                .chartXScale(domain: 0...maxXScaled)
                                .frame(height: 200)
                            }
                            .padding(.horizontal, 20)
                        }
                    }
                    .padding(12)
                    .background(Color(UIColor.blackAccent))
                    .cornerRadius(8)
                    .shadow(color: Color.black.opacity(0.1), radius: 5)
                    
                    VStack(alignment: .leading, spacing: 12) {
                        // Memory Details
                        HStack {
                            Text("Memory:")
                                .fontWeight(.semibold)
                            Text(memoryDisplay)
                            Spacer()
                            Text("Percentile:")
                                .fontWeight(.semibold)
                            Text("\(memoryPercentileString)%")
                        }
                        
                        // Memory Distribution Chart with Avatar Overlay
                        if let memoryDistribution = memoryDistributionData {
                            let maxX = memoryDistribution.distribution
                                    .compactMap { Double($0.x) }
                                    .max() ?? 1000.0
                            let maxXScaled = (maxX / 1000.0) + 10.0
                            
                            VStack(alignment: .leading, spacing: 8) {
                                Chart {
                                    // Draw each bar from the distribution.
                                    ForEach(memoryDistribution.distribution) { entry in
                                        if let xValue = Double(entry.x) {
                                            // Convert x by dividing by 1000.
                                            let convertedX = xValue / 1000.0
                                            BarMark(
                                                x: .value("Memory (MB)", convertedX),
                                                y: .value("%", entry.percent)
                                            )
                                        }
                                    }
                                    // Overlay the user's avatar icon.
                                    let userMemory = Double(memory)
                                       if let closestEntry = memoryDistribution.distribution.min(by: { first, second in
                                           let firstValue = Double(first.x) ?? 0
                                           let secondValue = Double(second.x) ?? 0
                                           return abs(firstValue - userMemory) < abs(secondValue - userMemory)
                                       }) {
                                        let userY = closestEntry.percent
                                           let convertedUserMemory = userMemory / 1000.0 / 1000.0
                                        PointMark(
                                            x: .value("Memory (MB)", convertedUserMemory),
                                            y: .value("%", userY)
                                        )
                                        .annotation(position: .top) {
                                            AsyncImage(url: URL(string: userAvatar)) { image in
                                                image.resizable()
                                                     .frame(width: 20, height: 20)
                                                     .clipShape(Circle())
                                            } placeholder: {
                                                Circle().fill(Color.gray).frame(width: 20, height: 20)
                                            }
                                        }
                                    }
                                }
                                .chartXAxisLabel("Memory (MB)")
                                .chartYAxisLabel("%")
                                .chartXScale(domain: 0...maxXScaled)
                                .frame(height: 200)
                            }
                            .padding(.horizontal, 20)
                        }
                    }
                    .padding(12)
                    .background(Color(UIColor.blackAccent))
                    .cornerRadius(8)
                    .shadow(color: Color.black.opacity(0.1), radius: 5)
                    
                    VStack(alignment: .leading, spacing: 12) {
                        // Code snippet with horizontal scrolling
                        Text("Submission")
                            .font(.headline)
                            .padding(.bottom, 4)
                        ScrollView(.horizontal, showsIndicators: true) {
                            CodeBlockView(code: extractedCode, language: languageName, typewriterEffect: false)
                        }
                        .background(Color(UIColor.systemGray6))
                        .cornerRadius(8)
                    }
                    .padding(12)
                    .background(Color(UIColor.blackAccent))
                    .cornerRadius(8)
                    .shadow(color: Color.black.opacity(0.1), radius: 5)
                    
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
    
    private var memory: Int {
        submissionDetails.memory
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
    
    private var runtime: Int {
        submissionDetails.runtime
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
    
    private var runtimeDistributionData: Distribution? {
        guard let json = submissionDetails.runtimeDistribution,
              let data = json.data(using: .utf8) else { return nil }
        return try? JSONDecoder().decode(Distribution.self, from: data)
    }
    
    private var memoryDistributionData: Distribution? {
        guard let json = submissionDetails.memoryDistribution,
              let data = json.data(using: .utf8) else { return nil }
        return try? JSONDecoder().decode(Distribution.self, from: data)
    }
}

struct Distribution: Codable {
    let lang: String
    let distribution: [DistributionEntry]
}

struct DistributionEntry: Codable, Identifiable {
    var id: String { x }
    let x: String
    let percent: Double

    init(from decoder: Decoder) throws {
        var container = try decoder.unkeyedContainer()
        self.x = try container.decode(String.self)
        self.percent = try container.decode(Double.self)
    }
}
