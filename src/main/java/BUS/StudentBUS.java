/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package BUS;
import DTO.Student_DTO;
import DAO.StudentDAO;
import GUI.QLyHocVien;
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
    
    private final StudentDAO stuDAO = new StudentDAO();
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
    
    public int getLastID() {
        return stuDAO.getLastID();
    }
    
    public int addStudent( String lastName, String firstName, String regDate) throws ClassNotFoundException{
        boolean flag = false;
        int result = -1;
        if(lastName.trim().equals("")){
            JOptionPane.showMessageDialog(null, "Chưa nhập họ học viên", "CẢNH BÁO", JOptionPane.ERROR_MESSAGE);
            
        }
        if(firstName.trim().equals("")){
            JOptionPane.showMessageDialog(null, "Chưa nhập tên học viên", "CẢNH BÁO", JOptionPane.ERROR_MESSAGE);
            
        }
        if(regDate.equals("")){
            JOptionPane.showMessageDialog(null, "Vẫn còn các trường chưa nhập thông tin", "CẢNH BÁO", JOptionPane.ERROR_MESSAGE);
        }
        if(!lastName.trim().equals("") && !firstName.trim().equals("") && !regDate.equals("") ){
            
            
            Student_DTO hv = new Student_DTO();
//                hv.setStuID(createAutoId()); 
                    hv.setLastName(lastName);
                    hv.setFirstName(firstName);
//                hv.setDob(dob);
//                hv.setGender(gender);
                    hv.setRegDate(regDate + " 00:00:00");

flag = stuDAO.addStu(hv);
if(flag != true)
{
    JOptionPane.showMessageDialog(null, "Fail!", "WARNING", JOptionPane.ERROR_MESSAGE);
}else{
    result =  stuDAO.getLastID(); 
     hv.setStuID(""+result);
    stuList.add(hv);
    JOptionPane.showMessageDialog(null, "Success!", "NOTICE", JOptionPane.INFORMATION_MESSAGE);
}

        }
        
        return result;
    }
    
    public boolean deleteStudent(String stuID) throws ClassNotFoundException{
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
