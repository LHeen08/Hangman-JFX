<h1 align="center">
Hangman
</h1>

### Description
Hangman game using JavaFX. Includes 3 difficulties and uses 1,500+ words with their respective categories.
There are 3 difficulties Easy, Medium, Hard. Easy has 6 guesses of words containing less than 8 letters. Medium and hard
both have only 4 guesses. Medium shows words containing 8-12 letters and Hard shows words with 12+ letters.
<br/>

# Table of Contents
1. [Requirements](#requirements)
2. [Installation](#installation)
3. [Usage](#usage)
4. [Pom help](#change-pomxml)
5. [Screenshots](#screenshots)

# Requirements
- [Maven](https://maven.apache.org/)

- [Java 8](https://www.java.com/en/download/manual.jsp)

***If using another version of java it is required to have correct JavaFX library along with it, since Java  versions above 8 don't come with JavaFX***
<br/>
*Note* - You will need to change the pom.xml if using another version of java. See [here](#change-pomxml)
# Installation
Clone this repo to your machine
```
git clone https://github.com/LHeen08/Hangman-JFX.git
```
*Note* - 
Make sure JavaFX jar is installed correctly for your IDE if using another version of Java
<br/>

# Usage
Run the app in your preferred IDE


# Change-pom.xml
If using another java version besides 8 change the pom.xml accordingly
```
    <properties>
        <maven.compiler.source>{Edit java version here}</maven.compiler.source>
        <maven.compiler.target>{Edit java version here}</maven.compiler.target>
    </properties>
```
```
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.6.1</version>
                <configuration>
                    <source>{Edit java version here}</source>
                    <target>{Edit java version here}</target>
                </configuration>
            </plugin>
```

# Screenshots
![Screenshot](src/screenshots/screenshot1.png?raw=true)
![Screenshot](src/screenshots/screenshot2.png?raw=true)
![Screenshot](src/screenshots/screenshot3.png?raw=true)
![Screenshot](src/screenshots/screenshot4.png?raw=true)
![Screenshot](src/screenshots/screenshot5.png?raw=true)
![Screenshot](src/screenshots/screenshot6.png?raw=true)
![Screenshot](src/screenshots/screenshot7.png?raw=true)


