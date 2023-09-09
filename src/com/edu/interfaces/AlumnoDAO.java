package com.edu.interfaces;

import java.util.ArrayList;

import com.edu.entidad.Alumno;


public interface AlumnoDAO {
	public int registrar(Alumno bean);				
	public int actualizar(Alumno bean);
	public int eliminar(int cod);
	ArrayList<Alumno> listAll();
}
