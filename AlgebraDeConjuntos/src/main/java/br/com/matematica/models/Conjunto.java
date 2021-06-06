package br.com.matematica.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Conjunto {

    private String nome;
    private List<Elemento> elementos;

    public Conjunto(String nome) {
        this.nome = nome;
        this.elementos = new ArrayList<>();
    }

    public Conjunto() {
        this.elementos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(List<Elemento> elementos) {

        Set<Elemento> removerDuplicados = new HashSet<>();
        for (Elemento e : elementos) {
            removerDuplicados.add(e);
        }
        for (Elemento e : removerDuplicados) {
            this.elementos.add(e);
        }

    }

    public void adicionarElemento(Elemento elemento) {
        if (!this.elementos.contains(elemento)) {
            this.elementos.add(elemento);
        }
    }

    public void removerElemento(Elemento elemento) {
        this.elementos.remove(elemento);
    }
}
