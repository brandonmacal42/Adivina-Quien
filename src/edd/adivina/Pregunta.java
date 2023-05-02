
package edd.adivina;

public class Pregunta {

    private String pregunta;
    private String[] si;
    private String[] no;
    
    public Pregunta(String pregunta, String si, String no) {
        this.pregunta = pregunta.trim();
        this.si = si.trim().split(" ");
        this.no = no.trim().split(" ");
    }

    public String getPregunta() {
        return pregunta;
    }

    public String[] getSi() {
        return si;
    }

    public String[] getNo() {
        return no;
    }

    public String toString() {
        return pregunta;
    }
}
