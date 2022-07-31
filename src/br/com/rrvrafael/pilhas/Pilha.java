package br.com.rrvrafael.pilhas;

import br.com.rrvrafael.listasligadas.ListaDuplamenteLigada;

public class Pilha<T> {
    private ListaDuplamenteLigada<T> elementos;

    public boolean estaVazia() {
        return elementos.estaVazia();
    }

    public void empilhar(T elemento) {
        elementos.inserir(elemento);
    }

    public T desempilhar() {
        if (estaVazia()) {
            return null;
        } else {
            T elemento = elementos.recuperar(elementos.tamanho() - 1);
            elementos.remover(elementos.tamanho() - 1);

            return elemento;
        }
    }
}
