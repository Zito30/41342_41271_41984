package Projeto;

import java.util.ArrayList;

public class Gestor {

    Gestor g = new Gestor();

    ArrayList<Pessoa>pessoas;
    ArrayList<Material>materiais;
    ArrayList<UC>ucs;
    ArrayList<Pedido>pedidos;

    public void criarPessoa(String nome, int cc, int idade) {

        int flagExiste=0;

        for(Pessoa p1:pessoas){
            if (p1.getCc() == cc) {
                System.out.println("A Pessoa já existe.");
                flagExiste=1;
            }
        }

        if (flagExiste==0){
            PessoaFactory pf = new PessoaFactory();
            int id=pessoas.size()+1;
            Pessoa p = pf.criarPessoa(nome, cc, idade,id);
            pessoas.add(p);
            System.out.println("Pessoa adicionada com sucesso.");
        }

    }

    public void criarMaterial(String nome, String tipo, String cabecalho) {

        //gerar etiqueta
        String etiqueta = g.emitirEtiquetas(tipo);

        Material m = new Material(etiqueta, nome, cabecalho);
        materiais.add(m);

    }

    public String emitirEtiquetas(String tipo) {
        int contaDrone=0;
        int contaComputador=0;
        int contaCarro=0;
        String etiqueta="";

        if(tipo=="1"){//Drone
            for(Material m:materiais){
                if(m.getTipo()==1){contaDrone++;}
            }
            etiqueta = "DR"+contaDrone+1;
        }
        else if(tipo=="2"){//Computador
            for(Material m:materiais){
                if(m.getTipo()==1){contaComputador++;}
            }
            etiqueta = "DR"+contaComputador+1;
        }
        else if(tipo=="3"){//Carro
            for(Material m:materiais){
                if(m.getTipo()==1){contaCarro++;}
            }
            etiqueta = "DR"+contaCarro+1;
        }
        return etiqueta;
    }

    public void criarUC(String nome) {

        int flagExiste=0;

        for(UC uc1:ucs){
            if (uc1.getNome() == nome) {
                System.out.println("A UC já existe.");
                flagExiste=1;
            }
        }

        if (flagExiste==0){
            UC uc = new UC(nome);
            ucs.add(uc);
            System.out.println("UC adicionada com sucesso.");
        }

    }

    public void removePessoa(int id) {

        int flagExiste=0;

        for(Pessoa p:pessoas) {
            if(p.getId()==id) {
                pessoas.remove(p);
                System.out.println("Pessoa removida com sucesso.");
                flagExiste=1;
            }
        }

        if(flagExiste==0){
            System.out.println("Pessoa não existe.");
        }

    }

    public void removeMaterial(String etiqueta) {

        int flagExiste=0;

        for(Material m:materiais) {
            if(m.getEtiqueta()==etiqueta) {
                materiais.remove(m);
                System.out.println("Material removido com sucesso.");
                flagExiste=1;
            }
        }

        if(flagExiste==0){
            System.out.println("Material não existe.");
        }

    }


    public void removeUC(String nome) {

        int flagExiste=0;

        for(UC uc:ucs) {
            if(uc.getNome().equals(nome)) {
                ucs.remove(uc);
                System.out.println("UC removida com sucesso.");
                flagExiste=1;
            }
        }

        if(flagExiste==0){
            System.out.println("UC não existe.");
        }

    }

    public String listarPessoas() {
        String listaDePessoas="";
        for(Pessoa p:pessoas) {
            listaDePessoas+=p.getNome()+"/n";
        }

        if (listaDePessoas.equals("")){
            return "Sem Pessoas registadas";
        }
        else{
            return listaDePessoas;
        }
    }

    public String listarMateriais() {
        String listaDeMateriais="";
        for(Material m:materiais) {
            listaDeMateriais+=m.getEtiqueta()+" - "+m.getNome()+"/n";
        }

        if (listaDeMateriais.equals("")){
            return "Sem Materiais registados";
        }
        else{
            return listaDeMateriais;
        }

    }

    public String listarMateriaisPorTipo(int tipo){ //1-Drone 2-Computador 3-Carro
        String listaDeMateriais="";
        String tipoDeMaterial="";

        if(tipo==1){//Drone
            tipoDeMaterial="Drones";
            for(Material m:materiais){
                if(m.getTipo()==1){listaDeMateriais+=m.getEtiqueta()+" - "+m.getNome()+"/n";}
            }
        }
        else if(tipo==2){//Computador
            tipoDeMaterial="Computadores";
            for(Material m:materiais){
                if(m.getTipo()==2){listaDeMateriais+=m.getEtiqueta()+" - "+m.getNome()+"/n";}
            }
        }
        else if(tipo==3){//Carro
            tipoDeMaterial="Carros";
            for(Material m:materiais){
                if(m.getTipo()==3){
                    listaDeMateriais+=m.getEtiqueta()+" - "+m.getNome()+"/n";
                }
            }
        }

        if (listaDeMateriais.equals("")){
            return "Sem "+tipoDeMaterial+"registados.";
        }
        else{
            return tipoDeMaterial+ "\n" +listaDeMateriais;
        }

    }

    public String listarUCs() {
        String listaDeUCs="";
        for(UC uc:ucs) {
            listaDeUCs+=uc.getNome()+"/n";
        }

        if (listaDeUCs.equals("")){
            return "Sem UCs registadas";
        }
        else{
            return listaDeUCs;
        }
    }

    public boolean consultarDisponibilidade(int id) {
        int flagInUse=0;
        for(Pedido p:pedidos) {
            if(p.getId()==id) {
                if(p.getDataDevolucao()==null){
                    flagInUse=1;
                }
            }
        }
        if(flagInUse==0) {
            return true;
        }
        else {
            return false;
        }

    }

}
