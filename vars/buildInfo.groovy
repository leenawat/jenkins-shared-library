#!/usr/bin/env groovy

def call() {
    def info = [:]
    
    info.buildNumber = env.BUILD_NUMBER ?: 'unknown'
    info.jobName = env.JOB_NAME ?: 'unknown'
    info.buildUrl = env.BUILD_URL ?: 'unknown'
    info.workspace = env.WORKSPACE ?: 'unknown'
    info.nodeLabel = env.NODE_LABELS ?: 'unknown'
    info.timestamp = new Date().toString()
    
    echo "📊 Build Information:"
    echo "   Build Number: ${info.buildNumber}"
    echo "   Job Name: ${info.jobName}"
    echo "   Build URL: ${info.buildUrl}"
    echo "   Workspace: ${info.workspace}"
    echo "   Node Label: ${info.nodeLabel}"
    echo "   Timestamp: ${info.timestamp}"
    
    return info
}

// Method to get specific info
def getBuildNumber() {
    return env.BUILD_NUMBER ?: 'unknown'
}

def getJobName() {
    return env.JOB_NAME ?: 'unknown'
}