package trangchu;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import chucnang.BanHang;
import chucnang.ButtonTabComponent;
import chucnang.LuanChuyen;
import chucnang.MuaHang;

public class ChucNang extends JPanel implements ActionListener {
    private JToolBar tbr;
    private JButton btnmuahang,btnbanhang,btnluanchuyen,btntonkho,btnthutien,
    btntratien,btnchungtu,btntonghop,btndoanhthu;
    private TrangChu trangchu;
    public ChucNang(TrangChu trangchu){
    	this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.trangchu = trangchu;
        this.tbr = new JToolBar();
        this.add(this.tbr);
        this.tbr.setOrientation(JToolBar.HORIZONTAL);
        this.btnmuahang = new JButton("Mua Hàng",new ImageIcon("images/muahang.gif"));
        this.btnmuahang.setVerticalTextPosition(JButton.BOTTOM);
        this.btnmuahang.setHorizontalTextPosition(JButton.CENTER);

        this.tbr.add(this.btnmuahang);
        this.tbr.setOrientation(JToolBar.HORIZONTAL);
        this.btnbanhang = new JButton("Bán Hàng",new ImageIcon("images/banhang.gif"));
        this.btnbanhang.setVerticalTextPosition(JButton.BOTTOM);
        this.btnbanhang.setHorizontalTextPosition(JButton.CENTER);
        this.tbr.add(this.btnbanhang);
        this.tbr.setOrientation(JToolBar.HORIZONTAL);
        this.btnluanchuyen = new JButton("Luân Chuyển",new ImageIcon("images/luanchuyen.gif"));
        this.btnluanchuyen.setVerticalTextPosition(JButton.BOTTOM);
        this.btnluanchuyen.setHorizontalTextPosition(JButton.CENTER);
        this.tbr.add(this.btnluanchuyen);
        this.tbr.setOrientation(JToolBar.HORIZONTAL);
        this.btntonkho = new JButton("Tồn Kho",new ImageIcon("T:images/tonkho.gif"));
        this.btntonkho.setVerticalTextPosition(JButton.BOTTOM);
        this.btntonkho.setHorizontalTextPosition(JButton.CENTER);
        this.tbr.add(this.btntonkho);
        this.tbr.setOrientation(JToolBar.HORIZONTAL);
        this.btnthutien = new JButton("Thu Tiền",new ImageIcon("images/thutien.gif"));
        this.btnthutien.setVerticalTextPosition(JButton.BOTTOM);
        this.btnthutien.setHorizontalTextPosition(JButton.CENTER);
        this.tbr.add(this.btnthutien);
        this.tbr.setOrientation(JToolBar.HORIZONTAL);
        this.btntratien = new JButton("Trả Tiền",new ImageIcon("images/tratien.gif"));
        this.btntratien.setVerticalTextPosition(JButton.BOTTOM);
        this.btntratien.setHorizontalTextPosition(JButton.CENTER);
        this.tbr.add(this.btntratien);
        this.tbr.setOrientation(JToolBar.HORIZONTAL);
        this.btnchungtu = new JButton("Chứng Từ",new ImageIcon("images/chungtu.gif"));
        this.btnchungtu.setVerticalTextPosition(JButton.BOTTOM);
        this.btnchungtu.setHorizontalTextPosition(JButton.CENTER);
        this.tbr.add(this.btnchungtu);
        this.tbr.setOrientation(JToolBar.HORIZONTAL);
        this.btndoanhthu = new JButton("Doanh Thu",new ImageIcon("images/doanhthu.gif"));
        this.btndoanhthu.setVerticalTextPosition(JButton.BOTTOM);
        this.btndoanhthu.setHorizontalTextPosition(JButton.CENTER);
        this.tbr.add(this.btndoanhthu);

        // su kien
        this.btnmuahang.addActionListener(this);
        this.btnbanhang.addActionListener(this);
        this.btnluanchuyen.addActionListener(this);
        this.btntonkho.addActionListener(this);
        this.btnthutien.addActionListener(this);
        this.btntratien.addActionListener(this);
        this.btnchungtu.addActionListener(this);
        this.btndoanhthu.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	
        if(e.getSource()== this.btnmuahang){
                this.trangchu.tbnPaneCenter.add("Mua Hàng",new MuaHang(trangchu));			
        }
        if(e.getSource()== this.btnbanhang){
                this.trangchu.tbnPaneCenter.add("Bán Hàng",new BanHang(trangchu));
        }
        if(e.getSource()== this.btnluanchuyen){
                this.trangchu.tbnPaneCenter.add("Luân Chuyển",new LuanChuyen(trangchu));
        }
        if(e.getSource()== this.btntonkho){
                this.trangchu.tbnPaneCenter.add("Tồn Kho",new MuaHang(trangchu));
        }
        if(e.getSource()== this.btnthutien){
                this.trangchu.tbnPaneCenter.add("Thu Tiền",new MuaHang(trangchu));
        }
        if(e.getSource()== this.btntratien){
                this.trangchu.tbnPaneCenter.add("Trả Tiền",new MuaHang(trangchu));
        }
        if(e.getSource()== this.btnchungtu){
                this.trangchu.tbnPaneCenter.add("Chứng Từ",new MuaHang(trangchu));
        }
        if(e.getSource()== this.btndoanhthu){
                this.trangchu.tbnPaneCenter.add("Doanh Thu",new MuaHang(trangchu));
        }
        int count = this.trangchu.tbnPaneCenter.getTabCount();
        for(int i=0;i<count;i++){
                this.trangchu.tbnPaneCenter.setTabComponentAt(i, new ButtonTabComponent(this.trangchu.tbnPaneCenter));

        }
    }
}

