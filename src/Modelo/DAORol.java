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

public class DAORol {
	private static final String ALL_ROLES ="SELECT * FROM ROLES";
	private static final String INSERT_ROLES ="INSERT INTO ROLES (NOMBRE, DESCRIPCION) VALUES (?,?)";
	private static final String UPDATE_ROLES ="UPDATE ROLES SET NOMBRE=?, SET DESCRIPCION=? WHERE ID = ?";
	private static final String SEARCHbyID ="SELECT * FROM ROLES WHERE ID = ?";
	private static final String DELETE_ROL="DELETE FROM ROLES WHERE ID = ?";
	
	public static LinkedList<Rol> findAll(){
		LinkedList<Rol> roles = new LinkedList<Rol>();
		try {
			PreparedStatement stmt = Conexion.getConnection().prepareStatement(ALL_ROLES);
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				int id = resultado.getInt("ID");
				String nombre = resultado.getString("NOMBRE");
				String desc = resultado.getString("desc");
				Rol r = new Rol();
				r.setId(id);
				r.setNombre(nombre);
				r.setDescripcion(desc);
				roles.add(r);
			}
			return roles;
		} catch (SQLException e) {
		e.printStackTrace();
		return null;
		}
	}
	
	public static boolean insert(Rol r) {
		try {
			PreparedStatement stmt = Conexion.getConnection().prepareStatement(INSERT_ROLES);
			stmt.setString(1, r.getNombre());
			stmt.setString(2, r.getDescripcion());
			int Retorno = stmt.executeUpdate();
			
			return Retorno > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean update(Rol r) {
		try {
			PreparedStatement stmt = Conexion.getConnection().prepareStatement(UPDATE_ROLES);
			stmt.setString(1, r.getNombre());
			stmt.setString(2, r.getDescripcion());
			stmt.setInt(3, r.getId());
			
			int Retorno = stmt.executeUpdate();
			
			return Retorno > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static LinkedList<Rol> find(int id){
		LinkedList<Rol> roles = new LinkedList<Rol>();
		try {
			PreparedStatement stmt = Conexion.getConnection().prepareStatement(SEARCHbyID);
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				int ID = Integer.parseInt(resultado.getString("ID"));
				String nombre = resultado.getString("NOMBRE");
				String desc = resultado.getString("DESCRIPCION");
				Rol r = new Rol();
				r.setId(ID);
				r.setNombre(nombre);
				r.setDescripcion(desc);
				roles.add(r);
			}
			return roles;
		} catch (SQLException e) {
		e.printStackTrace();
		return null;
		}
	}
	
	public static boolean delete(int id){
		try {
			PreparedStatement statement = Conexion.getConnection().prepareStatement(DELETE_ROL);
			statement.setInt(1, id);
			
			int retorno = statement.executeUpdate();
			return retorno>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
		
	}
	
}