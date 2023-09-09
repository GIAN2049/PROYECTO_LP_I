package com.edu.controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.edu.entidad.Usuario;
import com.edu.interfaces.UsuarioDAO;
import com.edu.utils.MySqlConexion;

public class MySqlUsuarioDAO implements UsuarioDAO{

	@Override
	public Usuario iniciarSesion(String vUsuario, String vClave) {
		
		Usuario bean = null;
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			cn = MySqlConexion.getConnection();
			String sql= "select * from tb_usuario where usuario = ? and contraseña = ?";
			ps = cn.prepareCall(sql);
			ps.setString(1, vUsuario);
			ps.setString(2, vClave);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				bean = new Usuario();
				bean.setUsuario(rs.getString(1));
				bean.setNombre(rs.getString(2));
				bean.setApellido(rs.getString(3));
				bean.setGenero(rs.getString(4));
				bean.setCorreo(rs.getString(5));
				bean.setTelefono(rs.getString(6));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(cn!=null) cn.close();		
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return bean;
	}

}
