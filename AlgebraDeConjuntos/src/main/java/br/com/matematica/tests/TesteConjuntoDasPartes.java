package br.com.matematica.tests;

import br.com.matematica.models.Conjunto;
import br.com.matematica.models.Elemento;
import br.com.matematica.models.ConjuntoDasPartes;
import java.util.List;

public class TesteConjuntoDasPartes {

    public static void main(String[] args) {

        Conjunto conjunto = new Conjunto("A");
        conjunto.adicionarElemento(new Elemento(1));
        conjunto.adicionarElemento(new Elemento(2));
        conjunto.adicionarElemento(new Elemento(3));
        conjunto.adicionarElemento(new Elemento(4));

        ConjuntoDasPartes conjuntoDasPartes = new ConjuntoDasPartes();
        List<Conjunto> resultado = conjuntoDasPartes.get(conjunto);
        conjuntoDasPartes.imprimir(resultado);

        Conjunto reversaoConjuntoDasPartes = conjuntoDasPartes.reverter(resultado);
        for (int i = 0; i < reversaoConjuntoDasPartes.getElementos().size(); i++) {
            if (i == 0) {
                System.out.print("{" + reversaoConjuntoDasPartes.getElementos().get(i).getValor() + ", ");
            } else if (i == reversaoConjuntoDasPartes.getElementos().size() - 1) {
                System.out.print(reversaoConjuntoDasPartes.getElementos().get(i).getValor() + "}\n");
            } else {
                System.out.print(reversaoConjuntoDasPartes.getElementos().get(i).getValor() + ", ");
            }
        }
    }
}
