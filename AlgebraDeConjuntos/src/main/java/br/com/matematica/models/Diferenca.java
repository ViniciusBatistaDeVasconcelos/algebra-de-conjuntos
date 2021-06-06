package br.com.matematica.models;

public class Diferenca {

    public Conjunto get(Conjunto conjunto1, Conjunto conjunto2) {
        Conjunto conjuntoDiferenca = new Conjunto();

        for (int i = 0; i < conjunto1.getElementos().size(); i++) {
            if (!Pertinencia.getInstancia().pertence(conjunto1.getElementos().get(i), conjunto2)) {
                conjuntoDiferenca.adicionarElemento(conjunto1.getElementos().get(i));
            }
        }
        return conjuntoDiferenca;
    }
}
