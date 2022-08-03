package br.com.rrvrafael.conjuntos;

import br.com.rrvrafael.espalhamento.TabelaEspalhamento;

public class Conjunto<T> {
    private TabelaEspalhamento<T> elementos;

    public Conjunto() {
        this.elementos = new TabelaEspalhamento<>();
    }

    public boolean inserir(T elemento) {        
        return elementos.inserir(elemento);
    }

    public boolean estaVazio() {
        return elementos.tamanho() == 0;
    }

    public int tamanho() {
        return elementos.tamanho();
    }

    public boolean contem(T elemento) {
        return elementos.contem(elemento);
    }

    public void remover(T elemento) {
        elementos.remover(elemento);
    }

    // private boolean contemOtimizado(T elemento) {
    //     for (int i = 0; i < elementos.tamanho(); i++) {
    //         T e = elementos.recuperar(i);
    //         if (e.hashCode() == elemento.hashCode()) {
    //             return true;
    //         }
    //     }

    //     return false;
    // }

    @Override
    public String toString() {
        return "Conjunto [elementos=" + elementos + "]";
    }
}
