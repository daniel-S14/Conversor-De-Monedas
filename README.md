# Conversor de Monedas
![Badge-Conversor](https://github.com/daniel-S14/Conversor-De-Monedas/assets/29052820/8a3d5142-61b9-4925-87e5-01291ce73d96)

## Índice

1. [Descripción General](#descripción-general)
2. [Características](#características)
3. [Requisitos](#requisitos)
4. [Configuración](#configuración)
5. [Uso](#uso)
6. [Ejemplo](#ejemplo)
7. [Autor](#autor)


## Descripción General

Esta es una aplicación simple en Java que convierte valores de moneda utilizando tasas de cambio en tiempo real de una API externa. La aplicación utiliza la biblioteca Gson para analizar las respuestas JSON de la API.

## Características

- Convertir moneda de un tipo a otro utilizando tasas de cambio en tiempo real.
- Soporta múltiples monedas.
- Guardar el historial de las conversiones realizadas.
- Interfaz de línea de comandos fácil de usar.

## Requisitos

- Java 8 o superior
- Biblioteca Gson
- Conexión a Internet

## Configuración

1. **Clonar el repositorio:**

   ```bash
   git clone (https://github.com/daniel-S14/Conversor-De-Monedas.git)
   cd Conversor-De-Monedas
   ```

2. **Instalar dependencias:**

   Asegúrate de tener la biblioteca Gson. Puedes descargarla desde el [Repositorio de Maven](https://mvnrepository.com/artifact/com.google.code.gson/gson).

   Si estás usando Maven, agrega la siguiente dependencia a tu `pom.xml`:

   ```xml
   <dependency>
       <groupId>com.google.code.gson</groupId>
       <artifactId>gson</artifactId>
       <version>2.8.8</version>
   </dependency>
   ```

   Si estás usando Gradle, agrega lo siguiente a tu `build.gradle`:

   ```groovy
   implementation 'com.google.code.gson:gson:2.8.8'
   ```

3. **Obtener una clave de API:**

   Regístrate para obtener una clave de API gratuita de un proveedor de servicios de conversión de moneda en [ExchangeRate-API](https://www.exchangerate-api.com/).

4. **Configurar la clave de API:**

   Actualiza el archivo `config.properties` con tu clave de API:

   ```
   api.key=TU_CLAVE_DE_API_AQUI
   ```

## Uso

1. **Compilar la aplicación:**

   ```bash
   javac -cp gson-2.8.8.jar:. src/com/example/currencyconverter/Main.java
   ```

2. **Ejecutar la aplicación:**

   ```bash
   java -cp gson-2.8.8.jar:. src/com/example/currencyconverter/Main
   ```

3. **Sigue las instrucciones en pantalla:**

   Ingresa la cantidad y las monedas de origen y destino. La aplicación mostrará la cantidad convertida utilizando las tasas de cambio más recientes de la API.

## Ejemplo

  ```plaintext
+------------------------------------------------+
|               Menú de Opciones                 |
+------------------------------------------------+
| 1. Peso mexicano
| 2. Rublo ruso
| 3. Dolar estadounidense
| 4. Real brazileño
| 5. Peso argentino
| 6. Yen japonés
| 0. Salir                                       |
+------------------------------------------------+
Seleccione moneda base: 
1
+------------------------------------------------+
|               Menú de Opciones                 |
+------------------------------------------------+
| 1. Peso mexicano
| 2. Rublo ruso
| 3. Dolar estadounidense
| 4. Real brazileño
| 5. Peso argentino
| 6. Yen japonés
| 0. Salir                                       |
+------------------------------------------------+
Seleccione moneda objetivo: 
3
Ingrese la cantidad a convertir
7895
El resultado de convertr 7895.0 MXN(Peso mexicano) es: 432.09335 USD(Dolar estadounidense)
Si desea realizar una conversión más ingrese 1 sino ingrese 0
 ```

## Autor
| [<img src="https://avatars.githubusercontent.com/u/29052820?s=400&v=4" width=115><br><sub>Daniel Zazueta</sub>](https://github.com/daniel-S14) |
| :---: |
