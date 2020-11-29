package br.edu.fatecpg.poo;

import static br.edu.fatecpg.poo.DBListenerP2.getConnection;
import java.sql.*;
import java.util.ArrayList;

public class Disciplina {
    public static final String URL = "jdbc:sqlite:D:\\projetos_github\\p1_gcf\\fatec-poo\\p2.db";
    String nome;
    String ementa;
    int ciclo;
    double nota;
    
    public Disciplina(String nome, String ementa, int ciclo) {
        this.nome = nome;
        this.ementa = ementa;
        this.ciclo = ciclo;
    }
    
    
    
    public static void insertDisciplina(String name, String ementa, int ciclo, int nota) throws Exception{
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection(URL);
        Statement stmt = con.createStatement();
        stmt.execute("INSERT INTO disciplinas VALUES('"+name+","+ementa+","+ciclo+","+nota+"')");
        stmt.close();
        con.close();
    }
    
    public static void deleteDisciplina(String name) throws Exception{
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection(URL);
        Statement stmt = con.createStatement();
        stmt.execute("DELETE FROM disciplinas WHERE name = '"+name+"'");
        stmt.close();
        con.close();
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
