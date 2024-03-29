package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.Timer;
import javax.swing.UIManager;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;
import connect.ioconnection;

import module.MarqueeTyGia;
import view.QuanLiBaoCao;
import view.TrangChu;

public class Home extends JFrame implements ActionListener {
	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
//	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	ImageIcon icon;
	private JTabbedPane tabbedPane;
	public static ClosableTabbedPane paneCenter;
	//public JTabbedPane paneCenter;
	private JPanel panelMenu;
	private JPanel panel_Banner;
	private JPanel panelImg;
	private JScrollPane scrollPane;
	private Timer timer;
	private MarqueeTyGia marqueeTyGia;
	private JButton btnHThng;
	private JButton button_1;
	private JButton btnNhpxut;
	private JButton btnThuChi;
	private JButton btnCngN;
	private JButton btnHngHa;
	private JButton btniTc;
	private JButton btnNhnVin;
	private JButton btnBaoCao;
	private JButton btnQunL;
	private JButton btnTrGip;
	private JScrollPane spanelMenu;
	private HeThong HeThong;
	private NhapXuat NhapXuat;
	private ThuChi ThuChi;
	private CongNo CongNo;
	private HangHoa HangHoa;
	private DoiTac DoiTac;
	private NhanVien NhanVien;
	private BaoCao BaoCao;
	private QuanLi QuanLi;
	private TroGiup TroGiup;
	private JLabel label;
	private JButton label_1;
	private JLabel label_2;
	private JButton btnNewButton;
	private JButton button;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
//	private JStatusBar JStatusBar;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel lblDgdgdgd;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JPanel panel_TyGia;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		installLnF();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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


	public Home() throws Exception {
		final HeThong        HeThong      = new  HeThong    (this); 
		final NhapXuat       NhapXuat     = new  NhapXuat   (this); 
		final ThuChi		 ThuChi		  = new  ThuChi		(this); 
		final CongNo		 CongNo		  = new  CongNo		(this); 
		final HangHoa		 HangHoa	  = new  HangHoa	(this); 
		final DoiTac		 DoiTac		  = new  DoiTac		(this); 
		final NhanVien	    NhanVien	  = new  NhanVien	(this); 
		final BaoCao		 BaoCao		  = new  BaoCao		(this); 
		final QuanLi		 QuanLi		  = new  QuanLi		(this); 
		final TroGiup		 TroGiup	  = new  TroGiup	(this); 
//		JStatusBar = new JStatusBar();
		
		VerticalMenuBar verticalMenuBar = new VerticalMenuBar();
		setIconImage(Toolkit.getDefaultToolkit().getImage("media/images/48px-Crystal_Clear_action_bookmark.png"));
		setTitle("NHAT QUANG SALES MANAGERMENT");
		//this.setVisible(true);
		getContentPane().setLayout(new BorderLayout(0, 0));
	
		getContentPane().setLayout(new BorderLayout());
		panelMenu = new JPanel();
		//panelMenu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		//panelMenu.add(new HeThong(this));
		paneCenter = new ClosableTabbedPane();
		paneCenter.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		panel_Banner = new JPanel();
		panel_Banner.setBackground(Color.DARK_GRAY);
		getContentPane().add(panel_Banner, BorderLayout.NORTH);
		panel_Banner.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_Banner.add(panel_2, BorderLayout.NORTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		icon = new ImageIcon("media/images/NewBanner.png");
		panelImg = new JPanel(){
			public void paintComponent(Graphics g)	{	
				Dimension d = getSize();
				g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
				setOpaque( false );
				super.paintComponent(g);
			}
			};
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 7;
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		panel_2.add(panelImg, gbc_lblNewLabel);
		
		lblDgdgdgd = new JLabel(" ");
		GridBagConstraints gbc_lblDgdgdgd = new GridBagConstraints();
		gbc_lblDgdgdgd.insets = new Insets(0, 0, 5, 5);
		gbc_lblDgdgdgd.gridx = 0;
		gbc_lblDgdgdgd.gridy = 1;
		panel_2.add(lblDgdgdgd, gbc_lblDgdgdgd);
		
		lblNewLabel_1 = new JLabel(" ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 1;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		label_8 = new JLabel(" ");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 0;
		gbc_label_8.gridy = 2;
		panel_2.add(label_8, gbc_label_8);
		
		label_3 = new JLabel(" ");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 0);
		gbc_label_3.gridx = 2;
		gbc_label_3.gridy = 2;
		panel_2.add(label_3, gbc_label_3);
		
		label_9 = new JLabel(" ");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 0;
		gbc_label_9.gridy = 3;
		panel_2.add(label_9, gbc_label_9);
		
		label_4 = new JLabel(" ");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 0);
		gbc_label_4.gridx = 2;
		gbc_label_4.gridy = 3;
		panel_2.add(label_4, gbc_label_4);
		
		label_10 = new JLabel(" ");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_10.gridx = 0;
		gbc_label_10.gridy = 4;
		panel_2.add(label_10, gbc_label_10);
		
		label_5 = new JLabel(" ");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 0);
		gbc_label_5.gridx = 2;
		gbc_label_5.gridy = 4;
		panel_2.add(label_5, gbc_label_5);
		
