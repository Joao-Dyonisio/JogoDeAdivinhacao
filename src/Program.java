import java.util.Random;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        int numeroSecreto = random.nextInt(101);
        int tentativas = 5;
        char opcao;

        System.out.println("===================================================");
        System.out.println("Bem-vindo ao jogo de adivinhar o número secreto!");
        System.out.println("Tente adivinhar o número entre 0 a 100.");
        System.out.println("===================================================");

        System.out.println("Você tem " + tentativas + " tentativas.");

        while (true) {
            System.out.println(("Vamos começar o jogo? (s/n): "));
            String entrada = sc.nextLine().trim().toLowerCase();

            if (entrada.equals("s") || entrada.equals("n")) {
                opcao = entrada.charAt(0);
                break;
            } else {
                System.out.println("Opção inválida. Digite 's' para sim ou 'n' para não.");
            }

            for (int i = 1; i <= tentativas; i ++) {
                System.out.print("Tentativa " + i + " | Digite o número: ");

                try {
                    int escolha = Integer.parseInt(sc.nextLine());

                    if (escolha < 0 || escolha > 100) {
                        System.out.println("Por favor, digite um número entre 0 e 100.");
                    }
                    if (escolha == numeroSecreto) {
                        System.out.println("Parabéns! Você acertou o número secreto "
                                + numeroSecreto + " em " + tentativas + " tentativas!");
                        sc.close();
                        return;
                    } else if (escolha < numeroSecreto) {
                        System.out.println("Número é maior!");
                    } else {
                        System.out.println("Número é menor!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Número Inválido. Digite um número INTEIRO.");
                }
            }
        }

        System.out.println("=======================================================");
        System.out.println("FIM DO JOGO! Número secreto era " + numeroSecreto);
        System.out.println("=======================================================");
        sc.close();
    }
}
