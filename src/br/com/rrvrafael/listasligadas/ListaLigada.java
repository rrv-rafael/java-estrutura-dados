package br.com.rrvrafael.listasligadas;

public class ListaLigada<T> {
    private No<T> primeiroNo;
    private No<T> ultimoNo;
    private int tamanho;

    public ListaLigada() {
        primeiroNo = null;
        ultimoNo = null;
        tamanho = 0;
    }

    public void inserir(T elemento) {
        No<T> novoNo = new No<T>(elemento);

        if (estaVazia()) {
            primeiroNo = novoNo;
            ultimoNo = novoNo;
        } else {
            primeiroNo = ultimoNo;
            ultimoNo = novoNo;
        }
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }
}
