package DAO;


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
public class StudentDAL extends MyDatabaseManager{
    public StudentDAL(){
        super();
        this.connectDb();
    }

    public void readStudents() throws SQLException{
        String query = "SELECT * FROM Person WHERE EnrollmentDate >0";
        ResultSet rs = this.doReadQuery(query);
        if (rs != null) {
            int i = 1;
            while (rs.next()) {
                System.out.print(i + " - ");
                System.out.println(rs.getString("Lastname") + " " + rs.getString("Firstname"));
                i++;
            }
        }
    }
    
    public static void main(String[] args){
        try {
            new StudentDAL().readStudents();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
