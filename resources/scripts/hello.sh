#!/bin/bash

echo "🐚 Hello from Shell Script!"
echo "📅 Date: $(date)"
echo "👤 User: $(whoami)"
echo "📂 PWD: $(pwd)"
echo "🖥️  Hostname: $(hostname)"

# Function example
say_hello() {
    local name=${1:-"World"}
    echo "👋 Hello, $name from shell script!"
}

# Call function
say_hello "$1"