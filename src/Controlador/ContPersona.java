/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.xml.crypto.Data;

import Inicio.Auxiliar;
import Modelo.DAOFuncionalidad;
import Modelo.DAOPersona;
import Modelo.DAORol;
import Modelo.Persona;
import Modelo.Rol;
import Vista.VisPersona;

public class ContPersona<Date> implements ActionListener {
	private VisPersona vispersona;
	private Persona persona;
	private DAOPersona dp;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public ContPersona(VisPersona vispersona) {

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

	/**
	 * 
	 */
	public void cargarComboRoles() {
		DefaultComboBoxModel modelo = new DefaultComboBoxModel();
		LinkedList<Rol> lista = new LinkedList<Rol>();
		lista = DAORol.findAll();

		for (Object rol : lista) {
			modelo.addElement(rol);
		}
		vispersona.comboRol.setModel(modelo);
	}

	/**
	 * 
	 */
	public void delete() {
		String documento = this.vispersona.textDocumento.getText();
		if (this.controlVacio(documento)) {
			Auxiliar.avisar("El campo documento no puede estar vac�o", "info");
			return;
		}
		int sino = JOptionPane.showConfirmDialog(null, "Seguro que quiere eliminar este registro?", "Confirmar",
				JOptionPane.YES_NO_OPTION);
		if (sino == JOptionPane.YES_OPTION) {
			this.persona = new Persona();
			this.persona.setDocumento(documento);
			if (DAOPersona.delete(this.persona)) {
				this.clean();
				Auxiliar.avisar("Se elimin� el registro de persona", "info");
			} else {
				Auxiliar.avisar("No se pudo eliminar el registro", "info");
			}
		}
	}

	/**
	 * 
	 */
	public void update() {
		String documento = this.vispersona.textDocumento.getText();
		String apellido1 = this.vispersona.textApellido1.getText();
		String apellido2 = this.vispersona.textApellido2.getText();
		String nombre1 = this.vispersona.textNombre1.getText();
		String nombre2 = this.vispersona.textNombre2.getText();
		LocalDate fn = LocalDate.parse(this.vispersona.textFN.getText(), this.formatter);
		String clave = this.vispersona.textClave.getText();
		Rol rol = (Rol) this.vispersona.comboRol.getSelectedItem();
		String email = this.vispersona.textEmail.getText();

		if (this.controlVacio(documento) || this.controlVacio(apellido1) || this.controlVacio(apellido2)
				|| this.controlVacio(nombre1) || this.controlVacio(nombre2) || this.controlVacio(clave)) {
			Auxiliar.avisar("Los campos no pueden estar vac�os", "info");
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

	/**
	 * 
	 */
	public void insert() {
		String documento = this.vispersona.textDocumento.getText();
		String apellido1 = this.vispersona.textApellido1.getText();
		String apellido2 = this.vispersona.textApellido2.getText();
		String nombre1 = this.vispersona.textNombre1.getText();
		String nombre2 = this.vispersona.textNombre2.getText();
		LocalDate fn = LocalDate.parse(this.vispersona.textFN.getText(), this.formatter);
		String clave = this.vispersona.textClave.getText();
		String email = this.vispersona.textEmail.getText();
		Rol rol = (Rol) this.vispersona.comboRol.getSelectedItem();

		if (this.controlVacio(documento) || this.controlVacio(nombre1) || this.controlVacio(apellido1)) {
			JOptionPane.showMessageDialog(null, "Los campos no pueden estar vac�os", "Error",
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

	/**
	 * 
	 */
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

	/**
	 * 
	 * @param txt
	 * @return
	 */
	public boolean controlVacio(String txt) {
		return txt.isEmpty();
	}
}
