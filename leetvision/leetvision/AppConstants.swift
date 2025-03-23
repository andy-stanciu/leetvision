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
        static let host = "192.168.1.129"
        static let port = 20501
    }
    
    /// OCR configuration
    enum OCR {
        static let extractionPrompt = "Extract the text as code from this image, preserving the indentation. Ensure that the code parses. Output only the code block and nothing else."
    }
    
    enum LeetCode {
        static let leetcode_session = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfYXV0aF91c2VyX2lkIjoiMTE1MTc2NTYiLCJfYXV0aF91c2VyX2JhY2tlbmQiOiJkamFuZ28uY29udHJpYi5hdXRoLmJhY2tlbmRzLk1vZGVsQmFja2VuZCIsIl9hdXRoX3VzZXJfaGFzaCI6IjBiYTJmMTJiM2EyY2ViZDVmYzg3ZTVjYmQ3MmE2NjhkNDIzMWRjODVlYWU0OTNlNjg0M2Q3ZjZhMTBhMmUwOTciLCJzZXNzaW9uX3V1aWQiOiJmZTU0ZWFlMiIsImlkIjoxMTUxNzY1NiwiZW1haWwiOiJhbmRyZWlzdEBvdXRsb29rLmNvbSIsInVzZXJuYW1lIjoiYW5keXN0YW5jaXUiLCJ1c2VyX3NsdWciOiJhbmR5c3RhbmNpdSIsImF2YXRhciI6Imh0dHBzOi8vYXNzZXRzLmxlZXRjb2RlLmNvbS91c2Vycy9hbmR5c3RhbmNpdS9hdmF0YXJfMTc0MTgxNjMzMi5wbmciLCJyZWZyZXNoZWRfYXQiOjE3NDI2ODgwNjMsImlwIjoiOTcuMTEzLjIyMS4xNDgiLCJpZGVudGl0eSI6ImI5NzdlMTBkMWNiMjYxMDc5MDllOTdkNTFhNjg4MzIzIiwiZGV2aWNlX3dpdGhfaXAiOlsiM2NiNGYwMDUyNTI3ZmYzN2E3NDIzNGU3ZjRlNmUyZmUiLCI5Ny4xMTMuMjIxLjE0OCJdLCJfc2Vzc2lvbl9leHBpcnkiOjEyMDk2MDB9.xgJ4kLFt6Jl3Woyje8vQqrLLdy4om7gFFvtMnXG3vBA"
        static let cf_clearance = "q94t0CN.TC3VFRRwBY6LMquwopSi9T0nkk7n9V_Vnb0-1742529118-1.2.1.1-3ODJw3tZde0DNN3LdYKwHbApR4F9XmJ0gcMsTcDN4nXtSy1kbtnFYkya0ubNNN5LbCj2vEHxnX3rIwibxuW5bsFQ7eE7v_p4.FfGvD92pwMsE1nSp71W7a3XW72kxPfqmoYqiVvKoFV.NYIHEvPRC3LdW0wRNP9qybhsGW.lDuGsytiUc03smyArah75Yr5G14Q_VMi3vHHyKA229IwpqngHy7bQiRr1Hy4BkA59TP2jCQZtJEMyo6sN68CbMfiZkmXQI9YBahmGBWv6rh1H13fOTdyFFopL5bWugZg_1RepNrcEX2Xqs8FfiZoQw7je.Rvz360xCpnVi3OA0gkq1pithJj6iRwqYV7xrXGIMqCOF0WgHCEeZVRW9mPAasGq"
        static let csrftoken = "9QJe6kbcGhZquIop1Em09TxWMGgFgjg5egNbYhzQVAqKiXFHv1QxjiVsINfd3f21"
    }
}

// Usage examples:
// let host = AppConstants.Network.host
// let prompt = AppConstants.OCR.extractionPrompt
