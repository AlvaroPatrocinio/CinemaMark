package com.cinema.func;

import com.cinema.JsonCinema;
import com.cinema.balcao.BalcaoFun;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Representa um funcionário do cinema.
 */
public class Funcionario {

    private int idFuncionario; // ID único do funcionário
    private String nome; // Nome do funcionário
    private String usuario; // Nome de usuário para login
    private String senha; // Senha para login
    private BalcaoFun balcaoFun;

    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static int proximoId = 1;

    private static final String FILE_PATH = "/home/joeum/Projetos GITHUB REPO/CinemaMark/Cinema/src/main/resources/arquivosjson/funcionarios.json";
    private static final String BALCAO_PATH = "/home/joeum/Projetos GITHUB REPO/CinemaMark/Cinema/src/main/resources/arquivosjson/balcoesFun.json";

    /**
     * Construtor para inicializar um Funcionario com informações completas.
     *
     * @param idFuncionario O ID único do funcionário
     * @param nome O nome do funcionário
     * @param usuario O nome de usuário para login
     * @param senha A senha para login
     */
    public Funcionario(int idFuncionario, String nome, String usuario, String senha, BalcaoFun balcaoFun) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.balcaoFun = balcaoFun;
    }

    public Funcionario(int idFuncionario, String nome, String usuario, String senha) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    /**
     * Construtor padrão que inicializa um Funcionario com valores padrão.
     * Nota: não é recomendado usar esse construtor diretamente.
     */
    public Funcionario() {
        // Os valores padrão serão null para Strings e 0 para int (para idFuncionario)
    }

    /**
     * Obtém o ID do funcionário.
     *
     * @return O ID do funcionário
     */
    public int getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * Define o ID do funcionário.
     *
     * @param idFuncionario O novo ID do funcionário
     */
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * Obtém o nome do funcionário.
     *
     * @return O nome do funcionário
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do funcionário.
     *
     * @param nome O novo nome do funcionário
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o nome de usuário para login.
     *
     * @return O nome de usuário
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Define o nome de usuário para login.
     *
     * @param usuario O novo nome de usuário
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtém a senha do funcionário.
     *
     * @return A senha do funcionário
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do funcionário.
     *
     * @param senha A nova senha do funcionário
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public BalcaoFun getBalcaoFun() {
        return balcaoFun;
    }

    public void setBalcaoFun(BalcaoFun balcaoFun) {
        this.balcaoFun = balcaoFun;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "idFuncionario=" + idFuncionario +
                ", nome='" + nome + '\'' +
                ", usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                ", balcaoFun='" + balcaoFun + '\'' +
                '}';
    }

    public static void cadastrarFuncionario() {
        Funcionario novoFuncionario = new Funcionario();

        novoFuncionario.setIdFuncionario(proximoId++);

        System.out.println("Digite o nome do funcionário:");
        String nome = sc.nextLine();
        novoFuncionario.setNome(nome);

        System.out.println("Digite o nome de usuário para login:");
        String usuario = sc.nextLine();
        novoFuncionario.setUsuario(usuario);

        System.out.println("Digite a senha para login:");
        String senha = sc.nextLine();
        novoFuncionario.setSenha(senha);

        // Carrega os balcões do arquivo JSON
        List<BalcaoFun> balcoes = JsonCinema.lerObjeto(BALCAO_PATH, new TypeToken<List<BalcaoFun>>() {}.getType());

        if (balcoes != null) {
            System.out.println("Balcões carregados com sucesso.");
            System.out.println("Lista de balcões disponíveis:");
            for (BalcaoFun balcao : balcoes) {
                System.out.println("Balcão " + balcao.getIdBalcao());
            }

            System.out.println("Digite o ID do balcão do funcionário:");
            int balcaoId = sc.nextInt();
            sc.nextLine(); // Limpar o buffer do scanner

            BalcaoFun balcaoSelecionado = null;
            // Busca o balcão pelo ID
            for (BalcaoFun balcao : balcoes) {
                if (balcao.getIdBalcao() == balcaoId) {
                    balcaoSelecionado = balcao;
                    break;
                }
            }

            if (balcaoSelecionado != null) {
                novoFuncionario.setBalcaoFun(balcaoSelecionado);

                funcionarios.add(novoFuncionario);

                JsonCinema.escreverObjeto(funcionarios, FILE_PATH);

                System.out.println("Funcionário cadastrado com sucesso!");
            } else {
                System.out.println("Balcão não encontrado.");
            }
        } else {
            System.out.println("Erro ao carregar balcões. Verifique o caminho do arquivo e a estrutura do JSON.");
        }
    }

    public static void selecionarFuncionario() {
        System.out.println("Digite o ID do funcionário que deseja selecionar:");
        int id = sc.nextInt();

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getIdFuncionario() == id) {
                System.out.println("Funcionário encontrado:");
                System.out.println(funcionario);
                return;
            }
        }

        System.out.println("Funcionário não encontrado com o ID fornecido.");
    }

    public static List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
