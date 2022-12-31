package Projeto;

import java.util.Scanner;

public class Menu {

    public static void mainMenu() {

        System.out.println("-------------Bem vindo á biblioteca UPT-------------");
        System.out.println("                 1.Menu Inserir ");
        System.out.println("                 2.Menu Eliminar");
        System.out.println("                 3.Menu Listar");
        System.out.println("                     0.Sair");
    }


    public static void menuInserir() {

        System.out.println("1. Inserir Pessoa");
        System.out.println("2. Inserir UC");
        System.out.println("3. Inserir Material");
        System.out.println("4. Inserir Avaria");
        System.out.println("5. Inserir Consumivel");
        System.out.println("6. Retroceder ao Menu Inicial");
        System.out.println("0.Sair");

    }


    public static void menuEliminar() {

        System.out.println("1. Eliminar Pessoa");
        System.out.println("2. Eliminar UC");
        System.out.println("3. Eliminar Material");
        System.out.println("4. Eliminar Avaria");
        System.out.println("5. Eliminar Consumivel");
        System.out.println("6. Retroceder ao Menu Inicial");
        System.out.println("0.Sair");
    }

    public static void menuListar() {

        System.out.println("1. Listar Pessoa");
        System.out.println("2. Listar UC");
        System.out.println("3. Listar Material");
        System.out.println("4. Listar Avaria");
        System.out.println("5. Listar Consumivel");
        System.out.println("6. Retroceder ao Menu Inicial");
        System.out.println("0.Sair");
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        int res = 0;

        Gestor g = new Gestor();

        int op;

        mainMenu();
        do {
            op = input.nextInt();
        }
        while (op < 0 || op > 3);

        while (op != 0) {

            switch (op) {

                case 1: {
                    menuInserir();

                    do {
                        System.out.println("Digite opção: ");
                        op = input.nextInt();
                    }
                    while (op < 0 || op > 6);

                    while (op != 0) {  //WHILE OPCAO INSERIR

                        switch (op) { //SWITCH OPCAO INSERIR

                            case 1: {//Inserir Pessoa
                                System.out.println("Nome: ");
                                String nome = input.next();
                                System.out.println("Cartão de cidadão: ");
                                int cc = input.nextInt();
                                System.out.println("Idade:");
                                int idade = input.nextInt();
                                g.criarPessoa(nome, cc, idade);
                            }
                            break;

                            case 2: {//Inserir UC
                                System.out.println("Nome: ");
                                String nome = input.next();
                                g.criarUC(nome);
                            }
                            break;

                            case 3: {//Inserir Material
                                int tipo = -1;
                                String cabecalho = "";
                                System.out.println("Nome: ");
                                String nome = input.next();
                                System.out.println("1-Drone 2-Computador 3-Carro");
                                System.out.println("Tipo: ");
                                while (tipo < 1 && tipo > 3) {
                                    tipo = input.nextInt();
                                }
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
                                System.out.println("Lista de Materiais");
                                g.listarMateriais();
                                System.out.println("Insira a etiqueta do produto: ");
                                String etiqueta = input.next();
                                System.out.println("Descreva o problema: ");
                                String descricao = input.next();
                                System.out.println("Data: ");
                                String dataDaAvaria = input.next();
                                g.registarAnomalia(etiqueta, descricao, dataDaAvaria);
                            }
                            break;

                            case 5: {//Inserir Consumivel
                                System.out.println("Lista de Materiais");
                                g.listarMateriais();
                                System.out.println("Etiqueta do Material: ");
                                String etiqueta = input.next();
                                System.out.println("Nome do Consumível: ");
                                String nome = input.next();
                                System.out.println("Quantidade: ");
                                int quantidade = input.nextInt();
                                g.adicionarConsumivel(etiqueta, nome, quantidade);
                            }
                            break;
                            case 6: {//retroceder ao menu inicial
                                mainMenu();
                            }
                            break;
                        }//fim do switch OPCAO INSERIR
                        menuInserir();
                        do {
                            System.out.println("Digite opção: ");
                            op = input.nextInt();
                        }
                        while (op < 0 || op > 6);
                    }//fim do while OPCAO INSERIR



                }//fim do case 1 - Registar
                break;

                case 2: {
                    menuEliminar();

                    do {
                        System.out.println("Digite opção: ");
                        op = input.nextInt();
                    }
                    while (op < 0 || op > 6);

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
                                String nome = input.next();
                                g.removeUC(nome);
                            }
                            break;

                            case 3: {//Eliminar Material
                                System.out.println("Lista de Materiais");
                                g.listarMateriais();
                                System.out.println("Etiqueta: ");
                                String etiqueta = input.next();
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
                                String nome = input.next();
                                System.out.println("Quantidade: ");
                                int quantidade = input.nextInt();
                                g.removerConsumivel(etiqueta, nome, quantidade);
                            }
                            break;
                            case 6: {//retroceder ao menu inicial
                                mainMenu();
                            }
                            break;
                        }
                        menuEliminar();
                        do {
                            System.out.println("Digite opção: ");
                            op = input.nextInt();
                        }
                        while (op < 0 || op > 6);
                    }
                mainMenu();

                }//fim do case 2 - Eliminar
                break;

