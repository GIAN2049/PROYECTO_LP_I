package com.edu.entidad;

public class Matricula {

	private int codMatricula;
	private int DNI;
	private int codCarrera;
	private int codAsignatura;
	private int codCiclo;
	private int codPeriodo;
	private String nombreAlumno, nombreAsignatura, nombreCarrera, nombreCiclo, 
	fechaInicio, fechaFin;
	
	public Matricula() {
		
	}

	public Matricula(int dNI, int codCarrera, int codAsignatura, int codCiclo, int codPeriodo, String nombreAlumno,
			String nombreAsignatura, String nombreCiclo) {
		super();
		DNI = dNI;
		this.codCarrera = codCarrera;
		this.codAsignatura = codAsignatura;
		this.codCiclo = codCiclo;
		this.codPeriodo = codPeriodo;
		this.nombreAlumno = nombreAlumno;
		this.nombreAsignatura = nombreAsignatura;
		this.nombreCiclo = nombreCiclo;
	}




	public Matricula(int dNI, int codCarrera, int codAsignatura, int codCiclo, int codPeriodo, String nombreAlumno,
			String nombreAsignatura, String nombreCarrera, String nombreCiclo) {
		super();
		DNI = dNI;
		this.codCarrera = codCarrera;
		this.codAsignatura = codAsignatura;
		this.codCiclo = codCiclo;
		this.codPeriodo = codPeriodo;
		this.nombreAlumno = nombreAlumno;
		this.nombreAsignatura = nombreAsignatura;
		this.nombreCarrera = nombreCarrera;
		this.nombreCiclo = nombreCiclo;
	}





	public int getCodMatricula() {
		return codMatricula;
	}

	public void setCodMatricula(int codMatricula) {
		this.codMatricula = codMatricula;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}

	public int getCodCarrera() {
		return codCarrera;
	}

	public void setCodCarrera(int codCarrera) {
		this.codCarrera = codCarrera;
	}

	public int getCodAsignatura() {
		return codAsignatura;
	}

	public void setCodAsignatura(int codAsignatura) {
		this.codAsignatura = codAsignatura;
	}

	public int getCodCiclo() {
		return codCiclo;
	}

	public void setCodCiclo(int codCiclo) {
		this.codCiclo = codCiclo;
	}

	public int getCodPeriodo() {
		return codPeriodo;
	}

	public void setCodPeriodo(int codPeriodo) {
		this.codPeriodo = codPeriodo;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
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

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	
	
	
	
}
