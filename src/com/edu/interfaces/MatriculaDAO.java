package com.edu.interfaces;

import java.util.ArrayList;

import com.edu.entidad.Asignatura;
import com.edu.entidad.Matricula;

public interface MatriculaDAO {
	public int registrar(Matricula bean);
	public ArrayList<Matricula> listAll();
}
