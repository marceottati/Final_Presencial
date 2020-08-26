/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import Modelo.DAOFuncionalidad;
import Modelo.DAORol;
import Modelo.Funcionalidad;
import Modelo.Rol;
import Vista.VisRol;

public class ContRol implements ActionListener {
	private Rol rol;
	private VisRol vista;

	public ContRol(VisRol vista) {
		super();
		this.rol = new Rol();
		this.vista = vista;
		this.vista.btnAgregar.addActionListener(this);
		this.vista.btnEliminar.addActionListener(this);
		this.vista.btnModificar.addActionListener(this);
		this.vista.btnBuscar.addActionListener(this);
		this.vista.btnLimpiar.addActionListener(this);
	}

	public void mostrar() {
		this.vista.setVisible(true);
		this.vista.setTitle("CRUD - Rol");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == this.vista.btnEliminar) {
			this.delete();
		} else if (obj == this.vista.btnModificar) {
			this.update();
		} else if (obj == this.vista.btnBuscar) {
			this.search();
		} else if (obj == this.vista.btnAgregar) {
			this.insert();
		} else if (obj == this.vista.btnLimpiar) {
			this.clearTable(this.vista.table);
		}
	}

	public boolean controlVacio(String txt) {
		return txt.isEmpty();
	}

	public void clean() {
		this.vista.txtNombre.setText(null);
		this.vista.txtDescripcion.setText(null);
	}

	public void update() {
		String nombre = this.vista.txtNombre.getText();
		String descripcion = this.vista.txtDescripcion.getText();

		if (controlVacio(nombre) || controlVacio(descripcion)) {
			JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacíos", "Error",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		this.rol.setDescripcion(descripcion);
		this.rol.setNombre(nombre);
		if (DAORol.updateRol(this.rol)) {
			this.clean();
			JOptionPane.showMessageDialog(null, "Exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "No se pudo modificar el registro", "Error",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void delete() {
		String id = this.vista.txtId.getText();
		if (this.controlVacio(id)) {
			JOptionPane.showMessageDialog(null, "El campo ID no puede estar vacío", "Error",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		int sino = JOptionPane.showConfirmDialog(null, "Seguro que quiere eliminar este registro?", "Confirmar",
				JOptionPane.YES_NO_OPTION);
		if (sino == JOptionPane.YES_OPTION) {
			if (DAORol.delete(id)) {
				this.clean();
				JOptionPane.showMessageDialog(null, "Exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro", "Error",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void insert() {
		String nombre = this.vista.txtNombre.getText();
		String descripcion = this.vista.txtDescripcion.getText();
		if (this.controlVacio(nombre) || this.controlVacio(descripcion)) {
			JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacíos", "Error",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		this.rol = new Rol();
		this.rol.setNombre(nombre);
		this.rol.setDescripcion(descripcion);
		if (DAORol.insertRol(this.rol)) {
			this.clean();
			JOptionPane.showMessageDialog(null, "Exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "No se pudo crear el registro", "Error",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static String[][] obtenerMatriz() {

		LinkedList<Rol> rol = DAORol.findAll();

		String matrizInfo[][] = new String[rol.size()][5];

		for (int i = 0; i < rol.size(); i++) {
			matrizInfo[i][0] = rol.get(i).getId() + "";
			matrizInfo[i][1] = rol.get(i).getNombre() + "";
			matrizInfo[i][2] = rol.get(i).getDescripcion() + "";
		}
		return matrizInfo;
	}

	public void clearTable(final JTable table) {
		for (int i = 0; i < table.getRowCount(); i++) {
			for (int j = 0; j < table.getColumnCount(); j++) {
				table.setValueAt("", i, j);
			}
		}
	}

	public void search() {
		int id = Integer.parseInt(this.vista.txtId.getText());
		LinkedList<Rol> rol = DAORol.findRol(id);
		this.clearTable(this.vista.table);
		String matrizInfo[][] = new String[rol.size()][5];
		for (int i = 0; i < rol.size(); i++) {
			matrizInfo[i][0] = rol.get(i).getId() + "";
			matrizInfo[i][1] = rol.get(i).getNombre() + "";
			matrizInfo[i][2] = rol.get(i).getDescripcion() + "";
		}
		this.vista.construirTabla(matrizInfo);
	}

	/*
	 * public void obtFunc() { LinkedList<Funcionalidad> func =
	 * DAOFuncionalidad.findAll(); for (Funcionalidad f : func) {
	 * this.vista.cbFuncionalidad.addItem(f.getNombre()); } } }
	 */
}
