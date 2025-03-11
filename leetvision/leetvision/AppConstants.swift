/*
 AppConstants.swift
 
 Global constants for the application.
*/

import Foundation

/// App-wide constants
enum AppConstants {
    /// Network configuration
    enum Network {
        // set as my Mac's IP for now
        static let host = "10.19.114.186"
        static let port = 20501
    }
    
    /// OCR configuration
    enum OCR {
        static let extractionPrompt = "Extract the text as code from this image, preserving the indentation. Ensure that the code parses. Output only the code block and nothing else."
    }
    
    enum LeetCode {
        static let leetcode_session = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfYXV0aF91c2VyX2lkIjoiMTE1MTc2NTYiLCJfYXV0aF91c2VyX2JhY2tlbmQiOiJkamFuZ28uY29udHJpYi5hdXRoLmJhY2tlbmRzLk1vZGVsQmFja2VuZCIsIl9hdXRoX3VzZXJfaGFzaCI6IjBiYTJmMTJiM2EyY2ViZDVmYzg3ZTVjYmQ3MmE2NjhkNDIzMWRjODVlYWU0OTNlNjg0M2Q3ZjZhMTBhMmUwOTciLCJzZXNzaW9uX3V1aWQiOiI0YTkwMjJkZSIsImlkIjoxMTUxNzY1NiwiZW1haWwiOiJhbmRyZWlzdEBvdXRsb29rLmNvbSIsInVzZXJuYW1lIjoiYW5keXN0YW5jaXUiLCJ1c2VyX3NsdWciOiJhbmR5c3RhbmNpdSIsImF2YXRhciI6Imh0dHBzOi8vYXNzZXRzLmxlZXRjb2RlLmNvbS91c2Vycy9kZWZhdWx0X2F2YXRhci5qcGciLCJyZWZyZXNoZWRfYXQiOjE3NDE1NzM4NzUsImlwIjoiMjA1LjE3NS4xMDYuMTMyIiwiaWRlbnRpdHkiOiJiODAxZDQ5NGYxMjI3OTNiMDYxMjYzNmJmYTIzNGI5YyIsImRldmljZV93aXRoX2lwIjpbIjlmMmY0OTZlNzViMTllYTFjOGYyNTZiMDI4MjQ5MTk5IiwiMjA1LjE3NS4xMDYuMTMyIl0sIl9zZXNzaW9uX2V4cGlyeSI6MTIwOTYwMH0.pS_V-aTyh2Jt4uyBsvCRYGtc5g0cNYpblBmInoRZ8Lw"
        static let cf_clearance = "LiZBSCfuR_M1.GxaAjYKNKmyDwhmS2WBEw9I.O.SHYM-1741573869-1.2.1.1-UJleu0TjdfkcrhdGRKEn650SQffBbs607gGe2zLWv34La8jtUoF9s4QRFh5CVfTetqsO1sIy3e_5ibXR.YJd9qg_ffDsxuUmeAGurgmHj.W5Frt5SGOCinE9Plevtd1CtBg0SFTW09GvQRjH_YHcHM3J1JTxMiuckLFQOgoC81zXI640Pl5jPa4QmetMbVF9U8GKYomeTzhf36ZAdsyVK8rUGHPLX2ZBcsvG4qx_ta6mctZkk0Zb8qj.FcZ53mqvlR50pU8xqCwQY7WdwDBIFfAIUKkAA0mNtSWkq9qkGEMshks0iivWwj6UDxXhzMg0nfPhS8iqtFmWxdW19EawwVvHtZ4HE0Fumt0AIMzCdfgq7q_ed98DEgjDsL6cDh4Zz1YefUMVN1wiMX1AcRBqD.9YQnxVZ5WJCff5_1bFD.IbbkUqfJXl6iePZ39FRCZ_CPNNYw8G27.khtyRPyQA9w"
        static let csrftoken = ("bqvVZIdZMZlgqBpbf3sWKgOejmznDhdmCoB6ibGoVitNacWfCIj1FGmzuCRVS40o")
    }
}

// Usage examples:
// let host = AppConstants.Network.host
// let prompt = AppConstants.OCR.extractionPrompt
