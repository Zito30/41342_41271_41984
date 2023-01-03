package Projeto;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.List;

import static Projeto.Menu.g;

public class FileCsv {
    public FileCsv() {

    }

    public void guardarPessoa(ArrayList<Pessoa> p){
        try {
            Writer file = Files.newBufferedWriter(Paths.get("src/main/java/FileCsv/pessoa.csv"));
            StatefulBeanToCsv<Pessoa> beanToCsv = new StatefulBeanToCsvBuilder(file).build();
            beanToCsv.write(p);
            file.flush();
            file.close();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void guardarMaterial(ArrayList<Material> m){
        try {
            Writer file = Files.newBufferedWriter(Paths.get("src/main/java/FileCsv/Material.csv"));
            StatefulBeanToCsv<Material> beanToCsv = new StatefulBeanToCsvBuilder(file).build();
            beanToCsv.write(m);
            file.flush();
            file.close();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public void guardarPedido(ArrayList<Pedido> p){
        try {
            Writer file = Files.newBufferedWriter(Paths.get("src/main/java/FileCsv/pedido.csv"));
            StatefulBeanToCsv<Pedido> beanToCsv = new StatefulBeanToCsvBuilder(file).build();
            beanToCsv.write(p);
            file.flush();
            file.close();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }

    }

    public void guardarConsumivel(ArrayList<Consumivel> c){
        try {
            Writer file = Files.newBufferedWriter(Paths.get("src/main/java/FileCsv/consumivel.csv"));
            StatefulBeanToCsv<Consumivel> beanToCsv = new StatefulBeanToCsvBuilder(file).build();
            beanToCsv.write(c);
            file.flush();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }

    }

    public void guardarAvaria(ArrayList<Avaria> a){
        try {
            Writer file = Files.newBufferedWriter(Paths.get("src/main/java/FileCsv/avaria.csv"));
            StatefulBeanToCsv<Avaria> beanToCsv = new StatefulBeanToCsvBuilder(file).build();
            beanToCsv.write(a);
            file.flush();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }

    public void guardarUc(ArrayList<UC> u){
        try {
            Writer file = Files.newBufferedWriter(Paths.get("src/main/java/FileCsv/uc.csv"));
            StatefulBeanToCsv<UC> beanToCsv = new StatefulBeanToCsvBuilder(file).build();
            beanToCsv.write(u);
            file.flush();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }

    public  void carregarCsv(String nomeCsv) {

        try {
            Reader rd = Files.newBufferedReader(Paths.get("src/main/java/FileCsv/" + nomeCsv + ".csv"));
            CSVReader csvReader = new CSVReaderBuilder(rd)
                    .withSkipLines(1)
                    .build();
            List<String[]> vector = csvReader.readAll();
                if (nomeCsv.equals("pessoa")) {
                    for (String[] str : vector){
                        String cc = str[0];
                        int idd = Integer.parseInt(str[2]);
                        String nome = str[3];
                        g.criarPessoa(nome, cc, idd);
                    }
                    System.out.println("...-...-...");
                }
                if (nomeCsv.equals("material")) {
                    for (String[] str : vector){
                        String nome = str[4];
                        int tipo = Integer.parseInt(str[6]);
                        String cabelhalho = str[2];
                        g.criarMaterial(nome, tipo, cabelhalho);
                    }
                    System.out.println("...-......");
                }

                if (nomeCsv.equals("uc")) {
                    for (String[] str : vector){
                        String nome = str[0];
                        g.criarUC(nome);}
                }

        } catch (IOException | CsvException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}