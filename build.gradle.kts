plugins {
    kotlin("jvm") version "2.0.20"
    id("com.gradle.plugin-publish") version "1.2.1"
    `java-gradle-plugin`
    `maven-publish`
}

group = "com.evan.gradle"
version = "0.0.0"

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}

gradlePlugin {
    plugins {
        create("testPlugin") {
            displayName = "Test Plugin"
            description = "This plugin is a test plugin"
            id = "com.evan.test-plugin"
            implementationClass = "com.evan.gradle.TestPlugin"
            tags = listOf("tooling", "kotlin")
        }
    }
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/evanc-mfw/test-plugin")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
            //artifact(tasks.getByName("kotlinSourcesJar"))
        }
    }
}
