package com.cinema;
import com.cinema.produto.Venda;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

public class Relatorio {

    private Venda venda;

    public Relatorio(Venda venda) {
        this.venda = venda;
    }

    public Relatorio(){

    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }


    private static final String VENDA_PATH = "C:\\Users\\Álvaro Soares\\Documents\\GitHub\\CineMark\\CineMark\\CinemaMark\\Cinema\\src\\main\\resources\\arquivosjson\\vendas.json";
    
    //Questão número 8: Verificar e imprimir dados das vendas e dos clientes;
    public static void exibirRelatorio() {
        List<Venda> vendas = new ArrayList<>();
        vendas = JsonCinema.lerObjeto(VENDA_PATH, new TypeToken<List<Venda>>() {}.getType());

        if (vendas != null) {
            for (Venda venda : vendas) {
                System.out.println(venda);
            }
        } else {
            System.out.println("Não foi possível ler o arquivo de vendas.");
        }
    }
}
