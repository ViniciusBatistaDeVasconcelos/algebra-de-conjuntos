package br.com.matematica.tests;

import br.com.matematica.models.Conjunto;
import br.com.matematica.models.Elemento;
import br.com.matematica.models.ProdutoCartesiano;
import br.com.matematica.models.exceptions.ExceptionObjetoInvalido;
import java.util.List;

public class TesteProdutoCartesino {

    public static void main(String[] args) throws ExceptionObjetoInvalido {

        Conjunto conjunto1 = new Conjunto("A");
        conjunto1.adicionarElemento(new Elemento(1));
        conjunto1.adicionarElemento(new Elemento(2));
        conjunto1.adicionarElemento(new Elemento(3));

        Conjunto conjunto2 = new Conjunto("B");
        conjunto2.adicionarElemento(new Elemento(3));
        conjunto2.adicionarElemento(new Elemento(4));

        Conjunto conjunto3 = new Conjunto("C");
        conjunto3.adicionarElemento(new Elemento(5));
        conjunto3.adicionarElemento(new Elemento(6));

        Conjunto conjunto4 = new Conjunto("D");
        conjunto4.adicionarElemento(new Elemento(7));
        conjunto4.adicionarElemento(new Elemento(8));

        ProdutoCartesiano produtoCartesiano = new ProdutoCartesiano();

        List<Object> AB = produtoCartesiano.get(conjunto1, conjunto2);
        produtoCartesiano.imprimir(AB);
        System.out.print("\n");

        List<Object> ABC = produtoCartesiano.get(AB, conjunto3);
        produtoCartesiano.imprimir(ABC);
        System.out.print("\n");

        List<Object> ABCD = produtoCartesiano.get(conjunto4, ABC);
        produtoCartesiano.imprimir(ABCD);
        System.out.print("\n");

        List<Object> ABCDE = produtoCartesiano.get(conjunto4, ABC);
        produtoCartesiano.imprimir(ABCD);
        System.out.print("\n");

        List<Object> ABXABC = produtoCartesiano.get(AB, ABC);
        produtoCartesiano.imprimir(ABXABC);
        System.out.print("\n");

        System.out.print("\n");

        List<Object> listaPercorrer = ABCD;
        for (int i = 0; i < produtoCartesiano.reverterParesOrdenados(listaPercorrer).size(); i++) {
            for (int j = 0; j < produtoCartesiano.reverterParesOrdenados(listaPercorrer).get(i).getElementos().size(); j++) {
                if (0 == j) {
                    System.out.print("{" + produtoCartesiano.reverterParesOrdenados(listaPercorrer).get(i).getElementos().get(j).getValor() + ", ");
                } else if (produtoCartesiano.reverterParesOrdenados(listaPercorrer).get(i).getElementos().size() - 1 == j) {
                    System.out.print(produtoCartesiano.reverterParesOrdenados(listaPercorrer).get(i).getElementos().get(j).getValor() + "}, ");
                } else {
                    System.out.print(produtoCartesiano.reverterParesOrdenados(listaPercorrer).get(i).getElementos().get(j).getValor() + ", ");
                }
            }
            System.out.print("\n");
        }
    }
}
