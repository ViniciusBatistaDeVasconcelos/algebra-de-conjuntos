package br.com.matematica.models;

import java.util.ArrayList;
import java.util.List;

public class ConjuntoDasPartes {
   
    public List<Conjunto> get(Conjunto conjunto) {
        List<Conjunto> conjuntoPartes = new ArrayList();
        int[][] matriz = tabelaVerdade(conjunto.getElementos().size());

        for (int linha = 0; linha < matriz.length; linha++) {

            Conjunto subConjunto = new Conjunto();

            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                if (matriz[linha][coluna] == 1) {
                    subConjunto.adicionarElemento(conjunto.getElementos().get(coluna));
                }
            }
            conjuntoPartes.add(subConjunto);
        }

        return conjuntoPartes;
    }

    public Conjunto reverter(List<Conjunto> conjuntoPartes) {
        Conjunto conjunto = new Conjunto();

        for (int i = 0; i < conjuntoPartes.size(); i++) {
            conjunto = Uniao.getInstancia().get(conjuntoPartes.get(i), conjunto);
        }
        return conjunto;
    }

    private int[][] tabelaVerdade(int tamanhoConjunto) {

        int qtdIteracao = potencia(2, tamanhoConjunto);
        int[][] matriz = new int[qtdIteracao][tamanhoConjunto];
        int valor;

        for (int linha = 0; linha < qtdIteracao; linha++) {
            valor = 0;
            for (int coluna = 0; coluna < tamanhoConjunto; coluna++) {

                int colunaInvertida = tamanhoConjunto - 1 - coluna;
                int magnitude = potencia(2, colunaInvertida);

                if (magnitude <= linha) {
                    if (valor + magnitude <= linha) {
                        valor = valor + magnitude;
                        matriz[linha][coluna] = 1;
                    }
                }
            }
        }
        return matriz;
    }

    private int potencia(int base, int expoente) {
        int resultado = 1;

        for (int i = 0; i < expoente; i++) {
            resultado = resultado * base;
        }
        return resultado;
    }

    public void imprimir(List<Conjunto> conjuntoPartes) {
        System.out.println("{");
        for (int i = 0; i < conjuntoPartes.size(); i++) {
            if (conjuntoPartes.get(i).getElementos().isEmpty()) {
                System.out.println("{}, ");
            } else {
                for (int j = 0; j < conjuntoPartes.get(i).getElementos().size(); j++) {
                    if (j == 0 && conjuntoPartes.get(i).getElementos().size() - 1 == 0) {
                        System.out.print("{" + conjuntoPartes.get(i).getElementos().get(j).getValor() + "}, ");
                    } else if (j == 0 && conjuntoPartes.get(i).getElementos().size() - 1 != 0) {
                        System.out.print("{" + conjuntoPartes.get(i).getElementos().get(j).getValor() + ", ");
                    } else if (j != 0 && conjuntoPartes.get(i).getElementos().size() - 1 == j && conjuntoPartes.size() - 1 == i) {
                        System.out.print(conjuntoPartes.get(i).getElementos().get(j).getValor() + "}");
                    } else if (j != 0 && conjuntoPartes.get(i).getElementos().size() - 1 == j) {
                        System.out.print(conjuntoPartes.get(i).getElementos().get(j).getValor() + "}, ");
                    } else {
                        System.out.print(conjuntoPartes.get(i).getElementos().get(j).getValor() + ", ");
                    }
                }
                System.out.print("\n");
            }
        }
        System.out.println("}");
    }
}
