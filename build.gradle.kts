plugins {
    kotlin("jvm") version "1.8.0"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    // Appium Java Client
    implementation("io.appium:java-client:8.6.0")

    // TestNG for testing
    testImplementation("org.testng:testng:7.8.0")
}

tasks.test {
    useTestNG()
}


java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}
