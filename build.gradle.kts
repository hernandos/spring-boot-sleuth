import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.0"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.7.21"
    kotlin("plugin.spring") version "1.7.21"
}

group = "de.com.saenz"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
}

extra["springCloudVersion"] = "2022.0.0-RC2"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//    implementation("org.springframework.cloud:spring-cloud-starter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-actuator
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    implementation (platform("io.micrometer:micrometer-tracing-bom:latest.release"))
    implementation ("io.micrometer:micrometer-tracing")
    implementation("io.micrometer:micrometer-tracing-bridge-brave")

    implementation("io.zipkin.reporter2:zipkin-reporter-brave")
    // https://mvnrepository.com/artifact/com.github.loki4j/loki-logback-appender
    implementation("com.github.loki4j:loki-logback-appender:1.3.2")




}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
