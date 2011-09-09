package main;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.*;


public class ClosableTabbedPane extends JTabbedPane{
	
	public void paint(Graphics g){
		super.paint(g);
	}
	
	public void addTab(Component component, String title, int index) {
		super.add(component, title+"  ", index);
	}
	public void addTab(Component component, String title) {
		super.add(title +"  ", component);
	}
	
	public String getTabTitleAt(int index) {
		return super.getTitleAt(index).trim();
	}
	
	public int positionTab(String title){
		int index = -1;
		for(int i=0; i<this.getTabCount(); i++){
			if(this.getTabTitleAt(i).equals(title)){
				index = i;
				break;
			}
		}
		return index;
	}
	
	public boolean tabAboutToClose(int tabIndex) {
		return true;
	}

	
}

