package com.edu.componentes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.edu.entidad.Carrera;
import com.edu.entidad.Docente;
import com.edu.utils.MySqlConexion;

public class JcomboBoxDocente {
	public ArrayList<Docente> obtenerDocente(){
		ArrayList<Docente> datos = new ArrayList<Docente>();
		Docente bean = null;
		Connection cn = null; 
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "select * from tb_docente";
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new Docente();
				bean.setDni(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				datos.add(bean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return datos;
	}
}
