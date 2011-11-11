package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.Timer;
import javax.swing.UIManager;

import module.MarqueeTyGia;

public class MainApp extends JFrame {
	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
//	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	public static ClosableTabbedPane paneCenter;
	//public JTabbedPane paneCenter;
	private JPanel panelMenu;
	private JPanel panel_Banner;
	private BufferedImage image;
	private JPanel panelImg;
	private JPanel panel_tyGia;
	private Box verticalBox;
	private JScrollPane scrollPane;
	private Timer timer;
	private MarqueeTyGia marqueeTyGia;
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


	public MainApp() throws Exception {
		VerticalMenuBar verticalMenuBar = new VerticalMenuBar();
		setIconImage(Toolkit.getDefaultToolkit().getImage("T:\\BT\\PJQLBH\\Source\\media\\images\\48px-Crystal_Clear_action_bookmark.png"));
		setTitle("Phần mềm quản lí bán hàng Hợp tác xã công nghiệp Nhật Quang");
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
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
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
		
		marqueeTyGia = new MarqueeTyGia();
		panel_tyGia.add(marqueeTyGia);
		timer = new Timer(400000, new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  marqueeTyGia = new MarqueeTyGia();
		    	  panel_tyGia.removeAll();
		    	  panel_tyGia.add(marqueeTyGia);
		        repaint();
		      }
		    });
		    timer.start();
		
		verticalBox.add(panel_tyGia);
		
		getContentPane().add(this.panelMenu,BorderLayout.WEST);
		//getContentPane().add(verticalMenuBar);
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
