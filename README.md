# SimpleWeatherApp ☁️

Una aplicación Android sencilla para consultar el clima en tiempo real utilizando la API de [WeatherAPI](https://www.weatherapi.com/).

## 🚀 Características

*   **Búsqueda por Ciudad:** Ingresa el nombre de cualquier ciudad del mundo para obtener información meteorológica instantánea.
*   **Información en Tiempo Real:** Visualiza la temperatura actual en grados Celsius.
*   **Estado del Clima:** Muestra una descripción textual (ej. "Sunny", "Cloudy") y un icono representativo del estado actual.
*   **Datos Adicionales:** Información sobre la humedad ambiental.
*   **Interfaz Moderna:** Construida con Material Design y componentes de Jetpack.

## 🛠️ Stack Tecnológico

*   **Lenguaje:** Kotlin
*   **Networking:** [Retrofit 2](https://square.github.io/retrofit/) para el consumo de la API REST.
*   **JSON Parsing:** [Gson](https://github.com/google/gson) para la serialización de datos.
*   **Coroutines:** Para realizar peticiones de red de forma asíncrona sin bloquear el hilo principal.
*   **Image Loading:** [Coil](https://coil-kt.github.io/coil/) para la carga eficiente de iconos meteorológicos desde URL.
*   **UI Components:**
    *   View Binding para la vinculación de vistas.
    *   Navigation Component para la gestión de fragmentos.
    *   ConstraintLayout para diseños flexibles.
*   **Arquitectura:** Basada en Fragmentos y ciclo de vida de Android.

## 📦 Instalación y Configuración

1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/tu-usuario/SimpleWeatherApp.git
    ```
2.  **Obtener una API Key:**
    *   Regístrate en [WeatherAPI.com](https://www.weatherapi.com/) para obtener una clave gratuita.
3.  **Configurar la API Key en el código:**
    *   Abre el archivo `app/src/main/java/com/example/simpleweatherapp/FirstFragment.kt`.
    *   Busca la variable `apiKey` y reemplaza el valor con tu clave:
        ```kotlin
        private val apiKey = "TU_API_KEY_AQUI"
        ```
4.  **Compilar y Ejecutar:**
    *   Abre el proyecto en Android Studio.
    *   Sincroniza el proyecto con los archivos Gradle.
    *   Ejecuta la aplicación en un emulador o dispositivo físico con conexión a Internet.

## 📄 Estructura del Proyecto

*   `WeatherModels.kt`: Define las clases de datos que representan la respuesta JSON de la API.
*   `WeatherService.kt`: Interfaz de Retrofit que define el endpoint `current.json`.
*   `FirstFragment.kt`: Contiene la lógica principal de búsqueda, llamada a la API y actualización de la interfaz de usuario.
*   `fragment_first.xml`: Diseño de la pantalla principal con búsqueda y visualización de datos.

## 🛑 Requisitos

*   Android Studio Ladybug (o superior).
*   SDK de Android nivel 24 (mínimo).
*   Conexión a Internet activa.

---
Desarrollado como una práctica de desarrollo Android
