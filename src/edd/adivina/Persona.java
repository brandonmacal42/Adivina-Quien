
package edd.adivina;

public class Persona {

    private String nombre;
    private String genero;
    private String piel;
    private String ojos;
    private String cabello;

    public Persona(String persona) {
        String[] a = persona.split("\\s+");
        this.nombre = a[0];
        this.genero = a[1];
        this.piel = a[2];
        this.ojos = a[3];
        this.cabello = a[4];
    }

    public String getNombre() {
        return nombre;
    }

    public boolean tiene(String opcion) {
        if (this.genero.equals(opcion)) return true;
        if (this.piel.equals(opcion)) return true;
        if (this.ojos.equals(opcion)) return true;
        if (this.cabello.equals(opcion)) return true;

        return false;
    }

    public String toString() {
        return "<" + nombre + " " + genero + " " + piel + " " + ojos + " " + cabello + ">";
    }
}
