package controlador;

import javax.swing.JOptionPane;

import modelo.*;
import vista.AfdVentana;
import vista.AfnVentana;

public class Controlador {
	
	AfnVentana afnVentana;
	AfdVentana afdVentana;
	Afd afd;
	Afn afn;
	AfnDos afnDos;
	Lamda lamda;
	ArbolNode arbolNode;
	
	
	
	public Controlador() {
		
		
		// TODO Auto-generated constructor stub
	}
	
	
	public void conectar(AfnVentana afnVentana, AfdVentana afdVentana) {
		this.afdVentana = afdVentana;
		this.afnVentana = afnVentana;
		
	}
	
	public void ejecutarAfd(String cadena) {
		afd = new Afd(cadena);
		
		if (afd.getAceptacion()==true) {
			JOptionPane.showMessageDialog(null, "la cadena es aceptada"+ "\n" + "El camino recorrido fue "+ afd.getRuta() );
			
		}
		else if (afd.getAceptacion()==false) {
			JOptionPane.showMessageDialog(null, "la cadena es rechazada"+ "\n"+ "Debido a: " + afd.getErrorCadena() );
			
		}
		
		
	}
	

	public void ejecutarAfn(String cadena) {
		
		afn = new Afn();
		arbolNode = new ArbolNode("q0");
		afn.leerCadena(cadena, afn.crearArbol(arbolNode).getPadre());
		
		if (afn.getEstado()== true){
			JOptionPane.showMessageDialog(null, "la cadena es aceptada");
			
		}
		else if (afn.getEstado()==false) {
			JOptionPane.showMessageDialog(null, "la cadena es rechazada"+ "\n"+ "Debido a: " + afn.getErrorCadena() );
			
		}
		
		
	}
	
	public void Afn2(String cadena){
		afnDos = new AfnDos();
		arbolNode = new ArbolNode("q0");
		
		try {
			
		afnDos.leerCadena(cadena, afnDos.crearArbol(arbolNode).getPadre());
		if (afnDos.getEstado() == true){
			JOptionPane.showMessageDialog(null, "La cadena fue aceptada");
		}
		else {
			JOptionPane.showMessageDialog(null, "Se revisaron todos los caminos y se nego la cadena");
		}
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "La cadena fue aceptada");
		}
		
	}
	
	public void lamda(String cadena){
		lamda = new Lamda();
		arbolNode = new ArbolNode("q0");
		
		try {
			
		lamda.leerCadena(cadena, lamda.crearArbol(arbolNode).getPadre());
		if (lamda.getEstado() == true){
			JOptionPane.showMessageDialog(null, "La cadena fue aceptada");
		}
		else {
			JOptionPane.showMessageDialog(null, "Se revisaron todos los caminos y se nego la cadena");
		}
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "La cadena fue aceptada, Mirar el camino en consola");
		}
		
	}
	
}
