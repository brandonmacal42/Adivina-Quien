package edd;

// import edd.adivina.ToXML;
import edd.adivina.AdivinaQuien;
import edd.adivina.Persona;
import edd.adivina.Pregunta;

import edd.estructuras.lineales.List;
import edd.estructuras.arboles.ArbolBinario;

import edd.colors.Colors;

import java.util.Scanner;

public class Prueba {

    public static int getInt(String mensaje, String error, int min, int max) {
        int val;
        Scanner scn = new Scanner(System.in);

        while (true) {
            Colors.println(mensaje, Colors.HIGH_INTENSITY);
            if (scn.hasNextInt()) {
                val = scn.nextInt();
                // (-infinito, min) || (max, infinito)
                if (val < min || max < val) {
                    Colors.println(error, Colors.RED + Colors.HIGH_INTENSITY);
                } else {
                    return val;
                }
            } else {
                scn.next();
                Colors.println(error, Colors.RED + Colors.HIGH_INTENSITY);
            }
        }
    }

    public static double getDouble(String mensaje, String error, double min, double max) {
        double val;
        Scanner scn = new Scanner(System.in);

        while (true) {
            Colors.println(mensaje, Colors.HIGH_INTENSITY);
            if (scn.hasNextDouble()) {
                val = scn.nextDouble();
                // (-infinito, min) || (max, infinito)
                if (val < min || max < val) {
                    Colors.println(error, Colors.RED + Colors.HIGH_INTENSITY);
                } else {
                    return val;
                }
            } else {
                scn.next();
                Colors.println(error, Colors.RED + Colors.HIGH_INTENSITY);
            }
        }
    }

    public static void print(String msg, String color, List list) {
        int i = 1;
        StringBuilder sb = new StringBuilder();

        Colors.println(msg, color + Colors.HIGH_INTENSITY);

        for (Object obj: list) {
            sb.append(i++);
            sb.append(". ");
            sb.append(obj.toString());
            sb.append(".\n");
        }

        Colors.println(sb.toString(), color);
    }

    public static String itemize(List list) {
        int i = 1;
        StringBuilder sb = new StringBuilder();

        sb.append("Selecciona una opcion.\n");

        for (Object obj: list) {
            sb.append(i++);
            sb.append(". ");
            sb.append(obj.toString());
            sb.append(".\n");
        }

        sb.append("0. Salir\n");

        return sb.toString();
    }

    public static int preguntar(AdivinaQuien a) {
        List<Pregunta> preguntas;
        String mensaje;
        int opcion, pregunta;
        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("Sobre que caracteristica quieres preguntar?.\n");
        sb.append("1. Genero.\n");
        sb.append("2. Piel.\n");
        sb.append("3. Ojos.\n");
        sb.append("4. Cabello.\n");
        sb.append("0. Salir.\n");
        mensaje = sb.toString();

        opcion = getInt(mensaje, "Por favor ingresa una opcion valida.", 0, 4);
        if (opcion != 0) {
            preguntas = a.getPreguntas(opcion);
            pregunta = getInt(itemize(preguntas), "Por favor ingresa una opcion valida.", 0, preguntas.size());

            if (pregunta != 0) {
                Colors.println(preguntas.get(pregunta - 1), Colors.HIGH_INTENSITY);
                if (a.ask(opcion, pregunta)) {
                    Colors.println("SI.", Colors.GREEN + Colors.HIGH_INTENSITY);
                } else {
                    Colors.println("NO.", Colors.RED + Colors.HIGH_INTENSITY);
                }
            } 
        }

        return opcion;
    }

    public static void main(String[] args) {
        int opcion, maxOption;
        String mensaje, error, aux;
        StringBuilder sb;

        List<Persona> personas;
        AdivinaQuien a;

        Colors.println("Este programa es el juego de Adivina Quien.", Colors.BLUE + Colors.HIGH_INTENSITY);

        // ToXML.preguntas();

        a = new AdivinaQuien();

        sb = new StringBuilder();
        sb.append("Selecciona una opcion.\n");
        sb.append("1. Selecciona un personaje\n");
        sb.append("0. Salir.\n");
        mensaje = sb.toString();
        error = "Por favor ingresa una opcion valida.";

        opcion = getInt(mensaje, error, 0, 1);
        if (opcion != 0) {
            personas = a.getPersonas();
            opcion = getInt(itemize(personas), error, 0, personas.size());

            if (opcion != 0) {
                a.setPersonaje(opcion);

                sb = new StringBuilder();
                sb.append("Selecciona una opcion.\n");
                sb.append("1. Preguntar sobre el personaje de pc.\n");
                sb.append("2. Ver personajes posibles y descalificados.\n");
                sb.append("0. Salir.\n");
                mensaje = sb.toString();
                do {
                    opcion = getInt(mensaje, error, 0, 2);

                    switch (opcion) {
                        case 1:
                            opcion = preguntar(a);
                            aux = a.turnoPC();
                            Colors.println(aux, Colors.CYAN + Colors.HIGH_INTENSITY);
                            aux = a.revisarGanador();
                            if (aux != null) {
                                opcion = 0;
                                Colors.println(aux, Colors.MAGENTA + Colors.HIGH_INTENSITY);
                            }
                        case 2:
                            personas = a.getPosibles();
                            print("Posibles del tablero del jugador:", Colors.GREEN, personas);
                            personas = a.getRechazados();
                            print("Rechazados del tablero del jugador:", Colors.RED, personas);
                            personas = a.getPC_Posibles();
                            print("Posibles del tablero de la pc:", Colors.GREEN, personas);
                            personas = a.getPC_Rechazados();
                            print("Rechazados del tablero de la pc:", Colors.RED, personas);
                            break;
                    }
                } while (opcion != 0);
            }
        }
        Colors.println("Vuelve pronto.", Colors.BLUE + Colors.HIGH_INTENSITY);
        mensaje = a.toString();
        aux = a.fromTree();
        if (mensaje.equals(aux)) {
            aux = Colors.GREEN + Colors.HIGH_INTENSITY + "Tree funciona." + Colors.RESTORE;
        } else {
            aux = Colors.RED + Colors.HIGH_INTENSITY + "Tree NO funciona." + Colors.RESTORE;
        }
        mensaje = mensaje.replace("@@", Colors.HIGH_INTENSITY);
        mensaje = mensaje.replace("@1", Colors.RESTORE);
        mensaje = mensaje.replace("@2", Colors.GREEN + Colors.HIGH_INTENSITY);
        mensaje = mensaje.replace("@3", Colors.RED + Colors.HIGH_INTENSITY);
        Colors.println(mensaje, Colors.HIGH_INTENSITY);
        System.out.println(aux);
    }
}
