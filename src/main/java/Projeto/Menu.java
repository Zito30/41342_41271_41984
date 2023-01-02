package Projeto;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void mainMenu() {

        System.out.println("-------------Laboratorio Eng.Infomática UPT-------------");
        System.out.println("                 1.Registar Requisição");
        System.out.println("                 2.Menu Inserir");
        System.out.println("                 3.Menu Eliminar");
        System.out.println("                 4.Menu Listar");
        System.out.println("                     0.Sair");

    }


    public static void menuInserir() {

        System.out.println("1. Inserir Pessoa");
        System.out.println("2. Inserir UC");
        System.out.println("3. Inserir Material");
        System.out.println("4. Inserir Avaria");
        System.out.println("5. Inserir Consumivel");
        System.out.println("0. Retroceder ao Menu Inicial");

    }


    public static void menuEliminar() {

        System.out.println("1. Eliminar Pessoa");
        System.out.println("2. Eliminar UC");
        System.out.println("3. Eliminar Material");
        System.out.println("4. Eliminar Avaria");
        System.out.println("5. Eliminar Consumivel");
        System.out.println("0. Retroceder ao Menu Inicial");

    }

    public static void menuListar() {

        System.out.println("1. Listar Pessoa");
        System.out.println("2. Listar UC");
        System.out.println("3. Listar Material");
        System.out.println("4. Listar Avaria");
        System.out.println("5. Listar Consumivel");
        System.out.println("0. Retroceder ao Menu Inicial");

    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int res = 0;

        Gestor g = new Gestor();

        int op;

        mainMenu();
        do {
            System.out.println("Digite opção: ");
            op = input.nextInt();
        }
        while (op < 0 || op > 4);

        while (op != 0) {

            switch (op) {

                case 1:{
                    int id=-1;
                    boolean existeP=false;
                    boolean existeM=false;
                    String mat = "";
                    ArrayList<Material> m = new ArrayList<>();
                    Material matAAdicionar = null;
                    int matExisteNaLista=0;
                    String nome="";
                    String materiais="";

                    System.out.println("Lista de Pessoas:");
                    System.out.println(g.listarPessoas());
                    if(g.listarPessoas().equals("Sem Pessoas registadas")){
                        break;
                    }

                    do{
                        System.out.println("Qual o Id da Pessoa");
                        id = input.nextInt();
                        existeP = g.verificarSePessoaExiste(id);
                    }while(existeP==false);

                    System.out.println("Lista dos materiais");
                    System.out.println(g.listarMateriais());

                    do{
                        System.out.println("Insira a etiqueta do material a inserir (0-para terminar): ");
                        mat = input.nextLine();
                        if(!mat.equals("0")){
                            existeM=g.verificarSeMaterialExiste(mat);
                        }
                        else{
                            System.out.println("Pedido registado com sucesso!");
                            System.out.println("--Pedido--");
                            System.out.println("Nome: ");
                            for(Pessoa p: g.pessoas){
                                if(id==p.getId()){
                                    nome=p.getNome();
                                }
                            }
                            System.out.println(nome);
                            for(Material mats:m){
                                materiais+=mats.getNome()+" | ";
                            }
                            System.out.println(materiais);
                        }
                        if(existeM==true){
                            for(Material i:g.materiais){
                                if(mat.equals(i.getEtiqueta())){
                                    matAAdicionar = i;
                                }
                            }
                            for(Material ii:m){
                                if(mat.equals(ii.getEtiqueta())){
                                    System.out.println("Material já está na lista");
                                    matExisteNaLista=1;
                                }
                            }
                            if(matExisteNaLista==0){
                                m.add(matAAdicionar);
                            }

                        }
                        else{
                            System.out.println("Material não existe. Etiqueta inválida.");
                        }
                    }while(!mat.equals("0"));

                }//fim do Case 1 -Registar requisição
                break;

                case 2: {
                    menuInserir();

                    do {
                        System.out.println("Digite opção: ");
                        op = input.nextInt();
                    }
                    while (op < 0 || op > 5);

                    while (op != 0) {  //WHILE OPCAO INSERIR

                        switch (op) { //SWITCH OPCAO INSERIR

                            case 1: {//Inserir Pessoa
                                String nome="";
                                String cc="";
                                int idade=-1;
                                do{
                                    System.out.println("Nome: ");
                                    nome = input.next();}
                                while(nome.equals(""));
                                do {
                                    System.out.println("Cartão de cidadão (8 digitos): ");
                                    cc = input.nextLine();}
                                while(cc.length()!=8);
                                do{
                                    System.out.println("Idade:");
                                    idade = input.nextInt();}
                                while(idade<=0 || idade>=120);
                                g.criarPessoa(nome, cc, idade);
                                }
                            break;

                            case 2: {//Inserir UC
                                String nome="";
                                do{
                                    System.out.println("Nome: ");
                                    nome = input.nextLine();}
                                while(nome.equals(""));
                                g.criarUC(nome);
                            }
                            break;

                            case 3: {//Inserir Material
                                String nome="";
                                int tipo=-1;
                                String cabecalho="";
                                do{
                                    System.out.println("Nome: ");
                                    nome = input.next();}
                                while(nome.equals(""));
                                do{
                                    System.out.println("1-Drone 2-Computador 3-Carro");
                                    System.out.println("Tipo: ");
                                    tipo = input.nextInt();}
                                while(tipo<1 && tipo>3);

                                if (tipo == 1) {
                                    cabecalho = "DR";
                                } else if (tipo == 2) {
                                    cabecalho = "CP";
                                } else {
                                    cabecalho = "CR";
                                }

                                g.criarMaterial(nome, tipo, cabecalho);
                            }
                            break;

                            case 4: {//Inserir Avaria
                                String etiqueta="";
                                String descricao="";
                                String dataDaAvaria="";
                                System.out.println("Lista de Materiais");
                                System.out.println(g.listarMateriais());
                                do{
                                    System.out.println("Insira a etiqueta do produto: ");
                                    etiqueta = input.next();}
                                while(etiqueta.equals(""));
                                do{
                                    System.out.println("Descreva o problema: ");
                                    descricao = input.nextLine();}
                                while(descricao.equals(""));
                                do {
                                    System.out.println("Data: ");
                                    dataDaAvaria = input.nextLine();}
                                while(dataDaAvaria.equals(""));
                                g.registarAnomalia(etiqueta, descricao, dataDaAvaria);
                            }
                            break;

                            case 5: {//Inserir Consumivel
                                String etiqueta="";
                                String nome="";
                                int quantidade=-1;
                                System.out.println("Lista de Materiais");
                                System.out.println(g.listarMateriais());
                                do{
                                    System.out.println("Etiqueta do Material: ");
                                    etiqueta = input.next();}
                                while(etiqueta.equals(""));
                                do{
                                    System.out.println("Nome do Consumível: ");
                                    nome = input.nextLine();}
                                while(nome.equals(""));
                                do{
                                    System.out.println("Quantidade (1-100): ");
                                    quantidade = input.nextInt();}
                                while(quantidade<1 || quantidade>100);
                                g.adicionarConsumivel(etiqueta, nome, quantidade);
                            }
                            break;
                        }//fim do switch OPCAO INSERIR
                        menuInserir();
                        do {
                            System.out.println("Digite opção: ");
                            op = input.nextInt();
                        }
                        while (op < 0 || op > 5);
                    }//fim do while OPCAO INSERIR

                }//fim do case 2 - Registar
                break;

                case 3: {
                    menuEliminar();

                    do {
                        System.out.println("Digite opção: ");
                        op = input.nextInt();
                    }
                    while (op < 0 || op > 5);

                    while (op != 0) {
                        switch (op) {
                            case 1: {//Eliminar Pessoa
                                System.out.println("Lista de Pessoas:");
                                g.listarPessoas();
                                System.out.println("ID da Pessoa: ");
                                int id = input.nextInt();
                                g.removePessoa(id);
                            }
                            break;

                            case 2: {//Eliminar UC
                                System.out.println("Lista de UCs:");
                                g.listarUCs();
                                System.out.println("Nome da UC: ");
                                String nome = input.nextLine();
                                g.removeUC(nome);
                            }
                            break;

                            case 3: {//Eliminar Material
                                System.out.println("Lista de Materiais");
                                g.listarMateriais();
                                System.out.println("Etiqueta: ");
                                String etiqueta = input.nextLine();
                                g.removeMaterial(etiqueta);
                            }
                            break;

                            case 4: {//Remover Avaria

                            }
                            break;

                            case 5: {//Remover Consumivel
                                System.out.println("Lista de Materiais");
                                g.listarMateriais();
                                System.out.println("Etiqueta do Material: ");
                                String etiqueta = input.next();
                                System.out.println("Lista de Consumiveis");
                                g.listarConsumiveisDeUmMaterial(etiqueta);
                                System.out.println("Nome do Consumível: ");
                                String nome = input.nextLine();
                                System.out.println("Quantidade: ");
                                int quantidade = input.nextInt();
                                g.removerConsumivel(etiqueta, nome, quantidade);
                            }
                            break;
                        }
                        menuEliminar();
                        do {
                            System.out.println("Digite opção: ");
                            op = input.nextInt();
                        }
                        while (op < 0 || op > 5);
                    }
                mainMenu();

                }//fim do case 2 - Eliminar
                break;

                case 4: {
                    menuListar();

                    do {
                        System.out.println("Digite opção: ");
                        op = input.nextInt();
                    }
                    while (op < 0 || op > 5);

                    while (op != 0) {

                        switch (op) {
                            case 1: {//Listar Pessoa
                                System.out.println(g.listarPessoas());
                            }
                            break;

                            case 2: {//Listar UC
                                System.out.println(g.listarUCs());
                            }
                            break;

                            case 3: {//Listar Material
                                int op1 = -1;
                                System.out.println("Tipo de listagem: 1-Todos 2-Por Tipo: ");
                                do{
                                    op1 = input.nextInt();
                                }while (op1 < 1 && op1 > 2);

                                if (op1 == 1) {
                                    System.out.println(g.listarMateriais());
                                } else {
                                    int tipo = -1;
                                    System.out.println("Tipo: 1-Drone 2-Computador 3-Carro");
                                    do{
                                        tipo = input.nextInt();
                                    }while (tipo < 1 && tipo > 3);
                                    System.out.println(g.listarMateriaisPorTipo(tipo));
                                }
                            }
                            break;

                            case 4: {//Listar Avaria
                                int op1 = -1;
                                System.out.println("Tipo de listagem: 1-Todos 2-De um Material: ");
                                do{
                                    op1 = input.nextInt();
                                }while (op1 < 1 && op1 > 2);

                                if (op1 == 1) {
                                    System.out.println(g.listarAnomalias());
                                } else {
                                    int tipo = -1;
                                    String etiqueta = "";
                                    System.out.println("Materiais:");
                                    System.out.println(g.listarMateriais());
                                    System.out.println("Material(etiqueta): ");
                                    do{
                                        etiqueta = input.nextLine();
                                    }while (etiqueta.equals(""));
                                    System.out.println(g.listarAnomaliasDeUmMaterial(etiqueta));
                                }
                            }
                            break;

                            case 5: {//Listar Consumivel
                                System.out.println("Lista de Materiais");
                                System.out.println(g.listarMateriais());
                                System.out.println("Etiqueta do Material: ");
                                String etiqueta = input.nextLine();
                                System.out.println(g.listarConsumiveisDeUmMaterial(etiqueta));
                            }
                            break;

                        }
                        menuListar();
                        do {
                            System.out.println("Digite opção: ");
                            op = input.nextInt();
                        }
                        while (op < 0 || op > 5);
                    }


                }//fim do case 3 - Listagens
                break;

                default:System.out.println("ERRO!");

            }//FIM SWITCH PRINCIPAL
            mainMenu();
            do {
                op = input.nextInt();
            }
            while (op < 0 || op > 4);


        }//FIM WHILE PRINCIPAL
    }
}
