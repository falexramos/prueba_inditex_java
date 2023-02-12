# Proyecto: Prueba Inditex Java
<p>Este proyecto se trata de una aplicación/servicio en SpringBoot que provee una endpoint rest de consulta para obtener información sobre precios de productos en una base de datos de comercio electrónico. La base de datos contiene la tabla PRICES que refleja el precio final y la tarifa que aplica a un producto de una cadena en unas fechas determinadas.
Este proyecto es una solución para la prueba técnica de Inditex, donde se requiere implementar una aplicación en Java que permita calcular el precio final de un producto en función de sus características y descuentos aplicables.</p>

<h2>Requisitos</h2>
<ul> <li> Java 11</li></ul> 
<ul> <li> Maven 3.6.3</li></ul> 


<h2>Instalación</h2>
<ul> <li>1. Descargar el repositorio en su equipo local </li></ul> 
<ul> <li> en la consola de git bash con el comando: git clone https://github.com/falexramos/prueba_inditex_java.git</li></ul> 
<ul> <li>2.Acceder a la carpeta del proyecto desde la línea de comandos, ejecutar el comando para compilar </li></ul> <span> mvn clean install </span>

<h2>Recursos</h2>
<p>En la caprte de Postman se encuentra un archivo .json que puede importar para cargar datos de prueba o cargar nuevos datos. <br></br>El proyecto incluye una colección de Postman que permite realizar pruebas al endpoint rest</p>
<h2></h2>
<h2></h2>

<ul> <li> </li></ul> 
<ul> <li> </li></ul> 


<h2>La aplicación acepta como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena. Y devuelve como datos de salida:</h2>

identificador de producto "PRODUCT_ID",
identificador de cadena "BRAND_ID",
tarifa a aplicar "PRIORITY",
fechas de aplicación "START_DATE" "END_DATE"
y precio final a aplicar "PRICE".
La base de datos se implementa en memoria (tipo h2) y se inicializa con los datos del ejemplo.

