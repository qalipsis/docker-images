plugins {
    java
}

repositories {
    mavenCentral()
    maven {
        name = "maven-central-snapshots"
        setUrl("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

configure<JavaPluginConvention> {
    description = "Cloud factory builder Image for QALIPSIS"

    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(platform("io.qalipsis:qalipsis-platform:@platform.version@"))

    implementation("io.qalipsis:qalipsis-api-dsl")
}