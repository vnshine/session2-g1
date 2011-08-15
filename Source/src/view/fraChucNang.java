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
import process.ChucNangProcess;
import module.ThongBao;


/**
 *
 * @author liemmaster
 */
public class fraChucNang extends javax.swing.JFrame 
{

    DefaultTableModel model = null;
    Object[][] rowData = {};
    String[] columnNames = {};
    
    String action; //Biến ghi nhận người dùng nhấn vào nút nào

    ChucNangProcess processAction;
    String id, ten, ghichu;
    String old_id;
    
    /** Creates new form fraChucNang */
    public fraChucNang() 
    {
        initComponents();
        
        columnNames = new String[] {"ID", "Tên chức năng", "Ghi chú"};
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

        processAction = new ChucNangProcess();
        
        
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
        
        txtMaChucNang.setEditable(flag);
        txtTenChucNang.setEditable(flag);
        txtaGhiChu.setEditable(flag);
    }
    
    public void ResetError()
    {
        lblID.setForeground(Color.BLACK);
        lblTen.setForeground(Color.BLACK);
        lblGhiChu.setForeground(Color.BLACK);
        lblThongBao.setForeground(Color.BLACK);
        lblThongBao.setText(" ");
    }
    
    public void ResetInput()
    {
        txtMaChucNang.setText("");
        txtTenChucNang.setText("");
        txtaGhiChu.setText("");
    }
    
    public Boolean ValidInput()
    {
        if(txtMaChucNang.getText().equals(""))
        {
            new ThongBao(lblThongBao, Color.RED, "ID không được phép trống");
            lblID.setForeground(Color.RED);
            return false;
        }
        
        if(txtMaChucNang.getText().length() < 6 || txtMaChucNang.getText().length() > 15)
        {
            new ThongBao(lblThongBao, Color.RED, "ID nằm trong khoảng từ 6 đến 15!");
            lblID.setForeground(Color.RED);
            return false;
        }
        
        if(txtTenChucNang.getText().equals(""))
        {
            new ThongBao(lblThongBao, Color.RED, "Tên chức năng không được phép trống");
            lblTen.setForeground(Color.RED);
            return false;
        }
        
        id = txtMaChucNang.getText();
        ten = txtTenChucNang.getText();
        ghichu = txtaGhiChu.getText();
        
        return true;
    }
    
    public void FillToTable()
    {
        ChucNangProcess prc = new ChucNangProcess();
        Vector<ChucNang> getResult = new Vector<ChucNang>();
        try 
        {
            getResult = prc.LayDanhSachChucNang();
            if(getResult.isEmpty())
            {
                new ThongBao(lblTrangThai, Color.gray, "Hiện tại không có chức năng nào!");
            }
            else
            {
                new ThongBao(lblTrangThai, Color.BLUE, "Tổng số " + getResult.size() + " chức năng!");
                model.setRowCount(0);
                columnNames = new String[] {"ID", "Tên chức năng", "Ghi chú"};

                for(int i=0;i<getResult.size();i++)
                {
                    Object[] temp = {getResult.get(i).getId(), getResult.get(i).getTenChucNang(), getResult.get(i).getGhiChu()};
                    model.insertRow(tblChucNang.getRowCount(), temp);
                }
            }
        }
        catch(SQLException ex) 
        {
           new ThongBao(lblTrangThai, Color.RED, "Kết nối tới cơ sở dữ liệu gặp vấn đề!");
           JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage(), "Lỗi SQL",JOptionPane.ERROR_MESSAGE);
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
        txtMaChucNang = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaGhiChu = new javax.swing.JTextArea();
        lblID = new javax.swing.JLabel();
        lblGhiChu = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();
        txtTenChucNang = new javax.swing.JTextField();
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 882, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dữ liệu"));

        txtaGhiChu.setColumns(20);
        txtaGhiChu.setRows(5);
        jScrollPane2.setViewportView(txtaGhiChu);

        lblID.setText("ID: *");

        lblGhiChu.setText("Ghi chú:");

        lblTen.setText("Tên chức năng: *");

        lblThongBao.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblThongBao.setText("* là bắt buộc");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblID)
                    .addComponent(lblTen))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblThongBao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(lblGhiChu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblID)
                            .addComponent(txtMaChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGhiChu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTen)))
                    .addComponent(jScrollPane2, 0, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblThongBao)
                .addContainerGap())
        );

        panChucNang.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách chức năng"));

        tblChucNang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên chức năng", "Ghi chú"
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
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
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
        old_id = txtMaChucNang.getText();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

        if(!ValidInput())
        {
            new ThongBao(lblThongBao, Color.RED, "Bạn phải chỉ định chức năng muốn xóa!");
        }
        else
        {
            try
            {
                processAction.XoaChucNang(id);
                OnOffEdit(false);
                new ThongBao(lblThongBao, Color.BLUE, "Xóa chức năng thành công!");
                ResetInput();;
                FillToTable();
            }
            catch(SQLException ex)
            {
                new ThongBao(lblThongBao, Color.RED, "Xóa chức năng không thành công!");
                JOptionPane.showMessageDialog(this, "Lỗi SQL: " + ex.getMessage(), "Lỗi SQL", JOptionPane.ERROR_MESSAGE);
                ResetError();
                ResetInput();
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
       
        if(ValidInput())
        {
            if(action.equals("add"))
            {
                if(processAction.TrungChucNang(id, ten)) // Nếu trùng chức năng
                {
                    lblID.setForeground(Color.RED);
                    lblTen.setForeground(Color.RED);
                    new ThongBao(lblThongBao, Color.RED, "Một chức năng tương tự đã tồn tại!");
                    return;
                }
                
                try
                {
                    ChucNang temp = new ChucNang(id, ten, ghichu);
                    processAction.ThemChucNang(temp);
                    OnOffEdit(false);
                    new ThongBao(lblThongBao, Color.BLUE, "Thêm chức năng thành công!");
                    ResetInput();
                    FillToTable();
                    ResetError();
                }
                catch(SQLException ex)
                {
                    new ThongBao(lblThongBao, Color.RED, "Thêm chức năng không thành công!");
                    JOptionPane.showMessageDialog(this, "Lỗi SQL: " + ex.getMessage(), "Lỗi SQL", JOptionPane.ERROR_MESSAGE);
                    ResetError();
                    ResetInput();
                }
            }
            else
            {
                
                try
                {
                    ChucNang temp = new ChucNang(id, ten, ghichu);
                    processAction.SuaChucNang(temp, old_id);
                    OnOffEdit(false);
                    new ThongBao(lblThongBao, Color.BLUE, "Sửa chức năng thành công!");
                    FillToTable();
                    ResetInput();
                    ResetError();
                }
                catch(SQLException ex)
                {
                    new ThongBao(lblThongBao, Color.RED, "Sửa chức năng không thành công!");
                    JOptionPane.showMessageDialog(this, "Lỗi SQL: " + ex.getMessage(), "Lỗi SQL", JOptionPane.ERROR_MESSAGE);
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
                fraChucNang chucNang = new fraChucNang();
                SetCenter setCenter = new SetCenter(chucNang);
                chucNang.setVisible(true);
                chucNang.OnOffEdit(false);
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
    private javax.swing.JLabel lblGhiChu;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblTen;
    private javax.swing.JLabel lblThongBao;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JScrollPane panChucNang;
    private javax.swing.JTable tblChucNang;
    private javax.swing.JTextField txtMaChucNang;
    private javax.swing.JTextField txtTenChucNang;
    private javax.swing.JTextArea txtaGhiChu;
    // End of variables declaration//GEN-END:variables
}
