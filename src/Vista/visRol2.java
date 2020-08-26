package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JFormattedTextField;

public class visRol2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					visRol2 frame = new visRol2();
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
	public visRol2() {
		setTitle("Mantenimiento Roles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Descripci\u00F3n");
		lblNewLabel.setBounds(37, 69, 74, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(47, 30, 46, 14);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(105, 29, 192, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(105, 67, 192, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEditar.setBounds(108, 129, 89, 23);
		contentPane.add(btnEditar);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(10, 129, 89, 23);
		contentPane.add(btnGuardar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(208, 129, 89, 23);
		contentPane.add(btnEliminar);

		JPanel panel = new JPanel();
		panel.setBounds(343, 32, 305, 342);
		contentPane.add(panel);

		table = new JTable();
		table.setBounds(22, 5, 261, 326);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "NOMBRE", "DESCRIPCION" }));
		table.getColumnModel().getColumn(2).setPreferredWidth(111);
		panel.setLayout(null);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(table);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 197, 287, 177);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblFuncionalidades = new JLabel("Funcionalidades");
		lblFuncionalidades.setBounds(10, 9, 76, 14);
		panel_1.add(lblFuncionalidades);

		JComboBox cboFunc = new JComboBox();
		cboFunc.setBounds(90, 6, 89, 20);
		panel_1.add(cboFunc);

		JButton btnAgregarFunc = new JButton("+");
		btnAgregarFunc.setBounds(189, 5, 41, 23);
		panel_1.add(btnAgregarFunc);

		JButton btnEliminarFunc = new JButton("-");
		btnEliminarFunc.setBounds(240, 5, 37, 23);
		btnEliminarFunc.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1.add(btnEliminarFunc);

		JList listFunc = new JList();
		listFunc.setBorder(new LineBorder(new Color(0, 0, 0)));
		listFunc.setBackground(Color.WHITE);
		listFunc.setBounds(251, 148, -229, -85);
		panel_1.add(listFunc);
	}
}
