package br.com.rrvrafael.conjuntos;

import br.com.rrvrafael.listasligadas.ListaLigada;

public class Conjunto<T> {
    private ListaLigada<T> elementos;

    public Conjunto() {
        this.elementos = new ListaLigada<>();
    }

    public boolean inserir(T elemento) {
        if (elemento != null && !contemOtimizado(elemento)) {
            elementos.inserir(elemento);

            return true;
        }
        
        return false;
    }

    public boolean inserirEm(int posicao, T elemento) {
        if (elemento != null && !contemOtimizado(elemento)) {
            elementos.inserirEm(posicao, elemento);

            return true;
        }

        return false;
    }

    public T recuperar(int posicao) {
        return elementos.recuperar(posicao);
    }

    public boolean estaVazio() {
        return elementos.estaVazia();
    }

    public int tamanho() {
        return elementos.tamanho();
    }

    public boolean contem(T elemento) {
        return elementos.contem(elemento);
    }

    public int indice(T elemento) {
        return elementos.indice(elemento);
    }

    public void remover(int posicao) {
        elementos.remover(posicao);
    }

    public void remover(T elemento) {
        elementos.remover(elemento);
    }

    private boolean contemOtimizado(T elemento) {
        for (int i = 0; i < elementos.tamanho(); i++) {
            T e = elementos.recuperar(i);
            if (e.hashCode() == elemento.hashCode()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "Conjunto [elementos=" + elementos + "]";
    }
}
