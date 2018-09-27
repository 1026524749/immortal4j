FROM openjdk:8u162-jre
ADD ./output/immortal4j-0.0.1-SNAPSHOT.jar /app.jar
CMD java -Xms10m -Xmx200m -jar /app.jar