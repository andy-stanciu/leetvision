import SwiftUI

struct ExecuteView: View {
    var testCaseNumber: Int = 1
    var inputP: [Int] = [1, 2, 3]
    var inputQ: [Int] = [1, 2, 3]
    var output: Bool = true
    var expected: Bool = true

    var body: some View {
        VStack(alignment: .leading, spacing: 10) {

            // Header Section
            HStack {
                Image(systemName: "checkmark.circle.fill")
                    .foregroundColor(.green)
                Text("Testcase   >   Test Result")
                    .font(.headline)
                Spacer()
            }

            // Status
            Text("Accepted")
                .font(.title)
                .foregroundColor(.green)
                .bold()

            Text("Runtime: 0 ms")
                .font(.subheadline)
                .foregroundColor(.gray)

            // Test Cases Navigation
            HStack {
                Text("• Case \(testCaseNumber)")
                    .font(.headline)
                    .bold()
                    .foregroundColor(.green)
                Spacer()
                Text("• Case 2   • Case 3")
                    .foregroundColor(.gray)
            }

            Divider()

            // Input Section
            VStack(alignment: .leading, spacing: 5) {
                Text("**Input**")
                    .font(.subheadline)
                    .bold()

                Text("p =")
                    .foregroundColor(.gray)
                Text("\(inputP)")
                    .padding()
                    .frame(maxWidth: .infinity, alignment: .leading)
                    .background(Color(UIColor.systemGray6))
                    .cornerRadius(8)

                Text("q =")
                    .foregroundColor(.gray)
                Text("\(inputQ)")
                    .padding()
                    .frame(maxWidth: .infinity, alignment: .leading)
                    .background(Color(UIColor.systemGray6))
                    .cornerRadius(8)
            }

            // Output Section
            VStack(alignment: .leading, spacing: 5) {
                Text("**Output**")
                    .font(.subheadline)
                    .bold()
                Text("\(output.description)")
                    .padding()
                    .frame(maxWidth: .infinity, alignment: .leading)
                    .background(Color(UIColor.systemGray6))
                    .cornerRadius(8)
            }

            // Expected Section
            VStack(alignment: .leading, spacing: 5) {
                Text("**Expected**")
                    .font(.subheadline)
                    .bold()
                Text("\(expected.description)")
                    .padding()
                    .frame(maxWidth: .infinity, alignment: .leading)
                    .background(Color(UIColor.systemGray6))
                    .cornerRadius(8)
            }

            Spacer()
        }
        .padding()
        .navigationBarTitle("Execute", displayMode: .inline)
    }
}

struct ExecuteView_Previews: PreviewProvider {
    static var previews: some View {
        ExecuteView()
    }
}
