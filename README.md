# Moneda_Conversor

Moneda_Conversor es una herramienta simple pero útil que te permite conocer las tasas de cambio entre diferentes monedas del mundo. Utilizando la API de ExchangeRate-API, este programa te muestra las monedas disponibles y calcula la tasa de cambio entre dos monedas que elijas.

## Características

* **Muestra monedas disponibles:** Te proporciona una lista completa de las monedas soportadas por la API de ExchangeRate-API.
* **Conversión de monedas:** Te permite ingresar una moneda base y una moneda objetivo para obtener la tasa de cambio actual entre ellas.

## Tecnologías Utilizadas

* **Java:** Lenguaje de programación principal.
* **Gson:** Biblioteca para parsear y trabajar con datos en formato JSON.
* **API de ExchangeRate-API:** Proporciona los datos actualizados de las tasas de cambio.

## Instrucciones de Uso

1. **Obtener una API Key:**
   - Regístrate en la página de ExchangeRate-API: https://www.exchangerate-api.com/
   - Obtén tu API Key personal.

2. **Configurar el archivo de configuración:**
   - Renombra el archivo `config.properties.example` a `config.properties`.
   - Abre `config.properties` y reemplaza `TU_API_KEY` con tu API Key obtenida en el paso anterior.

3. **Ejecutar el programa:**
   - Asegúrate de tener Java instalado en tu sistema.
   - Abre una terminal o línea de comandos.
   - Navega hasta el directorio donde se encuentra el programa.
   - Ejecuta el siguiente comando:

     ```bash
     java Main
     ```

4. **Interactuar con el programa:**
   - El programa mostrará una lista de las monedas disponibles.
   - Ingresa el código de la moneda base (por ejemplo, USD).
   - Ingresa el código de la moneda objetivo.
   - El programa mostrará la tasa de cambio entre las dos monedas.

## Requisitos

* **Java:** Debes tener instalado el entorno de ejecución de Java (JRE) en tu sistema.
* **Archivo de configuración:** Necesitas tener un archivo `config.properties` válido con tu API Key.
