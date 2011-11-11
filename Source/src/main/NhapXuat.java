package main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;

import view.QuanLiNhapXuat;
import javax.swing.JLabel;
import java.awt.Component;

public class NhapXuat extends JPanel implements ActionListener {
    private JToolBar tbr;
    private JButton btnDoiTac,btnNhanVien;
    private Home trangchu;
    public NhapXuat(Home home){
    	this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.trangchu = home;
        this.tbr = new JToolBar();
        tbr.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        this.add(tbr);
        tbr.setOrientation(JToolBar.VERTICAL);
        tbr.setEnabled(false);
        
        JLabel label = new JLabel("                                            ");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        tbr.add(label);
        btnDoiTac = new JButton("Quản lí Nhập Xuất",new ImageIcon("media/images/Phieu-thu-chi-nhap-xuat-A5-1-.png"));
        btnDoiTac.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDoiTac.setVerticalTextPosition(JButton.BOTTOM);
        btnDoiTac.setHorizontalTextPosition(JButton.CENTER);
        tbr.add(this.btnDoiTac);
        btnDoiTac.addActionListener(this);
        

    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	
        if(e.getSource()== this.btnDoiTac){
        	if(this.trangchu.paneCenter.positionTab("Phiếu nhập xuất") > -1){
        		return;
        		}else if(this.trangchu.paneCenter.positionTab("Phiếu nhập xuất") == -1){
        			try {
						this.trangchu.paneCenter.addTab(new QuanLiNhapXuat(), "Phiếu nhập xuất");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
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

