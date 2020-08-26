package Controlador;

import Vista.VisLogin;
import Modelo.Persona;
import Modelo.Funcionalidad;
import java.sql.Connection;
import java.util.Observable;
import java.util.Observer;

public class ContLogin implements Observer{

    private VisLogin vistaLogin;
    private Persona persona;
    private Funcionalidad funcionalidad;
    private Connection conexion;

    //public ContLogin(VisLogin vistaLogin, Persona persona, Funcionalidad funcionalidad, Connection conexion) {
    public ContLogin(VisLogin vistaLogin) { 
    	this.vistaLogin = vistaLogin;
        //this.persona = persona;
        //this.funcionalidad = funcionalidad;
        //this.conexion = conexion;
    }

    public void mostrarLogin() {
        this.vistaLogin.setVisible(true);
    }

    @Override
    public void update(Observable o, Object obj){
    }
}
