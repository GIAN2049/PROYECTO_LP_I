package com.edu.componentes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import com.edu.entidad.Ciclos;
import com.edu.utils.MySqlConexion;

public class JcomoBoxNivel {
	public ArrayList<Ciclos> obtenerCiclo(){
		ArrayList<Ciclos> nombreCiclo = new ArrayList<>();
		
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			cn = MySqlConexion.getConnection();
			String sql = "select * from tb_ciclos";
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Ciclos bean = new Ciclos();
				bean.setCodigo(rs.getInt(1));
				bean.setNro_ciclo(rs.getString(2));
				nombreCiclo.add(bean);
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
		
		
		return nombreCiclo;
	}
}
