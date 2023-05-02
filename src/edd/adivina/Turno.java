
package edd.adivina;

import edd.estructuras.lineales.List;
import edd.estructuras.lineales.ArrayList;

public class Turno implements Comparable<Turno> {

    private Pregunta pregunta;
    private List<Persona> si;
    private List<Persona> no;
    private boolean respuesta;
    private boolean jugador;
    private int orden;

    public Turno(Pregunta pregunta, List<Persona> si, List<Persona> no, boolean respuesta, boolean jugador, int orden) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.jugador = jugador;
        this.orden = orden;

        this.si = new ArrayList<>();
        for (Persona p: si) {
            this.si.add(this.si.size(), p);
        }

        this.no = new ArrayList<>();
        for (Persona p: no) {
            this.no.add(this.no.size(), p);
        }
    }

    public int compareTo(Turno t) {
        return this.orden - t.orden;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (jugador) {
            sb.append("@@Turno de jugador:@1 ");
        } else {
            sb.append("@@Turno de PC:@1 ");
        }

        sb.append(pregunta);
        sb.append(" ");
        if (respuesta) {
            sb.append("@2");
            sb.append(pregunta);
            sb.append(" ");
            sb.append("SI");
        } else {
            sb.append("@3");
            sb.append(pregunta);
            sb.append(" ");
            sb.append("NO");
        }
        sb.append(".@1\n@@Posibles:@1 ");
        sb.append(si);
        sb.append(".\n@@Rechazadas:@1 ");
        sb.append(no);
        sb.append(".\n");

        return sb.toString();
    }
}
