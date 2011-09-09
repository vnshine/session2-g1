package main;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;


public class Help extends JPanel implements ActionListener {
    private JToolBar tbr;
    private JButton btnHuongDan;
    private MainApp trangchu;
    public Help(MainApp trangchu){
    	this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.trangchu = trangchu;
        this.tbr = new JToolBar();
        this.add(tbr);
        tbr.setOrientation(JToolBar.HORIZONTAL);
        btnHuongDan = new JButton("Huong dan su dung",new ImageIcon("media/images/48px-Crystal_Clear_app_kthememgr.png"));
        btnHuongDan.setVerticalTextPosition(JButton.BOTTOM);
        btnHuongDan.setHorizontalTextPosition(JButton.CENTER);
        tbr.add(this.btnHuongDan);
        btnHuongDan.addActionListener(this);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	
        if(e.getSource()== this.btnHuongDan){
        	if(this.trangchu.paneCenter.positionTab("Mua Hàng") > -1){
        		return;
        		}else if(this.trangchu.paneCenter.positionTab("Mua Hàng") == -1){
        			this.trangchu.paneCenter.addTab(new JButton("jfbsgbksnkgs"), "Mua Hàng");
        			//this.trangchu.paneCenter.addTab(new MuaHang(trangchu), "Mua Hàng");
            		
        		this.trangchu.paneCenter.setSelectedIndex( this.trangchu.paneCenter.getTabCount()-1);
        		}
//                this.trangchu.paneCenter.add("Mua Hàng",new JButton("jfbsgbksnkgs"));		
//                this.trangchu.paneCenter.add("Mua Hàng",new MuaHang(trangchu));
        }
        
        int count = this.trangchu.paneCenter.getTabCount();
        for(int i=0;i<count;i++){
                this.trangchu.paneCenter.setTabComponentAt(i, new ButtonTabComponent(this.trangchu.paneCenter));

        }
    }
}

