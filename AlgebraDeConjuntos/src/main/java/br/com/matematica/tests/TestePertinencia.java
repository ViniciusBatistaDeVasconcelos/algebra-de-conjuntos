package br.com.matematica.tests;

import br.com.matematica.models.Conjunto;
import br.com.matematica.models.Elemento;
import br.com.matematica.models.Pertinencia;
import java.util.ArrayList;
import java.util.List;

public class TestePertinencia {

    public static void main(String[] args) {
        
        Elemento elemento = new Elemento("a", 1);
        List<Elemento> elementos = new ArrayList<>();
        elementos.add(new Elemento(5));
        elementos.add(new Elemento(10));
        elementos.add(new Elemento(9));
        elementos.add(new Elemento(78));
        elementos.add(new Elemento(10));
        elementos.add(new Elemento(91));
        elementos.add(new Elemento(3));
        
        Conjunto conjunto = new Conjunto("A");
        conjunto.setElementos(elementos);

        
        if (Pertinencia.getInstancia().pertence(elemento, conjunto)) {
            System.out.println("O elemento pertence");
        } else {
            System.out.println("O elemento NÃO pertence");
        }
    }
}
