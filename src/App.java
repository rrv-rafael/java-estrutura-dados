import java.util.Scanner;

import br.com.rrvrafael.listasligadas.ListaLigada;
import br.com.rrvrafael.modelos.Pessoa;
import br.com.rrvrafael.vetores.Vetor;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int opcao;

        System.out.println("*****Menu*****");
        System.out.println("1 - Gerenciamento de memória.");
        System.out.println("2 - Vetores.");
        System.out.println("3 - Lista ligada.");
        System.out.println("Conforme as opções cima, informe a desejada:");
        opcao = scan.nextInt();

        switch (opcao) {
            case 1 -> gerenciamentoMemoria();
            case 2 -> declararVetor();
            case 3 -> criarListaLigada();
            default -> System.out.println("Opção inválida!");
        }

        scan.close();
    }

    private static void criarListaLigada() {
        ListaLigada<Pessoa> listaPessoas = new ListaLigada<>();

        listaPessoas.inserir(new Pessoa(1, "Rafael Rodrigues Vitor"));
        listaPessoas.inserir(new Pessoa(2, "Renan Craldino Vitor"));
        listaPessoas.inserir(new Pessoa(3, "José Gilson Vitor Junior"));
        listaPessoas.inserirEm(1, new Pessoa(4, "Marlene Aparecida Vitor"));
        listaPessoas.inserirPrimeiro(new Pessoa(5, "José Gilson Vitor"));
        listaPessoas.inserirUltimo(new Pessoa(6, "João Izidório de Oliveira"));

        System.out.println(listaPessoas);

        Pessoa pessoa = listaPessoas.recuperar(1);
        Pessoa pessoaForaLista = new Pessoa(100, "Maria Oliveira");
        System.out.println(listaPessoas.contem(pessoa));
        System.out.println(listaPessoas.contem(pessoaForaLista));
        System.out.println(listaPessoas.indice(pessoa));
        System.out.println(listaPessoas.indice(pessoaForaLista));

        listaPessoas.remover(pessoa);

        System.out.println(listaPessoas);

        listaPessoas.remover(2);

        System.out.println(listaPessoas);

        System.out.println("\nLista de pessoas:");

        for (int i = 0; i < listaPessoas.tamanho(); i++) {
            System.out.println(listaPessoas.recuperar(i).toString());
        }
    }

    private static void gerenciamentoMemoria() {
        int valor = 3;
        System.out.println("valor: " + valor);

        int valor2 = valor;
        System.out.println("valor2: " + valor2);
        valor2 = 2;

        System.out.println("valor: " + valor);
        System.out.println("valor2: " + valor2);
        System.out.println(valor == valor2);

        Pessoa p1 = new Pessoa(1, "Rafael Rodrigues");

        // Pessoa p2 = new Pessoa(1, "Rafael Rodrigues");
        Pessoa p2 = p1;

        System.out.println(p1);
        System.out.println(p2);

        p2.setNome("Rafael Modificado");

        System.out.println(p1);
        System.out.println(p2);

        System.out.println(p1.equals(p2));
    }

    private static void declararVetor() {
        Vetor<Pessoa> pessoas = new Vetor<>();

        try {
            pessoas.inserir(new Pessoa(1, "Rafael Rodrigues Vitor"));
            pessoas.inserir(new Pessoa(2, "Renan Craldino Vitor"));
            pessoas.inserir(new Pessoa(3, "José Gilson Vitor Junior"));
            pessoas.inserir(new Pessoa(4, "Marlene Aparecida Vitor"));
            pessoas.inserirEm(1, new Pessoa(5, "José Gilson Vitor"));

            System.out.println(pessoas);

            System.out.println("Lista de pessoas:");

            for (int i = 0; i < pessoas.tamanho(); i++) {
                System.out.println(pessoas.recuperar(i).getNome());
            }

            Pessoa pessoa = pessoas.recuperar(1);
            Pessoa pessoa2 = new Pessoa(10, "Não existe");

            System.out.println(pessoas.contem(pessoa));
            System.out.println(pessoas.contem(pessoa2));
            System.out.println(pessoas.indice(pessoa));
            System.out.println(pessoas.indice(pessoa2));

            pessoas.remover(0);

            System.out.println("\nVetor após remoção com método recebendo posição:");

            for (int i = 0; i < pessoas.tamanho(); i++) {
                System.out.println(pessoas.recuperar(i).getNome());
            }

            pessoas.remover(pessoa);

            System.out.println("\nVetor após remoção com método recebendo pessoa:");

            for (int i = 0; i < pessoas.tamanho(); i++) {
                System.out.println(pessoas.recuperar(i).getNome());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
