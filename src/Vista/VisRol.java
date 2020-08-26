package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlador.ContRol;

public class VisRol extends JFrame {
//
//	private JPanel contentPane;
//	public JTextField txtId;
//	public JTextField txtNom;
//	public JTextField txtDesc;
//	public JButton btnModificar;
//	public JButton btnRegistrar;
//	public JButton btnEliminar;
//	private JScrollPane scrollRol;
//	public JTable tablaRol;
//	public JTextField txtBuscar;
//	public JButton btnBuscar;
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VisRol frame = new VisRol();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public VisRol() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 695, 378);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JLabel ID = new JLabel("ID");
//		ID.setBounds(10, 22, 46, 14);
//		contentPane.add(ID);
//		
//		JLabel lblNombre = new JLabel("Nombre");
//		lblNombre.setBounds(10, 53, 46, 14);
//		contentPane.add(lblNombre);
//		
//		JLabel lblNewLabel_1_1 = new JLabel("Descripcion");
//		lblNewLabel_1_1.setBounds(10, 92, 58, 14);
//		contentPane.add(lblNewLabel_1_1);
//		
//		txtId = new JTextField();
//		txtId.setBounds(78, 19, 86, 20);
//		contentPane.add(txtId);
//		txtId.setColumns(10);
//		
//		txtNom = new JTextField();
//		txtNom.setColumns(10);
//		txtNom.setBounds(78, 50, 86, 20);
//		contentPane.add(txtNom);
//		
//		txtDesc = new JTextField();
//		txtDesc.setColumns(10);
//		txtDesc.setBounds(78, 89, 86, 20);
//		contentPane.add(txtDesc);
//		
//		btnRegistrar = new JButton("Registrar");
//		btnRegistrar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnRegistrar.setBounds(224, 18, 89, 23);
//		contentPane.add(btnRegistrar);
//		
//		btnEliminar = new JButton("Eliminar");
//		btnEliminar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
//		btnEliminar.setBounds(224, 49, 89, 23);
//		contentPane.add(btnEliminar);
//		
//		btnModificar = new JButton("Modificar");
//		btnModificar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnModificar.setBounds(224, 88, 89, 23);
//		contentPane.add(btnModificar);
//		
//		scrollRol = new JScrollPane();
//		scrollRol.setBounds(406, 64, 263, 294);
//		contentPane.add(scrollRol);
//		
//		txtBuscar = new JTextField();
//		txtBuscar.setBounds(406, 33, 131, 20);
//		contentPane.add(txtBuscar);
//		txtBuscar.setColumns(10);
//		
//		btnBuscar = new JButton("Buscar");
//		btnBuscar.setBounds(547, 30, 89, 23);
//		contentPane.add(btnBuscar);
//		
//		construirTabla(ContRol.obtenerMatriz());
//	}
//	
//	public void construirTabla(String [][] info) {
//		String titulos[] = {"Identificador", "Nombre", "Descripcion"};
//		//String info [][] = ControladorPersona.obtenerMatriz();
//		tablaRol = new JTable(info,titulos);
//		scrollRol.setViewportView(tablaRol);
//	}
}
