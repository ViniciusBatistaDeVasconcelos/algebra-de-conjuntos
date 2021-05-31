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
        for(Conjunto c : arquivo.getConjuntos()){
            System.out.print(c.getNome());
            for(Elemento e: c.getElementos()){
                System.out.print("\t"+e.getValor());
            }
            System.out.println("");
        }
    }
}
