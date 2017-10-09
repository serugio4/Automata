package modelo;

import java.util.ArrayList;

public class Lamda {

	ArbolNode arbol;
	boolean estado;


//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Lamda l= new Lamda();
//		try{
//			System.out.println(l.leerCadena("aaabaaa", l.crearArbol(new ArbolNode("q0")).getPadre()));
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Acabo en aceptacion");
//		}
//
//	}

	public ArbolNode crearArbol(ArbolNode node) {

		this.arbol = node;
		ArrayList<ArbolNode> listaHijos;

		if(arbol.getNombre().equalsIgnoreCase("q0")){
			arbol.addHijos(new ArbolNode("q1"));
			arbol.addHijos(new ArbolNode("q2"));
			listaHijos = arbol.getHijos();
			for (int i = 0; i < listaHijos.size(); i++) {				
				crearArbol(listaHijos.get(i));				
			}
		}
		else if (arbol.getNombre().equalsIgnoreCase("q1")){
			arbol.addHijos(new ArbolNode("q3"));
		}


		return arbol;


	}

	public boolean leerCadena(String cadena, ArbolNode arbol) throws IllegalAccessException{

		if(!cadena.equalsIgnoreCase("")){

			if(arbol.getNombre().equalsIgnoreCase("q0") && 
					(cadena.charAt(0) == 'a' || cadena.charAt(0)=='b')){				
				estado = false;
				System.out.println("q0 -> q1 con "+  cadena.charAt(0) + ", " + estado);
				leerCadena(cadena.substring(1), arbol.getHijos().get(0));

			}
			if(arbol.getNombre().equalsIgnoreCase("q0") && 
					(cadena.charAt(0) == 'a' || cadena.charAt(0)=='b')){				
				estado = false;
				System.out.println("q0 -> q2 con "+  cadena.charAt(0) + ", " + estado);
				leerCadena(cadena.substring(1), arbol.getHijos().get(1));

			}
			if(arbol.getNombre().equalsIgnoreCase("q1")){
				estado = true;
				System.out.println("q1 -> q3 con "+ "Lamda" + ", " + estado);
				leerCadena(cadena, arbol.getHijos().get(0));
			}
			if(arbol.getNombre().equalsIgnoreCase("q1") && cadena.charAt(0) == 'a' ){
				estado = false;
				System.out.println("q1 -> q2 con "+  cadena.charAt(0)+ ", " + estado);
				leerCadena(cadena.substring(1), arbol.getPadre().getHijos().get(1));

			}
			if(arbol.getNombre().equalsIgnoreCase("q2")){
				estado = false;
				System.out.println("q2 -> q1 con " +"Lamda"+ ", " + estado);
				leerCadena(cadena, arbol.getPadre().getHijos().get(0));

			}
			if(arbol.getNombre().equalsIgnoreCase("q2") && cadena.charAt(0) == 'b' ){
				estado = true;
				System.out.println("q2 -> q3  con "+ cadena.charAt(0) + ", " + estado);
				if(estado == true && cadena.substring(1).equalsIgnoreCase("")){
					System.out.println("Estado: " +  estado);					
					throw new IllegalAccessException();
				}
				leerCadena(cadena.substring(1), arbol.getPadre().getHijos().get(0).getHijos().get(0));
			}

			if(arbol.getNombre().equalsIgnoreCase("q3") && cadena.charAt(0) == 'a' ){
				if(estado == true && cadena.substring(1).equalsIgnoreCase("")){
					System.out.println("Estado: " +  estado);					
					throw new IllegalAccessException();
				}
				estado = false;
				System.out.println("q3 -> q1 con " + cadena.charAt(0)+ ", " + estado);
				leerCadena(cadena.substring(1), arbol.getPadre());
				
			}
			if(arbol.getNombre().equalsIgnoreCase("q3") && cadena.charAt(0) == 'b' ){
				estado = false;
				return estado;
				
			}
			if (cadena.charAt(0)!='a' && cadena.charAt(0)!='b'){
				estado = false;
				System.out.println("El caracter "+ cadena.charAt(0)+ " No pertenece al alfabeto");
			}
		}
		if(arbol.getNombre().equalsIgnoreCase("q2")){
			estado = false;
			System.out.println("q2 -> q1 con " +"Lamda"+ ", " + estado);
			leerCadena(cadena, arbol.getPadre().getHijos().get(0));
		}
		if(arbol.getNombre().equalsIgnoreCase("q1")){
			estado = true;
			System.out.println("q1 -> q3 con "+ "Lamda" + ", " + estado);
			leerCadena(cadena, arbol.getHijos().get(0));
		}
//		

		return estado;



	}
}
