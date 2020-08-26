package Vista;

import Modelo.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisMenu extends JFrame {

	private JPanel contentPane;
	private static Persona persona;
	private JLabel lblBienvenido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisMenu frame = new VisMenu();
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
	public VisMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblBienvenido = new JLabel("\u00A1BIENVENIDO!");
		lblBienvenido.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setBounds(10, 44, 684, 31);
		contentPane.add(lblBienvenido);
		
		JButton btnPersona = new JButton("Personas");
		btnPersona.setBounds(97, 116, 462, 91);
		contentPane.add(btnPersona);
		
		JButton btnRoles = new JButton("Roles");
		btnRoles.setBounds(97, 219, 225, 91);
		contentPane.add(btnRoles);
		
		JButton btnFuncionalidades = new JButton("Funcionalidades");
		btnFuncionalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFuncionalidades.setBounds(334, 218, 225, 91);
		contentPane.add(btnFuncionalidades);
	}

	public void setVisible(Persona p) {
		this.persona = p;
		this.lblBienvenido.setText("\u00A1BIENVENIDO "+this.persona.getNombre1()+"!");
		this.setVisible(true);
	}
}
