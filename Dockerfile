FROM openjdk:8-jre

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JAVA_OPTS=""
    
ADD target/my-oauth-0.0.1-SNAPSHOT.jar app.jar

CMD echo "The application will start " && \
    java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar > catalina.out 2>&1 &

EXPOSE 8081