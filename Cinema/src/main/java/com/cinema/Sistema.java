package com.cinema;

import com.cinema.balcao.BalcaoAut;
import com.cinema.balcao.BalcaoFun;
import com.cinema.cine.Filme;
import com.cinema.cine.Ingresso;
import com.cinema.cine.Sala;
import com.cinema.cine.Sessao;
import com.cinema.cliente.Cliente;
import com.cinema.func.Administrador;
import com.cinema.func.Funcionario;
import com.cinema.func.Login;
import com.cinema.produto.Produto;
import com.cinema.produto.Venda;

import java.util.Scanner;

public class Sistema {

    private static Scanner input = new Scanner(System.in);
    private static Scanner input2 = new Scanner(System.in);

    Cliente cliente = new Cliente();
    Produto produto = new Produto();
    Filme filme = new Filme();
    Funcionario funcionario = new Funcionario();
    Administrador administrador = new Administrador();
    Sala sala = new Sala();
    Sessao sessao = new Sessao();
    Ingresso ingresso = new Ingresso();
    Venda venda = new Venda();
    Login login = new Login();
    BalcaoFun balcaoFun = new BalcaoFun();
    BalcaoAut balcaoAut = new BalcaoAut();
    Relatorio relatorio = new Relatorio();

    private static Sistema instance;

    public static Sistema getInstance() {
        if (instance == null) {
            instance = new Sistema();
        }
        return instance;
    }


    private static void exibirInicio() {
        System.out.println("----------------------------------------------");
        System.out.println("-----------------CineMark---------------------");
        System.out.println("----------------------------------------------");
        System.out.println("----------------------------------------------");
    }

    public void menuadm() {
        System.out.println("----------------------------------------------");
        System.out.println("-----------Bem vindo ao CineMark--------------");
        System.out.println("----------------------------------------------");
        System.out.println("**********Selecione a Opção desejada**********");
        System.out.println("----------------------------------------------");
        System.out.println("/    Opção 1 - Venda     /");
        System.out.println("/    Opção 2 - Ver Sessões    /");
        System.out.println("/    Opção 3 - Relatorios     /");
        System.out.println("/    Opção 4 - Cadastros     /");
        System.out.println("/    Opção 5 - Sair     /");

        int option = input.nextInt();

        switch (option) {
            case 1:
                //Questão número 10: Cada venda efetuada vai gerar um extrato que deverá ser impresso e salvo junto com a informação do cliente que fez a compra
                login.realizarLogin();
                menuVendas();
                break;
            case 2:
                menuSessoes();
                break;
            case 3:
                login.realizarLoginAdmin();
                menuRelatorios();
                break;
            case 4:
                login.realizarLoginAdmin();
                menuCadastros();
                break;
            case 5:
                System.out.println("---Obrigado pela preferência! Volte Sempre!---");
                System.exit(0);
                break;
            default:
                System.out.println("------------Opção Inválida!------------");
                menuadm();
                break;
        }
    }

    //Questão número 10: Cada venda efetuada vai gerar um extrato que deverá ser impresso e salvo junto com a informação do cliente que fez a compra.
    private void menuVendas(){
        exibirInicio();
        System.out.println("----------------------------------------------");
        System.out.println("----------------------------------------------");
        System.out.println("**********Selecione a Opção desejada**********");
        System.out.println("----------------------------------------------");
        System.out.println("/    Opção 1 - Comprar Ingressos       /");
        System.out.println("/    Opção 2 - Comprar Produtos       /");
        System.out.println("/    Opção 3 - Menu Anterior     /");


        int option1 = input2.nextInt();
        switch (option1) {
            case 1:
                ingresso.comprarIngresso();
                System.out.println("----------------------------------------------");
                System.out.println("--------Ingresso Comprado com Sucesso---------");
                System.out.println("----------------------------------------------");
                System.out.println("----------------------------------------------");
                menuVendas();
                break;

            case 2:
                venda.realizarVenda();
                menuVendas();
                break;
            case 3:
                menuadm();
                break;
            default:
                System.out.println("------------Opção Inválida!------------");
                menuVendas();
                break;
        }
    }


    private void menuSessoes() {
        exibirInicio();
        System.out.println("----------------------------------------------");
        System.out.println("----------------------------------------------");
        System.out.println("**********Selecione a Opção desejada**********");
        System.out.println("----------------------------------------------");
        System.out.println("/    Opção 1 - Ver Sessões Disponíveis       /");
        System.out.println("/    Opção 2 - Menu Anterior     /");

        int option2 = input2.nextInt();
        switch (option2) {
            case 1:
                sessao.visualizarSessoes();
                System.out.println("----------------------------------------------");
                System.out.println("--------Sessão Selecionada com Sucesso--------");
                System.out.println("----------------------------------------------");
                System.out.println("----------------------------------------------");
                menuSessoes();
                break;
            case 2:
                menuadm();
                break;
            default:
                System.out.println("------------Opção Inválida!------------");
                menuSessoes();
                break;
        }
    }

