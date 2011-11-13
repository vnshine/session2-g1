package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class TrangChu extends JInternalFrame{

	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	private static final long serialVersionUID = 1L;
	ImageIcon icon;
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
	public static void main(String[] args) {
		installLnF();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChu frame = new TrangChu();
					frame.setVisible(true);
					frame.pack();
					JFrame mainf = new JFrame();
					mainf.getContentPane().add(frame);
					mainf.setVisible(true);
					mainf.pack();
					mainf.setDefaultCloseOperation(EXIT_ON_CLOSE);
					mainf.setExtendedState(Frame.MAXIMIZED_BOTH);  // full screen
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public TrangChu() throws Exception {
		icon = new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\TrangChu.png");
		JPanel panel = new JPanel(){
		public void paintComponent(Graphics g)	{	
			Dimension d = getSize();
			g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
			setOpaque( false );
			super.paintComponent(g);
		}
		};
		//scrollPane = new JScrollPane( panel );	
		setContentPane( panel );
	}

}
