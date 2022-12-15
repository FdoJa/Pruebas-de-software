package biblioteca;
import java.util.regex.*;

public class Regx {
	Pattern formatTexto = Pattern.compile("^([a-zA-Z_0-9]+\s+)*[a-zA-Z_0-9]*$");
	Pattern formatFecha = Pattern.compile("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$");
	Pattern formatNumero = Pattern.compile("^[0-9]+$");
	Pattern formatCodigos = Pattern.compile("^[0-9]{13}$");
	
    public boolean checkText(String texto){
    	Matcher matcher = this.formatTexto.matcher(texto);
        boolean matches = matcher.matches();
    	return matches;
    }
    
    public boolean checkFecha(String texto) {
    	Matcher matcher = this.formatFecha.matcher(texto);
        boolean matches = matcher.matches();
    	return matches;
    }
    
    public boolean checkNumero(String texto) {
    	Matcher matcher = this.formatNumero.matcher(texto);
        boolean matches = matcher.matches();
    	return matches;
    }
    
    public boolean checkCodigos(String texto) {
    	Matcher matcher = this.formatCodigos.matcher(texto);
        boolean matches = matcher.matches();
    	return matches;
    }
    
    public boolean checkEstado(String texto) {
    	String a = "extraviado";
    	String b = "disponible";
    	String c = "prestado";
    	if (a.equals(texto) || b.equals(texto) || c.equals(texto)){
    		return true;
    	}
    	return false;
    }
}
