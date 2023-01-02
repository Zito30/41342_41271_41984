package Projeto;

public class PessoaFactory {

    public Pessoa criarPessoa(String nome, String cc, int idade, int id) {
        return new Pessoa(nome, cc, idade, id);
    }

}
