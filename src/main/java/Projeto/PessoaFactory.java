package Projeto;

public class PessoaFactory {

    public Pessoa criarPessoa(String nome, int cc, int idade, int id) {
        return new Pessoa(nome, cc, idade, id);
    }

}
