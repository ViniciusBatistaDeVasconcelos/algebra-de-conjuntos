package br.com.matematica.tests;

import br.com.matematica.models.Conjunto;
import br.com.matematica.models.Elemento;
import br.com.matematica.models.GerenciadorArquivo;
import br.com.matematica.models.exceptions.ExceptionSintaxeArquivo;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TesteGerenciadorArquivo {

    public static void main(String[] args) throws IOException, FileNotFoundException, ExceptionSintaxeArquivo {
        GerenciadorArquivo arquivo = new GerenciadorArquivo();

        arquivo.leitura();

        for (Conjunto c : arquivo.getConjuntos()) {
            System.out.print(c.getNome() + " = ");

            if (c.getElementos().isEmpty()) {
                System.out.print("{}");
            } else {
                for (int i = 0; i < c.getElementos().size(); i++) {
                    if (i == 0) {
                        System.out.print("{" + c.getElementos().get(i).getValor() + ", ");
                    } else if (i == c.getElementos().size() - 1) {
                        System.out.print(c.getElementos().get(i).getValor() + "}");
                    } else {
                        System.out.print(c.getElementos().get(i).getValor() + ", ");
                    }
                }
            }
            System.out.print("\n");
        }

        for (Elemento e : arquivo.getElementos()) {
            System.out.println(e.getNome() + " = " + e.getValor());
        }
    }
}
