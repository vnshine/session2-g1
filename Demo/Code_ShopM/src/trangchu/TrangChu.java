package trangchu;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceModerateLookAndFeel;



public class TrangChu extends JFrame {

	public JTabbedPane tbnPane,tbnPaneCenter;
	private JPanel topPanel;
	public TrangChu(){
		
	}
	public void initFrame(){
        this.setLayout(new BorderLayout());
        this.topPanel = new JPanel();
        this.topPanel.setLayout(new BorderLayout());
        this.tbnPane = new JTabbedPane();
        this.tbnPane.addTab("Hệ Thống", new HeThong());
        this.tbnPane.addTab("Danh Mục", new DanhMuc());
        this.tbnPane.addTab("Chức Năng", new ChucNang(this));
        //this.tbnPane.addTab("Trợ Giúp", new TroGiup());
        this.topPanel.add(this.tbnPane);

        this.tbnPaneCenter = new JTabbedPane();
        this.getContentPane().add(this.topPanel,BorderLayout.NORTH);
        this.getContentPane().add(this.tbnPaneCenter,BorderLayout.CENTER);
	}
	public void display(){
        this.setSize(1200,720);
        this.setTitle("Phần Mềm Quản Lý Bán Hàng");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
	}
	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame.setDefaultLookAndFeelDecorated(true);
                LookAndFeel laf = new SubstanceModerateLookAndFeel();
                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
                JFrame.setDefaultLookAndFeelDecorated(false);
                JDialog.setDefaultLookAndFeelDecorated(true);
                try {
                        UIManager.setLookAndFeel(laf);
                        TrangChu app = new TrangChu();
                        app.initFrame();
                        app.display();
                } catch (UnsupportedLookAndFeelException e) {
                        e.printStackTrace();
                }
            }
        });
		
	}

}
