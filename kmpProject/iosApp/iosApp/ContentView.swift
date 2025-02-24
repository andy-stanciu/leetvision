import SwiftUI

struct ContentView: View {
    var body: some View {
        ZStack {
            TabView {
                Text("Home")
                    .tabItem {
                        Image(systemName: "house")
                        Text("Home")
                    }

                CameraView()
                    .tabItem {
                        Image(systemName: "camera")
                        Text("Camera")
                    }

                Text("Profile")
                    .tabItem {
                        Image(systemName: "person")
                        Text("Profile")
                    }
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}