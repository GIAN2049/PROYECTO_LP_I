package com.edu.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.edu.entidad.Carrera;
import com.edu.interfaces.CarreraDAO;
import com.edu.utils.MySqlConexion;



public class MySqlCarreraDAO implements CarreraDAO{

	@Override
	public int registrar(Carrera bean) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement ps = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "insert into tb_carrera values(?,?)";
			ps = cn.prepareStatement(sql);
			ps.setInt(1, bean.getCodigo());
			ps.setString(2, bean.getNombre());
			salida = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (ps != null)
					ps.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		
		return salida;
	}

	@Override
	public int actualizar(Carrera bean) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement ps = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "update tb_carrera set nom_carrera = ? where cod_carrera=?";
			ps = cn.prepareStatement(sql);
			ps.setString(1, bean.getNombre());
			ps.setInt(2, bean.getCodigo());
			salida = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (ps != null)
					ps.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		
		return salida;
	}

	@Override
	public int eliminar(int cod) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement ps = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "delete from tb_carrera where cod_carrera=?";
			ps = cn.prepareStatement(sql);
			ps.setInt(1, cod);
			salida = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (ps != null)
					ps.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		
		return salida;
	}

	@Override
	public ArrayList<Carrera> listAll() {
		ArrayList<Carrera> carrera = new ArrayList<Carrera>();
		
		Carrera bean = null;
		
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "select * from tb_carrera";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				bean = new Carrera();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				carrera.add(bean);
			}
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return carrera;
	}

	@Override
	public int ultimoCodigo() {
		int ultimoCodigo = 0;
	    String query = "SELECT MAX(cod_carrera) AS ultimo_codigo FROM tb_carrera";
	    Connection cn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
	    try {
	    	cn = MySqlConexion.getConnection();
	    	ps = cn.prepareStatement(query);
	    	rs = ps.executeQuery();
	    	
	    	if(rs.next()) {
	    		ultimoCodigo = rs.getInt("ultimo_codigo");
	    	}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	    
	    if(ultimoCodigo == 0) {
	    	ultimoCodigo = 1000;
	    }
	    
	    
		return ultimoCodigo+1;
	}

}
