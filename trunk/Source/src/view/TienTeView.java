/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * fraChucNang.java
 *
 * Created on Aug 15, 2011, 10:30:08 AM
 */
package view;

import admin.LoginForm;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import module.SetCenter;
import myobject.ChucNang;
import myobject.TienTe;
import process.ChucNangProcess;
import process.TienTe_Process;
import module.ThongBao;


/**
 *
 * @author vietanh
 */
public class TienTeView extends javax.swing.JFrame 
{

    DefaultTableModel model = null;
    Object[][] rowData = {};
    String[] columnNames = {};
    
    String action; //Biáº¿n ghi nháº­n ngÆ°á»�i dÃ¹ng nháº¥n vÃ o nÃºt nÃ o

    TienTe_Process pro;
    String id, ten, ghichu;
    String old_id;
    
    /** Creates new form fraChucNang */
    public TienTeView() 
    {
        initComponents();
        
        columnNames = new String[] {"ID", "Mã tiền tệ", "Mua vào", "Bán ra"};
        model = new DefaultTableModel(rowData, columnNames);
        tblChucNang = new JTable(model)
        {
            public boolean isCellEditable(int rowIndex, int colIndex) 
            {
                    return false; //Disallow the editing of any cell
            }
        };
        tblChucNang.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblChucNang.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        tblChucNang.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        panChucNang.setViewportView(tblChucNang);

        pro = new TienTe_Process();
        
        
        //Hien du lieu ra bang
        FillToTable();
    }

    
    public void OnOffEdit(Boolean flag)
    {
        btnThem.setEnabled(!flag);
        btnSua.setEnabled(!flag);
        btnXoa.setEnabled(!flag);
        btnLuu.setEnabled(flag);
        btnHuy.setEnabled(flag);
        btnTim.setEnabled(!flag);
        
        txtMa.setEditable(flag);
        txtMuaVao.setEditable(flag);
        txtBanRa.setEditable(flag);
    }
    
    public void ResetError()
    {
        lblMa.setForeground(Color.BLACK);
        lblMuaVao.setForeground(Color.BLACK);
        lblBanRa.setForeground(Color.BLACK);
        lblThongBao.setForeground(Color.BLACK);
        lblThongBao.setText(" ");
    }
    
    public void ResetInput()
    {
        txtMa.setText("");
        txtMuaVao.setText("");
        txtBanRa.setText("");
    }
    
    public Boolean ValidInput()
    {
        if(txtMa.getText().equals(""))
        {
            new ThongBao(lblThongBao, Color.RED, "Mã tiền tệ không dược phép để trống");
            lblMa.setForeground(Color.RED);
            return false;
        }
        
        if(txtMa.getText().length() < 3 || txtMa.getText().length() > 20)
        {
            new ThongBao(lblThongBao, Color.RED, "Mã tiền tệ lớn hơn 3 chữ cái!");
            lblMa.setForeground(Color.RED);
            return false;
        }
        
        
        return true;
    }
    
