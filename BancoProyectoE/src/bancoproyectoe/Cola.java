/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoproyectoe;

/**
 *
 * @author gaort
 */
public class Cola {
    private Nod0 frent, ult;

    public boolean esVacia() {
        return frent == null;
    }
    
   
    public void insertar(Tiquete a) {
        Nod0 n = new Nod0(a);
        if (this.esVacia()) {
            frent = ult = n;
        } else {
            ult.setSig(n);
            ult = n;
        }
    }

    public Tiquete atender() {
        Tiquete d = null;
        if (!this.esVacia()) {
            d = frent.getTiquete();
            if (frent == ult) {
                frent = ult = null;
            } else {
                frent = frent.getSig();
            }
        }
        return d;
    }
    
    public int cantidad() {
        int contador = 0;
        Nod0 n = frent;
        while (n != null) {
            contador++;
            n = n.getSig();
        }
        return contador;
    }
    

    @Override
    public String toString() {
        String r = "Cola{\n";
        if (this.esVacia()) {
            r += "Vacia\n}";
        } else {
            Nod0 aux = frent;
            while (aux != null) {
                r += aux + "\n";
                aux = aux.getSig();
            }
            r += "}";
        }
        return r;
    }
}
