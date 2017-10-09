package modelo;

import java.util.ArrayList;

public class Afn {
	
	ArbolNode arbol;
	private boolean estado;
	private String errorCadena;
	
	
	

	public Afn() {
		
		errorCadena ="";
		
	}
		
	
	public ArbolNode crearArbol(ArbolNode node) {

		this.arbol = node;
		ArrayList<ArbolNode> listaHijos;
		
		if(arbol.getNombre().equalsIgnoreCase("q0")){
			arbol.addHijos(new ArbolNode("q1"));
			listaHijos = arbol.getHijos();
			System.out.println("Cree raiz y agrege q1");
			for (int i = 0; i < listaHijos.size(); i++) {				
				crearArbol(listaHijos.get(i));				
			}
		}
		else if (arbol.getNombre().equalsIgnoreCase("q1")){
			arbol.addHijos(new ArbolNode("q2"));
			System.out.println("Cree q2 en q1");
			
		}
		
		return arbol;
		
	}
	
	public boolean leerCadena(String cadena, ArbolNode arbol){


		if(!cadena.equalsIgnoreCase("")){

			if(arbol.getNombre().equalsIgnoreCase("q0") && (cadena.charAt(0) == 'a' ||
					cadena.charAt(0) == 'c' || cadena.charAt(0)=='b') ){

				System.out.println("Estoy en q0 para leer "+  cadena.charAt(0));
				estado = false;
				leerCadena(cadena.substring(1), arbol);			

			}	

			if(arbol.getNombre().equalsIgnoreCase("q0") && cadena.charAt(0) == 'b' ){
				System.out.println("Estoy en q0 para leer " + cadena.charAt(0));
				estado = false;
				leerCadena(cadena.substring(1), arbol.getHijos().get(0));

			}
			if(arbol.getNombre().equalsIgnoreCase("q1") && cadena.charAt(0) == 'a' ){
				System.out.println("Estoy en q1 para leer " + cadena.charAt(0));
				estado = false;
				leerCadena(cadena.substring(1), arbol.getPadre());

			}
			if(arbol.getNombre().equalsIgnoreCase("q1") && cadena.charAt(0) == 'b' ){
				System.out.println("Estoy en q1 para leer "+ cadena.charAt(0));
				estado = false;
				leerCadena(cadena.substring(1), arbol);

			}
			if(arbol.getNombre().equalsIgnoreCase("q1") && cadena.charAt(0) == 'c' ){
				System.out.println("Estoy en q1 para leer " + cadena.charAt(0));
				estado = true;
				leerCadena(cadena.substring(1), arbol.getHijos().get(0));

			}

			if(arbol.getNombre().equalsIgnoreCase("q2") && (cadena.charAt(0) == 'a' ||
					cadena.charAt(0) == 'c' || cadena.charAt(0) == 'b') ){

				estado = true;
				System.out.println("Estoy en q2 para leer " + cadena.charAt(0));
				leerCadena(cadena.substring(1), arbol);


			}
			else if (cadena.charAt(0)!='a' && cadena.charAt(0)!='b' &&  cadena.charAt(0)!='c'){
				estado = false;
				errorCadena="El caracter '"+ cadena.charAt(0)+ "' No pertenece al alfabeto";
				
			}
		}

		return estado;
	}
	
	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public String getErrorCadena() {
		return errorCadena;
	}


	public void setErrorCadena(String errorCadena) {
		this.errorCadena = errorCadena;
	}

	

}
