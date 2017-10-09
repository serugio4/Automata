package utils;

public class NodoArbol {
	
	int dato;
	NodoArbol izq, der;
	String nombre;
	
	
	public NodoArbol(int dato, String nombre) {
		
		this.dato = dato;
		this.nombre = nombre;
		this.izq=null;
		this.der=null;
		
		
	}
	
	
	public String toString() {
		
		
		return nombre + " Su dato es "+ dato;
		
	}
	

}
