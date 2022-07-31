package br.com.rrvrafael.listasligadas;

public class ListaDuplamenteLigada<T> {
    private No<T> primeiroNo;
    private No<T> ultimoNo;
    private int tamanho;

    public ListaDuplamenteLigada() {
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
            novoNo.setAnterior(ultimoNo);
            ultimoNo = novoNo;
        }

        tamanho++;
    }

    public void inserirEm(int posicao, T elemento) {
        if (posicao >= tamanho()) {
            throw new IllegalArgumentException(String.format("A posição [%d] é inválida.", posicao));
        }

        if (posicao == 0) {
            No<T> novoNo = new No<T>(elemento);
            novoNo.setProximo(primeiroNo);
            primeiroNo.setAnterior(novoNo);
            primeiroNo = novoNo;
        } else if (posicao == tamanho() - 1) {
            No<T> novoNo = new No<T>(elemento);
            ultimoNo.setProximo(novoNo);
            novoNo.setAnterior(ultimoNo);
            ultimoNo = novoNo;
        } else {
            No<T> noAnterior = recuperarNo(posicao - 1);
            No<T> noAtual = recuperarNo(posicao);
            No<T> novoNo = new No<>(elemento);
            noAnterior.setProximo(novoNo);
            novoNo.setProximo(noAtual);
            novoNo.setAnterior(noAnterior);
        }

        tamanho++;
    }

    public void inserirPrimeiro(T elemento) {
        inserirEm(0, elemento);
    }

    public void inserirUltimo(T elemento) {
        inserirEm(tamanho - 1, elemento);
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

    public boolean contem(T elemento) {
        for (int i = 0; i < tamanho(); i++) {
            No<T> noAtual = recuperarNo(i);

            if (noAtual.getElemento() != null && noAtual.getElemento().equals(elemento)) {
                return true;
            }
        }

        return false;
    }

    public int indice(T elemento) {
        for (int i = 0; i < tamanho(); i++) {
            No<T> noAtual = recuperarNo(i);

            if (noAtual.getElemento() != null && noAtual.getElemento().equals(elemento)) {
                return i;
            }
        }

        return -1;
    }

    public void remover(int posicao) {
        if (posicao >= tamanho()) {
            throw new IllegalArgumentException(String.format("A posição [%d] é inválida.", posicao));
        }
        
        if (posicao == 0) {
            No<T> proximoNo = primeiroNo.getProximo();
            primeiroNo.setProximo(null);
            proximoNo.setAnterior(null);
            primeiroNo = proximoNo;
        } else if (posicao == tamanho() - 1) {
            No<T> penultimoNo = ultimoNo.getAnterior();
            penultimoNo.setProximo(null);
            ultimoNo.setAnterior(null);
            ultimoNo = penultimoNo;
        } else {
            No<T> noAtual = recuperarNo(posicao);
            No<T> noAnterior = noAtual.getAnterior();
            No<T> proximoNo = noAtual.getProximo();
    
            noAnterior.setProximo(proximoNo);
            proximoNo.setAnterior(noAnterior);
            noAtual.setProximo(null);
            noAtual.setAnterior(null);
        }

        tamanho--;
    }

    public void remover(T elemento) {
        int indice = indice(elemento);

        if (indice == -1) {
            throw new IllegalArgumentException("Elemento inválido - " + elemento.toString());
        }

        remover(indice);
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
