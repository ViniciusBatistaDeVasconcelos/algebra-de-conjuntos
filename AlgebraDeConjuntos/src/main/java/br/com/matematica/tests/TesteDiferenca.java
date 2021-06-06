package br.com.matematica.tests;

import br.com.matematica.models.Conjunto;
import br.com.matematica.models.Diferenca;
import br.com.matematica.models.Elemento;

public class TesteDiferenca {

    public static void main(String[] args) {

        Conjunto conjunto1 = new Conjunto("A");
        conjunto1.adicionarElemento(new Elemento(0));
        conjunto1.adicionarElemento(new Elemento(1));
        conjunto1.adicionarElemento(new Elemento(2));
        conjunto1.adicionarElemento(new Elemento(3));
        conjunto1.adicionarElemento(new Elemento(4));

        Conjunto conjunto2 = new Conjunto("B");
        conjunto2.adicionarElemento(new Elemento(3));
        conjunto2.adicionarElemento(new Elemento(4));
        conjunto2.adicionarElemento(new Elemento(5));
        conjunto2.adicionarElemento(new Elemento(6));
        conjunto2.adicionarElemento(new Elemento(7));

        Diferenca diferenca = new Diferenca();
        Conjunto conjuntoDiferenca = diferenca.get(conjunto1, conjunto2);

        if (conjuntoDiferenca.getElementos().isEmpty()) {
            System.out.println("Os elementos são iguais!");
        } else {
            for (Elemento e : conjuntoDiferenca.getElementos()) {
                System.out.println(e.getValor() + ", ");
            }
        }

    }
}
