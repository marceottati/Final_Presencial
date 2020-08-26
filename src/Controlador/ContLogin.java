package Controlador;

import Vista.VisLogin;
import Modelo.DAOPersona;
import Vista.VisMenu;
import Modelo.Persona;
import Modelo.Funcionalidad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import Inicio.Auxiliar;

public class ContLogin implements ActionListener {

	private VisLogin vistaLogin;
	private Persona persona;

	// public ContLogin(VisLogin vistaLogin, Persona persona, Funcionalidad
	// funcionalidad, Connection conexion) {
	public ContLogin(VisLogin vistaLogin) {
		this.vistaLogin = vistaLogin;
		this.persona = new Persona();
	}

	public void mostrarLogin() {
		this.vistaLogin.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == this.vistaLogin.btnLogin) {
			String email = vistaLogin.txtEmail.getText();
			String pass = vistaLogin.txtPass.getText();
			if (email.equals("") || pass.equals("")) {
				Auxiliar.avisar("Los campos email y contraseña son obligatorios", "error");
				return;
			}
			this.login(email, pass);
		}
	}

	public void login(String email, String pass) {

		this.persona = DAOPersona.login(email, pass);
		VisMenu vm = new VisMenu();
		vm.setVisible(this.persona);
	}

}
