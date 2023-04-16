/**
 * For a reason we cannot explain, the image can be prepared but not built with the Gradle plugin.
 * The Gradle plugin freezes on locks acquire/release and never ends.
 *
 * Therefore, we generate a script file for Unix-based machines, that can build and push the image.
 */
description = "Builder for the QALIPSIS Factory images"

val kotlinVersion: String by project
val platformVersion: String by project

version = platformVersion.toLowerCase()

tasks {

    val replacedPropertiesInResources = mapOf(
        "kotlin.version" to kotlinVersion,
        "platform.version" to platformVersion,
        "image.name" to "zakd79ka.gra7.container-registry.ovh.net/oss/${project.name}:${project.version}",
        "docker.folder" to project.file("build/docker").absolutePath
    )

    withType<ProcessResources> {
        filter<org.apache.tools.ant.filters.ReplaceTokens>(
            "beginToken" to "@",
            "endToken" to "@",
            "tokens" to replacedPropertiesInResources
        )
    }

    named("dockerPrepare").configure {
        dependsOn("processResources")
    }
}

docker {
    name = "zakd79ka.gra7.container-registry.ovh.net/oss/${project.name}:${project.version}"
    tag("latest", project.version as String)

    setDockerfile(project.file("src/main/docker/Dockerfile"))
    files((tasks["processResources"] as ProcessResources).outputs)
}