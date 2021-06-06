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

                        System.out.println("\nConjuntos(S):\n");
                        for (int j = 0; j < arquivo.getConjuntos().size(); j++) {
                            System.out.print(arquivo.getConjuntos().get(j).getNome() + " = ");
                            if (arquivo.getConjuntos().get(j).getElementos().isEmpty()) {
                                System.out.print("{}\n");
                            } else {
                                for (int i = 0; i < arquivo.getConjuntos().get(j).getElementos().size(); i++) {
                                    if (arquivo.getConjuntos().get(j).getElementos().size() == 1) {
                                        System.out.print("{" + arquivo.getConjuntos().get(j).getElementos().get(0).getValor() + "}\n");
                                    } else {
                                        if (i == 0) {
                                            System.out.print("{" + arquivo.getConjuntos().get(j).getElementos().get(i).getValor() + ", ");
                                        } else if (i == arquivo.getConjuntos().get(j).getElementos().size() - 1) {
                                            System.out.print(arquivo.getConjuntos().get(j).getElementos().get(i).getValor() + "}\n");
                                        } else {
                                            System.out.print(arquivo.getConjuntos().get(j).getElementos().get(i).getValor() + ", ");
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (!arquivo.getElementos().isEmpty()) {

                        System.out.println("\nElemento(s):\n");
                        for (Elemento e : arquivo.getElementos()) {
                            System.out.println(e.getNome() + " = " + e.getValor());
                        }
                    }
                    break;
                case 2:
                    if (!arquivo.getConjuntos().isEmpty() && !arquivo.getElementos().isEmpty()) {
                        System.out.println("\nSerão utilizados:");

                        System.out.print("\nElemento:");
                        System.out.println("\t" + arquivo.getElementos().get(0).getNome() + " = " + arquivo.getElementos().get(0).getValor());

                        System.out.print("\nConjunto:");
                        System.out.print("\t" + arquivo.getConjuntos().get(0).getNome() + " = ");
                        for (int i = 0; i < arquivo.getConjuntos().get(0).getElementos().size(); i++) {
                            if (arquivo.getConjuntos().get(0).getElementos().size() == 1) {
                                System.out.print("{" + arquivo.getConjuntos().get(0).getElementos().get(0).getValor() + "}");
                            } else {
                                if (i == 0) {
                                    System.out.print("{" + arquivo.getConjuntos().get(0).getElementos().get(i).getValor() + ", ");
                                } else if (i == arquivo.getConjuntos().get(0).getElementos().size() - 1) {
                                    System.out.print(arquivo.getConjuntos().get(0).getElementos().get(i).getValor() + "}\n");
                                } else {
                                    System.out.print(arquivo.getConjuntos().get(0).getElementos().get(i).getValor() + ", ");
                                }
                            }
                        }

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

                        System.out.println("\nSerão utilizados:\n");

                        for (int j = 0; j < 2; j++) {
                            for (int i = 0; i < arquivo.getConjuntos().get(j).getElementos().size(); i++) {
                                if (arquivo.getConjuntos().get(j).getElementos().size() == 1) {
                                    System.out.print("\t" + arquivo.getConjuntos().get(j).getNome() + " = {" + arquivo.getConjuntos().get(0).getElementos().get(i).getValor() + "}\n");
                                } else {
                                    if (i == 0) {
                                        System.out.print("\t" + arquivo.getConjuntos().get(j).getNome() + " = {" + arquivo.getConjuntos().get(0).getElementos().get(i).getValor() + ", ");
                                    } else if (i == arquivo.getConjuntos().get(j).getElementos().size() - 1) {
                                        System.out.print(arquivo.getConjuntos().get(j).getElementos().get(i).getValor() + "}\n");
                                    } else {
                                        System.out.print(arquivo.getConjuntos().get(j).getElementos().get(i).getValor() + ", ");
                                    }
                                }
                            }
                        }
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

                        System.out.println("\nSerão utilizados:\n");

                        for (int j = 0; j < 2; j++) {
                            for (int i = 0; i < arquivo.getConjuntos().get(j).getElementos().size(); i++) {
                                if (arquivo.getConjuntos().get(j).getElementos().size() == 1) {
                                    System.out.print("\t" + arquivo.getConjuntos().get(j).getNome() + " = {" + arquivo.getConjuntos().get(0).getElementos().get(i).getValor() + "}\n");
                                } else {
                                    if (i == 0) {
                                        System.out.print("\t" + arquivo.getConjuntos().get(j).getNome() + " = {" + arquivo.getConjuntos().get(0).getElementos().get(i).getValor() + ", ");
                                    } else if (i == arquivo.getConjuntos().get(j).getElementos().size() - 1) {
                                        System.out.print(arquivo.getConjuntos().get(j).getElementos().get(i).getValor() + "}\n");
                                    } else {
                                        System.out.print(arquivo.getConjuntos().get(j).getElementos().get(i).getValor() + ", ");
                                    }
                                }
                            }
                        }

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
                        Conjunto conjuntoUniao = new Conjunto();

                        System.out.println("\nSerão utilizados:\n");
                        for (int j = 0; j < arquivo.getConjuntos().size(); j++) {
                            conjuntoUniao = Uniao.getInstancia().get(conjuntoUniao, arquivo.getConjuntos().get(j));

                            System.out.print(arquivo.getConjuntos().get(j).getNome() + " = ");
                            if (arquivo.getConjuntos().get(j).getElementos().isEmpty()) {
                                System.out.print("{}\n");
                            } else {
                                for (int i = 0; i < arquivo.getConjuntos().get(j).getElementos().size(); i++) {
                                    if (arquivo.getConjuntos().get(j).getElementos().size() == 1) {
                                        System.out.print("{" + arquivo.getConjuntos().get(j).getElementos().get(i).getValor() + "}\n");
                                    } else {
                                        if (i == 0) {
                                            System.out.print("{" + arquivo.getConjuntos().get(j).getElementos().get(i).getValor() + ", ");
                                        } else if (i == arquivo.getConjuntos().get(j).getElementos().size() - 1) {
                                            System.out.print(arquivo.getConjuntos().get(j).getElementos().get(i).getValor() + "}\n");
                                        } else {
                                            System.out.print(arquivo.getConjuntos().get(j).getElementos().get(i).getValor() + ", ");
                                        }
                                    }
                                }
                            }
                        }

                        System.out.println("\n\nO conjunto formado foi:");

                        for (int i = 0; i < arquivo.getConjuntos().size(); i++) {
                            if (i == 0) {
                                System.out.print("União de " + arquivo.getConjuntos().get(i).getNome() + ", ");
                            } else if (i == arquivo.getConjuntos().size() - 1) {
                                System.out.print(arquivo.getConjuntos().get(i).getNome() + ".\n");
                            } else {
                                System.out.print(arquivo.getConjuntos().get(i).getNome() + " e ");
                            }
                        }

                        if (conjuntoUniao.getElementos().isEmpty()) {
                            System.out.println("\t{}\n");
                        } else {
                            for (int i = 0; i < conjuntoUniao.getElementos().size(); i++) {
                                if (conjuntoUniao.getElementos().size() == 1) {
                                    System.out.print("\t{" + conjuntoUniao.getElementos().get(i).getValor() + "}\n");
                                } else {
                                    if (i == 0) {
                                        System.out.print("\t{" + conjuntoUniao.getElementos().get(i).getValor() + ", ");
                                    } else if (i == conjuntoUniao.getElementos().size() - 1) {
                                        System.out.print(conjuntoUniao.getElementos().get(i).getValor() + "}\n");
                                    } else {
                                        System.out.print(conjuntoUniao.getElementos().get(i).getValor() + ", ");
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Leia o arquivo (opção 1) ou verifique se há no mínimo 2 conjuntos nele.");
                    }
                    break;
                case 6:
                    if (!arquivo.getConjuntos().isEmpty() && arquivo.getConjuntos().size() >= 2) {
                        Conjunto conjuntoIntercessao = new Conjunto();

                        System.out.println("\nSerão utilizados:\n");
                        for (int j = 0; j < arquivo.getConjuntos().size(); j++) {
                            if (j == 0) {
                                conjuntoIntercessao = Intercessao.getInstancia().get(arquivo.getConjuntos().get(j), arquivo.getConjuntos().get(j + 1));
                            } else {
                                conjuntoIntercessao = Intercessao.getInstancia().get(conjuntoIntercessao, arquivo.getConjuntos().get(j));
                            }

                            System.out.print(arquivo.getConjuntos().get(j).getNome() + " = ");
                            if (arquivo.getConjuntos().get(j).getElementos().isEmpty()) {
                                System.out.print("{}");
                            } else {
                                for (int i = 0; i < arquivo.getConjuntos().get(j).getElementos().size(); i++) {
                                    if (arquivo.getConjuntos().get(j).getElementos().size() == 1) {
                                        System.out.print("{" + arquivo.getConjuntos().get(j).getElementos().get(i).getValor() + "}");
                                    } else {
                                        if (i == 0) {
                                            System.out.print("{" + arquivo.getConjuntos().get(j).getElementos().get(i).getValor() + ", ");
                                        } else if (i == arquivo.getConjuntos().get(j).getElementos().size() - 1) {
                                            System.out.print(arquivo.getConjuntos().get(j).getElementos().get(i).getValor() + "}\n");
                                        } else {
                                            System.out.print(arquivo.getConjuntos().get(j).getElementos().get(i).getValor() + ", ");
                                        }
                                    }
                                }
                            }
                        }

                        System.out.println("\n\nO conjunto formado foi: ");
                        for (int i = 0; i < arquivo.getConjuntos().size(); i++) {
                            if (i == 0) {
                                System.out.print("Intercessão de " + arquivo.getConjuntos().get(i).getNome() + ", ");
                            } else if (i == arquivo.getConjuntos().size() - 1) {
                                System.out.print(arquivo.getConjuntos().get(i).getNome() + ".\n");
                            } else {
                                System.out.print(arquivo.getConjuntos().get(i).getNome() + " e ");
                            }
                        }
                        if (conjuntoIntercessao.getElementos().isEmpty()) {
                            System.out.println("\t{}\n");
                        } else {
                            for (int i = 0; i < conjuntoIntercessao.getElementos().size(); i++) {
                                if (conjuntoIntercessao.getElementos().size() == 1) {
                                    System.out.print("\t{" + conjuntoIntercessao.getElementos().get(i).getValor() + "}\n");
                                } else {
                                    if (i == 0) {
                                        System.out.print("\t{" + conjuntoIntercessao.getElementos().get(i).getValor() + ", ");
                                    } else if (i == conjuntoIntercessao.getElementos().size() - 1) {
                                        System.out.print(conjuntoIntercessao.getElementos().get(i).getValor() + "}\n");
                                    } else {
                                        System.out.print(conjuntoIntercessao.getElementos().get(i).getValor() + ", ");
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Leia o arquivo (opção 1) ou verifique se há no mínimo 2 conjuntos nele.");
                    }
                    break;
                case 7:
                    if (!arquivo.getConjuntos().isEmpty() && arquivo.getConjuntos().size() >= 2) {

                        System.out.println("\nSerão utilizados:\n");

                        for (int j = 0; j < 2; j++) {
                            for (int i = 0; i < arquivo.getConjuntos().get(j).getElementos().size(); i++) {
                                if (arquivo.getConjuntos().get(j).getElementos().size() == 1) {
                                    System.out.print("\t" + arquivo.getConjuntos().get(j).getNome() + " = {" + arquivo.getConjuntos().get(0).getElementos().get(i).getValor() + "}");
                                } else {
                                    if (i == 0) {
                                        System.out.print("\t" + arquivo.getConjuntos().get(j).getNome() + " = {" + arquivo.getConjuntos().get(0).getElementos().get(i).getValor() + ", ");
                                    } else if (i == arquivo.getConjuntos().get(j).getElementos().size() - 1) {
                                        System.out.print(arquivo.getConjuntos().get(j).getElementos().get(i).getValor() + "}\n");
                                    } else {
                                        System.out.print(arquivo.getConjuntos().get(j).getElementos().get(i).getValor() + ", ");
                                    }
                                }
                            }
                            System.out.print("\n");
                        }
                        ProdutoCartesiano produtoCartesiano = new ProdutoCartesiano();

                        List<Object> resultadoProdutoCartesiano = produtoCartesiano.get(arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1));
                        System.out.println("Resultado:\n");
                        produtoCartesiano.imprimir(resultadoProdutoCartesiano);

                        System.out.println("\n\nDeseja reverter? Digite 'S' para SIM");
                        String escolhaReverterProdutoCartesiano = scanner.next();

                        if ("S".equals(escolhaReverterProdutoCartesiano.toUpperCase())) {
                            System.out.println("Resultado: ");

                            List<Conjunto> reverterProdutoCartesiano = produtoCartesiano.reverterParesOrdenados(resultadoProdutoCartesiano);

                            for (int i = 0; i < reverterProdutoCartesiano.size(); i++) {
                                for (int j = 0; j < reverterProdutoCartesiano.get(i).getElementos().size(); j++) {
                                    if (reverterProdutoCartesiano.get(i).getElementos().size() == 1) {
                                        System.out.print("\t{" + reverterProdutoCartesiano.get(i).getElementos().get(j).getValor() + "}");
                                    } else {
                                        if (0 == j) {
                                            System.out.print("\t{" + reverterProdutoCartesiano.get(i).getElementos().get(j).getValor() + ", ");
                                        } else if (reverterProdutoCartesiano.get(i).getElementos().size() - 1 == j) {
                                            System.out.print(reverterProdutoCartesiano.get(i).getElementos().get(j).getValor() + "} ");
                                        } else {
                                            System.out.print(reverterProdutoCartesiano.get(i).getElementos().get(j).getValor() + ", ");
                                        }
                                    }
                                }
                                System.out.print("\n");
                            }
                        }
                    } else {
                        System.out.println("Leia o arquivo (opção 1) ou verifique se há no mínimo 2 conjuntos nele.");
                    }
                    break;
                case 8:
                    if (!arquivo.getConjuntos().isEmpty()) {

                        System.out.println("\nSerá utilizado:\n");

                        for (int i = 0; i < arquivo.getConjuntos().get(0).getElementos().size(); i++) {
                            if (arquivo.getConjuntos().get(0).getElementos().size() == 1) {
                                System.out.print("\t" + arquivo.getConjuntos().get(0).getNome() + " = {" + arquivo.getConjuntos().get(0).getElementos().get(i).getValor() + "}\n");
                            } else {
                                if (i == 0) {
                                    System.out.print("{" + arquivo.getConjuntos().get(0).getElementos().get(i).getValor() + ", ");
                                } else if (i == arquivo.getConjuntos().get(0).getElementos().size() - 1) {
                                    System.out.print(arquivo.getConjuntos().get(0).getElementos().get(i).getValor() + "}\n");
                                } else {
                                    System.out.print(arquivo.getConjuntos().get(0).getElementos().get(i).getValor() + ", ");
                                }
                            }
                        }

                        ConjuntoDasPartes conjuntoDasPartes = new ConjuntoDasPartes();

                        List<Conjunto> resultadoConjuntoDasPartes = conjuntoDasPartes.get(arquivo.getConjuntos().get(0));
                        conjuntoDasPartes.imprimir(resultadoConjuntoDasPartes);

                        System.out.println("\n\nDeseja reverter? Digite 'S' para SIM");
                        String escolhaReverterConjuntodasPartes = scanner.next();

                        if ("S".equals(escolhaReverterConjuntodasPartes.toUpperCase())) {
                            System.out.println("Resultado: ");

                            Conjunto reversaoConjuntoDasPartes = conjuntoDasPartes.reverter(resultadoConjuntoDasPartes);

                            for (int i = 0; i < reversaoConjuntoDasPartes.getElementos().size(); i++) {
                                if (reversaoConjuntoDasPartes.getElementos().size() == 1) {
                                    System.out.print("\t{" + reversaoConjuntoDasPartes.getElementos().get(i).getValor() + "}\n");
                                } else {
                                    if (i == 0) {
                                        System.out.print("\t{" + reversaoConjuntoDasPartes.getElementos().get(i).getValor() + ", ");
                                    } else if (i == reversaoConjuntoDasPartes.getElementos().size() - 1) {
                                        System.out.print(reversaoConjuntoDasPartes.getElementos().get(i).getValor() + "}\n");
                                    } else {
                                        System.out.print(reversaoConjuntoDasPartes.getElementos().get(i).getValor() + ", ");
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Leia o arquivo (opção 1) ou verifique se há no mínimo 1 conjunto nele.");
                    }
                    break;
                case 9:
                    if (!arquivo.getConjuntos().isEmpty() && arquivo.getConjuntos().size() >= 2) {

                        System.out.println("\nSerão utilizados:\n");

                        for (int j = 0; j < 2; j++) {
                            for (int i = 0; i < arquivo.getConjuntos().get(j).getElementos().size(); i++) {
                                if (arquivo.getConjuntos().get(j).getElementos().size() == 1) {
                                    System.out.print("\t" + arquivo.getConjuntos().get(j).getNome() + " = {" + arquivo.getConjuntos().get(0).getElementos().get(i).getValor() + "}");
                                } else {
                                    if (i == 0) {
                                        System.out.print("\t" + arquivo.getConjuntos().get(j).getNome() + " = {" + arquivo.getConjuntos().get(0).getElementos().get(i).getValor() + ", ");
                                    } else if (i == arquivo.getConjuntos().get(j).getElementos().size() - 1) {
                                        System.out.print(arquivo.getConjuntos().get(j).getElementos().get(i).getValor() + "}\n");
                                    } else {
                                        System.out.print(arquivo.getConjuntos().get(j).getElementos().get(i).getValor() + ", ");
                                    }
                                }
                            }
                            System.out.print("\n");
                        }

                        Diferenca diferenca = new Diferenca();
                        Conjunto conjuntoDiferenca = diferenca.get(arquivo.getConjuntos().get(0), arquivo.getConjuntos().get(1));

                        System.out.println("\nConjunto formado: " + arquivo.getConjuntos().get(0).getNome() + " - " + arquivo.getConjuntos().get(1).getNome());

                        if (conjuntoDiferenca.getElementos().isEmpty()) {
                            System.out.print("\n\t{}");
                        } else {
                            for (int i = 0; i < conjuntoDiferenca.getElementos().size(); i++) {
                                if (conjuntoDiferenca.getElementos().size() == 1) {
                                    System.out.print("\n\t{" + conjuntoDiferenca.getElementos().get(i).getValor() + "}\n");
                                } else {
                                    if (i == 0) {
                                        System.out.print("\n\t{" + conjuntoDiferenca.getElementos().get(i).getValor() + ", ");
                                    } else if (i == conjuntoDiferenca.getElementos().size() - 1) {
                                        System.out.print(conjuntoDiferenca.getElementos().get(i).getValor() + "}\n");
                                    } else {
                                        System.out.print(conjuntoDiferenca.getElementos().get(i).getValor() + ", ");
                                    }
                                }
                            }
                        }
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
