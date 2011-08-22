package main;

import java.awt.BorderLayout;
import java.awt.Container;
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

import module.GetScreenSize;
import view.*;

import java.awt.Window.Type;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewMain extends JFrame {

	private JPanel contentPane;

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
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panHeader = new JPanel();
		contentPane.add(panHeader, BorderLayout.NORTH);
		
		JPanel panLeft = new JPanel();
		contentPane.add(panLeft, BorderLayout.WEST);
		
		JTree treMenu = new JTree();
		panLeft.add(treMenu);
		
		final JPanel panBody = new JPanel();
		contentPane.add(panBody, BorderLayout.CENTER);
		
		
		//Set full screen
		GetScreenSize srcSize = new GetScreenSize();
		setBounds(1, 1, srcSize.getWidth()-10, srcSize.getHeigth()-10);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNhapXuat = new JMenu("Nhập/Xuất hàng");
		menuBar.add(mnNhapXuat);
		JMenuItem mntnNhapHang = new JMenuItem("Nhập hàng");
		mnNhapXuat.add(mntnNhapHang);
		
		JMenuItem mntmXuatHang = new JMenuItem("Xuất hàng");
		mnNhapXuat.add(mntmXuatHang);
		mntnNhapHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				JOptionPane.showMessageDialog(null, "Gọi phân quyền!");
				FraPhanQuyen phanQuyen = new FraPhanQuyen();

		            setSize(300,300);
				phanQuyen.setVisible(true);
				panBody.add(phanQuyen);
				try 
				{
		            phanQuyen.setSelected(true);
		        }
				catch (java.beans.PropertyVetoException e) 
				{}
			}
		});
		
	}
}
