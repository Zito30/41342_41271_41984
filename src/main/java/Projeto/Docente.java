package Projeto;

import java.util.ArrayList;

public class Docente extends Pessoa{

    public ArrayList<UC>ucs=new ArrayList<UC>();

    public Docente(int id,String nome,int cc,int idade){
        super(nome,cc,idade,id);

    }

    public ArrayList<UC> getUcs() {
        return ucs;
    }

    public void setUcs(ArrayList<UC> ucs) {
        this.ucs = ucs;
    }

    @Override
    public String toString() {
        return "UC: " + ucs;
    }
}
