# Utiliza una imagen base de Maven para compilar la aplicación
FROM maven:3.8.4-openjdk-11 AS build

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo pom.xml y descarga las dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia el código fuente y compila la aplicación
COPY src ./src
RUN mvn package -DskipTests

# Utiliza una imagen base de OpenJDK para ejecutar la aplicación
FROM openjdk:11-jre-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR compilado desde la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto en el que la aplicación se ejecutará
EXPOSE 4567

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]