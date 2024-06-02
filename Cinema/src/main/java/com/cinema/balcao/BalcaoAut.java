package com.cinema.balcao;

/**
 * Representa um balcão automatico de atendimento no cinema.
 */
public class BalcaoAut {

    /** Identificador único do balcão */
    private int idBalcao;

    /**
     * Construtor da classe BalcaoAut.
     * @param idBalcao O identificador único do balcão a ser criado.
     */
    public BalcaoAut(int idBalcao) {
        this.idBalcao = idBalcao;
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
}
