package main;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceAutumnLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceBusinessBlackSteelLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceBusinessBlueSteelLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceBusinessLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceChallengerDeepLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceCremeCoffeeLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceCremeLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceDustCoffeeLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceDustLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceEmeraldDuskLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGeminiLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteAquaLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteGlassLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceMagellanLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceMistAquaLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceMistSilverLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceModerateLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceNebulaBrickWallLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceNebulaLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceOfficeBlue2007LookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceOfficeSilver2007LookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceRavenLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceSaharaLookAndFeel;
import java.awt.Dimension;


public class DoiGiaoDien extends JPanel implements ItemListener {
	private JComboBox combox;
	public DoiGiaoDien(MainApp trangchu) {
		String course[] = {"Chọn","Windows","Moderate","Autumn","BusinessBlackSteel","BusinessBlueSteel","Business","ChallengerDeep","CremeCoffee","Creme",
				"DustCoffee","Dust","Gemini","EmeraldDusk","Magellan","MistAqua","GraphiteAqua","MistSilver","GraphiteGlass","Moderate",
				"NebulaBrickWall","Graphite","Nebula","OfficeBlue2007","OfficeSilver2007","Raven","Sahara"};
		combox = new JComboBox(course);
		combox.setPreferredSize(new Dimension(80, 20));
		combox.setMaximumRowCount(12);
		combox.addItemListener(this);
		this.add(combox);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == this.combox){
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "Windows"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		               
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);

		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		               
		                	try {
								UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (InstantiationException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (UnsupportedLookAndFeelException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		                
		            }
		        });
			}
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "Moderate"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		                LookAndFeel laf = new SubstanceModerateLookAndFeel();
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
		                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		                try {
		                        UIManager.setLookAndFeel(laf);
		                } catch (UnsupportedLookAndFeelException e) {
		                        e.printStackTrace();
		                }
		            }
		        });
			}
			
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "Autumn"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		                LookAndFeel laf = new SubstanceAutumnLookAndFeel();
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
		                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		                try {
		                        UIManager.setLookAndFeel(laf);
		                } catch (UnsupportedLookAndFeelException e) {
		                        e.printStackTrace();
		                }
		            }
		        });
			}
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "BusinessBlackSteel"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		                LookAndFeel laf = new SubstanceBusinessBlackSteelLookAndFeel();
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
		                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		                try {
		                        UIManager.setLookAndFeel(laf);
		                } catch (UnsupportedLookAndFeelException e) {
		                        e.printStackTrace();
		                }
		            }
		        });
			}
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "BusinessBlueSteel"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		                LookAndFeel laf = new SubstanceBusinessBlueSteelLookAndFeel();
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
		                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		                try {
		                        UIManager.setLookAndFeel(laf);
		                } catch (UnsupportedLookAndFeelException e) {
		                        e.printStackTrace();
		                }
		            }
		        });				
			}
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "Business"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		                LookAndFeel laf = new SubstanceBusinessLookAndFeel();
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
		                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		                try {
		                        UIManager.setLookAndFeel(laf);
		                } catch (UnsupportedLookAndFeelException e) {
		                        e.printStackTrace();
		                }
		            }
		        });				
			}
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "ChallengerDeep"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		                LookAndFeel laf = new SubstanceChallengerDeepLookAndFeel();
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
		                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		                try {
		                        UIManager.setLookAndFeel(laf);
		                } catch (UnsupportedLookAndFeelException e) {
		                        e.printStackTrace();
		                }
		            }
		        });				
			}
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "CremeCoffee"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		                LookAndFeel laf = new SubstanceCremeCoffeeLookAndFeel();
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
		                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		                try {
		                        UIManager.setLookAndFeel(laf);
		                } catch (UnsupportedLookAndFeelException e) {
		                        e.printStackTrace();
		                }
		            }
		        });				
			}
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "Creme"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		                LookAndFeel laf = new SubstanceCremeLookAndFeel();
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
		                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		                try {
		                        UIManager.setLookAndFeel(laf);
		                } catch (UnsupportedLookAndFeelException e) {
		                        e.printStackTrace();
		                }
		            }
		        });				
			}
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "DustCoffee"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		                LookAndFeel laf = new SubstanceDustCoffeeLookAndFeel();
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
		                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		                try {
		                        UIManager.setLookAndFeel(laf);
		                } catch (UnsupportedLookAndFeelException e) {
		                        e.printStackTrace();
		                }
		            }
		        });				
			}
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "Dust"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		                LookAndFeel laf = new SubstanceDustLookAndFeel();
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
		                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		                try {
		                        UIManager.setLookAndFeel(laf);
		                } catch (UnsupportedLookAndFeelException e) {
		                        e.printStackTrace();
		                }
		            }
		        });				
			}
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "Gemini"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		                LookAndFeel laf = new SubstanceGeminiLookAndFeel();
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
		                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		                try {
		                        UIManager.setLookAndFeel(laf);
		                } catch (UnsupportedLookAndFeelException e) {
		                        e.printStackTrace();
		                }
		            }
		        });				
			}
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "EmeraldDusk"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		                LookAndFeel laf = new SubstanceEmeraldDuskLookAndFeel();
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
		                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		                try {
		                        UIManager.setLookAndFeel(laf);
		                } catch (UnsupportedLookAndFeelException e) {
		                        e.printStackTrace();
		                }
		            }
		        });				
			}
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "Magellan"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		                LookAndFeel laf = new SubstanceMagellanLookAndFeel();
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
		                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		                try {
		                        UIManager.setLookAndFeel(laf);
		                } catch (UnsupportedLookAndFeelException e) {
		                        e.printStackTrace();
		                }
		            }
		        });				
			}
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "MistAqua"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		                LookAndFeel laf = new SubstanceMistAquaLookAndFeel();
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
		                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		                try {
		                        UIManager.setLookAndFeel(laf);
		                } catch (UnsupportedLookAndFeelException e) {
		                        e.printStackTrace();
		                }
		            }
		        });				
			}
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "GraphiteAqua"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		                LookAndFeel laf = new SubstanceGraphiteAquaLookAndFeel();
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
		                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		                try {
		                        UIManager.setLookAndFeel(laf);
		                } catch (UnsupportedLookAndFeelException e) {
		                        e.printStackTrace();
		                }
		            }
		        });				
			}
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "MistSilver"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		                LookAndFeel laf = new SubstanceMistSilverLookAndFeel();
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
		                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		                try {
		                        UIManager.setLookAndFeel(laf);
		                } catch (UnsupportedLookAndFeelException e) {
		                        e.printStackTrace();
		                }
		            }
		        });				
			}
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "GraphiteGlass"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		                LookAndFeel laf = new SubstanceGraphiteGlassLookAndFeel();
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
		                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		                try {
		                        UIManager.setLookAndFeel(laf);
		                } catch (UnsupportedLookAndFeelException e) {
		                        e.printStackTrace();
		                }
		            }
		        });				
			}
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "Moderate"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		                LookAndFeel laf = new SubstanceModerateLookAndFeel();
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
		                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		                try {
		                        UIManager.setLookAndFeel(laf);
		                } catch (UnsupportedLookAndFeelException e) {
		                        e.printStackTrace();
		                }
		            }
		        });				
			}
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "NebulaBrickWall"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		                LookAndFeel laf = new SubstanceNebulaBrickWallLookAndFeel();
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
		                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		                try {
		                        UIManager.setLookAndFeel(laf);
		                } catch (UnsupportedLookAndFeelException e) {
		                        e.printStackTrace();
		                }
		            }
		        });				
			}
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "Graphite"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		                LookAndFeel laf = new SubstanceGraphiteLookAndFeel();
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
		                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		                try {
		                        UIManager.setLookAndFeel(laf);
		                } catch (UnsupportedLookAndFeelException e) {
		                        e.printStackTrace();
		                }
		            }
		        });				
			}
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "Nebula"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		                LookAndFeel laf = new SubstanceNebulaLookAndFeel();
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
		                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		                try {
		                        UIManager.setLookAndFeel(laf);
		                } catch (UnsupportedLookAndFeelException e) {
		                        e.printStackTrace();
		                }
		            }
		        });				
			}
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "OfficeBlue2007"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		                LookAndFeel laf = new SubstanceOfficeBlue2007LookAndFeel();
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
		                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		                try {
		                        UIManager.setLookAndFeel(laf);
		                } catch (UnsupportedLookAndFeelException e) {
		                        e.printStackTrace();
		                }
		            }
		        });				
			}
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "OfficeSilver2007"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		                LookAndFeel laf = new SubstanceOfficeSilver2007LookAndFeel();
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
		                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		                try {
		                        UIManager.setLookAndFeel(laf);
		                } catch (UnsupportedLookAndFeelException e) {
		                        e.printStackTrace();
		                }
		            }
		        });				
			}
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "Raven"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		                LookAndFeel laf = new SubstanceRavenLookAndFeel();
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
		                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		                try {
		                        UIManager.setLookAndFeel(laf);
		                } catch (UnsupportedLookAndFeelException e) {
		                        e.printStackTrace();
		                }
		            }
		        });				
			}
			if(e.getStateChange() == ItemEvent.SELECTED && this.combox.getSelectedItem() == "Sahara"){
				javax.swing.SwingUtilities.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                JFrame.setDefaultLookAndFeelDecorated(true);
		                LookAndFeel laf = new SubstanceSaharaLookAndFeel();
		                SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
		                //UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
		                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		                JFrame.setDefaultLookAndFeelDecorated(false);
		                JDialog.setDefaultLookAndFeelDecorated(true);
		                try {
		                        UIManager.setLookAndFeel(laf);
		                } catch (UnsupportedLookAndFeelException e) {
		                        e.printStackTrace();
		                }
		            }
		        });				
			}	
			
		}
	}

}
