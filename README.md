# Prueba técnica: technical-test
Repositorio para alojar la prueba técnica de la compañía.

# Especificaciones
La prueba está realizada con java 17 y Spring Boot version 3.0.5.

- Se ha usado Lombok para la reducción de código "boilerplate"
- Se ha usado un gestor de migraciones como flyway para pre-popular la base de datos.
- Se ha usado una bbdd en memoria H2.
- Los tests se han realizado con: 
  - Para el caso de los unitarios: Mockito y Junit5
  - Para el caso de los del controlador (integración): RestAssured junto con los Matchers de Hamcrest.
- Se ha implementado una arquitectura hexagonal (o de puertos y adaptadores) siguiendo los principios de diseño SOLID
- Se ha hecho uso de la clase @ControllerAdvice que proporciona Spring Boot para la centralización y mejor manejo de las excepciones del API
- Se ha usado git bajo el flujo de trabajo gitflow para la gestión de ramas del proyecto.
- Se ha facilitado un swagger para mejor testeo de la prueba.
- Uso de DTO para la entrada y salida del endpoint principal.

# Cómo lanzarla
Para probar la prueba, solamente habría que abir el proyecto en cualquier IDE y lanzarlo. Al hacerlo se nos levantará un [swagger](http://localhost:8080/swagger-ui/index.html)

# Conclusiones
Me ha gustado realizarla, aunque me hubiera gustado (por mi parte) tener más tiempo para dedicarle y así refinarla un poco más.
Por ejemplo, añadiría en los controladores los demás endpoints del típico CRUD
