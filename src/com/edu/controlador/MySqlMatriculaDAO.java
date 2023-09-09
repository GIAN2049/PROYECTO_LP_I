package com.edu.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.edu.entidad.Matricula;
import com.edu.interfaces.MatriculaDAO;
import com.edu.utils.MySqlConexion;

public class MySqlMatriculaDAO implements MatriculaDAO{

	@Override
	public int registrar(Matricula bean) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement ps = null;
		
		try {
			cn = MySqlConexion.getConnection();
			String sql = "insert into tb_matricula values (null, ?, ?, ?, ?, ?)";
			ps = cn.prepareStatement(sql);
			ps.setInt(1, bean.getDNI());
			ps.setInt(2, bean.getCodCarrera());
			ps.setInt(3, bean.getCodAsignatura());
			ps.setInt(4, bean.getCodCiclo());
			ps.setInt(5, bean.getCodPeriodo());
			
			salida = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) {
					ps.close();
				}else if(cn!= null) {
					cn.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return salida;
	}

	@Override
	public ArrayList<Matricula> listAll() {
		ArrayList<Matricula> datos = new ArrayList<Matricula>();
		Matricula bean = null;
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			cn = MySqlConexion.getConnection();
			String sql = "select distinct a.dni_alumno, a.nombre, c.nom_carrera, ci.nmro_ciclo, p.fec_inicio, p.fec_fin "
					+ "from tb_matricula m join tb_alumno a on m.dni_alumno = a.dni_alumno "
					+ "join tb_carrera c on m.cod_carrera = c.cod_carrera "
					+ "join tb_ciclos ci on m.cod_ciclo = ci.cod_ciclo "
					+ "join tb_periodos p on m.cod_periodo = p.cod_periodo";
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new Matricula();
				bean.setDNI(rs.getInt(1));
				bean.setNombreAlumno(rs.getString(2));
				bean.setNombreCarrera(rs.getString(3));
				bean.setNombreCiclo(rs.getString(4));
				bean.setFechaInicio(rs.getString(5));
				bean.setFechaFin(rs.getString(6));
				datos.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null)
					cn.close();
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return datos;
	}
}
