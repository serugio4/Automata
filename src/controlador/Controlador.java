package controlador;

import javax.swing.JOptionPane;

import modelo.Afd;
import modelo.Afn;
import modelo.AfnPrueba;
import modelo.ArbolNode;
import vista.AfdVentana;
import vista.AfnVentana;

public class Controlador {
	
	AfnVentana afnVentana;
	AfdVentana afdVentana;
	Afd afd;
	Afn afn;
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
	
}
