/*
 * Disciplina: 2026-PS
 * Projeto   : bibliotech
 * Arquivo   : Usuario.java
 * Autor     : Gustavo Ferreira Koller Da Silva
 * Descricao : Classe base Usuario que serve de heranca para Leitor e Bibliotecario.
 */

package bibliotech;

public class Usuario {
    private String nome;
    private String id;

    public Usuario(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }
}
