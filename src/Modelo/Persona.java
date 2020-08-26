package Modelo;

import Inicio.Conexion;
import java.sql.Connection;
import java.time.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Persona {
    private int id;
    private String documento;
    private String apellido1;
    private String apellido2;
    private String nombre1;
    private String nombre2;
    private LocalDate fechaNac;
    private String pass;
    private String email;
    private Rol rol;
    //private String rolDescripcion;

    public Persona() {
    }

    public Persona(String documento, String apellido1, String apellido2, String nombre1, String nombre2, LocalDate fechaNac,
            String pass, String email, Rol rol) {

        this.documento = documento;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.fechaNac = fechaNac;
        this.pass = pass;
        this.email = email;
        this.rol = rol;
    }

  
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Persona{" + "documento=" + documento + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", nombre1=" + nombre1 + ", nombre2=" + nombre2 + ", fechaNac=" + fechaNac + ", pass=" + pass + ", email=" + email + ", rolNombre=" + rol.getNombre() + ", rolDescripcion=" + rol.getDescripcion() + '}';
    }

}
