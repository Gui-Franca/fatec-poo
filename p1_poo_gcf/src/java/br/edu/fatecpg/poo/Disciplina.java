package br.edu.fatecpg.poo;

import java.sql.*;
import java.util.ArrayList;

public class Disciplina {
    private long rowid;
    private String nome;
    private String ementa;
    private Integer ciclo;
    private Double nota;
    
    public static ArrayList<Disciplina> getList(){
        ArrayList<Disciplina> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            con = DBListener.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select rowis,* FROM disciplina");
            while(rs.next()){
                list.add(new Disciplina(rs.getLong("rowid"), rs.getString("nome"),rs.getString("ementa"),rs.getInt("ciclo"),rs.getDouble("nota")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    
    
    public Disciplina(long rowid,String nome, String ementa, int ciclo, double nota) {
        this.rowid = rowid;
        this.nome = nome;
        this.ementa = ementa;
        this.ciclo = ciclo;
        this.nota = nota;
    }
    
    public long getRowid() {
        return rowid;
    }

    public void setRowid(long rowid) {
        this.rowid = rowid;
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
    
    public static String getCreateStatement(){
        return "CREATE TABLE IF NOT EXISTS disciplina("
                +"nome VARCHAR(50) UNIQUE NOT NULL,"
                +"ementa VARCHAR(200) NOT NULL,"
                +"ciclo INT NOT NULL,"
                +"nota INT NOT NULL"
                +")";
    }
    
}
