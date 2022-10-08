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
            String sql = "SELECT * FROM student";
            x.sqlExcute(sql);
            
            while(rs.next()){
                Student_DTO hv = new Student_DTO();
                hv.setStuID(rs.getString(1));
                hv.setLastName(rs.getString(2));
                hv.setStName(rs.getString(3));
                hv.setDob(rs.getString(4));
                hv.setGender(rs.getString(5));
                hv.setRegDate(rs.getString(6));  
                dshv.add(hv);
            }
            return dshv;
            
        }catch(SQLException e){
                return null;
            }
        
    }
    
    public boolean addStu(Student_DTO stu){
        boolean result = false;
        try{
            String sql = "INSERT INTO student VALUES(?,?,?,?,?,?)";
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, stu.getStuID());
            prep.setString(2, stu.getLastName());
            prep.setString(3, stu.getStName());
            prep.setString(4, stu.getDob());
            prep.setString(5, stu.getGender());
            prep.setString(6, stu.getRegDate());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return result;
    }
    
    public boolean updateStu(Student_DTO stu){
        boolean result = false;
        try {
            String sql = "UPDATE student SET LastName=?, FirstName=?, DOB=? Gender=? RegisterDay=? WHERE StudentID=?";
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, stu.getLastName());
            prep.setString(2, stu.getStName());
            prep.setString(3, stu.getDob());
            prep.setString(4, stu.getGender());
            prep.setString(5, stu.getRegDate());
            prep.setString(6, stu.getStuID());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }
    
    public boolean deleteStu(String stuID){
        boolean result = false;
        try{
            String sql = "DELETE FROM student where StudentID=?";
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, stuID);
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public String lastIdOrder() throws SQLException {
        String sql = "SELECT * FROM student ORDER BY StudentID DESC LIMIT 1";
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
