/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI;

import BUS.StudentBUS;
import DTO.Student_DTO;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import GUI.QLyHocVien;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class JdlCreateStudent extends javax.swing.JDialog {

    /**
     * Creates new form JdlNewStudent
     */
    private StudentBUS stuBUS = new StudentBUS();
    private Student_DTO stuDTO = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    QLyHocVien a = new QLyHocVien();
    DefaultTableModel dtmStu;
    
    
    public JdlCreateStudent(java.awt.Frame parent, boolean modal) throws ClassNotFoundException {
        super(parent, modal);
        initComponents();
//        ListStu();
        taiDanhsach();
        
    }
    
//    public void ListStu(){
//        a.loadStuList();
//        a.customStu();
//    }
    public void taiDanhsach() throws ClassNotFoundException {

        dtmStu = new DefaultTableModel();
        dtmStu.addColumn("Student ID");
        dtmStu.addColumn("LastName");
        dtmStu.addColumn("FirstName");
//        dtmStu.addColumn("DOB");
//        dtmStu.addColumn("Gender");
        dtmStu.addColumn("Register Date");
        
        a.tblStudent.setModel(dtmStu);
        
        dtmStu.setRowCount(0);
        stuBUS.getStuList();

        ArrayList<Student_DTO> dssp = stuBUS.getStuList();
        if (dssp != null) {
            for (Student_DTO hv : dssp) {
                Vector vt = new Vector();
                Vector vec = new Vector();
                vec.add(hv.getStuID());
                vec.add(hv.getLastName());
                vec.add(hv.getFirstName());
//                vec.add(hv.getDob());
//                vec.add(hv.getGender());
                vec.add(hv.getRegDate());
                dtmStu.addRow(vec);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupGender = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        txtStName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jclRegDate = new com.toedter.calendar.JDateChooser();
        jclDOB = new com.toedter.calendar.JDateChooser();
        rbtnFemale = new javax.swing.JRadioButton();
        rbtnMale = new javax.swing.JRadioButton();
        btnCreateNewStu = new javax.swing.JButton();
        lblNameForm = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnClearWords = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student Creation Form");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Last Name :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 80, 30));

        jLabel2.setText("First Name :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 80, 30));

        jLabel3.setText("Gender :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 80, 30));
        jPanel1.add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 180, 30));
        jPanel1.add(txtStName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 180, 30));

        jLabel5.setText("Register Date:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 80, 30));

        jLabel6.setText("Date of birth :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 80, 30));
        jPanel1.add(jclRegDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 170, 30));
        jPanel1.add(jclDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 170, 30));

        btnGroupGender.add(rbtnFemale);
        rbtnFemale.setText("Female");
        jPanel1.add(rbtnFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, -1, 30));

        btnGroupGender.add(rbtnMale);
        rbtnMale.setText("Male");
        jPanel1.add(rbtnMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, -1, 30));

        btnCreateNewStu.setText("Create");
        btnCreateNewStu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNewStuActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreateNewStu, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 80, 40));

        lblNameForm.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("STUDENT ADDING FORM");

        javax.swing.GroupLayout lblNameFormLayout = new javax.swing.GroupLayout(lblNameForm);
        lblNameForm.setLayout(lblNameFormLayout);
        lblNameFormLayout.setHorizontalGroup(
            lblNameFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblNameFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addContainerGap())
        );
        lblNameFormLayout.setVerticalGroup(
            lblNameFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblNameFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(lblNameForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 450, -1));

        btnClearWords.setText("Clear");
        btnClearWords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearWordsActionPerformed(evt);
            }
        });
        jPanel1.add(btnClearWords, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, -1, 40));

        btnCancel.setText("Cancel");
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, -1, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateNewStuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNewStuActionPerformed
        
        try {
            String gt = null;
            if(rbtnFemale.isSelected()){
                gt = "Femal";
            } else if (rbtnMale.isSelected()){
                gt = "Male";
            }
            
            boolean flag = stuBUS.addStudent(txtLastName.getText(), txtStName.getText(), sdf.format(jclRegDate.getDate()));
//        ListStu();
//loadStuList();
            

            if( flag != false){
                txtLastName.setText("");
                txtStName.setText("");
//                btnGroupGender.clearSelection();
//                jclDOB.setDate(null);
                jclRegDate.setDate(null);
                taiDanhsach();
                this.dispose();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JdlCreateStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCreateNewStuActionPerformed

    private void btnClearWordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearWordsActionPerformed
        // TODO làm sạc các trường thông tin
        txtLastName.setText(null);
        txtStName.setText(null);
//        jclDOB.setDateFormatString(null);
//        jclDOB.setDate(null);
        jclRegDate.setDateFormatString(null);
        jclRegDate.setDate(null);
//        btnGroupGender.clearSelection();
    }//GEN-LAST:event_btnClearWordsActionPerformed

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnCancelMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JdlCreateStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdlCreateStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdlCreateStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdlCreateStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JdlCreateStudent dialog = new JdlCreateStudent(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JdlCreateStudent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClearWords;
    private javax.swing.JButton btnCreateNewStu;
    private javax.swing.ButtonGroup btnGroupGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser jclDOB;
    private com.toedter.calendar.JDateChooser jclRegDate;
    private javax.swing.JPanel lblNameForm;
    private javax.swing.JRadioButton rbtnFemale;
    private javax.swing.JRadioButton rbtnMale;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtStName;
    // End of variables declaration//GEN-END:variables
}