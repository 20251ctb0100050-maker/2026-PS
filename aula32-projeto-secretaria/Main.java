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
            System.out.println("=============================================");
            System.out.println("       SECRETARIA DO CAMPOS - GUSTAVO KOLLER");
            System.out.println("=============================================");
            System.out.println("[1] Cadastrar aluno");
            System.out.println("[2] Listar alunos");
            System.out.println("[3] Buscar por matricula");
            System.out.println("[4] Atualizar curso");
            System.out.println("[5] Remover aluno");
            System.out.println("[6] relatorio");
            System.out.println("[0] Sair");
            System.out.println("Sua escolha:");

            String opcao = teclado.nextLine().trim();

            // Texto que parece "0", "1", "2", ...
            if (opcao.equals("0")) {
                System.out.println("Secretaria fechada. Até a próxima!");
                break;

            } else if (opcao.equals("1")) {
                cadastrar(lista, teclado);

            } else if (opcao.equals("2")) {
                listar(lista);

            } else if (opcao.equals("3")) {
                buscar(lista, teclado);

            } else if (opcao.equals("4")) {
                atualizar(lista, teclado);

            } else if (opcao.equals("5")) {
                remover(lista, teclado);

            } else if (opcao.equals("6")) {
                relatorio(lista, teclado);

            } else {
                System.out.println("Opção inválida! Vale 0, 1, 2, 3, 4, 5 ou 6.");
            }
        }
    }

    // Le os dados no balcão, carimba a ficha e guarda no gaveteiro.
    static void cadastrar(ArrayList<Aluno> lista, Scanner teclado) {
        System.out.print("Nome: ");
        String nome = teclado.nextLine().trim();

        System.out.print("Matricula: ");
        String matricula = teclado.nextLine().trim();

        // MATRICULA UNICA: busca antes de inserir. Se ja existe, desiste.
        // A mesma busca de novo: quarta vez que ela trabalha para voce.
        Aluno existente = buscarPorMatricula(lista, matricula);

        if (existente != null) {
            System.out.println("Ja existe ficha com a matricula " + matricula + "!");
            return;
        }

        System.out.print("Curso: ");
        String curso = teclado.nextLine().trim();

        Aluno aluno = new Aluno(nome, matricula, curso);
        lista.add(aluno);

        System.out.println("Ficha de " + nome + " guardada!");
    }

    // Percorre o gaveteiro e imprime ficha por ficha.
    static void listar(ArrayList<Aluno> lista) {

        if (lista.size() == 0) {
            System.out.println("Nenhuma ficha...");

        } else {
            System.out.println("---- FICHAS NO GAVETEIRO ----");
            System.out.println(lista.size());

            for (int i = 0; i < lista.size(); i++) {
                Aluno a = lista.get(i);

                System.out.println(
                    a.getMatricula() + " | " +
                    a.getNome() + " | " +
                    a.getCurso()
                );

                System.out.println(a);
            }
        }
    }

    // O CORACAO DO SISTEMA: devolve a ficha achada, ou null se nao existir.
    static Aluno buscarPorMatricula(ArrayList<Aluno> lista, String matricula) {

        for (int i = 0; i < lista.size(); i++) {
            Aluno a = lista.get(i);

            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }

        return null;
    }

    // O balcao pergunta a matricula e usa a busca para responder.
    static void buscar(ArrayList<Aluno> lista, Scanner teclado) {
        System.out.print("Matricula procurada: ");

        String matricula = teclado.nextLine().trim();

        Aluno a = buscarPorMatricula(lista, matricula);

        if (a == null) {
            System.out.println(
                "Nenhuma ficha com a matricula " + matricula + "."
            );

        } else {
            System.out.println(
                "Achei: " + a.getMatricula() + " | " + a.getNome() + ""
            );
        }
    }

    // Atualizar reusa a busca.
    static void atualizar(ArrayList<Aluno> lista, Scanner teclado) {
        System.out.print("Matricula da ficha a atualizar: ");
        String matricula = teclado.nextLine().trim();

        Aluno a = buscarPorMatricula(lista, matricula);

        if (a == null) {
            System.out.println(
                "Nenhuma ficha com a matricula " + matricula + "."
            );
            return;
        }

        System.out.print("Novo curso de " + a.getNome() + ": ");
        String novoCurso = teclado.nextLine().trim();

        a.setCurso(novoCurso);

        System.out.println(
            "Ficha atualizada: " + a.getMatricula() + " | " + a.getNome()
        );
    }

    // Acao destrutiva pede confirmacao.
    static void remover(ArrayList<Aluno> lista, Scanner teclado) {
        System.out.print("Matricula da ficha a remover: ");
        String matricula = teclado.nextLine().trim();

        Aluno a = buscarPorMatricula(lista, matricula);

        if (a == null) {
            System.out.println(
                "Nenhuma ficha com a matricula " + matricula + "."
            );
            return;
        }

        System.out.print(
            "Tem certeza que remove " + a.getNome() + "? (s/n): "
        );

        String resposta = teclado.nextLine().trim();

        if (resposta.equals("s")) {
            lista.remove(a);
            System.out.println("Ficha removida.");

        } else {
            System.out.println("Remocao cancelada.");
        }
    }

    // RELATORIO: o padrao preparar -> percorrer -> usar, da Aula 29.
    static void relatorio(ArrayList<Aluno> lista, Scanner teclado) {
        System.out.println("--- RELATORIO DA SECRETARIA ---");
        System.out.println("Total de fichas: " + lista.size());
        System.out.print("Contar alunos de qual curso? ");

        String curso = teclado.nextLine().trim();

        int contador = 0;                         // preparar

        for (int i = 0; i < lista.size(); i++) { // percorrer
            Aluno a = lista.get(i);

            if (a.getCurso().equals(curso)) {
                contador = contador + 1;
            }
        }

        System.out.println(
            "Alunos de " + curso + ": " + contador
        );                                        // usar
    }
}