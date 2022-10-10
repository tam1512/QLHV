package DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import config.SQLConnection.*;
import DTO.Student_DTO;
import config.SQLConnection;
import static config.SQLConnection.conn;
import static config.SQLConnection.rs;
import static config.SQLConnection.st;
import java.sql.PreparedStatement;
import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sam
 */
public class StudentDAO {
    
    SQLConnection x ;

    public ArrayList<Student_DTO> StuList() throws ClassNotFoundException, SQLException {
        ArrayList<Student_DTO> dshv = new ArrayList<>();
        x = new SQLConnection();
        try{
            String sql = "SELECT * FROM person Where HireDate IS NULL";
            x.sqlExcute(sql);
            
            while(rs.next()){
                Student_DTO hv = new Student_DTO();
                hv.setStuID(rs.getString(1));
                hv.setLastName(rs.getString(2));
                hv.setFirstName(rs.getString(3));
//                hv.setDob(rs.getString(4));
//                hv.setGender(rs.getString(5));
                hv.setRegDate(rs.getString(5));  
                dshv.add(hv);
            }
            return dshv;
            
        }catch(SQLException e){
                return null;
            }
        
    }
    
    public int getLastID() {
        int kq = 0;
        try {
            String sql = "SELECT MAX(PersonID) FROM person";
            PreparedStatement prep = conn.prepareStatement(sql);
            ResultSet result = prep.executeQuery();
            while (result.next()) {
                kq = result.getInt(1);
            }  
        } catch (Exception e) {
        }
        return kq;
    }
    
    public boolean addStu(Student_DTO stu) throws ClassNotFoundException{
        boolean result = false;
        try{
            String sql = "INSERT INTO person(Lastname, Firstname, EnrollmentDate) VALUES(?,?,?)";
            PreparedStatement prep = conn.prepareStatement(sql);
//            prep.setString(1, stu.getStuID());
            prep.setString(1, stu.getLastName());
            prep.setString(2, stu.getFirstName());
//            prep.setString(4, stu.getDob());
//            prep.setString(5, stu.getGender());
            prep.setString(3, stu.getRegDate());
            result = prep.executeUpdate() > 0;
//            System.out.println(result);
//            StuList();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return result;
    }
    
    public boolean updateStu(Student_DTO stu) throws ClassNotFoundException{
        boolean result = false;
        try {
            String sql = "UPDATE person SET Lastname=?, Firstname=?, EnrollmentDate=? WHERE PersonID=?";
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, stu.getLastName());
            prep.setString(2, stu.getFirstName());
//            prep.setString(3, stu.getDob());
//            prep.setString(4, stu.getGender());
            prep.setString(3, stu.getRegDate());
            prep.setString(4, stu.getStuID());
            result = prep.executeUpdate() > 0;
//            StuList();
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }
    
    public boolean deleteStu(String stuID) throws ClassNotFoundException{
        boolean result = false;
        try{
            String sql = "DELETE FROM person where PersonID=?";
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, stuID);
            result = prep.executeUpdate() > 0;
//            StuList();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public String lastIdOrder() throws SQLException {
        String sql = "SELECT * FROM person ORDER BY PersonID DESC LIMIT 1";
        rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            //SQLConnection.rs = SQLConnection.conn.sqlExcute(sql);

            while (rs.next()) {
                String data = rs.getString(1);
                return data;
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }
        
//    public void readStudents() throws SQLException{
//        String query = "SELECT * FROM student WHERE EnrollmentDate >0";
//        ResultSet rs = this.doReadQuery(query);
//        if (rs != null) {
//            int i = 1;
//            while (rs.next()) {
//                System.out.print(i + " - ");
//                System.out.println(rs.getString("Lastname") + " " + rs.getString("Firstname"));
//                i++;
//            }
//        }
//    }
    
        
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        StudentDAO a = new StudentDAO();
        System.out.println(a.StuList());
            
    }
}
