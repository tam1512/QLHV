/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;
import static javax.swing.JRootPane.ERROR_DIALOG;

/**
 *
 * @author Admin
 */
public final class SQLConnection {


    String host;
    String database;
    String username, password;
    String url;
    public static Connection conn = null;
    public static Statement st = null;
    public static ResultSet rs = null;

    public SQLConnection() throws ClassNotFoundException {
        connectionTest();
    }

    public SQLConnection(String host, String username, String password, String database) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.database = database;
    }

    protected void connectionTest() throws ClassNotFoundException {
        docFileText();

        url = "jdbc:mysql://" + host + "/" + database + "?useUnicode=true&characterEncoding=UTF8";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
//            System.out.println("Success");
//            System.out.println(conn.getCatalog());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không kết nối được tới CSDL!", "Cảnh báo", JOptionPane.INFORMATION_MESSAGE);
            //System.exit(0);
            closeConnection();
        }
//        JOptionPane.showMessageDialog(null, "Đã kết nối được tới CSDL!", "Cảnh báo", JOptionPane.INFORMATION_MESSAGE);
        
    }

    private void docFileText() {
        // Xử lý đọc file để lấy ra 4 tham số
        host = "";
        database = "";
        username = "";
        password = "";

        try {
            FileInputStream fis = new FileInputStream("data.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            host = br.readLine().trim();
            database = br.readLine().trim();
            username = br.readLine().trim();
            password = br.readLine().trim();

            if (password == null) {
                password = "";
            }

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
            if (st != null) {
                st.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet sqlExcute(String sql) throws ClassNotFoundException {
        docFileText();

        url = "jdbc:mysql://" + host + ":3306/" + database + "?useUnicode=true&characterEncoding=UTF8";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Success");
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            return rs;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connection failed!", "Error", JOptionPane.INFORMATION_MESSAGE);
            //System.exit(0);
        }
        closeConnection();
        return null;

    }

//    public boolean sqlUpdate(String sql) {
//        docFileText();
//
//        url = "jdbc:mysql://" + host + ":3306/" + database + "?useUnicode=true&characterEncoding=UTF8";
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection(url, username, password);
//            st = conn.createStatement();
//            int Result = st.executeUpdate(sql);
//            if (Result == 0) {
//                throw new Exception();
//            }
//        } catch (Exception e) {
//            //e.printStackTrace();
//            closeConnection();
//            return false;
//        }
//        closeConnection();
//        return true;
//    }



    public static void main(String[] args) throws ClassNotFoundException {
            SQLConnection a = new SQLConnection();
            
    }
}   
