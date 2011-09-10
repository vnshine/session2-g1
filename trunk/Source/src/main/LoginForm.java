package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.Font;

public class LoginForm extends JFrame {

	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String lnfClassname = PREFERRED_LOOK_AND_FEEL;
					if (lnfClassname == null)
						lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
					UIManager.setLookAndFeel(lnfClassname);
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 249);
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
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(49, 36, 46, 14);
		panel_1.add(lblName);
		
		JLabel lblPassword = new JLabel("Password");
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
	}
}
