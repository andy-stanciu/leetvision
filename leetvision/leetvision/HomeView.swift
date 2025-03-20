import SwiftUI
import PhotosUI

struct HomeView: View {
    // MARK: - UI State
    @State private var selectedItem: PhotosPickerItem?
    @State private var selectedImageData: Data?
    @State private var isLoading = false
    @State private var errorMessage: String?
    
    // MARK: - Server Responses
    @State private var classifyResponse: ClassifyResponse?
    @State private var executeResponse: ExecuteResponse?
    
    // MARK: - Navigation Trigger
    @State private var shouldNavigate = false
    
    var body: some View {
        NavigationView {
            ScrollView {
                VStack(alignment: .leading, spacing: 20) {
                    // Image selection area with updated styling
                    VStack {
                        if let imageData = selectedImageData,
                           let uiImage = UIImage(data: imageData) {
                            Image(uiImage: uiImage)
                                .resizable()
                                .scaledToFit()
                                .frame(maxHeight: 300)
                                .cornerRadius(12)
                        } else {
                            RoundedRectangle(cornerRadius: 12)
                                .fill(Color(.systemGray5))
                                .frame(height: 220)
                                .overlay(
                                    Text("Select an image containing code")
                                        .font(.headline)
                                        .foregroundColor(.gray)
                                )
                        }
                        
                        PhotosPicker(
                            selection: $selectedItem,
                            matching: .images
                        ) {
                            Text("Select image")
                                .font(.headline)
                                .padding()
                                .frame(maxWidth: .infinity)
                                .background(Color.blue.opacity(0.7))
                                .foregroundColor(.white)
                                .cornerRadius(12)
                        }
                        .padding(.top, 10)
                        
                        if selectedImageData != nil {
                            Button("Execute code") {
                                Task {
                                    await analyzeImage()
                                }
                            }
                            .font(.headline)
                            .padding()
                            .frame(maxWidth: .infinity)
                            .background(Color.green.opacity(0.7))
                            .foregroundColor(.white)
                            .cornerRadius(12)
                            .padding(.top, 5)
                        }
                    }
                    .padding()
                    .background(Color.white)
                    .cornerRadius(12)
                    .shadow(color: Color.black.opacity(0.1), radius: 4, x: 0, y: 2)
                    
                    // Loading indicator
                    if isLoading {
                        HStack {
                            Spacer()
                            ProgressView("Processing...")
                            Spacer()
                        }
                    }
                    
                    // Error message
                    if let errorMessage = errorMessage {
                        Text(errorMessage)
                            .font(.body)
                            .foregroundColor(.red)
                            .padding()
                            .background(Color.red.opacity(0.1))
                            .cornerRadius(12)
                    }
                    
                    // Header image at the top
                    Image("leetvision")
                        .resizable()
                        .scaledToFill()
                        .clipped()
                        .cornerRadius(12)
                        .padding(.bottom, 20)
                    
                    // Hidden NavigationLink to navigate to the results page
                    NavigationLink(
                        destination: destinationView,
                        isActive: $shouldNavigate,
                        label: { EmptyView() }
                    )
                    
                    Spacer()
                }
                .padding()
            }
            .onChange(of: selectedItem) { newItem in
                loadImageData(from: newItem)
            }
            // Background color set to rgba(194,209,215,255)
            .background(Color(red: 194/255, green: 209/255, blue: 215/255, opacity: 1.0))
            .ignoresSafeArea(.all, edges: .bottom)
            .navigationBarHidden(false)
        }
    }
    
    // MARK: - Computed Destination View
    private var destinationView: some View {
        Group {
            if let classifyResponse = classifyResponse {
                ResultsView(classifyResponse: classifyResponse)
            } else {
                EmptyView()
            }
        }
    }
    
    // MARK: - Helper Methods
    private func loadImageData(from item: PhotosPickerItem?) {
        guard let item = item else { return }
        item.loadTransferable(type: Data.self) { result in
            switch result {
            case .success(let data):
                DispatchQueue.main.async {
                    self.selectedImageData = data
                    // Reset previous responses
                    self.classifyResponse = nil
                    self.executeResponse = nil
                    self.errorMessage = nil
                }
            case .failure(let error):
                DispatchQueue.main.async {
                    self.errorMessage = "Failed to load image: \(error.localizedDescription)"
                }
            }
        }
    }
    
    private func analyzeImage() async {
        guard let imageData = selectedImageData else {
            errorMessage = "Please select an image first"
            return
        }
        
        do {
            DispatchQueue.main.async {
                self.isLoading = true
                self.errorMessage = nil
            }
            
            let response = try await NetworkService.classify(imageData: imageData)
            
            DispatchQueue.main.async {
                self.classifyResponse = response
                self.isLoading = false
                self.shouldNavigate = true
            }
        } catch {
            DispatchQueue.main.async {
                self.isLoading = false
                self.errorMessage = "Error: \(error.localizedDescription)"
            }
        }
    }
}

struct HomeView_Previews: PreviewProvider {
    static var previews: some View {
        HomeView()
    }
}
