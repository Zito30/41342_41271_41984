package Projeto;

import java.util.ArrayList;

public class Gestor {

    Gestor g = new Gestor();

    ArrayList<Pessoa>pessoas;
    ArrayList<Material>materiais;
    ArrayList<UC>ucs;
    ArrayList<Pedido>pedidos;

    public void criarPessoa(int id, String nome, String cc, int idade) {

        PessoaFactory pf = new PessoaFactory();
        Pessoa p = pf.criarPessoa(idade, nome, id, idade);
        pessoas.add(p);

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
        else if(tipo=="3"){//Drone
            for(Material m:materiais){
                if(m.getTipo()==1){contaCarro++;}
            }
            etiqueta = "DR"+contaCarro+1;
        }
        return etiqueta;
    }

    public void criarUC(String nome) {
        UC uc = new UC(nome);
        ucs.add(uc);
    }

    public void removePessoa(int id) {
        for(Pessoa p:pessoas) {
            if(p.getId()==id) {
                pessoas.remove(p);
            }
        }
    }

    public void removeMaterial(String etiqueta) {
        for(Material m:materiais) {
            if(m.getEtiqueta()==etiqueta) {
                materiais.remove(m);
            }
        }
    }


    public void removeUC(String nome) {
        for(UC uc:ucs) {
            if(uc.getNome().equals(nome)) {
                ucs.remove(uc);
            }
        }
    }

    public String listarPessoas() {
        String listaDePessoas="";
        for(Pessoa p:pessoas) {
            listaDePessoas+=p.getNome()+"/n";
        }
        return listaDePessoas;
    }

    public String listarMateriais() {
        String listaDeMateriais="";
        for(Material m:materiais) {
            listaDeMateriais+=m.getEtiqueta()+" - "+m.getNome()+"/n";
        }
        return listaDeMateriais;
    }

    public String listarMateriaisPorTipo(int tipo){ //1-Drone 2-Computador 3-Carro
        String listaDeMateriais="";

        if(tipo==1){//Drone
            for(Material m:materiais){
                if(m.getTipo()==1){listaDeMateriais+=m.getEtiqueta()+" - "+m.getNome()+"/n";}
            }
        }
        else if(tipo==2){//Computador
            for(Material m:materiais){
                if(m.getTipo()==2){listaDeMateriais+=m.getEtiqueta()+" - "+m.getNome()+"/n";}
            }
        }
        else if(tipo==3){//Drone
            for(Material m:materiais){
                if(m.getTipo()==3){
                    listaDeMateriais+=m.getEtiqueta()+" - "+m.getNome()+"/n";
                }
            }
        }
        return listaDeMateriais;
    }

    public String listarUCs() {
        String listaDeUCs="";
        for(UC uc:ucs) {
            listaDeUCs+=uc.getNome()+"/n";
        }
        return listaDeUCs;
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
