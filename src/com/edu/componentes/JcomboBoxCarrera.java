package com.edu.componentes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.edu.entidad.Carrera;
import com.edu.entidad.Genero;
import com.edu.utils.MySqlConexion;

public class JcomboBoxCarrera {
	
	
	
	public ArrayList<Carrera> obtenerCarrera(){
		ArrayList<Carrera> nombreCarrera = new ArrayList<>();
		
		Carrera bean = null;
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "select * from tb_carrera";
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new Carrera();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				nombreCarrera.add(bean);
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
		
		return nombreCarrera;
	}
	
	
	
	
	/*public ArrayList<Carrera> obtenerCarrera(){
		ArrayList<Carrera> nombreCarrera = new ArrayList<>();
		
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			cn = MySqlConexion.getConnection();
			String sql = "select * from tb_carrera";
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Carrera bean = new Carrera();
				bean.setCodigo(rs.getInt(1));
				nombreCarrera.add(bean);
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e.toString());
		}finally {
			try {
				if(cn!=null) cn.close();
				if(ps!=null) ps.close();
				if(rs!=null) rs.close();
			} catch (SQLException e2) {
				JOptionPane.showMessageDialog(null, "ERROR: " + e2.toString());
			}
		}
		
		
		return nombreCarrera;
	}*/
}
