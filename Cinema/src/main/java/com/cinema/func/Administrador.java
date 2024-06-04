package com.cinema.func;
import com.cinema.JsonCinema;

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

    //private static final String FILE_PATH = "/home/joeum/Projetos GITHUB REPO/CinemaMark/Cinema/src/main/resources/arquivosjson/admins.json";
    private static final String FILE_PATH = "C:\\Users\\Álvaro Soares\\Documents\\GitHub\\CineMark\\CineMark\\CinemaMark\\Cinema\\src\\main\\resources\\arquivosjson\\admins.json";

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

        Administrador novoAdministrador = new Administrador();

        novoAdministrador.setIdFuncionario(proximoId++);
        novoAdministrador.setIsAdm(true);
        System.out.print("Digite o nome do administrador: ");
        String nome = sca.nextLine();
        novoAdministrador.setNome(nome);

        System.out.print("Digite o nome de usuário do administrador: ");
        String usuario = sca.nextLine();
        novoAdministrador.setUsuario(usuario);

        System.out.print("Digite a senha do administrador: ");
        String senha = sca.nextLine();
        novoAdministrador.setSenha(senha);

        administradores.add(novoAdministrador);

        JsonCinema.escreverObjeto(administradores, FILE_PATH);
    }

    
    private static Administrador buscarAdministradorPorId(int id) {
        for (Administrador administrador : administradores) {
            if (administrador.getIdFuncionario() == id) {
                return administrador;
            }
        }
        return null;
    }


    public static void alterarCadastroAdministrador() {
        Scanner sca = new Scanner(System.in);

        System.out.print("Digite o ID do administrador que deseja alterar: ");
        int idAdministrador = sca.nextInt();
        sca.nextLine();

        // Buscar o administrador pelo ID
        Administrador administrador = buscarAdministradorPorId(idAdministrador);

        if (administrador != null) {
            System.out.println("Administrador encontrado. Digite os novos dados:");

            System.out.print("Novo nome: ");
            String novoNome = sca.nextLine();
            administrador.setNome(novoNome);

            System.out.print("Novo nome de usuário: ");
            String novoUsuario = sca.nextLine();
            administrador.setUsuario(novoUsuario);

            System.out.print("Nova senha: ");
            String novaSenha = sca.nextLine();
            administrador.setSenha(novaSenha);

            System.out.println("Cadastro do administrador alterado com sucesso.");
        } else {
            System.out.println("Nenhum administrador encontrado com o ID fornecido.");
        }
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
