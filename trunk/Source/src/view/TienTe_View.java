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

import javax.swing.JButton;
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
import myobject.TienTe;
import process.TienTe_Process;
import module.ThongBao;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 *
 * @author vietanh
 */
public class TienTe_View extends javax.swing.JFrame 
{

    DefaultTableModel model = null;
    Object[][] rowData = {};
    String[] columnNames = {};
    
    String action; //Biáº¿n ghi nháº­n ngÆ°á»�i dÃ¹ng nháº¥n vÃ o nÃºt nÃ o

    TienTe_Process pro;
    String id, ten, ghichu;
    String old_id;
    
    /** Creates new form fraChucNang */
    public TienTe_View() 
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
        soTrang =(int) Math.floor(pro.soPhanTu()/8 + 1);
        label_1.setText(String.valueOf(soTrang));
        
        //Hien du lieu ra bang
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
        btnShow.setEnabled(!flag);
        
        txtMa.setEditable(flag);
        txtMuaVao.setEditable(flag);
        txtBanRa.setEditable(flag);
        textField.setEditable(flag);
    }
    
    public void ResetError()
    {
    	lblId.setForeground(Color.BLACK);
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
        textField.setText("");
    }
    
    public Boolean ValidInput()
    {
        if(txtMa.getText().equals(""))
        {
            new ThongBao(lblThongBao, Color.RED, "Mã tiền tệ không dược phép để trống");
            lblMa.setForeground(Color.RED);
            return false;
        }
        
        if(textField.getText().equals("") && searchOnOff == false)
        {
            new ThongBao(lblThongBao, Color.RED, "ID tiền tệ không dược phép để trống");
            lblId.setForeground(Color.RED);
            return false;
        }
        
        if((txtMa.getText().length() < 3 || txtMa.getText().length() > 20) && searchOnOff == false)
        {
            new ThongBao(lblThongBao, Color.RED, "Mã tiền tệ lớn hơn 3 chữ cái!");
            lblMa.setForeground(Color.RED);
            return false;
        }
        
        
        return true;
    }
    
    public void FillToTable(Integer trang)
    {
    	textField_6.setText(String.valueOf(trang));
        Vector<TienTe> getResult = new Vector<TienTe>();
        try 
        {
            getResult = pro.showList(trang);
            if(getResult.isEmpty())
            {
                new ThongBao(lblTrangThai, Color.gray, "Danh sách trống!");
            }
            else
            {
                new ThongBao(lblTrangThai, Color.BLUE, "Danh sách gồm " + String.valueOf(pro.soPhanTu()) + " loại mã tiền tệ!");
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
    
    public void SearchToTable(Integer trang)
    {
    	textField_6.setText(String.valueOf(trang));
        Vector<TienTe> getResult = new Vector<TienTe>();
        try 
        {
            getResult = pro.searchList(trang);
            if(getResult.isEmpty())
            {
                new ThongBao(lblTrangThai, Color.gray, "Danh sách trống!");
            }
            else
            {
                new ThongBao(lblTrangThai, Color.BLUE, "Danh sách gồm " + String.valueOf(pro.soPhanTuSearch()) + " loại mã tiền tệ!");
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
//        jScrollPane2 = new javax.swing.JScrollPane();
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
        btnShow = new javax.swing.JButton();
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

        lblMa.setText("Mã tiền tệ: *");

        lblMuaVao.setText("Mua vào: ");

        lblBanRa.setText("Bán ra: ");

        lblThongBao.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblThongBao.setText("* Là bắt buộc");
        
        lblId = new JLabel("ID: *");
        
        textField = new JTextField();
        textField.setColumns(10);

        javax.swing.GroupLayout gl_jPanel2 = new javax.swing.GroupLayout(jPanel2);
        gl_jPanel2.setHorizontalGroup(
        	gl_jPanel2.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanel2.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblMa)
        				.addComponent(lblId))
        			.addGap(18)
        			.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblThongBao, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
        				.addGroup(gl_jPanel2.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(textField)
        						.addComponent(txtMa, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblBanRa)
        						.addComponent(lblMuaVao))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(txtBanRa)
        						.addComponent(txtMuaVao, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
        					.addContainerGap())))
        );
        gl_jPanel2.setVerticalGroup(
        	gl_jPanel2.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanel2.createSequentialGroup()
        			.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
        				.addComponent(txtBanRa, 0, 0, Short.MAX_VALUE)
        				.addGroup(gl_jPanel2.createParallelGroup(Alignment.BASELINE)
        					.addComponent(lblBanRa)
        					.addComponent(lblId)
        					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_jPanel2.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtMuaVao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblMuaVao)
        				.addComponent(txtMa)
        				.addComponent(lblMa))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(lblThongBao)
        			.addContainerGap())
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

        btnShow.setText("Danh Sách");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });
        
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

        btnLuu.setText("  ");
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
                .addComponent(btnShow)
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
                .addComponent(btnShow)
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
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
    	searchOnOff = false;
    	soTrang =(int) Math.floor(pro.soPhanTu()/8 + 1);
    	label_1.setText(String.valueOf(soTrang));
    	thisTrang = 1;
    	FillToTable(1);
        
    }
    
    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
    	btnLuu.setText("Tìm");
        OnOffEdit(true);
        searchOnOff = true;
        action = "search";
    }
    
    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
    	if (searchOnOff == false) {
    		
    		FillToTable(soTrang);
            thisTrang = soTrang;
		}else if (searchOnOff == true) {
			
    		SearchToTable(soTrang);
            thisTrang = soTrang;
		}
        
    }
    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        
    	if (searchOnOff == false) {
			FillToTable(1);
			thisTrang = 1;
		}else if (searchOnOff == true) {
			SearchToTable(1);
			thisTrang = 1;
		}
    	
    }
    private void btnNtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
    	if (searchOnOff == false) {
    		if (thisTrang < soTrang) {
    			thisTrang ++ ;
    			FillToTable(thisTrang);
    		}else {
				
			}
		}else if (searchOnOff == true) {
			if (thisTrang < soTrang) {
    			thisTrang ++ ;
    			SearchToTable(thisTrang);
    		}else {
				
			}
		}
    	
        
        
    }
    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
    	if (searchOnOff == false) {
    		if (thisTrang > 1) {
    			thisTrang -- ;
    			FillToTable(thisTrang);
    		}else {
    			
    		}
		}else if (searchOnOff == true) {
			if (thisTrang > 1) {
				thisTrang -- ;
				SearchToTable(thisTrang);
			}else {
				
			}
		}
        
    }
    
    
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
        txtMa.setText((String)tblChucNang.getValueAt(row, 1));
        txtMuaVao.setText(String.valueOf(tblChucNang.getValueAt(row, 2)));
        txtBanRa.setText(String.valueOf(tblChucNang.getValueAt(row, 3)));
        
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
            
            	new ThongBao(lblThongBao, Color.RED, "Bạn phải chắc chắn là muốn xóa");
            	btnLuu.setText("Xóa");
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
                
                    
                    pro.insertTienTe(textField.getText(), txtMa.getText(), Float.parseFloat(txtMuaVao.getText()), Float.parseFloat(txtBanRa.getText()));
                    OnOffEdit(false);
                    new ThongBao(lblThongBao, Color.BLUE, "Thêm thành công!");
                    ResetInput();
                    FillToTable(1);
                    soTrang =(int) Math.floor(pro.soPhanTu()/8 + 1);
                    label_1.setText(String.valueOf(soTrang));
                    thisTrang = 1;
                    ResetError();
                    btnLuu.setText("  ");
                }
                catch(SQLException ex)
                {
                    new ThongBao(lblThongBao, Color.RED, "ThÃªm chá»©c nÄƒng khÃ´ng thÃ nh cÃ´ng!");
                    JOptionPane.showMessageDialog(this, "Lá»—i SQL: " + ex.getMessage(), "Lá»—i SQL", JOptionPane.ERROR_MESSAGE);
                    ResetError();
                    ResetInput();
                }
            }
            else if (action.equals("search"))
            {
                
                try
                {
                   
                	
                    pro.searchTienTe(textField.getText(), txtMa.getText());
                    OnOffEdit(false);
                    soTrang =(int) Math.floor(pro.soPhanTuSearch()/8 + 1);
                    label_1.setText(String.valueOf(soTrang));
                    thisTrang = 1;
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
            else if (action.equals("edit"))
            {
                
                try
                {
//                    ChucNang temp = new ChucNang(id, ten, ghichu);
                	row = tblChucNang.getSelectedRow();
                    pro.updateTienTe(old_id, txtMa.getText(), Float.parseFloat(txtMuaVao.getText()),Float.parseFloat(txtBanRa.getText()));
                    OnOffEdit(false);
                    new ThongBao(lblThongBao, Color.BLUE, "Sửa thành công!");
                    FillToTable(1);
                    soTrang =(int) Math.floor(pro.soPhanTu()/8 + 1);
                    label_1.setText(String.valueOf(soTrang));
                    thisTrang = 1;
                    ResetInput();
                    ResetError();
                    btnLuu.setText("  ");
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
                    FillToTable(1);
                    soTrang =(int) Math.floor(pro.soPhanTu()/8 + 1);
                    label_1.setText(String.valueOf(soTrang));
                    thisTrang = 1;
                    ResetInput();
                    ResetError();
                    btnLuu.setText("  ");
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
                TienTe_View tienView = new TienTe_View();
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
//    private javax.swing.JScrollPane jScrollPane2;
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
    private JTextField textField;
    private JButton btnLast;
    private JButton btnFirst;
    private JButton btnPrev;
    private JButton btnNt;
    private Integer soTrang = null;
    private Integer thisTrang = null;
    private Boolean searchOnOff = false;
    private JTextField textField_6;
    private javax.swing.JLabel label_1;
    private javax.swing.JButton btnShow;
    private javax.swing.JLabel lblId;
}
