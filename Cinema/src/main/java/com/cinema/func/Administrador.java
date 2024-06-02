package com.cinema.func;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Representa um administrador dentro do sistema de cinema.
 */
public class Administrador extends Funcionario {

    private boolean isAdmin; // Indica se o funcionário é um administrador ou não
    static Scanner sca = new Scanner (System.in);
    private static int proximoId = 1;
    private static List<Administrador> administradores = new ArrayList<>();

    /**
     * Construtor para criar um novo administrador com informações básicas.
     *
     * @param idFuncionario O ID do funcionário
     * @param nome O nome do funcionário
     * @param usuario O nome de usuário do funcionário
     * @param senha A senha do funcionário
     */
    public Administrador(int idFuncionario, String nome, String usuario, String senha) {
        super(idFuncionario, nome, usuario, senha); // Chama o construtor da superclasse Funcionario
        this.setIsAdm(true); // Define que este funcionário é um administrador
    }

    public static void cadastrarAdministrador(){
        int idFuncionario = proximoId;

        System.out.print("Digite o nome do funcionário: ");
        String nome = sca.nextLine();

        System.out.print("Digite o nome de usuário do funcionário: ");
        String usuario = sca.nextLine();

        System.out.print("Digite a senha do funcionário: ");
        String senha = sca.nextLine();

        Administrador novoAdministrador = new Administrador(idFuncionario, nome, usuario, senha);

        administradores.add(novoAdministrador);
            }

    /**
     * Construtor padrão para criar um administrador sem especificar informações.
     */
    public Administrador() {
        this.setIsAdm(true); // Define que este funcionário é um administrador
    }

    /**
     * Obtém o status de administração do funcionário.
     *
     * @return true se o funcionário for um administrador, false caso contrário
     */
    public boolean isIsAdmin() {
        return isAdmin;
    }

    /**
     * Define o status de administração do funcionário.
     *
     * @param isAdmin true se o funcionário for um administrador, false caso contrário
     */
    public void setIsAdm(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * Retorna uma representação em string do objeto Administrador.
     *
     * @return Uma string que representa o administrador e suas informações
     */
    @Override
    public String toString() {
        return "Administrador{" +
                "isAdmin=" + isAdmin +
                ", Nome=" + this.getNome() +
                ", ID=" + this.getIdFuncionario() +
                ", SENHA=" + this.getSenha() +
                '}';
    }
}
