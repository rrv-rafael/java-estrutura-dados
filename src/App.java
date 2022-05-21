import java.util.Scanner;

import br.com.rrvrafael.modelos.Pessoa;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int opcao;

        System.out.println("*****Menu*****");
        System.out.println("1 - Gerenciamento de memória.");
        System.out.println("Conforme as opções cima, informe a desejada:");
        opcao = scan.nextInt();

        switch (opcao) {
            case 1 -> gerenciamentoMemoria();
            default -> System.out.println("Opção inválida!");
        }

        scan.close();
    }

    public static void gerenciamentoMemoria() {
        int valor = 3;
        System.out.println("valor: " + valor);

        int valor2 = valor;
        System.out.println("valor2: " + valor2);
        valor2 = 2;

        System.out.println("valor: " + valor);
        System.out.println("valor2: " + valor2);
        System.out.println(valor == valor2);

        Pessoa p1 = new Pessoa(1, "Rafael Rodrigues");

        Pessoa p2 = p1;

        System.out.println(p1);
        System.out.println(p2);

        p2.setNome("Rafael Modificado");

        System.out.println(p1);
        System.out.println(p2);
    }
}
