package com.company.pipeline

class HelloService implements Serializable {
    
    def script
    
    HelloService(script) {
        this.script = script
    }
    
    def sayHello(String name) {
        script.echo "🎉 Hello from HelloService class, ${name}!"
        return "Greeting from class: ${name}"
    }
    
    def generateGreeting(Map config) {
        def name = config.name ?: "World"
        def language = config.language ?: "en"
        
        def greetings = [
            en: "Hello",
            th: "สวัสดี",
            ja: "こんにちは",
            es: "Hola",
            fr: "Bonjour"
        ]
        
        def greeting = greetings[language] ?: greetings.en
        def message = "${greeting}, ${name}!"
        
        script.echo "🌐 ${message}"
        return message
    }
    
    def getSystemInfo() {
        def info = [:]
        info.javaVersion = System.getProperty("java.version")
        info.osName = System.getProperty("os.name")
        info.osVersion = System.getProperty("os.version")
        info.userHome = System.getProperty("user.home")
        
        script.echo "💻 System Information:"
        info.each { key, value ->
            script.echo "   ${key}: ${value}"
        }
        
        return info
    }
}