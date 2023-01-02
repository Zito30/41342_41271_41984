package Projeto;

import java.util.ArrayList;

public class Pessoa {
    private int id;
    private String nome;
    private String cc;
    private int idade;
    public ArrayList<Pedido>pedidos=new ArrayList<Pedido>();

    public Pessoa(String nome, String cc, int idade, int id) {
        this.nome = nome;
        this.cc = cc;
        this.idade = idade;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCc() {
        return cc;
    }

    public int getIdade() {
        return idade;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}
