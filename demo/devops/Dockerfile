FROM openjdk:21-jdk-oracle

WORKDIR /app
COPY demo-0.0.1-SNAPSHOT.jar /app/demo.jar

ENV JAVA_OPTS="-Xms256m -Xmx512m"

CMD ["sh", "-c", "java $JAVA_OPTS -jar /app/demo.jar"]