                case 3: {
                    menuListar();

                    do {
                        System.out.println("Digite opção: ");
                        op = input.nextInt();
                    }
                    while (op < 0 || op > 6);

                    while (op != 0) {
                        switch (op) {
                            case 1: {//Listar Pessoa
                                g.listarPessoas();
                            }
                            break;

                            case 2: {//Listar UC
                                g.listarUCs();
                            }
                            break;

                            case 3: {//Listar Material
                                int op1 = -1;
                                System.out.println("Tipo de listagem: 1-Todos 2-Por Tipo: ");
                                while (op1 < 1 && op1 > 2) {
                                    op1 = input.nextInt();
                                }

                                if (op1 == 1) {
                                    g.listarMateriais();
                                } else {
                                    int tipo = -1;
                                    System.out.println("Tipo: 1-Drone 2-Computador 3-Carro");
                                    while (tipo < 1 && tipo > 3) {
                                        tipo = input.nextInt();
                                    }
                                    g.listarMateriaisPorTipo(tipo);
                                }
                            }
                            break;

                            case 4: {//Listar Avaria
                                int op1 = -1;
                                System.out.println("Tipo de listagem: 1-Todos 2-De um Material: ");
                                while (op1 < 1 && op1 > 2) {
                                    op1 = input.nextInt();
                                }

                                if (op1 == 1) {
                                    g.listarAnomalias();
                                } else {
                                    int tipo = -1;
                                    String etiqueta = "";
                                    System.out.println("Materiais:");
                                    g.listarMateriais();
                                    System.out.println("Material(etiqueta): ");
                                    while (etiqueta.equals("")) {
                                        etiqueta = input.next();
                                    }
                                    g.listarAnomaliasDeUmMaterial(etiqueta);
                                }
                            }
                            break;

                            case 5: {//Listar Consumivel
                                System.out.println("Lista de Materiais");
                                g.listarMateriais();
                                System.out.println("Etiqueta do Material: ");
                                String etiqueta = input.next();
                                g.listarConsumiveisDeUmMaterial(etiqueta);
                            }
                            break;
                            case 6: {//retroceder ao menu inicial
                                mainMenu();
                            }
                            break;
                        }

                        mainMenu();
                    }


                }//fim do case 3 - Listagens
                break;

                default:System.out.println("ERRO!");

            }//FIM SWITCH PRINCIPAL
            mainMenu();
            do {
                op = input.nextInt();
            }
            while (op < 0 || op > 3);


        }//FIM WHILE PRINCIPAL
    }
}
