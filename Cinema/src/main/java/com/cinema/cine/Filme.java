package com.cinema.cine;

import com.cinema.JsonCinema;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Representa um filme do cinema.
 */
public class Filme {
    private int id; /* O ID do filme */
    private String nome; /** O nome do filme */
    private String genero; /** O gênero do filme para assimilar com as preferências do cliente */
    private String diretor; /** O diretor do filme */
    private String descrição; /* A descrição do filme */

    /** Número total de filmes criados. */
    private static int numFilmes = 0;

    /**
     * Construtor para criar um novo filme.
     * @param nome O nome do filme.
     * @param genero O gênero do filme.
     * @param diretor O diretor do filme.
     * @param descrição A descrição do filme.
     */

    /** Inicializando lista de filmes */
    private static List<Filme> filmes = new ArrayList<>();
    private static Scanner scf = new Scanner(System.in);

    //Questão número 14: Salve e recupere todas as informações dos Clientes, Filmes, Produtos, Vendas, colaboradores e Estoque em um arquivo de texto.
    private static final String FILE_PATH = "C:\\Users\\Álvaro Soares\\Documents\\GitHub\\CineMark\\CineMark\\CinemaMark\\Cinema\\src\\main\\resources\\arquivosjson\\arquivosjson\\filmes.json";

    public Filme(String nome, String genero, String diretor, String descrição) {
        this.nome = nome;
        this.genero = genero;
        this.diretor = diretor;
        this.descrição = descrição;
    }

    public Filme(){

    }
    public static String cadastrarFilme(Filme filme) {

        Filme novoFilme = new Filme();

        novoFilme.setId(++numFilmes);

        System.out.println("Digite o nome do filme:");
        String nome = scf.nextLine();
        novoFilme.setNome(nome);

        System.out.println("Digite o genero do filme:");
        String genero = scf.nextLine();
        novoFilme.setGenero(genero);

        System.out.println("Digite o diretor:");
        String diretor = scf.nextLine();
        novoFilme.setDiretor(diretor);

        System.out.println("Digite a descrição:");
        String descricao = scf.nextLine();
        novoFilme.setDescrição(descricao);

        filmes.add(novoFilme);

        JsonCinema.escreverObjeto(filmes, FILE_PATH);
        return novoFilme.toString();
    }

    public static Filme buscarFilmePorId(int id, List<Filme> filmes) {
        for (Filme filme : filmes) {
            if (filme.getId() == id) {
                return filme;
            }
        }
        return null;
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
     * Obtém a descrição do filme.
     * @return A descrição do filme.
     */
    public int getId() {
        return id;
    }

    /**
     * Define a descrição do filme.
     * @param id A nova descrição do filme.
     */
    public void setId(int id) {
        this.id = id;
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
                ", id='" + id + '\'' +
                '}';
    }
}
