/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoproyectoe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author gaort
 */
public class ManejoArchivo {
    Tiquete t = new Tiquete();
    Cola C = new Cola();
    String hora = t.getHora();
    public static String archivo = "Tiquetes.txt";

    Tiquete atendido = C.atender();
    
    public static void escribir(Tiquete atendido) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            writer.newLine();
            writer.write(atendido.toString());
            System.out.println("Tiquete atendido agregado a reportes.");
        } catch (IOException e) {
            System.err.println("Error al agregar el tiquete a reportes: " + e.getMessage());
        }
    }

    public static void reescribir(String info) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(info);
            System.out.println("Tiquete escrito correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir el tiquete: " + e.getMessage());
        }
    }

    public static String ConsultarTotalTiquetesAtendidos() {
        int contador = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            while (reader.readLine() != null) {
                contador++;
            }
            return "Cantidad total de tiquetes atendidos: " + contador;
        } catch (IOException e) {
            return "Error al leer el archivo: " + e.getMessage();
        }
    }

    public static String ConsultarCajaMasAtencion() {
    int P = 0;
    int A = 0;
    int B = 0;

    try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
        String leer;
        while ((leer = reader.readLine()) != null) {
            if (leer.contains("P")) {
                P++;
            } else if (leer.contains("A")) {
                A++;
            } else if (leer.contains("B")){
                B++;
            }
        }
        String atencion = "";
        if (P > A) {
            atencion = "️La Caja Preferencial es la caja que mas tiquetes atendio con " + P +  "Tiquetes atendidos en total.";
        } else if (P > B) {
            atencion = "️La Caja Preferencial es la caja que mas tiquetes atendio con " + P + "Tiquetes atendidos en total.";
        } else if (A > P){
            atencion = "️La Caja tramites rapidos es la caja que mas tiquetes atendio con " + A + "Tiquetes atendidos en total.";
        } else if (A > B){
            atencion = "️La Caja tramites rapidos es la caja que mas tiquetes atendio con " + A + "Tiquetes atendidos en total.";
        } else if (B > P){
            atencion = "La caja de tramites Multiples es la caja que mas tiquetes atendio con " + B + "Tiquetes atendidos en total.";
        } else if (B > A){
            atencion = "La caja de tramites Multiples es la caja que mas tiquetes atendio con " + B + "Tiquetes atendidos en total.";
        }

        return atencion;
    } catch (IOException e) {
        return "Error al leer el archivo: " + e.getMessage();
    }
    
  
        
 }       
    public static void MenuConsulta() {
        String opcion = JOptionPane.showInputDialog(
                "******MENU CONSULTAS******\n"
                + "1) Consultar por total de clientes atendidos\n"
                + "2) Consultar por cual caja atendio mas clientes\n"
                
        );

        switch (opcion) {
            case "1":
                String M = ManejoArchivo.ConsultarTotalTiquetesAtendidos();
                JOptionPane.showMessageDialog(null, M);
                break;
            case "2":
                String mensaj = ManejoArchivo.ConsultarCajaMasAtencion();
                JOptionPane.showMessageDialog(null, mensaj);
                break;
                
         
        }

    }
  
}
