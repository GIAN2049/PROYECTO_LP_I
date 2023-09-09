package com.edu.componentes;

public class Item {
	private String nombre;
	private int codigo;

	public Item(String nombre, int codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return nombre;
	}
}
