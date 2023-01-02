package Projeto;

import java.util.ArrayList;
import java.util.Scanner;


public class Gestor {

    Scanner input=new Scanner(System.in);

    public Gestor(){

    }

    public ArrayList<Pessoa>pessoas=new ArrayList<>();
    int contaPessoasRegistadas=0;
    public ArrayList<Material>materiais=new ArrayList<>();
    public ArrayList<UC>ucs=new ArrayList<>();
    public ArrayList<Pedido>pedidos=new ArrayList<>();

    public void criarPessoa(String nome, String cc, int idade) {

        int flagExiste=0;

        for(Pessoa p1:pessoas){
            if (p1.getCc().equals(cc)) {
                System.out.println("A Pessoa já existe.");
                flagExiste=1;
            }
        }

        if (flagExiste==0){
            PessoaFactory pf = new PessoaFactory();
            int id=contaPessoasRegistadas+1;
            Pessoa p = pf.criarPessoa(nome, cc, idade,id);
            pessoas.add(p);
            contaPessoasRegistadas++;
            System.out.println("Pessoa adicionada com sucesso.");
        }

    }

    public void criarMaterial(String nome, int tipo, String cabecalho) {


        //gerar etiqueta
        String etiqueta = emitirEtiquetas(tipo);

        Material m = new Material(etiqueta, nome, cabecalho,tipo);
        materiais.add(m);

    }

    public String emitirEtiquetas(int tipo) {
        int contaDrone=0;
        int contaComputador=0;
        int contaCarro=0;
        String etiqueta="";

        if(tipo==1){//Drone
            for(Material m:materiais){
                if(m.getTipo()==1){contaDrone++;}
            }
            etiqueta = "DR"+contaDrone+1;
        }
        else if(tipo==2){//Computador
            for(Material m:materiais){
                if(m.getTipo()==1){contaComputador++;}
            }
            etiqueta = "CP"+contaComputador+1;
        }
        else if(tipo==3){//Carro
            for(Material m:materiais){
                if(m.getTipo()==1){contaCarro++;}
            }
            etiqueta = "CR"+contaCarro+1;
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
                break;
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
                break;
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
                break;
            }
        }

