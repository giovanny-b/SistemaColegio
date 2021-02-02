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
public class AgregarD {
    
    public static ConexionBD c = new ConexionBD();
    
    private String nombre;
    private String apellido;
    private int edad;
    private String telefono;
    private String id;    
    private String materia;
    private String directorGrado;

        
    public AgregarD(String _nombre, String _apellido, int _edad, String _materia, String _telefono, String _id, String _directorGrado){
        this.nombre = _nombre;
        this.apellido = _apellido;
        this.edad = _edad;
        this.materia = _materia;
        this.telefono = _telefono;
        this.id = _id;
        this.directorGrado = _directorGrado;
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
    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getDirectorGrado() {
        return directorGrado;
    }

    public void setDirectorGrado(String directorGrado) {
        this.directorGrado = directorGrado;
    }
    
    
    public void AgregarDocente() throws SQLException{    
        
        c.ConectarBD("colegio");
                        
        String sql = "INSERT INTO Docente (nombre, apellido, edad, materia, telefono, identificacion, directorGrado) VALUES (?,?,?,?,?,?,?)";
        c.stmt = c.conexion.prepareStatement(sql);
        
        c.stmt.setString(1, getNombre());
        c.stmt.setString(2, getApellido());
        c.stmt.setInt(3, getEdad());
        c.stmt.setString(4, getMateria());
        c.stmt.setString(5, getTelefono());
        c.stmt.setString(6, getId());
        c.stmt.setString(7, getDirectorGrado());
        
        c.stmt.executeUpdate();
        
        System.out.println("Registrado con exito!");
        c.DesconectarBD();
        
    }
    
}
