
package edd.adivina;

import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import edd.estructuras.arboles.ArbolBinario;
import edd.estructuras.lineales.List;
import edd.estructuras.lineales.ArrayList;
import edd.readerwriter.ReaderWriter;

import edd.colors.Colors;

public class AdivinaQuien {

    private List<Turno> turnos;
    private ArbolBinario<Turno> tree;

    public AdivinaQuien() {
        turnos = new ArrayList<>();
        tree = new ArbolBinario<>();
    }

    public String toString() {
        return turnos.toString();
    }

    public String fromTree() {
        return tree.toString();
    }

    public List<Pregunta> getPreguntas(int opcion) {
        ArrayList<Pregunta> result = new ArrayList();
        Pregunta p1;
        Pregunta p2;
        Pregunta p3;
        Pregunta p4;
        Pregunta p5;
        Pregunta p6;
        Pregunta p7;
        Pregunta p8;
        Pregunta p9;

        switch (opcion) {
            case 1:
                p1 = new Pregunta("¿Tu personaje tiene genero1?", "SI", "NO");
                p2 = new Pregunta("¿Tu personaje tiene genero2?", "SI", "NO");
                p3 = new Pregunta("¿Tu personaje tiene genero3?", "SI", "NO");
                p4 = new Pregunta("¿Tu personaje tiene genero4?", "SI", "NO");
                p5 = new Pregunta("¿Tu personaje tiene genero5?", "SI", "NO");
                p6 = new Pregunta("¿Tu personaje tiene genero6?", "SI", "NO");
                p7 = new Pregunta("¿Tu personaje tiene genero7?", "SI", "NO");
                p8 = new Pregunta("¿Tu personaje tiene genero8?", "SI", "NO");
                p9 = new Pregunta("¿Tu personaje tiene genero9?", "SI", "NO");
                break;
            case 2:
                p1 = new Pregunta("¿Tu personaje tiene la piel p1?", "SI", "NO");
                p2 = new Pregunta("¿Tu personaje tiene la piel p2?", "SI", "NO");
                p3 = new Pregunta("¿Tu personaje tiene la piel p3?", "SI", "NO");
                p4 = new Pregunta("¿Tu personaje tiene la piel p4?", "SI", "NO");
                p5 = new Pregunta("¿Tu personaje tiene la piel p5?", "SI", "NO");
                p6 = new Pregunta("¿Tu personaje tiene la piel p6?", "SI", "NO");
                p7 = new Pregunta("¿Tu personaje tiene la piel p7?", "SI", "NO");
                p8 = new Pregunta("¿Tu personaje tiene la piel p8?", "SI", "NO");
                p9 = new Pregunta("¿Tu personaje tiene la piel p9?", "SI", "NO");
                break;

            case 3:
                p1 = new Pregunta("¿Tu personaje tiene los ojos ojos1?", "SI", "NO");
                p2 = new Pregunta("¿Tu personaje tiene los ojos ojos2?", "SI", "NO");
                p3 = new Pregunta("¿Tu personaje tiene los ojos ojos3?", "SI", "NO");
                p4 = new Pregunta("¿Tu personaje tiene los ojos ojos4?", "SI", "NO");
                p5 = new Pregunta("¿Tu personaje tiene los ojos ojos5?", "SI", "NO");
                p6 = new Pregunta("¿Tu personaje tiene los ojos ojos6?", "SI", "NO");
                p7 = new Pregunta("¿Tu personaje tiene los ojos ojos7?", "SI", "NO");
                p8 = new Pregunta("¿Tu personaje tiene los ojos ojos8?", "SI", "NO");
                p9 = new Pregunta("¿Tu personaje tiene los ojos ojos9?", "SI", "NO");
                break;

            case 4:
                p1 = new Pregunta("¿Tu personaje tiene el cabello cabello1?", "SI", "NO");
                p2 = new Pregunta("¿Tu personaje tiene el cabello cabello2?", "SI", "NO");
                p3 = new Pregunta("¿Tu personaje tiene el cabello cabello3?", "SI", "NO");
                p4 = new Pregunta("¿Tu personaje tiene el cabello cabello4?", "SI", "NO");
                p5 = new Pregunta("¿Tu personaje tiene el cabello cabello5?", "SI", "NO");
                p6 = new Pregunta("¿Tu personaje tiene el cabello cabello6?", "SI", "NO");
                p7 = new Pregunta("¿Tu personaje tiene el cabello cabello7?", "SI", "NO");
                p8 = new Pregunta("¿Tu personaje tiene el cabello cabello8?", "SI", "NO");
                p9 = new Pregunta("¿Tu personaje tiene el cabello cabello9?", "SI", "NO");
                break;

            default:
                return null;
        }
        result.addLast(p1);
        result.addLast(p2);
        result.addLast(p3);
        result.addLast(p4);
        result.addLast(p5);
        result.addLast(p6);
        result.addLast(p7);
        result.addLast(p8);
        result.addLast(p9);
        return result;
    }

    public boolean ask(int opcion, int pregunta) {
        if (opcion == pregunta) {
            return true;
        } else {
            return false;
        }
    }

    public List<Persona> getPersonas() throws IOException {
        List<String> persona;
        List<Persona> result = new ArrayList();
        persona = ReaderWriter.readLines("personas.txt");
        for (String string : persona) {
            Persona p = new Persona(string);
            result.add(0, p);
        }
        return result;
    }

    public void setPersonaje(int opcion) {
        
    }
}
