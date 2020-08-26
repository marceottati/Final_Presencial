package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

public class VisFuncionalidad {

	public JFrame frmControlDeFuncionalidades;
	public JTextField textNombre;
	public JTextField textDescripcion;
	public JButton btnGuardar;
	public JButton btnEliminar;
	public JButton btnModificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisFuncionalidad window = new VisFuncionalidad();
					window.frmControlDeFuncionalidades.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VisFuncionalidad() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmControlDeFuncionalidades = new JFrame();
		frmControlDeFuncionalidades.setTitle("Control de Funcionalidades");
		frmControlDeFuncionalidades.setBounds(100, 100, 507, 398);
		frmControlDeFuncionalidades.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmControlDeFuncionalidades.getContentPane().setLayout(null);

		textNombre = new JTextField();
		textNombre.setBounds(74, 70, 140, 23);
		frmControlDeFuncionalidades.getContentPane().add(textNombre);
		textNombre.setColumns(10);

		textDescripcion = new JTextField();
		textDescripcion.setBounds(74, 125, 140, 23);
		frmControlDeFuncionalidades.getContentPane().add(textDescripcion);
		textDescripcion.setColumns(10);

		JLabel Nombre = new JLabel("Nombre");
		Nombre.setBounds(27, 74, 37, 14);
		frmControlDeFuncionalidades.getContentPane().add(Nombre);

		JLabel Descripcion = new JLabel("Descripcion");
		Descripcion.setBounds(10, 129, 54, 14);
		frmControlDeFuncionalidades.getContentPane().add(Descripcion);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardar.setBounds(91, 177, 89, 23);
		frmControlDeFuncionalidades.getContentPane().add(btnGuardar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.setBounds(91, 234, 89, 23);
		frmControlDeFuncionalidades.getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(91, 294, 89, 23);
		frmControlDeFuncionalidades.getContentPane().add(btnEliminar);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(224, 23, 237, 308);
		frmControlDeFuncionalidades.getContentPane().add(tabbedPane);
	}
}
