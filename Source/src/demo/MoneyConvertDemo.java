package demo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import javax.swing.text.StyledEditorKit.BoldAction;
import module.MoneyConvert;


/**
*
* @author liemmaster
*/
public class MoneyConvertDemo extends JFrame
{
	private MoneyConvert br = new MoneyConvert();
	
	public MoneyConvertDemo()
	{
		JLabel l1 = new JLabel("Số tiền: ");
		final JTextField t1 = new JTextField("10");
		
		t1.setColumns(15);
		final JTextField t2 = new JTextField();
		t2.setColumns(60);
		setLayout(new FlowLayout());
		add(l1);
		add(t1);
		add(t2);
		
		t1.addKeyListener(new KeyListener() 
		{
			public void keyTyped(KeyEvent e) 
			{
				t2.setText(br.tranlate(t1.getText()));
			}

			@Override
			public void keyPressed(KeyEvent e) {t2.setText(br.tranlate(t1.getText()));}

			@Override
			public void keyReleased(KeyEvent e) {t2.setText(br.tranlate(t1.getText()));}
		});
		
		setSize(700, 150);
		setDefaultCloseOperation(new JFrame().EXIT_ON_CLOSE);
	}
	public static void main(String[] args)
	{
		new MoneyConvertDemo().setVisible(true);
	}
}