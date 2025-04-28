/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoproyectoe;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author gaort
 */
public class Tiquete {
   private String Nombre;
    private int id;
    private int edad;
    private String fecha;
    private String hora;
    private String tramite;
    private String tipo;

    public Tiquete(String Nombre, int id, int edad, String fecha, String hora, String tramite, String tipo) {
        this.Nombre = Nombre;
        this.id = id;
        this.edad = edad;
        this.fecha = fecha;
        this.hora = hora;
        this.tramite = tramite;
        this.tipo = tipo;
    }
    
    

    public Tiquete() {
        LocalDateTime hora = LocalDateTime.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        this.fecha = hora.format(formatoFecha);
        this.hora = hora.format(formatoHora);

      
    } 

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    

    public String getTramite() {
        return tramite;
    }

    public void setTramite(String tramite) {
        this.tramite = tramite;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Tiquete{" + "Nombre=" + Nombre + ", id=" + id + ", edad=" + edad + ", fecha=" +fecha +  ", hora=" + hora + ", tramite=" + tramite + ", tipo=" + tipo + '}';
    }

   

   
    
    
}
