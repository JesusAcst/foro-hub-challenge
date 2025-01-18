# Foro Hub (API REST) - Challenge Alura

Foro Hub es una API REST desarrollada con **Spring Boot** para gestionar tópicos en un foro de discusión. Esta API permite crear, actualizar, eliminar y consultar tópicos, además de incluir autenticación y autorización para restringir el acceso a la información.


## Características

La API proporciona las siguientes funcionalidades:

- **Crear un nuevo tópico**: Permite crear un tópico proporcionando un título, mensaje, autor y curso.
- **Mostrar todos los tópicos**: Visualiza todos los tópicos disponibles en el foro.
- **Mostrar un tópico específico**: Consulta un tópico específico mediante su identificador único.
- **Actualizar un tópico**: Modifica los datos de un tópico existente.
- **Eliminar un tópico**: Elimina un tópico de la base de datos.

---

## Tecnologías Utilizadas

- **Java 17** (o superior)
- **Spring Boot** 2.x
- **Maven** 4.x
- **MySQL** 8.x
- **Spring Data JPA** para gestión de base de datos
- **Spring Security** para autenticación y autorización
- **Flyway Migration** para gestión de migraciones de base de datos
- **Lombok** para reducción de código repetitivo
- **Spring Web** para creación de servicios REST

---

## Diagrama de Base de Datos

La base de datos está compuesta principalmente por la tabla `topicos`, que almacena la información de los tópicos. La estructura de la tabla es la siguiente:


### Tabla: `topicos`

| Campo            | Tipo        | Descripción                             |
|------------------|-------------|-----------------------------------------|
| `id`             | INT         | Identificador único del tópico (PK)     |
| `titulo`         | VARCHAR(255)| Título del tópico                      |
| `mensaje`        | TEXT        | Contenido del tópico                    |
| `fecha_creacion` | DATETIME    | Fecha de creación del tópico            |
| `status`         | VARCHAR(50) | Estado del tópico (e.g., "activo")      |
| `autor`          | VARCHAR(255)| Nombre del autor                        |
| `curso`          | VARCHAR(255)| Curso asociado al tópico                |

---

## Endpoints

### 1. **Crear un nuevo tópico**
`POST /api/topicos`  
Crea un nuevo tópico proporcionando los siguientes datos en el cuerpo de la solicitud:

**Request Body:**
```json
{
  "titulo": "Nuevo Tópico",
  "mensaje": "Este es un mensaje de prueba",
  "autor": "Jesus Acosta",
  "curso": "Desarrollo Web"
}
````

### 2. **Mostrar todos los tópicos**
`GET /api/topicos`  
Obtiene todos los tópicos disponibles en el foro.

**Respuesta ejemplo:**
```json
[
  {
    "id": 1,
    "titulo": "Tópico A",
    "mensaje": "Este es un mensaje de prueba",
    "fecha_creacion": "2025-01-18T10:00:00",
    "status": "activo",
    "autor": "Juan Pérez",
    "curso": "Desarrollo Web"
  },
  {
    "id": 2,
    "titulo": "Tópico B",
    "mensaje": "Discusión sobre Spring Boot y sus ventajas.",
    "fecha_creacion": "2025-01-18T11:00:00",
    "status": "activo",
    "autor": "Ana Gómez",
    "curso": "Java avanzado"
  }
]
````

### 3. **Mostrar tópico específico**
`GET /api/topicos/{id}`  

Obtiene un tópico específico por su id.

**Respuesta ejemplo:**
```json
{
  "id": 1,
  "titulo": "Nuevo Tópico",
  "mensaje": "Este es un mensaje de prueba",
  "fecha_creacion": "2025-01-18T10:00:00",
  "status": "activo",
  "autor": "Juan Pérez",
  "curso": "Desarrollo Web"
}
````

### 4. **Actualizar topico**
`PUT /api/topicos/{id}`
Actualiza los detalles de un tópico específico.

**Request Body:**
```json
{
  "titulo": "Tópico actualizado",
  "mensaje": "Contenido actualizado",
  "autor": "Carlos López",
  "curso": "Bases de Datos"
}
````
**Respuesta ejemplo::**
```json
{
"id": 1,
"titulo": "Tópico actualizado",
"mensaje": "Contenido actualizado",
"fecha_creacion": "2025-01-18T10:00:00",
"status": "activo",
"autor": "Carlos López",
"curso": "Bases de Datos"
}
````

### 5. **Eliminar tópico**
`DELETE /api/topicos/{id}`
Elimina un tópico de la base de datos.

**Respuesta ejemplo:**
```json
{
  "message": "Tópico eliminado con éxito"
}
````


