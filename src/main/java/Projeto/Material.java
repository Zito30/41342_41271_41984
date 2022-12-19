package Projeto;

import java.util.ArrayList;

public class Material {
    private String etiqueta;
    private String nome;
    private String cabecalho;
    private int tipo;
    public ArrayList<Pedido>pedidos=new ArrayList<Pedido>();
    public ArrayList<Avaria>avarias=new ArrayList<Avaria>();
    public  ArrayList<Consumivel>consumiveis=new ArrayList<Consumivel>();

    public Material(String etiqueta,String nome,String cabecalho){
        this.etiqueta=etiqueta;
        this.nome=nome;
        this.cabecalho=cabecalho;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public String getNome() {
        return nome;
    }

    public String getCabecalho() {
        return cabecalho;
    }

    public int getTipo(){return tipo;}

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
