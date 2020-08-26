package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import Inicio.Auxiliar;
import Modelo.DAOPersona;
import Modelo.Funcionalidad;
import Modelo.Persona;
import Modelo.Rol;
import Vista.VisFuncionalidad;

import Vista.VisRol;
import Modelo.DAOFuncionalidad;

public class ContFuncionalidad implements ActionListener {
	private Funcionalidad funcionalidad;
	private VisFuncionalidad visFuncionalidad;

	public ContFuncionalidad(VisFuncionalidad vista) {
		super();
		this.funcionalidad = new Funcionalidad();
		this.visFuncionalidad = visFuncionalidad;
		this.visFuncionalidad.btnEliminar.addActionListener(this);
		this.visFuncionalidad.btnModificar.addActionListener(this);
		this.visFuncionalidad.btnGuardar.addActionListener(this);
	}

	public void actionPerformed(ActionEvent arg0) {

		Object obj = arg0.getSource();
		if (obj == this.visFuncionalidad.btnEliminar) {
			this.delete();
		} else if (obj == this.visFuncionalidad.btnGuardar) {
			this.insert();
		} else if (obj == this.visFuncionalidad.btnModificar) {
			this.update();
		}
	}

	public void iniciar() {
		this.visFuncionalidad.setVisible(true);

	}

	public void delete() {
		String nombre = this.visFuncionalidad.textNombre.getText();
		if (this.controlVacio(nombre)) {
			Auxiliar.avisar("El campo nombre no puede estar vacío", "info");
			return;
		}
		int sino = JOptionPane.showConfirmDialog(null, "Seguro que quiere eliminar este registro?", "Confirmar",
				JOptionPane.YES_NO_OPTION);
		if (sino == JOptionPane.YES_OPTION) {
			this.funcionalidad = new Funcionalidad();
			this.funcionalidad.setNombre(nombre);
			if (DAOFuncionalidad.delete(this.funcionalidad)) {
				this.clean();
				Auxiliar.avisar("Se eliminó el registro de persona", "info");
			} else {
				Auxiliar.avisar("No se pudo eliminar el registro", "info");
			}
		}
	}

	public void update() {
		String nombre = this.visFuncionalidad.textNombre.getText();
		String descripcion = this.visFuncionalidad.textDescripcion.getText();

		if (this.controlVacio(nombre) || this.controlVacio(descripcion)) {
			Auxiliar.avisar("Los campos no pueden estar vacíos", "info");
			return;
		}
		this.DAOFuncionalidad = new Funcionalidad(descripcion, nombre);
		if (DAOFuncionalidad.updateRol(this.funcionalidad)) {
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
		String nombre = this.visFuncionalidad.textNombre.getText();
		String descripcion = this.visFuncionalidad.textDescripcion.getText();

		if (this.controlVacio(nombre) || this.controlVacio(descripcion)) {
			Auxiliar.avisar("Los campos no pueden estar vacíos", "info");
			return;
		}
		this.funcionalidad = new Funcionalidad(descripcion, nombre);
		if (DAOFuncionalidad.insertFuncionalidad(this.funcionalidad)) {
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
		this.visFuncionalidad.textNombre.setText(null);
		this.visFuncionalidad.textDescripcion.setText(null);

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