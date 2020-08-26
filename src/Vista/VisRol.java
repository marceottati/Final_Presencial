package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlador.ContRol;
import Modelo.DAOFuncionalidad;
import Modelo.Funcionalidad;
import Modelo.Rol;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import java.awt.Font;

public class VisRol extends JFrame {

	private JPanel contentPane;
	public JTextField txtId;
	public JTextField txtNom;
	public JTextField txtDesc;
	public JButton btnModificar;
	public JButton btnRegistrar;
	public JButton btnEliminar;
	private JScrollPane scrollRol;
	public JTable tablaRol;
	public JTextField txtBuscar;
	public JButton btnBuscar;
	private JTable TablaRol;
	public JTable Tabla_Rol;
	private JScrollPane scrollPane;
	private JTable TablaFunc;
	public JTable tablaRolFunc;
	public JButton btnAgregarFunc;
	public JButton btnEliminarFunc;
	public JComboBox cbFunc;
	private JLabel lblNewLabel;
	public JButton btnNewButton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisRol frame = new VisRol();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VisRol() {
		setTitle("Mantenimiento de roles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ID = new JLabel("ID");
		ID.setBounds(10, 22, 46, 14);
		contentPane.add(ID);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 53, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblNewLabel_1_1 = new JLabel("Descripcion");
		lblNewLabel_1_1.setBounds(10, 92, 58, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtId = new JTextField();
		txtId.setBounds(78, 19, 170, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(78, 50, 170, 20);
		contentPane.add(txtNom);
		
		txtDesc = new JTextField();
		txtDesc.setColumns(10);
		txtDesc.setBounds(78, 89, 170, 20);
		contentPane.add(txtDesc);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistrar.setBounds(282, 13, 89, 23);
		contentPane.add(btnRegistrar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnEliminar.setBounds(282, 44, 89, 23);
		contentPane.add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.setBounds(282, 83, 89, 23);
		contentPane.add(btnModificar);
		
		scrollRol = new JScrollPane();
		scrollRol.setBounds(406, 64, 263, 315);
		contentPane.add(scrollRol);
		
		construirTabla(ContRol.obtenerMatriz());
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(406, 33, 67, 20);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(483, 30, 89, 23);
		contentPane.add(btnBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 231, 297, 127);
		contentPane.add(scrollPane);
		
		tablaRolFunc = new JTable();
		tablaRolFunc.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Identificador", "Nombre", "Descripcion"
			}
		));
		scrollPane.setViewportView(tablaRolFunc);
		
		btnAgregarFunc = new JButton("+");
		btnAgregarFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		btnAgregarFunc.setBounds(172, 197, 46, 23);
		contentPane.add(btnAgregarFunc);
		
		cbFunc = new JComboBox();
		cbFunc.setBounds(23, 198, 115, 20);
		contentPane.add(cbFunc);
		
		DefaultComboBoxModel modelo = new DefaultComboBoxModel();
		LinkedList<Funcionalidad> lista = new LinkedList<Funcionalidad>();
		lista = DAOFuncionalidad.findAll();
		for (Funcionalidad func: lista) {
			modelo.addElement(func);
		}
		cbFunc.setModel(modelo);
		
		btnEliminarFunc = new JButton("-");

		btnEliminarFunc.setBounds(228, 197, 46, 23);
		contentPane.add(btnEliminarFunc);
		
		lblNewLabel = new JLabel("Funcionalidades del ROL seleccionado");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(23, 160, 281, 14);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("Limpiar");
		btnNewButton.setBounds(580, 30, 89, 23);
		contentPane.add(btnNewButton);
	}
	
	public void construirTabla(String [][] info) {
		String titulos[] = {"Identificador", "Nombre", "Descripcion"};
		Tabla_Rol = new JTable();
		Tabla_Rol.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int filaSeleccionada=Tabla_Rol.getSelectedRow();
				if(filaSeleccionada>-1) {
					txtId.setText((String)Tabla_Rol.getValueAt(filaSeleccionada, 0).toString());
					txtNom.setText((String)Tabla_Rol.getValueAt(filaSeleccionada, 1));
					txtDesc.setText((String) Tabla_Rol.getValueAt(filaSeleccionada, 2));
				}
				VisRol v = new VisRol();
				ContRol c = new ContRol(v);
				crearTablaFunc(c.searchFunc(txtId.getText()));
			}
		});
		Tabla_Rol.setModel( new DefaultTableModel(
			info,
			titulos
		) );
		scrollRol.setViewportView(Tabla_Rol);
	}
	
	public void crearTablaFunc(String [][] info) {
		String titulos[] = {"Identificador", "Nombre", "Descripcion"};
		tablaRolFunc= new JTable(); 
		tablaRolFunc.setModel( new DefaultTableModel(
				info,
				titulos
			) );
		scrollPane.setViewportView(tablaRolFunc);
	}
}
