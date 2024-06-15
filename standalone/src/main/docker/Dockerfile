FROM --platform=$TARGETPLATFORM eclipse-temurin:21-jre-alpine

WORKDIR /app

ENV TINI_VERSION v0.19.0

ADD https://github.com/krallin/tini/releases/download/${TINI_VERSION}/tini /sbin/tini
RUN chmod +x /sbin/tini

RUN mkdir -p /app/libs /app/scenario-libs /app/logs /app/config
ADD libs /app/libs

RUN chmod -R 777 /app

COPY entrypoint.sh /usr/local/bin
RUN chmod +x /usr/local/bin/entrypoint.sh

EXPOSE 8080 8443

ENV JVM_ARGS "-Xms64m -Xmx1024m"
ENV LOG_PATH /app/logs
ENV MIN_FLAT_FILE_LOG_LEVEL ALL
ENTRYPOINT ["/sbin/tini", "--", "/usr/local/bin/entrypoint.sh"]
