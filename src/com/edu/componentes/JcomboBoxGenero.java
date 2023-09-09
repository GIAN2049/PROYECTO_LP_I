package com.edu.componentes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.edu.entidad.Genero;
import com.edu.utils.MySqlConexion;


public class JcomboBoxGenero {
	public ArrayList<Genero> obtenerNombre(){
		ArrayList<Genero> nombreGenero = new ArrayList<>();
		
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			cn = MySqlConexion.getConnection();
			String sql = "select * from tb_genero";
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Genero bean = new Genero();
				bean.setNombre(rs.getString(1));
				nombreGenero.add(bean);
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
		
		
		return nombreGenero;
	}
}
