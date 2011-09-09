package main;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;


public class ChucNang extends JPanel implements ActionListener {
    private JToolBar tbr;
    private JButton btnmuahang;
    private MainApp trangchu;
    public ChucNang(MainApp trangchu){
    	this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.trangchu = trangchu;
        this.tbr = new JToolBar();
        this.add(tbr);
        tbr.setOrientation(JToolBar.HORIZONTAL);
        btnmuahang = new JButton("Mua Hàng",new ImageIcon("media/images/icon-DoiTac.png"));
        btnmuahang.setVerticalTextPosition(JButton.BOTTOM);
        btnmuahang.setHorizontalTextPosition(JButton.CENTER);
        tbr.add(this.btnmuahang);
        btnmuahang.addActionListener(this);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	
        if(e.getSource()== this.btnmuahang){
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

