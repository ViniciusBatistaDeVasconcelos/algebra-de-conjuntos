package br.com.matematica.models;

public class Pertinencia {

    private static Pertinencia instancia = new Pertinencia();

    public static Pertinencia getInstancia() {
        return instancia;
    }
    public boolean pertence(Elemento elemento, Conjunto conjunto) {
        for (int i = 0; i < conjunto.getElementos().size(); i++) {
            if (elemento.getValor() == conjunto.getElementos().get(i).getValor()) {
                return true;
            }
        }
        return false;
    }
}
