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

    public Material(String etiqueta,String nome,String cabecalho,int tipo){
        this.etiqueta=etiqueta;
        this.nome=nome;
        this.cabecalho=cabecalho;
        this.tipo=tipo;
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


    public void adicionarConsumivel(String nome, int quantidade){
        int idConsumivel = consumiveis.size()+1;
        int flagExiste=0;
        for(Consumivel c:consumiveis){
            if(c.getNome().equals(nome)){
                flagExiste=1;
                int existiam=c.getQuantidade();
                c.setQuantidade(c.getQuantidade()+quantidade);
                System.out.println("Consumivel adicionado com sucesso.");
                System.out.println("Existiam: "+existiam+ "e agora existem:"+c.getQuantidade()+" (adicionou "+quantidade+")");
                break;
            }
        }

        if(flagExiste==0){
            Consumivel c = new Consumivel(idConsumivel,nome,quantidade);
            consumiveis.add(c);
        }

    }

    public void removerConsumivel(String nome, int quantidade){
        int flagExiste=0;
        for(Consumivel c:consumiveis){
            if(c.getNome().equals(nome)){
                flagExiste=1;
                if(quantidade<=c.getQuantidade()){
                    c.setQuantidade(c.getQuantidade()-quantidade);
                    System.out.println("Consumivel removido com sucesso.");
                }
                else{
                    System.out.println("Está a remover mais do que os que existem.");
                    System.out.println("Existem: "+c.getQuantidade()+ "a tentar remover:"+quantidade);
                }
                break;
            }
        }

        if(flagExiste==0){
            System.out.println("Consumível não existe.");
        }

    }

    public void adicionarPedido(int idPessoa,int id,String data,ArrayList<Material>materiais){
        int idPedidos = pedidos.size()+1;
        int flagExiste=0;
        for(Pedido c:pedidos){
            if(c.getId()==id){
                flagExiste=1;
                break;
            }
        }

        if(flagExiste==0){
            Pedido p=new Pedido(idPessoa, id, data, materiais);
            pedidos.add(p);
        }
    }

    public void adicionarAnomalia(int id, String descricao, String dataDaAvaria){
        int idAnomalias =avarias.size()+1;
        int flagExiste=0;
        for(Avaria a:avarias){
            if(a.getId()==id){
                flagExiste=1;
                break;
            }
        }

        if(flagExiste==0){
            Avaria a=new Avaria(id,descricao,dataDaAvaria);
            avarias.add(a);
        }
    }


    @Override
    public String toString() {
        return "Material{" +
                "etiqueta='" + etiqueta + '\'' +
                ", nome='" + nome + '\'' +
                ", cabecalho='" + cabecalho + '\'' +
                ", tipo=" + tipo +
                ", pedidos=" + pedidos +
                ", avarias=" + avarias +
                ", consumiveis=" + consumiveis +
                '}';
    }
}
