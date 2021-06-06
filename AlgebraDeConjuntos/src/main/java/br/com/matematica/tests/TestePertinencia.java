package br.com.matematica.tests;

import br.com.matematica.models.Conjunto;
import br.com.matematica.models.Elemento;
import br.com.matematica.models.Pertinencia;

public class TestePertinencia {

    public static void main(String[] args) {

        Elemento elemento = new Elemento("a", -3);

        Conjunto conjunto = new Conjunto();
        conjunto.adicionarElemento(new Elemento(0));
        conjunto.adicionarElemento(new Elemento(1));
        conjunto.adicionarElemento(new Elemento(-7));
        conjunto.adicionarElemento(new Elemento(99));
        conjunto.adicionarElemento(new Elemento(-3));

        if (Pertinencia.getInstancia().pertence(elemento, conjunto)) {
            System.out.println("O elemento pertence!");
        } else {
            System.out.println("O elemento NÃO pertence!");
        }
    }
}
