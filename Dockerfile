FROM openjdk:8
ADD jar/booking-service.jar booking-service.jar
EXPOSE 8100
ENTRYPOINT ["java","-jar","booking-service.jar"] 