    public void FillToTable()
    {
        TienTe_Process pro = new TienTe_Process();
        Vector<TienTe> getResult = new Vector<TienTe>();
        try 
        {
            getResult = pro.showList();
            if(getResult.isEmpty())
            {
                new ThongBao(lblTrangThai, Color.gray, "Danh sách trống!");
            }
            else
            {
                new ThongBao(lblTrangThai, Color.BLUE, "Danh sách gồm " + getResult.size() + " loại mã tiền tệ!");
                model.setRowCount(0);
                columnNames = new String[] {"ID", "Mã tiền tệ", "Mua vào", "Bán ra"};

                for(int i=0;i<getResult.size();i++)
                {
                    Object[] temp = {getResult.get(i).getIdTienTe(), getResult.get(i).getTenTienTe(), getResult.get(i).getTyGiaMuaVao(), getResult.get(i).getTyGiaBanRa()};
                    model.insertRow(tblChucNang.getRowCount(), temp);
                }
            }
        }
        catch(SQLException ex) 
        {
           new ThongBao(lblTrangThai, Color.RED, "Káº¿t ná»‘i tá»›i cÆ¡ sá»Ÿ dá»¯ liá»‡u gáº·p váº¥n Ä‘á»�!");
           JOptionPane.showMessageDialog(this, "Lá»—i: " + ex.getMessage(), "Lá»—i SQL",JOptionPane.ERROR_MESSAGE);
        }
                
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtMa = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtBanRa = new javax.swing.JTextField();
        lblMa = new javax.swing.JLabel();
        lblBanRa = new javax.swing.JLabel();
        lblMuaVao = new javax.swing.JLabel();
        txtMuaVao = new javax.swing.JTextField();
        lblThongBao = new javax.swing.JLabel();
        panChucNang = new javax.swing.JScrollPane();
        tblChucNang = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        lblTrangThai = new javax.swing.JLabel();

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
        jScrollPane3.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frmChucNang"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 255)));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 100));

        javax.swing.GroupLayout gl_jPanel1 = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(gl_jPanel1);
        gl_jPanel1.setHorizontalGroup(
            gl_jPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 882, Short.MAX_VALUE)
        );
        gl_jPanel1.setVerticalGroup(
            gl_jPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dữ liệu"));

        txtBanRa.setColumns(10);
        
        jScrollPane2.setViewportView(txtBanRa);

        lblMa.setText("Mã tiền tệ: *");

        lblMuaVao.setText("Mua vào: ");

        lblBanRa.setText("Bán ra: ");

        lblThongBao.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblThongBao.setText("* Là bắt buộc");

        javax.swing.GroupLayout gl_jPanel2 = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(gl_jPanel2);
        gl_jPanel2.setHorizontalGroup(
            gl_jPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_jPanel2.createSequentialGroup()
                .addContainerGap()
                .addGroup(gl_jPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMa)
                    .addComponent(lblMuaVao))
                .addGap(18, 18, 18)
                .addGroup(gl_jPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblThongBao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                    .addGroup(gl_jPanel2.createSequentialGroup()
                        .addGroup(gl_jPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMuaVao, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(lblBanRa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE))))
        );
        gl_jPanel2.setVerticalGroup(
            gl_jPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_jPanel2.createSequentialGroup()
                .addGroup(gl_jPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(gl_jPanel2.createSequentialGroup()
                        .addGroup(gl_jPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMa)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBanRa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(gl_jPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMuaVao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMuaVao)))
                    .addComponent(jScrollPane2, 0, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblThongBao)
                .addContainerGap())
        );

        panChucNang.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách"));

        tblChucNang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TÃªn chá»©c nÄƒng", "Ghi chÃº"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        panChucNang.setViewportView(tblChucNang);
        tblChucNang.getColumnModel().getColumn(0).setResizable(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tác vụ"));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnTim.setText("Tìm kiếm");

        javax.swing.GroupLayout gl_jPanel3 = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(gl_jPanel3);
        gl_jPanel3.setHorizontalGroup(
            gl_jPanel3.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_jPanel3.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLuu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHuy)
                .addContainerGap(488, Short.MAX_VALUE))
        );
        gl_jPanel3.setVerticalGroup(
            gl_jPanel3.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_jPanel3.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnThem)
                .addComponent(btnSua)
                .addComponent(btnXoa)
                .addComponent(btnTim)
                .addComponent(btnLuu)
                .addComponent(btnHuy))
        );

        lblTrangThai.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblTrangThai.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThai)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        
        OnOffEdit(true);
        ResetInput();
        action = "add";
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
       
        OnOffEdit(true);
        action = "edit";
