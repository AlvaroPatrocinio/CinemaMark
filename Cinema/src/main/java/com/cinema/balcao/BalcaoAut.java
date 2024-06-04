package com.cinema.balcao;

import com.cinema.JsonCinema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Representa um balcão automatico de atendimento no cinema.
 */
public class BalcaoAut {

    //private static final String BALCAO_PATH = "/home/joeum/Projetos GITHUB REPO/CinemaMark/Cinema/src/main/resources/arquivosjson/balcoesAut.json";
    private static final String BALCAO_PATH = "C:\\Users\\Álvaro Soares\\Documents\\GitHub\\CineMark\\CineMark\\CinemaMark\\Cinema\\src\\main\\resources\\arquivosjson\\arquivosjson\\balcoesAut.json";

    private static List<BalcaoAut> balcoes = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    /** Identificador único do balcão */
    private int idBalcao;

    /**
     * Construtor da classe BalcaoAut.
     * @param idBalcao O identificador único do balcão a ser criado.
     */
    public BalcaoAut(int idBalcao) {
        this.idBalcao = idBalcao;
    }

    public BalcaoAut() {

    }

    /**
     * Obtém o identificador do balcão.
     * @return O identificador único do balcão.
     */
    public int getIdBalcao() {
        return idBalcao;
    }

    /**
     * Define o identificador do balcão.
     * @param idBalcao O novo identificador único do balcão.
     */
    public void setIdBalcao(int idBalcao) {
        this.idBalcao = idBalcao;
    }

    /**
     * Retorna uma representação em string do objeto BalcaoAut.
     * @return Uma string contendo o identificador do balcão.
     */
    @Override
    public String toString() {
        return "BalcaoAut{" +
                "idBalcao=" + idBalcao +
                '}';
    }

    public static void cadastrarBalcao() {
        BalcaoAut novoBalcaoAut = new BalcaoAut();

        System.out.println("Digite o ID do balcão:");
        int idBalcao = sc.nextInt();
        sc.nextLine(); // Limpar o buffer do scanner
        novoBalcaoAut.setIdBalcao(idBalcao);

        balcoes.add(novoBalcaoAut);

        JsonCinema.escreverObjeto(balcoes, BALCAO_PATH);

        System.out.println("Balcão cadastrado com sucesso!");
    }
}
