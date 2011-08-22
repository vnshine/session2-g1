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
import java.awt.Dimension;
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
import myobject.ThongTinCongTy;
import myobject.TienTe;
import process.ChucNangProcess;
import process.ThongTinCongTy_Process;
import process.TienTe_Process;
import module.ThongBao;


/**
 *
 * @author vietanh
 */
public class ThongTinCongTy_View extends javax.swing.JFrame 
{

    DefaultTableModel model = null;
    Object[][] rowData = {};
    String[] columnNames = {};
    
    String action; //Biáº¿n ghi nháº­n ngÆ°á»�i dÃ¹ng nháº¥n vÃ o nÃºt nÃ o

    ThongTinCongTy_Process pro;
    String old_id;
    
    /** Creates new form fraChucNang */
    public ThongTinCongTy_View() 
    {
        initComponents();
        
        columnNames = new String[] {"ID", "Tên công ty", "Địa chỉ", "Số điện thoại", "Email", "Website" , "Loại tiền sử dụng" , "Số lượng"};
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

        pro = new ThongTinCongTy_Process();
        
        
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
        
        txtID.setEditable(flag);
        txtTen.setEditable(flag);
        txtDiaChi.setEditable(flag);
    }
    
    public void ResetError()
    {
        lblID.setForeground(Color.BLACK);
        lblTen.setForeground(Color.BLACK);
        lblDiaChi.setForeground(Color.BLACK);
        lblThongBao.setForeground(Color.BLACK);
        lblThongBao.setText(" ");
    }
    
    public void ResetInput()
    {
        txtID.setText("");
        txtTen.setText("");
        txtDiaChi.setText("");
    }
    
    public Boolean ValidInput()
    {
        if(txtID.getText().equals(""))
        {
            new ThongBao(lblThongBao, Color.RED, "Mã tiền tệ không dược phép để trống");
            lblID.setForeground(Color.RED);
            return false;
        }
        
        if(txtID.getText().length() < 3 || txtID.getText().length() > 20)
        {
            new ThongBao(lblThongBao, Color.RED, "Mã tiền tệ lớn hơn 3 chữ cái!");
            lblID.setForeground(Color.RED);
            return false;
        }
        
        
        return true;
    }
    
    public void FillToTable()
    {
        ThongTinCongTy_Process pro = new ThongTinCongTy_Process();
        Vector<ThongTinCongTy> getResult = new Vector<ThongTinCongTy>();
        try 
        {
            getResult = pro.showList();
            if(getResult.isEmpty())
            {
                new ThongBao(lblTrangThai, Color.gray, "Danh sách trống!");
            }
            else
            {
                new ThongBao(lblTrangThai, Color.BLUE, "Danh sách gồm " + getResult.size() + " công ty!");
                model.setRowCount(0);
                columnNames = new String[] {"ID", "Tên công ty", "Địa chỉ", "Số điện thoại", "Email", "Website" , "Loại tiền sử dụng" , "Số lượng"};

                for(int i=0;i<getResult.size();i++)
                {
                    Object[] temp = {getResult.get(i).getIdCongTy(),getResult.get(i).getTenCongTy(),getResult.get(i).getDiaChiCongTy(),getResult.get(i).getSdtCongTy(),getResult.get(i).getEmailCongTy(),getResult.get(i).getWebCongTy(),getResult.get(i).getIdTienTe(),getResult.get(i).getSlTienMat()};
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
        txtID = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();
        lblSdt = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblWebsite = new javax.swing.JLabel();
        lblTienTe = new javax.swing.JLabel();
        lblSoluong = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtWebsite = new javax.swing.JTextField();
        txtTienTe = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
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

        
        
        jScrollPane2.setViewportView(txtDiaChi);

        lblID.setText("ID: *");

        lblTen.setText("Tên Công Ty: ");

        lblDiaChi.setText("Địa Chỉ: ");
        
        lblSdt.setText("SĐT: ");

        lblThongBao.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblThongBao.setText("* Là bắt buộc");

        javax.swing.GroupLayout gl_jPanel2 = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(gl_jPanel2);
        gl_jPanel2.setHorizontalGroup(
            gl_jPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_jPanel2.createSequentialGroup()
                .addContainerGap()
                .addGroup(gl_jPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblID)
                    .addComponent(lblTen))
                    
                .addGap(18, 18, 18)
                .addGroup(gl_jPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblThongBao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                    .addGroup(gl_jPanel2.createSequentialGroup()
                        .addGroup(gl_jPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(lblDiaChi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE))))
        );
        gl_jPanel2.setVerticalGroup(
            gl_jPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_jPanel2.createSequentialGroup()
                .addGroup(gl_jPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(gl_jPanel2.createSequentialGroup()
                        .addGroup(gl_jPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblID)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDiaChi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(gl_jPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTen)))
                            
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

        btnLuu.setText(" ");
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
    	btnLuu.setText("Lưu");
        OnOffEdit(true);
        ResetInput();
        action = "add";
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
    	btnLuu.setText("Lưu");
        OnOffEdit(true);
        action = "edit";
//        old_id = txtMa.getText();
        row = tblChucNang.getSelectedRow();
        old_id = (String)tblChucNang.getValueAt(row, 0);
        txtID.setText((String)tblChucNang.getValueAt(row, 1));
        txtTen.setText(String.valueOf(tblChucNang.getValueAt(row, 2)));
        txtDiaChi.setText(String.valueOf(tblChucNang.getValueAt(row, 3)));
        
    }//GEN-LAST:event_btnSuaActionPerformed
    
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
            
            	new ThongBao(lblThongBao, Color.RED, "Bạn phải chắc chắn là muốn xóa");
            	btnLuu.setText("Xóa");
                OnOffEdit(true);
                action = "delete";
                row = tblChucNang.getSelectedRow();
                old_id = (String)tblChucNang.getValueAt(row, 0);
                txtID.setText((String)tblChucNang.getValueAt(row, 0));
                txtTen.setText(String.valueOf(tblChucNang.getValueAt(row, 1)));
                txtDiaChi.setText(String.valueOf(tblChucNang.getValueAt(row, 2)));
                
            
            
        
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
                
                    
                    pro.insertCongTy(txtID.getText(), Float.parseFloat(txtTen.getText()), Float.parseFloat(txtDiaChi.getText()));
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
                   
                	row = tblChucNang.getSelectedRow();
                    pro.updateCongTy(old_id, txtID.getText(), Float.parseFloat(txtTen.getText()),Float.parseFloat(txtDiaChi.getText()));
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
                	pro.deleteCongTy(old_id);
                    OnOffEdit(false);
                    new ThongBao(lblThongBao, Color.BLUE, "Đã xóa thông tin công ty thành công");
                    ResetInput();;
                    FillToTable();
                    btnLuu.setText(" ");
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
            	ThongTinCongTy_View congTy_View = new ThongTinCongTy_View();
                SetCenter setCenter = new SetCenter(congTy_View);
                congTy_View.setVisible(true);
                congTy_View.OnOffEdit(false);
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
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblTen;
    private javax.swing.JLabel lblSdt;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblWebsite;
    private javax.swing.JLabel lblTienTe;
    private javax.swing.JLabel lblSoluong;
    private javax.swing.JLabel lblThongBao;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JScrollPane panChucNang;
    private javax.swing.JTable tblChucNang;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtWebsite;
    private javax.swing.JTextField txtTienTe;
    private javax.swing.JTextField txtSoLuong;
    private int row;
    // End of variables declaration//GEN-END:variables
}

