/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.xml.crypto.Data;

import Modelo.DAOFuncionalidad;
import Modelo.DAOPersona;
import Modelo.DAORol;
import Modelo.Persona;
import Modelo.Rol;
import Vista.VisPersona;

/**
 *
 * @author tecnico
 * @param <Date>
 */
public class ContVistaPersona<Date> implements ActionListener {
	private VisPersona vispersona;
	private Persona persona;
	private DAOPersona dp;

	public ContVistaPersona(VisPersona vispersona) {

		super();
		this.persona = new Persona();
		this.vispersona = vispersona;
		// this.ventana.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo.png")));
		this.vispersona.btnGuardar.addActionListener(this);
		this.vispersona.btnEditar.addActionListener(this);
		this.vispersona.btnEliminar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		Object obj = arg0.getSource();
		if (obj == this.vispersona.btnEliminar) {
			this.delete();
		} else if (obj == this.vispersona.btnGuardar) {
			this.insert();
		} else if (obj == this.vispersona.btnEditar) {
			this.update();
		}
	}

	public void iniciar() {
		this.vispersona.setVisible(true);
		cargarComboRoles();
	}

	// *************************************************************************************************

	public void cargarComboRoles() {
		this.vispersona.comboRol.add(DAORol.findAll());
	}
	public void delete() {
		String documento = this.vispersona.textDocumento.getText();
		if (this.controlVacio(documento)) {
			JOptionPane.showMessageDialog(null, "El campo documento no puede estar vacío", "Error",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		int sino = JOptionPane.showConfirmDialog(null, "Seguro que quiere eliminar este registro?", "Confirmar",
				JOptionPane.YES_NO_OPTION);
		if (sino == JOptionPane.YES_OPTION) {
			if (DAOPersona.delete(documento)) {
				this.clean();
				JOptionPane.showMessageDialog(null, "Exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro", "Error",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void update() {
		String documento = this.vispersona.textDocumento.getText();
		String apellido1 = this.vispersona.textApellido1.getText();
		String apellido2 = this.vispersona.textApellido2.getText();
		String nombre1 = this.vispersona.textNombre1.getText();
		String nombre2 = this.vispersona.textNombre2.getText();
		java.sql.Date fn = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(this.vispersona.textFN.getText());
		String clave = this.vispersona.textClave.getText();
		Object rol = this.vispersona.comboRol.getSelectedItem();
		String email = this.vispersona.textEmail.getText();

		if (this.controlVacio(documento) || this.controlVacio(apellido1) || this.controlVacio(apellido2)
				|| this.controlVacio(nombre1) || this.controlVacio(nombre2) || this.controlVacio(clave)) {
			JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacíos", "Error",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		this.persona = new Persona(documento, apellido1, apellido2, nombre1, nombre2, fn, clave, email, rol);
		if (DAOPersona.update(this.persona)) {
			this.clean();
			JOptionPane.showMessageDialog(null, "Exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "No se pudo modificar el registro", "Error",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// *************************************************************************************************
	public void insert() {
		String documento = this.vispersona.textDocumento.getText();
		String apellido1 = this.vispersona.textApellido1.getText();
		String apellido2 = this.vispersona.textApellido2.getText();
		String nombre1 = this.vispersona.textNombre1.getText();
		String nombre2 = this.vispersona.textNombre2.getText();
		String fn = this.vispersona.textFN.getText();
		String clave = this.vispersona.textClave.getText();
		String email = this.vispersona.textEmail.getText();
		Object rol = this.vispersona.comboRol.getSelectedItem();

		if (this.controlVacio(documento) || this.controlVacio(nombre1) || this.controlVacio(apellido1)) {
			JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacíos", "Error",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		this.persona = new Persona(documento, apellido1, apellido2, nombre1, nombre2, fn, clave, email, rol);
		if (DAOPersona.insert(this.persona)) {
			this.clean();
			JOptionPane.showMessageDialog(null, "Exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "No se pudo crear el registro", "Error",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	// *******************************METODO LIMPIAR
	// CAMPOS*********************************************
	public void clean() {
		this.vispersona.textDocumento.setText(null);
		this.vispersona.textNombre1.setText(null);
		this.vispersona.textNombre2.setText(null);
		this.vispersona.textApellido1.setText(null);
		this.vispersona.textApellido2.setText(null);
		this.vispersona.textClave.setText(null);
		this.vispersona.textFN.setText(null);
		this.vispersona.textEmail.setText(null);
	}

	// ***********************************METODO COMPROBAR
	// CAMPOS**************************************
	public boolean controlVacio(String txt) {
		return txt.isEmpty();
	}
}
