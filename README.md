Este proyecto utiliza Spring Boot para construir una aplicación web con acceso a una base de datos. A continuación, se describen las dependencias necesarias, la estructura de los paquetes y las propiedades de configuración relevantes.

## Dependencias a descargar

- **Spring Data JPA**: Facilita la interacción con la base de datos y proporciona operaciones CRUD mediante interfaces de repositorio.
- **H2**: Base de datos en memoria utilizada principalmente para pruebas y desarrollo, permitiendo una configuración fácil y rápida de una base de datos temporal.
- **Spring WEB**: Conjunto de funcionalidades para desarrollar aplicaciones web en Spring, incluyendo soporte para el manejo de solicitudes HTTP y el desarrollo de controladores web.

## Paquetes y sus significados

- **Entities**: Aquí se definen las entidades que representarán la estructura de nuestra base de datos. En este caso, se crea la entidad "Pokedex" con sus respectivos atributos.
- **Repository**: Contiene los repositorios que interactúan con la base de datos. Se puede utilizar tanto `CrudRepository` como `JpaRepository`, siendo este último más completo.
- **Controllers**: Define los controladores que manejan las solicitudes HTTP.
- **Service**: Actúa como el cerebro de la aplicación, encargándose de la lógica de negocio y coordinando las operaciones entre los controladores y los repositorios. Proporciona una abstracción entre las capas y promueve una arquitectura más modular y mantenible.
- **Data**: Componente encargado de cargar datos iniciales en la base de datos, ya sea para pruebas de desarrollo o datos básicos necesarios al inicio de la aplicación. Esto asegura que la funcionalidad de la aplicación que depende de estos datos funcione correctamente.

## Propiedades de configuración

A continuación se detallan algunas propiedades de configuración importantes para la aplicación:

| Propiedad | Descripción |
| --- | --- |
| `spring.datasource.url` | URL de conexión a la base de datos. |
| `spring.datasource.username` | Nombre de usuario para la conexión a la base de datos. |
| `spring.datasource.password` | Contraseña para la conexión a la base de datos. |
| `spring.jpa.hibernate.ddl-auto` | Controla la forma en que Hibernate crea o actualiza la estructura de la base de datos (`create`, `update`, etc.). |
| `spring.jpa.show-sql` | Muestra las consultas SQL generadas por Hibernate en la consola. |
| `spring.jpa.properties.hibernate.dialect` | Dialecto de Hibernate para la base de datos utilizada (por ejemplo, `org.hibernate.dialect.MySQLDialect`). |
| `spring.servlet.multipart.max-file-size` | Tamaño máximo permitido para archivos cargados (por ejemplo, "10MB"). |
| `spring.servlet.multipart.max-request-size` | Tamaño máximo permitido para la solicitud multipart (por ejemplo, "100MB"). |
| `server.port` | Puerto en el que se ejecutará la aplicación web. |
| `server.servlet.context-path` | Ruta del contexto de la aplicación web (por ejemplo, `/myapp`). |
| `spring.profiles.active` | Permite activar perfiles de configuración específicos. |
| `logging.level.root` | Nivel de registro para la raíz del registro de la aplicación (por ejemplo, `INFO`, `DEBUG`, `ERROR`). |
| `spring.thymeleaf.cache` | Habilita o deshabilita el caché de Thymeleaf (motor de plantillas). |
