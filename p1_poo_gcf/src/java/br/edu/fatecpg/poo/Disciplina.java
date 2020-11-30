package br.edu.fatecpg.poo;

import java.util.ArrayList;

public class Disciplina {
    String nome;
    String ementa;
    int ciclo;
    double nota;
    
    public Disciplina(String nome, String ementa, int ciclo) {
        this.nome = nome;
        this.ementa = ementa;
        this.ciclo = ciclo;
    }
    
    public Disciplina getList(int i){
        
        Disciplina disc1 = new Disciplina("POO","Ementa POO",4);
        Disciplina disc2 = new Disciplina("SO2","Ementa SO2",4);
        Disciplina disc3 = new Disciplina("BD","Ementa BD",4);
        Disciplina disc4 = new Disciplina("SI","Ementa SI",4);
        Disciplina disc5 = new Disciplina("ES3","Ementa ES3",4);
        Disciplina disc6 = new Disciplina("MetPesq","Ementa MetPesq",4);
        
        ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
        disciplinas.add(disc1);
        disciplinas.add(disc2);
        disciplinas.add(disc3);
        disciplinas.add(disc4);
        disciplinas.add(disc5);
        disciplinas.add(disc6);
        
        return disciplinas.get(i);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
