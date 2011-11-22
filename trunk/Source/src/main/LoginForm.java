package main;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.Color;

import javax.swing.AbstractButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.UIManager;

import module.SetCenter;
import module.MD5;

import process.LoginProcess;
import sun.font.FontManager.FamilyDescription;
//import view.LostPassword;
import view.ThongTinCongTyView;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JToggleButton;

public class LoginForm extends JFrame {

	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private LoginProcess pro;
	private String name, pass;
	private JCheckBox chckbxRememberPassword;
	private JLabel lblName, lblLostPassword, label, lblPassword, lblCsdl,lblMaCsdl,lblEnter;
	public static String userName;
	private JTextField txtThaotvsqlexpress;
	JToggleButton tglbtnTingVit;
	private JButton btnOk, btnCancel;
//	private static Thread th1;
//	private static Thread th2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String lnfClassname = PREFERRED_LOOK_AND_FEEL;
					if (lnfClassname == null){
						lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
					}
					UIManager.setLookAndFeel(lnfClassname);
					LoginForm frame1 = new LoginForm();
					frame1.setVisible(true);
					SetCenter setCenter = new SetCenter(frame1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//	public static void Login(){
//		
//		
//	}
//	
//	public static void App(){
//		
//		
//	}

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		pro = new LoginProcess();
		String[] value = pro.Load();
		
		setTitle("Login");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setPreferredSize(new Dimension(50,50));
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		lblEnter = new JLabel("Nhập tài khoản và mật khẩu");
		lblEnter.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnter.setBounds(23, 11, 251, 14);
		panel_1.add(lblEnter);
		
		lblName = new JLabel("Server Name :");
		lblName.setBounds(33, 36, 69, 14);
		panel_1.add(lblName);
		
		passwordField = new JPasswordField(value[1]);
		passwordField.setBounds(105, 86, 315, 20);
		panel_1.add(passwordField);
		
		textField = new JTextField(value[0]);
		textField.setBounds(105, 58, 315, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		chckbxRememberPassword = new JCheckBox("Ghi nhớ");
		chckbxRememberPassword.setBounds(59, 113, 82, 23);
		panel_1.add(chckbxRememberPassword);
		chckbxRememberPassword.setSelected(true);
		
		btnOk = new JButton("Đăng nhập");
		btnOk.setBounds(128, 149, 89, 23);
		panel_1.add(btnOk);
		
		btnCancel = new JButton("Thoát");
		btnCancel.setBounds(230, 149, 89, 23);
		panel_1.add(btnCancel);
		
		label = new JLabel("");
		label.setBounds(128, 183, 258, 14);
		label.setForeground(Color.RED);
//		label.setVerticalTextPosition(JLabel.BOTTOM);
//		label.setHorizontalTextPosition(JLabel.CENTER);
		panel_1.add(label);
		
		lblLostPassword = new JLabel("Quên mật khẩu?");
		lblLostPassword.setForeground(Color.BLUE);
		lblLostPassword.setCursor(new Cursor(HAND_CURSOR));
		lblLostPassword.setBounds(338, 117, 82, 14);
		panel_1.add(lblLostPassword);
		
		lblCsdl = new JLabel("Tài Khoản :");
		lblCsdl.setBounds(33, 61, 69, 14);
		panel_1.add(lblCsdl);
		
		txtThaotvsqlexpress = new JTextField("THAOTV\\SQLEXPRESS");
		txtThaotvsqlexpress.setBounds(105, 33, 315, 20);
		panel_1.add(txtThaotvsqlexpress);
		txtThaotvsqlexpress.setColumns(10);
		
		lblMaCsdl = new JLabel("Mật Khẩu :");
		lblMaCsdl.setBounds(33, 89, 62, 14);
		panel_1.add(lblMaCsdl);
		
		tglbtnTingVit = new JToggleButton("English");
		tglbtnTingVit.setBounds(166, 113, 121, 23);
		panel_1.add(tglbtnTingVit);
		
		ActionListener actionListener = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
		        boolean selected = abstractButton.getModel().isSelected();
		        if (selected) {
		        	tglbtnTingVit.setText("Tiếng Việt");
		        	lblCsdl.setText("Username :");
		        	lblMaCsdl.setText("Password :");
		        	lblLostPassword.setText("Lost Password?");
		        	chckbxRememberPassword.setText("Remember");
		        	btnOk.setText("Login");
		        	btnCancel.setText("Cancel"); 
		        	lblEnter.setText("Enter the account and password");
				}else {
					tglbtnTingVit.setText("English");
		        	lblCsdl.setText("Tài Khoản :");
		        	lblMaCsdl.setText("Mật Khẩu :");
		        	lblLostPassword.setText("Quên mật khẩu?");
		        	chckbxRememberPassword.setText("Ghi nhớ");
		        	btnOk.setText("Đăng Nhập");
		        	btnCancel.setText("Thoát"); 
		        	lblEnter.setText("Nhập tài khoản và mật khẩu");
				}
		        
		        
		      }
		    };
		    // Attach Listeners
		    tglbtnTingVit.addActionListener(actionListener);
		
		btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
		});
		
		btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
		});
		
//		lblLostPassword.addMouseListener(new java.awt.event.MouseAdapter() {
//            @Override
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//            	lblLostPasswordMouseClicked(evt);
//            }
//        });
		
	}
	
	private Boolean valid(String name, String pass){
		Boolean result = true;
		if(name.equals("")){
			lblName.setForeground(Color.red);
			label.setText("Tên đăng nhập không được để trống");
			return false;
		}
		if(pass.equals("")){
			lblPassword.setForeground(Color.red);
			label.setText("Mã đăng nhập không được để trống");
			return false;
		}
		return result;
	}
	
//	private void actionPerformed(java.awt.event.ActionEvent evt){
//		tglbtnTingVit.setText("Tiếng Anh");
//		lblName.setText("Login");
//	}
	
	private void btnOkActionPerformed(java.awt.event.ActionEvent evt){
		name = textField.getText();
		pass = passwordField.getText();
		
		if (chckbxRememberPassword.isSelected() == true) {
			pro.Ghi(name, pass);
		} else {
			pro.Del();
		}
		
		name = name.replace(" ", "").toUpperCase();
		pass = pass.replace(" ", "").toUpperCase();
		//str = MD5.MD5Password(pass);
		//System.out.println(str);
		
		if (valid(name, pass) == false) {
			return;
		}
		
		if (pro.Login(name, pass)) {
			this.setVisible(false);
			Home frame;
			try{
				userName = name;
				frame = new Home();
				frame.setVisible(true);
				frame.pack();
				frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				frame.setExtendedState(Frame.MAXIMIZED_BOTH);
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}else {
			label.setText("Sai mã đăng nhập hoặc mật khẩu");
		}
		
	}

	private void btnCancelActionPerformed(java.awt.event.ActionEvent evt){
		System.exit(0);		
	}
}
