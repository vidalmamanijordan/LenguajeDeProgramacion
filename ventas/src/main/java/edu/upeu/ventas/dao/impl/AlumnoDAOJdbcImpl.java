package edu.upeu.ventas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.upeu.ventas.dao.AlumnoDAO;
import edu.upeu.ventas.dominio.Alumno;
import edu.upeu.ventas.util.DBConexion;

public class AlumnoDAOJdbcImpl implements AlumnoDAO {

	//Metodo para Guardar Alumnos...
	public void guardar(Alumno p) {

		try {
			//Nos Conectamos a nuestra base de datos MySQL..
			Connection conn = DBConexion.getConexion();
			//Preparamos Nuestra consulta....
			PreparedStatement ps = conn
					.prepareStatement("insert into alumno(id,nombre,ape_pat,ape_mat) values(uuid(),?,?,?)");

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

	//Metodo para Listar un Alumno...
	public List<Alumno> listarAlumnos() {
		List<Alumno> lista = new ArrayList<Alumno>();

		try {
			Connection conn = DBConexion.getConexion();

			PreparedStatement ps = conn
					.prepareStatement("select * from alumno");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Alumno p = new Alumno();
				p.setId(rs.getString("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApePat(rs.getString("ape_pat"));
				p.setApeMat(rs.getString("ape_mat"));

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
	//Metodo para Actualizar Datos en nuestra base de Datos MySQL...
	public void actualizar(Alumno p) {

		try {
			Connection conn = DBConexion.getConexion();

			PreparedStatement ps = conn
					.prepareStatement("update alumno set nombre=?,ape_pat=?,ape_mat=? where id=?");

			
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

	
	public Alumno getAlumnoPorid(String id) {

		Alumno al = null;
		try {
			Connection conn = DBConexion.getConexion();

			PreparedStatement ps = conn
					.prepareStatement("select * from alumno where id=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				al=new Alumno();
				al.setId(rs.getString("id"));
				al.setNombre(rs.getString("nombre"));
				al.setApePat(rs.getString("ape_pat"));
				al.setApeMat(rs.getString("ape_mat"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConexion.exit();
		}
		// TODO Auto-generated method stub
		return al;
	}
}
