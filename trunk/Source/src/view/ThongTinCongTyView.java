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

import java.awt.Color;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import module.SetCenter;
import module.ThongBao;
import myobject.ThongTinCongTy;
import process.ThongTinCongTy_Process;
import admin.LoginForm;


/**
 *
 * @author vietanh
 */
public class ThongTinCongTyView extends javax.swing.JFrame 
{

    DefaultTableModel model = null;
    Object[][] rowData = {};
    String[] columnNames = {};
    
    String action; //Biáº¿n ghi nháº­n ngÆ°á»�i dÃ¹ng nháº¥n vÃ o nÃºt nÃ o

    ThongTinCongTy_Process pro;
    String old_id;
    
    /** Creates new form fraChucNang */
    public ThongTinCongTyView() 
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
        if (searchOnOff == false) {
        	soTrang =(int) Math.floor(pro.soPhanTu()/8 + 1);
		}else {
			soTrang =(int) Math.floor(pro.soPhanTuSearch()/8 + 1);
		}
        
        label_1.setText(String.valueOf(soTrang));
        FillToTable(1);
        thisTrang = 1;
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
        textField_5.setEditable(flag);
        textField.setEditable(flag);
        textField_1.setEditable(flag);
        textField_2.setEditable(flag);
        textField_3.setEditable(flag);
        textField_4.setEditable(flag);
        
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
        textField_5.setText("");
    }
    
    public Boolean ValidInput()
    {
        
        
        
        
        return true;
    }
    
    public void FillToTable(Integer trang)
    {
        textField_6.setText(String.valueOf(trang));
        Vector<ThongTinCongTy> getResult = new Vector<ThongTinCongTy>();
        try 
        {	
        		getResult = pro.showList(trang);
			
            
            if(getResult.isEmpty())
            {
                new ThongBao(lblTrangThai, Color.gray, "Danh sách trống!");
            }
            else
            {
                new ThongBao(lblTrangThai, Color.BLUE, "Danh sách gồm " +String.valueOf(pro.soPhanTu()) + " công ty!");
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
    
    public void SearchToTable(Integer trang)
    {
        textField_6.setText(String.valueOf(trang));
        Vector<ThongTinCongTy> getResult = new Vector<ThongTinCongTy>();
        try 
        {
        	getResult = pro.searchList(trang,txtID.getText(),txtTen.getText(),textField_5.getText(),textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText());
            if(getResult.isEmpty())
            {
                new ThongBao(lblTrangThai, Color.gray, "Danh sách trống!");
            }
            else
            {
                new ThongBao(lblTrangThai, Color.BLUE, "Danh sách gồm " +String.valueOf(pro.soPhanTuSearch()) + " công ty!");
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
        lblID = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();
        lblSdt = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
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

        lblID.setText("ID: *");

        lblTen.setText("Tên Công Ty: ");

        lblDiaChi.setText("Địa Chỉ: *");
        
        lblSdt.setText("SĐT: ");

        lblThongBao.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblThongBao.setText("* Là bắt buộc");
        
        textField = new JTextField();
        textField.setColumns(10);
        
        JLabel lblEmail_1 = new JLabel("Email: ");
        
        JLabel lblWebsite_1 = new JLabel("Website: ");
        
        JLabel lblTinT = new JLabel("Tiền tệ : *");
        
        JLabel lblSLng = new JLabel("Số lượng:");
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        
        textField_5 = new JTextField();
        textField_5.setColumns(10);
        
        JLabel lblS = new JLabel("SĐT:");

        javax.swing.GroupLayout gl_jPanel2 = new javax.swing.GroupLayout(jPanel2);
        gl_jPanel2.setHorizontalGroup(
        	gl_jPanel2.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanel2.createSequentialGroup()
        			.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_jPanel2.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_jPanel2.createSequentialGroup()
        							.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING, false)
        								.addComponent(lblEmail_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(lblID, Alignment.LEADING)
        								.addComponent(lblTen, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        							.addGap(18)
        							.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
        								.addComponent(txtID, GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
        								.addComponent(txtTen, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
        								.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
        								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
        								.addGroup(gl_jPanel2.createSequentialGroup()
        									.addGap(175)
        									.addComponent(lblSLng)
        									.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE))
        								.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING, false)
        									.addGroup(gl_jPanel2.createSequentialGroup()
        										.addComponent(lblDiaChi)
        										.addGap(26))
        									.addGroup(gl_jPanel2.createSequentialGroup()
        										.addComponent(lblWebsite_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        										.addPreferredGap(ComponentPlacement.RELATED))
        									.addGroup(Alignment.LEADING, gl_jPanel2.createSequentialGroup()
        										.addComponent(lblS)
        										.addPreferredGap(ComponentPlacement.RELATED))))
        							.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
        								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        								.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        								.addComponent(textField_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        								.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)))
        						.addComponent(lblTinT)))
        				.addGroup(gl_jPanel2.createSequentialGroup()
        					.addGap(96)
        					.addComponent(lblThongBao, GroupLayout.DEFAULT_SIZE, 1392, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        gl_jPanel2.setVerticalGroup(
        	gl_jPanel2.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanel2.createSequentialGroup()
        			.addGroup(gl_jPanel2.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblID)
        				.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblDiaChi))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_jPanel2.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtTen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblTen)
        				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblS))
        			.addGap(18)
        			.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_jPanel2.createParallelGroup(Alignment.BASELINE)
        					.addComponent(lblEmail_1)
        					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_jPanel2.createParallelGroup(Alignment.BASELINE)
        					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(lblWebsite_1)))
        			.addGap(18)
        			.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_jPanel2.createParallelGroup(Alignment.BASELINE)
        					.addComponent(lblTinT)
        					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_jPanel2.createParallelGroup(Alignment.BASELINE)
        					.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(lblSLng)))
        			.addGap(18)
        			.addComponent(lblThongBao)
        			.addGap(39))
        );
        jPanel2.setLayout(gl_jPanel2);

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
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });
        
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
        
        btnFirst = new JButton("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        btnPrev = new JButton("Prev");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });
        btnNt = new JButton("Next");
        btnNt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNtActionPerformed(evt);
            }
        });
        btnLast = new JButton("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });
        JLabel label = new JLabel("/");
        
        label_1 = new JLabel();
        textField_6 = new JTextField();
        textField_6.setColumns(10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 1510, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(163)
        			.addComponent(btnFirst)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnPrev)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(btnNt)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnLast)
        			.addGap(74)
        			.addComponent(lblTrangThai, GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
        			.addContainerGap())
        		.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 1510, Short.MAX_VALUE)
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, 1500, Short.MAX_VALUE)
        			.addContainerGap())
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addComponent(panChucNang, GroupLayout.DEFAULT_SIZE, 1500, Short.MAX_VALUE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(panChucNang, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
        			.addGap(16)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(lblTrangThai)
        				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(btnFirst)
        					.addComponent(btnPrev)
        					.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(label)
        					.addComponent(label_1)
        					.addComponent(btnNt)
        					.addComponent(btnLast)))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);
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
        textField_5.setText(String.valueOf(tblChucNang.getValueAt(row, 3)));
        
        
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
                textField_5.setText(String.valueOf(tblChucNang.getValueAt(row, 2)));
                
            
            
        
    }//GEN-LAST:event_btnXoaActionPerformed
    
    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
    	btnLuu.setText("Tìm");
        OnOffEdit(true);
        searchOnOff = true;
        action = "search";
}
    
    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        FillToTable(soTrang);
        thisTrang = soTrang;
    }
    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        FillToTable(1);
        thisTrang = 1;
    }
    private void btnNtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
    	if (thisTrang < soTrang) {
			thisTrang ++ ;
			FillToTable(thisTrang);
		}else {
			
		}
        
        
    }
    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
    	if (thisTrang > 1) {
			thisTrang -- ;
			FillToTable(thisTrang);
		}else {
			
		}
        
    }
    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
       
        if(ValidInput())
        {
            
           
            
            if (action.equals("delete"))
            {
                
                try
                {
                	pro.deleteCongTy(old_id);
                    OnOffEdit(false);
                    new ThongBao(lblThongBao, Color.BLUE, "Đã xóa thông tin công ty thành công");
                    ResetInput();;
                    FillToTable(1);
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
            else if (action.equals("search"))
            {
                
                try
                {
                   
                	
                    pro.searchCongTy(txtID.getText(),txtTen.getText(),textField_5.getText(),textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText());
                    System.out.println(txtID.getText());
                    OnOffEdit(false);
                    SearchToTable(1);
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
            	ThongTinCongTyView congTy_View = new ThongTinCongTyView();
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblTen;
    private javax.swing.JLabel label_1;
    private javax.swing.JLabel lblSdt;
    private javax.swing.JLabel lblThongBao;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JScrollPane panChucNang;
    private javax.swing.JTable tblChucNang;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtTen;
    private int row;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JButton btnLast;
    private JButton btnFirst;
    private JButton btnPrev;
    private JButton btnNt;
    private Integer soTrang = null;
    private Integer thisTrang = null;
    private Boolean searchOnOff = false;
}

