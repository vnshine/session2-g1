package main;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

import view.QuanLiDoiTac;
import view.QuanLiNhanVien;


public class NhanVien extends JPanel implements ActionListener {
    private JToolBar tbr;
    private JButton btnNhanVien;
    private MainApp trangchu;
    public NhanVien(MainApp trangchu){
    	this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.trangchu = trangchu;
        this.tbr = new JToolBar();
        this.add(tbr);
        tbr.setOrientation(JToolBar.VERTICAL);
        tbr.setEnabled(false);
        
        btnNhanVien = new JButton("Quản lí nhân viên",new ImageIcon("media/images/NhanVien-icon.png"));
        btnNhanVien.setVerticalTextPosition(JButton.BOTTOM);
        btnNhanVien.setHorizontalTextPosition(JButton.CENTER);
        tbr.add(this.btnNhanVien);
        btnNhanVien.addActionListener(this);
        

    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	
        if(e.getSource()== this.btnNhanVien){
        	if(this.trangchu.paneCenter.positionTab("Nhân Viên") > -1){
        		return;
        		}else if(this.trangchu.paneCenter.positionTab("Nhân Viên") == -1){
        			try {
						this.trangchu.paneCenter.addTab(new QuanLiNhanVien(), "Nhân Viên");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
        		this.trangchu.paneCenter.setSelectedIndex( this.trangchu.paneCenter.getTabCount()-1);
        		}
        }
        
        int count = this.trangchu.paneCenter.getTabCount();
        for(int i=0;i<count;i++){
                this.trangchu.paneCenter.setTabComponentAt(i, new ButtonTabComponent(this.trangchu.paneCenter));
        }
    }
}

