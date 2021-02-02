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
public class Listar {

    public static ConexionBD c = new ConexionBD();

    public void ListarEstudiante(String grado) throws SQLException {
        c.ConectarBD("colegio");

        String sql = "SELECT * FROM estudiante WHERE grado=" + grado;
        String[] datos = new String[7];

        c.st = c.conexion.createStatement();
        c.result = c.st.executeQuery(sql);

        while (c.result.next()) {
            datos[0] = c.result.getString(1);
            datos[1] = c.result.getString(2);
            datos[2] = c.result.getString(3);
            datos[3] = c.result.getString(4);
            datos[4] = c.result.getString(5);
            datos[5] = c.result.getString(6);
            datos[6] = c.result.getString(7);

            for (int i = 0; i < datos.length; i++) {
                System.out.print(datos[i] + " | ");
            }
            System.out.println("");

        }

    }
    public void ListarDocente() throws SQLException {
        c.ConectarBD("colegio");

        String sql = "SELECT * FROM Docente";
        String[] datos = new String[8];

        c.st = c.conexion.createStatement();
        c.result = c.st.executeQuery(sql);

        while (c.result.next()) {
            datos[0] = c.result.getString(1);
            datos[1] = c.result.getString(2);
            datos[2] = c.result.getString(3);
            datos[3] = c.result.getString(4);
            datos[4] = c.result.getString(5);
            datos[5] = c.result.getString(6);
            datos[6] = c.result.getString(7);
            datos[7] = c.result.getString(8);

            for (int i = 0; i < datos.length; i++) {
                System.out.print(datos[i] + " | ");
            }
            System.out.println("");

        }

    }

}
