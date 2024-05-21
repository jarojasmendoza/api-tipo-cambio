# API Tipo Cambio

Esta es una API para calcular el tipo de cambio entre diferentes monedas.

## Requisitos

- Java JDK 17 o superior
- Maven
- Docker (opcional, para despliegue)

## Instalación y Ejecución

1. Clona este repositorio:

```bash
git clone https://github.com/jarojasmendoza/
```

2. Accede al directorio del proyecto:

```bash
cd api-tipo-cambio
```

3. Compila el proyecto con Maven:

```bash
mvn clean package
```

4. Ejecuta la aplicación:

```bash
java -jar target/api-tipo-cambio-0.0.1-SNAPSHOT.jar
```

La aplicación estará disponible en [http://localhost:8080](http://localhost:8080).

## Uso

### Endpoint para listar cambios

```
GET /listar
```

Este endpoint devuelve una lista de cambios de moneda.

### Endpoint para realizar un cambio

```
POST /cambiar
```

Este endpoint realiza un cambio de moneda basado en la solicitud proporcionada.
```json
{
  "monto" : 10,
  "monedaOrigen":"USD",
  "monedaDestino":"PEN"
}
```
## Docker

Si prefieres ejecutar la aplicación en un contenedor Docker, puedes construir la imagen y ejecutar el contenedor con los siguientes comandos:

```bash
docker build -t api-tipo-cambio .
docker run -p 8080:8080 api-tipo-cambio
```
