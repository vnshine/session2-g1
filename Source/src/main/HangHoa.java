package main;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import view.QuanLiHangHoa;
import view.QuanLiNhomHang;
import javax.swing.JLabel;
import java.awt.Component;


public class HangHoa extends JPanel implements ActionListener {
    private JToolBar tbr;
    private JButton btnNhomHang,btnHangHoa;
    private Home trangchu;
    private JLabel label;
    public HangHoa(Home home){
    	this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.trangchu = home;
        this.tbr = new JToolBar();
        tbr.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        this.add(tbr);
        tbr.setEnabled(false);
        tbr.setOrientation(JToolBar.VERTICAL);

        btnNhomHang = new JButton("Quản lý nhóm hàng",new ImageIcon("media/images/nhomhang-icon.png"));
        btnNhomHang.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnNhomHang.setVerticalTextPosition(JButton.BOTTOM);
        btnNhomHang.setHorizontalTextPosition(JButton.CENTER);
        tbr.add(this.btnNhomHang);
        btnNhomHang.addActionListener(this);

        btnHangHoa = new JButton("Quản lý hàng hóa",new ImageIcon("media/images/hanghoa -icon.png"));
        btnHangHoa.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnHangHoa.setVerticalTextPosition(JButton.BOTTOM);
        btnHangHoa.setHorizontalTextPosition(JButton.CENTER);
        tbr.add(this.btnHangHoa);
        
        label = new JLabel("                                            ");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        tbr.add(label);
        btnHangHoa.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	
        if(e.getSource()== this.btnNhomHang){
        	if(this.trangchu.paneCenter.positionTab("Nhóm hàng") > -1){
        		return;
        		}else if(this.trangchu.paneCenter.positionTab("Nhóm hàng") == -1){
        			try {
						this.trangchu.paneCenter.addTab(new QuanLiNhomHang(), "Nhóm hàng");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        		this.trangchu.paneCenter.setSelectedIndex( this.trangchu.paneCenter.getTabCount()-1);
        		}
        }
        
        if(e.getSource()== this.btnHangHoa){
        	if(this.trangchu.paneCenter.positionTab("Hàng hóa") > -1){
        		return;
        		}else if(this.trangchu.paneCenter.positionTab("Hàng hsóa") == -1){
        			try {
						this.trangchu.paneCenter.addTab(new QuanLiHangHoa(), "Hàng hóa");
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

