package com.edu.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.lang.model.element.NestingKind;

import com.edu.entidad.Docente;
import com.edu.interfaces.DocenteDAO;
import com.edu.utils.MySqlConexion;

public class MySqlDocenteDAO implements DocenteDAO{

	@Override
	public int registrar(Docente bean) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement ps = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "insert into tb_docente values(?,?,?,?,?,?,?)";
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
	public int actualizar(Docente bean) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement ps = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "update tb_docente set nombre=?, apellidos=?, edad=?, genero=?, telefono=?, correo=? where dni_docente=?";
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
		PreparedStatement pstm = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "delete from tb_docente where dni_docente=?";
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
	public ArrayList<Docente> listAll() {
		ArrayList<Docente> doc = new ArrayList<Docente>();
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
				bean.setApellidos(rs.getString(3));
				bean.setEdad(rs.getInt(4));
				bean.setGenero(rs.getString(5));
				bean.setTelefono(rs.getString(6));
				bean.setCorreo(rs.getString(7));
				
				doc.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(cn!=null) cn.close();
				if(ps!=null) ps.close();
				if(rs!=null) rs.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return doc;
	}
}
