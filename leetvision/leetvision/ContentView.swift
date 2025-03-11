/*
See the License.txt file for this sample's licensing information.
*/

import SwiftUI

struct ContentView: View {
    @State private var showingCameraView = false
    
    var body: some View {
        TabView {
            // Camera tab - just shows a button to present camera
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
            .fullScreenCover(isPresented: $showingCameraView) {
                CameraView()
            }
            
            // Home tab
            HomeView()
                .tabItem {
                    Label("Home", systemImage: "house")
                }
            
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
