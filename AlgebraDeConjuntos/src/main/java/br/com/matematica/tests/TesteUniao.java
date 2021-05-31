package br.com.matematica.tests;

import br.com.matematica.models.Conjunto;
import br.com.matematica.models.Elemento;
import br.com.matematica.models.Uniao;

public class TesteUniao {

    public static void main(String[] args) {
        
        
        Conjunto conjunto1 = new Conjunto("A");
        conjunto1.adicionarElemento(new Elemento(1));
        conjunto1.adicionarElemento(new Elemento(2));
        conjunto1.adicionarElemento(new Elemento(3));
        conjunto1.adicionarElemento(new Elemento(4));
        conjunto1.adicionarElemento(new Elemento(5));
        conjunto1.adicionarElemento(new Elemento(7));
        
        Conjunto conjunto2 = new Conjunto("B");
        conjunto2.adicionarElemento(new Elemento(1));
        conjunto2.adicionarElemento(new Elemento(2));
        conjunto2.adicionarElemento(new Elemento(3));
        conjunto2.adicionarElemento(new Elemento(4));
        conjunto2.adicionarElemento(new Elemento(5));
        conjunto2.adicionarElemento(new Elemento(6));

        for(Elemento e : Uniao.getInstancia().get(conjunto1, conjunto2).getElementos()){
            System.out.println(e.getValor());
        }
        
    }
}
