package com.cinema.cine;

/**
 * Representa um filme do cinema.
 */
public class Filme {
    private String nome; /** O nome do filme */
    private String genero; /** O gênero do filme para assimilar com as preferências do cliente */
    private String diretor; /** O diretor do filme */
    private String descrição; /* A descrição do filme */

    /**
     * Construtor para criar um novo filme.
     * @param nome O nome do filme.
     * @param genero O gênero do filme.
     * @param diretor O diretor do filme.
     * @param descrição A descrição do filme.
     */
    public Filme(String nome, String genero, String diretor, String descrição) {
        this.nome = nome;
        this.genero = genero;
        this.diretor = diretor;
        this.descrição = descrição;
    }

    /**
     * Obtém o nome do filme.
     * @return O nome do filme.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do filme.
     * @param nome O novo nome do filme.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o gênero do filme.
     * @return O gênero do filme.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Define o gênero do filme.
     * @param genero O novo gênero do filme.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtém o diretor do filme.
     * @return O diretor do filme.
     */
    public String getDiretor() {
        return diretor;
    }

    /**
     * Define o diretor do filme.
     * @param diretor O novo diretor do filme.
     */
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    /**
     * Obtém a descrição do filme.
     * @return A descrição do filme.
     */
    public String getDescrição() {
        return descrição;
    }

    /**
     * Define a descrição do filme.
     * @param descrição A nova descrição do filme.
     */
    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    /**
     * Retorna uma representação em string do filme.
     * @return Uma string que representa o filme.
     */
    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", diretor='" + diretor + '\'' +
                ", descrição='" + descrição + '\'' +
                '}';
    }
}
