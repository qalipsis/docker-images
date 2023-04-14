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

    // Preload all the plugins into the local Gradle cache.
    implementation("io.qalipsis.plugin:qalipsis-plugin-cassandra")
    implementation("io.qalipsis.plugin:qalipsis-plugin-elasticsearch")
    implementation("io.qalipsis.plugin:qalipsis-plugin-graphite")
    implementation("io.qalipsis.plugin:qalipsis-plugin-influxdb")
    implementation("io.qalipsis.plugin:qalipsis-plugin-jackson")
    implementation("io.qalipsis.plugin:qalipsis-plugin-jakarta-ee-messaging")
    implementation("io.qalipsis.plugin:qalipsis-plugin-jms")
    implementation("io.qalipsis.plugin:qalipsis-plugin-kafka")
    implementation("io.qalipsis.plugin:qalipsis-plugin-mail")
    implementation("io.qalipsis.plugin:qalipsis-plugin-mongodb")
    implementation("io.qalipsis.plugin:qalipsis-plugin-netty")
    implementation("io.qalipsis.plugin:qalipsis-plugin-r2dbc-jasync")
    implementation("io.qalipsis.plugin:qalipsis-plugin-rabbitmq")
    implementation("io.qalipsis.plugin:qalipsis-plugin-redis-lettuce")
    implementation("io.qalipsis.plugin:qalipsis-plugin-slack")
    implementation("io.qalipsis.plugin:qalipsis-plugin-timescaledb")
}