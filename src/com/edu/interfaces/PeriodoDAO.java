package com.edu.interfaces;

import java.util.ArrayList;

import com.edu.entidad.Periodo;

public interface PeriodoDAO {
	public int registrar(Periodo bean);
	public int eliminar(int cod);
	public ArrayList<Periodo> listAll();
	public int obtenerCodigo();
}
