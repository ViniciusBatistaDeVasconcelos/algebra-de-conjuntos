package br.com.matematica.tests;

import br.com.matematica.models.Conjunto;
import br.com.matematica.models.Elemento;
import br.com.matematica.models.ConjuntoDasPartes;

public class TesteConjuntoDasPartes {

    public static void main(String[] args) {

        Conjunto conjunto = new Conjunto("A");
        conjunto.adicionarElemento(new Elemento(1));
        conjunto.adicionarElemento(new Elemento(2));
        conjunto.adicionarElemento(new Elemento(3));
        //conjunto.adicionarElemento(new Elemento(4));
        
        for (Conjunto subConjunto : ConjuntoDasPartes.getInstancia().get(conjunto)) {
            if (subConjunto.getElementos().isEmpty()) {
                System.out.println("VAZIO");
            } else {
                for (Elemento elemento : subConjunto.getElementos()) {
                    System.out.print(elemento.getValor() + "\t");
                }
                System.out.print("\n");
            }
        }

    }
}
