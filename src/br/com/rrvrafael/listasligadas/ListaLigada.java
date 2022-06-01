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

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int tamanho() {
        return tamanho;
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
