import kotlin.io.path.exists
import kotlin.io.path.pathString

plugins {
    java
    id("org.springframework.boot") version "3.3.0-M1"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "lol.koblizek"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    implementation("org.jetbrains:annotations:24.1.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

val resourceDir: File = sourceSets.main.get().resources.srcDirs.first()
val privKey = resourceDir.resolve("cert/private.pem").toPath()
val pubKey = resourceDir.resolve("cert/public.der").toPath()


val genKeys = tasks.create("genKeys") {
    group = "myedu"
    description = "Generates keys"

    doLast {
        if (privKey.exists() || pubKey.exists()) {
            println("Keys already exist, no need to generate them")
        } else {
            exec {
                workingDir = projectDir
                commandLine = listOf("openssl genrsa -out src/main/resources/cert/private.pem 2048")
            }
            exec {
                commandLine = listOf("openssl rsa -in ${privKey.toFile().path} -pubout -outform DER -out ${pubKey.pathString}")
            }
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
