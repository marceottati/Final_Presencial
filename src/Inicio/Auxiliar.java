package Inicio;

import javax.swing.JOptionPane;

public class Auxiliar {
	public static void avisar(String msj, String tipo) {
		int alerta = JOptionPane.INFORMATION_MESSAGE;
		if (tipo.toLowerCase().equals("error")) {
			alerta = JOptionPane.ERROR_MESSAGE;
		}
		JOptionPane.showMessageDialog(null, msj, "Error", alerta);
	}
}
