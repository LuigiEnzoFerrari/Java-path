#!/bin/bash

find * -name "*.java" > sources.txt

if [ "$#" -ne 1 ]; then
    echo "Expecting exactly one argument."
    exit 1
fi

# Compilation
echo "Compiling Java program..."
javac -d bin/ @sources.txt

# Execute
if [ $? -eq 0 ]; then
	java -cp bin/ aviation.main.Main $1
else
    echo "Compilation failed. Please fix the errors."
fi