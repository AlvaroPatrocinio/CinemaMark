package com.cinema.func;

/**
 * Classe para realizar operações de login.
 */
public class Login {

    private String user;
    private String pass;

    /**
     * Construtor da classe Login.
     *
     * @param usuario O nome de usuário
     * @param senha A senha do usuário
     */
    public Login(String usuario, String senha) {
        this.user = usuario;
        this.pass = senha;
    }

    /**
     * Método para realizar o login de um funcionário.
     *
     * @param funcionario O funcionário que está tentando fazer login
     * @return true se o login for bem-sucedido, false caso contrário
     */
    public boolean login(Funcionario funcionario) {
        return funcionario.getUsuario().equals(user)
                && funcionario.getSenha().equals(pass);
    }

    /**
     * Método para realizar o login de um administrador.
     *
     * @param administrador O administrador que está tentando fazer login
     * @return true se o login for bem-sucedido e for um administrador, false caso contrário
     */
    public boolean login(Administrador administrador){
        return administrador.getUsuario().equals(user)
                && administrador.getSenha().equals(pass)
                && administrador.isIsAdmin();
    }

    /**
     * Sobrescrita do método toString para exibir informações sobre o login.
     *
     * @return Uma representação em string do objeto Login
     */
    @Override
    public String toString() {
        return "Login{" +
                "user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