		label_11 = new JLabel(" ");
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.insets = new Insets(0, 0, 5, 5);
		gbc_label_11.gridx = 0;
		gbc_label_11.gridy = 5;
		panel_2.add(label_11, gbc_label_11);
		
		label_6 = new JLabel(" ");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 0);
		gbc_label_6.gridx = 2;
		gbc_label_6.gridy = 5;
		panel_2.add(label_6, gbc_label_6);
		
		label_12 = new JLabel(" ");
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.insets = new Insets(0, 0, 5, 5);
		gbc_label_12.gridx = 0;
		gbc_label_12.gridy = 6;
		panel_2.add(label_12, gbc_label_12);
		
		label_7 = new JLabel(" ");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 0);
		gbc_label_7.gridx = 2;
		gbc_label_7.gridy = 6;
		panel_2.add(label_7, gbc_label_7);
		
		label_13 = new JLabel("");
		GridBagConstraints gbc_label_13 = new GridBagConstraints();
		gbc_label_13.insets = new Insets(0, 0, 0, 5);
		gbc_label_13.gridx = 1;
		gbc_label_13.gridy = 7;
		panel_2.add(label_13, gbc_label_13);
		
		panel_TyGia = new JPanel();
		panel_TyGia.setBackground(Color.DARK_GRAY);
		panel_Banner.add(panel_TyGia, BorderLayout.SOUTH);
		
		marqueeTyGia = new MarqueeTyGia();
		panel_TyGia.add(marqueeTyGia);
		marqueeTyGia.setBackground(Color.DARK_GRAY);
		timer = new Timer(400000, new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  marqueeTyGia = new MarqueeTyGia();
		    	  panel_TyGia.removeAll();
		    	  marqueeTyGia.setBackground(Color.DARK_GRAY);
		    	  panel_TyGia.add(marqueeTyGia);
		        repaint();
		      }
		    });
		    timer.start();
		
		
		GridBagLayout gbl_panelMenu = new GridBagLayout();
		gbl_panelMenu.columnWidths = new int[]{0, 0, 0};
		gbl_panelMenu.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelMenu.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panelMenu.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelMenu.setLayout(gbl_panelMenu);
		
		btnHThng = new JButton("Hệ thống");
		btnHThng.setIcon(new ImageIcon("media/images/Home.png"));
		btnHThng.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnHThng.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (HeThong.isVisible()) {HeThong.setVisible(false);}else
				HeThong.setVisible(true);
			}
		});
		
		label = new JLabel("                                                    ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panelMenu.add(label, gbc_label);
		
		label_2 = new JLabel("        ");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 0);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 0;
		panelMenu.add(label_2, gbc_label_2);
		GridBagConstraints gbc_btnHThng = new GridBagConstraints();
		gbc_btnHThng.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnHThng.insets = new Insets(0, 0, 5, 5);
		gbc_btnHThng.gridx = 0;
		gbc_btnHThng.gridy = 1;
		panelMenu.add(btnHThng, gbc_btnHThng);

		
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 0;
		gbc_button_1.gridy = 2;
		panelMenu.add(HeThong, gbc_button_1);
		
		btnNhpxut = new JButton("Nhập/Xuất");
		btnNhpxut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (NhapXuat.isVisible()) {
					NhapXuat.setVisible(false);}else
					NhapXuat.setVisible(true);
			}
		});
		btnNhpxut.setIcon(new ImageIcon("media/images/import_export-icon.png"));
		btnNhpxut.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnNhpxut = new GridBagConstraints();
		gbc_btnNhpxut.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNhpxut.insets = new Insets(0, 0, 5, 5);
		gbc_btnNhpxut.gridx = 0;
		gbc_btnNhpxut.gridy = 3;
		panelMenu.add(btnNhpxut, gbc_btnNhpxut);
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 4;
		panelMenu.add(NhapXuat, gbc_btnNewButton);
		
		btnThuChi = new JButton("Thu Chi");
		btnThuChi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ThuChi.isVisible()) {
					ThuChi.setVisible(false);}else
					ThuChi.setVisible(true);
			}
		});
		btnThuChi.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThuChi.setIcon(new ImageIcon("media/images/money-icon.png"));
		GridBagConstraints gbc_btnThuChi = new GridBagConstraints();
		gbc_btnThuChi.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnThuChi.insets = new Insets(0, 0, 5, 5);
		gbc_btnThuChi.gridx = 0;
		gbc_btnThuChi.gridy = 5;
		panelMenu.add(btnThuChi, gbc_btnThuChi);
		
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 6;
		panelMenu.add(ThuChi, gbc_button);
		
		btnCngN = new JButton("Công nợ");
		btnCngN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (CongNo.isVisible()) {
					CongNo.setVisible(false);}else
					CongNo.setVisible(true);
			}
		});
		btnCngN.setIcon(new ImageIcon("media/images/ConNO-icon.png"));
		btnCngN.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnCngN = new GridBagConstraints();
		gbc_btnCngN.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCngN.insets = new Insets(0, 0, 5, 5);
		gbc_btnCngN.gridx = 0;
		gbc_btnCngN.gridy = 7;
		panelMenu.add(btnCngN, gbc_btnCngN);
		
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 0;
		gbc_button_2.gridy = 8;
		panelMenu.add(CongNo, gbc_button_2);
		
		btnHngHa = new JButton("Hàng hóa");
		btnHngHa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (HangHoa.isVisible()) {
					HangHoa.setVisible(false);}else
					HangHoa.setVisible(true);
			}
		});
		btnHngHa.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnHngHa.setIcon(new ImageIcon("media/images/hanghoa-icon.png"));
		GridBagConstraints gbc_btnHngHa = new GridBagConstraints();
		gbc_btnHngHa.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnHngHa.insets = new Insets(0, 0, 5, 5);
		gbc_btnHngHa.gridx = 0;
		gbc_btnHngHa.gridy = 9;
		panelMenu.add(btnHngHa, gbc_btnHngHa);
		
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 0;
		gbc_button_3.gridy = 10;
		panelMenu.add(HangHoa, gbc_button_3);
		
		btniTc = new JButton("Đối tác");
		btniTc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (DoiTac.isVisible()) {
					DoiTac.setVisible(false);}else
					DoiTac.setVisible(true);
			}
		});
		btniTc.setIcon(new ImageIcon("media/images/icon-DoiTac.png"));
		btniTc.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btniTc = new GridBagConstraints();
		gbc_btniTc.fill = GridBagConstraints.HORIZONTAL;
		gbc_btniTc.insets = new Insets(0, 0, 5, 5);
		gbc_btniTc.gridx = 0;
		gbc_btniTc.gridy = 11;
		panelMenu.add(btniTc, gbc_btniTc);
		
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 0;
		gbc_button_4.gridy = 12;
		panelMenu.add(DoiTac, gbc_button_4);
		
		btnNhnVin = new JButton("Nhân viên");
		btnNhnVin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (NhanVien.isVisible()) {
					NhanVien.setVisible(false);}else
					NhanVien.setVisible(true);
			}
		});
		btnNhnVin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNhnVin.setIcon(new ImageIcon("media/images/icon-NhanVien.png"));
		GridBagConstraints gbc_btnNhnVin = new GridBagConstraints();
		gbc_btnNhnVin.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNhnVin.insets = new Insets(0, 0, 5, 5);
		gbc_btnNhnVin.gridx = 0;
		gbc_btnNhnVin.gridy = 13;
		panelMenu.add(btnNhnVin, gbc_btnNhnVin);
		
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.insets = new Insets(0, 0, 5, 5);
		gbc_button_5.gridx = 0;
		gbc_button_5.gridy = 14;
		panelMenu.add(NhanVien, gbc_button_5);
		
		BaoCao.setVisible(false);
		btnBaoCao = new JButton("Báo cáo");
		btnBaoCao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (BaoCao.isVisible()) {
					BaoCao.setVisible(false);}else
					BaoCao.setVisible(true);
			}
		});
		btnBaoCao.setIcon(new ImageIcon("media/images/ReportsIcon.png"));
		btnBaoCao.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnBaoCao = new GridBagConstraints();
		gbc_btnBaoCao.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBaoCao.insets = new Insets(0, 0, 5, 5);
		gbc_btnBaoCao.gridx = 0;
		gbc_btnBaoCao.gridy = 15;
		panelMenu.add(btnBaoCao, gbc_btnBaoCao);
		
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.insets = new Insets(0, 0, 5, 5);
		gbc_button_6.gridx = 0;
		gbc_button_6.gridy = 16;
		panelMenu.add(BaoCao, gbc_button_6);
		
		
		
		btnQunL = new JButton("Quản lý");
		btnQunL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (QuanLi.isVisible()) {
					QuanLi.setVisible(false);}else
					QuanLi.setVisible(true);
			}
		});
		btnQunL.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQunL.setIcon(new ImageIcon("media/images/Manager-Icon.png"));
		GridBagConstraints gbc_btnQunL = new GridBagConstraints();
		gbc_btnQunL.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQunL.insets = new Insets(0, 0, 5, 5);
		gbc_btnQunL.gridx = 0;
		gbc_btnQunL.gridy = 17;
		panelMenu.add(btnQunL, gbc_btnQunL);
		
		GridBagConstraints gbc_button_7 = new GridBagConstraints();
		gbc_button_5.insets = new Insets(0, 0, 5, 5);
		gbc_button_5.gridx = 0;
		gbc_button_5.gridy = 18;
		panelMenu.add(QuanLi, gbc_button_7);
		
		btnTrGip = new JButton("Trợ giúp");
		btnTrGip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (TroGiup.isVisible()) {
					TroGiup.setVisible(false);}else
					TroGiup.setVisible(true);
			}
		});
		btnTrGip.setIcon(new ImageIcon("media/images/help-icon.png"));
		btnTrGip.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnTrGip = new GridBagConstraints();
		gbc_btnTrGip.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnTrGip.insets = new Insets(0, 0, 5, 5);
		gbc_btnTrGip.gridx = 0;
		gbc_btnTrGip.gridy = 19;
		panelMenu.add(btnTrGip, gbc_btnTrGip);
		//getContentPane().add(verticalMenuBar);
		getContentPane().add(this.paneCenter,BorderLayout.CENTER);
		spanelMenu = new JScrollPane(panelMenu);
		
		GridBagConstraints gbc_button_8 = new GridBagConstraints();
		gbc_button_5.insets = new Insets(0, 0, 5, 5);
		gbc_button_5.gridx = 0;
		gbc_button_5.gridy = 20;
		panelMenu.add(TroGiup, gbc_button_8);
		
		label_1 = new JButton("");
		label_1.setIcon(new ImageIcon("media/images/banner_02.png"));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 21;
		panelMenu.add(label_1, gbc_label_1);
		getContentPane().add(spanelMenu,BorderLayout.WEST);
		
		HeThong.setVisible(false);
		NhapXuat.setVisible(false);
		ThuChi.setVisible(false);  
		CongNo.setVisible(false);  
		HangHoa.setVisible(false); 
		DoiTac.setVisible(false);  
		NhanVien.setVisible(false);
//		BaoCao.setVisible(false);  
		QuanLi.setVisible(false);  
		TroGiup.setVisible(false);
		paneCenter.addTab(new TrangChu(), "Trang chủ");
//		getContentPane().add(JStatusBar,BorderLayout.SOUTH);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== btnBaoCao){
        	if(paneCenter.positionTab("Báo cáo") > -1){
        		return;
        		}else if(paneCenter.positionTab("Báo cáo") == -1){
        			try {
        				Connection con = ioconnection.getConnection();
        				JasperPrint print = JasperFillManager.fillReport("report/rptDoanhThu.jasper", null, con);
        				
        				JRViewer viewer=new JRViewer(print);
						paneCenter.addTab(viewer, "Báo cáo doanh thu theo tháng");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        		paneCenter.setSelectedIndex(paneCenter.getTabCount()-1);
        		}
        }
        
        int count = paneCenter.getTabCount();
        for(int i=0;i<count;i++){
                paneCenter.setTabComponentAt(i, new ButtonTabComponent(paneCenter));
        }
	}

}
