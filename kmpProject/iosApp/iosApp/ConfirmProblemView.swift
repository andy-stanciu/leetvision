import SwiftUI

struct ConfirmProblemView: View {
    var body: some View {
        VStack {
            Text("Confirm Problem")
                .font(.largeTitle)
                .padding()
            Spacer()
        }
        .navigationBarTitle("Confirm Problem", displayMode: .inline)
        .navigationBarBackButtonHidden(true)
        .navigationBarItems(leading: Button(action: {
            // Action to go back
            // In SwiftUI, the back button is handled automatically by NavigationView
        }) {
            Image(systemName: "arrow.left")
                .foregroundColor(.blue)
        })
    }
}