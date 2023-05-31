
#Proyecto de Automatización Web con Selenium, Cucumber y Screenplay

Este proyecto utiliza Selenium, Cucumber y el patrón de diseño Screenplay para realizar pruebas automatizadas en aplicaciones web. Se utiliza Maven como gestor de dependencias.

### Versión utilizada
- Serenity Core: 1.8.3
- Serenity Cucumber: 1.6.6
- SLF4J Simple: 1.7.7
- JUnit: 4.12

## Instalación
Clona este repositorio:

´´´
git clone https://github.com/tuusuario/proyecto-automatizacion-web.git
Navega al directorio del proyecto:
´´´

´´´
cd proyecto-automatizacion-web
Ejecuta el siguiente comando para compilar y descargar las dependencias:
´´´

´´´
mvn clean compile
´´´

## Ejecución
Para ejecutar las pruebas automatizadas, utiliza el siguiente comando:

´´´
mvn clean verify
´´´ 

Este comando ejecutará las pruebas y generará los informes de Serenity al finalizar.

## Estructura del proyecto

- src/test/java: Contiene los archivos de código fuente de las pruebas.
- src/test/resources: Contiene los archivos de recursos, como los archivos Gherkin con los escenarios de prueba.
- Escenarios Gherkin
- Los escenarios de prueba se encuentran en los archivos .feature en la carpeta src/test/resources/features. Estos archivos están escritos en lenguaje Gherkin y describen el comportamiento esperado de la aplicación bajo prueba.

### Comandos adicionales

´´´
mvn clean: Limpia los archivos generados en compilaciones anteriores.
mvn compile: Compila el código fuente del proyecto.
mvn test: Ejecuta las pruebas unitarias.
mvn serenity:aggregate: Genera los informes de Serenity.
´´´

Para más información sobre los comandos disponibles, consulta la documentación de Maven.


