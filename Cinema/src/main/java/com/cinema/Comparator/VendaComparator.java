package com.cinema.Comparator;
import java.util.Comparator;
import com.cinema.produto.Venda;

/**
 * Comparador para ordenar objetos Venda com base no nome.
 */
public class VendaComparator implements Comparator<Venda> {

    /**
     * Compara dois objetos Venda com base nos nomes.
     *
     * @param f1 o primeiro objeto Venda
     * @param f2 o segundo objeto Venda
     * @return um valor negativo, zero ou um valor positivo, conforme o nome do primeiro objeto seja menor que, igual a, ou maior que o segundo
     */

    //Questão 13: Implementar a interface Comparator para as classes Filme e Venda e fazer comparações por diferentes atributos.
    @Override
    public int compare(Venda f1, Venda f2) {
        Integer quantidade1 = f1.getQuantidadeVendida();
        Integer quantidade2 = f2.getQuantidadeVendida();
        return quantidade1.compareTo(quantidade2);
    }
}