package com.cinema.balcao;

import com.cinema.JsonCinema;
import com.cinema.func.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Esta classe representa um balcão com um funcionário associado.
 */
public class BalcaoFun extends BalcaoAut {

    private static final String BALCAO_PATH = "/home/joeum/Projetos GITHUB REPO/CinemaMark/Cinema/src/main/resources/arquivosjson/balcoesFun.json";
    private static List<BalcaoFun> balcoes = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    /**
     * Construtor para inicializar um BalcaoFun com um ID de balcão e um funcionário associado.
     * @param idBalcao O ID do balcão.
     */
    public BalcaoFun(int idBalcao) {
        super(idBalcao); // Chama o construtor da classe pai com o ID do balcão
    }

    public BalcaoFun() {
        super();
    }

    /**
     * Sobrescreve o método toString para retornar uma representação em string do BalcaoFun.
     * @return Uma representação em string do BalcaoFun.
     */
    @Override
    public String toString() {
        return "BalcaoFun{" +
                "id=" + getIdBalcao() +
                '}';
    }

    public static void cadastrarBalcao() {
        BalcaoFun novoBalcao = new BalcaoFun();

        System.out.println("Digite o ID do balcão:");
        int idBalcao = sc.nextInt();
        sc.nextLine(); // Limpar o buffer do scanner
        novoBalcao.setIdBalcao(idBalcao);

        balcoes.add(novoBalcao);

        JsonCinema.escreverObjeto(balcoes, BALCAO_PATH);

        System.out.println("Balcão cadastrado com sucesso!");
    }
}
