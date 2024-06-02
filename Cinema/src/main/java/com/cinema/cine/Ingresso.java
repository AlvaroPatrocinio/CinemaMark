package com.cinema.cine;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Representa um ingresso para um filme em um cinema.
 */
public class Ingresso {
    private int idIngresso;  // Identificação única do ingresso
    private String tipo;  // Tipo do ingresso (ex: inteiro, meia-entrada)
    private Filme filme;  // Filme associado ao ingresso
    private Sala sala;  // Sala onde o filme será exibido
    private LocalDateTime dataHora;  // Data e hora do ingresso
    private double preco;  // Preço do ingresso

    private List<Ingresso> ingressos = new ArrayList<>();  // Lista de ingressos cadastrados

    Scanner sc = new Scanner(System.in);  // Scanner para entrada de dados

    /**
     * Cadastrar um novo ingresso.
     * @param ingresso O ingresso a ser cadastrado.
     * @return Uma representação em String dos ingressos cadastrados.
     */
    public String cadastrarIngresso(Ingresso ingresso) {
        Ingresso novoIngresso = new Ingresso();  // Cria um novo ingresso

        // Captura e define os dados do novo ingresso
        System.out.println("Digite a Identificação do ingresso: ");
        int idIngresso = sc.nextInt();
        novoIngresso.setIdIngresso(idIngresso);

        System.out.println("Digite o tipo do ingresso: ");
        sc.nextLine();
        String tipo = sc.nextLine();
        novoIngresso.setTipo(tipo);

        System.out.println("Digite a data e a hora do filme (no formato yyyy-MM-dd HH:mm): ");
        String dataHoraInput = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dataHora = LocalDateTime.parse(dataHoraInput, formatter);
        novoIngresso.setDataHora(dataHora);

        System.out.println("Digite o preço do ingresso: ");
        double preco = sc.nextDouble();
        novoIngresso.setPreco(preco);

        System.out.println("Digite o Filme: ");
        sc.nextLine(); // Consumir a quebra de linha deixada pelo nextDouble() antes de ler a string
        String filme = sc.nextLine();
        novoIngresso.setFilme(getFilme());

        System.out.println("Digite a Sala do filme:");
        int sala = sc.nextInt();
        novoIngresso.setSala(getSala());

        ingressos.add(novoIngresso);  // Adiciona o ingresso à lista de ingressos
        return ingressos.toString();  // Retorna uma representação em String dos ingressos cadastrados
    }

    /**
     * Construtor para um ingresso com todos os atributos.
     */
    public Ingresso(int idIngresso, String tipo, Filme filme, Sala sala, LocalDateTime dataHora, double preco) {
        this.idIngresso = idIngresso;
        this.tipo = tipo;
        this.filme = filme;
        this.sala = sala;
        this.dataHora = dataHora;
        this.preco = preco;
    }

    /**
     * Construtor padrão para um ingresso.
     */
    public Ingresso() {
        // Inicializa os atributos com valores padrão
        this.idIngresso = idIngresso;
        this.tipo = tipo;
        this.filme = filme;
        this.sala = sala;
        this.dataHora = dataHora;
        this.preco = preco;
    }

    // Getters e setters para os atributos da classe

    /**
     * Obtém a identificação do ingresso.
     * @return A identificação do ingresso.
     */
    public int getIdIngresso() {
        return idIngresso;
    }

    /**
     * Define a identificação do ingresso.
     * @param idIngresso A identificação do ingresso a ser definida.
     */
    public void setIdIngresso(int idIngresso) {
        this.idIngresso = idIngresso;
    }

    /**
     * Obtém o tipo do ingresso.
     * @return O tipo do ingresso.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o tipo do ingresso.
     * @param tipo O tipo do ingresso a ser definido.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtém o filme associado ao ingresso.
     * @return O filme associado ao ingresso.
     */
    public Filme getFilme() {
        return filme;
    }

    /**
     * Define o filme associado ao ingresso.
     * @param filme O filme associado ao ingresso a ser definido.
     */
    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    /**
     * Obtém a sala onde o filme será exibido.
     * @return A sala onde o filme será exibido.
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * Define a sala onde o filme será exibido.
     * @param sala A sala onde o filme será exibido a ser definida.
     */
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    /**
     * Obtém a data e hora do ingresso.
     * @return A data e hora do ingresso.
     */
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    /**
     * Define a data e hora do ingresso.
     * @param dataHora A data e hora do ingresso a ser definida.
     */
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    /**
     * Obtém o preço do ingresso.
     * @return O preço do ingresso.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o preço do ingresso.
     * @param preco O preço do ingresso a ser definido.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }
}
