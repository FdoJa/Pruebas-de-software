package biblioteca;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner i = new Scanner(System.in);
		Scanner s = new Scanner(System.in);
		int iterador;
		
		Almacenamiento estante = new Almacenamiento();
		Regx corrector = new Regx();
		
		Libro test1 = new Libro("It", "Stephen King", "07/08/1987", 1138, "Signet books", "Novela de terror", "9780451149510", "3er piso de la biblioteca", "disponible", "Libro de terror clasico");
		Libro test2 = new Libro("El resplandor", "Stephen King", "07/10/2021", 656, "DEBOLSILLO", "Novela de terror", "9878466357319", "2do piso de la biblioteca", "disponible", "Libro de terror clasico");
		Libro test3 = new Libro("1984", "George Orwell", "01/01/1961", 328, "Signet Classic", "Novela de ciencia ficcion", "9780451524935", "1er piso de la biblioteca", "extraviado", "Libro distopico");
		Libro test4 = new Libro("La llamada de Cthulhu", "HP Lovecraft", "22/05/2016", 36, "CreateSpace Independent Publishing Platforms", "Cuento de terror", "9781533390349", "2do piso de la biblioteca", "prestado", "Relato corto");
		Libro test5 = new Libro("Juego de tronos", "George RR Martin", "01/05/2012", 800, "Vintage Espanol", "Novela de fantasia", "9780307951182", "1er piso de la biblioteca", "prestado", "Novela en ambientacion medieval");
		
		estante.agregarLibro(test5);
		estante.agregarLibro(test4);
		estante.agregarLibro(test3);
		estante.agregarLibro(test2);
		estante.agregarLibro(test1);
		
		// Libros previos
		
		
		System.out.println("Bienvenido! Ingrese número de opción a usar:");
		do {
			System.out.println("1. Registrar un libro");
			System.out.println("2. Buscar un libro");
			System.out.println("3. Editar un libro");
			System.out.println("4. Eliminar un libro");
			System.out.println("5. Cambiar estado de un libro");
			System.out.println("6. Cerrar programa");
			iterador = i.nextInt();
			
			switch(iterador) {
				// Añadir libros
				case 1:
					System.out.println("Ingrese todos los datos para el registro");
					System.out.println("-> Titulo del libro: ");
					String titu = s.nextLine();
					if(!corrector.checkText(titu)) {
						System.out.println("Titulo invalido (Solo letras, numeros y espacios), intente nuevamente");
						break;
					}
					
					System.out.println("-> Autor del libro: ");
					String autor = s.nextLine();
					if(!corrector.checkText(autor)) {
						System.out.println("Autor invalido (Solo letras, numeros y espacios), intente nuevamente");
						break;
					}
					
					System.out.println("-> Fecha de edición (Formato DD/MM/AAAA)");
					String fecha = s.nextLine();
					if(!corrector.checkFecha(fecha)) {
						System.out.println("Fecha invalida, favor ingrese el formato correcto");
						break;
					}
					
					System.out.println("-> Número de paginas: ");
					String pag = s.nextLine();
					int pagInt = 0;
					if(!corrector.checkNumero(pag)) {
						System.out.println("Ingrese solo numeros, intente nuevamente");
						break;
					} else {
						pagInt = Integer.parseInt(pag);
					}
					
					System.out.println("-> Editorial: ");
					String edito = s.nextLine();
					if(!corrector.checkText(edito)) {
						System.out.println("Editorial invalida (Solo letras, numeros y espacios), intente nuevamente");
						break;
					}
					
					System.out.println("-> Genero: ");
					String gene = s.nextLine();
					if(!corrector.checkText(gene)) {
						System.out.println("Genero invalido (Solo letras, numeros y espacios), intente nuevamente");
						break;
					}
					
					System.out.println("-> ISBN (Codigo de barra): ");
					String codigo = s.nextLine();
					if(!corrector.checkCodigos(codigo)) {
						System.out.println("Codigo invalido (Debe ser solo 13 números), intente nuevamente");
						break;
					}
					
					System.out.println("-> Ubicación (Donde se encontraría en la biblioteca fisica): ");
					String ubi = s.nextLine();
					if(!corrector.checkText(ubi)) {
						System.out.println("Ubicación invalida (Solo letras, numeros y espacios), intente nuevamente");
						break;
					}
					
					System.out.println("-> Estado (prestado, disponible, extraviado): ");
					String estado = s.nextLine();
					if(!corrector.checkEstado(estado)) {
						System.out.println("Estado invalido, favor de solo poner alguna de las opciones disponibles");
						break;
					}
					
					System.out.println("-> Descripción del libro: ");
					String descrip = s.nextLine();
					if(!corrector.checkText(descrip)) {
						System.out.println("Descripción invalida (Solo letras, numeros y espacios), intente nuevamente");
						break;
					}
					
					Libro l = new Libro(titu, autor, fecha, pagInt, edito, gene, codigo, ubi, estado, descrip);
					estante.agregarLibro(l);
					System.out.println("Se ha agregado un libro con exito");
					System.out.println("---------------------------------");
				break;
				
				// Buscar libros
				case 2:
					System.out.println("Escriba el nombre del parametro por el que desea buscar: ");
					System.out.println("-> titulo");
					System.out.println("-> autor");
					System.out.println("-> ISBN");
					String buscar = s.nextLine();
					
					if (buscar.equals("titulo")){
						System.out.println("Ingrese el titulo del libro a buscar");
						buscar = s.nextLine();
						if(!estante.buscarLibroPorTitulo(buscar)) {
							System.out.println("No se ha encontrando ningún libro con las especificaciones dadas");
							System.out.println("----------------------------------------------------------------");
						}

						
					} else if (buscar.equals("autor")) {
						System.out.println("Ingrese el autor a buscar");
						buscar = s.nextLine();
						if(!estante.buscarLibroPorAutor(buscar)) {
							System.out.println("No se ha encontrando ningún libro con las especificaciones dadas");
							System.out.println("----------------------------------------------------------------");
						}
						
					} else if (buscar.equals("ISBN")) {
						System.out.println("Ingrese el ISBN (código de barra) del libro a buscar");
						buscar = s.nextLine();
						if(!estante.buscarLibroPorCodigo(buscar)) {
							System.out.println("No se ha encontrando ningún libro con las especificaciones dadas");
							System.out.println("----------------------------------------------------------------");
						}
					
					} else {
						System.out.println("Ingrese el nombre de un parámetro valido");
						System.out.println("----------------------------------------");
					}
				break;
				
				case 3:
					System.out.println("Indique el ISBN (código de barra) del libro a editar: ");
					buscar = s.nextLine();
					
					System.out.println("Ingrese datos a modificar (dejar vacio si es que no se quiere editar un parametro):");
					System.out.println("-> Titulo del libro: ");
					String newtitu = s.nextLine();
					
					System.out.println("-> Autor del libro: ");
					String newautor = s.nextLine();
					
					System.out.println("-> Fecha de edición");
					String newfecha = s.nextLine();
					
					System.out.println("-> Número de paginas: ");
					String pages = s.nextLine();

					
					System.out.println("-> Editorial: ");
					String newedito = s.nextLine();
					
					System.out.println("-> Genero: ");
					String newgene = s.nextLine();
					
					System.out.println("-> ISBN (Codigo de barra): ");
					String newcodigo = s.nextLine();
					
					System.out.println("-> Ubicación (Donde se encontraría en la biblioteca fisica): ");
					String newubi = s.nextLine();
					
					System.out.println("-> Estado (prestado, disponible, extraviado): ");
					String newestado = s.nextLine();
					
					System.out.println("-> Descripción del libro: ");
					String newdescrip = s.nextLine();
					
					if(!estante.editarLibro(buscar, newtitu, newautor, newfecha, pages, newedito, newgene, newcodigo, newubi, newestado, newdescrip)) {
						System.out.println("Ha ocurrido un error en la edición, verifique si los parámetros ingresados cumplen el formato o si el libro a editar existe");
						break;
					}
				break;
				
				// Borrar libro
				case 4:
					System.out.println("Indique el ISBN (código de barra) del libro a borrar: ");
					buscar = s.nextLine();
					if(!estante.borrarLibro(buscar)) {
						System.out.println("No se ha encontrado ningún libro con las especificaciones dadas, intente nuevamente");
						System.out.println("----------------------------------------------------------------");
					}
					
					
				break;
				
				// Cambiar estado
				case 5:
					System.out.println("Indique el ISBN (código de barra) del libro a cambiar el estado: ");
					buscar = s.nextLine();

					System.out.println("Ingrese el nuevo estado del libro (-> prestado, disponible, extraviado):");
					String newEstado = s.nextLine();
					if(!estante.estadoLibro(buscar, newEstado)) {
						System.out.println("No se ha encontrando ningún libro con las especificaciones dadas");
						System.out.println("----------------------------------------------------------------");
					}
				break;
				
				// Cerrar
				case 6:
					System.out.println("Cerrando la consola...");
				break;
				default:
					System.out.println("Ingrese una opción valida");
					
			}
		}while(iterador!=6);
		i.close();
		s.close();
		System.out.println("Adios!");
	}
}
