FROM openjdk:8-alpine

ENV APP_PATH=/opt/demoapp

WORKDIR $APP_PATH

COPY target/demoapp.jar $APP_PATH/

EXPOSE 9000

CMD ["env"]

ENTRYPOINT ["java","-jar","demoapp.jar"]