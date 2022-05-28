package br.com.rrvrafael.vetores;

import java.util.Arrays;

public class Vetor<T> {
    private Object[] elementos;
    private int posicao;

    public Vetor(int capacidade) {
        this.elementos = new Object[capacidade];
        posicao = 0;
    }

    public Vetor() {
        this.elementos = new Object[3];
        posicao = 0;
    }

    public void inserir(T elemento) {
        if (posicao >= elementos.length) {
            elementos = Arrays.copyOf(elementos, elementos.length + 1);
        }
        elementos[posicao] = elemento;
        posicao++;
    }

    public void inserirEm(int posicao, T elemento) {
        if (posicao > this.elementos.length) {
            throw new IllegalArgumentException(String.format("A posição [%d] é inválida.", posicao));
        }

        if (elementos[posicao] != null) {
            Object[] arrayFinal = Arrays.copyOfRange(elementos, posicao, elementos.length);
            Object[] arrayInicio = new Object[posicao + 1];

            System.arraycopy(elementos, 0, arrayInicio, 0, posicao);
            arrayInicio[arrayInicio.length - 1] = elemento;

            int novoTamanho = arrayInicio.length + arrayFinal.length;

            elementos = new Object[novoTamanho];

            System.arraycopy(arrayInicio, 0, elementos, 0, arrayInicio.length);
            System.arraycopy(arrayFinal, 0, elementos, arrayInicio.length, arrayFinal.length);
            posicao++;
        } else {
            elementos[posicao] = elemento;
        }
    }

    @SuppressWarnings("unchecked")
    public T recuperar(int posicao) {
        if (posicao >= tamanho()) {
            throw new IllegalArgumentException(String.format("A posição [%d] é inválida.", posicao));
        }

        return (T)elementos[posicao];
    }

    public int tamanho() {
        return elementos.length;
    }

    public boolean contem(T elemento) {
        for (Object element : elementos) {
            if (element != null && element.equals(elemento)) {
                return true;
            }
        }

        return false;
    }

    public int indice(T elemento) {
        for (int i = 0; i < tamanho(); i++) {
            T element = recuperar(i);
            
            if (element != null && element.equals(elemento)) {
                return i;
            }
        }

        return -1;
    }

    public void remover(int posicao) {
        if (posicao >= tamanho()) {
            throw new IllegalArgumentException(String.format("A posição [%d] é inválida.", posicao));
        }

        Object[] arrayFinal = Arrays.copyOfRange(elementos, posicao + 1, tamanho());
        Object[] arrayInicio = Arrays.copyOfRange(elementos, 0, posicao);

        elementos = new Object[tamanho() - 1];
        posicao--;

        System.arraycopy(arrayInicio, 0, elementos, 0, arrayInicio.length);
        System.arraycopy(arrayFinal, 0, elementos, arrayInicio.length, arrayFinal.length);
    }

    public void remover(T elemento) {
        int posicao = indice(elemento);

        if (posicao >= tamanho() || posicao == -1) {
            throw new IllegalArgumentException(String.format("A posição [%d] é inválida.", posicao));
        }

        remover(posicao);
    }

    @Override
    public String toString() {
        return "Vetor [elementos=" + Arrays.toString(elementos) + ", posicao=" + posicao + "]";
    }
}
