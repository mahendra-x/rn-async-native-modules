import Foundation
import React // Import the React Native module

@objc(MyNativeModule)
class MyNativeModule: NSObject {

    @objc
    func getData(_ resolve: @escaping RCTPromiseResolveBlock, reject: @escaping RCTPromiseRejectBlock) {
        // Example data
        let data: [String: Any] = [
            "id": 1235,
            "name": "React Native with Swift and Me"
        ]
        
        // Resolve the promise with the data
        resolve(data)
    }
    
    @objc
    static func requiresMainQueueSetup() -> Bool {
        return false
    }
}
