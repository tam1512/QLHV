package DAO;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sam
 */
public class MyDatabaseManager {
    private Connection c;
    private  Statement s;
    private PreparedStatement p;
    private String host, port, dbName, dbUser, dbPassword;
    
    MyDatabaseManager(){
        host = "localhost";
        port = "3306";
        dbUser = "root";
        dbName = "School";
        dbPassword = "";
    }
            
    public void connectDb(){
        String dbPath = "jdbc:mysql://" + host + ":" + port + "/"
                        + dbName + "?useUnicode=yes&characterEncoding=UTF-8";
        try{
            c = (Connection) DriverManager.getConnection(dbPath, dbUser, dbPassword);
            s =  c.createStatement();
            System.out.print("Connected");
        }catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }
            
    public ResultSet doReadQuery(String sql) throws SQLException{
        ResultSet rs = null;
       rs = s.executeQuery(sql);
        return rs;
    }
    public void doUpdateQuery() throws SQLException{
        try {
            p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MyDatabaseManager.class.getName())
            .log(Level.SEVERE, null, ex);
        }
    }
            
    public static void main(String[] args){
        new MyDatabaseManager().connectDb();
    }
}
