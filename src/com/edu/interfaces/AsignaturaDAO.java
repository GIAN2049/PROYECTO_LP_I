package com.edu.interfaces;

import java.util.ArrayList;
import com.edu.entidad.Asignatura;
import com.edu.entidad.Docente;

public interface AsignaturaDAO{
	public int registrar(Asignatura bean);				
	public int actualizar(Asignatura bean);
	public int eliminar(int cod);
	ArrayList<Asignatura> listAll();
	public int obtenerCodigo();
	public Docente buscarPorID(int cod);
	ArrayList<Asignatura> habilitarAsignatura(int cod);
	public String obtenerNombre(int cod);
}
