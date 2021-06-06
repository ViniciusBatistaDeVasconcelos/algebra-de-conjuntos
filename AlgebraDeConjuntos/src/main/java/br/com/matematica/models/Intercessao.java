package br.com.matematica.models;

public class Intercessao {

    private static Intercessao instancia = new Intercessao();

    public static Intercessao getInstancia() {
        return instancia;
    }

    public Conjunto get(Conjunto conjunto1, Conjunto conjunto2) {

        Conjunto intercessao = new Conjunto();

        for (int i = 0; i < conjunto1.getElementos().size(); i++) {
            if (Pertinencia.getInstancia().pertence(conjunto1.getElementos().get(i), conjunto2)) {
                intercessao.adicionarElemento(conjunto1.getElementos().get(i));
            }
        }

        return intercessao;
    }
}
