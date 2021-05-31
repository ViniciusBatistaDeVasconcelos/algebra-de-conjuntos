package br.com.matematica.models;

public class Contido {

    private static Contido instancia = new Contido();

    public static Contido getInstancia() {
        return instancia;
    }

    public boolean contidoIgual(Conjunto conjunto1, Conjunto conjunto2) {

        if (conjunto1.getElementos().size() > conjunto2.getElementos().size()) {
            return false;
        }

        int contador = 0;

        for (int i = 0; i < conjunto1.getElementos().size(); i++) {
            for (int j = 0; j < conjunto2.getElementos().size(); j++) {
                if (conjunto1.getElementos().get(i).getValor() == conjunto2.getElementos().get(j).getValor()) {
                    ++contador;
                }
            }
        }

        if (contador == conjunto1.getElementos().size()) {
            return true;
        }

        return false;
    }

    public boolean contidoPropriamente(Conjunto conjunto1, Conjunto conjunto2) {
        if (conjunto1.getElementos().size() == conjunto2.getElementos().size()) {
            return false;
        }
        return this.contidoIgual(conjunto1, conjunto2);
    }
}