package com.cinema.produto;

import com.cinema.JsonCinema;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Scanner;

public class Venda {
    private Produto produto;
    private int quantidadeVendida;

    private static final Scanner scanner = new Scanner(System.in);

    public Venda(Produto produto, int quantidadeVendida) {
        this.produto = produto;
        this.quantidadeVendida = quantidadeVendida;
    }

    public Venda() {
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    private static final String VENDA_PATH = "/home/joeum/Projetos GITHUB REPO/CinemaMark/Cinema/src/main/resources/arquivosjson/vendas.json";
    private static final String PRODUTO_PATH = "/home/joeum/Projetos GITHUB REPO/CinemaMark/Cinema/src/main/resources/arquivosjson/produtos.json";

    public static void realizarVenda() {
        // Carrega os produtos do arquivo JSON
        List<Produto> produtos = JsonCinema.lerObjeto(PRODUTO_PATH, new TypeToken<List<Produto>>() {}.getType());

        if (produtos != null) {
            System.out.println("Produtos carregados com sucesso.");
            System.out.println("Lista de produtos disponíveis:");
            for (Produto produto : produtos) {
                System.out.println(produto.getProdutoId() + ": " + produto.getNome());
            }

            System.out.println("Digite o ID do produto que deseja vender:");
            int produtoId = scanner.nextInt();

            System.out.println("Digite a quantidade a ser vendida:");
            int quantidadeVendida = scanner.nextInt();

            Produto produtoVendido = null;
            // Busca o produto pelo ID
            for (Produto produto : produtos) {
                if (produto.getProdutoId() == produtoId) {
                    produtoVendido = produto;
                    break;
                }
            }

            if (produtoVendido != null) {
                // Verifica se há quantidade suficiente em estoque
                if (produtoVendido.getQuantidadeEstoque() >= quantidadeVendida) {
                    // Atualiza a quantidade em estoque após a venda
                    produtoVendido.setQuantidadeEstoque(produtoVendido.getQuantidadeEstoque() - quantidadeVendida);

                    // Escreve a lista atualizada no arquivo JSON de produtos
                    JsonCinema.escreverObjeto(produtos, PRODUTO_PATH);

                    // Cria a venda e escreve no arquivo de vendas
                    Venda venda = new Venda(produtoVendido, quantidadeVendida);
                    JsonCinema.escreverObjetoUnico(venda, VENDA_PATH);

                    System.out.println("Venda realizada com sucesso.");
                } else {
                    System.out.println("Quantidade insuficiente em estoque.");
                }
            } else {
                System.out.println("Produto não encontrado.");
            }
        } else {
            System.out.println("Erro ao carregar produtos. Verifique o caminho do arquivo e a estrutura do JSON.");
        }
    }
}
