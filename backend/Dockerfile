FROM openjdk:17

ARG JAR_FILE=build/libs/*.jar
ARG SPRING_PROFILE=dev
ARG JASYPT_PASSWORD

COPY ${JAR_FILE} seoul-awake.jar

ENV spring_profile=${SPRING_PROFILE} \
    jasypt_password=${JASYPT_PASSWORD}

ENTRYPOINT java -jar seoul-awake.jar \
            --spring.profiles.active=${spring_profile} \
            --JASYPT_PASSWORD=${jasypt_password}
