package Projeto;

public class Avaria {
    private int id;
    private String descricao;
    private String dataAvaria;

    public Avaria(int id,String descricao,String dataAvaria){
        this.id=id;
        this.descricao=descricao;
        this.dataAvaria=dataAvaria;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDataAvaria() {
        return dataAvaria;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
