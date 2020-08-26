package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

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
		this.visFuncionalidad = vista;
		
//		DefaultTableModel modelo = new DefaultTableModel();
//		final String[] columnNames = { "Id", "Nombre", "Descripción" };
//		for (int column = 0; column < columnNames.length; column++) {
//			modelo.addColumn(columnNames[column]);
//		}
//		Object[] fila = new Object[columnNames.length];
//		LinkedList<Funcionalidad> funs = DAOFuncionalidad.findAll(); 
//		for (int i = 0; i < funs.size(); i++) {
//			int id = funs.get(i).getId();
//			String nombre = funs.get(i).getNombre();
//			String descripcion = funs.get(i).getDescripcion();
//			fila[0] = id;
//			fila[1] = nombre;
//			fila[2] = descripcion;
//			modelo.addRow(fila);
//		}
//		this.visFuncionalidad.table.setModel(modelo);
////		JScrollPane scrollPane = new JScrollPane(this.visFuncionalidad.table);
		
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
//		this.visFuncionalidad.setVisible(true);

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
		String id = this.visFuncionalidad.textId.getText();
		String nombre = this.visFuncionalidad.textNombre.getText();
		String descripcion = this.visFuncionalidad.textDescripcion.getText();

		if (this.controlVacio(id) || this.controlVacio(nombre) || this.controlVacio(descripcion)) {
			Auxiliar.avisar("Los campos no pueden estar vacíos", "info");
			return;
		}

		int idx = Integer.parseInt(id);
		this.funcionalidad.setId(idx);
		this.funcionalidad.setNombre(nombre);
		this.funcionalidad.setDescripcion(descripcion);
		if (DAOFuncionalidad.updateFuncionalidad(this.funcionalidad)) {
			this.clean();
			Auxiliar.avisar("Se actaulizó la funcionalidad", "info");
		} else {
			Auxiliar.avisar("No se actaulizó la funcionalidad", "error");
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
			Auxiliar.avisar("Se creó la funcionalidad", "info");
		} else {
			Auxiliar.avisar("No se pudo craer la funcionalidad", "error");
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