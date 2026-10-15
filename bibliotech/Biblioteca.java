/*
 * Disciplina: 2026-PS
 * Projeto   : bibliotech
 * Arquivo   : Biblioteca.java
 * Autor     : Gustavo Ferreira Koller Da Silva
 * Descricao : Classe gerenciadora que reúne acervo, leitores e historico de emprestimos.
 */

package bibliotech;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros;
    private ArrayList<Leitor> leitoras;
    private ArrayList<Emprestimo> emprestimos;

    // Construtor que cria as listas (Fase 1.5)
    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.leitoras = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    // Nivel B: Evita matricula repetida
    public boolean cadastrarLeitor(Leitor leitor) {
        if (buscarLeitor(leitor.getId()) != null) {
            return false; 
        }
        leitoras.add(leitor);
        return true;
    }

    public void listarAcervo() {
        System.out.println("--- Acervo ---");
        for (Livro l : livros) {
            System.out.println(l);
        }
    }

    public Livro buscarLivro(String titulo) {
        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                return l;
            }
        }
        return null;
    }

    public Leitor buscarLeitor(String matricula) {
        for (Leitor leitor : leitoras) {
            if (leitor.getId().equals(matricula)) {
                return leitor;
            }
        }
        return null;
    }

    public boolean emprestar(String titulo, String matricula) {
        Livro livro = buscarLivro(titulo);
        Leitor leitor = buscarLeitor(matricula);

        // If de guarda para evitar NullPointerException (Fase 3.4)
        if (livro == null || leitor == null) {
            return false;
        }

        Emprestimo emp = new Emprestimo(livro, leitor);

        if (emp.realizarEmprestimo()) {
            emprestimos.add(emp);
            return true;
        }

        return false;
    }

    public boolean devolver(String titulo) {
        for (Emprestimo emp : emprestimos) {
            if (emp.getLivro().getTitulo().equalsIgnoreCase(titulo) && emp.estaAtivo()) {
                return emp.registrarDevolucao();
            }
        }
        return false;
    }

    public void listarEmprestimos() {
        System.out.println("--- Emprestimos ---");
        for (Emprestimo emp : emprestimos) {
            System.out.println(emp);
        }
    }

    // Nivel A: Listar livros ativos de um leitor especifico
    public void listarLivrosDoLeitor(String matricula) {
        System.out.println("--- Livros com a matricula " + matricula + " ---");
        for (Emprestimo emp : emprestimos) {
            if (emp.getLeitor().getId().equals(matricula) && emp.estaAtivo()) {
                System.out.println(emp.getLivro());
            }
        }
    }
}
