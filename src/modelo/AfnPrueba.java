package modelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AfnPrueba {
	
	char[] mensaje;
	private Boolean aceptacion;
	int tamMen;
	int cont;
	private String ruta;
	
	
	
	
	public AfnPrueba(String mensaje) {
		
		this.mensaje = mensaje.toCharArray();
		setAceptacion(false);
		tamMen= mensaje.length();
		cont=0;
		q0();
		
	}
	
	public void q0() {
		if (cont<tamMen) {
			ruta+="q0, ";
			
			if (mensaje[cont]=='a' || mensaje[cont]=='c') {
				cont++;
				setAceptacion(false);
				q0();
			}
			else if (mensaje[cont]=='b') {
				cont++;
				setAceptacion(false);
				q1();
				
			}
			else {
				System.out.println("el caracter '" + mensaje[cont] +  "' ingresado no pertenece al alfabeto");
				setAceptacion(false);
			}
		}	
	}
	
	public void q1() {
		if (cont<tamMen) {
			ruta+="q1, ";
			
			if (mensaje[cont]=='a') {
				cont++;
				setAceptacion(false);
				q0();
			}
			else if (mensaje[cont]=='b') {
				cont++;
				setAceptacion(false);
				q1();	
			}else if (mensaje[cont]=='c') {
				cont++;
				setAceptacion(true);
				q2();	
			}
			else {
				System.out.println("el caracter '" + mensaje[cont] +  "' ingresado no pertenece al alfabeto");
				setAceptacion(false);
				
			}	
		}
	}
	
	
	public void q2() {
		if (cont<tamMen) {
			ruta+="q2, ";

			if (mensaje[cont]=='a' || mensaje[cont]=='b' || mensaje[cont]=='c') {
				cont++;
				setAceptacion(true);
				q2();
			}
			
			else {
				System.out.println("el caracter " + mensaje[cont] +  " ingresado no pertenece al alfabeto");
				setAceptacion(false);	
			}	
		}	
	}
	
	
	
	
	public Boolean getAceptacion() {
		return aceptacion;
	}

	public void setAceptacion(Boolean aceptacion) {
		this.aceptacion = aceptacion;
	}

	
	
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

}