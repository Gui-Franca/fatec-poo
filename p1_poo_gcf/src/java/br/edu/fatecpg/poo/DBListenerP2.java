package br.edu.fatecpg.poo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.*;
import java.util.ArrayList;

public class DBListenerP2 implements ServletContextListener {
    public static final String CLASS_NAME = "org.sqlite.JDBC";
    public static final String URL = "jdbc:sqlite:p2.db";
    public static Exception exception = null;
    
        public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(URL);
    }
        
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try{
            Class.forName(CLASS_NAME);
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS disciplinas("
                    + "name VARCHAR(200) NOT NULL PRIMARY KEY,"
                    + "ementa VARCHAR(200) NOT NULL,"
                    + "ciclo integer NOT NULL"
                    + "nota integer NOT NULL"
                    + ")");
            if(getDisciplinas().isEmpty()){
                stmt.execute("INSERT INTO users VALUES("
                        + "'POO',"
                        + "'Ementa POO',"
                        + "4,"
                        + "10"
                        + ")");
                stmt.execute("INSERT INTO users VALUES("
                        + "'SO2',"
                        + "'Ementa SO2',"
                        + "4,"
                        + "10"
                        + ")");
                stmt.execute("INSERT INTO users VALUES("
                        + "'BD',"
                        + "'Ementa BD',"
                        + "4,"
                        + "10"
                        + ")");
                stmt.execute("INSERT INTO users VALUES("
                        + "'SI',"
                        + "'Ementa SI',"
                        + "4,"
                        + "10"
                        + ")");
                stmt.execute("INSERT INTO users VALUES("
                        + "'ES3',"
                        + "'Ementa ES3',"
                        + "4,"
                        + "10"
                        + ")");
                stmt.execute("INSERT INTO users VALUES("
                        + "'MetPesq',"
                        + "'Ementa MetPesq',"
                        + "4,"
                        + "10"
                        + ")");
                
            }
            stmt.execute("CREATE TABLE IF NOT EXISTS log("
                    + "name VARCHAR(200) NOT NULL PRIMARY KEY,"
                    + "ementa VARCHAR(200) NOT NULL,"
                    + "ciclo integer NOT NULL"
                    + "nota integer NOT NULL"
                    + ")");
            stmt.close();
            con.close();
        }catch(Exception ex){
            exception = ex;
        }
        
        
    }
    public static ArrayList<String> getDisciplinas() throws Exception{
        ArrayList<String> list = new ArrayList<>();
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT name FROM disciplinas");
        while(rs.next()){
            list.add(rs.getString("name"));
        }
        rs.close();
        stmt.close();
        con.close();
        return list;
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
