/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Sam
 */
public class Main extends javax.swing.JFrame {

    int posX = 0, posY = 0;
    JPanel pnlCard, pnlTrangchu, pnlQLDiem, pnlQLGiangvien, pnlQLHocvien, pnlQLKhoahoc, pnlDangky;
    ArrayList<JPanel> listMenuLeft;
    CardLayout cards = new CardLayout();

    public Main() throws InterruptedException {
        initComponents();
        control();
        addEvents();
        ClockTime();
    }

    private void control() {

        pnlCard = new JPanel(cards);
//        pnlTrangchu = new JPanel();
//        pnlTrangchu.setBackground(Color.MAGENTA);
        pnlQLDiem = new JPanel();
        pnlQLGiangvien = new JPanel();
        pnlQLHocvien = new JPanel();
        pnlQLKhoahoc = new JPanel();
        pnlDangky = new JPanel();

        QLyHocVien hocvien = new QLyHocVien();
        hocvien.setVisible(true);
        pnlQLHocvien.add(hocvien);

        QLyGiangVien giangvien = new QLyGiangVien();
        giangvien.setVisible(true);
        pnlQLGiangvien.add(giangvien);

        QLyDiem diem = new QLyDiem();
        diem.setVisible(true);
        pnlQLDiem.add(diem);

        QLyKhoaHoc khoahoc = new QLyKhoaHoc();
        khoahoc.setVisible(true);
        pnlQLKhoahoc.add(khoahoc);

        DangKy dangky = new DangKy();
        dangky.setVisible(true);
        pnlDangky.add(dangky);

//        pnlCard.add(pnlTrangchu,"1");
        pnlCard.add(pnlQLHocvien, "1");
        pnlCard.add(pnlQLDiem, "2");
        pnlCard.add(pnlQLGiangvien, "3");
        pnlCard.add(pnlQLKhoahoc, "4");
        pnlCard.add(pnlDangky, "5");

        cards.show(pnlCard, "1");
        pnlView.add(pnlCard);

    }

    private void addEvents() {

        listMenuLeft = new ArrayList<>();

        listMenuLeft.add(pnlMenu_HV);
        listMenuLeft.add(pnlMenu_Diem);
        listMenuLeft.add(pnlMenu_GV);
        listMenuLeft.add(pnlMenu_KH);
        listMenuLeft.add(pnlMenu_DK);
//        listMenuLeft.add(pnlDangky);

        for (JPanel pnl : listMenuLeft) {
            pnl.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    String cardname = "";
                    if (pnl == pnlMenu_HV) {
                        cardname = "1";
                    } else if (pnl == pnlMenu_Diem) {
                        cardname = "2";
                    } else if (pnl == pnlMenu_GV) {
                        cardname = "3";
                    } else if (pnl == pnlMenu_KH) {
                        cardname = "4";
                    } else if (pnl == pnlMenu_DK) {
                        cardname = "5";
                    }

                    cards.show(pnlCard, cardname);
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
        }
    }

