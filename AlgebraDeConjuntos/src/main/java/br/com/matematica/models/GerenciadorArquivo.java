package br.com.matematica.models;

import br.com.matematica.models.exceptions.ExceptionSintaxeArquivo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GerenciadorArquivo {

    private String caminho = "./src/main/java/br/com/matematica/Entrada.txt";
    private List<Conjunto> conjuntos;
    private List<Elemento> elementos;

    public GerenciadorArquivo() {

    }

    public GerenciadorArquivo(String caminho) {
        this.caminho = caminho;
    }

    public List<Conjunto> getConjuntos() {
        return conjuntos;
    }

    public List<Elemento> getElementos() {
        return elementos;
    }

    public void leitura() throws FileNotFoundException, IOException, ExceptionSintaxeArquivo {
        this.conjuntos = new ArrayList<>();
        this.elementos = new ArrayList<>();

        FileReader arquivo = new FileReader(caminho);
        BufferedReader ler = new BufferedReader(arquivo);

        String linha = ler.readLine();

        while (linha != null) {

            String str = linha;

            str = str.trim();
            str = str.replaceAll("\n", "");
            str = str.replaceAll("\t", "");
            str = str.replaceAll(" ", "");

            if (str.indexOf("=") != -1) {
                if (str.split("=")[0].length() == 1) {

                    int ascii = (int) str.split("=")[0].charAt(0);
                    if (ascii >= 65 && ascii <= 90) {

                        if (str.split("=")[1].indexOf("{") != -1 && str.split("=")[1].indexOf("}") != -1) {

                            if (str.indexOf("=") == str.indexOf("{") - 1 && str.indexOf("}") == str.length() - 1) {

                                Conjunto conjunto = new Conjunto(str.split("=")[0]);

                                if (str.indexOf("{") != str.indexOf("}") - 1) {

                                    String elementos[] = str.substring(str.indexOf("{") + 1, str.indexOf("}")).split(",");

                                    for (String e : elementos) {
                                        conjunto.adicionarElemento(new Elemento(Integer.parseInt(e)));
                                    }
                                }

                                conjuntos.add(conjunto);

                            } else {
                                throw new ExceptionSintaxeArquivo("004 - Certifique-se que não há nada fora do parênteses: " + linha);
                            }
                        } else {
                            throw new ExceptionSintaxeArquivo("003 - Falta de parênteses: " + linha);
                        }

                    } else if (ascii >= 97 && ascii <= 122) {
                        //System.out.println(str.split("=")[0]);
                    } else {
                        throw new ExceptionSintaxeArquivo("002 - Insira uma letra para representar o conjunto (UpperCase) ou elemento (LowerCase): " + linha);
                    }
                } else {
                    throw new ExceptionSintaxeArquivo("002 - Insira uma letra para representar o conjunto (UpperCase) ou elemento (LowerCase): " + linha);
                }
            } else {
                throw new ExceptionSintaxeArquivo("001 - Falta o sinal de igualdade: " + linha);
            }

            //System.out.println(linha);
            linha = ler.readLine();
        }
        arquivo.close();
    }
}
