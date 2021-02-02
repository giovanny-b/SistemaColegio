/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Agregar.*;
import static Clases.Eliminar.c;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author giovannyb
 */
public class Main {

    public static String comand;
    public static String rojo = "\u001B[31m", amarillo = "\u001B[33m", blanco = "\u001B[37m", azul = "\u001B[34m", verde = "\u001B[32m";

    public static boolean Docente = false;
    public static boolean root = false;
    public static boolean estudiante = false;
    public static boolean login = false;

    public static String tipo;
    public static String ide;
    public static String nombreR;

    public static String code;
    public static String materia;

    public static ConexionBD c = new ConexionBD();

    public static void main(String[] args) throws SQLException {

        Scanner scan = new Scanner(System.in);

        System.out.print("Tipo: ");
        tipo = scan.next();
        System.out.print("identificacion: ");
        ide = scan.next();

        if (tipo.equals("root") && ide.equals("root")) {
            root = true;
            code = "admin@BEGIN:~";
            acciones();
        } else if (tipo.equalsIgnoreCase("est")) {
            estudiante = true;

            c.ConectarBD("colegio");

            String sql = "SELECT * FROM estudiante WHERE identificacion=" + ide;
            c.result = c.st.executeQuery(sql);
            while (c.result.next()) {
                if (c.result.isLast()) {
                    nombreR = c.result.getString("nombre");
                    code = nombreR + "@EST:~";
                    acciones();
                }
            }
            c.DesconectarBD();

        } else if (tipo.equalsIgnoreCase("doc")) {
            Docente = true;
            c.ConectarBD("colegio");
            String sql = "SELECT * FROM Docente WHERE identificacion=" + ide;
            c.result = c.st.executeQuery(sql);
            while (c.result.next()) {
                if (c.result.isLast()) {
                    materia = c.result.getString("materia");
                    nombreR = c.result.getString("nombre");
                    code = nombreR + "@" + materia + ":~";
                    acciones();
                }
            }
            c.DesconectarBD();
        }

    }

    public static void acciones() throws SQLException {

        Scanner scan = new Scanner(System.in);
        do {
            System.out.print(verde + code + azul + "$ ");
            comand = scan.next();
            switch (comand) {
                case "add":

                    if (root) {

                        comand = scan.next();

                        if (comand.equalsIgnoreCase("estu")) {

                            comand = scan.next();
                            String nombre = comand;
                            comand = scan.next();
                            String ape = comand;
                            int edad = scan.nextInt();
                            comand = scan.next();
                            String grado = comand;
                            comand = scan.next();
                            String tel = comand;
                            comand = scan.next();
                            String id = comand;

                            AgregarE add = new AgregarE(nombre, ape, edad, grado, tel, id);
                            add.AgregarEstudiante();

                        } else if (comand.equalsIgnoreCase("doce")) {

                            comand = scan.next();
                            String nombre = comand;
                            comand = scan.next();
                            String ape = comand;
                            int edad = scan.nextInt();
                            comand = scan.next();
                            String materiaD = comand;
                            comand = scan.next();
                            String tel = comand;
                            comand = scan.next();
                            String id = comand;
                            comand = scan.next();
                            String diGra = comand;

                            AgregarD add = new AgregarD(nombre, ape, edad, materiaD, tel, id, diGra);
                            add.AgregarDocente();

                        }

                        break;
                    } else {
                        System.out.println(rojo + "No tienes privilegios de root.");
                    }
                case "list":

                    if (root) {
                        comand = scan.next();

                        if (comand.equals("estu")) {

                            String grado = scan.nextLine();

                            Listar list = new Listar();
                            list.ListarEstudiante(grado);
                        }
                        if (comand.equals("doce")) {
                            Listar list = new Listar();
                            list.ListarDocente();
                        }
                    } else {
                        System.out.println(rojo + "No tienes privilegios de root!");
                    }

                    break;
                case "delete":

                    if (root) {
                        comand = scan.next();

                        if (comand.equals("estu")) {

                            String nombre = scan.next();

                            Eliminar eliminar = new Eliminar();
                            eliminar.EliminarE(nombre);
                        } else if (comand.equals("doce")) {

                            int id = scan.nextInt();

                            Eliminar eliminar = new Eliminar();
                            eliminar.EliminarD(id);
                        }
                    } else {
                        System.out.println(rojo + "No tienes privilegios de root");
                    }
                    break;
                case "update":
                    comand = scan.next();

                    if (comand.equalsIgnoreCase("estu")) {

                        comand = scan.next();
                        String nombre = comand;
                        comand = scan.next();
                        String ape = comand;
                        int edad = scan.nextInt();
                        comand = scan.next();
                        String grado = comand;
                        comand = scan.next();
                        String tel = comand;
                        comand = scan.next();
                        String iden = comand;

                        ActualizarR uptd = new ActualizarR(nombre, ape, edad, grado, tel, iden);
                        uptd.ActualizarE();

                    }
                    break;
                case "edit":

                    if (Docente) {

                        comand = scan.next();

                        if (comand.equalsIgnoreCase("list")) {

                            comand = scan.next();

                            c.ConectarBD(comand);

                            String sqlM = "SELECT * FROM Periodo1 WHERE materia=";
                            c.st = c.conexion.createStatement();
                            c.result = c.st.executeQuery(sqlM);

                            String[] datos = new String[4];

                            while (c.result.next()) {

                                datos[0] = c.result.getString(1);
                                datos[1] = c.result.getString(2);
                                datos[2] = c.result.getString(3);
                                datos[3] = c.result.getString(4);

                                for (int i = 0; i < datos.length; i++) {
                                    System.out.print(datos[i] + " | ");
                                }
                                System.out.println("");
                            }

                        }
                    }
                    break;

                case "logout":

                    Main.main(null);

                    System.exit(0);

                    break;
                case "clear":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    break;
            }

        } while (!comand.equals(
                "exit"));
    }

}
