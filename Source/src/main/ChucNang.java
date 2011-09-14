package main;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import view.QuanLiDoiTac;


public class ChucNang extends JPanel implements ActionListener {
    private JToolBar tbr;
    private JButton btnDoiTac,btnNhanVien;
    private MainApp trangchu;
    public ChucNang(MainApp trangchu){
    	this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.trangchu = trangchu;
        this.tbr = new JToolBar();
        this.add(tbr);
        tbr.setEnabled(false);
        tbr.setOrientation(JToolBar.VERTICAL);
        btnDoiTac = new JButton("Quản lí đối tác",new ImageIcon("media/images/icon-DoiTac.png"));
        btnDoiTac.setVerticalTextPosition(JButton.BOTTOM);
        btnDoiTac.setHorizontalTextPosition(JButton.CENTER);
        tbr.add(this.btnDoiTac);
        btnDoiTac.addActionListener(this);
        
        btnNhanVien = new JButton("Quản lí nhân viên",new ImageIcon("media/images/icon-NhanVien.png"));
        btnNhanVien.setVerticalTextPosition(JButton.BOTTOM);
        btnNhanVien.setHorizontalTextPosition(JButton.CENTER);
        tbr.add(this.btnNhanVien);
        btnNhanVien.addActionListener(this);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	
        if(e.getSource()== this.btnDoiTac){
        	if(this.trangchu.paneCenter.positionTab("Đối tác") > -1){
        		return;
        		}else if(this.trangchu.paneCenter.positionTab("Đối tác") == -1){
        			try {
						this.trangchu.paneCenter.addTab(new QuanLiDoiTac(), "Đối tác");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			//this.trangchu.paneCenter.addTab(new MuaHang(trangchu), "Mua Hàng");
            		
        		this.trangchu.paneCenter.setSelectedIndex( this.trangchu.paneCenter.getTabCount()-1);
        		}
//                this.trangchu.paneCenter.add("Mua Hàng",new JButton("jfbsgbksnkgs"));		
//                this.trangchu.paneCenter.add("Mua Hàng",new MuaHang(trangchu));
        }
        
        if(e.getSource()== this.btnNhanVien){
        	if(this.trangchu.paneCenter.positionTab("Nhân Viên") > -1){
        		return;
        		}else if(this.trangchu.paneCenter.positionTab("Nhân Viên") == -1){
        			this.trangchu.paneCenter.addTab(new JButton("jfbsgbksnkgs"), "Nhân Viên");
        		this.trangchu.paneCenter.setSelectedIndex( this.trangchu.paneCenter.getTabCount()-1);
        		}
        }
        
        int count = this.trangchu.paneCenter.getTabCount();
        for(int i=0;i<count;i++){
                this.trangchu.paneCenter.setTabComponentAt(i, new ButtonTabComponent(this.trangchu.paneCenter));

        }
    }
}

