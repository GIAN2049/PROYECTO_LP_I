package com.edu.entidad;

public class Asignatura {
	private int codigo, codigoCarrera, codigoCiclo, dniDocente;
	private String nombre;
	
	private String nombreCarrera;
	private String nombreCiclo;
	private String nombreDocente;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigoCarrera() {
		return codigoCarrera;
	}
	public void setCodigoCarrera(int codigoCarrera) {
		this.codigoCarrera = codigoCarrera;
	}
	public int getCodigoCiclo() {
		return codigoCiclo;
	}
	public void setCodigoCiclo(int codigoCiclo) {
		this.codigoCiclo = codigoCiclo;
	}
	public int getDniDocente() {
		return dniDocente;
	}
	public void setDniDocente(int dniDocente) {
		this.dniDocente = dniDocente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreCarrera() {
		return nombreCarrera;
	}
	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}
	public String getNombreCiclo() {
		return nombreCiclo;
	}
	public void setNombreCiclo(String nombreCiclo) {
		this.nombreCiclo = nombreCiclo;
	}
	public String getNombreDocente() {
		return nombreDocente;
	}
	public void setNombreDocente(String nombreDocente) {
		this.nombreDocente = nombreDocente;
	}
	
	
}
