package com.cinema;


/**
 * Classe principal que inicia o sistema do cinema.
 */
public class Main {
    
    /**
     * Método principal que inicia o sistema do cinema.
     * @param args Os argumentos da linha de comando (não utilizados neste caso).
     */
    public static void main(String[] args) {

        // Instanciação do sistema do cinema
        Sistema sistema = new Sistema();

        // Chamada do menu do sistema para administradores
        sistema.menuadm();

    }
}

