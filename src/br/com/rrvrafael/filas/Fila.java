package br.com.rrvrafael.filas;

import br.com.rrvrafael.listasligadas.ListaLigada;

public class Fila<T> {
    private ListaLigada<T> elementos;

    public Fila() {
        this.elementos = new ListaLigada<>();
    }

    public void enfileirar(T elemento) {
        elementos.inserir(elemento);
    }

    public T desenfileirar() {
        if (estaVazia()) {
            return null;
        }

        T elemento = elementos.recuperar(0);

        elementos.remover(0);

        return elemento;
    }

    public boolean estaVazia() {
        return elementos.estaVazia();
    }

    @Override
    public String toString() {
        return "Fila:\n" + elementos;
    }
}
