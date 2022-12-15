package biblioteca;

public class Libro {
	String titulo; 
    String autor;
    String fecha_edicion;
    Integer numero_paginas = null;
    String editorial;
    String genero;
    String ISBN;
    String ubicacion;
    String estado;
    String descripcion;
    
    Regx corrector = new Regx();
    
    Libro(String newTitulo, String newAutor, String newFecha, int newPaginas, String newEditorial, String newGenero, String newISBN, String newUbicacion, String newEstado, String newDescripcion){
    	if(corrector.checkText(newTitulo) && corrector.checkText(newAutor) && corrector.checkFecha(newFecha) && corrector.checkText(newEditorial) && corrector.checkText(newGenero) && corrector.checkCodigos(newISBN) && corrector.checkText(newUbicacion) && corrector.checkEstado(newEstado) && corrector.checkText(newDescripcion)){
    		titulo = newTitulo;
    		autor = newAutor;
    		fecha_edicion = newFecha;
    		numero_paginas = newPaginas;
    		editorial = newEditorial;
    		genero = newGenero;  	
    		ISBN = newISBN;
    		ubicacion = newUbicacion;
    		estado = newEstado;
    		descripcion = newDescripcion;
    	}
    }
    
    public String verificarInformacion(Libro libro) {
    	return "Titulo: " + this.titulo + ", Autor: " + this.autor + ", Fecha de edición: " + this.fecha_edicion + ", Paginas: " + this.numero_paginas + ", Editorial: " + this.editorial + ", Genero: " + this.genero + ", ISBN: " + this.ISBN + ", Ubicación: " + this.ubicacion + ", Estado: " + this.estado + ", Descripción: " + this.descripcion;
    }

    public void mostrarInformacion(Libro libro){
    	System.out.println("Titulo: " + this.titulo + ", Autor: " + this.autor + ", Fecha de edición: " + this.fecha_edicion + ", Paginas: " + this.numero_paginas + ", Editorial: " + this.editorial + ", Genero: " + this.genero + ", ISBN: " + this.ISBN + ", Ubicación: " + this.ubicacion + ", Estado: " + this.estado + ", Descripción: " + this.descripcion);
    }
    
    public void cambiarEstado(String newEstado) {
    	this.estado = newEstado;
    }
}
