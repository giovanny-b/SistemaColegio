/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.SQLException;

/**
 *
 * @author giovannyb
 */
public class Eliminar {

    public static ConexionBD c = new ConexionBD();

    public void EliminarE(String nombre) throws SQLException {
        
        c.ConectarBD("colegio");

        String sql = "DELETE FROM estudiante WHERE nombre=?";
        
        c.stmt = c.conexion.prepareStatement(sql);
        c.stmt.setString(1, nombre);
        
        c.stmt.executeUpdate();
        c.DesconectarBD();
        
        c.ConectarBD("");
        
        String sqlD = "DROP DATABASE " + nombre;
        c.st.execute(sqlD);
        
        c.DesconectarBD();
        
        System.out.println("¡Eliminado con exito!");

    }
    
    public void EliminarD(int id) throws SQLException {
        
        c.ConectarBD("colegio");

        String sql = "DELETE FROM Docente WHERE id=?";
        
        c.stmt = c.conexion.prepareStatement(sql);
        c.stmt.setInt(1, id);
        
        c.stmt.executeUpdate();
        
        c.DesconectarBD();

    }

}
