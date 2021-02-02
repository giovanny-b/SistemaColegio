/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agregar;

import Clases.ConexionBD;
import java.sql.SQLException;

/**
 *
 * @author giovannyb
 */
public class AgregarE {
    
    public static ConexionBD c = new ConexionBD();
        
    private String nombre;
    private String apellido;
    private int edad;
    private String grado;
    private String telefono;
    private String id;    

        
    public AgregarE(String _nombre, String _apellido, int _edad, String _grado, String _telefono, String _id){
        this.nombre = _nombre;
        this.apellido = _apellido;
        this.edad = _edad;
        this.grado = _grado;
        this.telefono = _telefono;
        this.id = _id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void AgregarEstudiante() throws SQLException{    
        
        c.ConectarBD("");
        
        c.st.execute("CREATE DATABASE " + getNombre());
        
        System.out.println("Se creo la base de datos del estudiante: " + getNombre());
        
        c.ConectarBD(getNombre());
        
        String sqlM = "CREATE TABLE Periodo1 ("
                + "id INT NOT NULL AUTO_INCREMENT,"
                + "notaP VARCHAR(10),"
                + "nota VARCHAR(10),"
                + "materia VARCHAR(50),"
                + "PRIMARY KEY(id)"
                + ");";
        c.st.execute(sqlM);
        c.DesconectarBD();
        
        c.ConectarBD(getNombre());
        
        String sqlE = "CREATE TABLE Periodo2 ("
                + "id INT NOT NULL AUTO_INCREMENT,"
                + "notaP VARCHAR(10),"
                + "nota VARCHAR(10),"
                + "materia VARCHAR(50),"
                + "PRIMARY KEY(id)"
                + ");";
        c.st.execute(sqlE);
                
        String sqlb = "CREATE TABLE Periodo3 ("
                + "id INT NOT NULL AUTO_INCREMENT,"
                + "notaP VARCHAR(10),"
                + "nota VARCHAR(10),"
                + "materia VARCHAR(50),"
                + "PRIMARY KEY(id)"
                + ");";
        c.st.execute(sqlb);
        
        String sqlI = "CREATE TABLE Periodo4 ("
                + "id INT NOT NULL AUTO_INCREMENT,"
                + "notaP VARCHAR(10),"
                + "nota VARCHAR(10),"
                + "materia VARCHAR(50),"
                + "PRIMARY KEY(id)"
                + ");";
        c.st.execute(sqlI);
        
        String sqlS = "CREATE TABLE Definitiva ("
                + "id INT NOT NULL AUTO_INCREMENT,"
                + "notaP VARCHAR(10),"
                + "nota VARCHAR(10),"
                + "materia VARCHAR(50),"
                + "PRIMARY KEY(id)"
                + ");";
        c.st.execute(sqlS);
        
        c.DesconectarBD();
        
        c.ConectarBD("colegio");
        
        String sqlde = "INSERT INTO estudiante (nombre, apellido, edad, grado, telefono, identificacion) VALUES (?,?,?,?,?,?)";
        c.stmt = c.conexion.prepareStatement(sqlde);
        
        c.stmt.setString(1, getNombre());
        c.stmt.setString(2, getApellido());
        c.stmt.setInt(3, getEdad());
        c.stmt.setString(4, getGrado());
        c.stmt.setString(5, getTelefono());
        c.stmt.setString(6, getId());
        
        c.stmt.executeUpdate();
        
        System.out.println("Registrado con exito!");
        c.DesconectarBD();
                        
    }
    
    
}
