package Projeto;

public class Consumivel {
    private int id;
    private String nome;
    private int quantidade;

    public Consumivel(int id, String nome, int quantidade){
        this.id=id;
        this.nome=nome;
        this.quantidade=quantidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Consumivel{" +
                "id=" + id +
                '}';
    }
}
