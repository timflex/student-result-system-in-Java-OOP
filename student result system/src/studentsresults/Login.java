package studentsresults;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Robert
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_username = new javax.swing.JLabel();
        jl_password = new javax.swing.JLabel();
        jb_login = new javax.swing.JButton();
        jb_cancel = new javax.swing.JButton();
        jtf_name = new javax.swing.JTextField();
        jpf_password = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Students Results System");
        setBackground(new java.awt.Color(0, 204, 153));
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(550, 540));
        setPreferredSize(new java.awt.Dimension(550, 340));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(null);

        jl_username.setText("User Name");
        getContentPane().add(jl_username);
        jl_username.setBounds(190, 100, 70, 15);

        jl_password.setText("Password");
        getContentPane().add(jl_password);
        jl_password.setBounds(190, 170, 60, 15);

        jb_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        jb_login.setText("Login");
        jb_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_loginActionPerformed(evt);
            }
        });
        getContentPane().add(jb_login);
        jb_login.setBounds(250, 230, 80, 30);

        jb_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lock.png"))); // NOI18N
        jb_cancel.setText("Cancel");
        jb_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelActionPerformed(evt);
            }
        });
        getContentPane().add(jb_cancel);
        jb_cancel.setBounds(370, 230, 87, 30);

        jtf_name.setToolTipText("  Enter your Username");
        jtf_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_nameActionPerformed(evt);
            }
        });
        getContentPane().add(jtf_name);
        jtf_name.setBounds(300, 90, 157, 28);

        jpf_password.setText("123");
        getContentPane().add(jpf_password);
        jpf_password.setBounds(300, 160, 157, 28);

        jLabel4.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel4.setText("STUDENT  RESULTS  SYSTEM");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(95, 23, 340, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelActionPerformed
        JOptionPane.showMessageDialog(null, "WELL THANKS FOR YOUR TIME \n      AND GOOODBYE......");
        System.exit(0);
    }//GEN-LAST:event_jb_cancelActionPerformed

    private void jtf_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nameActionPerformed

    private void jb_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_loginActionPerformed
        try {
            // initialize connection
            connect con = new connect();
            try {
                // set sql statement
                 con.setSql("SELECT * FROM login WHERE username='" + jtf_name.getText() + "' and password='" + jpf_password.getText() + "'");
                // get result set
                ResultSet rs = con.getResultSet();
                if (rs.next()) {
                    switch (rs.getString("type")) {
                        case "student":
                            JLabel label = new JLabel(jpf_password.getText().toUpperCase());

                            Student student_panel = new Student(label);
                            student_panel.setVisible(true);
                            student_panel.setResizable(false);
                            student_panel.setLocationRelativeTo(null);

//                            welcome alert
                            student_panel.getContentPane().add(label);

                            break;
                        case "adminstrator":
                            Admin admin_panel = new Admin();
                            admin_panel.setVisible(true);
                            admin_panel.setResizable(false);
                            admin_panel.setLocationRelativeTo(null);

//                            welcome alert
                            JLabel label1 = new JLabel(jtf_name.getText().toUpperCase());
                            label1.setFont(new Font("times new romans", Font.BOLD, 20));
                            label1.setForeground(Color.red);
                            admin_panel.setVisible(true);
                            admin_panel.getContentPane().add(label1);
                            label1.setBounds(640, 10, 100, 20);
                            break;
                        case "lecturer":
                            Lecturer lect_panel = new Lecturer();
                            lect_panel.setVisible(true);
                            lect_panel.setResizable(false);
                            lect_panel.setLocationRelativeTo(null);

//                            welcome panel
                            JLabel lect_label = new JLabel(jtf_name.getText().toUpperCase());
                            lect_label.setForeground(Color.blue);
                            lect_panel.setFont(new Font("times new romans", Font.BOLD, 20));
                            lect_panel.getContentPane().add(lect_label);
                            lect_label.setBounds(700, 0, 100, 25);
                            break;

                    }
                    jtf_name.setText("");
                    jpf_password.setText("");
                    this.dispose();
                } else {

                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Invalid", JOptionPane.ERROR_MESSAGE);
                }
                con.con.close();

            } catch (SQLException | HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "Invalid username or password2", "Invalid", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null, ex.toString());
                jtf_name.setText("");
                jpf_password.setText("");
            }
        } catch (HeadlessException x) {
            JOptionPane.showMessageDialog(null, "Unable to connect to the database", "Connection error", JOptionPane.ERROR_MESSAGE);
            System.out.println(x.toString());
        }
    }//GEN-LAST:event_jb_loginActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login loginPanel = new Login();
//                frame.setSize(550, 540);
                loginPanel.setVisible(true);
                loginPanel.setResizable(false);
                loginPanel.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jb_cancel;
    private javax.swing.JButton jb_login;
    private javax.swing.JLabel jl_password;
    private javax.swing.JLabel jl_username;
    private javax.swing.JPasswordField jpf_password;
    private javax.swing.JTextField jtf_name;
    // End of variables declaration//GEN-END:variables
}
