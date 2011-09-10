package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

public class MainApp extends JFrame {

	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	public static ClosableTabbedPane paneCenter;
	//public JTabbedPane paneCenter;
	private JPanel panelMenu;
	private JPanel panel_Banner;
	private BufferedImage image;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		installLnF();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp frame = new MainApp();
					frame.setVisible(true);
					frame.pack();
					//frame.getContentPane().add(frame);

					
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
					frame.setExtendedState(Frame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */


	public MainApp() throws IOException {
		//this.setVisible(true);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("New label");


		getContentPane().setLayout(new BorderLayout());
		panelMenu = new JPanel();
		//panelMenu.set
		panelMenu.setLayout(new BorderLayout());
		tabbedPane = new JTabbedPane();
		tabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		//tabbedPane.add("dsgds", "media/images/48px-Crystal_Clear_action_bookmark.png",  new JButton());
		tabbedPane.addTab("Chức năng vớ vẩn", new ChucNang(this));
		tabbedPane.addTab("Trợ giúp", new Help(this));

		panelMenu.add(tabbedPane);
		paneCenter = new ClosableTabbedPane();
		paneCenter.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		panel_Banner = new JPanel();
		image = ImageIO.read(new File("media/images/NhatQuangBanner.png")); 
		BufferedImage myPicture = image; 
		JLabel picLabel = new JLabel(new ImageIcon( myPicture )) ;
		panel_Banner.add(picLabel);

		getContentPane().add(panel_Banner, BorderLayout.NORTH);
		getContentPane().add(this.panelMenu,BorderLayout.WEST);
		getContentPane().add(this.paneCenter,BorderLayout.CENTER);
		
	}

	private static void installLnF() {
		try {
			String lnfClassname = PREFERRED_LOOK_AND_FEEL;
			if (lnfClassname == null)
				lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(lnfClassname);
		} catch (Exception e) {
			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL
					+ " on this platform:" + e.getMessage());
		}
	}

}
