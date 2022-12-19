package Projeto;

public class PessoaFactory {

    public Pessoa criarPessoa(int id, String nome, int cc, int idade) {
        return new Pessoa(id, nome, cc, idade);
    }

}
