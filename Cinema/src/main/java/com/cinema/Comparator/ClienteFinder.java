package com.cinema.Comparator;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import com.cinema.cliente.Cliente;

public class ClienteFinder {

    /**
     * Encontra um cliente na lista de clientes utilizando um comparator para comparação.
     *
     * @param clientes      a lista de clientes onde procurar
     * @param clienteToFind o cliente a ser encontrado
     * @param comparator    o comparator a ser utilizado para comparação
     * @return o cliente encontrado ou null se não encontrado
     */
    public Cliente find(List<Cliente> clientes, Cliente clienteToFind, Comparator<Cliente> comparator) {
        Iterator<Cliente> iterator = clientes.iterator();
        
        while (iterator.hasNext()) {
            Cliente currentCliente = iterator.next();
            if (comparator.compare(currentCliente, clienteToFind) == 0) {
                return currentCliente;
            }
        }
        
        return null; // Cliente não encontrado
    }
}