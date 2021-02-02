/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import static Agregar.AgregarE.c;
import static Clases.Eliminar.c;
import java.sql.SQLException;

/**
 *
 * @author giovannyb
 */
public class ActualizarR {
    
    private String nombre;
    private String apellido;
    private int edad;
    private String grado;
    private String telefono;
    private String id;    

        
    public ActualizarR(String _nombre, String _apellido, int _edad, String _grado, String _telefono, String _id){
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
    
    
    
    ConexionBD c = new ConexionBD();
    
    public void ActualizarE() throws SQLException{
        
        c.ConectarBD("colegio");
        
        String sql = "UPDATE estudiante SET nombre=?, apellido=?, edad=?, grado=?, telefono=?, identificacion=? WHERE identificacion=?";
        
        c.stmt = c.conexion.prepareStatement(sql);
        
        c.stmt.setString(1, getNombre());
        c.stmt.setString(2, getApellido());
        c.stmt.setInt(3, getEdad());
        c.stmt.setString(4, getGrado());
        c.stmt.setString(5, getTelefono());
        c.stmt.setString(6, getId());
        c.stmt.setString(7, getId());
        
        c.stmt.executeUpdate();
        
        System.out.println("EL estudiante se actualizo con exito!");
        
        c.DesconectarBD();
        
    }
    
}
