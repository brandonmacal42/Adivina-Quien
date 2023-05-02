
package edd.adivina;

public class Caracteristica {

    private String nombre;
    private String[] opciones;

    public Caracteristica(String caracteristica) {
        String[] a = caracteristica.split(",");

        this.nombre = a[0];

        opciones = new String[a.length - 1];
        for(int i = 1; i < a.length; i++) {
            opciones[i - 1] = a[i];
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<");
        sb.append(nombre);
        sb.append(": ");

        for (int i = 0; i < opciones.length; i++) {
            sb.append(opciones[i]);
            if (i != opciones.length - 1) sb.append(" ");
        }

        sb.append(">");

        return sb.toString();
    }
}
