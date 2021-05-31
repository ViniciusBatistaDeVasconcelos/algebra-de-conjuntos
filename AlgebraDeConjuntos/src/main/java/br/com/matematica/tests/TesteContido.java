package br.com.matematica.tests;

import br.com.matematica.models.Conjunto;
import br.com.matematica.models.Contido;
import br.com.matematica.models.Elemento;

public class TesteContido {

    public static void main(String[] args) {
        
        
        Conjunto conjunto1 = new Conjunto("A");
        conjunto1.adicionarElemento(new Elemento(1));
        conjunto1.adicionarElemento(new Elemento(2));
        conjunto1.adicionarElemento(new Elemento(3));
        conjunto1.adicionarElemento(new Elemento(4));
        conjunto1.adicionarElemento(new Elemento(5));
        
        Conjunto conjunto2 = new Conjunto("B");
        conjunto2.adicionarElemento(new Elemento(1));
        conjunto2.adicionarElemento(new Elemento(2));
        conjunto2.adicionarElemento(new Elemento(3));
        conjunto2.adicionarElemento(new Elemento(4));
        conjunto2.adicionarElemento(new Elemento(5));
        conjunto2.adicionarElemento(new Elemento(6));

        
        if (Contido.getInstancia().contidoIgual(conjunto1, conjunto2)) {
            System.out.println("É contido ou igual");
        } else {
            System.out.println("Não é contido ou igual");
        }
        
        if (Contido.getInstancia().contidoPropriamente(conjunto1, conjunto2)) {
            System.out.println("É contido propriamente");
        } else {
            System.out.println("Não é contido propriamente");
        }
    }
}
