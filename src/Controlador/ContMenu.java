package Controlador;

import Vista.VisFuncionalidad;
import Vista.VisMenu;
import Vista.VisPersona;
import Vista.VisRol;
import Modelo.Persona;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContMenu implements ActionListener {

	private VisMenu vistaMenu;
	private Persona persona;

	public ContMenu(VisMenu vm, Persona p) {
		this.vistaMenu = vm;
		this.persona = p;
		this.vistaMenu.lblBienvenido.setText("\u00A1BIENVENIDO " + p.getNombre1() + "!");
		this.vistaMenu.btnRoles.addActionListener(this);
		this.vistaMenu.btnPersona.addActionListener(this);
		this.vistaMenu.btnFuncionalidades.addActionListener(this);
	}

	public void mostrar() {
		this.vistaMenu.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == this.vistaMenu.btnPersona) {
			VisPersona vp = new VisPersona();
			ContPersona cvp = new ContPersona(vp);
			cvp.iniciar();
		} else if (obj == this.vistaMenu.btnRoles) {
			VisRol vr = new VisRol();
			ContRol cvr = new ContRol(vr);
			cvr.mostrar();
		}else if (obj == this.vistaMenu.btnFuncionalidades) {
			VisFuncionalidad vf = new VisFuncionalidad();
			ContFuncionalidad cvf = new ContFuncionalidad(vf);
			cvf.iniciar();
		}
	}

}
