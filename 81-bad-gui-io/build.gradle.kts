plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "0.40.0"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.mvc.BadIOGUI")
}

dependencies {
    compileOnly("com.github.spotbugs:spotbugs-annotations:4.7.3")
}