FROM openjdk:8-jre

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JAVA_OPTS=""

ARG JAR_FILE

ADD target/${JAR_FILE} app.jar

CMD echo "The application will start " && \
    java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar

EXPOSE 8081