    private void menuRelatorios() {
        exibirInicio();
        System.out.println("----------------------------------------------");
        System.out.println("----------------------------------------------");
        System.out.println("**********Selecione a Opção desejada**********");
        System.out.println("----------------------------------------------");
        System.out.println("/    Opção 1 - Exibir Relatório       /");
        System.out.println("/    Opção 2 - Menu Anterior     /");


        int option1 = input2.nextInt();
        switch (option1) {
            case 1:
                //Questçao número 8: Verificar e imprimir dados das vendas e dos clientes;
                relatorio.exibirRelatorio();
                System.out.println("----------------------------------------------");
                System.out.println("--------Relatorio Exibido com Sucesso---------");
                System.out.println("----------------------------------------------");
                System.out.println("----------------------------------------------");
                menuRelatorios();
                break;

            case 2:
                menuadm();
                break;
        }
    }

    private void menuCadastros() {
        System.out.println("----------------------------------------------");
        System.out.println("----------------------------------------------");
        System.out.println("**********Selecione a Opção desejada**********");
        System.out.println("----------------------------------------------");
        System.out.println("/    Opção 1 - Cadastro de Produto     /");
        System.out.println("/    Opção 2 - Cadastro de Filmes    /");
        System.out.println("/    Opção 3 - Cadastro de Cliente     /");
        System.out.println("/    Opção 4 - Cadastro de Funcionário     /");
        System.out.println("/    Opção 5 - Cadastro de Administrador     /");
        System.out.println("/    Opção 6 - Cadastro de Salas     /");
        System.out.println("/    Opção 7 - Cadastro de Sessões     /");
        System.out.println("/    Opção 8 - Cadastro de Balcão com Funcionario     /");
        System.out.println("/    Opção 9 - Cadastro de Balcão Automatico     /");
        System.out.println("/    Opção 10 - Menu Anterior     /");

        int option4 = input2.nextInt();
        switch (option4) {
            case 1:
                produto.cadastrarProduto(produto);
                System.out.println("----------------------------------------------");
                System.out.println("--------Produto Cadastrado com Sucesso--------");
                System.out.println("----------------------------------------------");
                System.out.println("----------------------------------------------");
                menuCadastros();
                break;
            case 2:
                filme.cadastrarFilme(filme);
                System.out.println("----------------------------------------------");
                System.out.println("--------Filme Cadastrado com Sucesso--------");
                System.out.println("----------------------------------------------");
                System.out.println("----------------------------------------------");
                menuCadastros();
                break;
            case 3:
                //Questão número 7: Cadastrar, alterar ou excluir clientes;
                cliente.cadastrarCliente(cliente);
                System.out.println("----------------------------------------------");
                System.out.println("--------Cliente Cadastrado com Sucesso--------");
                System.out.println("----------------------------------------------");
                System.out.println("----------------------------------------------");
                menuCadastros();
                break;
            case 4:
                //Questão número 6: Deve ser possível cadastrar os colaboradores no sistema, alterar ou editar seusatributos;
                funcionario.cadastrarFuncionario();
                System.out.println("----------------------------------------------");
                System.out.println("--------Funcionário Cadastrado com Sucesso----");
                System.out.println("----------------------------------------------");
                System.out.println("----------------------------------------------");
                menuCadastros();
                break;
            case 5:
                administrador.cadastrarAdministrador();
                System.out.println("----------------------------------------------");
                System.out.println("--------Administrador Cadastrado com Sucesso--");
                System.out.println("----------------------------------------------");
                System.out.println("----------------------------------------------");
                menuCadastros();
                break;
            case 6:
                sala.cadastrarSala(sala);
                System.out.println("----------------------------------------------");
                System.out.println("-----------------Sala Cadastrada com Sucesso--");
                System.out.println("----------------------------------------------");
                System.out.println("----------------------------------------------");
                menuCadastros();
                break;
            case 7:
                sessao.cadastrarSessao();
                System.out.println("----------------------------------------------");
                System.out.println("--------Sessão Cadastrada com Sucesso---------");
                System.out.println("----------------------------------------------");
                System.out.println("----------------------------------------------");
                menuCadastros();
                break;
            case 8:
                balcaoFun.cadastrarBalcao();
                System.out.println("----------------------------------------------");
                System.out.println("--------Sessão Cadastrada com Sucesso---------");
                System.out.println("----------------------------------------------");
                System.out.println("----------------------------------------------");
                menuCadastros();
                break;
            case 9:
                balcaoAut.cadastrarBalcao();
                System.out.println("----------------------------------------------");
                System.out.println("--------Sessão Cadastrada com Sucesso---------");
                System.out.println("----------------------------------------------");
                System.out.println("----------------------------------------------");
                menuCadastros();
                break;
            case 10:
                menuadm();
                break;
            default:
                System.out.println("------------Opção Inválida!------------");
                menuCadastros();
                break;
        }
    }
}
