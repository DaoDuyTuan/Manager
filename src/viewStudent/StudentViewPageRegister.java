/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewStudent;

import ControlManagement.StudentMna;
import ModelManagerment.Course;
import ModelManagerment.Course_Student;
import ViewMangement.loginForm;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DuyTuan
 */
public class StudentViewPageRegister extends javax.swing.JFrame {

    /**
     * Creates new form StudentViewPageRegister
     */
    Course_Student course_student;
    DefaultTableModel courseTable;
    StudentMna studentControl;
    loginForm login;
    private List<String> listCourseDelete = new ArrayList<>();
    public StudentViewPageRegister() {
        initComponents();
        courseTable = new DefaultTableModel();
        studentControl = new StudentMna();
        courseTable.addColumn("courseID");
        courseTable.addColumn("courseName");
        courseTable.addColumn("courseAmount");
        courseTable.addColumn("Date");
        jTable1.setModel(courseTable);
        delete.setEnabled(false);

        displayInitial();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txtC = new javax.swing.JTextField();
        insert = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        done = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        refresh = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtC.setText("courseID");
        txtC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCFocusLost(evt);
            }
        });
        txtC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCMouseClicked(evt);
            }
        });
        txtC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCActionPerformed(evt);
            }
        });

        insert.setText("Send");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 0));
        jLabel1.setText("Register Course");

        back.setText("Back");

        done.setText("Done");
        done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jLabel2.setText("CourseID:");

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(insert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(done)
                        .addGap(41, 41, 41))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(211, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delete)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(txtC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete)
                    .addComponent(jLabel2)
                    .addComponent(refresh))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(done)
                    .addComponent(insert))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Register Course", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("User", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab3", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void doneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_doneActionPerformed

    private void txtCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCActionPerformed

    private void txtCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_txtCFocusLost

    private void txtCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCMouseClicked
        // TODO add your handling code here:
        txtC.setText("");
    }//GEN-LAST:event_txtCMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        courseTable.setRowCount(0);
        String id = txtC.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String format = dateFormat.format(date);
        studentControl.registerCourse(id);
        for (Map.Entry<String, Course> course : StudentMna.listCourseRegistered.entrySet()) {
            courseTable.addRow(new Object[]{course.getValue().getCourseID(), course.getValue().getCourseName(), course.getValue().getCourseAmount(), format});
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        // TODO add your handling code here:
        int checkInserted = 0;
        int checkSuccessful = 0;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String format = dateFormat.format(date);

        if (StudentMna.listCourseRegistered == null) {
            JOptionPane.showMessageDialog(this, "You have not course!");
            return;
        }
        for (String object1 : StudentMna.checkCourseIDWhenInsertDB) {
            for (String object2 : StudentMna.listCourseWhenLoadDB) {
                if (object1.equals(object2)) {
                    checkInserted++;
                }
            }
            if (checkInserted == 0) {
                studentControl.insertCourseOfStudent(object1, "124", format);
                checkInserted = 0;
                checkSuccessful++;
            }
        }
        
        if (checkSuccessful != 0) {
            JOptionPane.showMessageDialog(this, "Them thanh cong");
            StudentMna.checkCourseIDWhenInsertDB.clear();
        } else if (checkSuccessful == 0) {
            JOptionPane.showMessageDialog(this, "Ban chua them moi hoc phan!");
        }
    }//GEN-LAST:event_insertActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        Vector vt = (Vector) courseTable.getDataVector().elementAt(jTable1.getSelectedRow());
        String courseID = (String) vt.elementAt(0);
        listCourseDelete.add((String) vt.elementAt(0));

        for (String object : listCourseDelete) {
            System.out.println(object);
        }
        delete.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        ///Lay ve courseID cua row duoc chon.
        Vector vt = (Vector) courseTable.getDataVector().elementAt(jTable1.getSelectedRow());
        String courseID = (String) vt.elementAt(0);
        ///
        courseTable.setRowCount(0);
        String mssv = "124";
        if (studentControl.deleteStudent(courseID, mssv)) {
            StudentMna.listCourseRegistered.remove(courseID);
            StudentMna.listCourseWhenLoadDB.remove(courseID);
            List<Course> viewCourseByMSSV = studentControl.viewCourseByMSSV(mssv);
            for (Map.Entry<String, Course> course : StudentMna.listCourseRegistered.entrySet()) {
                courseTable.addRow(new Object[]{course.getValue().getCourseID(), course.getValue().getCourseName(),
                    course.getValue().getCourseAmount(), course.getValue().getDate()});
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        courseTable.setRowCount(0);
        displayInitial();
    }//GEN-LAST:event_refreshActionPerformed

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
            java.util.logging.Logger.getLogger(StudentViewPageRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentViewPageRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentViewPageRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentViewPageRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentViewPageRegister().setVisible(true);
            }
        });
    }

    public void displayInitial() {
        List<Course> viewCourseByMSSV = studentControl.viewCourseByMSSV("124");
        for (Map.Entry<String, Course> course : StudentMna.listCourseRegistered.entrySet()) {
            courseTable.addRow(new Object[]{course.getValue().getCourseID(), course.getValue().getCourseName(), course.getValue().getCourseAmount(), course.getValue().getDate()});
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton delete;
    private javax.swing.JButton done;
    private javax.swing.JButton insert;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton refresh;
    private javax.swing.JTextField txtC;
    // End of variables declaration//GEN-END:variables
}
