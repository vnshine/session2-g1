/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LoginForm.java
 *
 * Created on Aug 15, 2011, 9:46:18 AM
 */
package admin;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import module.SetCenter;

/**
 *
 * @author maytinh
 */
public class LoginForm extends javax.swing.JFrame {
    
    /** Creates new form LoginForm */
    
    public LoginForm() 
    {
        initComponents();   
    }

    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panDangNhap = new javax.swing.JPanel();
        lblMaNhanVien = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        lblMatKhau = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        chkNhoTaiKhoan = new javax.swing.JCheckBox();
        lblQuyenMatKhau = new javax.swing.JLabel();
        btnDangNhap = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        lblThongBao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setName("frmLogin"); // NOI18N

        panDangNhap.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ThĂ´ng tin tĂ i khoáº£n", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.black)); // NOI18N

        lblMaNhanVien.setText("MĂ£ nhĂ¢n viĂªn: ");

        txtMaNhanVien.setText("admin");

        lblMatKhau.setText("Máº­t kháº©u: ");

        txtMatKhau.setText("admin");

        chkNhoTaiKhoan.setText("Nhá»› tĂ i khoáº£n");

        lblQuyenMatKhau.setForeground(new java.awt.Color(0, 51, 255));
        lblQuyenMatKhau.setText("QuyĂªn máº­t kháº©u?");
        lblQuyenMatKhau.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnDangNhap.setText("Ä�Äƒng nháº­p");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        btnThoat.setText("ThoĂ¡t");

        lblThongBao.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblThongBao.setForeground(new java.awt.Color(255, 0, 0));
        lblThongBao.setText(" ");

        javax.swing.GroupLayout panDangNhapLayout = new javax.swing.GroupLayout(panDangNhap);
        panDangNhap.setLayout(panDangNhapLayout);
        panDangNhapLayout.setHorizontalGroup(
            panDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDangNhapLayout.createSequentialGroup()
                .addGroup(panDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panDangNhapLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(btnDangNhap)
                        .addGap(18, 18, 18)
                        .addComponent(btnThoat))
                    .addGroup(panDangNhapLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaNhanVien)
                            .addComponent(lblMatKhau))
                        .addGap(18, 18, 18)
                        .addGroup(panDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblThongBao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                            .addGroup(panDangNhapLayout.createSequentialGroup()
                                .addComponent(chkNhoTaiKhoan)
                                .addGap(18, 18, 18)
                                .addComponent(lblQuyenMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                            .addComponent(txtMaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panDangNhapLayout.setVerticalGroup(
            panDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDangNhapLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaNhanVien)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatKhau)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkNhoTaiKhoan)
                    .addComponent(lblQuyenMatKhau))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThoat)
                    .addComponent(btnDangNhap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblThongBao))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    /*
     * ***********************************************
     * CĂ¡c hĂ m phá»¥c vá»¥ cĂ¡c chá»©c nÄƒng
     */
    private Boolean isValidInput(String sMaNhanVien, String sMatKhau)
    {
        Boolean result = true;
        if(sMaNhanVien.equals(""))
        {
            lblMaNhanVien.setForeground(Color.red);
            lblThongBao.setText("MĂ£ nhĂ¢n viĂªn lĂ  báº¯t buá»™c!");
            return false;
        }
        if(sMaNhanVien.length() != 6)
        {
            lblMaNhanVien.setForeground(Color.red);
            lblThongBao.setText("MĂ£ nhĂ¢n viĂªn gá»“m 6 kĂ½ tá»±!");
            return false;
        }
        
        if(sMatKhau.equals(""))
        {
            lblMatKhau.setForeground(Color.red);
            lblThongBao.setText("Máº­t kháº©u lĂ  báº¯t buá»™c!");
            return false;
        }
        
        if(sMatKhau.length() < 4)
        {
            lblMatKhau.setForeground(Color.red);
            lblThongBao.setText("Máº­t kháº©u pháº£i lá»›n hÆ¡n 4 kĂ½ tá»±!");
            return false;
        }
        return result;
    }
    
    
private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        String sMaNhanVien = txtMaNhanVien.getText().trim().toUpperCase();
        String sMatKhau = txtMatKhau.getText().trim();
        
        if(! isValidInput(sMaNhanVien, sMatKhau))
        {
            return;
        }
        
        LoginCode vaLogin = new LoginCode();
        if(vaLogin.ValidLogin(sMaNhanVien, sMatKhau))
        {
            JOptionPane.showMessageDialog(this, "Ä�Äƒng nháº­p thĂ nh cĂ´ng!","Ä�Äƒng nháº­p",JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            panDangNhap.setForeground(Color.yellow);
            lblThongBao.setText("Sai mĂ£ nhĂ¢n viĂªn hoáº·c máº­t kháº©u!");
            //JOptionPane.showMessageDialog(this, "Ä�Äƒng nháº­p khĂ´ng thĂ nh cĂ´ng!\nSai mĂ£ nhĂ¢n viĂªn hoáº·c máº­t kháº©u.","Ä�Äƒng nháº­p",JOptionPane.WARNING_MESSAGE);
        }
}//GEN-LAST:event_btnDangNhapActionPerformed

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
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() 
            {
                LoginForm frmLogin = new LoginForm();
                                                
                frmLogin.setVisible(true);
                
                SetCenter setCenter = new SetCenter(frmLogin);
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnThoat;
    private javax.swing.JCheckBox chkNhoTaiKhoan;
    private javax.swing.JLabel lblMaNhanVien;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblQuyenMatKhau;
    private javax.swing.JLabel lblThongBao;
    private javax.swing.JPanel panDangNhap;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JPasswordField txtMatKhau;
    // End of variables declaration//GEN-END:variables
}
