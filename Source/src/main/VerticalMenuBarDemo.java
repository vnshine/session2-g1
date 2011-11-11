package main;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.JMenuItem;

class VerticalMenuBar extends JMenuBar {
  private static final LayoutManager grid = new GridLayout(0,1);
  public VerticalMenuBar() {
    setLayout(grid);
  }
}


public class VerticalMenuBarDemo {

  public static void main(final String args[]) {
    JFrame frame = new JFrame("MenuSample Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(350, 250);
    frame.getContentPane().setLayout(new BorderLayout(0, 0));
    
    VerticalMenuBar verticalMenuBar = new VerticalMenuBar();
    frame.getContentPane().add(verticalMenuBar, BorderLayout.WEST);
    
    JMenu mnNewMenu = new JMenu("New menu");
    verticalMenuBar.add(mnNewMenu);
    
    JMenuItem mntmGhdfjdf = new JMenuItem("ghdfjdf");
    mnNewMenu.add(mntmGhdfjdf);
    
    JMenu mnNewMenu_2 = new JMenu("New menu");
    verticalMenuBar.add(mnNewMenu_2);
    
    JMenu mnNewMenu_1 = new JMenu("New menu");
    verticalMenuBar.add(mnNewMenu_1);
    frame.setVisible(true);
  }
}