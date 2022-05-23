import java.util.Scanner;

import br.com.rrvrafael.modelos.Pessoa;
import br.com.rrvrafael.vetores.Vetor;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int opcao;

        System.out.println("*****Menu*****");
        System.out.println("1 - Gerenciamento de memória.");
        System.out.println("2 - Vetores.");
        System.out.println("Conforme as opções cima, informe a desejada:");
        opcao = scan.nextInt();

        switch (opcao) {
            case 1 -> gerenciamentoMemoria();
            case 2 -> declararVetor();
            default -> System.out.println("Opção inválida!");
        }

        scan.close();
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
    }
}
