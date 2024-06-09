package com.cinema.Comparator;
import java.util.Comparator;
import com.cinema.cine.Filme;

/**
 * Comparador para ordenar objetos Filme com base no ID.
 * 
 * Essa classe implementa a interface Comparator, permitindo a comparação de objetos Filme.
 */
public class FilmeComparator implements Comparator<Filme> {
    /**
     * Compara dois objetos Filme com base no ID.
     *
     * @param f1 o primeiro objeto Filme
     * @param f2 o segundo objeto Filme
     * @return um valor negativo, zero ou um valor positivo, conforme o ID do primeiro objeto seja menor que, igual a, ou maior que o segundo
     */
    
    //Questão 13: Implementar a interface Comparator para as classes Filme e Venda e fazer comparações por diferentes atributos.
    @Override
    public int compare(Filme f1, Filme f2) {
       return f1.getNome().compareTo(f2.getNome());
    }
}