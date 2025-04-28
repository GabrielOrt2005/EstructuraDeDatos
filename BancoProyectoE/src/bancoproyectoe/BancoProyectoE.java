/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bancoproyectoe;

import javax.swing.JOptionPane;

/**
 *
 * @author gaort
 */
public class BancoProyectoE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Tiquete t = new Tiquete();
        Banco info = new Banco();
        Nod0 N = new Nod0(t);

        Cola preferencial = new Cola();
        Cola TramiteR = new Cola();
        Cola Multiple = new Cola();
        Cola Multiple2 = new Cola();

        preferencial.insertar(new Tiquete("Andres", 3232, 32, t.getFecha(), t.getHora(), "D", "P"));
        preferencial.insertar(new Tiquete("jULIAN", 3232, 32, t.getFecha(), t.getHora(), "D", "P"));
        Multiple.insertar(new Tiquete("Josue", 3232, 32, t.getFecha(), t.getHora(), "D y R", "B"));

        String U = JOptionPane.showInputDialog("Ingrese el nombre de usuario:");
        String C = JOptionPane.showInputDialog("Ingrese la contraseña");

        info.configurarBanco();
        if ("Gabriel".equals(U) && "Fidelitas".equals(C)) {
            JOptionPane.showMessageDialog(null, "Bienvenido al sistema");

            while (true) {
                String opcion = JOptionPane.showInputDialog(
                        "******MENU******\n"
                        + "1) Tomar un Tiquete\n"
                        + "2) Atender tiquetes\n"
                        + "3) Ver reportes\n"
                        + "4) Ver estado cajas\n"
                        + "5) Salir"
                );

                String resp, nombre, id, edad, fecha, hora, tramite, tipo;

                switch (opcion) {
                    case "1":
                        nombre = JOptionPane.showInputDialog("Ingrese su nombre: ");
                        id = JOptionPane.showInputDialog(null, "Ingrese su ID:");
                        edad = JOptionPane.showInputDialog(null, "Ingrese su edad:");
                        fecha = t.getFecha();
                        hora = t.getHora();
                        tramite = JOptionPane.showInputDialog(null, "Ingrese su tramite (D: Depostidos, R: Retiros, C: Cambio de divisas):");
                        tipo = JOptionPane.showInputDialog(null, "Ingrese su tipo de tramite (P: preferencial, A: Solo un tramite, B: varios tramites ):");
                        int num = Integer.parseInt(id);
                        int nums = Integer.parseInt(edad);
                        resp = "Nombre: " + nombre + ";" + "ID: " + num + ";" + "Edad: " + nums + ";" + "Fecha" + fecha + ";" 
                               + "Hora" + hora + ";" + "Tramite: " + tramite + ";" + "Tipo: " + tipo;

                        switch (tipo) {
                            case "B":
                                if (Multiple.cantidad() > Multiple2.cantidad()) {
                                    Multiple2.insertar(new Tiquete(nombre, num, nums, fecha, hora, tramite, tipo));
                                    JOptionPane.showMessageDialog(null, Multiple2);

                                } else {
                                    Multiple.insertar(new Tiquete(nombre, num, nums, fecha, hora, tramite, tipo));
                                    JOptionPane.showMessageDialog(null, Multiple);

                                }

                                if (Multiple.cantidad() == 1) {
                                    JOptionPane.showMessageDialog(null, "Usted es el primero en la fila, sera atendid@ de inmediato, Gracias por preferirnos.");
                                    Tiquete atendido = Multiple.atender();
                                    ManejoArchivo.escribir(atendido);
                                } else if (Multiple2.cantidad() == 1) {
                                    JOptionPane.showMessageDialog(null, "Usted es el primero en la fila, sera atendid@ de inmediato, Gracias por preferirnos.");
                                    Tiquete atendido = Multiple2.atender();
                                    ManejoArchivo.escribir(atendido);
                                }
                                break;

                            case "P":
                                preferencial.insertar(new Tiquete(nombre, num, nums, fecha, hora, tramite, tipo));
                                JOptionPane.showMessageDialog(null, preferencial);

                                if (preferencial.cantidad() == 1) {
                                    JOptionPane.showMessageDialog(null, "Usted es el primero en la fila, sera atendid@ de inmediato, Gracias por preferirnos.");
                                    Tiquete atendido = preferencial.atender();
                                    ManejoArchivo.escribir(atendido);
                                }
                                break;

                            case "A":
                                TramiteR.insertar(new Tiquete(nombre, num, nums, fecha, hora, tramite, tipo));
                                JOptionPane.showMessageDialog(null, TramiteR);

                                if (TramiteR.cantidad() == 1) {
                                    JOptionPane.showMessageDialog(null, "Usted es el primero en la fila, sera atendid@ de inmediato, Gracias por preferirnos.");
                                    Tiquete atendido = TramiteR.atender();
                                    ManejoArchivo.escribir(atendido);
                                }
                                break;
                        }
                        break;

                    case "2":
                        tipo = JOptionPane.showInputDialog(
                                "Ingrese la caja en la que quiere atender (P: preferencial, A: Tramite Rapido, B: varios tramites, C: varios tramites 2 )");

                        switch (tipo) {
                            case "P":
                                if (!preferencial.esVacia()) {
                                    Tiquete atendido = preferencial.atender();
                                    JOptionPane.showMessageDialog(null, "Tiquete atendido en la Caja Preferencial: " + atendido.toString());
                                    ManejoArchivo.escribir(atendido);

                                } else {
                                    JOptionPane.showMessageDialog(null, "No hay tiquetes para atender.");
                                }
                                break;

                            case "A":
                                if (!TramiteR.esVacia()) {
                                    Tiquete atendido = TramiteR.atender();
                                    JOptionPane.showMessageDialog(null, "Tiquete atendido en la Caja de Trámites Rápidos: " + atendido.toString());
                                    ManejoArchivo.escribir(atendido);

                                } else {
                                    JOptionPane.showMessageDialog(null, "No hay tiquetes para atender.");
                                }
                                break;

                            case "B":
                                if (!Multiple.esVacia()) {
                                    Tiquete atendido = Multiple.atender();
                                    JOptionPane.showMessageDialog(null, "Tiquete atendido en la Caja de Múltiples Trámites 1: " + atendido.toString());
                                    ManejoArchivo.escribir(atendido);

                                } else {
                                    JOptionPane.showMessageDialog(null, "No hay tiquetes para atender.");
                                }
                                break;

                            case "C":
                                if (!Multiple2.esVacia()) {
                                    Tiquete atendido = Multiple2.atender();
                                    JOptionPane.showMessageDialog(null, "Tiquete atendido en la Caja de Múltiples Trámites 2: " + atendido.toString());
                                    ManejoArchivo.escribir(atendido);
                                } else {
                                    JOptionPane.showMessageDialog(null, "No hay tiquetes para atender.");
                                }
                                break;
                        }
                        break;

                    case "3":
                        ManejoArchivo.MenuConsulta();
                        
        
                        break;

                    case "4":
                        JOptionPane.showMessageDialog(null, preferencial);
                        JOptionPane.showMessageDialog(null, TramiteR);
                        JOptionPane.showMessageDialog(null, Multiple);
                        JOptionPane.showMessageDialog(null, Multiple2);

                        break;

                    case "5":
                        JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                        return;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.");
                        break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos, intentelo de nuevo");
        }
    }
}
