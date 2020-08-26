
package Modelo;

import Inicio.Auxiliar;
import Inicio.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DAOPersona {
	
//*************************************SENTENCIAS PRECOMPILADAS TABLA PERSONAS**********************************************************************************	

	private static final String txt = "p.*, r.NOMBRE ROL_NOMBRE, r.DESCRIPCION ROL_DESCRIPCION FROM PERSONAS p INNER JOIN ROLES r ON p.ROL_ID = r.ID";
	private static final String PERSONA_X_DOCUMENTO = "SELECT " + txt + " WHERE DOCUMENTO=?";
	private static final String LOGIN = "SELECT " + txt + " WHERE EMAIL=? AND PASS=?";
	private static final String INSERT_PERSONAS = "INSERT INTO PERSONAS (DOCUMENTO, APELLIDO1, APELLIDO2, NOMBRE1, NOMBRE2, FECHA_NAC, PASS, ROL_ID, EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_PERSONAS = "UPDATE PERSONAS SET DOCUMENTO=?, APELLIDO1=?, APELLIDO2=?, NOMBRE1=?, NOMBRE2=?, FECHA_NAC=?, PASS=?, ROL_ID=?, EMAIL=? WHERE ID=?";
	private static final String OBTENER_TODOS = "SELECT " + txt + " WHERE p.EMAIL = ? AND p.PASS = ?";
	private static final String DELETE = "DELETE FROM PERSONAS WHERE p.DOCUMENTO = ?";
	
//**********************************MÉTODO PARA INSERTAR REGISTROS EN LA TABLA PERSONAS*************************************************************************
	/**
	 * INSERT
	 * @param PERSONA
	 * @return BOOLEAN
	 */
	public static boolean insert(Persona p) {
		try {
			PreparedStatement st = Conexion.getConnection().prepareStatement(INSERT_PERSONAS);

			st.setString(1, p.getDocumento());
			st.setString(1, p.getApellido1());
			st.setString(1, p.getApellido2());
			st.setString(1, p.getNombre1());
			st.setString(1, p.getNombre2());
			st.setDate(1, p.getFechaNac());
			st.setString(1, p.getPass());
			st.setInt(1, p.getRol().getId());
			st.setString(1, p.getEmail());
			st.setString(1, p.getDocumento());

			int nro = st.executeUpdate();

			return (nro > 0);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			return false;
		}
	}
//**********************************MÉTODO PARA ACTAULIZAR REGISTROS EN LA TABLA PERSONAS**********************************************************************
	/**
	 * UPDATE
	 * @param PERSONA
	 * @return PERSONA
	 */
	public static boolean update(Persona p) {
		try {
			PreparedStatement st = Conexion.getConnection().prepareStatement(UPDATE_PERSONAS);

			st.setString(1, p.getDocumento());
			st.setString(1, p.getApellido1());
			st.setString(1, p.getApellido2());
			st.setString(1, p.getNombre1());
			st.setString(1, p.getNombre2());
			st.setDate(1, p.getFechaNac());
			st.setString(1, p.getPass());
			st.setInt(1, p.getRol().getId());
			st.setString(1, p.getEmail());
			st.setInt(1, p.getId());

			int nro = st.executeUpdate();

			return (nro > 0);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			return false;
		}
	}
	
//*****************************MÉTODO PARA BUSCAR REGISTROS EN LA TABLA PERSONAS SEGÚN DOCUMENTO**************************************************************
	/**
	 * FINDPERSONAXDOCUMENTO
	 * @param DOCUMENTO
	 * @return PERSONA
	 */
	public Persona findPersonaXDocumento(String documento) {
		try {
			Persona p = new Persona();

			PreparedStatement st = Conexion.getConnection().prepareStatement(PERSONA_X_DOCUMENTO);
			st.setString(1, documento);
			ResultSet resultado = st.executeQuery();

			while (resultado.next()) {
				p.setId(resultado.getInt("ID_PERSONA"));
				p.setDocumento(resultado.getString("DOCUMENTO"));
				p.setNombre1(resultado.getString("NOMBRE1"));
				p.setNombre2(resultado.getString("NOMBRE2"));
				p.setApellido1(resultado.getString("APELLIDO1"));
				p.setApellido2(resultado.getString("APELLIDO2"));
				p.setEmail(resultado.getString("EMAIL"));
				p.setFechaNac(resultado.getDate("FECHA_NAC"));
				Rol rol = new Rol(resultado.getInt("ROL_ID"), resultado.getString("ROL_NOMBRE"),
						resultado.getString("ROL_DESCRIPCION"));
				p.setRol(rol);
			}

			return p;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
//**********************************MÉTODO PARA LOGUEAR EN LA TABLA PERSONAS*********************************************************************************
	/**
	 * LOGIN
	 * @param EMAIL
	 * @param PASS
	 * @return PERSONA
	 */
	public static Persona login(String email, String pass) {
		try {
			Persona p = new Persona();

			PreparedStatement st = Conexion.getConnection().prepareStatement(LOGIN);
			st.setString(1, email);
			st.setString(2, pass);
			ResultSet resultado = st.executeQuery();

			if (!resultado.next()) {				
				return null;
			}

			p.setId(resultado.getInt("ID"));
			p.setDocumento(resultado.getString("DOCUMENTO"));
			p.setNombre1(resultado.getString("NOMBRE1"));
			p.setNombre2(resultado.getString("NOMBRE2"));
			p.setApellido1(resultado.getString("APELLIDO1"));
			p.setApellido2(resultado.getString("APELLIDO2"));
			p.setEmail(resultado.getString("EMAIL"));
			p.setFechaNac(resultado.getDate("FECHA_NAC"));
			Rol rol = new Rol(resultado.getInt("ROL_ID"), resultado.getString("ROL_NOMBRE"),
					resultado.getString("ROL_DESCRIPCION"));
			p.setRol(rol);

			return p;
		} catch (Exception ex) {
			System.err.println(ex.getStackTrace());
			Auxiliar.avisar(ex.getMessage(), "error");
			return null;
		}
	}
	
//**********************************MÉTODO PARA ELIMINAR REGISTROS DE LA TABLA PERSONAS********************************************************************	
	/**
	 * DELETE
	 * @param PERSONA
	 * @return BOOLEAN
	 */
	public static Boolean delete(Persona p) {
		try {

			PreparedStatement st = Conexion.getConnection().prepareStatement(DELETE);
			st.setString(1, p.getDocumento());
			return (st.executeUpdate() > 0) ? true : false;

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
//***********************************MÉTODO PARA OBTENER UNA PERSONA DE LA TABLA PERSONAS****************************************************************
	/**
	 * OBTENER PERSONA DESDE BASE DE DATOS
	 * @param MAIL
	 * @param PASS
	 * @return UNA PERSONA EN CASO DE QUE LA ENCUENTRE
	 */
	public static LinkedList<Persona> obtenerDesdeBD(String email, String pass) throws Exception {
		try {
			PreparedStatement miConsulta = Conexion.getConnection().prepareStatement(OBTENER_TODOS);
			miConsulta.setString(1, email);
			miConsulta.setString(2, pass);
			ResultSet personasRS = miConsulta.executeQuery();

			LinkedList<Persona> personas = new LinkedList<Persona>();

			if (personasRS != null) {
				while (personasRS.next()) {

					Persona p = new Persona();
					p.setDocumento(personasRS.getString("DOCUMENTO"));
					p.setApellido1(personasRS.getString("APELLIDO1"));
					p.setApellido2(personasRS.getString("APELLIDO2"));
					p.setNombre1(personasRS.getString("NOMBRE1"));
					p.setNombre2(personasRS.getString("NOMBRE2"));
					p.setFechaNac(personasRS.getDate("FECHA_NAC"));
					p.setPass(personasRS.getString("PASS"));
					p.setEmail(personasRS.getString("EMAIL"));

					Rol r = new Rol();
					r.setId(personasRS.getInt("ROL_ID"));
					r.setNombre(personasRS.getString("ROL_NOMBRE"));
					r.setDescripcion(personasRS.getString("ROL_DESCRIPCION"));

					p.setRol(r);

					personas.add(p);
				}
				return personas;
			} else {
				System.out.println("ES NULO ----------------------");
				return null;
			}

		} catch (SQLException e) {
			throw new Exception(e.getMessage() + " > " + e.getStackTrace());
		}

	}
//******************************************************************************************************************************************************

}
