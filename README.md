# <a src="https://qalipsis.io"><img src="http://assets.qalipsis.io/qalipsis-logo.png" style="height:60px;width:60px;position:relative;top:18px;margin-right:20px;"/>QALIPSIS - Builders for the Docker Images</a>

![CI](https://github.com/qalipsis/docker-images/actions/workflows/build-images.yml/badge.svg)

## Introduction

This project contains three modules to build the required Docker images used for QALIPSIS:

- Head
- Factory
- Standalone
- Factory builder
- Factory builder with plugins

The versions of the dependencies are to be updated in the file `gradle.properties`.

## The images

### Head

The head is built using a Gradle Plugin for Docker, generating an image containing
a flat directory with all the required dependencies.

The start program of the image forces QALIPSIS to start as head but accepts further arguments.

Additional configuration files (for QALIPSIS or logback) can be added / mounted into the folder `/app/config`.
The logs are written into the directory `/app/logs`, which can be overwritten by the env variable `LOG_PATH`.

The JVM argument are set by the env variable `JVM_ARGS` and default to `-Xms64m -Xmx512m`.

The image also contains extra dependencies to write logs as JSON, which has to be properly configured by the deployment
configuration.

### Factory

The factory is built using a Gradle Plugin for Docker, generating an image containing
a flat directory with all the required dependencies.

The start program of the image forces QALIPSIS to start as factory but accepts further arguments.

Additional configuration files (for QALIPSIS or logback) can be added / mounted into the folder `/app/config`.
The logs are written into the directory `/app/logs`, which can be overwritten by the env variable `LOG_PATH`.

The JVM argument are set by the env variable `JVM_ARGS` and default to `-Xms64m -Xmx1024m`.

The image also contains extra dependencies to write logs as JSON, which has to be properly configured by the deployment
configuration.

### Standalone

The standalone image is built using a Gradle Plugin for Docker, generating an image containing
a flat directory with all the required dependencies.

The start program of the image forces QALIPSIS to start as standalone but accepts further arguments.

Additional configuration files (for QALIPSIS or logback) can be added / mounted into the folder `/app/config`.
The logs are written into the directory `/app/logs`, which can be overwritten by the env variable `LOG_PATH`.

The JVM argument are set by the env variable `JVM_ARGS` and default to `-Xms64m -Xmx1024m`.

The image also contains extra dependencies to write logs as JSON, which has to be properly configured by the deployment
configuration.

### Factory builder

In order to accelerate the build of new factories in a reproducible way, a Gradle-based image
is created, which contains all the dependencies for the QALIPSIS scenario build.

Building such a "factory builder" requires flexible files for Docker, that are generated dynamically from templates.

However, while the whole preparation is working properly, building the image using the Gradle Plugin for Docker
is not working and leads to an endless build.

Therefore, the process of Docker preparation also creates a script file for Unix-based machines, generated into
build/docker, which contains the command and configuration to build, tag and push the image.

### Factory builder with plugins

The image is similar to the previous one, but additionally includes all the preloaded QALIPSIS plugins in the Gradle
cache.

## Building all the images

The images are meant to be built and published from the Github actions.
When the version of the libraries are upgraded, the configuration has to be changed into the file `gradle.properties`
and a build will automatically run on the git push action.