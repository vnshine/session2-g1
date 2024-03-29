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
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import module.SetCenter;
import myobject.ChucNang;
import module.ThongBao;
import myobject.ObjQuyen;
import process.QuyenProcess;


/**
 *
 * @author liemmaster
 */
public class fraQuanLyQuyen extends javax.swing.JFrame 
{

    DefaultTableModel model = null;
    Object[][] rowData = {};
    String[] columnNames = {};
    
    String action; //Biến ghi nhận người dùng nhấn vào nút nào

    QuyenProcess processAction;
    String ten, ghichu;
    String old_name;
    
    /** Creates new form fraChucNang */
    public fraQuanLyQuyen() 
    {
        initComponents();
        new SetCenter(this);
        OnOffEdit(false);
        columnNames = new String[] {"Quyền", "Ghi chú"};
        model = new DefaultTableModel(rowData, columnNames);
        tblDanhSach = new JTable(model)
        {
            public boolean isCellEditable(int rowIndex, int colIndex) 
            {
                    return false; //Disallow the editing of any cell
            }
        };
        tblDanhSach.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblDanhSach.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        tblDanhSach.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        tblDanhSach.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        tblDanhSach.getColumnModel().getColumn(0).setPreferredWidth(100);
        
        panDanhSach.setViewportView(tblDanhSach);

        processAction = new QuyenProcess();

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
        
        txtTenQuyen.setEditable(flag);
        txtaGhiChu.setEditable(flag);
    }
    
    public void ResetError()
    {
        lblTen.setForeground(Color.BLACK);
        lblGhiChu.setForeground(Color.BLACK);
        lblThongBao.setForeground(Color.BLACK);
        lblThongBao.setText(" ");
    }
    
    public void ResetInput()
    {
        txtTenQuyen.setText("");
        txtaGhiChu.setText("");
    }
    
    public Boolean ValidInput()
    {   
        if(txtTenQuyen.getText().equals(""))
        {
            new ThongBao(lblThongBao, Color.RED, "Tên quyền không được phép trống");
            lblTen.setForeground(Color.RED);
            return false;
        }
        
        if(txtTenQuyen.getText().length() < 6 || txtTenQuyen.getText().length() > 100)
        {
            new ThongBao(lblThongBao, Color.RED, "Tên quyền nằm trong khoảng từ 6 đến 100!");
            lblTen.setForeground(Color.RED);
            return false;
        }
        
        ten = txtTenQuyen.getText();
        ghichu = txtaGhiChu.getText();
        
        return true;
    }
    
    public void FillToTable()
    {
        QuyenProcess prc = new QuyenProcess();
        Vector<ObjQuyen> getResult = new Vector<ObjQuyen>();
        try 
        {
            getResult = prc.LayDanhSachQuyen();
            if(getResult.isEmpty())
            {
                new ThongBao(lblTrangThai, Color.gray, "Danh sách quyền rỗng!");
            }
            else
            {
                new ThongBao(lblTrangThai, Color.BLUE, "Tổng số " + getResult.size() + " bản ghi.");
                model.setRowCount(0);
                for(int i=0;i<getResult.size();i++)
                {
                    Object[] temp = {getResult.get(i).getTen(), getResult.get(i).getGhiChu()};
                    
                    model.insertRow(tblDanhSach.getRowCount(), temp);
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

        panBanner = new javax.swing.JPanel();
        panDuLieu = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaGhiChu = new javax.swing.JTextArea();
        lblGhiChu = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();
        txtTenQuyen = new javax.swing.JTextField();
        lblThongBao = new javax.swing.JLabel();
        panDanhSach = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();
        panTacVu = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        lblTrangThai = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frmChucNang"); // NOI18N

        panBanner.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 255)));
        panBanner.setPreferredSize(new java.awt.Dimension(800, 100));

        javax.swing.GroupLayout panBannerLayout = new javax.swing.GroupLayout(panBanner);
        panBanner.setLayout(panBannerLayout);
        panBannerLayout.setHorizontalGroup(
            panBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );
        panBannerLayout.setVerticalGroup(
            panBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );

        panDuLieu.setBorder(javax.swing.BorderFactory.createTitledBorder("Dữ liệu"));

        txtaGhiChu.setColumns(20);
        txtaGhiChu.setRows(5);
        jScrollPane2.setViewportView(txtaGhiChu);

        lblGhiChu.setText("Ghi chú:");

        lblTen.setText("Tên quyền: *");

        lblThongBao.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblThongBao.setText("* bắt buộc");

        javax.swing.GroupLayout panDuLieuLayout = new javax.swing.GroupLayout(panDuLieu);
        panDuLieu.setLayout(panDuLieuLayout);
        panDuLieuLayout.setHorizontalGroup(
            panDuLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDuLieuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTen)
                .addGap(18, 18, 18)
                .addGroup(panDuLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panDuLieuLayout.createSequentialGroup()
                        .addComponent(txtTenQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblGhiChu))
                    .addComponent(lblThongBao, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panDuLieuLayout.setVerticalGroup(
            panDuLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panDuLieuLayout.createSequentialGroup()
                .addGroup(panDuLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGhiChu)
                    .addGroup(panDuLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTenQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTen)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblThongBao))
        );

