## Dependecias a descargar. 

- `Spring Data JPA`-> Se utiliza para facilitar la interacción con la base de datos y proporcionar operaciones CRUD 
mediante interfaces de repositorio.
- `H2`-> Es una base de datos en memoria que se utiliza principalmente para pruebas y desarrollo, permitiendo una 
configuración fácil y rápida de una base de datos temporal.
- `Spring WEB`-> Es un conjunto de funcionalidades para desarrollar aplicaciones web en Spring, incluyendo soporte 
para el manejo de solicitudes HTTP y el desarrollo de controladores web.

------------------------------------------------------------------------------------------------------------------------
## Paquete y sus significados.

* `Entities`-> Lo usaremos para crear nuestra base de datos. en este caso fue la "pokedex", con sus atributos.
* `Repository`-> Fue donde se creo el repositorio, se puede usar tanto CrudRepository como JpaRepository, 
es mas completo.
* `Controllers`-> Que es donde realizaremos las llamadas HTTP
* `Service`-> El archivo de servicio actúa como el cerebro de la aplicación, encargándose de la lógica de negocio 
y coordinando las operaciones entre los controladores y los repositorios. Proporciona una abstracción entre las capas y
promueve una arquitectura más modular y mantenible para la aplicación.
* `Data`-> En este caso fue componente que se encarga de cargar datos iniciales en la base de datos, ya sea 
datos de prueba para desarrollo o datos básicos que deben estar disponibles al inicio de la aplicación. Esto puede ser 
útil para probar y asegurar que la funcionalidad de la aplicación que depende de estos datos funcione correctamente.
-----------------------------------------------------------------------------------------------------------------------

*   **Propiedad	Descripción**
    * `spring.datasource.url`-> URL de conexión a la base de datos.
    * `spring.datasource.username`-> Nombre de usuario para la conexión a la base de datos.
    * `spring.datasource.password`-> Contraseña para la conexión a la base de datos.
    * `*pring.jpa.hibernate.ddl-auto`-> Controla la forma en que Hibernate crea o actualiza la estructura de la base de 
    datos (create, update, etc.).
    * `spring.jpa.show-sql` -> Muestra las consultas SQL generadas por Hibernate en la consola.
    * `spring.jpa.properties.hibernate.dialect`-> Dialecto de Hibernate para la base de datos utilizada (por ejemplo, 
    org.hibernate.dialect.MySQLDialect).
    * `spring.servlet.multipart.max-file-size`-> Tamaño máximo permitido para archivos cargados (por ejemplo, "10MB").
    * `spring.servlet.multipart.max-request-size`-> Tamaño máximo permitido para la solicitud multipart
    (por ejemplo, "100MB").
    * `server.port`-> Puerto en el que se ejecutará la aplicación web.
    * `server.servlet.context-path`-> Ruta del contexto de la aplicación web (por ejemplo, /myapp).
    * `spring.profiles.active`-> Permite activar perfiles de configuración específicos.
    * `logging.level.root` -> Nivel de registro para la raíz del registro de la aplicación 
    (por ejemplo, INFO, DEBUG, ERROR).
    * `spring.thymeleaf.cache`-> Habilita o deshabilita el caché de Thymeleaf (motor de plantillas).