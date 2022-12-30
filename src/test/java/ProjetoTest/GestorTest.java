package ProjetoTest;

import Projeto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GestorTest {

    Gestor g=new Gestor();

    @BeforeEach
    public void setup() {

        Pessoa p= new Pessoa("Vasco",123,21,1);
        g.pessoas.add(p);
        Pessoa p1= new Pessoa("Diogo",124,21,2);
        g.pessoas.add(p1);

        Material m=new Material("DR01","DJI","DR");
        g.materiais.add(m);
        Material m1=new Material("CP01","ASUS","CP");
        g.materiais.add(m1);

        UC uc=new UC("Qualidade de Software");
        g.ucs.add(uc);
        UC uc1=new UC("Sistemas Operativos");
        g.ucs.add(uc1);

        ArrayList<Material>mat = new ArrayList<>();
        mat.add(m);
        Pedido pedido=new Pedido(1,"27/12/2022",mat);
        g.pedidos.add(pedido);

    }
    @Test
    @DisplayName("Teste Criar Pessoa")
    public void testCriarPessoa(){
        String nome="Delsey";
        int cc=125;
        int idade=21;

        g.criarPessoa(nome,cc,idade);
        assertEquals(3,g.pessoas.size());
    }

    @Test
    @DisplayName("Teste Criar Material")
    public void testCriarMaterial(){
        String nome="Computador";
        int tipo=1;
        String cabecalho="Computador da mesa 1";

        g.criarMaterial(nome,tipo,cabecalho);
        assertEquals(3,g.materiais.size());
    }

    @Test
    @DisplayName("Teste de emitir etiquetas")
    public void testEmitirEtiquetas(){
       String expected="DR01";

       assertEquals(expected,g.emitirEtiquetas(1));
    }

    @Test
    @DisplayName("Teste Criar UC")
    public void testCriarUC(){
        String nomeUC="Matematica Discreta";
        g.criarUC(nomeUC);
        assertEquals(3,g.ucs.size());
    }

    @Test
    @DisplayName("Teste Remover pessoa")
    public void testRemovePessoa(){
        g.removePessoa(1);
        assertEquals(1,g.pessoas.size());
    }

    @Test
    @DisplayName("Teste Remover Material")
    public void testRemoveMaterial(){
        g.removeMaterial("DR01");
        assertEquals(1,g.materiais.size());
    }


    @Test
    @DisplayName("Teste Remover UCs")
    public void testRemoveUC(){
        g.removeUC("Sistemas Operativos");
        assertEquals(1,g.ucs.size());
    }

    @Test
    @DisplayName("Testar Consultar Disponibilidade")
    public void testConsultarDisponibilidade(){
        assertTrue(g.consultarDisponibilidade("CP01"));
    }

    @Test
    @DisplayName("Teste Registar pedido")
    public void testRegistarPedido(){
        String data="28/12/2022";
        ArrayList<Material>materiaisDoPedido = new ArrayList<Material>();
        Material m = g.materiais.get(1); //DR01
        materiaisDoPedido.add(m);
        String expected="Pedido registado com sucesso.";
        assertEquals(expected,g.registarPedido(data,materiaisDoPedido));

    }

}
