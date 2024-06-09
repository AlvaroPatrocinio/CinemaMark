package com.cinema.cine;
import com.cinema.JsonCinema;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sessao {

    private int codSessao; // O código único da sessão
    private Filme filme; // O filme exibido na sessão
    private Sala sala; // A sala onde a sessão ocorre
    private String dataHora; // A data e hora da sessão


    // Caminhos dos arquivos JSON
    private static final String FILME_PATH = "C:\\Users\\Álvaro Soares\\Documents\\GitHub\\CineMark\\CineMark\\CinemaMark\\Cinema\\src\\main\\resources\\arquivosjson\\filmes.json";
    private static final String SALA_PATH = "C:\\Users\\Álvaro Soares\\Documents\\GitHub\\CineMark\\CineMark\\CinemaMark\\Cinema\\src\\main\\resources\\arquivosjson\\salas.json";
    private static final String SESSAO_PATH = "C:\\Users\\Álvaro Soares\\Documents\\GitHub\\CineMark\\CineMark\\CinemaMark\\Cinema\\src\\main\\resources\\arquivosjson\\sessoes.json";


    /**
     * Construtor para criar uma nova sessão.
     * @param codSessao O código único da sessão
     * @param filme O filme exibido na sessão
     * @param sala A sala onde a sessão ocorre
     * @param dataHora A data e hora da sessão
     */
    public Sessao(int codSessao, Filme filme, Sala sala, String dataHora) {
        this.codSessao = codSessao;
        this.filme = filme;
        this.sala = sala;
        this.dataHora = dataHora;
    }

    //Iniciando construtor padrao
    public Sessao(){

    }

    public int getCodSessao() {
        return codSessao;
    }

    public void setCodSessao(int codSessao) {
        this.codSessao = codSessao;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }


    /**
     * Retorna uma representação ToString
     * @return Uma string representando a sessão.
     */
    @Override
    public String toString() {
        return "Sessao{" +
                "codSessao=" + codSessao +
                ", filme=" + filme +
                ", sala=" + sala +
                ", dataHora='" + dataHora + '\'' +
                '}';
    }

    /**
     * Método para cadastrar uma nova sessão.
     */
    public static void cadastrarSessao() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o codigo da sessão");
        int codSessao = scanner.nextInt();
        scanner.nextLine();

        // Buscar lista de filmes e de salas
        List<Filme> filmes = JsonCinema.lerObjeto(FILME_PATH, new TypeToken<List<Filme>>() {}.getType());
        List<Sala> salas = JsonCinema.lerObjeto(SALA_PATH, new TypeToken<List<Sala>>() {}.getType());

        System.out.println("Selecione um filme:");
        for (Filme filme : filmes) {
            System.out.println(filme.getId() + ": " + filme.getNome());
        }
        int idFilme = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        Filme filmeSelecionado = Filme.buscarFilmePorId(idFilme, filmes);
        if (filmeSelecionado == null) {
            System.out.println("Filme não encontrado.");
            return; // Se o filme não for encontrado, encerra o método
        }

        System.out.println("Selecione uma sala:");
        for (Sala sala : salas) {
            if (sala.isStatus()) { // Verifica se a sala está disponível (status true)
                System.out.println(sala.getIdSala());
            }
        }

        // Solicitar ao usuário que selecione uma sala disponível
        int idSala = -1;
        do {
            idSala = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            Sala salaSelecionada = Sala.buscarSalaPorId(idSala, salas);
            if (salaSelecionada == null || !salaSelecionada.isStatus()) {
                System.out.println("Sala não encontrada ou não disponível. Selecione outra sala:");
            } else {
                salaSelecionada.setStatus(false);
                System.out.println("Digite a data e hora da sessão (formato dd/MM/yyyy HH'h'): ");
                String dataHora = scanner.nextLine();
                System.out.println();
                System.out.println("Sessão criada com sucesso.");

                Sessao novaSessao = new Sessao(codSessao, filmeSelecionado, salaSelecionada, dataHora);
                List<Sessao> sessoes = JsonCinema.lerObjeto(SESSAO_PATH, new TypeToken<List<Sessao>>() {}.getType());
                if (sessoes == null) sessoes = new ArrayList<>();
                sessoes.add(novaSessao);
                JsonCinema.escreverObjeto(sessoes, SESSAO_PATH);

                System.out.println("Sessão Cadastrada com sucesso!");
                return;
            }
        } while (true);
    }

    /**
     * Método para buscar uma sessão pelo ID.
     * @param id O ID da sessão a ser buscada.
     * @param sessoes A lista de sessões onde será feita a busca.
     * @return A sessão encontrada ou null se não for encontrada.
     */
    public static Sessao buscarSessaoPorId(int id, List<Sessao> sessoes) {
        for (Sessao sessao : sessoes) {
            if (sessao.getCodSessao() == id) {
                return sessao;
            }
        }
        return null;
    }

    /**
     * Método para visualizar todas as sessões cadastradas.
     */
    public static void visualizarSessoes() {
        List<Sessao> sessoes = JsonCinema.lerObjeto(SESSAO_PATH     , new TypeToken<List<Sessao>>() {}.getType());
        if (sessoes == null || sessoes.isEmpty()) {
            System.out.println("Nenhuma sessão encontrada.");
        } else {
            System.out.println("Lista de sessões:");
            for (Sessao sessao : sessoes) {
                System.out.println(sessao);
            }
        }
    }
}
