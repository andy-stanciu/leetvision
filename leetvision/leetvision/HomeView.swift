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
                    // Title
                    Text("Code Analyzer")
                        .font(.largeTitle)
                        .fontWeight(.bold)
                        .padding(.bottom, 10)
                    
                    // Image selection area
                    VStack {
                        if let imageData = selectedImageData,
                           let uiImage = UIImage(data: imageData) {
                            Image(uiImage: uiImage)
                                .resizable()
                                .scaledToFit()
                                .frame(maxHeight: 300)
                                .cornerRadius(8)
                        } else {
                            RoundedRectangle(cornerRadius: 12)
                                .fill(Color.gray.opacity(0.2))
                                .frame(height: 200)
                                .overlay(
                                    Text("Select an image containing code")
                                        .foregroundColor(.gray)
                                )
                        }
                        
                        PhotosPicker(
                            selection: $selectedItem,
                            matching: .images
                        ) {
                            Text("Select Image")
                                .padding()
                                .background(Color.blue)
                                .foregroundColor(.white)
                                .cornerRadius(8)
                        }
                        .padding(.top, 10)
                        
                        if selectedImageData != nil {
                            Button("Analyze Code") {
                                Task {
                                    await analyzeImage()
                                }
                            }
                            .padding()
                            .background(Color.green)
                            .foregroundColor(.white)
                            .cornerRadius(8)
                            .padding(.top, 5)
                        }
                    }
                    .padding()
                    .background(Color.white)
                    .cornerRadius(12)
                    .shadow(radius: 2)
                    
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
                            .foregroundColor(.red)
                            .padding()
                            .background(Color.red.opacity(0.1))
                            .cornerRadius(8)
                    }
                    
                    // Hidden NavigationLink to navigate to the results page
                    NavigationLink(
                        destination: destinationView,
                        isActive: $shouldNavigate,
                        label: { EmptyView() }
                    )
                }
                .padding()
            }
            .onChange(of: selectedItem) { newItem in
                loadImageData(from: newItem)
            }
            .navigationTitle("Home")
        }
    }
    
    // MARK: - Computed Destination View
    private var destinationView: some View {
        Group {
            if let classifyResponse = classifyResponse {
                ResultsView(
                    classifyResponse: classifyResponse,
                    executeResponse: executeResponse
                )
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
                // Trigger navigation to the results page
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
