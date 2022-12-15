Tarea módulo de registro biblioteca
* **Nombre**: Fernando Delgado - Rol: 201804571-3

* **Descripción**: Proyecto para el guardado de información sobre libros, para ello es posible guardar los datos acerca de su: Título, autor, fecha edición, número de páginas, editorial, género, ISBN ((International Standard Book Number), ubicación (piso de biblioteca, número de pasillos, estante, posición (x,y)), estado (Prestado, disponible, extraviado), descripción.

Para ello se utiliza un archivo Regex que permite validar las entradas, donde se tienen distintas opciones para ciertos parámetros:
  * Parámetro tipo texto (Título, autor, editorial, género, ubicación, descripción): Solamente se pueden utilizar caracteres (Letras mayúsculas o minúsculas desde la a-z), números y espacios. Destacando que no se puede realizar una entrada en blanco tipo " ".
  * Parámetro tipo "Fecha": Para la fecha de edición, se elige el formato de fecha DD/MM/AAAA, o de otra forma DD/MM/AA.
  * Parámetro tipo "Páginas": Solo son aceptables números.
  * Parámetro tipo "Código": Para el ISBN del libro, se elige el formato de 13 dígitos. Por lo cual es obligatorio colocar una entrada de exactamente esa cantidad de dígitos.
  * Parámetro tipo "Estado": Se define que solamente existen las opciones posibles a colocar de -> prestado, disponible, extraviado. Cualquier otra será rechazada.

El proyecto ofrece ciertas funciones para su manejo por el usuario, siendo estas las siguientes:
  * Agregar/registrar un libro
  * Buscar un libro por su título, autor o ISBN.
  * Editar un libro
  * Eliminar un registre de un libro
  * Cambiar el estado de un libro

**Instalación**: Código en JAVA el cual debe ser ejecutado, abrir en un IDLE (Preferentemente Eclipse dado que se desarrolla en este) y ejecutar "Main.java" para acceder a la terminal y utilizar el programa. En caso de querer verificar los casos de prueba, ejecutar archivo "bibliotecaTest.java".

* **Cómo usar**:
  * Se debe correr el programa. Al iniciar, en la consola se le especificará al usuario las cosas que puede realizar, teniendo que ingresar un número por consola asociado a la opción que se quiere usar.
  * Luego seguir instrucciones de cada opción. NOTA: Fijarse bien en lo que se pide en cada opción y como es el formato adecuado dado que se debe respetar las mayúsculas. En el caso de haber elegido "buscar un libro" luego la consola le pedirá ingresar el nombre del parámetro a buscar. Ej: Si quiere buscar por ISBN, debe escribir "ISBN" e ingresarlo. Para el caso de título escribir "titulo" sin mayúsculas.

* **Cómo contribuir**:
  * El programa utiliza Regex para fijarse en la corrección del ingreso de parámetros, quizás otra idea para fijarse mejor en los casos de uso de la clase de "libro" y "almacenamiento" sería el realizar la corrección aquí.
 
* **Licencia**: None
