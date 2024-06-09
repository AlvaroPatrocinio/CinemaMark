package com.cinema.Comparator;
import java.util.Comparator;
import com.cinema.cliente.Cliente;

public class ClienteComparator implements Comparator<Cliente> {
    @Override
    public int compare(Cliente c1, Cliente c2) {
        
        return c1.getNomeCompleto().compareTo(c2.getNomeCompleto());

    }
}
