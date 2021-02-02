/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.*;

/**
 *
 * @author giovannyb
 */
public class ConexionBD{

    public Connection conexion;
    public PreparedStatement stmt;
    public Statement st;
    public ResultSet result;

    public void ConectarBD(String DB) throws SQLException {

        final String url_bd = "jdbc:mysql://localhost:3306/";
        final String url_bd2 = "jdbc:mysql://localhost:3306/" + DB;

        if (DB.equals("")) {
            conexion = DriverManager.getConnection(url_bd, "GiovannyBernal", "1096539141");
        }else{
            conexion = DriverManager.getConnection(url_bd2, "GiovannyBernal", "1096539141");
        }
        
        st = conexion.createStatement();

    }

    public void DesconectarBD() {
        try {
            if (conexion != null) {
                if (stmt != null) {
                    stmt.close();
                }
                conexion.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }
    }
    
    public Connection getConnection(){
        return conexion;
    }   

}
