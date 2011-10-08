package main;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import view.QuanLiNhomHang;


public class HangHoa extends JPanel implements ActionListener {
    private JToolBar tbr;
    private JButton btnNhomHang,btnHangHoa;
    private MainApp trangchu;
    public HangHoa(MainApp trangchu){
    	this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.trangchu = trangchu;
        this.tbr = new JToolBar();
        this.add(tbr);
        tbr.setEnabled(false);
        tbr.setOrientation(JToolBar.VERTICAL);

        btnNhomHang = new JButton("Quản lí nhóm hàng",new ImageIcon("media/images/nhomhang-icon.png"));
        btnNhomHang.setVerticalTextPosition(JButton.BOTTOM);
        btnNhomHang.setHorizontalTextPosition(JButton.CENTER);
        tbr.add(this.btnNhomHang);
        btnNhomHang.addActionListener(this);

        btnHangHoa = new JButton("Quản lí hàng hóa",new ImageIcon("media/images/hanghoa -icon.png"));
        btnHangHoa.setVerticalTextPosition(JButton.BOTTOM);
        btnHangHoa.setHorizontalTextPosition(JButton.CENTER);
        tbr.add(this.btnHangHoa);
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
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        		this.trangchu.paneCenter.setSelectedIndex( this.trangchu.paneCenter.getTabCount()-1);
        		}
        }
        
        if(e.getSource()== this.btnHangHoa){
        	if(this.trangchu.paneCenter.positionTab("Hàng hóa") > -1){
        		return;
        		}else if(this.trangchu.paneCenter.positionTab("Hàng hóa") == -1){
        			try {
						this.trangchu.paneCenter.addTab(new QuanLiNhomHang(), "Hàng hóa");
					} catch (SQLException e1) {
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

