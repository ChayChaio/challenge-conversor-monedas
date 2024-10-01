# Conversor de Monedas

Este proyecto es un conversor de monedas que permite realizar conversiones entre varias divisas populares 
y guardar los resultados en un archivo JSON. La aplicación interactúa con una API externa para 
obtener las tasas de conversión actualizadas. 
Está compuesto por varias clases que gestionan la consulta a la API, el procesamiento de los resultados 
y la presentación del cambio realizado.

## Funcionalidades
**Convertir entre las siguientes monedas:**
- Dólar (USD) y Peso Argentino (ARS)
- Dólar (USD) y Real Brasileño (BRL)
- Dólar (USD) y Peso Colombiano (COP)
- Mostrar el resultado de la conversión en pantalla.
- Guardar los resultados de las conversiones en un archivo JSON.
- Finalizar el programa automáticamente después de guardar los resultados.

## Tabla de Contenidos
- [Requisitos](#requisitos)
- [Instalación y uso](#instalación-y-uso)
- [Estructura del Proyecto](#estructura-del-proyecto)
  - [Main.java](#mainjava)
  - [ConsultaApi.java](#consultaapijava)
  - [GeneradorDeJson.java](#generadordejsonjava)
  - [ResultadoDelCambio.java](#resultadodelcambiojava)
- [Capturas paso a paso](#capturas-paso-a-paso) 

## Requisitos

- Java 17 o superior.
- Dependencias externas para consultas HTTP (por ejemplo, `HttpClient` de Java o alguna librería como `OkHttp`).
- Clave API válida para realizar consultas de conversión de moneda (obtenida de una API de cambio de divisas).

## Instalación y uso

1. Clona el repositorio:
   ```bash
   git clone https://github.com/ChayChaio/challenge-conversor-monedas.git

Abrir la carpeta en IntelliJ

Correr la clase Main.java

Ingresa tu clave API cuando se te solicite.

Selecciona las opciones del menú para realizar conversiones entre monedas. 
Los resultados se mostrarán en pantalla y se almacenarán en una lista.

Puedes optar por guardar los resultados de las conversiones en un archivo 
JSON seleccionando la opción 7 en el menú. El programa se cerrará automáticamente 
después de guardar los resultados correctamente.

## Estructura del Proyecto
### Main.java
El punto de entrada de la aplicación. Esta clase coordina las interacciones con el usuario, solicita las monedas y el monto a convertir, 
y luego utiliza la clase ConsultaApi para obtener los datos de la API.

### ConsultaApi.java
Esta clase maneja la conexión a una API externa de conversión de monedas. Recibe como parámetros la moneda base y la moneda objetivo,
y devuelve un objeto ResultadoDelCambio con los detalles de la conversión.

### GeneradorDeJson.java
Responsable de gestionar la estructura de los datos JSON necesarios para interactuar con la API de conversión de monedas.

### ResultadoDelCambio.java
Esta clase es un record que almacena los resultados de la conversión de moneda, como el monto convertido y la tasa de cambio. 
También incluye un método mostrarAlmacenarResultado para imprimir los resultados y almacenarlos en una lista si es necesario.

## Capturas paso a paso
Mensaje de bienvenida y pedido de una APIKey para funcionar
![image](https://github.com/user-attachments/assets/06799dd6-2e7f-4c97-8ad9-59d2603c28f9)
Presentación del menú de opciones
![image](https://github.com/user-attachments/assets/0cf7de03-240a-4e18-a58b-d5f76f4a1d18)
Selección de la opción 1 y el monto a convertir
![image](https://github.com/user-attachments/assets/26655ab4-4df7-4f6c-bde8-910ff5c42622)
Devuelve la información de la conversión y ofrece nuevamente el menú de opciones
![image](https://github.com/user-attachments/assets/b659dd75-9cc6-40a4-ae23-68af41df9141)
Repito los mismos pasos con otras opciones de conversión
![image](https://github.com/user-attachments/assets/ba7a1b3c-4226-402b-9e80-be1ed32284cf)
![image](https://github.com/user-attachments/assets/c4b088c1-3895-4d31-bb31-5ea7364ead52)
Selecciono la opción 7.- Guardar...
Solicita un nombre con el cual guardar el archivo
![image](https://github.com/user-attachments/assets/543b9f4d-7b10-417a-9727-8d8656a095ea)
Confirma el guardado, agradece el uso de la aplicación y finaliza el programa
![image](https://github.com/user-attachments/assets/90fd6e2d-8f46-43c9-adc0-3df9fb3d6d0a)
El archivo conversiones.txt fue creado correctamente con la información sobre las conversiones realizadas
![image](https://github.com/user-attachments/assets/2ae55c85-db3b-44f4-b2ae-737d29b2f2d6)











Este `README.md` cubre la funcionalidad básica del proyecto. Si hay algún aspecto que te gustaría ampliar o modificar, no dudes en decírmelo.







