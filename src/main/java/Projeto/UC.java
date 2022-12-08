package Projeto;

import java.util.ArrayList;

public class UC {
    private String nome;
    public ArrayList<Pedido>pedidos=new ArrayList<Pedido>();

    public UC(String nome){
        this.nome=nome;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}
