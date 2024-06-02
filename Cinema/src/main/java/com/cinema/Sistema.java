package com.cinema;

import com.cinema.cliente.Cliente;
import com.cinema.produto.Produto;

import java.util.Scanner;

public class Sistema {
 private static Scanner input = new Scanner(System.in);
 private static Scanner input2 = new Scanner(System.in);
 Cliente cliente = new Cliente();
 Produto produto = new Produto();

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

                int option1 = input2.nextInt();
                switch (option1){

            case 3:
                cliente.cadastrarCliente(cliente);
                System.out.println("----------------------------------------------");
                System.out.println("--------Cliente Cadastrado com Sucesso--------");
                System.out.println("----------------------------------------------");
                System.out.println("----------------------------------------------");
                menuadm();

            case 1:
                produto.cadastrarProduto(produto);
                System.out.println("----------------------------------------------");
                System.out.println("--------Produto Cadastrado com Sucesso--------");
                System.out.println("----------------------------------------------");
                System.out.println("----------------------------------------------");
                menuadm();
                       
            }
case 5:
        System.out.println("---Obrigado pela preferência! Volte Sempre!---");
        System.exit(0); 
        }
       
    }
}