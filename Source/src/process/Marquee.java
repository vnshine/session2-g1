package process;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Marquee extends JPanel implements ActionListener {


    private static final int RATE = 12;
    private final Timer timer = new Timer(1000 / RATE, this);
    private final JLabel label = new JLabel();
    private final String s;
    private final int n;
    private int index;

    public Marquee(String s, int n) {
        if (s == null || n < 1) {
            throw new IllegalArgumentException("Null string or n < 1");
        }
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append(' ');
        }
        this.s = sb + s + sb;
        this.n = n;
        label.setFont(new Font("Serif", Font.ITALIC, 20));
        label.setText(sb.toString());
        this.add(label);
    }
    public void start() {
        timer.start();
    }
    public void stop() {
        timer.stop();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        index++;
        if (index > s.length() - n) {
            index = 0;
        }
        label.setText(s.substring(index, index + n));
    }
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Marquee");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String s = "Project NhatQuang";
        Marquee m = new Marquee(s, 100);
        f.add(m);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        m.start();

	}

}
