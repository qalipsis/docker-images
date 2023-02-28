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

    implementation("io.qalipsis:api-dsl")

    // Preload all the plugins into the local Gradle cache.
    implementation("io.qalipsis.plugin:cassandra")
    implementation("io.qalipsis.plugin:elasticsearch")
    implementation("io.qalipsis.plugin:graphite")
    implementation("io.qalipsis.plugin:influxdb")
    implementation("io.qalipsis.plugin:jackson")
    implementation("io.qalipsis.plugin:jakarta-ee-messaging")
    implementation("io.qalipsis.plugin:jms")
    implementation("io.qalipsis.plugin:kafka")
    implementation("io.qalipsis.plugin:mail")
    implementation("io.qalipsis.plugin:mongodb")
    implementation("io.qalipsis.plugin:netty")
    implementation("io.qalipsis.plugin:r2dbc-jasync")
    implementation("io.qalipsis.plugin:rabbitmq")
    implementation("io.qalipsis.plugin:redis-lettuce")
    implementation("io.qalipsis.plugin:slack")
    implementation("io.qalipsis.plugin:timescaledb")
}