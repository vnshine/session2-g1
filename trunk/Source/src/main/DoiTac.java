package main;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import view.QuanLiDoiTac;
import view.QuanLiNhaSanXuat;
import javax.swing.JLabel;
import java.awt.Component;


public class DoiTac extends JPanel implements ActionListener {
    private JToolBar tbr;
    private JButton btnDoiTac,btnNhanVien,btnNSX;
    private Home trangchu;
    private JLabel label;
    public DoiTac(Home home){
    	this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.trangchu = home;
        this.tbr = new JToolBar();
        tbr.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        this.add(tbr);
        tbr.setEnabled(false);
        tbr.setOrientation(JToolBar.VERTICAL);
        btnDoiTac = new JButton("Quản lý đối tác",new ImageIcon("media/images/icon-DoiTac.png"));
        btnDoiTac.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDoiTac.setVerticalTextPosition(JButton.BOTTOM);
        btnDoiTac.setHorizontalTextPosition(JButton.CENTER);
        tbr.add(this.btnDoiTac);
        btnDoiTac.addActionListener(this);
        
        btnNSX = new JButton("Nhà sản xuất",new ImageIcon("media/images/Factory.png"));
        btnNSX.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnNSX.setVerticalTextPosition(JButton.BOTTOM);
        btnNSX.setHorizontalTextPosition(JButton.CENTER);
        tbr.add(this.btnNSX);
        
        label = new JLabel("                                            ");
        label.setAlignmentX(0.5f);
        tbr.add(label);
        btnNSX.addActionListener(this);

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
        		this.trangchu.paneCenter.setSelectedIndex( this.trangchu.paneCenter.getTabCount()-1);
        		}
        }
        if(e.getSource()== this.btnNSX){
        	if(this.trangchu.paneCenter.positionTab("Nhà sản xuất") > -1){
        		return;
        		}else if(this.trangchu.paneCenter.positionTab("Nhà sản xuất") == -1){
        			try {
						this.trangchu.paneCenter.addTab(new QuanLiNhaSanXuat(), "Nhà sản xuất");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
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

