package br.com.matematica;

import br.com.matematica.models.Conjunto;
import br.com.matematica.models.ConjuntoDasPartes;
import br.com.matematica.models.Contido;
import br.com.matematica.models.Diferenca;
import br.com.matematica.models.Elemento;
import br.com.matematica.models.GerenciadorArquivo;
import br.com.matematica.models.Intercessao;
import br.com.matematica.models.Pertinencia;
import br.com.matematica.models.ProdutoCartesiano;
import br.com.matematica.models.Uniao;
import br.com.matematica.models.exceptions.ExceptionObjetoInvalido;
import br.com.matematica.models.exceptions.ExceptionSintaxeArquivo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static Scanner scanner = new Scanner(System.in);

    public static String getMenu() {

        String str = "\n\n"
                + "--------------------------- <Menu> ---------------------------\n"
                + " 1) Ler arquivo\n"
                + " 2) Pertinência\n"
                + " 3) Contido ou igual\n"
                + " 4) Contido propriamente\n"
                + " 5) União\n"
                + " 6) Intercessão\n"
                + " 7) Produto cartesiano\n"
                + " 8) Conjunto das partes\n"
                + " 9) Diferença de conjuntos\n"
                + "10) Sair\n"
                + "--------------------------------------------------------------\n";
        return str;
    }

    public static void mostrarConjuntos(List<Conjunto> conjuntos, int tamanho) {

        for (int j = 0; j < tamanho; j++) {
            if (conjuntos.get(j).getNome() != null) {
                System.out.print(conjuntos.get(j).getNome() + " = ");
            }
            if (conjuntos.get(j).getElementos().isEmpty()) {
                System.out.print("{}\n");
            } else {
                for (int i = 0; i < conjuntos.get(j).getElementos().size(); i++) {

                    if (conjuntos.get(j).getElementos().size() == 1) {
                        System.out.print("{" + conjuntos.get(j).getElementos().get(i).getValor() + "}\n");
                    } else {
                        if (i == 0) {
                            System.out.print("{" + conjuntos.get(j).getElementos().get(i).getValor() + ", ");
                        } else if (i == conjuntos.get(j).getElementos().size() - 1) {
                            System.out.print(conjuntos.get(j).getElementos().get(i).getValor() + "}\n");
                        } else {
                            System.out.print(conjuntos.get(j).getElementos().get(i).getValor() + ", ");
                        }
                    }
                }
            }
        }
    }

    public static void mostrarNomeConjuntos(List<Conjunto> conjuntos) {

        for (int j = 0; j < conjuntos.size(); j++) {
            if (conjuntos.get(j).getNome() != null) {
                if (conjuntos.size() == 1) {
                    System.out.print(conjuntos.get(0).getNome() + ".\n");
                } else {
                    if (j == conjuntos.size() - 1) {
                        System.out.print(conjuntos.get(j).getNome() + ".\n");
                    } else {
                        System.out.print(conjuntos.get(j).getNome() + ", ");
                    }
                }
            }
        }
    }

    public static void mostrarConjunto(Conjunto conjunto) {
        if (conjunto.getNome() != null) {
            System.out.print(conjunto.getNome() + " = ");
        }
        if (conjunto.getElementos().isEmpty()) {
            System.out.println("{}\n");
        } else {
            for (int i = 0; i < conjunto.getElementos().size(); i++) {
                if (conjunto.getElementos().size() == 1) {
                    System.out.print("{" + conjunto.getElementos().get(i).getValor() + "}\n");
                } else {
                    if (i == 0) {
                        System.out.print("{" + conjunto.getElementos().get(i).getValor() + ", ");
                    } else if (i == conjunto.getElementos().size() - 1) {
                        System.out.print(conjunto.getElementos().get(i).getValor() + "}\n");
                    } else {
                        System.out.print(conjunto.getElementos().get(i).getValor() + ", ");
                    }
                }
            }
        }
    }

    public static void mostrarElementos(List<Elemento> elementos, int tamanho) {
        for (int j = 0; j < tamanho; j++) {
            System.out.println(elementos.get(j).getNome() + " = " + elementos.get(j).getValor());
        }
    }

    public static void main(String[] args) throws IOException, FileNotFoundException, ExceptionSintaxeArquivo, ExceptionObjetoInvalido {
        GerenciadorArquivo arquivo = new GerenciadorArquivo();
        Contido contido = new Contido();

        int escolhaMenu;
        do {
            System.out.println(getMenu());
            System.out.println("Escolha uma Opção: ");
            escolhaMenu = scanner.nextInt();

            switch (escolhaMenu) {

                case 1:
                    arquivo.leitura();

                    System.out.println("O arquivo foi lido com sucesso...");

                    if (!arquivo.getConjuntos().isEmpty()) {
                        System.out.println("\nConjunto(s):\n");
                        mostrarConjuntos(arquivo.getConjuntos(), arquivo.getConjuntos().size());
                    }
                    if (!arquivo.getElementos().isEmpty()) {
                        System.out.println("\nElemento(s):\n");
                        mostrarElementos(arquivo.getElementos(), arquivo.getElementos().size());
                    }
                    break;
                case 2:
                    if (!arquivo.getConjuntos().isEmpty() && !arquivo.getElementos().isEmpty()) {

                        System.out.println("\nSerão utilizados:");
                        System.out.print("\nElemento: ");
                        mostrarElementos(arquivo.getElementos(), 1);

                        System.out.print("\nConjunto: ");
                        mostrarConjuntos(arquivo.getConjuntos(), 1);

                        System.out.print("\nResultado: ");
                        if (Pertinencia.getInstancia().pertence(arquivo.getElementos().get(0), arquivo.getConjuntos().get(0))) {
                            System.out.println("O elemento pertence!");
                        } else {
                            System.out.println("O elemento NÃO pertence!");
                        }
                    } else {
                        System.out.println("Leia o arquivo (opção 1) ou verifique se há ao menos 1 elemento e 1 conjunto nele.");
                    }
                    break;
                case 3:
                    if (!arquivo.getConjuntos().isEmpty() && arquivo.getConjuntos().size() >= 2) {

                        System.out.println("Serão utilizados:\n");
                        System.out.println("Conjunto: ");
                        mostrarConjuntos(arquivo.getConjuntos(), 2);

                        System.out.print("\nResultado: ");
                        if (contido.contidoIgual(arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1))) {
                            System.out.println("O conjunto " + arquivo.getConjuntos().get(0).getNome() + " é contido ou igual a " + arquivo.getConjuntos().get(1).getNome());
                        } else {
                            System.out.println("O conjunto " + arquivo.getConjuntos().get(0).getNome() + " NÃO é contido ou igual a " + arquivo.getConjuntos().get(1).getNome());
                        }
                    } else {
                        System.out.println("Leia o arquivo (opção 1) ou verifique se há no mínimo 2 conjuntos nele.");
                    }
                    break;
                case 4:
                    if (!arquivo.getConjuntos().isEmpty() && arquivo.getConjuntos().size() >= 2) {

                        System.out.println("Serão utilizados:\n");
                        System.out.println("Conjunto: ");
                        mostrarConjuntos(arquivo.getConjuntos(), 2);

                        System.out.print("\nResultado: ");
                        if (contido.contidoPropriamente(arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1))) {
                            System.out.println("O conjunto " + arquivo.getConjuntos().get(0).getNome() + " é contido propriamente a " + arquivo.getConjuntos().get(1).getNome());
                        } else {
                            System.out.println("O conjunto " + arquivo.getConjuntos().get(0).getNome() + " NÃO é contido propriamente a " + arquivo.getConjuntos().get(1).getNome());
                        }
                    } else {
                        System.out.println("Leia o arquivo (opção 1) ou verifique se há no mínimo 2 conjuntos nele.");
                    }
                    break;
                case 5:
                    if (!arquivo.getConjuntos().isEmpty() && arquivo.getConjuntos().size() >= 2) {

                        System.out.println("Serão utilizados:\n");
                        System.out.println("Conjunto: ");
                        mostrarConjuntos(arquivo.getConjuntos(), arquivo.getConjuntos().size());

                        Conjunto conjuntoUniao = new Conjunto();

                        for (Conjunto c : arquivo.getConjuntos()) {
                            conjuntoUniao = Uniao.getInstancia().get(conjuntoUniao, c);
                        }

                        System.out.println("\n\nO conjunto formado foi:\n");
                        System.out.print("União de: ");
                        mostrarNomeConjuntos(arquivo.getConjuntos());
                        System.out.print("\n");
                        mostrarConjunto(conjuntoUniao);
                    } else {
                        System.out.println("Leia o arquivo (opção 1) ou verifique se há no mínimo 2 conjuntos nele.");
                    }
                    break;
                case 6:
                    if (!arquivo.getConjuntos().isEmpty() && arquivo.getConjuntos().size() >= 2) {

                        System.out.println("Serão utilizados:\n");
                        System.out.println("Conjunto: ");
                        mostrarConjuntos(arquivo.getConjuntos(), arquivo.getConjuntos().size());

                        Conjunto conjuntoIntercessao = new Conjunto();

                        for (int j = 0; j < arquivo.getConjuntos().size(); j++) {
                            if (j == 0) {
                                conjuntoIntercessao = Intercessao.getInstancia().get(arquivo.getConjuntos().get(j), arquivo.getConjuntos().get(j + 1));
                            } else {
                                conjuntoIntercessao = Intercessao.getInstancia().get(conjuntoIntercessao, arquivo.getConjuntos().get(j));
                            }
                        }

                        System.out.println("\n\nO conjunto formado foi:\n");
                        System.out.print("Intercessão de: ");
                        mostrarNomeConjuntos(arquivo.getConjuntos());
                        System.out.print("\n");
                        mostrarConjunto(conjuntoIntercessao);
                    } else {
                        System.out.println("Leia o arquivo (opção 1) ou verifique se há no mínimo 2 conjuntos nele.");
                    }
                    break;
                case 7:
                    if (!arquivo.getConjuntos().isEmpty() && arquivo.getConjuntos().size() >= 2) {

                        System.out.println("Serão utilizados:\n");
                        System.out.println("Conjunto: ");
                        mostrarConjuntos(arquivo.getConjuntos(), 2);

                        ProdutoCartesiano produtoCartesiano = new ProdutoCartesiano();

                        List<Object> resultadoProdutoCartesiano = produtoCartesiano.get(arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1));

                        System.out.println("\nResultado:\n");
                        produtoCartesiano.imprimir(resultadoProdutoCartesiano);

                        System.out.println("\n\nDeseja reverter? Digite 'S' para SIM");
                        String escolhaReverterProdutoCartesiano = scanner.next();

                        if ("S".equals(escolhaReverterProdutoCartesiano.toUpperCase())) {
                            System.out.println("\nResultado:\n");
                            List<Conjunto> reverterProdutoCartesiano = produtoCartesiano.reverterParesOrdenados(resultadoProdutoCartesiano);
                            mostrarConjuntos(reverterProdutoCartesiano, reverterProdutoCartesiano.size());
                        }
                    } else {
                        System.out.println("Leia o arquivo (opção 1) ou verifique se há no mínimo 2 conjuntos nele.");
                    }
                    break;
                case 8:
                    if (!arquivo.getConjuntos().isEmpty()) {

                        System.out.println("Serão utilizados:\n");
                        System.out.println("Conjunto: ");
                        mostrarConjuntos(arquivo.getConjuntos(), 1);

                        ConjuntoDasPartes conjuntoDasPartes = new ConjuntoDasPartes();

                        List<Conjunto> resultadoConjuntoDasPartes = conjuntoDasPartes.get(arquivo.getConjuntos().get(0));
                        System.out.print("\n");
                        conjuntoDasPartes.imprimir(resultadoConjuntoDasPartes);

                        System.out.println("\n\nDeseja reverter? Digite 'S' para SIM");
                        String escolhaReverterConjuntodasPartes = scanner.next();

                        if ("S".equals(escolhaReverterConjuntodasPartes.toUpperCase())) {
                            System.out.println("\nResultado:\n");
                            Conjunto reversaoConjuntoDasPartes = conjuntoDasPartes.reverter(resultadoConjuntoDasPartes);
                            mostrarConjunto(reversaoConjuntoDasPartes);
                        }
                    } else {
                        System.out.println("Leia o arquivo (opção 1) ou verifique se há no mínimo 1 conjunto nele.");
                    }
                    break;
                case 9:
                    if (!arquivo.getConjuntos().isEmpty() && arquivo.getConjuntos().size() >= 2) {

                        System.out.println("Serão utilizados:\n");
                        System.out.println("Conjunto: ");
                        mostrarConjuntos(arquivo.getConjuntos(), 2);

                        Diferenca diferenca = new Diferenca();
                        Conjunto conjuntoDiferenca = diferenca.get(arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1));

                        System.out.println("\nConjunto formado:");
                        System.out.print("\n" + arquivo.getConjuntos().get(0).getNome() + " - " + arquivo.getConjuntos().get(1).getNome() + " = ");
                        mostrarConjunto(conjuntoDiferenca);
                    } else {
                        System.out.println("Leia o arquivo (opção 1) ou verifique se há no mínimo 2 conjuntos nele.");
                    }
                    break;
                case 10:
                    break;
                default:
                    break;
            }
        } while (escolhaMenu != 10);
    }
}
