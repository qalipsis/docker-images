FROM --platform=$TARGETPLATFORM gradle:8-jdk17-jammy

RUN mkdir -p /usr/pre-app
WORKDIR /usr/pre-app
COPY app /usr/pre-app/

RUN gradle --no-daemon --no-watch-fs classes

WORKDIR /usr/app
RUN rm -rf /usr/pre-app

