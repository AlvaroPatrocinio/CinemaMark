package com.cinema.cine;

import com.cinema.JsonCinema;
import com.cinema.cliente.Cliente;
import com.google.gson.reflect.TypeToken;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Representa um ingresso para um filme em um cinema.
 */
public class Ingresso {
    private int idIngresso;  // Identificação única do ingresso
    private static Sessao sessao;
    private double preco;  // Preço do ingresso
    private static Cliente cliente;

    private static int proximoId = 0;

    private List<Ingresso> ingressos = new ArrayList<>();  // Lista de ingressos cadastrados

    private static Scanner scanner = new Scanner(System.in);  // Scanner para entrada de dados

    private static final String SESSAO_PATH = "/home/joeum/Projetos GITHUB REPO/CinemaMark/Cinema/src/main/resources/arquivosjson/sessoes.json";
    private static final String CLIENTE_PATH = "/home/joeum/Projetos GITHUB REPO/CinemaMark/Cinema/src/main/resources/arquivosjson/clientes.json";
    private static final String VENDA_PATH = "/home/joeum/Projetos GITHUB REPO/CinemaMark/Cinema/src/main/resources/arquivosjson/vendas.json";


    /**
     * Cadastrar um novo ingresso.
     * @param ingresso O ingresso a ser cadastrado.
     * @return Uma representação em String dos ingressos cadastrados.
     */
    /**
     * Método para comprar um ingresso.
     */
    public static void comprarIngresso() {
        // Ler os clientes do arquivo JSON
        List<Cliente> clientes = JsonCinema.lerObjeto(CLIENTE_PATH,new TypeToken<List<Cliente>>() {}.getType());
        if (clientes == null || clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado. Não é possível comprar ingressos.");
            return;
        }

        // Exibir os clientes cadastrados
        System.out.println("Clientes cadastrados:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        System.out.println("Digite o ID do cliente que está comprando o ingresso: ");
        int idCliente = scanner.nextInt();
        Cliente clienteSelecionado = cliente.buscarClientePorId(idCliente, clientes);
        if (clienteSelecionado == null) {
            System.out.println("Cliente não encontrado. Não é possível comprar o ingresso.");
            return;
        }

        // Ler as sessões disponíveis do arquivo JSON
        List<Sessao> sessoes = JsonCinema.lerObjeto(SESSAO_PATH, new TypeToken<List<Sessao>>() {}.getType());
        if (sessoes == null || sessoes.isEmpty()) {
            System.out.println("Nenhuma sessão disponível. Não é possível comprar ingressos.");
            return;
        }
        for (Sessao sessao : sessoes) {
            System.out.println(sessao);
        }

        System.out.println("Digite o ID da sessão para a qual deseja comprar o ingresso: ");
        int idSessao = scanner.nextInt();
        Sessao sessaoSelecionada = sessao.buscarSessaoPorId(idSessao, sessoes);
        if (sessaoSelecionada == null) {
            System.out.println("Sessão não encontrada. Não é possível comprar o ingresso.");
            return;
        }

        System.out.println("Digite o preço do ingresso: ");
        double preco = scanner.nextDouble();

        Ingresso ingresso = new Ingresso();
        ingresso.setIdIngresso(proximoId++);
        ingresso.setSessao(sessao);
        ingresso.setPreco(preco);
        ingresso.setCliente(cliente);

        // Ler os ingressos do arquivo JSON
        List<Ingresso> ingressos = JsonCinema.lerObjeto(VENDA_PATH, new TypeToken<List<Ingresso>>() {}.getType());
        if (ingressos == null) {
            ingressos = new ArrayList<>();
        }
        ingressos.add(ingresso);

        // Salvar os ingressos no arquivo JSON
        JsonCinema.escreverObjeto(ingressos, VENDA_PATH);

        System.out.println("Ingresso comprado com sucesso!");
    }

    /**
     * Construtor para um ingresso com todos os atributos.
     */

    public Ingresso(int idIngresso, Sessao sessao ,double preco, Cliente cliente) {
        this.idIngresso = idIngresso;
        this.sessao = sessao;
        this.preco = preco;
        this.cliente = cliente;
    }

    /**
     * Construtor padrão para um ingresso.
     */
    public Ingresso() {

    }

    // Getters e setters para os atributos da classe


    public int getIdIngresso() {
        return idIngresso;
    }

    public void setIdIngresso(int idIngresso) {
        this.idIngresso = idIngresso;
    }

    public static Sessao getSessao() {
        return sessao;
    }

    public static void setSessao(Sessao sessao) {
        Ingresso.sessao = sessao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public static Cliente getCliente() {
        return cliente;
    }

    public static void setCliente(Cliente cliente) {
        Ingresso.cliente = cliente;
    }
}
