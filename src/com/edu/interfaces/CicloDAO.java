package com.edu.interfaces;

import java.util.ArrayList;

import com.edu.entidad.Ciclos;

public interface CicloDAO {
	public int registrar(Ciclos bean);
	public int actualizar(Ciclos bean);
	public int eliminar(int codigo);
	ArrayList<Ciclos> ListAll();
	public int ultimoCodigo();
	public String obtenerNombre(int cod);
}
