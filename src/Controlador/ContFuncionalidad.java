package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.Funcionalidad;
import Modelo.Rol;
import Vista.VisFuncionalidad;
//import Vista.VisRol;

public class ContFuncionalidad implements ActionListener {
	private Funcionalidad funcionalidad;
	private VisFuncionalidad vista;

	public ContFuncionalidad(VisFuncionalidad vista) {
		super();
		this.funcionalidad = new Funcionalidad();
		this.vista = vista;
		this.vista.btnEliminar.addActionListener(this);
		this.vista.btnModificar.addActionListener(this);
		this.vista.btnGuardar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}