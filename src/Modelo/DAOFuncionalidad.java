/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import Inicio.Conexion;

/**
 *
 * @author tecnico
 */
public class DAOFuncionalidad {
	private static final String ALL_FUNCIONALIDADES = "SELECT * FROM FUNCIONALIDADES ORDER BY ID_FUNCIONALIDAD";

	private static final String INSERT_FUNCIONALIDAD = "INSERT INTO FUNCIONALIDADES (DESCRIPCION, NOMBRE) VALUES (?,?)";

	private static final String UPDATE_FUNCIONALIDAD = "UPDATE FUNCIONALIDADES SET DESCRIPCION=?, NOMBRE=?  WHERE ID_FUNCIONALIDAD=?";

	private static final String DELETE_FUNCIONALIDAD = "DELETE FROM FUNCIONALIDADES WHERE ID_FUNCIONALIDAD=?";

	private static final String SELECCIONAR_BY_ID_FUNCIONALIDAD = "SELECT * FROM ROLES WHERE ID_FUNCIONALIDAD=?";

	/**
	 * FUNCION findFuncionalidades RETORNA UN OBJETO FUNCIONALIDAD DADO SU ID
	 * 
	 * @param id
	 * @return FUNCIONALIDAD
	 */
	public Funcionalidad findFuncionalidades(int id) {

		try {
			Funcionalidad f = new Funcionalidad();
			PreparedStatement st = Conexion.getConnection().prepareStatement(SELECCIONAR_BY_ID_FUNCIONALIDAD);

			st.setInt(1, id);

			ResultSet resultado = st.executeQuery();

			while (resultado.next()) {
				f.setId(resultado.getInt("ID_FUNCIONALIDAD"));
				f.setDescripcion(resultado.getString("DESCRIPCION"));
				f.setNombre(resultado.getString("NOMBRE"));
			}

			return f;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	/**
	 * FUNCION insertFuncionalidad QUE TIENE LA FUNCION DE INSERTAR UNA NUEVA
	 * FUNCIONALIDAD
	 * 
	 * @param f
	 * @return boolean
	 */
	public boolean insertFuncionalidad(Funcionalidad f) {
		try {
			boolean resultado = false;
			PreparedStatement st = Conexion.getConnection().prepareStatement(INSERT_FUNCIONALIDAD);

			st.setString(1, f.getDescripcion());
			st.setString(2, f.getNombre());

			int ret = st.executeUpdate();

			if (ret > 0) {
				resultado = true;
			} else {
				resultado = false;
			}

			return resultado;

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	/**
	 * FUNCION updateRol PARA REALIZAR ACTUALIZACION DE LAS FUNCIONALIDADES
	 * 
	 * @param f
	 * @return BOOLEAN
	 */
	public boolean updateRol(Funcionalidad f) {
		try {
			boolean resultado = false;
			PreparedStatement st = Conexion.getConnection().prepareStatement(UPDATE_FUNCIONALIDAD);

			st.setString(1, f.getDescripcion());
			st.setString(2, f.getNombre());
			st.setInt(3, f.getId());

			int ret = st.executeUpdate();

			if (ret > 0) {
				resultado = true;
			} else {
				resultado = false;
			}

			return resultado;

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	/**
	 * FUNCION DELETE SIRVE PARA ELIMINAR UNA FUNCIONALIDAD
	 * 
	 * @param id
	 * @return BOOLEAN
	 */

	public static boolean delete(int id) {
		try {

			PreparedStatement st = Conexion.getConnection().prepareStatement(DELETE_FUNCIONALIDAD);

			st.setInt(1, id);
			int retorno = st.executeUpdate();

			return retorno > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * FUNCION FINDALL QUE SIRVE PARA BUSCAR LAS FUNCIONALIDADES GUARDADAS EN LA BD
	 * 
	 * @return FUNCIONALIDADES
	 */
	public static LinkedList<Funcionalidad> findAll() {
		LinkedList<Funcionalidad> Funcionalidades = new LinkedList<>();

		try {

			PreparedStatement st = Conexion.getConnection().prepareStatement(ALL_FUNCIONALIDADES);

			ResultSet resultado = st.executeQuery();

			while (resultado.next()) {
				Funcionalidad f = new Funcionalidad();
				f.setId(resultado.getInt("ID_FUNCIONALIDAD"));
				f.setDescripcion(resultado.getString("DESCRIPCION"));
				f.setNombre(resultado.getString("NOMBRE"));
				Funcionalidades.add(f);
			}
			return Funcionalidades;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
