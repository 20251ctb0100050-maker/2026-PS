/*
 * Disciplina: 2026-PS
 * Projeto   : bibliotech
 * Arquivo   : Leitor.java
 * Autor     : Gustavo Ferreira Koller Da Silva
 * Descricao : Classe que representa um Leitor, herdando de Usuario.
 */

package bibliotech;

public class Leitor extends Usuario {
    private int livrosEmMaos;
    private int limiteLivros;

    public Leitor(String nome, String id, int limiteLivros) {
        super(nome, id);
        this.limiteLivros = limiteLivros;
        this.livrosEmMaos = 0;
    }

    public boolean podePegarEmprestado() {
        return livrosEmMaos < limiteLivros;
    }

    public void pegouLivro() {
        livrosEmMaos++;
    }

    public void devolveuLivro() {
        if (livrosEmMaos > 0) {
            livrosEmMaos--;
        }
    }

    public int getLivrosEmMaos() {
        return livrosEmMaos;
    }
}
