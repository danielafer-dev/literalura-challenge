Literalura 

Este programa es un catálogo de libros que hice para practicar cómo conectar Java con una base de datos y cómo traer información de internet.

¿Qué hace la aplicación?
Busca libros por nombre: Escribes el título de un libro y el programa lo busca en una página llamada "Gutendex".

Guarda lo que encuentras: Si el libro existe, el programa guarda automáticamente los datos del libro y del autor en tu propia base de datos.

Evita repetidos: Está configurado para que no se guarde el mismo autor dos veces por error.

Filtra por idioma: Puedes pedirle al programa que te muestre solo los libros que están en español, inglés u otros idiomas que configuré.

¿Cómo está hecho?
Java y Spring Boot: Es el motor principal que hace que todo funcione.

Base de Datos: Usa JPA para que sea muy fácil guardar y leer la información de las tablas de "obras" y "escritores".

Lectura de datos (JSON): Uso unas herramientas llamadas "Records" y anotaciones de Jackson para que el programa entienda la información que nos manda la web de libros.


Cómo usarlo
Revisa que tu base de datos esté conectada en el archivo application.properties.

Dale a "Run" en el archivo LiteraluraApplication.java.

Se abrirá un menú en la parte de abajo de tu pantalla (la consola) y solo tienes que seguir las opciones.
