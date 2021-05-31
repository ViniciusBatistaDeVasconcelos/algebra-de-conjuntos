package br.com.matematica.models;

public class Intercessao {

    private static Intercessao instancia = new Intercessao();

    public static Intercessao getInstancia() {
        return instancia;
    }

    public Conjunto get(Conjunto conjunto1, Conjunto conjunto2) {

        Conjunto intercessao = new Conjunto("I");

        for (int i = 0; i < conjunto1.getElementos().size(); i++) {
            if (Pertinencia.getInstancia().pertence(conjunto1.getElementos().get(i), conjunto2)) {
                if (Pertinencia.getInstancia().pertence(conjunto2.getElementos().get(i), conjunto1)) {
                    System.out.println(conjunto1.getElementos().get(i).getValor());
                }
            }
        }

        return intercessao;
    }
}
