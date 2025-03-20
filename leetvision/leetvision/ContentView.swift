import SwiftUI

struct ContentView: View {
    @State private var selectedTab = 0
    @State private var showingCameraView = false
    
    var body: some View {
        TabView(selection: $selectedTab) {
            // Home tab - first, default selected.
            HomeView()
                .tabItem {
                    Label("Home", systemImage: "house")
                }
                .tag(0)
            
            // Camera tab - second.
            VStack {
                Button {
                    showingCameraView = true
                } label: {
                    VStack {
                        Image(systemName: "camera.fill")
                            .font(.system(size: 50))
                        Text("Open Camera")
                    }
                    .foregroundColor(.blue)
                    .padding()
                }
            }
            .tabItem {
                Label("Camera", systemImage: "camera")
            }
            .tag(1)
            .fullScreenCover(isPresented: $showingCameraView) {
                CameraView()
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
