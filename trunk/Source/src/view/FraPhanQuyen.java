package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class FraPhanQuyen extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FraPhanQuyen frame = new FraPhanQuyen();
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
	public FraPhanQuyen() 
	{
		super("Nhập hàng", 
                true, //resizable
                true, //closable
                true, //maximizable
                true);//iconifiable
//		setBounds(10, 10, 800, 600);
		setSize(800,600);
	}

}
