import SwiftUI

struct MainAppView: View {
    var problem: String

    var body: some View {
        VStack {
            Text("Selected Problem: \(problem)")
                .padding()

            Spacer()

            // Grid layout for the four quadrants
            GeometryReader { geometry in
                let width = geometry.size.width / 2
                let height = geometry.size.height / 2

                VStack(spacing: 0) {
                    HStack(spacing: 0) {
                        NavigationLink(destination: ExecuteView()) {
                            QuadrantView(title: "Execute", color: .red)
                                .frame(width: width, height: height)
                        }
                        NavigationLink(destination: LearnView()) {
                            QuadrantView(title: "Learn", color: .green)
                                .frame(width: width, height: height)
                        }
                    }
                    HStack(spacing: 0) {
                        NavigationLink(destination: ExplainView()) {
                            QuadrantView(title: "Explain", color: .blue)
                                .frame(width: width, height: height)
                        }
                        NavigationLink(destination: FixView()) {
                            QuadrantView(title: "Fix", color: .yellow)
                                .frame(width: width, height: height)
                        }
                    }
                }
            }

            Spacer()
        }
        .navigationBarTitle("Main App", displayMode: .inline)
    }
}

struct QuadrantView: View {
    var title: String
    var color: Color

    var body: some View {
        ZStack {
            color
            Text(title)
                .font(.title)
                .foregroundColor(.white)
        }
    }
}