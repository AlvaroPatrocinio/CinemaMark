package com.cinema.produto;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * Representa o estoque de produtos, mantendo uma lista de itens de estoque.
 */

// vai faltar um metodo para dar baixa no estoque de a cordo com a venda
public class Estoque {
    private List<Produto> produtos = new ArrayList<>();
    private List<ItemEstoque> itensEstoque;

    public Estoque() {
        this.itensEstoque = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida. Adicione uma quantidade válida.");
            return;
        }
        ItemEstoque item = encontrarItemPorProduto(produto);
        if (item != null) {
            item.adicionarQuantidade(quantidade);
        } else {
            itensEstoque.add(new ItemEstoque(produto, quantidade));
        }
        System.out.println(quantidade + " unidades de " + produto.getNome() + " adicionadas ao estoque.");
    }

    public ItemEstoque encontrarItemPorProduto(Produto produto) {
        for (ItemEstoque item : itensEstoque) {
            if (item.getProduto().equals(produto)) {
                return item;
            }
        }
        return null;
    }

    public void removerProduto(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida. Insira uma quantidade positiva.");
            return;
        }
        ItemEstoque item = encontrarItemPorProduto(produto);
        if (item != null && item.getQuantidade() >= quantidade) {
            item.removerQuantidade(quantidade);
            System.out.println(quantidade + " unidades de " + produto.getNome() + " removidas do estoque.");
        } else {
            System.out.println("Produto não encontrado ou quantidade insuficiente em estoque.");
        }
    }

    public void exibirEstoque() {
        System.out.println("---- Estoque Atual ----");
        for (ItemEstoque item : itensEstoque) {
            System.out.println(item.getProduto().toString() + " - Quantidade em estoque: " + item.getQuantidade() + " unidades.");
        }
    }

    public int verificarEstoque(Produto produto) {
        ItemEstoque item = encontrarItemPorProduto(produto);
        if (item != null) {
            int quantidade = item.getQuantidade();
            System.out.println("Quantidade de " + produto.getNome() + " em estoque: " + quantidade + " unidades.");
            return quantidade;
        }
        return 0;
    }

    public List<Produto> getProdutos() {
        List<Produto> produtos = new ArrayList<>();
        for (ItemEstoque item : itensEstoque) {
            produtos.add(item.getProduto());
        }
        return produtos;
    }

    /**
     * Método para gerar um alerta se algum produto está abaixo do estoque mínimo ou próximo da data de validade.
     *
     * @param estoqueMinimo Quantidade mínima de estoque para considerar como alerta de estoque baixo
     * @return Uma lista de strings indicando os alertas para os produtos, ou uma lista vazia se não houver alertas
     */
    public List<String> alerta(int estoqueMinimo) {
        List<String> alertas = new ArrayList<>();

        Date hoje = new Date(); // Data atual

        for (Produto produto : produtos) {
            if (produto.getQuantidadeEstoque() <= estoqueMinimo) {
                alertas.add("O produto " + produto.getNome() + " está acabando. Quantidade em estoque: " + produto.getQuantidadeEstoque());
            }

            long diasRestantes = calcularDiasRestantes(produto.getDataValidade(), hoje);
            if (diasRestantes <= 30) {
                alertas.add("O produto " + produto.getNome() + " está próximo da data de validade. Dias restantes: " + diasRestantes);
            }
        }

        return alertas;
    }

    /**
     * Método privado para calcular os dias restantes até a data de validade.
     *
     * @param dataValidade Data de validade do produto
     * @param hoje Data atual
     * @return Número de dias restantes até a data de validade
     */
    private long calcularDiasRestantes(Date dataValidade, Date hoje) {
        long diffEmMilissegundos = dataValidade.getTime() - hoje.getTime();
        return diffEmMilissegundos / (24 * 60 * 60 * 1000);
    }


    @Override
    public String toString() {
        return "Estoque{" +
                "Lista de estoque ='" + itensEstoque + '\'' +
                '}';

}
}