//        old_id = txtMa.getText();
        row = tblChucNang.getSelectedRow();
        old_id = (String)tblChucNang.getValueAt(row, 0);
        txtMa.setText((String)tblChucNang.getValueAt(row, 1));
        txtMuaVao.setText(String.valueOf(tblChucNang.getValueAt(row, 2)));
        txtBanRa.setText(String.valueOf(tblChucNang.getValueAt(row, 3)));
        
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
            
            	new ThongBao(lblThongBao, Color.RED, "Bạn phải chắc chắn là muốn xóa");
                OnOffEdit(true);
                action = "delete";
                row = tblChucNang.getSelectedRow();
                old_id = (String)tblChucNang.getValueAt(row, 0);
                txtMa.setText((String)tblChucNang.getValueAt(row, 1));
                txtMuaVao.setText(String.valueOf(tblChucNang.getValueAt(row, 2)));
                txtBanRa.setText(String.valueOf(tblChucNang.getValueAt(row, 3)));
                
            
            
        
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
       
        if(ValidInput())
        {
            if(action.equals("add"))
            {
//                if(pro.TrungMa(id, ten)) // Náº¿u trÃ¹ng chá»©c nÄƒng
//                {
//                    lblMa.setForeground(Color.RED);
//                    lblMuaVao.setForeground(Color.RED);
//                    new ThongBao(lblThongBao, Color.RED, "Má»™t chá»©c nÄƒng tÆ°Æ¡ng tá»± Ä‘Ã£ tá»“n táº¡i!");
//                    return;
//                }
                
                try
                {
                
                    
                    pro.insertTienTe(txtMa.getText(), Float.parseFloat(txtMuaVao.getText()), Float.parseFloat(txtBanRa.getText()));
                    OnOffEdit(false);
                    new ThongBao(lblThongBao, Color.BLUE, "Thêm thành công!");
                    ResetInput();
                    FillToTable();
                    ResetError();
                }
                catch(SQLException ex)
                {
                    new ThongBao(lblThongBao, Color.RED, "ThÃªm chá»©c nÄƒng khÃ´ng thÃ nh cÃ´ng!");
                    JOptionPane.showMessageDialog(this, "Lá»—i SQL: " + ex.getMessage(), "Lá»—i SQL", JOptionPane.ERROR_MESSAGE);
                    ResetError();
                    ResetInput();
                }
            }
            else if (action.equals("edit"))
            {
                
                try
                {
//                    ChucNang temp = new ChucNang(id, ten, ghichu);
                	row = tblChucNang.getSelectedRow();
                    pro.updateTienTe(old_id, txtMa.getText(), Float.parseFloat(txtMuaVao.getText()),Float.parseFloat(txtBanRa.getText()));
                    OnOffEdit(false);
                    new ThongBao(lblThongBao, Color.BLUE, "Sửa thành công!");
                    FillToTable();
                    ResetInput();
                    ResetError();
                }
                catch(SQLException ex)
                {
                    new ThongBao(lblThongBao, Color.RED, "Sá»­a chá»©c nÄƒng khÃ´ng thÃ nh cÃ´ng!");
                    JOptionPane.showMessageDialog(this, "Lá»—i SQL: " + ex.getMessage(), "Lá»—i SQL", JOptionPane.ERROR_MESSAGE);
                    ResetError();
                    ResetInput();
                }
            }
            
            else if (action.equals("delete"))
            {
                
                try
                {
                	pro.deleteTienTe(old_id);
                    OnOffEdit(false);
                    new ThongBao(lblThongBao, Color.BLUE, "Đã xóa mã tiền tệ thành công");
                    ResetInput();;
                    FillToTable();
                }
                catch(SQLException ex)
                {
                    new ThongBao(lblThongBao, Color.RED, "Có lỗi xảy ra! Xóa không thành công ");
                    JOptionPane.showMessageDialog(this, "Lá»—i SQL: " + ex.getMessage(), "Lá»—i SQL", JOptionPane.ERROR_MESSAGE);
                    ResetError();
                    ResetInput();
                }
            }
        }
        
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        
        OnOffEdit(false);
        ResetError();
        ResetInput();
    }//GEN-LAST:event_btnHuyActionPerformed

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
            java.util.logging.Logger.getLogger(fraChucNang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fraChucNang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fraChucNang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fraChucNang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

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
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {

            public void run() 
            {
                TienTeView tienView = new TienTeView();
                SetCenter setCenter = new SetCenter(tienView);
                tienView.setVisible(true);
                tienView.OnOffEdit(false);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblBanRa;
    private javax.swing.JLabel lblMa;
    private javax.swing.JLabel lblMuaVao;
    private javax.swing.JLabel lblThongBao;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JScrollPane panChucNang;
    private javax.swing.JTable tblChucNang;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMuaVao;
    private javax.swing.JTextField txtBanRa;
    private int row;
    // End of variables declaration//GEN-END:variables
}
