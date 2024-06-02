package com.cinema;
import com.cinema.cine.Filme;
import com.cinema.cliente.Cliente;
import com.cinema.func.Administrador;
import com.cinema.func.Funcionario;
import com.cinema.produto.Produto;
import java.util.Scanner;

public class Sistema {
 private static Scanner input = new Scanner(System.in);
 private static Scanner input2 = new Scanner(System.in);
 Cliente cliente = new Cliente();
 Produto produto = new Produto();
 Filme filme = new Filme();
 Funcionario funcionario = new Funcionario();
 Administrador administrador = new Administrador();

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

        switch (option){
default:
            System.out.println("------------Opção Inválida!------------");

        //Case 4: Menu de cadastros - Atenção na concatenação do switch, ele confunde devido ser switch dentro de switch.
        case 4:
            exibirInicio();
            System.out.println("----------------------------------------------");
            System.out.println("----------------------------------------------");
            System.out.println("**********Selecione a Opção desejada**********");
            System.out.println("----------------------------------------------");
            System.out.println("/    Opção 1 - Cadastro de Produto     /");
            System.out.println("/    Opção 2 - Cadastro de Filmes    /");
            System.out.println("/    Opção 3 - Cadastro de Cliente     /");
            System.out.println("/    Opção 4 - Cadastro de Funcionário     /");
            System.out.println("/    Opção 5 - Cadastro de Administrador     /");
            System.out.println("/    Opção 6 - Menu Anterior     /");

                int option1 = input2.nextInt();
                switch (option1){

            case 1:
                produto.cadastrarProduto(produto);
                System.out.println("----------------------------------------------");
                System.out.println("--------Produto Cadastrado com Sucesso--------");
                System.out.println("----------------------------------------------");
                System.out.println("----------------------------------------------");
                menuadm();

            case 2:
                filme.cadastrarFilme(filme);
                System.out.println("----------------------------------------------");
                System.out.println("--------Filme Cadastrado com Sucesso--------");
                System.out.println("----------------------------------------------");
                System.out.println("----------------------------------------------");
                menuadm();    

            case 3:
                cliente.cadastrarCliente(cliente);
                System.out.println("----------------------------------------------");
                System.out.println("--------Cliente Cadastrado com Sucesso--------");
                System.out.println("----------------------------------------------");
                System.out.println("----------------------------------------------");
                menuadm();    
            
            case 4:
                funcionario.cadastrarFuncionario();
                System.out.println("----------------------------------------------");
                System.out.println("--------Funcionario Cadastrado com Sucesso----");
                System.out.println("----------------------------------------------");
                System.out.println("----------------------------------------------");
                menuadm();  
            case 5:
                administrador.cadastrarAdministrador();
                System.out.println("----------------------------------------------");
                System.out.println("--------Administrador Cadastrado com Sucesso--");
                System.out.println("----------------------------------------------");
                System.out.println("----------------------------------------------");
                menuadm();  
            
            case 6:
            menuadm();                       
            }
case 5:
        System.out.println("---Obrigado pela preferência! Volte Sempre!---");
        System.exit(0); 
        }
       
    }
}