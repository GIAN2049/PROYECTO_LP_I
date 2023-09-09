package com.edu.interfaces;

import java.util.ArrayList;

import com.edu.entidad.Docente;

public interface DocenteDAO {
	public int registrar(Docente bean);				
	public int actualizar(Docente bean);
	public int eliminar(int cod);
	ArrayList<Docente> listAll();
}
