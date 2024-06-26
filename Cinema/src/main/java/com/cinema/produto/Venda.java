package com.cinema.produto;

import com.cinema.JsonCinema;
import com.cinema.cliente.Cliente;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Venda {
    private Produto produto; // Produto vendido
    private int quantidadeVendida; // Quantidade vendida do produto
    private Cliente cliente; // Cliente que realizou a compra
    private String tipoBalcao; // Tipo de balcão utilizado para a venda


    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Construtor para criar uma nova venda com todos os detalhes especificados.
     *
     * @param produto           O produto vendido.
     * @param quantidadeVendida A quantidade vendida do produto.
     * @param cliente           O cliente que realizou a compra.
     * @param tipoBalcao        O tipo de balcão utilizado para a venda.
     */
    public Venda(Produto produto, int quantidadeVendida, Cliente cliente, String tipoBalcao) {
        this.produto = produto;
        this.quantidadeVendida = quantidadeVendida;
        this.cliente = cliente;
        this.tipoBalcao = tipoBalcao;
    }

    /**
     * Retorna o tipo de balcão utilizado para a venda.
     *
     * @return O tipo de balcão.
     */
    public String getTipoBalcao() {
        return tipoBalcao;
    }

    /**
     * Define o tipo de balcão utilizado para a venda.
     *
     * @param tipoBalcao O novo tipo de balcão.
     */
    public void setTipoBalcao(String tipoBalcao) {
        this.tipoBalcao = tipoBalcao;
    }


     /**
     * Construtor padrão para criar uma venda.
     */
    public Venda() {
    }

    /**
     * Retorna o produto vendido.
     *
     * @return O produto vendido.
     */
    public Produto getProduto() {
        return produto;
    }

     /**
     * Define o produto vendido.
     *
     * @param produto O novo produto vendido.
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

     /**
     * Retorna a quantidade vendida do produto.
     *
     * @return A quantidade vendida.
     */
    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    /**
     * Define a quantidade vendida do produto.
     *
     * @param quantidadeVendida A nova quantidade vendida.
     */
    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    /**
     * Retorna o cliente que realizou a compra.
     *
     * @return O cliente.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Define o cliente que realizou a compra.
     *
     * @param cliente O novo cliente.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    //Questão número 14: Salve e recupere todas as informações dos Clientes, Filmes, Produtos, Vendas, colaboradores e Estoque em um arquivo de texto.
    //Caminhos JSON
    private static final String VENDA_PATH = "C:\\Users\\Álvaro Soares\\Documents\\GitHub\\CineMark\\CineMark\\CinemaMark\\Cinema\\src\\main\\resources\\arquivosjson\\vendas.json";
    private static final String PRODUTO_PATH = "C:\\Users\\Álvaro Soares\\Documents\\GitHub\\CineMark\\CineMark\\CinemaMark\\Cinema\\src\\main\\resources\\arquivosjson\\produtos.json";
    private static final String CLIENTE_PATH = "C:\\Users\\Álvaro Soares\\Documents\\GitHub\\CineMark\\CineMark\\CinemaMark\\Cinema\\src\\main\\resources\\arquivosjson\\clientes.json";
    private static final String BALCAOAUT_PATH = "C:\\Users\\Álvaro Soares\\Documents\\GitHub\\CineMark\\CineMark\\CinemaMark\\Cinema\\src\\main\\resources\\arquivosjson\\balcaoAut.json";
    private static final String BALCAOFUN_PATH = "C:\\Users\\Álvaro Soares\\Documents\\GitHub\\CineMark\\CineMark\\CinemaMark\\Cinema\\src\\main\\resources\\arquivosjson\\funcionarios.json";




    /**
     * Realiza uma venda, solicitando detalhes ao usuário.
     */
    public static void realizarVenda() {

        System.out.println("Selecione o tipo de balcão:");
        System.out.println("1 - Balcão Automático");
        System.out.println("2 - Balcão com Funcionário");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        String balcaoUtilizado;
        switch (escolha) {
            case 1:
                balcaoUtilizado = "Balcão Automático";
                break;
            case 2:
                balcaoUtilizado = "Balcão com Funcionário";
                break;
            default:
                System.out.println("Escolha inválida.");
                return;
        }

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
                    // Carrega os clientes do arquivo JSON
                    List<Cliente> clientes = JsonCinema.lerObjeto(CLIENTE_PATH, new TypeToken<List<Cliente>>() {}.getType());

                    if (clientes != null) {
                        System.out.println("Clientes carregados com sucesso.");
                        System.out.println("Lista de clientes disponíveis:");
                        for (Cliente cliente : clientes) {
                            System.out.println(cliente.getIdCliente() + ": " + cliente.getNomeCompleto());
                        }

                        System.out.println("Digite o ID do cliente que está realizando a compra:");
                        int clienteId = scanner.nextInt();

                        Cliente clienteSelecionado = null;
                        // Busca o cliente pelo ID
                        for (Cliente cliente : clientes) {
                            if (cliente.getIdCliente() == clienteId) {
                                clienteSelecionado = cliente;
                                break;
                            }
                        }

                        if (clienteSelecionado != null) {
                            // Atualiza a quantidade em estoque após a venda
                            produtoVendido.setQuantidadeEstoque(produtoVendido.getQuantidadeEstoque() - quantidadeVendida);

                            // Escreve a lista atualizada no arquivo JSON de produtos
                            JsonCinema.escreverObjeto(produtos, PRODUTO_PATH);

                            // Cria a venda e escreve no arquivo de vendas
                            Venda venda = new Venda(produtoVendido, quantidadeVendida, clienteSelecionado, balcaoUtilizado);
                            //Questão número 5: O sistema deverá armazenar de forma estática os 5 balcões do cinema.
                            venda.setTipoBalcao(balcaoUtilizado);
                            List<Venda> vendas = new ArrayList<>();
                            vendas.add(venda);

                            JsonCinema.escreverObjeto(vendas, VENDA_PATH);


                            System.out.println("Venda realizada com sucesso.");
                        } else {
                            System.out.println("Cliente não encontrado.");
                        }
                    } else {
                        System.out.println("Erro ao carregar clientes. Verifique o caminho do arquivo e a estrutura do JSON.");
                    }
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

     /**
     * Retorna uma representação em string do objeto Venda.
     *
     * @return Uma string que representa o objeto Venda.
     */
    @Override
    public String toString() {
        return "Venda{" +
                "produto=" + produto +
                ", quantidadeVendida=" + quantidadeVendida +
                ", cliente=" + cliente +
                '}';
    }
}
