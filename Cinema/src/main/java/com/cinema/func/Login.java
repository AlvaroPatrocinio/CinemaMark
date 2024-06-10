package com.cinema.func;
import com.cinema.JsonCinema;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import java.util.Scanner;


/**
 * Classe para realizar operações de login.
 */
public class Login {

    private String user;
    private String pass;

    private static final String FUNCIONARIO_PATH = "C:\\Users\\Álvaro Soares\\Documents\\GitHub\\CineMark\\CineMark\\CinemaMark\\Cinema\\src\\main\\resources\\arquivosjson\\funcionarios.json";
    private static final String ADMINISTRADOR_PATH = "C:\\Users\\Álvaro Soares\\Documents\\GitHub\\CineMark\\CineMark\\CinemaMark\\Cinema\\src\\main\\resources\\arquivosjson\\admins.json";


    private static final Scanner scanner = new Scanner(System.in);

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

    public Login(){

    }
    /**
     * Método para realizar o login de um funcionário.
     *
     * @param funcionario O funcionário que está tentando fazer login
     * @return true se o login for bem-sucedido, false caso contrário
     */
    public boolean loginFuncionario(Funcionario funcionario) {
        return funcionario.getUsuario().equals(user)
                && funcionario.getSenha().equals(pass);
    }

    /**
     * Método para realizar o login de um administrador.
     *
     * @param administrador O administrador que está tentando fazer login
     * @return true se o login for bem-sucedido e for um administrador, false caso contrário
     */
    public boolean loginAdmin(Administrador administrador){
        return administrador.getUsuario().equals(user)
                && administrador.getSenha().equals(pass)
                && administrador.isIsAdmin();
    }


    /**
     * Método para verificar se um funcionário existe no arquivo JSON e realizar o login.
     *
     * @return true se o login for bem-sucedido, false caso contrário
     */
    public boolean verificarLoginFuncionario() {
        List<Funcionario> funcionarios = JsonCinema.lerObjeto(FUNCIONARIO_PATH, new TypeToken<List<Funcionario>>() {}.getType());
        if (funcionarios != null) {
            for (Funcionario funcionario : funcionarios) {
                if (loginFuncionario(funcionario)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Método para verificar se um administrador existe no arquivo JSON e realizar o login.
     *
     * @return true se o login for bem-sucedido, false caso contrário
     */
    public boolean verificarLoginAdmin() {
        List<Administrador> administradores = JsonCinema.lerObjeto(ADMINISTRADOR_PATH, new TypeToken<List<Administrador>>() {}.getType());
        if (administradores != null) {
            for (Administrador administrador : administradores) {
                if (loginAdmin(administrador)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Método principal para realizar login.
     */
    public static void realizarLogin() {
        while (true) {
        Login login = new Login();
        
        System.out.println("----------------------------------------------");
        System.out.println("------------- Login de requerido -------------");
        System.out.println("----------------------------------------------");

        System.out.println();
        System.out.println("Digite o nome de usuário:");
        String usuario = scanner.nextLine();
        System.out.println("Digite a senha:");
        String senha = scanner.nextLine();

         login = new Login(usuario, senha);

        if (login.verificarLoginAdmin()) {
            System.out.println("Login de administrador bem-sucedido.");
            break;
        } else if (login.verificarLoginFuncionario()) {
            System.out.println("Login de funcionário bem-sucedido.");
            break;
        } else {
            System.out.println("Nome de usuário ou senha incorretos.");
                }
    } 
    
}

    public static void realizarLoginAdmin() {
        while (true) {
            Login login = new Login();

            System.out.println("----------------------------------------------");
            System.out.println("------ Login de administrador requerido ------");
            System.out.println("----------------------------------------------");
            System.out.println();
            System.out.println("Digite o nome de usuário:");
            String usuario = scanner.nextLine();
            System.out.println("Digite a senha:");
            String senha = scanner.nextLine();

            login = new Login(usuario, senha);

            if (login.verificarLoginAdmin()) {
                System.out.println("Login de administrador bem-sucedido.");
                break;
            } else {
                System.out.println("Nome de usuário ou senha incorretos.");
                            }
        }
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
