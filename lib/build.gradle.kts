plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("com.google.guava:guava:32.1.1-jre")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks.register("task3"){
    println("REGISTER TASK3: This is executed during the configuration phase")
}

tasks.named("task3"){
    println("NAMED TASK3: This is executed during the configuration phase")
    doFirst {
        println("NAMED TASK3 - doFirst: This is executed during the execution phase")
    }
    doLast {
        println("NAMED TASK3 - doLast: This is executed during the execution phase")
    }
}
