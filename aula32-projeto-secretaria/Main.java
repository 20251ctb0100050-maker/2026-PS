/*
 * Disciplina: 2020-PS
 * Estudante: [Gustavo ferreira Koller Da Silva]
 * Data: 2020.08.11
 * Projeto: aula32-projeto-secretaria
 * Arquivo: Main.java
 */

// import: ArrayList = a lista que cresce (o gaveteiro).
// Scanner: a leitura do teclado.
import java.util.ArrayList;
import java.util.Scanner;

/*
 * O BALCÃO DA SECRETARIA: não guarda ficha nenhuma, ele atende.
 * Mostra o menu, lê a escolha e chama o método que resolve.
 */
public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // O GAVETEIRO TIPADO: o <Aluno> diz que só entra ficha de aluno aqui.
        ArrayList<Aluno> lista = new ArrayList<Aluno>();

        // while (true) = repete para sempre. A única saída é o break da opção 0.
        while (true) {
            System.out.println("=====================================");
            System.out.println("       SECRETARIA DO SEU NOME");
            System.out.println("=====================================");
            System.out.println("[1] Cadastrar aluno");
            System.out.println("[2] Listar alunos");
            System.out.println("[0] Sair");
            System.out.println("Sua escolha:");
            System.out.println("Nome: Ana Souza");
            System.out.println("Matricula: 2026001");
            System.out.println("Curso: Informatica");
            System.out.println("Ficha de Ana Souza arquivada!");
            String opcao = teclado.nextLine().trim();  // trim: tira espaços das pontas

            // Texto que parece "0", "1", "2", ...
            if (opcao.equals("0")) {
                System.out.println("Secretaria fechada. Até a próxima!");
                break;
            } else if (opcao.equals("1")) {
                cadastrar(lista, teclado);
            } else if (opcao.equals("2")) {
                listar(lista);
            } else {
                System.out.println("Opção inválida! Vale 0, 1 ou 2.");
            }
        }
    }

    // Le os dados no balcão, carimba a ficha e guarda no gaveteiro.
    static void cadastrar(ArrayList<Aluno> lista, Scanner teclado) {
        System.out.print("Nome: ");
        String nome = teclado.nextLine().trim();

        // LACUNA GUIADA: leia matrícula e curso desse jeito.
        // crie a ficha com new Aluno(...) e guarde com lista.add(...)
        // e avise "Ficha de " + nome + " guardada!"

    }

    // Percorre o gaveteiro e imprime ficha por ficha (padrão da Aula 20).
    static void listar(ArrayList<Aluno> lista) {
        // LACUNA AUTÔNOMA: se lista.size() == 0, avise "Nenhuma ficha..."
        // se não, imprima ---- FICHAS NO GAVETEIRO ---- com lista.size()
        // e percorra com for
        // imprimindo matrícula + " | " + nome + " | " + curso pelos getters
    }
}