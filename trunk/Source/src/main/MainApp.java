package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
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
import javax.swing.Box;

import module.MarqueeTyGia;

public class MainApp extends JFrame {
	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	public static ClosableTabbedPane paneCenter;
	//public JTabbedPane paneCenter;
	private JPanel panelMenu;
	private JPanel panel_Banner;
	private BufferedImage image;
	private JPanel panelImg;
	private JPanel panel_tyGia;
	private Box verticalBox;
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
	


		getContentPane().setLayout(new BorderLayout());
		panelMenu = new JPanel();
		//panelMenu.set
		panelMenu.setLayout(new BorderLayout());
		tabbedPane = new JTabbedPane();
		tabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		//JPanel  pnlProducts = new JPanel();
		tabbedPane.add(null, new javax.swing.ImageIcon("media/images/Windows.png"));
		tabbedPane.addTab("Hệ Thống", new javax.swing.ImageIcon("media/images/Home.png"), new HeThong(this)); // NOI18N

//        javax.swing.GroupLayout pnlProductsLayout = new javax.swing.GroupLayout(pnlProducts);
//        pnlProducts.setLayout(pnlProductsLayout);
//        pnlProductsLayout.setHorizontalGroup(
//            pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 630, Short.MAX_VALUE)
//        );
//        pnlProductsLayout.setVerticalGroup(
//            pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 418, Short.MAX_VALUE)
//        );
		tabbedPane.addTab("Nhập/Xuất", 
				new javax.swing.ImageIcon("media/images/import_export-icon.png"), 
				new NhapXuat(this));
		tabbedPane.addTab("Thu/Chi"  , 
				new javax.swing.ImageIcon("media/images/money-icon.png"),         
				new ThuChi(this));
		tabbedPane.addTab("Công nợ"  , 
				new javax.swing.ImageIcon("media/images/ConNO-icon.png"),         
				new CongNo(this));
		tabbedPane.addTab("Hàng hóa" , 
				new javax.swing.ImageIcon("media/images/hanghoa-icon.png"),       
				new HangHoa(this));
		tabbedPane.addTab("Đối tác"  , 
				new javax.swing.ImageIcon("media/images/icon-DoiTac.png"),        
				new DoiTac(this));
		tabbedPane.addTab("Nhân viên", 
				new javax.swing.ImageIcon("media/images/icon-NhanVien.png"),      
				new NhanVien(this));
		tabbedPane.addTab("Báo cáo"  , 
				new javax.swing.ImageIcon("media/images/ReportsIcon.png"),        
				new BaoCao(this));
		tabbedPane.addTab("Quản lí"  , 
				new javax.swing.ImageIcon("media/images/Manager-Icon.png"),       
				new QuanLi(this));
		tabbedPane.addTab("Trợ giúp" , 
				new javax.swing.ImageIcon("media/images/help-icon.png"),          
				new TroGiup(this));
		

		panelMenu.add(tabbedPane);
		paneCenter = new ClosableTabbedPane();
		paneCenter.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		panel_Banner = new JPanel();
		image = ImageIO.read(new File("media/images/NhatQuangBanner.png")); 
		BufferedImage myPicture = image; 

		getContentPane().add(panel_Banner, BorderLayout.NORTH);
		panel_Banner.setLayout(new BorderLayout(0, 0));
		
		verticalBox = Box.createVerticalBox();
		panel_Banner.add(verticalBox, BorderLayout.SOUTH);
		
		panelImg = new JPanel();
		verticalBox.add(panelImg);
		panelImg.setLayout(new BorderLayout(0, 0));
		JLabel picLabel = new JLabel(new ImageIcon( myPicture )) ;
		panelImg.add(picLabel);
		
		panel_tyGia = new JPanel();
		MarqueeTyGia marqueeTyGia = new MarqueeTyGia();
		panel_tyGia.add(marqueeTyGia);
		verticalBox.add(panel_tyGia);
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
