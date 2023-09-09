package com.edu.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.edu.entidad.Alumno;
import com.edu.interfaces.AlumnoDAO;
import com.edu.utils.MySqlConexion;

public class MySqlAlumnoDAO implements AlumnoDAO{

	@Override
	public int registrar(Alumno bean) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement ps = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "insert into tb_alumno values(?,?,?,?,?,?,?)";
			ps = cn.prepareStatement(sql);
			ps.setInt(1, bean.getDni());
			ps.setString(2, bean.getNombre());
			ps.setString(3, bean.getApellidos());
			ps.setInt(4, bean.getEdad());
			ps.setString(5, bean.getGenero());
			ps.setString(6, bean.getTelefono());
			ps.setString(7, bean.getCorreo());
			salida = ps.executeUpdate();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"OCURRIO UN ERROR: " + e.toString());
		}finally {
			try {
				if(cn!=null) cn.close();
				if(ps!=null) cn.close();
			} catch (SQLException e2) {
				JOptionPane.showMessageDialog(null,"OCURRIO UN ERROR: " + e2.toString());
			}
		}
		
		return salida;
	}

	@Override
	public int actualizar(Alumno bean) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement ps = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "update tb_alumno set nombre=?, apellidos=?, edad=?, genero=?, telefono=?, correo=? where dni_alumno=?";
			ps = cn.prepareStatement(sql);
			ps.setString(1, bean.getNombre());
			ps.setString(2, bean.getApellidos());
			ps.setInt(3, bean.getEdad());
			ps.setString(4, bean.getGenero());
			ps.setString(5, bean.getTelefono());
			ps.setString(6, bean.getCorreo());
			ps.setInt(7, bean.getDni());
			salida = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) ps.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	@Override
	public int eliminar(int cod) {
		int salida= -1;
		Connection cn = null;
		//CallableStatement cstm = null;
		PreparedStatement pstm = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "delete from tb_alumno where dni_alumno=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			salida = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(cn!=null) cn.close();
				if(pstm!=null) pstm.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return salida;
	}

	@Override
	public ArrayList<Alumno> listAll() {
		ArrayList<Alumno> alu = new ArrayList<Alumno>();
		Alumno bean = null;
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "select * from tb_alumno order by nombre asc";
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new Alumno();
				bean.setDni(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setApellidos(rs.getString(3));
				bean.setEdad(rs.getInt(4));
				bean.setGenero(rs.getString(5));
				bean.setTelefono(rs.getString(6));
				bean.setCorreo(rs.getString(7));
				alu.add(bean);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e2) {
				JOptionPane.showMessageDialog(null, e2.toString());
			}
		}
		
		
		return alu;
	}

}
