#!/usr/bin/env groovy

def call() {
    echo "🌍 Hello World from Shared Library!"
    echo "📅 Current time: ${new Date()}"
    echo "🏗️ Build number: ${env.BUILD_NUMBER}"
    echo "🔧 Job name: ${env.JOB_NAME}"
}