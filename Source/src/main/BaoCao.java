package main;


import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;

import view.BaoCaoDoanhThuTheoThang;
import view.ThongTaiKhoan;


public class BaoCao extends JPanel implements ActionListener {
    private JToolBar tbr;
    private JButton btnBaoCaoDoanhThuThang;
    private Home trangchu;
    private JLabel lblNewLabel;
    public BaoCao(Home home){
    	
    	this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.trangchu = home;
        this.tbr = new JToolBar();
        tbr.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        add(tbr);
        tbr.setOrientation(JToolBar.VERTICAL);
        
        btnBaoCaoDoanhThuThang = new JButton("Báo cáo doanh thu theo tháng",new ImageIcon("media/images/User-icon.png"));
        btnBaoCaoDoanhThuThang.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnBaoCaoDoanhThuThang.setVerticalTextPosition(JButton.BOTTOM);
        btnBaoCaoDoanhThuThang.setHorizontalTextPosition(JButton.CENTER);
        tbr.add(this.btnBaoCaoDoanhThuThang);
        btnBaoCaoDoanhThuThang.addActionListener(this);
        
        lblNewLabel = new JLabel("                                       ");
        lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        tbr.add(lblNewLabel);

    }
    public void closeMenu() {
		this.setVisible(false);
	}
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()== this.btnBaoCaoDoanhThuThang){
            	if(this.trangchu.paneCenter.positionTab("Báo cáo") > -1){
            		return;
            		}else if(this.trangchu.paneCenter.positionTab("Báo cáo") == -1){
            			try {
    						this.trangchu.paneCenter.addTab(new BaoCaoDoanhThuTheoThang(), "Báo cáo");
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

