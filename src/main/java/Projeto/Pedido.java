package Projeto;

import java.util.ArrayList;

public class Pedido {
    private int id;
    private String dataPedido;
    private String dataDevolucao;
    public ArrayList<Material>materiais=new ArrayList<Material>();

    public Pedido(int id,String dataPedido, ArrayList<Material>materiais){
        this.id=id;
        this.dataPedido=dataPedido;
        this.materiais = materiais;
    }

    public int getId() {
        return id;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public ArrayList<Material> getMateriais() {
        return materiais;
    }

    public void setMateriais(ArrayList<Material> materiais) {
        this.materiais = materiais;
    }
}
