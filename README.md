# Prueba Técnica THB (Backend)

## Herramientas Usadas
- Spring
- Spring Boot
- MySQL Workbench
- OpenJDK 17

## Instrucciones

1. Una vez creada la base de datos, abrir el proyecto en algún IDE.
2. Colocar la contraseña y usuario en el `application.properties`.
3. Ejecutar el proyecto desde el archivo `PruebaApplication.java`. Se ejecutará en el puerto por defecto (8080). Procurar ejecutar el backend antes que el front.

## Notas
- Tiene habilitado CORS para que se puedan hacer peticiones desde otro localhost en el puerto 8081.
- Tiene integrado el driver de Postgres por si es más conveniente, auqneu esto implica tambien colocar las demás conexiones e información necesaria para que conecten.
- Para mejores resultados, después de crear la base de datos de THB, no generar las tablas con script ya que cuando se inicia el backend solo busca la base de datos y mapea las entidades creando las tablas. Lo que si es recomendable es hacer los registros con el `base.sql`.

