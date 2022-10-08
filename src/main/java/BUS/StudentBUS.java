/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package BUS;
import DTO.Student_DTO;
import DAO.StudentDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class StudentBUS {
    
    private StudentDAO stuDAO = new StudentDAO();
    private ArrayList<Student_DTO> stuList = null;
   

    public StudentBUS() {
    }
    
    public ArrayList<Student_DTO> getStuList() {
        try {
            
            if(stuList == null){
                this.stuList = stuDAO.StuList();
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.stuList;
        
    }
    
    public boolean addStudent( String lastName, String stName, String dob, String gender, String regDate){
        boolean flag = false;
        try {
            if(lastName.trim().equals("")){
                JOptionPane.showMessageDialog(null, "Chưa nhập họ học viên", "CẢNH BÁO", JOptionPane.ERROR_MESSAGE);
                
            }
            if(stName.trim().equals("")){
                JOptionPane.showMessageDialog(null, "Chưa nhập tên học viên", "CẢNH BÁO", JOptionPane.ERROR_MESSAGE);
                
            }
            if(gender.trim().equals("") | dob.equals("") | regDate.equals("")){
                JOptionPane.showMessageDialog(null, "Vẫn còn các trường chưa nhập thông tin", "CẢNH BÁO", JOptionPane.ERROR_MESSAGE);
            }
            if(!lastName.trim().equals("") && !stName.trim().equals("") && !gender.trim().equals("") && !dob.equals("") && !regDate.equals("") ){
                
            
                Student_DTO hv = new Student_DTO();
                hv.setStuID(createAutoId());
                hv.setLastName(lastName);
                hv.setStName(stName);
                hv.setDob(dob);
                hv.setGender(gender);
                hv.setRegDate(regDate);

                flag = stuDAO.addStu(hv);
                if(flag != true)
                {
                    JOptionPane.showMessageDialog(null, "Fail!", "WARNING", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Success!", "NOTICE", JOptionPane.INFORMATION_MESSAGE);
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return flag;
    }
    
    public boolean deleteStudent(String stuID){
        boolean flag = stuDAO.deleteStu(stuID);
        return flag;
    }
    
    public String createAutoId() throws SQLException {
        String data = stuDAO.lastIdOrder();
        if (data == null || data.isEmpty()) {
            return null;
        }
        int intData = Integer.parseInt(data.replace("SD", "")) + 1;
        return ("SD" + intData);
    }
}
