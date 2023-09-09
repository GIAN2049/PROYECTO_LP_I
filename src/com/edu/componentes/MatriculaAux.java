package com.edu.componentes;

public class MatriculaAux {
	private int codMatricula;
	private int dniAlumno;
	private int codCarrera;
	private int codAsignatura;
	private int codCiclo;
	private int codPeriodo;
	private String nombreAsignatura;
	private String nombreCiclo;
	


	public MatriculaAux(int dniAlumno, int codCarrera, int codAsignatura, int codCiclo,
			int codPeriodo, String nombreAsignatura, String nombreCiclo) {
		super();
		this.dniAlumno = dniAlumno;
		this.codCarrera = codCarrera;
		this.codAsignatura = codAsignatura;
		this.codCiclo = codCiclo;
		this.codPeriodo = codPeriodo;
		this.nombreAsignatura = nombreAsignatura;
		this.nombreCiclo = nombreCiclo;
	}



	public int getCodMatricula() {
		return codMatricula;
	}



	public void setCodMatricula(int codMatricula) {
		this.codMatricula = codMatricula;
	}



	public int getDniAlumno() {
		return dniAlumno;
	}



	public void setDniAlumno(int dniAlumno) {
		this.dniAlumno = dniAlumno;
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



	public String getNombreAsignatura() {
		return nombreAsignatura;
	}



	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}



	public String getNombreCiclo() {
		return nombreCiclo;
	}



	public void setNombreCiclo(String nombreCiclo) {
		this.nombreCiclo = nombreCiclo;
	}
	
}
