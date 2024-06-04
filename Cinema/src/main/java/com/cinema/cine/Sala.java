package com.cinema.cine;

import com.cinema.JsonCinema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Representa uma sala de cinema.
 */
public class Sala {
    /** Identificador único da sala. */
    private int idSala;

    /** Capacidade máxima de assentos da sala. */
    private int capacidade;

    /**Verifica se a sala esta disponivel */
    private boolean status;

    private static List<Sala> salas = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    //private static final String FILE_PATH = "/home/joeum/Projetos GITHUB REPO/CinemaMark/Cinema/src/main/resources/arquivosjson/salas.json";
    private static final String FILE_PATH = "C:\\Users\\Álvaro Soares\\Documents\\GitHub\\CineMark\\CineMark\\CinemaMark\\Cinema\\src\\main\\resources\\arquivosjson\\salas.json";
    /**
     * Construtor da Sala.
     * @param idSala O identificador único da sala.
     * @param capacidade A capacidade máxima de assentos da sala.
     */
    public Sala(int idSala, int capacidade, String tipo, boolean status) {
        this.idSala = idSala;
        this.capacidade = capacidade;
        this.status = status;
    }

    // Iniciando construtor padrão
    public Sala(){


    }

    public static String cadastrarSala(Sala sala){
        Sala novaSala = new Sala();

        System.out.println("Digite o codigo da sala:");
        int idSala = sc.nextInt();
        novaSala.setIdSala(idSala);
        sc.nextLine(); // Consumir a quebra de linha após nextInt()


        System.out.println("Digite a capacidade máxima de assentos da sala:");
        int capacidade = sc.nextInt();
        novaSala.setCapacidade(capacidade);
        sc.nextLine(); // Consumir a quebra de linha após nextInt()


        System.out.println("A sala está em operação? (true/false):");
        boolean status = sc.nextBoolean();
        novaSala.setStatus(status);
        sc.nextLine(); // Consumir a quebra de linha após nextBoolean()

        salas.add(novaSala);

        JsonCinema.escreverObjeto(salas, FILE_PATH);
        return novaSala.toString();
    }

    public static Sala buscarSalaPorId(int id, List<Sala> salas) {
        for (Sala sala : salas) {
            if (sala.getIdSala() == id) {
                return sala;
            }
        }
        return null;
    }

    /**
     * Obtém o identificador da sala.
     * @return O identificador da sala.
     */
    public int getIdSala() {
        return idSala;
    }

    /**
     * Define o identificador da sala.
     * @param idSala O novo identificador da sala.
     */
    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    /**
     * Obtém a capacidade da sala.
     * @return A capacidade da sala.
     */
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * Define a capacidade da sala.
     * @param capacidade A nova capacidade da sala.
     */
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    /**
     * Obtém o tipo da sala.
     * @return O tipo da sala.
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Define o tipo da sala.
     * @param status O novo tipo da sala.
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Retorna uma representação em formato de string da sala.
     * @return Uma string representando a sala.
     */
    @Override
    public String toString() {
        return "Sala{" +
                "idsala=" + idSala +
                ", capacidade=" + capacidade +
                '}';
    }
}
