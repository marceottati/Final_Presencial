
/*
  
ÚLTIMAS MODIFICACIONES -----------
20200825 > Landro > modificación > login, insert, update
VAMO LO PIBE
*/

package Modelo;

import Inicio.Auxiliar;
import Inicio.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DAOPersona {

	// *************************************SENTENCIAS PRECOMPILADAS TABLA
	// PERSONAS**********************************************************************************
	private static final String txt = "p.*, r.NOMBRE ROL_NOMBRE, r.DESCRIPCION ROL_DESCRIPCION FROM PERSONAS p INNER JOIN ROLES r ON p.ROL_ID = r.ID";
	private static final String PERSONA_X_DOCUMENTO = "SELECT " + txt + " WHERE DOCUMENTO=?";
	private static final String LOGIN = "SELECT " + txt + " WHERE EMAIL=? AND PASS=?";
	private static final String INSERT_PERSONAS = "INSERT INTO PERSONAS (DOCUMENTO, APELLIDO1, APELLIDO2, NOMBRE1, NOMBRE2, FECHA_NAC, PASS, ROL_ID, EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_PERSONAS = "UPDATE PERSONAS SET DOCUMENTO=?, APELLIDO1=?, APELLIDO2=?, NOMBRE1=?, NOMBRE2=?, FECHA_NAC=?, PASS=?, ROL_ID=?, EMAIL=? WHERE ID=?";
	private static final String OBTENER_TODOS = "SELECT " + txt + " WHERE p.EMAIL = ? AND p.PASS = ?";
	private static final String DELETE = "DELETE FROM PERSONAS WHERE p.DOCUMENTO = ?";

	/**
	 * INSERT
	 * 
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

	/**
	 * UPDATE
	 * 
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

	/**
	 * Encuentra una persona en base de dato basándose en su documento
	 * 
	 * @param Persona Persona con documento a buscar
	 * @return Persona Persona en caso que encuentre un registro que coincida, de lo
	 *         contrario devuelve null
	 */
	public Persona findPersonaXDocumento(Persona p) {
		try {
			PreparedStatement st = Conexion.getConnection().prepareStatement(PERSONA_X_DOCUMENTO);
			st.setString(1, p.getDocumento());
			ResultSet resultado = st.executeQuery();

			if (resultado.next() == false) {
				return null;
			}
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

			return p;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	/**
	 * 
	 * 
	 * @param Persona
	 * @return PERSONA
	 */
	public static Persona login(Persona p) {
		try {
			PreparedStatement st = Conexion.getConnection().prepareStatement(LOGIN);
			st.setString(1, p.getEmail());
			st.setString(2, p.getPass());
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

	/**
	 * DELETE
	 * 
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
}
