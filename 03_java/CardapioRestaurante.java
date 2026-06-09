import java.util.Scanner;

public class CardapioRestaurante {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("     RESTAURANTE SABOR CASEIRO");
        System.out.println("=================================");
        System.out.println("1 - X-Burguer .......... R$ 18,00");
        System.out.println("2 - Pizza .............. R$ 35,00");
        System.out.println("3 - Suco Natural ....... R$ 8,00");
        System.out.println("4 - Café ............... R$ 5,00");
        System.out.println("5 - Salada ............. R$ 12,00");
        System.out.println("6 - Cachorro-Quente .... R$ 15,00");
        System.out.println("7 - Refrigerante ....... R$ 7,00");
        System.out.println("8 - Batata Frita ....... R$ 14,00");
        System.out.println("9 - Sorvete ............ R$ 10,00");
        System.out.println("10 - Lasanha ........... R$ 28,00");
        System.out.println("=================================");

        System.out.print("Escolha uma opção: ");
        int opcao = entrada.nextInt();

        if (opcao == 1) {
            System.out.println("Item escolhido: X-Burguer");
            System.out.println("Valor: R$ 18,00");
        } else if (opcao == 2) {
            System.out.println("Item escolhido: Pizza");
            System.out.println("Valor: R$ 35,00");
        } else if (opcao == 3) {
            System.out.println("Item escolhido: Suco Natural");
            System.out.println("Valor: R$ 8,00");
        } else if (opcao == 4) {
            System.out.println("Item escolhido: Café");
            System.out.println("Valor: R$ 5,00");
        } else if (opcao == 5) {
            System.out.println("Item escolhido: Salada");
            System.out.println("Valor: R$ 12,00");
        } else if (opcao == 6) {
            System.out.println("Item escolhido: Cachorro-Quente");
            System.out.println("Valor: R$ 15,00");
        } else if (opcao == 7) {
            System.out.println("Item escolhido: Refrigerante");
            System.out.println("Valor: R$ 7,00");
        } else if (opcao == 8) {
            System.out.println("Item escolhido: Batata Frita");
            System.out.println("Valor: R$ 14,00");
        } else if (opcao == 9) {
            System.out.println("Item escolhido: Sorvete");
            System.out.println("Valor: R$ 10,00");
        } else if (opcao == 10) {
            System.out.println("Item escolhido: Lasanha");
            System.out.println("Valor: R$ 28,00");
        } else {
            System.out.println("Opção inválida! Escolha um número de 1 a 10.");
        }

        entrada.close();
    }
}