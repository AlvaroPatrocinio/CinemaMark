package com.cinema.balcao;

import com.cinema.func.Funcionario;

/**
 * Esta classe representa um balcão com um funcionário associado.
 */
public class BalcaoFun extends BalcaoAut {

    private Funcionario funcionarioBalcao; // Funcionário associado ao balcão

    /**
     * Construtor para inicializar um BalcaoFun com um ID de balcão e um funcionário associado.
     * @param idBalcao O ID do balcão.
     * @param funcionarioBalcao O funcionário associado ao balcão.
     */
    public BalcaoFun(int idBalcao, Funcionario funcionarioBalcao) {
        super(idBalcao); // Chama o construtor da classe pai com o ID do balcão
        this.funcionarioBalcao = funcionarioBalcao; // Inicializa o funcionário associado
    }

    /**
     * Obtém o funcionário associado ao balcão.
     * @return O funcionário associado ao balcão.
     */
    public Funcionario getFuncionarioBalcao() {
        return funcionarioBalcao;
    }

    /**
     * Define o funcionário associado ao balcão.
     * @param funcionarioBalcao O funcionário a ser associado ao balcão.
     */
    public void setFuncionarioBalcao(Funcionario funcionarioBalcao) {
        this.funcionarioBalcao = funcionarioBalcao;
    }

    /**
     * Sobrescreve o método toString para retornar uma representação em string do BalcaoFun.
     * @return Uma representação em string do BalcaoFun.
     */
    @Override
    public String toString() {
        return "BalcaoFun{" +
                "funcionarioBalcao=" + funcionarioBalcao +
                '}';
    }
}
