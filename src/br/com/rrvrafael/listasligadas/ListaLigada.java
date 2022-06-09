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
            ultimoNo.setProximo(novoNo);
            ultimoNo = novoNo;
        }

        tamanho++;
    }

    public void inserirEm(int posicao, T elemento) {
        if (posicao >= tamanho()) {
            throw new IllegalArgumentException(String.format("A posição [%d] é inválida.", posicao));
        }

        No<T> noAnterior = recuperarNo(posicao - 1);
        No<T> noAtual = recuperarNo(posicao);
        No<T> novoNo = new No<>(elemento);
        noAnterior.setProximo(novoNo);
        novoNo.setProximo(noAtual);
    }

    public T recuperar(int posicao) {
        No<T> no = recuperarNo(posicao);

        if (no != null) {
            return no.getElemento();
        }

        return null;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int tamanho() {
        return tamanho;
    }

    private No<T> recuperarNo(int posicao) {
        if (posicao >= tamanho()) {
            throw new IllegalArgumentException(String.format("A posição [%d] é inválida.", posicao));
        }

        No<T> resultado = null;

        for (int i = 0; i <= posicao; i++) {
            if (i == 0) {
                resultado = primeiroNo;
            } else {
                resultado = resultado.getProximo();
            }
        }

        return resultado;
    }

    @Override
    public String toString() {
        if (estaVazia()) {
            return "Lista []";
        } else {
            No<T> noAtual = primeiroNo;

            StringBuilder sb = new StringBuilder();

            sb.append("Lista [");
            sb.append(noAtual.getElemento() != null ? noAtual.getElemento().toString() : "<NULO>");
            sb.append(",");

            while (noAtual.getProximo() != null) {
                sb.append(noAtual.getProximo().getElemento() != null ? noAtual.getProximo().getElemento().toString() : "<NULO>");
                sb.append(",");
                noAtual = noAtual.getProximo();
            }

            sb.append("]");

            return sb.toString();
        }
    }
}
