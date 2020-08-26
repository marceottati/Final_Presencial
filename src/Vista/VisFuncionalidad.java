package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Modelo.DAOFuncionalidad;
import Modelo.Funcionalidad;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class VisFuncionalidad extends JFrame {

	public JFrame frmControlDeFuncionalidades;
	public JTextField textId;
	public JTextField textNombre;
	public JTextField textDescripcion;
	public JButton btnGuardar;
	public JButton btnEliminar;
	public JButton btnModificar;
	public JTable table;

	/**
	 * Create the application.
	 */
	public VisFuncionalidad() {
		initialize();
		this.frmControlDeFuncionalidades.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmControlDeFuncionalidades = new JFrame();
		frmControlDeFuncionalidades.setTitle("Control de Funcionalidades");
		frmControlDeFuncionalidades.setBounds(100, 100, 637, 398);
		frmControlDeFuncionalidades.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmControlDeFuncionalidades.getContentPane().setLayout(null);

		textNombre = new JTextField();
		textNombre.setBounds(120, 126, 140, 23);
		frmControlDeFuncionalidades.getContentPane().add(textNombre);
		textNombre.setColumns(10);

		textDescripcion = new JTextField();
		textDescripcion.setBounds(120, 181, 140, 23);
		frmControlDeFuncionalidades.getContentPane().add(textDescripcion);
		textDescripcion.setColumns(10);

		JLabel Nombre = new JLabel("Nombre");
		Nombre.setHorizontalAlignment(SwingConstants.RIGHT);
		Nombre.setBounds(34, 130, 76, 14);
		frmControlDeFuncionalidades.getContentPane().add(Nombre);

		JLabel Descripcion = new JLabel("Descripcion");
		Descripcion.setHorizontalAlignment(SwingConstants.RIGHT);
		Descripcion.setBounds(17, 185, 93, 14);
		frmControlDeFuncionalidades.getContentPane().add(Descripcion);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardar.setBounds(120, 226, 140, 23);
		frmControlDeFuncionalidades.getContentPane().add(btnGuardar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.setBounds(120, 260, 140, 23);
		frmControlDeFuncionalidades.getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(120, 294, 140, 23);
		frmControlDeFuncionalidades.getContentPane().add(btnEliminar);

		table = new JTable();
		table.setBounds(294, 58, 276, 259);
		frmControlDeFuncionalidades.getContentPane().add(table);

		DefaultTableModel modelo = new DefaultTableModel();
		final String[] columnNames = { "Id", "Nombre", "Descripción" };
		for (int column = 0; column < columnNames.length; column++) {
			modelo.addColumn(columnNames[column]);
		}
		Object[] fila = new Object[columnNames.length];
		LinkedList<Funcionalidad> funs = DAOFuncionalidad.findAll(); 
		for (int i = 0; i < funs.size(); i++) {
			int id = funs.get(i).getId();
			String nombre = funs.get(i).getNombre();
			String descripcion = funs.get(i).getDescripcion();
			fila[0] = id;
			fila[1] = nombre;
			fila[2] = descripcion;
			modelo.addRow(fila);
		}
		table.setModel(modelo);
		
		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(120, 79, 140, 23);
		frmControlDeFuncionalidades.getContentPane().add(textId);
		
		JLabel lblId = new JLabel("Id");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(34, 83, 76, 14);
		frmControlDeFuncionalidades.getContentPane().add(lblId);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int filaSeleccionada=table.getSelectedRow();
				if(filaSeleccionada>-1) {					
					textId.setText((String)table.getValueAt(filaSeleccionada, 0).toString());
					textNombre.setText((String)table.getValueAt(filaSeleccionada, 1));
					textDescripcion.setText((String) table.getValueAt(filaSeleccionada, 2));					
				}
			}
		});
	}
}
