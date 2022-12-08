package Projeto;

import java.util.ArrayList;

public class Material {
    private int id;
    private String nome;
    private String cabecalho;
    public ArrayList<Pedido>pedidos=new ArrayList<Pedido>();
    public ArrayList<Avaria>avarias=new ArrayList<Avaria>();
    public  ArrayList<Consumivel>consumiveis=new ArrayList<Consumivel>();

    public Material(int id,String nome,String cabecalho){
        this.id=id;
        this.nome=nome;
        this.cabecalho=cabecalho;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCabecalho() {
        return cabecalho;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public ArrayList<Avaria> getAvarias() {
        return avarias;
    }

    public ArrayList<Consumivel> getConsumiveis() {
        return consumiveis;
    }
}
