package biblioteca;
import java.util.*;

public class Almacenamiento {
	List<Libro> libros = new ArrayList<Libro>();
	
    public void agregarLibro(Libro libro) {
    	libros.add(libro);
    }
    
    public Iterator<Libro> iterador(Almacenamiento a){
    	Iterator<Libro> i = this.libros.iterator();
    	return i;
    }
    
    public ListIterator<Libro> iteradorLista(Almacenamiento a){
    	ListIterator<Libro> i = this.libros.listIterator();
    	return i;
    }
    
    public boolean buscarLibroPorTitulo(String libro) {
    	boolean encontrado = false;
    	Iterator<Libro> buscar_libro = this.iterador(this);
		while(buscar_libro.hasNext()) {
			Libro verificar = buscar_libro.next();
			if(verificar.titulo.equals(libro)) {
				encontrado = true;
				verificar.mostrarInformacion(verificar);
			}
		}
		if (!encontrado) {
			return false;
		}
		return true;
		
	}
    
    public boolean buscarLibroPorAutor(String libro) {
    	boolean encontrado = false;
    	Iterator<Libro> buscar_libro = this.iterador(this);
		while(buscar_libro.hasNext()) {
			Libro verificar = buscar_libro.next();
			if(verificar.autor.equals(libro)) {
				encontrado = true;
				verificar.mostrarInformacion(verificar);
			}
		}
		if (!encontrado) {
			return false;
		}
		return true;
	}
    
    public boolean buscarLibroPorCodigo(String libro) {
    	boolean encontrado = false;
    	Iterator<Libro> buscar_libro = this.iterador(this);
		while(buscar_libro.hasNext()) {
			Libro verificar = buscar_libro.next();
			if(verificar.ISBN.equals(libro)) {
				encontrado = true;
				verificar.mostrarInformacion(verificar);
			}
		}
		if (!encontrado) {
			return false;
		}
		return true;
	}
    
    public boolean editarLibro(String libro, String newTitulo, String newAutor, String newFecha, String newPaginas, String newEditorial, String newGenero, String newISBN, String newUbicacion, String newEstado, String newDescripcion) {
    	Regx corrector = new Regx();
    	boolean encontrado = false;
		ListIterator<Libro> editar_libro = this.iteradorLista(this);
		while(editar_libro.hasNext()) {
			Libro verificar = editar_libro.next();
			if(verificar.ISBN.equals(libro)) {
				encontrado = true;
				
				if (newTitulo.isEmpty()) {
					newTitulo = verificar.titulo;
				} else {
					if(!corrector.checkText(newTitulo)) {
						System.out.println("Titulo invalido (Solo letras, numeros y espacios), intente nuevamente");
						return false;
					}
				}
				
				if (newAutor.isEmpty()) {
					newAutor = verificar.autor;
				} else {
					if(!corrector.checkText(newAutor)) {
						System.out.println("Autor invalido (Solo letras, numeros y espacios), intente nuevamente");
						return false;
					}
				}
				
				if (newFecha.isEmpty()) {
					newFecha = verificar.fecha_edicion;
				} else {
					if(!corrector.checkFecha(newFecha)) {
						System.out.println("Fecha invalida, favor ingrese el formato correcto");
						return false;
					}
				}
				
				int newPaginasInt = 0;
				if (newPaginas.isEmpty()) {
					newPaginasInt = verificar.numero_paginas;
				} else {
					if(!corrector.checkNumero(newPaginas)) {
						System.out.println("Ingrese solo numeros, intente nuevamente");
						return false;
					}
					newPaginasInt = Integer.parseInt(newPaginas);
				}
				
				if (newEditorial.isEmpty()) {
					newEditorial = verificar.editorial;
				} else {
					if(!corrector.checkText(newEditorial)) {
						System.out.println("Editorial invalida (Solo letras, numeros y espacios), intente nuevamente");
						return false;
					}
				}
				
				if (newGenero.isEmpty()) {
					newGenero = verificar.genero;
				} else {
					System.out.println("Genero invalido (Solo letras, numeros y espacios), intente nuevamente");
					return false;
				}
				
				if (newISBN.isEmpty()) {
					newISBN = verificar.ISBN;
				} else {
					System.out.println("Codigo invalido (Debe ser solo 13 números), intente nuevamente");
					return false;
				}
				
				if (newUbicacion.isEmpty()) {
					newUbicacion = verificar.ubicacion;
				} else {
					System.out.println("Ubicación invalida (Solo letras, numeros y espacios), intente nuevamente");
					return false;
				}
				
				if (newEstado.isEmpty()) {
					newEstado = verificar.estado;
				} else {
					System.out.println("Estado invalido, favor de solo poner alguna de las opciones disponibles");
					return false;
				}
				
				if (newDescripcion.isEmpty()) {
					newDescripcion = verificar.descripcion;
				} else {
					System.out.println("Descripción invalida (Solo letras, numeros y espacios), intente nuevamente");
					return false;
				}
				
				editar_libro.set(new Libro(newTitulo, newAutor, newFecha, newPaginasInt, newEditorial, newGenero, newISBN, newUbicacion, newEstado, newDescripcion));
				System.out.println("Libro cambiado con exito");
				System.out.println("-------------------------");
			}
		}
		if (!encontrado) {
			return false;
		}
		return true;
    }
    
    
    public boolean borrarLibro(String libro) {
    	boolean encontrado = false;
    	Iterator<Libro> buscar_libro = this.iterador(this);
		while(buscar_libro.hasNext()) {
			Libro verificar = buscar_libro.next();
			if(verificar.ISBN.equals(libro)) {
				encontrado = true;
				buscar_libro.remove();
				System.out.println("Se ha borrado el libro con exito");
				System.out.println("--------------------------------");
				break;
			}
		}
		if (!encontrado) {
			return false;
		}
		return true;
    }
    
    public boolean estadoLibro(String libro, String newEstado) {
		boolean encontrado = false;
		ListIterator<Libro> editar_libro = this.iteradorLista(this);
		while(editar_libro.hasNext()) {
			Libro verificar = editar_libro.next();
			if(verificar.ISBN.equals(libro)) {
				encontrado = true;
				
				if (newEstado.isEmpty() || (!newEstado.equals("disponible") && !newEstado.equals("extraviado") && !newEstado.equals("prestado"))) {
					System.out.println("Ingrese un estado valido");
					System.out.println("------------------------");
					break;
				}
				
				verificar.cambiarEstado(newEstado);
				editar_libro.set(verificar);
				
				System.out.println("Se ha modificado el estado del libro con exito");
				System.out.println("----------------------------------------------");
				break;
			}
		}
		if (!encontrado) {
			return false;
		}
		return true;
    }
}
