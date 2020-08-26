package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class VisLogin extends JFrame {

	private JPanel contentPane;
	public JTextField txtEmail;
	public JPasswordField txtPass;
	public JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisLogin frame = new VisLogin();
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
	public VisLogin() {
		setTitle("Acceso de usuarios");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(72, 33, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(72, 50, 363, 47);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a:");
		lblPass.setBounds(72, 108, 100, 14);
		contentPane.add(lblPass);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(72, 125, 363, 47);
		contentPane.add(txtPass);
		
		btnLogin = new JButton("Entrar");
		btnLogin.setBounds(290, 186, 145, 47);
		contentPane.add(btnLogin);
	}
}
