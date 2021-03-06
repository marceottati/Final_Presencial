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
	private static final String ALL_FUNCIONALIDADES = "SELECT * FROM FUNCIONALIDADES ORDER BY ID";
	private static final String INSERT_FUNCIONALIDAD = "INSERT INTO FUNCIONALIDADES (DESCRIPCION, NOMBRE) VALUES (?,?)";
	private static final String UPDATE_FUNCIONALIDAD = "UPDATE FUNCIONALIDADES SET DESCRIPCION=?, NOMBRE=? WHERE ID=?";
	private static final String DELETE_FUNCIONALIDAD = "DELETE FROM FUNCIONALIDADES WHERE ID=?";
	private static final String SELECCIONAR_BY_ID_FUNCIONALIDAD = "SELECT * FROM ROLES WHERE ID=?";

	private static final String ROL_FUNCIONALIDADES = "SELECT f.* FROM Funcionalidades f LEFT JOIN ROLES_FUNCIONALIDADES RF ON f.ID = RF.FUNCIONALIDAD_ID WHERE RF.ROL_ID=?";
	
	//SENTENCIAS DE LA TABLA N N
	private static final String DELETE_ROL_FUNC = "DELETE FROM ROLES_FUNCIONALIDADES WHERE ROL_ID=? AND FUNCIONALIDAD_ID=?";
	private static final String INSERT_ROL_FUNC = "INSERT INTO ROLES_FUNCIONALIDADES(ROL_ID, FUNCIONALIDAD_ID) VALUES(?, ?)";
	private static final String UPDATE_ROL_FUNC = "UPDATE ROLES_FUNCIONALIDADES SET ROL_ID=?, FUNCIONALIDAD_ID=?";
	//*************************************************************************************************************
	/**
	 * FUNCION findFuncionalidades RETORNA UN OBJETO FUNCIONALIDAD DADO SU ID
	 * 
	 * @param id
	 * @return FUNCIONALIDAD
	 */
	public static Funcionalidad findFuncionalidades(int id) {

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
	public static boolean insertFuncionalidad(Funcionalidad f) {
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
	public static boolean updateFuncionalidad(Funcionalidad f) {
		try {
			PreparedStatement st = Conexion.getConnection().prepareStatement(UPDATE_FUNCIONALIDAD);

			st.setString(1, f.getDescripcion());
			st.setString(2, f.getNombre());
			st.setInt(3, f.getId());

			int ret = st.executeUpdate();

			return (ret > 0);

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

	public static boolean delete(Funcionalidad f) {
		try {

			PreparedStatement st = Conexion.getConnection().prepareStatement(DELETE_FUNCIONALIDAD);

			st.setInt(1, f.getId());
			int retorno = st.executeUpdate();

			return (retorno > 0);

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
				f.setId(resultado.getInt("ID"));
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

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static LinkedList<Funcionalidad> rol_Func(Rol rol) {
		LinkedList<Funcionalidad> Funcionalidades = new LinkedList<>();

		try {

			PreparedStatement st = Conexion.getConnection().prepareStatement(ROL_FUNCIONALIDADES);
			st.setInt(1, rol.getId());
			ResultSet resultado = st.executeQuery();
			System.out.println("cos");
			while (resultado.next()) {
				Funcionalidad f = new Funcionalidad();
				f.setId(resultado.getInt("ID"));
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
	
	//******************************************ROLES_FUNCIONALIDADES************************************************
	/**
	 * FUNCI�N INSERT_FOL_FUNC
	 * @param rol
	 * @param func
	 * @return boolean
	 */
	public static boolean INSERT_Rol_Func(int rol, int func) {
		try {
			PreparedStatement st = Conexion.getConnection().prepareStatement(INSERT_ROL_FUNC);
			st.setInt(1, rol);
			st.setInt(2, func);
			
			int resultado = st.executeUpdate();
			
			return (resultado>0);
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
	/**
	 * UPDATE_Rol_Func
	 * @param rol
	 * @param func
	 * @return boolean
	 */
	public static boolean UPDATE_Rol_Func(int rol, int func) {
		
		try {
			
			PreparedStatement st = Conexion.getConnection().prepareStatement(UPDATE_ROL_FUNC);
			st.setInt(1, rol);
			st.setInt(2, func);
			
			int resultado = st.executeUpdate();
			
			return (resultado>0);
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
	
	/**
	 * DELETE_Rol_Func
	 * @param rol
	 * @param func
	 * @return boolean
	 */
	public static boolean DELETE_Rol_Func(int rol, int func) {
		
		try {
			
			PreparedStatement st = Conexion.getConnection().prepareStatement(DELETE_ROL_FUNC);
			st.setInt(1, rol);
			st.setInt(2, func);
			
			int resultado = st.executeUpdate();
			
			return (resultado>0);
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
}
