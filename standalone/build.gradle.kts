description = "QALIPSIS Standalone image"

val platformVersion: String by project

version = platformVersion.toLowerCase()

repositories {
    mavenCentral()

    maven {
        name = "maven-central-snapshots"
        setUrl("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

dependencies {
    implementation(platform("io.qalipsis:qalipsis-platform:$platformVersion"))

    implementation("io.qalipsis:qalipsis-runtime")
    implementation("io.qalipsis:qalipsis-head")
    implementation("io.qalipsis:qalipsis-factory")

    runtimeOnly("net.logstash.logback:logstash-logback-encoder:7.2")
}

docker {
    name = "zakd79ka.gra7.container-registry.ovh.net/oss/${project.name}:${platformVersion.toLowerCase()}"

    setDockerfile(project.file("src/main/docker/Dockerfile"))

    platform("linux/amd64", "linux/arm64")
    buildx(true)
    files((tasks["processResources"] as ProcessResources).outputs, File(project.buildDir, "classpath"))
    noCache(true)
    push(true)
}

tasks {
    val collectJars = create("collectJars") {
        group = "build"

        doLast {
            val target = File(project.buildDir, "classpath/libs")
            if (!target.isDirectory) {
                target.deleteRecursively()
            }
            project.mkdir(target)
            configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.forEach {
                it.copyTo(File(target, it.name), true)
            }
        }
    }

    named("dockerPrepare").configure {
        dependsOn(collectJars)
    }
}
