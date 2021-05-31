package br.com.matematica.models;

//import br.com.matematica.models.exceptions.ExceptionObjetoInvalido;
import java.util.ArrayList;
import java.util.List;

public class ConjuntoDasPartes {

    private static ConjuntoDasPartes instancia = new ConjuntoDasPartes();
    private List<Conjunto> conjuntoPartes;

    public static ConjuntoDasPartes getInstancia() {
        return instancia;
    }

    public List<Conjunto> get(Conjunto conjunto) {
        conjuntoPartes = new ArrayList();
        int [][] matriz = tabelaVerdade(conjunto.getElementos().size());
        
        for (int linha = 0; linha < matriz.length; linha++) {
            
            Conjunto subConjunto = new Conjunto();
            
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.print(matriz[linha][coluna] + " ");
                
                if(matriz[linha][coluna] == 1){
                    subConjunto.adicionarElemento(conjunto.getElementos().get(coluna));
                }   
            }
            conjuntoPartes.add(subConjunto);
            System.out.print("\n");
        }

        return conjuntoPartes;
    }

    public int[][] tabelaVerdade(int tamanhoConjunto) {

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
                //System.out.print(matriz[linha][coluna] + "  ");
            }
            //System.out.print("\n");
        }
        return matriz;
    }

    public int potencia(int base, int expoente) {
        int resultado = 1;

        for (int i = 0; i < expoente; i++) {
            resultado = resultado * base;
        }
        return resultado;
    }
}
