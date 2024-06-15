FROM --platform=$TARGETPLATFORM eclipse-temurin:21-jre-alpine

WORKDIR /app

RUN apk add --no-cache tini

RUN mkdir -p /app/libs /app/logs /app/config
ADD libs /app/libs

RUN chmod -R 777 /app

COPY entrypoint.sh /usr/local/bin
RUN chmod +x /usr/local/bin/entrypoint.sh

EXPOSE 8080

ENV JVM_ARGS "-Xms64m -Xmx512m"
ENV LOG_PATH /app/logs
ENV MIN_FLAT_FILE_LOG_LEVEL ALL
ENTRYPOINT ["/sbin/tini", "--", "/usr/local/bin/entrypoint.sh"]
