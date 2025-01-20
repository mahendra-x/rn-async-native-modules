package com.sdkdata

import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class MyNativeModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "MyNativeModule"
    }

    @ReactMethod
    fun getData(promise: Promise) {
        try {
            // Example data as a Map
            val data = mapOf(
                "id" to 1234,
                "name" to "React Native with Kotlin"
            )

            // Convert the Map to a WritableMap
            val writableMap = Arguments.createMap()
            for ((key, value) in data) {
                when (value) {
                    is Int -> writableMap.putInt(key, value)
                    is String -> writableMap.putString(key, value)
                    else -> {
                        promise.reject("INVALID_TYPE", "Unsupported data type for key: $key")
                        return
                    }
                }
            }

            // Resolve the promise with the WritableMap
            promise.resolve(writableMap)
        } catch (e: Exception) {
            // Reject the promise with the error message
            promise.reject("ERROR_CODE", e.message)
        }
    }
}
