FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=build/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
COPY wait-for-it.sh wait-for-it.sh
RUN apk add --no-cache bash
CMD ["chmod", "-x", "wait-for-it.sh"]
ENTRYPOINT ["./wait-for-it.sh", "localhost:8091", "--timeout=120", "--", "java","-cp","app:app/lib/*","com.colwell.coding.swdocdata.SwDocDataApplication"]
