# ============ 1) BUILD ============
FROM maven:3.9.9-eclipse-temurin-21 AS builder
WORKDIR /workspace

COPY pom.xml .
RUN mvn -B -DskipTests dependency:go-offline

COPY src ./src
RUN mvn -B -DskipTests package

# ============ 2) RUNTIME ============
FROM eclipse-temurin:21-jre-jammy
WORKDIR /opt/app

ENV PORT=8080
EXPOSE 8080

# copia o jar “fat” (gcp-<versao>.jar). O .jar.original NÃO casa aqui.
COPY --from=builder /workspace/target/gcp-*.jar /opt/app/app.jar

# forma exec; deixe a porta vir do application.yml e fixe o bind (redundante, mas ok)
ENTRYPOINT ["java","-jar","/opt/app/app.jar","--server.address=0.0.0.0"]

## ============================
## 1) BUILD (Maven + JDK 21)
## ============================
#FROM maven:3.9.9-eclipse-temurin-21 AS builder
#WORKDIR /workspace
#
## Copia o POM primeiro para aproveitar cache das dependências
#COPY pom.xml .
#RUN mvn -B -DskipTests dependency:go-offline
#
## Copia o código-fonte e empacota
#COPY src ./src
#RUN mvn -B -DskipTests package
#
## ============================
## 2) RUNTIME (JRE 21 enxuto)
## ============================
#FROM eclipse-temurin:21-jre-jammy
#WORKDIR /opt/app
#
## Cloud Run usa a variável $PORT; default 8080 localmente
#ENV PORT=8080
#EXPOSE 8080
#
## Copia o jar gerado
## (se houver só 1 jar em target, o wildcard funciona)
#COPY --from=builder /workspace/target/*.jar /opt/app/app.jar
#
## Faz o app escutar na porta do Cloud Run ($PORT)
#ENTRYPOINT ["sh","-c","java -jar /opt/app/app.jar --server.port=${PORT}"]
