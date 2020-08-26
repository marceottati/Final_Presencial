package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.sound.midi.MidiDevice.Info;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import Inicio.Auxiliar;
import Modelo.DAOFuncionalidad;
import Modelo.DAORol;
import Modelo.Funcionalidad;
import Modelo.Persona;
import Modelo.Rol;
import Vista.VisRol;

public class ContRol implements ActionListener{
	private VisRol vista;
	private Rol rol;
	
	public ContRol(VisRol vista) {
		super();
		this.rol = new Rol();
		this.vista = vista;
		this.vista.btnEliminar.addActionListener(this);
		this.vista.btnModificar.addActionListener(this);
		this.vista.btnRegistrar.addActionListener(this);
		this.vista.btnAgregarFunc.addActionListener(this);
		this.vista.btnBuscar.addActionListener(this);
		this.vista.btnEliminarFunc.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == this.vista.btnEliminar) {
			this.delete();
		} else if (obj == this.vista.btnModificar) {
			this.update();
		}else if (obj== this.vista.btnBuscar) {
			this.search();
		}else if (obj==this.vista.btnRegistrar) {
			this.insert();
		}else if (obj==this.vista.btnAgregarFunc) {
			this.agregarFuncARol();
			this.vista.crearTablaFunc(searchFunc(this.vista.txtId.getText()));
			}else if (obj==this.vista.btnEliminarFunc) {
			this.eliminarFuncARol();
			this.vista.crearTablaFunc(searchFunc(this.vista.txtId.getText()));
		}
	}
	
	public void mostrar() {
		this.vista.setVisible(true);
		this.vista.setTitle("CRUD - Rol");
	}
	
	public void clean() {
		this.vista.txtDesc.setText(null);
		this.vista.txtNom.setText(null);
	}
	
	public boolean controlVacio(String txt) {
		return txt.isEmpty();
	}
	
	public void update() {
		String nom = this.vista.txtNom.getText();
		String desc = this.vista.txtDesc.getText();
		if (this.controlVacio(nom)||this.controlVacio(desc)) {
			JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacíos","Error", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		this.rol = new Rol();
		this.rol.setNombre(nom);
		this.rol.setDescripcion(desc);
		if (DAORol.update(this.rol)) {
			this.clean();
			JOptionPane.showMessageDialog(null, "Exito","Exito", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "No se pudo modificar el registro","Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	


	public void insert() {
		String nom = this.vista.txtNom.getText();
		String desc = this.vista.txtDesc.getText();
		if (this.controlVacio(nom)||this.controlVacio(desc)) {
			JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacíos","Error", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		this.rol = new Rol();
		this.rol.setNombre(nom);
		this.rol.setDescripcion(desc);
		if (DAORol.insert(this.rol)) {
			this.clean();
			JOptionPane.showMessageDialog(null, "Exito","Exito", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "No se pudo crear el registro","Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static void clearTable(final JTable table) {
	   for (int i = 0; i < table.getRowCount(); i++) {
	      for(int j = 0; j < table.getColumnCount(); j++) {
	          table.setValueAt("", i, j);
	      }
	   }
	}
	
	public void search() {
		int id = Integer.parseInt(this.vista.txtBuscar.getText());
		this.rol.setId(id);
		LinkedList<Rol> roles = DAORol.find(this.rol.getId());
		this.clearTable(this.vista.tablaRol);
		String matrizInfo [][] = new String[roles.size()][3];
		for (int i = 0; i < roles.size(); i++) {
			matrizInfo[i][0] = roles.get(i).getId()+"";
			matrizInfo[i][1] = roles.get(i).getNombre()+"";
			matrizInfo[i][2] = roles.get(i).getDescripcion()+"";
		}
		this.vista.construirTabla(matrizInfo);
	}
	
	public static String[][] obtenerMatriz() {
		LinkedList<Rol> roles = DAORol.findAll();
		
		String matrizInfo [][] = new String[roles.size()][3];
		
		for (int i = 0; i < roles.size(); i++) {
			matrizInfo[i][0] = roles.get(i).getId()+"";
			matrizInfo[i][1] = roles.get(i).getNombre()+"";
			matrizInfo[i][2] = roles.get(i).getDescripcion()+"";
		}
		return matrizInfo;
	}
	

	public void delete() {
		String idS = this.vista.txtId.getText();	
		if (this.controlVacio(idS)) {
			JOptionPane.showMessageDialog(null, "El campo del Identificador no puede estar vacío","Error", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		int id = Integer.parseInt(idS);
		int sino = JOptionPane.showConfirmDialog(null, "Seguro que quiere eliminar este registro?","Confirmar",JOptionPane.YES_NO_OPTION);
		if (sino==JOptionPane.YES_OPTION) {
			if (DAORol.delete(id)) {
				this.clean();
				JOptionPane.showMessageDialog(null, "Exito","Exito", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro","Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public String [][] searchFunc(String a) {
		int id = Integer.parseInt(a);
		this.rol = new Rol();
		this.rol.setId(id);
		LinkedList<Funcionalidad> func = DAOFuncionalidad.rol_Func(this.rol.getId());
		ContRol.clearTable(this.vista.tablaRolFunc);
		String matrizInfo [][] = new String[func.size()][3];
		for (int i = 0; i < func.size(); i++) {
			matrizInfo[i][0] = func.get(i).getId()+"";
			matrizInfo[i][1] = func.get(i).getNombre()+"";
			matrizInfo[i][2] = func.get(i).getDescripcion()+"";
		}
		return matrizInfo;
	}
	
	public void LlenarCombo() {
		
	}
	
	public void eliminarFuncARol() {
		int idRol = Integer.parseInt(this.vista.txtId.getText());
		Funcionalidad f = (Funcionalidad) this.vista.cbFunc.getSelectedItem();
		if (DAOFuncionalidad.DELETE_Rol_Func(idRol, f.getId())) {
			Auxiliar.avisar("Se ha eliminado la funcionalidad", "Info");
		}else {
			Auxiliar.avisar("Error al eliminar la funcionalidad", "Error");
		}
	}
	
	public void agregarFuncARol() {
		int idRol = Integer.parseInt(this.vista.txtId.getText());
		Funcionalidad f = (Funcionalidad) this.vista.cbFunc.getSelectedItem();
		if (DAOFuncionalidad.INSERT_Rol_Func(idRol, f.getId())) {
			Auxiliar.avisar("Se agregó correctamente la funcionalidad", "Info");
		}else {
			Auxiliar.avisar("Error al agregar la funcionalidad", "Error");
		}
	}
}
