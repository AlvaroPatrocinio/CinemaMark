package com.cinema;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.util.Iterator;
import com.cinema.Comparator.ClienteComparator;
import com.cinema.Comparator.ClienteFinder;
import com.cinema.Comparator.FilmeComparator;
import com.cinema.cine.Filme;
import com.cinema.cliente.Cliente;
import com.cinema.func.Funcionario;
import com.cinema.produto.Produto;

/**
 * Classe principal que inicia o sistema do cinema.
 */
public class Main {
    
    /**
     * Método principal que inicia o sistema do cinema.
     * @param args Os argumentos da linha de comando (não utilizados neste caso).
     */
    public static void main(String[] args) {

        // Criação da lista de funcionários
        List<Filme> listaFilme = new ArrayList<>();

        // Criação de instâncias da classe Funcionario
        Filme f1 = new Filme("Ta dando onda", "Comédia", "Lucas", "É isso ai pessoal");
        Filme f2 = new Filme("Interestelar", "Drama", "Arthur", "É isso ai pessoal");
        Filme f3 = new Filme("Green", "Cor", "João", "É isso ai pessoal");
        Filme f4 = new Filme("Sempre ao seu lado", "Triste", "Zezinho", "É isso ai pessoal");

        // Adição dos Filmes à lista
        listaFilme.add(f1);
        listaFilme.add(f2);
        listaFilme.add(f3);
        listaFilme.add(f4);

        // Ordenação da lista de filmes com base no nome usando o FuncionarioComparator
        Collections.sort(listaFilme, new FilmeComparator());

        // Impressão dos filmes ordenados por nome
        System.out.println("Filmes ordenados por nome:");
        for (Filme filme : listaFilme) {
            System.out.println(filme);
        }

        System.out.println("-----------------------------");


        // Questão 16/17: Criar um método find para clientes utilizando o interator e comparator.
        Produto produto = new Produto(); // Cliente tem Produto produto no construtor.
        List<Cliente> clientes = new ArrayList<>(List.of(
            new Cliente(1, "Alice Silva", "Endereço 1", "Telefone 1", "Email 1", "CPF 1", "Preferências 1", produto),
            new Cliente(2, "Bob Souza", "Endereço 2", "Telefone 2", "Email 2", "CPF 2", "Preferências 2", produto),
            new Cliente(3, "Carlos Pereira", "Endereço 3", "Telefone 3", "Email 3", "CPF 3", "Preferências 3", produto)
        ));

        Cliente clienteToFind = new Cliente(2, "Bob Souza", "Endereço 2", "Telefone 2", "Email 2", "CPF 2", "Preferências 2", produto);
        ClienteComparator comparator = new ClienteComparator();

        // Ordenando a lista de clientes
        Collections.sort(clientes, comparator);

        //find
        ClienteFinder finder = new ClienteFinder();
        long startTime = System.nanoTime();
        Cliente foundCliente = finder.find(clientes, clienteToFind, comparator);
        long endTime = System.nanoTime();
        long durationFind = endTime - startTime;

        if (foundCliente != null) {
            System.out.println("Cliente encontrado usando find: " + foundCliente);
        } else {
            System.out.println("Cliente não encontrado usando find.");
        }

        //binarySearch
        startTime = System.nanoTime();
        int index = Collections.binarySearch(clientes, clienteToFind, comparator);
        endTime = System.nanoTime();
        long durationBinarySearch = endTime - startTime;

        if (index >= 0) {
            System.out.println("Cliente encontrado usando binarySearch: " + clientes.get(index));
        } else {
            System.out.println("Cliente não encontrado usando binarySearch.");
        }

        // Resultados do tempo
        System.out.println("Tempo de execução do find: " + durationFind + " nanosegundos");
        System.out.println("Tempo de execução do binarySearch: " + durationBinarySearch + " nanosegundos");
    

        // Instanciação do sistema do cinema
        Sistema sistema = new Sistema();

        // Chamada do menu do sistema para administradores
        sistema.menuadm();

    }
}


