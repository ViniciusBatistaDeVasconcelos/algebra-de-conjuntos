package br.com.matematica.models;

import br.com.matematica.models.exceptions.ExceptionObjetoInvalido;
import java.util.ArrayList;
import java.util.List;

public class ProdutoCartesiano {

    private static ProdutoCartesiano instancia = new ProdutoCartesiano();
    private List<Object> conjuntoProduto;

    public static ProdutoCartesiano getInstancia() {
        return instancia;
    }

    public List<Object> get(Conjunto conjunto1, Conjunto conjunto2) {
        conjuntoProduto = new ArrayList();

        for (int i = 0; i < conjunto1.getElementos().size(); i++) {
            for (int j = 0; j < conjunto2.getElementos().size(); j++) {

                List<Elemento> produto = new ArrayList();
                produto.add(conjunto1.getElementos().get(i));
                produto.add(conjunto2.getElementos().get(j));
                conjuntoProduto.add(produto);

                System.out.println(conjunto1.getElementos().get(i).getValor() + " , " + conjunto2.getElementos().get(j).getValor());
            }
        }

        return conjuntoProduto;
    }

    public List<Object> get(Conjunto conjunto1, List<Object> conjunto2) {
        conjuntoProduto = new ArrayList();

        for (int i = 0; i < conjunto1.getElementos().size(); i++) {
            for (int j = 0; j < conjunto2.size(); j++) {
                List<Object> produto = new ArrayList();
                produto.add(conjunto1.getElementos().get(i));
                produto.add(conjunto2.get(j));
                conjuntoProduto.add(produto);
            }
        }
        return conjuntoProduto;
    }

    public List<Object> get(List<Object> conjunto1, Conjunto conjunto2) {
        conjuntoProduto = new ArrayList();
        for (int i = 0; i < conjunto1.size(); i++) {
            for (int j = 0; j < conjunto2.getElementos().size(); j++) {
                List<Object> produto = new ArrayList();
                produto.add(conjunto1.get(i));
                produto.add(conjunto2.getElementos().get(j));
                conjuntoProduto.add(produto);
            }
        }
        return conjuntoProduto;
    }

    public List<Object> get(List<Object> conjunto1, List<Object> conjunto2) {
        conjuntoProduto = new ArrayList();

        for (int i = 0; i < conjunto1.size(); i++) {
            for (int j = 0; j < conjunto2.size(); j++) {
                List<Object> produto = new ArrayList();
                produto.add(conjunto1.get(i));
                produto.add(conjunto2.get(j));
                conjuntoProduto.add(produto);
            }
        }
        return conjuntoProduto;
    }

    public void mostrarProdutoCartesiano() throws ExceptionObjetoInvalido {
        for (int i = 0; i < conjuntoProduto.size(); i++) {

            if (conjuntoProduto.get(i).getClass() == Elemento.class) {

                Elemento e = (Elemento) conjuntoProduto.get(i);
                if (conjuntoProduto.size() - 1 == i) {
                    System.out.print(e.getValor());
                } else {
                    System.out.print(e.getValor() + ", ");
                }
            } else if (conjuntoProduto.get(i) instanceof List) {
                System.out.print("(");
                
                mostrarProdutoCartesiano((List<Object>) conjuntoProduto.get(i));
                
                if (conjuntoProduto.size() - 1 == i) {
                    System.out.print(")");
                } else {
                    System.out.print("), ");
                }
            } else {
                throw new ExceptionObjetoInvalido("001 - A lista possui algum objeto que não pode ser definido.");
            }
        }
    }

    private void mostrarProdutoCartesiano(List<Object> conjuntoProduto) throws ExceptionObjetoInvalido {
        for (int i = 0; i < conjuntoProduto.size(); i++) {

            if (conjuntoProduto.get(i).getClass() == Elemento.class) {

                Elemento e = (Elemento) conjuntoProduto.get(i);
                if (conjuntoProduto.size() - 1 == i) {
                    System.out.print(e.getValor());
                } else {
                    System.out.print(e.getValor() + ", ");
                }

            } else if (conjuntoProduto.get(i) instanceof List) {
                System.out.print("(");
                
                mostrarProdutoCartesiano((List<Object>) conjuntoProduto.get(i));
                
                if (conjuntoProduto.size() - 1 == i) {
                    System.out.print(")");
                } else {
                    System.out.print("), ");
                }

            } else {
                throw new ExceptionObjetoInvalido("001 - A lista possui algum objeto que não pode ser definido.");
            }
        }
    }
}
