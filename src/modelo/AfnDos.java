package modelo;

import java.util.ArrayList;

public class AfnDos {
	private ArbolNode arbol;
	private boolean estado;
	
//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//
//	AfnDos a= new AfnDos();
//	try{
//		System.out.println(a.leerCadena("aaabaa", a.crearArbol(new ArbolNode("q0")).getPadre()));
//	} catch (IllegalAccessException e) {
//		// TODO Auto-generated catch block
//		System.out.println("Acabo en aceptacion");
//	}
//
//}

	public ArbolNode crearArbol(ArbolNode node) {

		this.arbol = node;
		ArrayList<ArbolNode> listaHijos;

		if(arbol.getNombre().equalsIgnoreCase("q0")){
			arbol.addHijos(new ArbolNode("q2"));
			arbol.addHijos(new ArbolNode("q3"));
			arbol.addHijos(new ArbolNode("q4"));
			arbol.addHijos(new ArbolNode("q1"));
			listaHijos = arbol.getHijos();
			for (int i = 0; i < listaHijos.size(); i++) {				
				crearArbol(listaHijos.get(i));				
			}
		}
		else if (arbol.getNombre().equalsIgnoreCase("q1")){
			arbol.addHijos(new ArbolNode("q2"));
		}
		else if (arbol.getNombre().equalsIgnoreCase("q2")){
			arbol.addHijos(new ArbolNode("q1"));
		}
		else if (arbol.getNombre().equalsIgnoreCase("q3")){	
			arbol.addHijos(new ArbolNode("q4"));
		}
		else if (arbol.getNombre().equalsIgnoreCase("q4")){
			arbol.addHijos(new ArbolNode("q3"));
		}

		return arbol;


	}

	public boolean leerCadena(String cadena, ArbolNode arbol) throws IllegalAccessException{

		if(!cadena.equalsIgnoreCase("")){

			if(arbol.getNombre().equalsIgnoreCase("q0") && cadena.charAt(0) == 'a'){				
				estado = true;
				System.out.println("q0 -> q2 "+  cadena.charAt(0)+ ", " + estado);
				leerCadena(cadena.substring(1), arbol.getHijos().get(0));

			}	

			if(arbol.getNombre().equalsIgnoreCase("q0") && cadena.charAt(0) == 'a' ){
				estado = true;
				System.out.println("q0 -> q3 "+  cadena.charAt(0)+ ", " + estado);
				leerCadena(cadena.substring(1), arbol.getHijos().get(1));

			}
			if(arbol.getNombre().equalsIgnoreCase("q0") && cadena.charAt(0) == 'b' ){
				estado = false;
				System.out.println("q0 -> q4 "+  cadena.charAt(0)+ ", " + estado);
				leerCadena(cadena.substring(1), arbol.getHijos().get(2));

			}
			if(arbol.getNombre().equalsIgnoreCase("q0") && cadena.charAt(0) == 'b' ){
				estado = false;
				System.out.println("q0 -> q1 "+  cadena.charAt(0)+ ", " + estado);
				leerCadena(cadena.substring(1), arbol.getHijos().get(3));

			}
			if(arbol.getNombre().equalsIgnoreCase("q2") && cadena.charAt(0) == 'b' ){
				estado = true;
				System.out.println("q2 -> q2 "+ cadena.charAt(0) + ", " + estado);
				leerCadena(cadena.substring(1), arbol);
				if(estado == true && cadena.substring(1).equalsIgnoreCase("")){
					System.out.println("Estado: " +  estado);
					throw new IllegalAccessException();
				}

			}
			if(arbol.getNombre().equalsIgnoreCase("q2") && cadena.charAt(0) == 'a' ){
				estado = false;
				System.out.println("q2 -> q1 " + cadena.charAt(0)+ ", " + estado);
				leerCadena(cadena.substring(1), arbol.getHijos().get(0));

			}
			if(arbol.getNombre().equalsIgnoreCase("q1") && cadena.charAt(0) == 'a' ){
				estado = true;
				System.out.println("q1 -> q2 " + cadena.charAt(0)+ ", " + estado);
				leerCadena(cadena.substring(1), arbol.getPadre());
				if(estado == true && cadena.substring(1).equalsIgnoreCase("")){
					System.out.println("Estado: " +  estado);
					throw new IllegalAccessException();
				}
			}
			if(arbol.getNombre().equalsIgnoreCase("q1") && cadena.charAt(0) == 'b' ){
				estado = false;
				System.out.println("q1 -> q1 " + cadena.charAt(0)+ ", " + estado);
				leerCadena(cadena.substring(1), arbol);
			}
			if(arbol.getNombre().equalsIgnoreCase("q3") && cadena.charAt(0) == 'a' ){
				estado = true;
				System.out.println("q3 -> q3 " + cadena.charAt(0)+ ", " + estado);
				leerCadena(cadena.substring(1), arbol);
				if(estado == true && cadena.substring(1).equalsIgnoreCase("")){
					System.out.println("Estado: " +  estado);
					throw new IllegalAccessException();
				}
			}
			if(arbol.getNombre().equalsIgnoreCase("q3") && cadena.charAt(0) == 'b' ){
				estado = false;
				System.out.println("q3 -> q4 " + cadena.charAt(0)+ ", " + estado);
				leerCadena(cadena.substring(1), arbol.getHijos().get(0));
			}
			if(arbol.getNombre().equalsIgnoreCase("q4") && cadena.charAt(0) == 'a' ){
				estado = false;
				System.out.println("q4 -> q4 " + cadena.charAt(0)+ ", " + estado);
				leerCadena(cadena.substring(1), arbol);
			}
			if(arbol.getNombre().equalsIgnoreCase("q4") && cadena.charAt(0) == 'b' ){
				estado = true;
				System.out.println("q4 -> q3  " + cadena.charAt(0)+ ", " + estado);
				leerCadena(cadena.substring(1), arbol.getPadre());
				if(estado == true && cadena.substring(1).equalsIgnoreCase("")){
					System.out.println("Estado: " +  estado);
					throw new IllegalAccessException();
				}
			}

			if (cadena.charAt(0)!='a' && cadena.charAt(0)!='b'){
				estado = false;
				System.out.println("El caracter "+ cadena.charAt(0) + " No pertenece al alfabeto");
			}
		}

		return estado;

	}
	
	public boolean getEstado(){
		return this.estado;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	


}


