/*
 * Disciplina: 2026-PS
 * Projeto   : bibliotech
 * Arquivo   : Main.java
 * Autor     : Gustavo Ferreira Koller Da Silva
 * Descricao : Classe principal para testar o funcionamento da classe Livro.
 */

package bibliotech;

public class Main {
    public static void main(String[] args) {
        System.out.println("BiblioTech v0.2 - as classes existem");

        // Criando dois livros
        Livro l1 = new Livro("Dom Casmurro", "Machado de Assis", 1899);
        Livro l2 = new Livro("Capitaes da Areia", "Jorge Amado", 1937);

        // Imprimindo os livros na tela
        System.out.println(l1);
        System.out.println(l2);

        // Realizando um emprestimo para testar
        l1.emprestar();

        System.out.println("Depois do emprestimo: " + l1);
        System.out.println("Dom Casmurro disponivel? " + l1.estaDisponivel());
    }
}