        panDanhSach.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách quyền"));
        panDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panDanhSachMouseClicked(evt);
            }
        });

        tblDanhSach.setAutoCreateRowSorter(true);
        tblDanhSach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblDanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDanhSach.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tblDanhSach.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                tblDanhSachMouseWheelMoved(evt);
            }
        });
        tblDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachMouseClicked(evt);
            }
        });
        tblDanhSach.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tblDanhSachFocusGained(evt);
            }
        });
        panDanhSach.setViewportView(tblDanhSach);

        panTacVu.setBorder(javax.swing.BorderFactory.createTitledBorder("Tác vụ"));

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
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panTacVuLayout = new javax.swing.GroupLayout(panTacVu);
        panTacVu.setLayout(panTacVuLayout);
        panTacVuLayout.setHorizontalGroup(
            panTacVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTacVuLayout.createSequentialGroup()
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
                .addContainerGap(492, Short.MAX_VALUE))
        );
        panTacVuLayout.setVerticalGroup(
            panTacVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTacVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
            .addComponent(panBanner, javax.swing.GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
            .addComponent(panDuLieu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panTacVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panDanhSach, javax.swing.GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panDuLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panTacVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThai))
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
        old_name = txtTenQuyen.getText();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

        if(!ValidInput())
        {
            new ThongBao(lblThongBao, Color.RED, "Bạn phải chỉ định quyền muốn xóa!");
        }
        else
        {
            try
            {
                processAction.XoaQuyen(ten);
                OnOffEdit(false);
                new ThongBao(lblThongBao, Color.BLUE, "Xóa quyền thành công!");
                ResetInput();;
                FillToTable();
            }
            catch(SQLException ex)
            {
                new ThongBao(lblThongBao, Color.RED, "Xóa quyền không thành công!");
                JOptionPane.showMessageDialog(this, "Lỗi SQL: " + ex.getMessage(), "Lỗi SQL", JOptionPane.ERROR_MESSAGE);
                ResetError();
                ResetInput();
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
       
        if(action.equals("search"))
        {
            if(txtTenQuyen.getText().trim().length()<3)
            {
                new ThongBao(lblThongBao, Color.RED, "Từ khóa từ 3 ký tự trở lên!");
                lblTen.setForeground(Color.RED);
                return;
            }
            QuyenProcess prc = new QuyenProcess();
            Vector<ObjQuyen> getResult = new Vector<ObjQuyen>();
            try 
            {
                getResult = prc.TimQuyen(new ObjQuyen(1, txtTenQuyen.getText().trim(), txtaGhiChu.getText().trim()));
                System.out.println("Before"  + txtTenQuyen.getText().trim() + ", " + txtaGhiChu.getText().trim());
                if(getResult.isEmpty())
                {
                    new ThongBao(lblTrangThai, Color.blue, "Tìm kiếm không có kết quả!");
                }
                else
                {
                    new ThongBao(lblTrangThai, Color.BLUE, "Kết quả tìm kiếm: " + getResult.size() + " bản ghi.");
                    model.setRowCount(0);
                    for(int i=0;i<getResult.size();i++)
                    {
                        System.out.println(tblDanhSach.getRowCount());
                        System.out.println(getResult.get(i).getTen() + "\n" + getResult.get(i).getGhiChu());
                        Object[] temp = {getResult.get(i).getTen(), getResult.get(i).getGhiChu()};
                        model.insertRow(tblDanhSach.getRowCount(), temp);
                    }
                }
                ResetInput();
            }
            catch(SQLException ex) 
            {
               new ThongBao(lblTrangThai, Color.RED, "Kết nối tới cơ sở dữ liệu gặp vấn đề!");
               JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage(), "Lỗi SQL",JOptionPane.ERROR_MESSAGE);
            }
            finally
            {
                OnOffEdit(false);
                ResetError();
                btnLuu.setText("Tìm kiếm");
            }
        }
        else
        {
            if(ValidInput())
            {
                if(action.equals("add"))
                {
                    if(processAction.TrungQuyen(ten)) // Nếu trùng quyền
                    {
                        lblTen.setForeground(Color.RED);
                        new ThongBao(lblThongBao, Color.RED, "Một quyền tương tự đã tồn tại!");
                        return;
                    }

                    try
                    {
                        ObjQuyen temp = new ObjQuyen(1, ten, ghichu);
                        processAction.ThemQuyen(temp);
                        OnOffEdit(false);
                        new ThongBao(lblThongBao, Color.BLUE, "Thêm quyền thành công!");
                        ResetInput();
                        FillToTable();
                        ResetError();
                    }
                    catch(SQLException ex)
                    {
                        new ThongBao(lblThongBao, Color.RED, "Thêm quyền không thành công!");
                        JOptionPane.showMessageDialog(this, "Lỗi SQL: " + ex.getMessage(), "Lỗi SQL", JOptionPane.ERROR_MESSAGE);
                        ResetError();
                        ResetInput();
                    }
                }
                else
                if(action.equals("edit"))
                {

                    try
                    {
                        ObjQuyen temp = new ObjQuyen(1, ten, ghichu);
                        processAction.SuaQuyen(temp, old_name);
                        OnOffEdit(false);
                        new ThongBao(lblThongBao, Color.BLUE, "Sửa quyền thành công!");
                        FillToTable();
                        ResetInput();
                        ResetError();
                    }
                    catch(SQLException ex)
                    {
                        new ThongBao(lblThongBao, Color.RED, "Sửa quyền không thành công!");
                        JOptionPane.showMessageDialog(this, "Lỗi SQL: " + ex.getMessage(), "Lỗi SQL", JOptionPane.ERROR_MESSAGE);
                        ResetError();
                        ResetInput();
                    }
                }
            }
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        
        OnOffEdit(false);
        ResetError();
        ResetInput();
    }//GEN-LAST:event_btnHuyActionPerformed

private void tblDanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachMouseClicked

        JOptionPane.showMessageDialog(this, "click");
//        Integer selected = tblDanhSach.getSelectedRow();
//        txtTenQuyen.setText((String) tblDanhSach.getValueAt(selected, 0));
//        txtaGhiChu.setText((String) tblDanhSach.getValueAt(selected, 1));
}//GEN-LAST:event_tblDanhSachMouseClicked

private void tblDanhSachMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_tblDanhSachMouseWheelMoved
    
}//GEN-LAST:event_tblDanhSachMouseWheelMoved

private void tblDanhSachFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblDanhSachFocusGained

}//GEN-LAST:event_tblDanhSachFocusGained

private void panDanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panDanhSachMouseClicked
    
}//GEN-LAST:event_panDanhSachMouseClicked

private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
    OnOffEdit(true);
    ResetInput();
    action = "search";
    btnLuu.setText("Tìm");
}//GEN-LAST:event_btnTimActionPerformed

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
            java.util.logging.Logger.getLogger(fraQuanLyQuyen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fraQuanLyQuyen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fraQuanLyQuyen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fraQuanLyQuyen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

            @Override
            public void run() 
            {
                fraQuanLyQuyen chucNang = new fraQuanLyQuyen();
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblGhiChu;
    private javax.swing.JLabel lblTen;
    private javax.swing.JLabel lblThongBao;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JPanel panBanner;
    private javax.swing.JScrollPane panDanhSach;
    private javax.swing.JPanel panDuLieu;
    private javax.swing.JPanel panTacVu;
    private javax.swing.JTable tblDanhSach;
    private javax.swing.JTextField txtTenQuyen;
    private javax.swing.JTextArea txtaGhiChu;
    // End of variables declaration//GEN-END:variables
}
