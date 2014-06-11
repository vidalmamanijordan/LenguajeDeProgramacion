package edu.upeu.ventas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.upeu.ventas.dao.DocenteDAO;
import edu.upeu.ventas.dominio.Alumno;
import edu.upeu.ventas.dominio.Docente;
import edu.upeu.ventas.util.DBConexion;

public class DocenteDAOJdbcImpl implements DocenteDAO {

	//Metodo para Listar un Alumno...
	public List<Docente> listarDocente() {
		List<Docente> lista = new ArrayList<Docente>();

		try {
			Connection conn = DBConexion.getConexion();

			PreparedStatement ps = conn
					.prepareStatement("select * from docente");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Docente p = new Docente();
				p.setId(rs.getString("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApePat(rs.getString("apePat"));
				p.setApeMat(rs.getString("apeMat"));

				lista.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConexion.exit();
		}
		System.out.println("Tamanio:" + lista.size());
		return lista;
	}
	
	public void guardar(Docente p) {

		try {
			//Nos Conectamos a nuestra base de datos MySQL..
			Connection conn = DBConexion.getConexion();
			//Preparamos Nuestra consulta....
			PreparedStatement ps = conn
					.prepareStatement("insert into docente(id,nombre,apePat,apeMat) values(uuid(),?,?,?)");

			ps.setString(1, p.getNombre());
			ps.setString(2, p.getApePat());
			ps.setString(3, p.getApeMat());
			//Ejecutamos la consulta preparada...
			ps.executeUpdate();

		} catch (SQLException e) {
			//Nos aseguramos que no aya errores por eso mandamos la excepcion..
			e.printStackTrace();
		} finally {
			//Nos desconectamos de la nuestra base de Datos...
			DBConexion.exit();
		}

	}
	
	public Docente getDocentePorid(String id) {

		Docente dc = null;
		try {
			Connection conn = DBConexion.getConexion();

			PreparedStatement ps = conn
					.prepareStatement("select * from docente where id=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				dc=new Docente();
				dc.setId(rs.getString("id"));
				dc.setNombre(rs.getString("nombre"));
				dc.setApePat(rs.getString("ape_pat"));
				dc.setApeMat(rs.getString("ape_mat"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConexion.exit();
		}
		// TODO Auto-generated method stub
		return dc;
	}
	public void actualizar(Docente p) {

		try {
			Connection conn = DBConexion.getConexion();

			PreparedStatement ps = conn
					.prepareStatement("update docente set nombre=?,apePat=?,apeMat=? where id=?");

			
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getApePat());
			ps.setString(3, p.getApeMat());
			ps.setString(4, p.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConexion.exit();
		}

	}
}