    private void ClockTime() throws InterruptedException {

        Thread clock = new Thread(){
            public void run(){
                try {
                    while (true) {
                        Calendar cal = new GregorianCalendar();
                        int second = cal.get(Calendar.SECOND);
                        int minute = cal.get(Calendar.MINUTE);
                        int hour = cal.get(Calendar.HOUR_OF_DAY);
                        String thu = null;
                        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
                        if (dayOfWeek == 1) {
                            thu = "Sunday";
                        } else if (dayOfWeek == 2) {
                            thu = "Monday";
                        }else if (dayOfWeek == 3){
                            thu = "Tuesday";
                        } else if (dayOfWeek == 4){
                            thu = "Wednesday";
                        } else if (dayOfWeek == 5){
                            thu = "Thursday";
                        } else if (dayOfWeek == 6){
                            thu = "Friday";
                        } else if (dayOfWeek == 7){
                            thu = "Saturday";
                        }
                        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
                        int month = cal.get(Calendar.MONTH);
                        int year = cal.get(Calendar.YEAR);

                        lblCLock.setText(hour + ":" + minute + ":" + second);
                        lblDate.setText(thu + ", " + dayOfMonth + "/" + (month + 1) + "/" + year);
                        sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        clock.start();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        nevPane = new javax.swing.JPanel();
        lblClose = new javax.swing.JLabel();
        lblMinimize = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pnlMenu_HV = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnlMenu_DK = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlMenu_KH = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pnlMenu_Diem = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pnlMenu_GV = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblCLock = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        pnlView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(930, 590));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nevPane.setBackground(new java.awt.Color(102, 102, 255));
        nevPane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        nevPane.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                nevPaneMouseDragged(evt);
            }
        });
        nevPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nevPaneMousePressed(evt);
            }
        });
        nevPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClose.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\QLySV\\src\\main\\java\\image\\outline_cancel_black_24dp.png")); // NOI18N
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });
        nevPane.add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 2, -1, -1));

        lblMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMinimize.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\QLySV\\src\\main\\java\\image\\outline_do_not_disturb_on_black_24dp.png")); // NOI18N
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseClicked(evt);
            }
        });
        nevPane.add(lblMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(844, 2, -1, -1));

        jPanel2.add(nevPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 30));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu_HV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlMenu_HV.setToolTipText("");
        pnlMenu_HV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Quản lý học viên");
        pnlMenu_HV.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 30));

        jPanel1.add(pnlMenu_HV, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 150, 50));

        pnlMenu_DK.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlMenu_DK.setToolTipText("");
        pnlMenu_DK.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đăng ký");
        pnlMenu_DK.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 29));

        jPanel1.add(pnlMenu_DK, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 150, 50));

        pnlMenu_KH.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlMenu_KH.setToolTipText("");
        pnlMenu_KH.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Quản lý khóa học");
        pnlMenu_KH.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 28));

        jPanel1.add(pnlMenu_KH, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 150, 50));

        pnlMenu_Diem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlMenu_Diem.setToolTipText("");
        pnlMenu_Diem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Quản lý điểm");
        pnlMenu_Diem.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 28));

        jPanel1.add(pnlMenu_Diem, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 150, 50));

        pnlMenu_GV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlMenu_GV.setToolTipText("");
        pnlMenu_GV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Quản lý giảng viên");
        pnlMenu_GV.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 30));

        jPanel1.add(pnlMenu_GV, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 150, 50));

        lblCLock.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCLock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCLock.setText("Time");
        jPanel1.add(lblCLock, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 130, 30));

        lblDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDate.setText("Date");
        jPanel1.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 100, 200, 30));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 230, 560));

        pnlView.setBackground(new java.awt.Color(204, 204, 255));
        pnlView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlView.setPreferredSize(new java.awt.Dimension(810, 560));
        pnlView.setLayout(new java.awt.CardLayout());
        jPanel2.add(pnlView, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 700, 560));
        pnlView.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nevPaneMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nevPaneMouseDragged
        // TODO add your handling code here:
        setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);
    }//GEN-LAST:event_nevPaneMouseDragged

    private void nevPaneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nevPaneMousePressed
        // TODO add your handling code here:
        posX = evt.getX();
        posY = evt.getY();
    }//GEN-LAST:event_nevPaneMousePressed

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

    private void lblMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseClicked
        // TODO add your handling code here:
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_lblMinimizeMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main a;
                try {
                    a = new Main();
                    a.setVisible(true);
                    a.setLocationRelativeTo(null);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCLock;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JPanel nevPane;
    private javax.swing.JPanel pnlMenu_DK;
    private javax.swing.JPanel pnlMenu_Diem;
    private javax.swing.JPanel pnlMenu_GV;
    private javax.swing.JPanel pnlMenu_HV;
    private javax.swing.JPanel pnlMenu_KH;
    private javax.swing.JPanel pnlView;
    // End of variables declaration//GEN-END:variables
}
