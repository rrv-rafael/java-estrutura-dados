package br.com.rrvrafael.arvorebinaria;

import br.com.rrvrafael.modelos.Pessoa;

public class NoArvorePessoa extends NoArvore<Pessoa> {

    public NoArvorePessoa(Pessoa valor) {
        super(valor);
    }

    @Override
    public int peso() {
        return valor.getId();
    }   
}
