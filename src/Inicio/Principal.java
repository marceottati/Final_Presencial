package Inicio;

import Vista.VisLogin;
import Controlador.ContLogin;
import java.sql.Connection;
import Modelo.Persona;
import Modelo.Funcionalidad;

public class Principal {

	public static void main(String[] args) {
		try {
			VisLogin login = new VisLogin();
			ContLogin contLogin = new ContLogin(login);
			contLogin.mostrarLogin();

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
}