        if(flagExiste==0){
            System.out.println("UC não existe.");
        }

    }

    public String listarPessoas() {
        String listaDePessoas="";
        for(Pessoa p:pessoas) {
            listaDePessoas+=p.getId()+" "+p.getNome()+ "\n";
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
            listaDeMateriais+=m.getEtiqueta()+" - "+m.getNome()+"\n";
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
                if(m.getTipo()==1){listaDeMateriais+=m.getEtiqueta()+" - "+m.getNome()+"\n";}
            }
        }
        else if(tipo==2){//Computador
            tipoDeMaterial="Computadores";
            for(Material m:materiais){
                if(m.getTipo()==2){listaDeMateriais+=m.getEtiqueta()+" - "+m.getNome()+"\n";}
            }
        }
        else if(tipo==3){//Carro
            tipoDeMaterial="Carros";
            for(Material m:materiais){
                if(m.getTipo()==3){
                    listaDeMateriais+=m.getEtiqueta()+" - "+m.getNome()+"\n";
                }
            }
        }

        if (listaDeMateriais.equals("")){
            return "Sem "+tipoDeMaterial+" registados.";
        }
        else{
            return tipoDeMaterial+ "\n" +listaDeMateriais;
        }

    }

    public String listarUCs() {
        String listaDeUCs="";
        for(UC uc:ucs) {
            listaDeUCs+=uc.getNome()+"\n";
        }

        if (listaDeUCs.equals("")){
            return "Sem UCs registadas";
        }
        else{
            return listaDeUCs;
        }
    }

    public String listarAnomaliasDeUmMaterial(String etiqueta) {
        String listaDeAnomalias="";
        for(Material m:materiais) {
            if(m.getEtiqueta().equals(etiqueta)){
                listaDeAnomalias+=m.getEtiqueta()+" "+m.getNome()+"\n";
                for (Avaria a : m.avarias) {
                    listaDeAnomalias+=a.getId()+" "+a.getDescricao()+" "+a.getDataAvaria()+"\n";
                }
            }
        }
        if(listaDeAnomalias==""){
            return "Não existem anomalias";
        }
        else{
            return listaDeAnomalias;
        }

    }

    public boolean consultarDisponibilidade(String etiqueta) {
        int flagInUse = 0;
        for (Pedido p : pedidos) {
            for (Material m : p.materiais) {
                if (m.getEtiqueta().equals(etiqueta)) {
                    if (p.getDataDevolucao() == null) {
                        flagInUse = 1;
                    }
                }
            }
        }

        if (flagInUse == 0) {
            return true;
        } else {
            return false;
        }
    }

    public String registarPedido(String data, ArrayList<Material> materiaisDoPedido) {
        int numPedido = pedidos.size()+1;
        if (materiaisDoPedido.size() == 0 || materiaisDoPedido.size()<0) {
            return "Erro, lista de materiais vazia. Pedido não registado.";
        } else if (materiaisDoPedido.size() > 0) {
            Pedido p = new Pedido(numPedido, data, materiaisDoPedido);
            return "Pedido registado com sucesso.";
        }
        else{
            return "Erro";
        }
    }

    public void registarAnomalia(String etiqueta,String descricao, String dataDaAvaria){
        int flagExiste=0;

        for(Material m:materiais) {
            if(m.getEtiqueta().equals(etiqueta)) {
                flagExiste=1;
                int numAvaria = m.avarias.size()+1;
                Avaria a = new Avaria(numAvaria,descricao,dataDaAvaria);
                m.avarias.add(a);
                break;
            }
        }

        if(flagExiste==0){
            System.out.println("Material não existe.");
        }
        else {
            System.out.println("Avaria registada com sucesso");
        }

    }

    public void adicionarConsumivel(String etiqueta,String nome, int quantidade){
        int flagExiste=0;
        for(Material m:materiais){
            if(m.getEtiqueta().equals(etiqueta)) {
                flagExiste=1;
                m.adicionarConsumivel(nome, quantidade);
                break;
            }
        }

        if(flagExiste==0){
            System.out.println("Material não existe.");
        }

    }

    public void removerConsumivel(String etiqueta, String nome, int quantidade){
        int flagExiste=0;
        for(Material m:materiais){
            if(m.getEtiqueta().equals(etiqueta)) {
                flagExiste=1;
                m.removerConsumivel(nome, quantidade);
                break;
            }
        }

        if(flagExiste==0){
            System.out.println("Material não existe.");
        }
    }

    public String listarConsumiveisDeUmMaterial(String etiqueta){
        String listaDeConsumiveis="";
        for(Material m:materiais){
            if(m.getEtiqueta().equals(etiqueta)) {
                for(Consumivel c : m.consumiveis){
                    listaDeConsumiveis+=c.getNome()+"\n";
                }
                if (listaDeConsumiveis.equals("")){
                    return "Sem Consumiveis registados";
                }
                else{
                    return listaDeConsumiveis;
                }
            }
        }

        return "Material não existe";

    }

    public String listarAnomalias(){
        String listaDeAnomalias="";
        for(Material m:materiais){
            listaDeAnomalias+=m.getEtiqueta()+" "+m.getNome()+"\n";
            for(Avaria a:m.avarias){
                listaDeAnomalias+=a.getId()+" "+a.getDescricao()+""+a.getDataAvaria()+"\n";
            }
        }
        if(listaDeAnomalias==""){
            return "Não existem anomalias";
        }
        else{
            return listaDeAnomalias;
        }
    }

    public Boolean verificarSePessoaExiste(int id){
        for(Pessoa p:pessoas){
            if(id==p.getId()){
                return true;
            }
        }
        return false;
    }

    public boolean verificarSeMaterialExiste(String etiqueta){
        for(Material m:materiais){
            if(etiqueta.equals(m.getEtiqueta())){
                return true;
            }
        }
        return false;
    }

}
