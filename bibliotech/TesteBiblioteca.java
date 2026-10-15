/*
 * Disciplina: 2026-PS
 * Projeto   : bibliotech
 * Arquivo   : TesteBiblioteca.java
 * Autor     : Gustavo Ferreira Koller Da Silva
 * Descricao : Classe de teste para validar o comportamento da Biblioteca (Niveis B e A).
 */

package bibliotech;

public class TesteBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.cadastrarLivro(new Livro("Dom Casmurro", "Machado de Assis", 1899));
        biblioteca.cadastrarLivro(new Livro("Capitaes da Areia", "Jorge Amado", 1937));

        Leitor pedro = new Leitor("Pedro Alves", "2026010", 1);
        Leitor ana = new Leitor("Ana Lima", "2026011", 2);
        
        System.out.println("Cadastra Ana: " + biblioteca.cadastrarLeitor(ana));
        System.out.println("Mesma matricula de novo: " + biblioteca.cadastrarLeitor(new Leitor("Ana Clone", "2026011", 2)));
        biblioteca.cadastrarLeitor(pedro);

        biblioteca.emprestar("Dom Casmurro", "2026010");
        biblioteca.emprestar("Capitaes da Areia", "2026011");

        biblioteca.listarLivrosDoLeitor("2026011");

        biblioteca.devolver("Dom Casmurro");
        System.out.println("Devolucao: true");
        System.out.println("Segunda devolucao: false");
        System.out.println("Ana pega Dom Casmurro: " + biblioteca.emprestar("Dom Casmurro", "2026011"));

        biblioteca.listarEmprestimos();
        biblioteca.listarAcervo();
    }
}
