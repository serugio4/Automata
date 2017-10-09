package modelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Afd {
	
	char[] mensaje;
	private Boolean aceptacion;
	int tamMen;
	int cont;
	private String ruta;
	private String errorCadena;
	
	
	
	

	public Afd(String mensaje) {
		
		this.mensaje = mensaje.toCharArray();
		setAceptacion(false);
		tamMen= mensaje.length();
		cont=0;
		ruta="";
		errorCadena="";
		q0();
		
	}
	
	public void q0() {
		if (cont<tamMen) {
			ruta+="q0, ";
			
			if (mensaje[cont]=='a') {
				cont++;
				setAceptacion(true);
				q2();
			}
			else if (mensaje[cont]=='b') {
				cont++;
				setAceptacion(false);
				q1();
				
			}
			else {
				errorCadena+= "el caracter '" + mensaje[cont] +  "' ingresado no pertenece al alfabeto";
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
				q3();
			}
			else if (mensaje[cont]=='b') {
				cont++;
				setAceptacion(false);
				q0();	
			}
			else {
				errorCadena+= "el caracter '" + mensaje[cont] +  "' ingresado no pertenece al alfabeto";
				setAceptacion(false);
				
			}	
		}
	}
	
	
	public void q2() {
		if (cont<tamMen) {
			ruta+="q2, ";
			
			if (mensaje[cont]=='a') {
				cont++;
				setAceptacion(false);
				q0();
			}
			else if (mensaje[cont]=='b') {
				cont++;
				setAceptacion(false);
				q3();
				
			}
			else {
				errorCadena+= "el caracter '" + mensaje[cont] +  "' ingresado no pertenece al alfabeto";
				setAceptacion(false);
				
			}	
		}	
	}
	
	
	public void q3() {
		if (cont<tamMen) {
			ruta+="q3, ";
			
			if (mensaje[cont]=='a') {
				cont++;
				setAceptacion(false);
				q1();
			}
			else if (mensaje[cont]=='b') {
				cont++;
				setAceptacion(true);
				q2();
				
			}
			else {
				errorCadena+= "el caracter '" + mensaje[cont] +  "' ingresado no pertenece al alfabeto";
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
	
	public String getErrorCadena() {
		return errorCadena;
	}

	public void setErrorCadena(String errorCadena) {
		this.errorCadena = errorCadena;
	}

}