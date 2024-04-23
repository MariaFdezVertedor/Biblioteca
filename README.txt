# Sistema de Gestión de Biblioteca

Este proyecto es un sistema de gestión de préstamos de libros desarrollado en Java utilizando Hibernate y MySQL.

## Descripción

El proyecto de la biblioteca es un sistema de gestión de préstamos de libros que permite a los usuarios realizar operaciones como registrar nuevos lectores, agregar nuevos libros al catálogo, realizar préstamos de libros a los lectores y registrar la devolución de libros prestados.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación de alto nivel y orientado a objetos.
  
- **Hibernate**: Framework de mapeo objeto-relacional (ORM) para gestionar la persistencia de los objetos Java en la base de datos MySQL.

- **MySQL**: Sistema de gestión de bases de datos relacional de código abierto.

- **Maven**: Herramienta de gestión de dependencias y construcción de proyectos.

## Estructura del Proyecto

El proyecto está estructurado en paquetes que contienen clases relacionadas con diferentes aspectos de la aplicación:

- **Biblioteca**: Contiene las clases principales del dominio de la aplicación, como `Lector`, `Libro`, y `Prestamo`.
  
- **Servicio**: Contiene clases que proporcionan servicios relacionados con la lógica de negocio, como `ServicioPrestamo` y `ServicioConsultas`.
  
- **Util**: Contiene clases de utilidad, como `HibernateUtil`, que gestionan la configuración de Hibernate.

## Funcionalidades Principales

- **Registro de Lectores**: Permite registrar nuevos lectores en la biblioteca proporcionando su nombre, apellido y dirección de correo electrónico.

- **Registro de Libros**: Permite agregar nuevos libros al catálogo de la biblioteca especificando el título, autor, año de publicación y disponibilidad.

- **Préstamo de Libros**: Permite realizar préstamos de libros a los lectores registrados en la biblioteca. Registra la fecha de préstamo y la fecha de devolución prevista.

- **Devolución de Libros**: Permite registrar la devolución de libros prestados. Actualiza la fecha de devolución en el registro de préstamo correspondiente.

## Configuración

### Requisitos Previos

- JDK (Java Development Kit) instalado en tu sistema.
- Maven instalado en tu sistema.
- MySQL Server instalado y en funcionamiento.

### Configuración del Proyecto

1. Clona este repositorio a tu máquina local:

git clone https://github.com/MariaFdezVertedor/Biblioteca.git

2. Importa el proyecto en tu IDE como un proyecto Maven.

3. Configura la base de datos:
   - Crea una base de datos MySQL llamada bibliotecabbdd.
   - Ejecuta el script schema.sql ubicado en la carpeta src/main/resources para crear las tablas necesarias en la base de datos.

### Ejecución

1. Desde tu IDE, abre el proyecto e identifica la clase Main ubicada en el paquete Biblioteca.
2. Ejecuta la clase Main como una aplicación Java.
3. El proyecto se ejecutará y mostrará mensajes de salida en la consola. Podrás ver los préstamos, libros y lectores registrados en la biblioteca.
