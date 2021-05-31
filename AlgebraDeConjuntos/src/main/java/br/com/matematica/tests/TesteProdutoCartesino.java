package br.com.matematica.tests;

import br.com.matematica.models.Conjunto;
import br.com.matematica.models.Elemento;
import br.com.matematica.models.ProdutoCartesiano;
import br.com.matematica.models.exceptions.ExceptionObjetoInvalido;

public class TesteProdutoCartesino {

    public static void main(String[] args) throws ExceptionObjetoInvalido {
        
        Conjunto conjunto1 = new Conjunto("A");
        conjunto1.adicionarElemento(new Elemento(1));
        conjunto1.adicionarElemento(new Elemento(2));
        
        Conjunto conjunto2 = new Conjunto("B");
        conjunto2.adicionarElemento(new Elemento(3));
        conjunto2.adicionarElemento(new Elemento(4));

        
        
        
        ProdutoCartesiano.getInstancia().get(ProdutoCartesiano.getInstancia().get(conjunto1, ProdutoCartesiano.getInstancia().get(conjunto1, conjunto2)), conjunto2);
        ProdutoCartesiano.getInstancia().mostrarProdutoCartesiano();
    }
}
