plugins {
    id("java")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(project(":accountbook-api"))
    implementation(project(":dispatcher-api"))
    runtimeOnly(project(":dispatcher-core"))
}

tasks.test {
    useJUnitPlatform()
}