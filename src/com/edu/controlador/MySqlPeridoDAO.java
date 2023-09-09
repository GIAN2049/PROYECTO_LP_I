package com.edu.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.edu.entidad.Periodo;
import com.edu.interfaces.PeriodoDAO;
import com.edu.utils.MySqlConexion;

public class MySqlPeridoDAO implements PeriodoDAO{

	@Override
	public int registrar(Periodo bean) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement ps = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "insert into tb_periodos values(?,?,?)";
			ps = cn.prepareStatement(sql);
			ps.setInt(1, bean.getCodigo());
			ps.setString(2, bean.getFechaInicio());
			ps.setString(3, bean.getFechaFin());
			salida = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(cn!=null) cn.close();
				if(ps!=null) ps.close();
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
			String sql = "delete from tb_periodos where cod_periodo=?";
			ps = cn.prepareStatement(sql);
			ps.setInt(1, cod);
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
	public ArrayList<Periodo> listAll() {
		ArrayList<Periodo> periodo = new ArrayList<Periodo>();
		Periodo bean = null;
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "select * from tb_periodos";
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new Periodo();
				bean.setCodigo(rs.getInt(1));
				bean.setFechaInicio(rs.getString(2));
				bean.setFechaFin(rs.getString(3));
				periodo.add(bean);
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
	
		return periodo;
	}

	@Override
	public int obtenerCodigo() {
		int ultimoCodigo = 0;
	    String query = "SELECT MAX(cod_periodo) AS ultimo_codigo FROM tb_periodos";
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
	    	ultimoCodigo = 3000;
	    }
	    
	    
		return ultimoCodigo+1;
	}

}
