package com.edu.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.edu.entidad.Asignatura;
import com.edu.entidad.Docente;
import com.edu.entidad.Periodo;
import com.edu.interfaces.AsignaturaDAO;
import com.edu.utils.MySqlConexion;

public class MySqlAsignaturaDAO implements AsignaturaDAO{
	
	

	@Override
	public int registrar(Asignatura bean) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement ps = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "insert into tb_asignaturas values(?,?,?,?,?)";
			ps = cn.prepareStatement(sql);
			ps.setInt(1, bean.getCodigo());
			ps.setString(2, bean.getNombre());
			ps.setInt(3, bean.getCodigoCarrera());
			ps.setInt(4, bean.getCodigoCiclo());
			ps.setInt(5, bean.getDniDocente());
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
	public int actualizar(Asignatura bean) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement ps = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "update tb_asignaturaS set nombre = ?, cod_carrera = ?, cod_ciclo = ?, dni_docente = ? where "
					+ "cod_asignatura = ?";
			ps = cn.prepareStatement(sql);
			ps.setString(1, bean.getNombre());
			ps.setInt(2, bean.getCodigoCarrera());
			ps.setInt(3, bean.getCodigoCiclo());
			ps.setInt(4, bean.getDniDocente());
			ps.setInt(5, bean.getCodigo());
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
			String sql = "delete from tb_asignaturas where cod_asignatura=?";
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
	public ArrayList<Asignatura> listAll() {
		ArrayList<Asignatura> asignatura = new ArrayList<Asignatura>();
		Asignatura bean = null;
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "select a.cod_asignatura, a.nombre, c.nom_carrera, ci.nmro_ciclo, d.nombre from "
					+ "tb_asignaturas a join tb_carrera c on a.cod_carrera = c.cod_carrera "
					+ "join tb_ciclos ci on a.cod_ciclo = ci.cod_ciclo "
					+ "join tb_docente d on a.dni_docente = d.dni_docente";
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new Asignatura();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setNombreCarrera(rs.getString(3));
				bean.setNombreCiclo(rs.getString(4));
				bean.setNombreDocente(rs.getString(5));
				asignatura.add(bean);
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
	
		return asignatura;
	}

	@Override
	public int obtenerCodigo() {
		int ultimoCodigo = 0;
	    String query = "SELECT MAX(cod_asignatura) AS ultimo_codigo FROM tb_asignaturas";
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
	    	ultimoCodigo = 4000;
	    }
	    
	    
		return ultimoCodigo+1;
	}

	@Override
	public Docente buscarPorID(int cod) {
		Docente bean = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "select d.nombre, d.apellidos "
					+ "from tb_docente d  where d.dni_docente=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if(rs.next()) {
				bean = new Docente();
				bean.setNombre(rs.getString(1));
				bean.setApellidos(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	
		return bean;
	}
	
	
	@Override
	public ArrayList<Asignatura> habilitarAsignatura(int cod) {
		ArrayList<Asignatura> datos = new ArrayList<Asignatura>();
		Asignatura bean = null;
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "select cod_asignatura, nombre from tb_asignaturas where cod_ciclo = ?;";
			ps = cn.prepareStatement(sql);
			ps.setInt(1, cod);
			rs = ps.executeQuery();
			while(rs.next()) {
				bean = new Asignatura();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				datos.add(bean);
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
		
		return datos;
	}

	@Override
	public String obtenerNombre(int cod) {
		Asignatura bean = null;
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "select nombre from tb_asignaturas where cod_asignatura = ?;";
			ps = cn.prepareStatement(sql);
			ps.setInt(1, cod);
			rs = ps.executeQuery();
			if(rs.next()) {
				bean = new Asignatura();
				bean.setNombre(rs.getString(1));
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
		
		return bean.getNombre();
	}


}
