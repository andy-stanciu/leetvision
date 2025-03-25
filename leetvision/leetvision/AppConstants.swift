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
    
    /// LeetCode cookies configuration.
    enum LeetCode {
        // These values will be updated once the user logs in.
        static var leetcode_session: String = ""
        static var cf_clearance: String = ""
        static var csrftoken: String = ""
        
        /// Update the stored LeetCode cookies.
        static func update(with cookies: OAuthCookies) {
            leetcode_session = cookies.leetcodeSession.value
            cf_clearance = cookies.cf_clearance.value
            csrftoken = cookies.csrftoken.value
        }
    }
}
