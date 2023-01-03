package Projeto;

import java.util.ArrayList;

public class Pedido {
    private int idPedido;
    private int idPessoa;
    private String dataPedido;
    private String dataDevolucao="";
    public ArrayList<Material>materiais=new ArrayList<Material>();

    public Pedido(int idPessoa,int idPedido,String dataPedido,ArrayList<Material>materiais){
        this.idPedido=idPedido;
        this.dataPedido=dataPedido;
        this.materiais = materiais;
    }

    public int getId() {
        return idPedido;
    }
    public int getPessoa(){return idPessoa;}

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

    public Pedido setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
        return this;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + idPedido +
                '}';
    }
}
