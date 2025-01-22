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

    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.17.2")
}

tasks.test {
    useTestNG()
}


java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}
