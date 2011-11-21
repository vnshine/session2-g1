package module;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import myobject.TyGia;

/** @see http://stackoverflow.com/questions/3617326 */
public class MarqueeTyGia extends JPanel {
	public MarqueeTyGia() {
		//String s = "T\u1EF7 gi\u00E1 ch\u00E9m gi\u00F3 h\u00F4m nay l\u00E0 Vi\u1EC7t nam ch\u00E9m 1 = M\u1EF9 ch\u00E9m 100 = Trung qu\u1ED1c ch\u00E9m 100 = Nh\u1EADt b\u1EA3n ch\u00E9m 99,5 = EU ch\u00E9m 98.75  t\u1EF7 gi\u00E1 ch\u00E9m gi\u00F3 c\u1EE7a Vi\u1EC7t Nam t\u0103ng v\u1ECDt so v\u1EDBi c\u00F9ng k\u1EF3 n\u0103m tr\u01B0\u1EDBc";
		Vector<TyGia> b = new LayTyGia().layTyGia();
		String s = "Tỷ giá ngoại tệ theo ngân hàng vietcombank hôm nay :   "+"               .::   "+
		b.get(0).getLoaiNgoaiTe() + " -    mua tiền mặt:  "+b.get(0).getMuaTienMat()+"  .:.  mua chuyển khoản:  "+b.get(0).getMuaChuyenKhoan()
		+"  .:.  bán ra:  "+b.get(0).getBanRa()
		+"               .::   "+
		b.get(1).getLoaiNgoaiTe() + " -    mua tiền mặt:  "+b.get(1).getMuaTienMat()+"  .:.  mua chuyển khoản:  "+b.get(1).getMuaChuyenKhoan()
		+"  .:.  bán ra:  "+b.get(1).getBanRa()
		+"               .::   "+
		b.get(2).getLoaiNgoaiTe() + " -    mua tiền mặt:  "+b.get(2).getMuaTienMat()+"  .:.  mua chuyển khoản:  "+b.get(2).getMuaChuyenKhoan()
		+"  .:.  bán ra:  "+b.get(2).getBanRa()
		+"               .::   "+
		b.get(3).getLoaiNgoaiTe() + " -    mua tiền mặt:  "+b.get(3).getMuaTienMat()+"  .:.  mua chuyển khoản:  "+b.get(3).getMuaChuyenKhoan()
		+"  .:.  bán ra:  "+b.get(3).getBanRa()
		+"               .::   "+
		b.get(4).getLoaiNgoaiTe() + " -    mua tiền mặt:  "+b.get(4).getMuaTienMat()+"  .:.  mua chuyển khoản:  "+b.get(4).getMuaChuyenKhoan()
		+"  .:.      bán ra:  "+b.get(4).getBanRa();
				//b.get(4).getLoaiNgoaiTe();
		
		MarqueePanel mp = new MarqueePanel(s, 200);
		mp.setBackground(Color.DARK_GRAY);
		mp.setOpaque(true);
        this.add(mp);
        mp.start();
	}
}

/** Side-scroll n characters of s. */
class MarqueePanel extends JPanel implements ActionListener {

    private static final int RATE = 10;
    private final Timer timer = new Timer(1000 / RATE, this);
    private final JLabel label = new JLabel();
    private final String s;
    private final int n;
    private int index;

    public MarqueePanel(String s, int n) {
        if (s == null || n < 1) {
            throw new IllegalArgumentException("Null string or n < 1");
        }
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append(' ');
        }
        this.s = sb + s + sb;
        this.n = n;
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setForeground(Color.RED);
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
}