# prueba_inditex_java
Proyecto: Prueba Inditex Java
Este proyecto se trata de una aplicación/servicio en SpringBoot que provee una endpoint rest de consulta para obtener información sobre precios de productos en una base de datos de comercio electrónico. La base de datos contiene la tabla PRICES que refleja el precio final y la tarifa que aplica a un producto de una cadena en unas fechas determinadas.

La aplicación acepta como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena. Y devuelve como datos de salida:

identificador de producto "PRODUCT_ID",
identificador de cadena "BRAND_ID",
tarifa a aplicar "PRIORITY",
fechas de aplicación "START_DATE" "END_DATE"
y precio final a aplicar "PRICE".
La base de datos se implementa en memoria (tipo h2) y se inicializa con los datos del ejemplo.

Endpoint
GET /prices: Acepta como parámetros de entrada applicationDate, productId, y brandId, y devuelve la información correspondiente al precio de un producto en una cadena en una fecha determinada.
Instrucciones para ejecutar
Clone el repositorio en su equipo local con el siguiente comando:
shell
Copy code
$ git clone https://github.com/falexramos/prueba_inditex_java.git
Acceda a la carpeta del proyecto:
shell
Copy code
$ cd prueba_inditex_java
Compile y ejecute la aplicación con Maven:
ruby
Copy code
$ mvn spring-boot:run
Cargue la información de ejemplo en la base de datos ejecutando el siguiente endpoint:
bash
Copy code
http://localhost:8080/prices/crearVarios
Pruebas con Postman
El proyecto incluye una colección de Postman que permite realizar pruebas al endpoint rest. Se deben validar las siguientes peticiones al servicio con los datos del ejemplo:

Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
Test 5: