import SwiftUI

struct LearnView: View {
    var body: some View {
        VStack {
            Text("Learn View")
                .font(.largeTitle)
                .padding()
            Spacer()
        }
        .navigationBarTitle("Learn", displayMode: .inline)
    }
}
