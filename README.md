# Currency Conversion API

## Descripción

Currency Conversion API es una aplicación Java que permite a los usuarios convertir cantidades entre diferentes monedas utilizando tasas de cambio actualizadas. La aplicación se conecta a un API para obtener las tasas de conversión y permite a los usuarios seleccionar la moneda de origen y destino, así como la cantidad a convertir.

## Funcionalidades

- Convertir entre múltiples monedas.
- Obtener tasas de cambio actualizadas desde una API.
- Interfaz de línea de comandos sencilla y fácil de usar.
- Validación de entradas para una mejor experiencia de usuario.

## API de Tasas de Cambio

Esta aplicación utiliza la API [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener tasas de cambio en tiempo real. A continuación, se presentan algunos detalles sobre la API:

- **Endpoint para tasas de cambio**: `https://v6.exchangerate-api.com/v6/{API_KEY}/latest/USD`
    - Este endpoint devuelve tasas de cambio con respecto al dólar estadounidense (USD) como base.

- **Endpoint para códigos de moneda**: `https://v6.exchangerate-api.com/v6/{API_KEY}/codes`
    - Devuelve una lista de todos los códigos de moneda soportados junto con sus nombres.

### Estructura Modular de la Aplicación

La aplicación está organizada en diferentes módulos para facilitar su mantenimiento y escalabilidad:

1. **`api`**:
    - **Descripción**: Gestiona la comunicación con la API de ExchangeRate-API.
    - **Clase principal**: `CurrencyApiClient`
    - **Funcionalidad**: Obtiene tasas de cambio y códigos de moneda (`fetchExchangeRate`, `fetchCurrencyCodes`).

2. **`converter`**:
    - **Descripción**: Contiene la lógica para convertir monedas.
    - **Clase principal**: `CurrencyConverter`
    - **Funcionalidad**: Proporciona métodos para calcular tasas de conversión y realizar la conversión (`getConversionRate`, `convert`).

3. **`model`**:
    - **Descripción**: Modela las respuestas de la API.
    - **Clases principales**: `CurrencyRatesResponse`, `CurrencyCodesResponse`
    - **Funcionalidad**: Representa las tasas de conversión y códigos de moneda.

4. **`utils`**:
    - **Descripción**: Proporciona funciones auxiliares.
    - **Clase principal**: `ConsoleUtils`
    - **Funcionalidad**: Limpia la consola con el método `clearConsole`.

5. **`app`**:
    - **Descripción**: Punto de entrada de la aplicación.
    - **Clase principal**: `Main`
    - **Funcionalidad**: Gestiona el flujo principal de la aplicación, interacción con el usuario y ejecución de conversiones.


## Requisitos

- JDK 11 o superior.
- Apache Maven 3.0.0 para la gestión de dependencias (incluida en el proyecto).
- Dependencias de `Gson` para el manejo de JSON (incluida en el proyecto).

## Instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/OscarRGualdronV/Currency-Conversion-Api.git

## Ejecución

Una vez clonado el repositorio, sigue estos pasos para ejecutar la aplicación:

1. Navega al directorio del proyecto:
   ```bash
   cd Currency-Conversion-Api
   ```

2. Compila el proyecto con el siguiente comando:
   ```bash
   javac -d bin src/com/currencyconverter/app/Main.java
   ```

3. Ejecuta la aplicación desde el directorio `bin`:
   ```bash
   java com.currencyconverter.app.Main
   ```

## Configuración de la API

Para obtener tu clave de API de ExchangeRate-API:

1. Regístrate en [ExchangeRate-API](https://www.exchangerate-api.com/).
2. Crea una cuenta gratuita y obtén tu clave de API.
3. En el archivo `CurrencyApiClient.java`, reemplaza `{API_KEY}` con tu clave de API:
   ```java
   private static final String API_KEY = "Clave de API personal";
   ```

## Tareas futuras

- [ ] Añadir soporte para más monedas.
- [ ] Implementar conversión inversa (de destino a origen).
- [ ] Mejorar la interfaz de usuario.


## Licencia

Este proyecto está bajo la Licencia MIT. Para más información, consulta el archivo [LICENSE](./LICENSE).

