package process;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;




import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class QuanLiKhachHang extends JFrame implements ActionListener {
	private static final Integer Interger = null;
	private JFrame fFrame;
	private JPanel pBaner;
	private JPanel pWorkSpace;
	private JLabel lBaner;
	private JButton[] bButton;
	private JTable tblResult;
	DefaultTableModel model;
	private JTable tblResult2;
	DefaultTableModel model2;
	private JScrollPane scpTable;
	private JScrollPane scpTable2;
	private JTabbedPane tTab;
	private JTextField[] tText;
	private JCheckBox[] chkCheck;
	private JTextField[] txtText;
	private JTextField txtSearch2;
	private Integer row;
	private String id;
	public QuanLiKhachHang(){
		//Frame
		fFrame = new JFrame();
		BorderLayout layout = new BorderLayout();
		fFrame.setLayout(layout);
		fFrame.setPreferredSize(new Dimension(800,600));
		
		
		//Baner
		pBaner = new JPanel();
		pBaner.setPreferredSize(new Dimension(800,100));
		Font f = new Font("Tahoma", 0, 20);
		lBaner = new JLabel("Quáº£n LĂ­ KhĂ¡ch HĂ ng");
		lBaner.setFont(f);
		pBaner.add(lBaner);
		fFrame.add(pBaner,layout.NORTH);
		
		
		//WorkSpace
		pWorkSpace = new JPanel();
		pWorkSpace.setPreferredSize(new Dimension(800,500));
		tTab = new JTabbedPane();
		
		
			//ThĂªm
			JPanel tab1 = new JPanel();
			FlowLayout flow = new FlowLayout();
			tab1.setLayout(flow);
			String[] str = {"ID","Há»� vĂ  TĂªn","NgĂ y sinh","SÄ�T","Ä�á»‹a chá»‰","Tráº¡ng ThĂ¡i","Ä�Æ¡n vá»‹"};
			JLabel[] lLabels;
			
			JButton bAdd, bReset;
			tText = new JTextField[7];
			lLabels = new JLabel[7];
			bAdd = new JButton("ThĂªm");
			bAdd.setActionCommand("ThĂªm");
			bAdd.addActionListener(this);
			bReset = new JButton("Há»§y");
			bReset.setActionCommand("Há»§y");
			bReset.addActionListener(this);
			for (int i = 0; i < lLabels.length; i++) {
				lLabels[i] = new JLabel(str[i]);
				tText[i] = new JTextField(10); 
				tab1.add(lLabels[i]);
				tab1.add(tText[i]);
			}
			tab1.add(bAdd);
			tab1.add(bReset);
	        tTab.addTab("ThĂªm", tab1);
	        tTab.setSelectedIndex(0);
	        
	        
	        
	        //XĂ³a 
	        JPanel tab2 =new JPanel();
	        BorderLayout layout2 = new BorderLayout();
	        tab2.setLayout(layout2);
	        scpTable = new JScrollPane();
			Object[][] data = {};
			String[] column = {" ","KhĂ¡ch HĂ ng", "Há»� vĂ  TĂªn", "NgĂ y Sinh","SÄ�T","Ä�á»‹a Chá»‰","Tráº¡ng ThĂ¡i","Ä�Æ¡n Vá»‹"};
			model = new DefaultTableModel(data, column);
			tblResult = new JTable(model);
			tblResult.setPreferredScrollableViewportSize(new Dimension(800,250));
			scpTable.setViewportView(tblResult);
			
			JButton btnList,btnSearch,btnDel;
			JTextField txtSearch;
			JLabel lSearch;
			btnList = new JButton("Hiá»ƒn thá»‹ danh sĂ¡ch");
			btnList.addActionListener(this);
			btnList.setActionCommand("Hiá»ƒn thá»‹ danh sĂ¡ch");
			btnSearch = new JButton("TĂ¬m Kiáº¿m");
			btnSearch.addActionListener(this);
			btnSearch.setActionCommand("TĂ¬m Kiáº¿m");
			btnDel = new JButton("XĂ³a");
			btnDel.addActionListener(this);
			btnDel.setActionCommand("XĂ³a");
			txtSearch = new JTextField(10);
			lSearch = new JLabel("TĂªn KhĂ¡ch HĂ ng");
			
			tab2.add(scpTable, layout2.NORTH);
			tab2.add(btnList, layout2.CENTER);
			JPanel panel = new JPanel();
			panel.add(lSearch);
			panel.add(txtSearch);
			panel.add(btnSearch);
			panel.add(btnDel);
			tab2.add(panel, layout2.SOUTH);
			tTab.addTab("xĂ³a", tab2);
			tTab.setSelectedIndex(1);
			
			
			
			//j
			JPanel tab3 =new JPanel();
	        BorderLayout layout3 = new BorderLayout();
	        tab3.setLayout(layout3);
	        scpTable2 = new JScrollPane();
			Object[][] data2 = {};
			String[] column2 = {"KhĂ¡ch HĂ ng", "Há»� vĂ  TĂªn", "NgĂ y Sinh","SÄ�T","Ä�á»‹a Chá»‰","Tráº¡ng ThĂ¡i","Ä�Æ¡n Vá»‹"};
			model2 = new DefaultTableModel(data2, column2);
			tblResult2 = new JTable(model2);
			tblResult2.setPreferredScrollableViewportSize(new Dimension(800,250));
			scpTable2.setViewportView(tblResult2);
			
			JButton btnList2,btnSearch2,btnGetInfo,btnUpdate;
			
			JLabel[] lLabel;
			String[] label = {"Há»� TĂªn","NgĂ y sinh","SÄ�T","Ä�á»‹a chĂ¬","Tráº¡ng thĂ¡i","Ä�Æ¡n vá»‹"};
			lLabel = new JLabel[6];
			txtText = new JTextField[6];
			btnList2 = new JButton("Hiá»ƒn thá»‹ danh sĂ¡ch");
			btnList2.addActionListener(this);
			btnList2.setActionCommand("Hiá»ƒn thá»‹ danh sĂ¡ch 2");
//			btnList2.setPreferredSize(new Dimension(10,25));
			JPanel listPanel = new JPanel();
			listPanel.add(btnList2);
			listPanel.setPreferredSize(new Dimension(25,25));
			btnSearch2 = new JButton("TĂ¬m Kiáº¿m");
			btnSearch2.setActionCommand("TĂ¬m Kiáº¿m 2");
			btnSearch2.addActionListener(this);
			btnGetInfo = new JButton("Láº¥y");
			btnGetInfo.addActionListener(this);
			btnGetInfo.setActionCommand("Láº¥y");
			btnUpdate= new JButton("Sá»­a");
			btnUpdate.addActionListener(this);
			btnUpdate.setActionCommand("Sá»­a");
			txtSearch2 = new JTextField(5);
			JPanel panel2 = new JPanel();
			panel2.add(txtSearch2);
			panel2.add(btnSearch2);
			for (int i = 0; i < label.length; i++) {
				lLabel[i] = new JLabel(label[i]);
				txtText[i] = new JTextField(5);
				panel2.add(lLabel[i]);
				panel2.add(txtText[i]);
			}
			panel2.add(btnGetInfo);
			panel2.add(btnUpdate);
			tab3.add(scpTable2, layout3.NORTH);
			tab3.add(listPanel, layout3.CENTER);
			tab3.add(panel2, layout3.SOUTH);
			tTab.addTab("Sá»­a", tab3);
			tTab.setSelectedIndex(2);
		
		
		//FRAME
		fFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fFrame.add(tTab, layout.CENTER);
		fFrame.pack();
		fFrame.setVisible(true);
		
		
		
		
		/*-----------------------------------------------------------------------------*/
		
		
		
		
		
	}
	public void loadData(){
		DefaultTableModel dtm = (DefaultTableModel) tblResult2.getModel();
		dtm.getDataVector().removeAllElements();
		dtm.fireTableChanged(null);
	}
	
	public static void main(String[] args) {
		new QuanLiKhachHang();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("ThĂªm")) {
			KhachHang_Process khachHang_Process = new KhachHang_Process();
			KhachHang khachHang = new KhachHang();
			khachHang.setPK_KhachHang(tText[0].getText());
			
			
			khachHang.setsHoTen(tText[1].getText());
			
//			 DateFormat formatter ; 
//			 Date date ; 
//			  formatter = new SimpleDateFormat("dd-MM-yyyy");
//			  try {
//				date = (Date)formatter.parse(tText[2].getText());
//			
//			  khachHang.setdNgaySinh(date);
//			 System.out.println("Today is " +date );
//			  } catch (ParseException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			
			
			
			
			khachHang.setsSoDienThoai(tText[3].getText());
			khachHang.setsDiaChi(tText[4].getText());
			
			Integer trangThai;
			trangThai = Interger.parseInt(tText[5].getText());
			khachHang.setiTrangThai(trangThai);
			
			Integer donVi;
			donVi = Interger.parseInt(tText[6].getText());
			khachHang.setiDonVi(donVi);
			
			khachHang_Process.insertKhachHang(khachHang);
			System.out.println(khachHang_Process.insertKhachHang(khachHang));
		}
		if (e.getActionCommand().equals("Há»§y")) {
			for (int i = 0; i < 7; i++) {
				tText[i].setText("");
			}
		}
		
		
		if (e.getActionCommand().equals("Hiá»ƒn thá»‹ danh sĂ¡ch")) {
			loadData();
			KhachHang_Process hang_Process = new KhachHang_Process();
			Vector<KhachHang> u = new Vector<KhachHang>();
			u = hang_Process.getList();
			chkCheck = new JCheckBox[u.size()];
			for (int i = 0; i < u.size(); i++) {
				KhachHang user = (KhachHang) u .get(i);
				
				chkCheck[i] = new JCheckBox();
				Object[] data = {chkCheck[i],user.getPK_KhachHang(),user.getsHoTen(),user.getdNgaySinh(),user.getsSoDienThoai(),user.getsDiaChi(),user.getiTrangThai(),user.getiDonVi()};
				model.insertRow(i, data);
			}
		}
		
		
		if (e.getActionCommand().equals("Hiá»ƒn thá»‹ danh sĂ¡ch 2")) {
			loadData();
			KhachHang_Process hang_Process = new KhachHang_Process();
			Vector<KhachHang> u = new Vector<KhachHang>();
			u = hang_Process.getList();
			for (int i = 0; i < u.size(); i++) {
				KhachHang user = (KhachHang) u .get(i);
				Object[] data2 = {user.getPK_KhachHang(),user.getsHoTen(),user.getdNgaySinh(),user.getsSoDienThoai(),user.getsDiaChi(),user.getiTrangThai(),user.getiDonVi()};
				model2.insertRow(i, data2);
			}
		}
		
		if (e.getActionCommand().equals("TĂ¬m Kiáº¿m 2")) {
			loadData();
			KhachHang_Process hang_Process = new KhachHang_Process();
			Vector<KhachHang> u = new Vector<KhachHang>();
			u = hang_Process.getListSearch(txtSearch2.getText());
			for (int i = 0; i < u.size(); i++) {
				KhachHang user = (KhachHang) u .get(i);
				Object[] data2 = {user.getPK_KhachHang(),user.getsHoTen(),user.getdNgaySinh(),user.getsSoDienThoai(),user.getsDiaChi(),user.getiTrangThai(),user.getiDonVi()};
				model2.insertRow(i, data2);
			}
		}
		
		
		if (e.getActionCommand().equals("Láº¥y")) {
			row = tblResult2.getSelectedRow();
			id = (String) tblResult2.getValueAt(row, 0);
			txtText[0].setText((String) tblResult2.getValueAt(row, 1));
//			txtText[1].setText((String) tblResult2.getValueAt(row, 2));
			txtText[2].setText((String) tblResult2.getValueAt(row, 3));
			txtText[3].setText((String) tblResult2.getValueAt(row, 4));
//			txtText[4].setText((String) tblResult2.getValueAt(row, 5));
//			txtText[5].setText((String) tblResult2.getValueAt(row, 6));		
		}
		
		if (e.getActionCommand().equals("Sá»­a")) {
			KhachHang_Process hang_Process = new KhachHang_Process();
			String id2 = id;
			String ten = txtText[0].getText();
			String sdt = txtText[2].getText();
			String diachi = txtText[3].getText();
			hang_Process.updatePerson(ten, sdt, diachi, id2);
			loadData();
			Vector<KhachHang> u = new Vector<KhachHang>();
			u = hang_Process.getList();
			for (int i = 0; i < u.size(); i++) {
				KhachHang user = (KhachHang) u .get(i);
				Object[] data2 = {user.getPK_KhachHang(),user.getsHoTen(),user.getdNgaySinh(),user.getsSoDienThoai(),user.getsDiaChi(),user.getiTrangThai(),user.getiDonVi()};
				model2.insertRow(i, data2);
			}
			
		}
	}

}
