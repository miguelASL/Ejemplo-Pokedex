# Imagen base de Docker
FROM openjdk:17-slim

# Etiqueta de la imagen
LABEL authors="mike"

# Directorio de trabajo
WORKDIR /app

# Comando de prueba
# ECHO "Prueba de Dockerfile"

# Copia los archivos necesarios para la construcción
COPY pom.xml .
COPY src ./src

# Instala Maven, construye el proyecto y luego limpia
# Actualiza la lista de paquetes disponibles en los repositorios de Debian y luego instala Maven.
# Ejecuta Maven para limpiar cualquier construcción previa y empaquetar el proyecto.
# Desinstala Maven, ya que no es necesario después de construir el proyecto.
# Elimina el directorio de construcción y el código fuente, ya que ya no son necesarios después de construir el JAR.
# Borra las listas de paquetes descargadas por apt-get update, reduciendo así el tamaño de la imagen.
RUN apt-get update && \
    apt-get install -y maven && \
    mvn package && \
    apt-get remove -y maven && \
    rm -rf /var/lib/apt/lists/* && \
    rm -rf /root/.m2 && \
    rm -rf /app/src && \
    rm -rf /app/target

# Informa a Docker que el contenedor escuchará en el puerto 7000 en tiempo de ejecución. Sin embargo, este puerto debe ser mapeado al host en el momento de la ejecución para ser accesible desde fuera del contenedor.
EXPOSE 7000

# Define el comando que se ejecutará por defecto cuando el contenedor se inicie. En este caso, está ejecutando el JAR de tu aplicación con Java.
ENTRYPOINT ["java", "-jar", "pokedexoficial-0.0.1-SNAPSHOT.jar"]