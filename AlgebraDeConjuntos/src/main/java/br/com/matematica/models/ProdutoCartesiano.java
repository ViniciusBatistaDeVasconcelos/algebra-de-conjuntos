package br.com.matematica.models;

import br.com.matematica.models.exceptions.ExceptionObjetoInvalido;
import java.util.ArrayList;
import java.util.List;

public class ProdutoCartesiano {

   
    private List<Conjunto> listaConjuntos;

    public List<Object> get(Conjunto conjunto1, Conjunto conjunto2) {
        List<Object> conjuntoProduto = new ArrayList();
        for (int i = 0; i < conjunto1.getElementos().size(); i++) {
            for (int j = 0; j < conjunto2.getElementos().size(); j++) {
                List<Elemento> produto = new ArrayList();
                produto.add(conjunto1.getElementos().get(i));
                produto.add(conjunto2.getElementos().get(j));
                conjuntoProduto.add(produto);
            }
        }
        return conjuntoProduto;
    }

    public List<Object> get(Conjunto conjunto1, List<Object> conjunto2) {
        List<Object>conjuntoProduto = new ArrayList();
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
        List<Object>conjuntoProduto = new ArrayList();
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
        List<Object>conjuntoProduto = new ArrayList();
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

    public List<Conjunto> reverterParesOrdenados(List<Object> conjuntoProduto) throws ExceptionObjetoInvalido {
        listaConjuntos = new ArrayList<>();
        reverter(conjuntoProduto);
        return listaConjuntos;
    }

    private List<Conjunto> reverter(List<Object> conjuntoProduto) throws ExceptionObjetoInvalido {

        Conjunto conjunto1 = new Conjunto();
        Conjunto conjunto2 = new Conjunto();
        List<Object> c1 = new ArrayList<>();
        List<Object> c2 = new ArrayList<>();

        for (int i = 0; i < conjuntoProduto.size(); i++) {
            if (conjuntoProduto.get(i) instanceof List) {
                List<Object> conjunto = (ArrayList) conjuntoProduto.get(i);
                if (conjunto.get(0).getClass() == Elemento.class) {
                    Elemento e = (Elemento) conjunto.get(0);
                    conjunto1.adicionarElemento(e);
                } else if (conjunto.get(0) instanceof List) {
                    c1.add(conjunto.get(0));
                }
                if (conjunto.get(1).getClass() == Elemento.class) {
                    Elemento e = (Elemento) conjunto.get(1);
                    conjunto2.adicionarElemento(e);
                } else if (conjunto.get(1) instanceof List) {
                    c2.add(conjunto.get(1));
                }
            } else {
                throw new ExceptionObjetoInvalido("002 - A lista possui algum objeto que não pode ser definido.");
            }
        }

        if (c1.isEmpty()) {
            listaConjuntos.add(conjunto1);
        }
        if (c2.isEmpty()) {
            listaConjuntos.add(conjunto2);
        }
        if (!c1.isEmpty()) {
            reverter((List<Object>) c1);
        }
        if (!c2.isEmpty()) {
            reverter((List<Object>) c2);
        }

        return listaConjuntos;
    }

    public void imprimir(List<Object> conjuntoProduto) throws ExceptionObjetoInvalido {
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
                imprimir((List<Object>) conjuntoProduto.get(i));
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
