# ============================
# 🧩 1️⃣ Stage de Build
# ============================
FROM eclipse-temurin:21-jdk-jammy AS builder

# Define o diretório de trabalho dentro do container
WORKDIR /opt/app

# Copia arquivos necessários para o build Maven
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Baixa dependências Maven para cache
RUN ./mvnw dependency:go-offline

# Copia o código fonte
COPY src ./src

# Compila o projeto (gera o .jar dentro de target/)
RUN ./mvnw clean package -DskipTests

# ============================
# 🚀 2️⃣ Stage de Execução (Runtime)
# ============================
FROM eclipse-temurin:21-jre-jammy

WORKDIR /opt/app

# Expõe a porta usada pelo Spring Boot
EXPOSE 8080

# Copia o .jar gerado do builder
COPY --from=builder /opt/app/target/*.jar /opt/app/app.jar

# Define o comando de inicialização
ENTRYPOINT ["java", "-jar", "/opt/app/app.jar"]
