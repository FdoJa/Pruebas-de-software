package biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class bibliotecaTest {
	 
	@Test
	public void testCrearLibro() {
		Libro test = new Libro("It", "Stephen King", "07/08/1987", 1138, "Signet books", "Novela de terror", "9780451149510", "3er piso de la biblioteca", "disponible", "Libro de terror clasico");
		String mostrar = "Titulo: It, Autor: Stephen King, Fecha de edición: 07/08/1987, Paginas: 1138, Editorial: Signet books, Genero: Novela de terror, ISBN: 9780451149510, Ubicación: 3er piso de la biblioteca, Estado: disponible, Descripción: Libro de terror clasico";
		assertEquals(mostrar, test.verificarInformacion(test));
	}

	@Test
	public void testCambiarEstado() {
		Libro test = new Libro("It", "Stephen King", "07/08/1987", 1138, "Signet books", "Novela de terror","‎9780451149510", "3er piso de la biblioteca", "Disponible", "Libro de terror clasico");
		test.cambiarEstado("No disponible");
		assertEquals("No disponible", test.estado);
	}
	
	@Test
	
	// Crear o modificar los valores a valores que no sean permitidos generara fallos, los siguientes son el formato establecido -> 
	//		Texto solo con letras, numeros y espacios; 
	//		Codigo ISBN con su versión de 13 digitos;
	//		Cantidad de paginas como entero -> Dado que el constructor lo pide en entero no se puede probar error
	//		Fecha en formato DD/MM/AAAA		
	
	public void testCrearFalloLibro() {
		// Fecha escrita en otro formato
		Libro test1 = new Libro("It", "Stephen King", "07 de Agosto de 1987", 1138, "Signet books", "Novela de terror", "9780451149510", "3er piso de la biblioteca", "disponible", "Libro de terror clasico");
		String mostrar = "Titulo: null, Autor: null, Fecha de edición: null, Paginas: null, Editorial: null, Genero: null, ISBN: null, Ubicación: null, Estado: null, Descripción: null";
		assertEquals(mostrar, test1.verificarInformacion(test1));
		
		// Texto con acento
		Libro test2 = new Libro("Páyaso", "Stephen King", "07/08/1987", 1138, "Signet books", "Novela de terror", "9780451149510", "3er piso de la biblioteca", "disponible", "Libro de terror clasico");
		assertEquals(mostrar, test2.verificarInformacion(test2));
		
		// Letras extrañas
		Libro test3 = new Libro("@%$&/", "Stephen King", "07/08/1987", 1138, "Signet books", "Novela de terror", "9780451149510", "3er piso de la biblioteca", "disponible", "Libro de terror clasico");
		assertEquals(mostrar, test3.verificarInformacion(test3));
		
		// Codigo ISBN sin 13 digitos, con más digitos, o con caracteres
		Libro test4 = new Libro("It", "Stephen King", "07/08/1987", 1138, "Signet books", "Novela de terror", "9780", "3er piso de la biblioteca", "disponible", "Libro de terror clasico");
		Libro test5 = new Libro("It", "Stephen King", "07/08/1987", 1138, "Signet books", "Novela de terror", "97045114951011111111", "3er piso de la biblioteca", "disponible", "Libro de terror clasico");
		Libro test6 = new Libro("It", "Stephen King", "07/08/1987", 1138, "Signet books", "Novela de terror", "97A-1149510", "3er piso de la biblioteca", "disponible", "Libro de terror clasico");
		assertEquals(mostrar, test4.verificarInformacion(test4));
		assertEquals(mostrar, test5.verificarInformacion(test5));
		assertEquals(mostrar, test6.verificarInformacion(test6));
	}
	
	@Test
	public void testRegex() {
		Regx corrector = new Regx();
		// Sobre textos -> Deben tener solo letras, numeros o espacios, pero no un espacio en blanco
		assertEquals(true,corrector.checkText("libro"));
		assertEquals(true,corrector.checkText("libro bacan"));
		assertEquals(true,corrector.checkText("12345"));
		assertEquals(true,corrector.checkText("Libro 12345"));
		assertEquals(true,corrector.checkText("12345 Libro"));
		
		// Sobre estado -> Solo puede ser disponible, extraviado o prestado
		assertEquals(true,corrector.checkEstado("disponible"));
		assertEquals(true,corrector.checkEstado("extraviado"));
		assertEquals(true,corrector.checkEstado("prestado"));
		
		// Sobre fecha -> Tener formato DD/MM/AAAA o DD/MM/AA
		assertEquals(true,corrector.checkFecha("14/12/2022"));
		assertEquals(true,corrector.checkFecha("14/12/22"));
		assertEquals(true,corrector.checkFecha("01/01/0001"));
		
		// Sobre numeros -> Solo numeros
		assertEquals(true,corrector.checkNumero("123455"));
		
		// Sobre codigos -> String de 13 números
		assertEquals(true,corrector.checkCodigos("1234567891234"));
	}
	
	@Test
	public void testFailRegex() {
		Regx corrector = new Regx();
		
		// Sobre textos -> Deben tener solo letras, numeros o espacios
		assertEquals(false,corrector.checkText("líbró"));
		assertEquals(false,corrector.checkText("%@%!$%"));
		assertEquals(false,corrector.checkText(" "));
		
		// Estado:
		assertEquals(false,corrector.checkEstado("Disponible"));
		assertEquals(false,corrector.checkEstado("12345"));
		assertEquals(false,corrector.checkEstado("Algun otro estado"));
		
		// Fecha
		assertEquals(false,corrector.checkFecha("40/12/2022"));
		assertEquals(false,corrector.checkFecha("01/13/0001"));
		assertEquals(false,corrector.checkFecha("30 de diciembre de 2022"));
		
		// Numero
		assertEquals(false,corrector.checkNumero("texto con numeros 12345"));
		assertEquals(false,corrector.checkNumero("12345A"));
		assertEquals(false,corrector.checkNumero("1 2 3 4 5"));
		
		// Codigos
		assertEquals(false,corrector.checkCodigos("12345"));
		assertEquals(false,corrector.checkCodigos("ABCDE-12345"));
		assertEquals(false,corrector.checkCodigos("123-4567891234"));
	}
	
	@Test 
	public void testBuscarLibro() {
		Libro test1 = new Libro("It", "Stephen King", "07/08/1987", 1138, "Signet books", "Novela de terror", "9780451149510", "3er piso de la biblioteca", "disponible", "Libro de terror clasico");
		Libro test2 = new Libro("El resplandor", "Stephen King", "07/10/2021", 656, "DEBOLSILLO", "Novela de terror", "9878466357319", "2do piso de la biblioteca", "disponible", "Libro de terror clasico");
		Libro test3 = new Libro("1984", "George Orwell", "01/01/1961", 328, "Signet Classic", "Novela de ciencia ficcion", "9780451524935", "1er piso de la biblioteca", "extraviado", "Libro distopico");
		Libro test4 = new Libro("La llamada de Cthulhu", "HP Lovecraft", "22/05/2016", 36, "CreateSpace Independent Publishing Platforms", "Cuento de terror", "9781533390349", "2do piso de la biblioteca", "prestado", "Relato corto");
		Libro test5 = new Libro("Juego de tronos", "George RR Martin", "01/05/2012", 800, "Vintage Espanol", "Novela de fantasia", "9780307951182", "1er piso de la biblioteca", "prestado", "Novela en ambientacion medieval");
			
		Almacenamiento estante = new Almacenamiento();
		
		estante.agregarLibro(test5);
		estante.agregarLibro(test4);
		estante.agregarLibro(test3);
		estante.agregarLibro(test2);
		estante.agregarLibro(test1);
		
		// Exito en busqueda en biblioteca
		assertEquals(true,estante.buscarLibroPorAutor("George Orwell"));
		System.out.println("----------------------------------------------------------------");
		assertEquals(true,estante.buscarLibroPorAutor("Stephen King"));
		System.out.println("----------------------------------------------------------------");
		assertEquals(true,estante.buscarLibroPorTitulo("It"));
		System.out.println("----------------------------------------------------------------");
		assertEquals(true,estante.buscarLibroPorTitulo("Juego de tronos"));
		System.out.println("----------------------------------------------------------------");
		assertEquals(true,estante.buscarLibroPorCodigo("9780451149510"));
		System.out.println("----------------------------------------------------------------");
		assertEquals(true,estante.buscarLibroPorCodigo("9781533390349"));
		System.out.println("----------------------------------------------------------------");
		
		// No se encuentra en la biblioteca
		assertEquals(false,estante.buscarLibroPorAutor("Gabriela Mistral"));
		assertEquals(false,estante.buscarLibroPorAutor("hp lovecraft"));
		assertEquals(false,estante.buscarLibroPorTitulo("el resplandor"));
		assertEquals(false,estante.buscarLibroPorTitulo("Papelucho"));
		assertEquals(false,estante.buscarLibroPorCodigo("9780451149511"));
		assertEquals(false,estante.buscarLibroPorCodigo("9781533390340"));
	}
}
