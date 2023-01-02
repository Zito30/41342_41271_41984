package ProjetoTest;

import Projeto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GestorTest {

    Gestor g=new Gestor();

    @BeforeEach
    public void setup() {

        Pessoa p= new Pessoa("Vasco","12345678",21,1);
        g.pessoas.add(p);
        Pessoa p1= new Pessoa("Diogo","12345670",21,2);
        g.pessoas.add(p1);

        Material m=new Material("DR01","DJI","DR",1);
        g.materiais.add(m);
        Material m1=new Material("CP01","ASUS","CP",2);
        g.materiais.add(m1);

        UC uc=new UC("Qualidade de Software");
        g.ucs.add(uc);
        UC uc1=new UC("Sistemas Operativos");
        g.ucs.add(uc1);

        ArrayList<Material>mat = new ArrayList<>();
        mat.add(m);
        Pedido pedido=new Pedido(1,"27/12/2022",mat);
        g.pedidos.add(pedido);
        Consumivel c=new Consumivel(11,"Asas",4);
        m.consumiveis.add(c);
    }
    @Test
    @DisplayName("Teste Criar Pessoa")
    public void testCriarPessoa(){
        String nome="Delsey";
        String cc="12345671";
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

    @ParameterizedTest
    @DisplayName("Teste Registar Anomalia")
    @CsvSource(value={"DR01,Comando Estourou,30/12/2022"})
    public void testRegistarAnomalia(String etiqueta,String descricao,String data){
        g.registarAnomalia(etiqueta,descricao,data);
        int expected=1;

        int idMaterial=-1;
        for(Material m: g.materiais){
            if(m.getEtiqueta().equals(etiqueta)){
                idMaterial=g.materiais.indexOf(m);

                assertEquals(expected,g.materiais.get(idMaterial).avarias.size());
                break;
            }

        }
    }

    @ParameterizedTest
    @DisplayName("Teste AdicionarConsumiveis")
    @CsvSource(value = {"DR01,Helices,4"})
    public void testAdicionarConsumivel(String etiqueta,String nome,int quantidade){
        g.adicionarConsumivel(etiqueta,nome,quantidade);

        int expected=2;

        int idMaterial=-1;
        for(Material m: g.materiais){
            if(m.getEtiqueta().equals(etiqueta)) {
                idMaterial = g.materiais.indexOf(m);
            }
                assertEquals(expected,g.materiais.get(idMaterial).consumiveis.size());
                break;
            }
    }


    @ParameterizedTest
    @DisplayName("Teste AdicionarConsumiveis")
    @CsvSource(value = {"DR01,Asas,1"})
    public void testRemoverConsumivel(String etiqueta,String nome,int quantidade){
        g.removerConsumivel(etiqueta,nome,quantidade);
        int expected=3;

        int idMaterial=-1;
        int idConsumivel=-1;
        for(Material m: g.materiais){
            if(m.getEtiqueta().equals(etiqueta)) {
                idMaterial = g.materiais.indexOf(m);
                for(Consumivel c:m.consumiveis){
                    if(c.getNome().equals(nome)){
                        idConsumivel=m.consumiveis.indexOf(c);
                    }
                }
            }
            assertEquals(expected,g.materiais.get(idMaterial).consumiveis.get(idConsumivel).getQuantidade());
            break;
        }

    }


    @Nested
    class RepeatedTest{

        @ParameterizedTest
        @DisplayName("Teste Criar Pessoa")
        @CsvSource(value={"Ze,01234567,23","Antonio,01234568,30","Nuno,01234569,26"})
        public void testCriarPessoa(String nome,String cc,int idade){
            g.criarPessoa(nome,cc,idade);
            int expected=3;

            assertEquals(expected,g.pessoas.size());
        }

    }
}
