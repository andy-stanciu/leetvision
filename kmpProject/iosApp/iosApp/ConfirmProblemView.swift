import SwiftUI

struct ConfirmProblemView: View {
    var body: some View {
        VStack {
//            Text("Confirm Problem")
//                .font(.largeTitle)
//                .padding()

            Spacer()

            NavigationLink(destination: MainAppView(problem: "Same Tree")) {
                Text("Same Tree")
                    .padding()
                    .background(Color.blue)
                    .foregroundColor(.white)
                    .cornerRadius(10)
            }
            .padding()

            NavigationLink(destination: MainAppView(problem: "Symmetric Tree")) {
                Text("Symmetric Tree")
                    .padding()
                    .background(Color.blue)
                    .foregroundColor(.white)
                    .cornerRadius(10)
            }
            .padding()

            Spacer()
        }
        .navigationBarTitle("Confirm Problem", displayMode: .inline)
    }
}