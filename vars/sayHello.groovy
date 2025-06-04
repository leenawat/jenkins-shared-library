#!/usr/bin/env groovy

def call(String name = "World") {
    echo "👋 Hello, ${name}!"
    
    // Return value example
    return "Greeting sent to ${name}"
}

// Overloaded method with Map parameter
def call(Map config) {
    def name = config.name ?: "World"
    def emoji = config.emoji ?: "👋"
    def color = config.color ?: "blue"
    
    echo "${emoji} Hello, ${name}!"
    
    // Conditional logic
    if (config.showTime) {
        echo "⏰ Current time: ${new Date()}"
    }
    
    if (config.showBuildInfo) {
        echo "🏗️ Build: ${env.BUILD_NUMBER}"
        echo "📂 Job: ${env.JOB_NAME}"
    }
    
    return [
        message: "Hello ${name}",
        timestamp: new Date().toString(),
        buildNumber: env.BUILD_NUMBER
    ]
}