package br.com.rrvrafael.espalhamento;

import br.com.rrvrafael.listasligadas.ListaLigada;

public class TabelaEspalhamento<T> {
    private ListaLigada<ListaLigada<T>> elementos;
    private int numeroCategorias = 16;
    private int tamanho;
    
    public TabelaEspalhamento() {
        elementos = new ListaLigada<ListaLigada<T>>();

        for (int i = 0; i < numeroCategorias; i++) {
            elementos.inserir(new ListaLigada<>());
        }

        tamanho = 0;
    }

    public boolean inserir(T elemento) {
        if (elemento == null || contem(elemento)) {
            return false;
        }

        int numeroEspalhamento = gerarNumeroEspalhamento(elemento);
        ListaLigada<T> categoria = elementos.recuperar(numeroEspalhamento);
        
        categoria.inserir(elemento);

        tamanho++;

        return true;
    }

    public void remover(T elemento) {
        int numeroEspalhamento = gerarNumeroEspalhamento(elemento);
        ListaLigada<T> categoria = elementos.recuperar(numeroEspalhamento);
        categoria.remover(elemento);

        tamanho--;
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean contem(T elemento) {
        int numeroEspalhamento = gerarNumeroEspalhamento(elemento);
        ListaLigada<T> categoria = elementos.recuperar(numeroEspalhamento);

        return categoria.contem(elemento);
    }
    private int gerarNumeroEspalhamento(T elemento) {
        return Math.abs(elemento.hashCode() % numeroCategorias);
    }

    @Override
    public String toString() {
        return "TabelaEspalhamento [elementos=" + elementos + "]";
    }
}
