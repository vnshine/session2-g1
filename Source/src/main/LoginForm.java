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
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.UIManager;

import module.SetCenter;

import process.LoginProcess;
import sun.font.FontManager.FamilyDescription;
import view.LostPassword;
import view.ThongTinCongTyView;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class LoginForm extends JFrame {

	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private LoginProcess pro;
	private String name, pass;
	private JLabel lblName, lblPassword, lblLostPassword, label;
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

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		setTitle("Login");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 270);
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
		
		JLabel lblEnter = new JLabel("Enter your usermane and password");
		lblEnter.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnter.setBounds(23, 11, 251, 14);
		panel_1.add(lblEnter);
		
		lblName = new JLabel("Name");
		lblName.setBounds(49, 36, 46, 14);
		panel_1.add(lblName);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(49, 61, 46, 14);
		panel_1.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(105, 58, 315, 20);
		panel_1.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(105, 33, 315, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JCheckBox chckbxRememberPassword = new JCheckBox("Remember Password");
		chckbxRememberPassword.setBounds(49, 85, 182, 23);
		panel_1.add(chckbxRememberPassword);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(131, 115, 89, 23);
		panel_1.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(230, 115, 89, 23);
		panel_1.add(btnCancel);
		
		label = new JLabel("");
		label.setBounds(117, 155, 303, 14);
		label.setForeground(Color.RED);
//		label.setVerticalTextPosition(JLabel.BOTTOM);
//		label.setHorizontalTextPosition(JLabel.CENTER);
		panel_1.add(label);
		
		lblLostPassword = new JLabel("Lost password?");
		lblLostPassword.setForeground(Color.BLUE);
		lblLostPassword.setCursor(new Cursor(HAND_CURSOR));
		lblLostPassword.setBounds(338, 89, 82, 14);
		panel_1.add(lblLostPassword);
		
		pro = new LoginProcess();
		
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
		
		lblLostPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	lblLostPasswordMouseClicked(evt);
            }
        });
		
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
	
	private void btnOkActionPerformed(java.awt.event.ActionEvent evt){
		name = textField.getText();
		pass = passwordField.getText();
		name = name.replace(" ", "").toUpperCase();
		pass = pass.replace(" ", "").toUpperCase();
		
		if (valid(name, pass) == false) {
			return;
		}
		if (pro.Login(name, pass)) {
			this.setVisible(false);
			ThongTinCongTyView frame = new ThongTinCongTyView();
			frame.setVisible(true);
			frame.pack();
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		}else {
			label.setText("Sai mã đăng nhập hoặc mật khẩu");
		}
		
	}

	private void btnCancelActionPerformed(java.awt.event.ActionEvent evt){
		System.exit(0);		
	}
	
	private void lblLostPasswordMouseClicked(MouseEvent evt){
		this.setVisible(false);
		LostPassword frame = new LostPassword();
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		SetCenter setCenter = new SetCenter(frame);
	}
}
