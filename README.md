
# Aplicación de Inicio de Sesión en Android con Firebase

Esta es una aplicación de Android que utiliza Firebase Authentication para gestionar el inicio de sesión y el registro de usuarios.

## Características

- Registro de usuarios utilizando email y contraseña.
- Inicio de sesión con credenciales de usuario.
- Interfaz para mostrar el email del usuario una vez que ha iniciado sesión.
- Funcionalidad para cerrar sesión.

## Configuración del Proyecto

1. **Configuración de Firebase:**
   - Debes crear un proyecto en Firebase y configurarlo para Android.
   - Descarga el archivo `google-services.json` proporcionado por Firebase y agrégalo al proyecto.

2. **Dependencias:**
   - Asegúrate de que las dependencias de Firebase estén incluidas en tu archivo `build.gradle`.

3. **MainActivity:**
   - Maneja la lógica para el registro e inicio de sesión de usuarios.
   - Cambia entre diferentes layouts dependiendo del estado del usuario (conectado o no conectado).

## Uso

- Al abrir la aplicación, el usuario podrá registrarse o iniciar sesión.
- Una vez autenticado, se mostrará el email del usuario y la opción de cerrar sesión.

## Nota Importante

- Reemplaza el archivo `google-services-example.json` con el `google-services.json` que obtienes de Firebase al registrar tu aplicación.