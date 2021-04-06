plugins {
    java
    kotlin("jvm") version "1.4.32"
}

group = "br.com.alura.bytebank"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("mysql:mysql-connector-java:8.0.15")
    testImplementation("junit", "junit", "4.12")
}
