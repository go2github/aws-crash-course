FROM openjdk:8
ADD target/aws-crash-course.jar aws-crash-course.jar
ENTRYPOINT ["java","-jar","/aws-crash-course.jar"]
EXPOSE 8080