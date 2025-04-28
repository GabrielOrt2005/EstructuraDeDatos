/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoproyectoe;

/**
 *
 * @author gaort
 */
public class Nod0 {
    private Tiquete tiquete;
    private Nod0 sig;

    public Nod0(Tiquete tiquete) {
        this.tiquete = tiquete;
    }

    public Tiquete getTiquete() {
        return tiquete;
    }

    public void setTiquete(Tiquete tiquete) {
        this.tiquete = tiquete;
    }

    public Nod0 getSig() {
        return sig;
    }

    public void setSig(Nod0 sig) {
        this.sig = sig;
    }

    @Override
    public String toString() {
        return "Nod0{" + "tiquete=" + tiquete + '}';
    }


  
    }

   
    
 
    


    
    
    
    

