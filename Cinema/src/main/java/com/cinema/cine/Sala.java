package com.cinema.cine;

/**
 * Representa uma sala de cinema.
 */
public class Sala {
    /** Identificador único da sala. */
    private int idsala;

    /** Capacidade máxima de assentos da sala. */
    private int capacidade;

    /** Tipo da sala (ex: 2D, 3D, VIP, etc.). */
    private String tipo;

    /**
     * Construtor da Sala.
     * @param idsala O identificador único da sala.
     * @param capacidade A capacidade máxima de assentos da sala.
     * @param tipo O tipo da sala (ex: 2D, 3D, VIP, etc.).
     */
    public Sala(int idsala, int capacidade, String tipo) {
        this.idsala = idsala;
        this.capacidade = capacidade;
        this.tipo = tipo;
    }

    /**
     * Obtém o identificador da sala.
     * @return O identificador da sala.
     */
    public int getIdsala() {
        return idsala;
    }

    /**
     * Define o identificador da sala.
     * @param idsala O novo identificador da sala.
     */
    public void setIdsala(int idsala) {
        this.idsala = idsala;
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
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o tipo da sala.
     * @param tipo O novo tipo da sala.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna uma representação em formato de string da sala.
     * @return Uma string representando a sala.
     */
    @Override
    public String toString() {
        return "Sala{" +
                "idsala=" + idsala +
                ", capacidade=" + capacidade +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
