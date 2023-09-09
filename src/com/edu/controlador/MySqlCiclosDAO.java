package com.edu.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.edu.entidad.Asignatura;
import com.edu.entidad.Ciclos;
import com.edu.interfaces.CicloDAO;
import com.edu.utils.MySqlConexion;

public class MySqlCiclosDAO implements CicloDAO{

	@Override
	public int registrar(Ciclos bean) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement ps = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "insert into tb_ciclos values(?,?)";
			ps = cn.prepareStatement(sql);
			ps.setInt(1, bean.getCodigo());
			ps.setString(2, bean.getNro_ciclo());
			salida = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(cn!=null) cn.close();
				if(ps!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return salida;
	}

	@Override
	public int actualizar(Ciclos bean) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement ps = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "update tb_ciclos set nmro_ciclo = ? where cod_ciclo = ?";
			ps = cn.prepareStatement(sql);
			ps.setString(1, bean.getNro_ciclo());
			ps.setInt(2, bean.getCodigo());
			salida = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(cn!=null) cn.close();
				if(ps!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return salida;
	}

	@Override
	public int eliminar(int codigo) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement ps = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "delete from tb_ciclos where cod_ciclo=?";
			ps = cn.prepareStatement(sql);
			ps.setInt(1, codigo);
			salida = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(cn!=null) cn.close();
				if(ps!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return salida;
	}

	@Override
	public ArrayList<Ciclos> ListAll() {
		ArrayList<Ciclos> ciclos = new ArrayList<Ciclos>();
		Ciclos bean = null;
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "select * from tb_ciclos";
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new Ciclos();
				bean.setCodigo(rs.getInt(1));
				bean.setNro_ciclo(rs.getString(2));
				ciclos.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return ciclos;
	}

	@Override
	public int ultimoCodigo() {
		int ultimoCodigo = 0;
	    String query = "SELECT MAX(cod_ciclo) AS ultimo_codigo FROM tb_ciclos";
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
	    	ultimoCodigo = 2000;
	    }
	    
	    
		return ultimoCodigo+1;
	}

	@Override
	public String obtenerNombre(int cod) {
		Ciclos bean = null;
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "select nmro_ciclo from tb_ciclos where cod_ciclo = ?;";
			ps = cn.prepareStatement(sql);
			ps.setInt(1, cod);
			rs = ps.executeQuery();
			if(rs.next()) {
				bean = new Ciclos();
				bean.setNro_ciclo(rs.getString(1));
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
		
		return bean.getNro_ciclo();
	}

}
