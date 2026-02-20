# Veterinary Clinic - Backend 🐾

API REST robusta y escalable diseñada para la gestión integral de una clínica veterinaria. Este proyecto demuestra habilidades avanzadas en arquitectura de software, modelado de datos y uso de las últimas versiones de Java y Spring Boot.

## 🚀 Tecnologías y Herramientas
* **Lenguaje:** Java 17 (Uso de Records, Streams API y Programación Funcional).
* **Framework:** Spring Boot 3.x (Spring Data JPA, Spring Web).
* **Base de Datos:** PostgreSQL con persistencia gestionada por Hibernate.
* **Infraestructura:** Docker & Docker Compose para la contenedorización de servicios.
* **Gestor de Dependencias:** Maven.

## 🏗️ Hitos Técnicos Destacables
* **Herencia Polimórfica:** Implementación de la estrategia `JOINED` para la gestión de especies (Dog/Cat), permitiendo atributos específicos y consultas eficientes.
* **Relaciones Avanzadas:** Uso de `@ManyToMany` con carga dinámica y filtrado de diagnósticos por especie mediante JPA Query Methods.
* **Arquitectura DTO:** Transferencia de datos segura y ligera utilizando Java 17 Records para desacoplar la API de las entidades de persistencia.
* **Integridad de Datos:** Gestión de transacciones con `@Transactional` para asegurar operaciones atómicas en la base de datos.

## 🛠️ Configuración del Entorno
1. Clonar el repositorio.
2. Asegurarse de tener Docker instalado.
3. Ejecutar `docker-compose up -d` para levantar la base de datos.
4. Ejecutar el proyecto desde IntelliJ o mediante `./mvnw spring-boot:run`.
5. La API estará disponible en `http://localhost:8081`.

---
Desarrollado con ❤️ por [Lorena SGC](https://github.com/lorenasgc)
