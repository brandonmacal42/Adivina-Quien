
package edd.estructuras.arboles;

import edd.estructuras.lineales.List;

public interface Nodo<E> {

    E getElemento();

    void setElemento(E dato);

    Nodo<E> getPadre();

    void setPadre(Nodo<E> padre);

    boolean esHoja();

    int getAltura();

    Nodo<E> getHijo(int índice) throws IndexOutOfBoundsException;

    Nodo<E> getHermanoSiguiente(Nodo<E> hijo) throws IllegalArgumentException;

    int getGrado();

    List<Nodo<E>> getListaHijos();

    boolean remueveHijo(Nodo<E> hijo);
}
