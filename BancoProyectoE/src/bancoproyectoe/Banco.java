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
public class Banco {
   private String nombre;
    private int totalCajas;
    private static final String ARCHIVO_CONFIG = "banco.txt";
    
    public void configurarBanco() {
        if (leerDesdeArchivo()) {
            JOptionPane.showMessageDialog(null, "Configuracion cargada desde archivo");
            return;
        }
        
        nombre = JOptionPane.showInputDialog("Ingrese el nombre del banco: ");

        do {
            String input = JOptionPane.showInputDialog("Ingrese la cantidad total de cajas: ");
            if (input != null) {
                totalCajas = Integer.parseInt(input);
            }
        } while (totalCajas < 3);

        JOptionPane.showMessageDialog(null,
                "Banco: " + nombre + "\n"
                + "Total de cajas: " + totalCajas + "\n"
                + "1 Caja Preferencial\n"
                + "1 Caja Trámites Rápidos\n"
                + (totalCajas - 2) + " Cajas para multiples tramites");
        
        mostrarInformacionBanco();
        guardarEnArchivo();
        JOptionPane.showMessageDialog(null, "Configuracion completada.");
    }

    private void guardarEnArchivo() {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter("banco.txt"))) {
            writer.write(nombre + "\n" + totalCajas);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la configuracion.");
        }
    }
    private boolean leerDesdeArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader("banco.txt"))) {
            nombre = reader.readLine();
            totalCajas = Integer.parseInt(reader.readLine());

            JOptionPane.showMessageDialog(null,
                    "Banco: " + nombre + "\n"
                            + "Total de cajas: " + totalCajas + "\n"
                            + "1 Caja Preferencial\n"
                            + "1 Caja Tramites Rápidos\n"
                            + (totalCajas - 2) + " Cajas para múltiples tramites");

            return true;
        } 
        catch (IOException | NumberFormatException e) {
            return false;
        }
    }

    private void mostrarInformacionBanco() {
    JOptionPane.showMessageDialog(null,
                "Banco: " + nombre + "\n"
                        + "Total de cajas: " + totalCajas + "\n"
                        + "1 Caja Preferencial\n"
                        + "1 Caja Trámites Rapidos\n"
                        + (totalCajas - 2) + " Cajas para multiples tramites");
    }   
}
