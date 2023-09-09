package com.edu.interfaces;

import java.util.ArrayList;

import com.edu.entidad.Carrera;

public interface CarreraDAO {
	public int registrar(Carrera bean);
	public int actualizar(Carrera bean);
	public int eliminar(int cod);
	ArrayList<Carrera> listAll();
	public int ultimoCodigo();
}
