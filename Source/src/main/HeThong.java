package main;


import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

import module.SetCenter;

import view.ThongTaiKhoan;


public class HeThong extends JPanel implements ActionListener {
	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
    private JToolBar tbr;
    private JButton btnlogout,btnMyAcc,btnTheme;
    private Home trangchu;
    private JLabel lblNewLabel;
    public HeThong(Home home){
    	
    	this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.trangchu = home;
        this.tbr = new JToolBar();
        tbr.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        add(tbr);
        tbr.setOrientation(JToolBar.VERTICAL);
        btnlogout = new JButton("Đăng xuất",new ImageIcon("media/images/logout.png"));
        btnlogout.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnlogout.setVerticalTextPosition(JButton.BOTTOM);
        btnlogout.setHorizontalTextPosition(JButton.CENTER);
        tbr.add(this.btnlogout);
        btnlogout.addActionListener(this);
        
        btnMyAcc = new JButton("Thông tin tài khoản",new ImageIcon("media/images/User-icon.png"));
        btnMyAcc.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnMyAcc.setVerticalTextPosition(JButton.BOTTOM);
        btnMyAcc.setHorizontalTextPosition(JButton.CENTER);
        tbr.add(this.btnMyAcc);
        btnMyAcc.addActionListener(this);
        
        btnTheme = new JButton(new ImageIcon("media/images/icons_themes.png"));
        btnTheme.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnTheme.setVerticalTextPosition(JButton.BOTTOM);
        btnTheme.setHorizontalTextPosition(JButton.CENTER);
        tbr.add(this.btnTheme);
        DoiGiaoDien theme = new DoiGiaoDien(home);
        tbr.add(theme);
        
        lblNewLabel = new JLabel("                                       ");
        lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        tbr.add(lblNewLabel);

    }
    public void closeMenu() {
		this.setVisible(false);
	}
    @Override
    public void actionPerformed(ActionEvent e) {
    	
        if(e.getSource()== this.btnlogout){
        	int yN = JOptionPane.showConfirmDialog(new JFrame(), "Bạn có chắc chắn muốn thoát", "Thoát", JOptionPane.YES_NO_OPTION);
        	if(yN == 0)
        	{
        		System.exit(0);
        	}
        		
			
        }
        
        if(e.getSource()== this.btnMyAcc){
            	if(this.trangchu.paneCenter.positionTab("Tài khoản") > -1){
            		return;
            		}else if(this.trangchu.paneCenter.positionTab("Tài khoản") == -1){
            			try {
    						this.trangchu.paneCenter.addTab(new ThongTaiKhoan(), "Tài khoản");
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

