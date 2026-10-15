/*
 * Disciplina: 2026-PS
 * Projeto   : bibliotech
 * Arquivo   : TesteRequisitos.java
 * Autor     : Gustavo Ferreira Koller Da Silva
 * Descricao : Validador completo cobrindo as 20 verificacoes dos Niveis C, B e A.
 */

package bibliotech;

import java.time.LocalDate;

public class TesteRequisitos {
    private static int passaram = 0;
    private static int falharam = 0;

    private static void verificar(String nome, boolean condicao) {
        if (condicao) {
            System.out.println("OK\t" + nome);
            passaram++;
        } else {
            System.out.println("FALHOU\t" + nome);
            falharam++;
        }
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.cadastrarLivro(new Livro("Dom Casmurro", "Machado de Assis", 1899));
        biblioteca.cadastrarLivro(new Livro("Capitaes da Areia", "Jorge Amado", 1937));

        Leitor pedro = new Leitor("Pedro Alves", "2026010", 1);
        Leitor ana = new Leitor("Ana Lima", "2026011", 2);
        biblioteca.cadastrarLeitor(pedro);
        biblioteca.cadastrarLeitor(ana);

        // Verificações de Busca e Cadastro (RF01, RF02, RF03)
        Livro l1 = biblioteca.buscarLivro("Dom Casmurro");
        verificar("RF01 livro cadastrado aparece na busca", l1 != null);

        Leitor leitorAchado = biblioteca.buscarLeitor("2026010");
        verificar("RF02 leitor cadastrado aparece na busca", leitorAchado != null);

        verificar("RF03 livro novo esta disponivel", l1 != null && l1.estaDisponivel());
        verificar("RF03 titulo fora do acervo nao e encontrado", biblioteca.buscarLivro("O Cortico") == null);

        // Regras padrão do emprestimo (RF05)
        boolean emp1 = biblioteca.emprestar("Dom Casmurro", "2026010");
        verificar("RF05 emprestimo de livro disponivel e aceito", emp1 == true);
        verificar("RF05 livro emprestado fica indisponivel", l1.estaDisponivel() == false);
        verificar("RF05 leitor passa a ter 1 livro em maos", pedro.getLivrosEmMaos() == 1);

        boolean emp2 = biblioteca.emprestar("Dom Casmurro", "2026011");
        verificar("RF05 livro emprestado e recusado para outro leitor", emp2 == false);

        boolean empLimite = biblioteca.emprestar("Capitaes da Areia", "2026010");
        verificar("RF05 leitor no limite e recusado", !empLimite);

        // Verificações de Devolução (RF04)
        boolean dev1 = biblioteca.devolver("Dom Casmurro");
        verificar("RF04 devolucao de emprestimo ativo e aceita", dev1 == true);
        verificar("RF04 livro devolvido volta a ficar disponivel", l1.estaDisponivel() == true);

        boolean devRepetida = biblioteca.devolver("Dom Casmurro");
        verificar("RF04 segunda devolucao e recusada", devRepetida == false);

        // Recusas robustas por dados inexistentes e integridade de estado
        boolean empInexistente = biblioteca.emprestar("O Cortico", "2026011");
        verificar("RF05 titulo inexistente e recusado", !empInexistente);

        boolean empLeitorInexistente = biblioteca.emprestar("Capitaes da Areia", "9999999");
        verificar("RF05 matricula inexistente e recusada", !empLeitorInexistente);

        Livro l2 = biblioteca.buscarLivro("Capitaes da Areia");
        verificar("RF05 recusa nao muda o livro", l2.estaDisponivel() == true);
        verificar("RF05 recusa nao muda o leitor", ana.getLivrosEmMaos() == 0);

        // Validacao estrutural de prazo de 7 dias
        biblioteca.emprestar("Capitaes da Areia", "2026011"); 
        Emprestimo registroAtivo = null;
        for (Emprestimo e : biblioteca.obterEmprestimosAtrasados(LocalDate.now().plusDays(10))) {
            registroAtivo = e; 
        }
        verificar("Prazo: devolucao prevista 7 dias depois da retirada", 
            registroAtivo != null && registroAtivo.getDataDevolucaoPrevista().equals(LocalDate.now().plusDays(7)));

        // Validacao temporal de atrasos
        LocalDate hoje = LocalDate.now();
        LocalDate ultimoDiaPrazo = hoje.plusDays(7);
        LocalDate diaSeguintePrazo = hoje.plusDays(8);

        verificar("HU05 hoje ninguem esta atrasado", biblioteca.obterEmprestimosAtrasados(hoje).isEmpty());
        verificar("HU05 no ultimo dia do prazo ninguem esta atrasado", biblioteca.obterEmprestimosAtrasados(ultimoDiaPrazo).isEmpty());
        verificar("HU05 um dia depois do prazo ha 1 atrasado", biblioteca.obterEmprestimosAtrasados(diaSeguintePrazo).size() == 1);

        System.out.println("\n" + passaram + " passaram, " + falharam + " falharam.");
    }
}
