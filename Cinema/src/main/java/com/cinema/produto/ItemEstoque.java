package com.cinema.produto;

/**
 * Representa um item de estoque que inclui um produto e sua quantidade.
 */
public class ItemEstoque {
    private Produto produto;
    private int quantidade;

    public ItemEstoque(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void adicionarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    public void removerQuantidade(int quantidade) {
        this.quantidade -= quantidade;
    }

@Override
    public String toString() {
    return "ItemEstoque{" +
            "produto=" + produto +
            ", quantidade=" + quantidade +
            '}';
}
}
