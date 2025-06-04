#!/usr/bin/env groovy

def call(Map config = [:]) {
    // Import the class
    def helloService = new com.company.pipeline.HelloService(this)
    
    echo "🚀 Advanced Hello World Function"
    echo "================================"
    
    // Basic greeting
    if (config.name) {
        sayHello(config.name)
    }

        // advance greeting
    if (config.name) {
        helloService.sayHello(config.name)
    }
    
    // Multi-language greeting
    if (config.language) {
        helloService.generateGreeting([
            name: config.name ?: "World",
            language: config.language
        ])
    }
    
    // Show build info
    if (config.showBuildInfo) {
        def buildInfo = buildInfo()
        echo "📊 Build completed at: ${buildInfo.timestamp}"
    }
    
    // Show system info
    if (config.showSystemInfo) {
        helloService.getSystemInfo()
    }
    
    // Run shell script
    if (config.runShellScript) {
        def scriptContent = libraryResource('scripts/hello.sh')
        writeFile file: 'hello.sh', text: scriptContent
        sh 'chmod +x hello.sh && ./hello.sh "Jenkins User"'
    }
    
    // Return summary
    return [
        status: "success",
        message: "Advanced hello completed",
        config: config,
        timestamp: new Date().toString()
    ]
}