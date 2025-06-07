# Kata-tondeuse
## Prerequisites
To use this app, you need to have installed :
- Java 21 (or other if you want to change the version in the parameters)
- Maven

You also need to write your own instruction files according to the spec given in the kata subject

## Installation
Copy the git project to your environment with git clone, then run
```
mvn clean install
```

## Use
To use this app, you need to write the following commands
```
java -jar tondeuse/target/tondeuse-1.0-SNAPSHOT.jar "$PATH_TO_YOUR_INSTRUCTIONS_FILE"
```
The example file is stored as tondeuse/test/java/resources/TestFile.txt