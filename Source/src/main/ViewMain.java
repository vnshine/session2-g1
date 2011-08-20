package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTree;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import java.awt.Window.Type;

public class ViewMain extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					ViewMain frame = new ViewMain();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("HỢP TÁC XÃ CÔNG NGHIỆP NHẬT QUANG - PHẦN MỀM QUẢN LÝ BÁN HÀNG");
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 784, 100);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 99, 150, 463);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTree tree = new JTree();
		tree.setBounds(0, 0, 150, 463);
		panel_1.add(tree);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(150, 99, 634, 463);
		contentPane.add(panel_2);
	}
}
