package com.cinema;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.util.Iterator;
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

        

        // Instanciação do sistema do cinema
        Sistema sistema = new Sistema();

        // Chamada do menu do sistema para administradores
        sistema.menuadm();

    }
}

