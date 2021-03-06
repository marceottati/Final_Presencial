package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisPersona extends JFrame{

	public JFrame frmMantenimientoDePersona;
	public JTextField textDocumento;
	public JTextField textNombre1;
	public JTextField textNombre2;
	public JTextField textApellido1;
	public JTextField textApellido2;
	public JTextField textFN;
	public JTextField textClave;
	public JTextField textEmail;
	public JButton btnGuardar;
	public JButton btnEliminar;
	public JButton btnEditar;
	public JComboBox comboRol;


	/**
	 * Create the application.
	 */
	public VisPersona() {
		initialize();
		this.frmMantenimientoDePersona.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMantenimientoDePersona = new JFrame();
		frmMantenimientoDePersona.setTitle("Mantenimiento de Persona");
		frmMantenimientoDePersona.setBounds(100, 100, 736, 473);
		frmMantenimientoDePersona.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMantenimientoDePersona.getContentPane().setLayout(null);

		textDocumento = new JTextField();
		textDocumento.setBounds(112, 45, 134, 20);
		frmMantenimientoDePersona.getContentPane().add(textDocumento);
		textDocumento.setColumns(10);

		textNombre1 = new JTextField();
		textNombre1.setBounds(112, 76, 134, 20);
		frmMantenimientoDePersona.getContentPane().add(textNombre1);
		textNombre1.setColumns(10);

		textNombre2 = new JTextField();
		textNombre2.setBounds(112, 107, 134, 20);
		frmMantenimientoDePersona.getContentPane().add(textNombre2);
		textNombre2.setColumns(10);

		textApellido1 = new JTextField();
		textApellido1.setBounds(112, 140, 134, 20);
		frmMantenimientoDePersona.getContentPane().add(textApellido1);
		textApellido1.setColumns(10);

		textApellido2 = new JTextField();
		textApellido2.setBounds(112, 175, 134, 20);
		frmMantenimientoDePersona.getContentPane().add(textApellido2);
		textApellido2.setColumns(10);

		textFN = new JTextField();
		textFN.setBounds(112, 206, 134, 20);
		frmMantenimientoDePersona.getContentPane().add(textFN);
		textFN.setColumns(10);

		textClave = new JTextField();
		textClave.setBounds(112, 237, 134, 20);
		frmMantenimientoDePersona.getContentPane().add(textClave);
		textClave.setColumns(10);

		textEmail = new JTextField();
		textEmail.setBounds(112, 268, 134, 20);
		frmMantenimientoDePersona.getContentPane().add(textEmail);
		textEmail.setColumns(10);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(339, 18, 352, 382);
		frmMantenimientoDePersona.getContentPane().add(tabbedPane);

		JLabel documento = new JLabel("Documento");
		documento.setHorizontalAlignment(SwingConstants.RIGHT);
		documento.setBounds(17, 45, 85, 14);
		frmMantenimientoDePersona.getContentPane().add(documento);

		JLabel nombre1 = new JLabel("Nombre 1");
		nombre1.setHorizontalAlignment(SwingConstants.RIGHT);
		nombre1.setBounds(29, 76, 73, 14);
		frmMantenimientoDePersona.getContentPane().add(nombre1);

		JLabel nombre2 = new JLabel("Nombre 2");
		nombre2.setHorizontalAlignment(SwingConstants.RIGHT);
		nombre2.setBounds(29, 107, 73, 14);
		frmMantenimientoDePersona.getContentPane().add(nombre2);

		JLabel apellido1 = new JLabel("Apellido 1");
		apellido1.setHorizontalAlignment(SwingConstants.RIGHT);
		apellido1.setBounds(29, 140, 73, 14);
		frmMantenimientoDePersona.getContentPane().add(apellido1);

		JLabel apellido2 = new JLabel("Apellido 2");
		apellido2.setHorizontalAlignment(SwingConstants.RIGHT);
		apellido2.setBounds(29, 175, 73, 14);
		frmMantenimientoDePersona.getContentPane().add(apellido2);

		JLabel fNacimiento = new JLabel("F. Nacimiento");
		fNacimiento.setHorizontalAlignment(SwingConstants.RIGHT);
		fNacimiento.setBounds(10, 206, 92, 14);
		frmMantenimientoDePersona.getContentPane().add(fNacimiento);

		JLabel clave = new JLabel("Clave");
		clave.setHorizontalAlignment(SwingConstants.RIGHT);
		clave.setBounds(48, 237, 54, 14);
		frmMantenimientoDePersona.getContentPane().add(clave);

		JLabel email = new JLabel("Email");
		email.setHorizontalAlignment(SwingConstants.RIGHT);
		email.setBounds(48, 268, 54, 14);
		frmMantenimientoDePersona.getContentPane().add(email);

		JLabel rol = new JLabel("Rol");
		rol.setHorizontalAlignment(SwingConstants.RIGHT);
		rol.setBounds(60, 327, 42, 14);
		frmMantenimientoDePersona.getContentPane().add(rol);

		comboRol = new JComboBox();
		comboRol.setBounds(112, 324, 134, 20);
		frmMantenimientoDePersona.getContentPane().add(comboRol);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {

			/**
			 *EVENTO PARA GUARDAR UNA PERSONA 
			 */
			
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGuardar.setBounds(10, 377, 89, 23);
		frmMantenimientoDePersona.getContentPane().add(btnGuardar);

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(109, 377, 89, 23);
		frmMantenimientoDePersona.getContentPane().add(btnEditar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(209, 377, 89, 23);
		frmMantenimientoDePersona.getContentPane().add(btnEliminar);
	}
}
