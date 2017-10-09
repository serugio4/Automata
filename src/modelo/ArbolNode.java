package modelo;

import java.awt.List;
import java.util.ArrayList;

public class ArbolNode {

	private String nombre;
	private ArbolNode padre;
	private ArrayList<ArbolNode> hijos;

	public ArbolNode(String nombre) {		
		this.nombre=nombre;
		padre = null;	
		this.hijos = new ArrayList<ArbolNode>();

	}

	public void setPadre(ArbolNode padre) {
		this.padre = padre;
	}
	public ArbolNode getPadre() {
		return padre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void addHijos(ArbolNode hijo){
		this.hijos.add(hijo);
		hijo.setPadre(this);

	}

	public ArrayList<ArbolNode> getHijos() {
		return hijos;
	}


}
