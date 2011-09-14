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
import javax.swing.SwingConstants;
import java.awt.Component;


public class HeThong extends JPanel implements ActionListener {
    private JToolBar tbr;
    private JButton btnlogout,btnMyAcc,btnTheme;
    private MainApp trangchu;
    public HeThong(MainApp trangchu){
    	this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.trangchu = trangchu;
        this.tbr = new JToolBar();
        tbr.setEnabled(false);
        this.add(tbr);
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
        DoiGiaoDien theme = new DoiGiaoDien(trangchu);
        tbr.add(theme);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	
        if(e.getSource()== this.btnlogout){
        	
        }
        
        if(e.getSource()== this.btnMyAcc){
        	
        }
        
        int count = this.trangchu.paneCenter.getTabCount();
        for(int i=0;i<count;i++){
                this.trangchu.paneCenter.setTabComponentAt(i, new ButtonTabComponent(this.trangchu.paneCenter));
        }
    }
}

