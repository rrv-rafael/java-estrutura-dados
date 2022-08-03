package br.com.rrvrafael.arvorebinaria;

public abstract class NoArvore<T> {
    protected T valor;
    private NoArvore<T> noEsquerdo;
    private NoArvore<T> noDireito;

    public NoArvore(T valor) {
        this.valor = valor;
        noEsquerdo = null;
        noDireito = null;
    }

    public T getValor() {
        return valor;
    }

    public NoArvore<T> getNoEsquerdo() {
        return noEsquerdo;
    }

    public void setNoEsquerdo(NoArvore<T> noEsquerdo) {
        this.noEsquerdo = noEsquerdo;
    }

    public NoArvore<T> getNoDireito() {
        return noDireito;
    }
    
    public void setNoDireito(NoArvore<T> noDireito) {
        this.noDireito = noDireito;
    }

    public abstract int peso();

    @Override
    public String toString() {
        return (noEsquerdo == null ? "[(X)]" : "[(" + noEsquerdo.toString() + ")]") + "[("+ valor.toString() + ")]" + 
        (noDireito == null ? "[(X)]" : "[(" + noDireito.toString() + ")]");

    }
}
