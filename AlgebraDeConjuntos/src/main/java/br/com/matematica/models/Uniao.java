package br.com.matematica.models;

public class Uniao {

    private static Uniao instancia = new Uniao();

    public static Uniao getInstancia() {
        return instancia;
    }

    public Conjunto get(Conjunto conjunto1, Conjunto conjunto2) {

        Conjunto uniao = new Conjunto("U");

        for (int i = 0; i < conjunto1.getElementos().size(); i++) {
            uniao.adicionarElemento(conjunto1.getElementos().get(i));
        }

        for (int i = 0; i < conjunto2.getElementos().size(); i++) {
            uniao.adicionarElemento(conjunto2.getElementos().get(i));
        }

        return uniao;
    }
}
