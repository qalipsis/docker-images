plugins {
    java
    id("com.palantir.docker") version "0.34.0" // https://github.com/palantir/gradle-docker
}

description = "Qalipsis Factory images"

val platformVersion: String by project

version = platformVersion

allprojects {
    group = "io.qalipsis.docker"

    apply(plugin = "java")
    apply(plugin = "com.palantir.docker")
}
