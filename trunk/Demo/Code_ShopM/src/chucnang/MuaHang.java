package chucnang;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import trangchu.TrangChu;

import com.toedter.calendar.JDateChooser;

public class MuaHang extends JInternalFrame {

    private JPanel plNorth,plCenter,plSouth;
	private JComboBox txtTenNPP;
	private JTextField txtDiaChi;
	private JComboBox txtMa;
	private JTextField txtDienThoai;
	private JComboBox txtTenNV;
	private JComboBox txtThanhToan;
	private JTextField txtHanThanhToan;
	private JTextField txtTong;
	private JButton btnTaoMoi,btnLuuvaThem;
	String[][] data = {{"","(Gõ vào đây)","","","","","",""}};
    String[] colunms = {"Mã Hàng","Tên Hàng","Kho Hàng","Đơn Vị","Đơn Giá","Số Lượng","Thành Tiền"};
	public MuaHang(TrangChu trangchu) {
    	    	
    	this.setLayout(new BorderLayout(15,15));
    	plNorth = new JPanel();
		add(plNorth,BorderLayout.NORTH);
		GridBagLayout gbl_plNorth = new GridBagLayout();
		gbl_plNorth.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_plNorth.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_plNorth.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_plNorth.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		plNorth.setLayout(gbl_plNorth);
		
		//JLabel lblThongTin = new JLabel("Thông tin nhập hàng");
		plNorth.setBorder(new TitledBorder("Thông tin nhập hàng"));
		GridBagConstraints gbc_lblThongTin = new GridBagConstraints();
		gbc_lblThongTin.insets = new Insets(0, 0, 5, 5);
		gbc_lblThongTin.gridx = 0;
		gbc_lblThongTin.gridy = 1;
		//plNorth.add(lblThongTin, gbc_lblThongTin);
		
		JLabel lblTenNPP = new JLabel("Tên Nhà Phân Phối: ");
		GridBagConstraints gbc_lblTenNPP = new GridBagConstraints();
		gbc_lblTenNPP.anchor = GridBagConstraints.WEST;
		gbc_lblTenNPP.insets = new Insets(0, 0, 5, 5);
		gbc_lblTenNPP.gridx = 1;
		gbc_lblTenNPP.gridy = 2;
		plNorth.add(lblTenNPP, gbc_lblTenNPP);
		
		txtTenNPP = new JComboBox();
		GridBagConstraints gbc_txtTenNPP = new GridBagConstraints();
		gbc_txtTenNPP.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTenNPP.gridwidth = 17;
		gbc_txtTenNPP.insets = new Insets(0, 0, 5, 5);
		gbc_txtTenNPP.gridx = 2;
		gbc_txtTenNPP.gridy = 2;
		plNorth.add(txtTenNPP, gbc_txtTenNPP);
		//txtTenNPP.setColumns(10);
		
		
		JLabel lblMa = new JLabel("Mã: ");
		GridBagConstraints gbc_lblMa = new GridBagConstraints();
		gbc_lblMa.anchor = GridBagConstraints.WEST;
		gbc_lblMa.insets = new Insets(0, 0, 5, 5);
		gbc_lblMa.gridx = 20;
		gbc_lblMa.gridy = 2;
		plNorth.add(lblMa, gbc_lblMa);
		
		txtMa = new JComboBox();
		GridBagConstraints gbc_txtMa = new GridBagConstraints();
		gbc_txtMa.gridwidth = 1;
		gbc_txtMa.insets = new Insets(0, 0, 5, 5);
		gbc_txtMa.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMa.gridx = 21;
		gbc_txtMa.gridy = 2;
		plNorth.add(txtMa, gbc_txtMa);
		//txtMa.setColumns(10);
		
		JLabel lblDiaChi = new JLabel("Địa Chỉ: ");
		GridBagConstraints gbc_lblDiaChi = new GridBagConstraints();
		gbc_lblDiaChi.anchor = GridBagConstraints.WEST;
		gbc_lblDiaChi.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiaChi.gridx = 1;
		gbc_lblDiaChi.gridy = 3;
		plNorth.add(lblDiaChi, gbc_lblDiaChi);
		
		txtDiaChi = new JTextField();
		GridBagConstraints gbc_txtDiaChi = new GridBagConstraints();
		gbc_txtDiaChi.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDiaChi.gridwidth = 17;
		gbc_txtDiaChi.insets = new Insets(0, 0, 5, 5);
		gbc_txtDiaChi.gridx = 2;
		gbc_txtDiaChi.gridy = 3;
		plNorth.add(txtDiaChi, gbc_txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblDienThoai = new JLabel("Điện Thoại: ");
		GridBagConstraints gbc_lblDienThoai = new GridBagConstraints();
		gbc_lblDienThoai.anchor = GridBagConstraints.WEST;
		gbc_lblDienThoai.insets = new Insets(0, 0, 5, 5);
		gbc_lblDienThoai.gridx = 20;
		gbc_lblDienThoai.gridy = 3;
		plNorth.add(lblDienThoai, gbc_lblDienThoai);
		
		txtDienThoai = new JTextField();
		GridBagConstraints gbc_txtDienThoai = new GridBagConstraints();
		gbc_txtDienThoai.gridwidth = 1;
		gbc_txtDienThoai.insets = new Insets(0, 0, 5, 5);
		gbc_txtDienThoai.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDienThoai.gridx = 21;
		gbc_txtDienThoai.gridy = 3;
		plNorth.add(txtDienThoai, gbc_txtDienThoai);
		txtDienThoai.setColumns(10);
		
		JLabel lblTenNN = new JLabel("Nhân Viên Nhận Hàng: ");
		GridBagConstraints gbc_lblTenNN = new GridBagConstraints();
		gbc_lblTenNN.anchor = GridBagConstraints.WEST;
		gbc_lblTenNN.insets = new Insets(0, 0, 5, 5);
		gbc_lblTenNN.gridx = 1;
		gbc_lblTenNN.gridy = 4;
		plNorth.add(lblTenNN, gbc_lblTenNN);
		
		txtTenNV = new JComboBox();
		GridBagConstraints gbc_txtTenNV = new GridBagConstraints();
		gbc_txtTenNV.gridwidth = 17;
		gbc_txtTenNV.insets = new Insets(0, 0, 5, 5);
		gbc_txtTenNV.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTenNV.gridx = 2;
		gbc_txtTenNV.gridy = 4;
		plNorth.add(txtTenNV, gbc_txtTenNV);
		//txtTenNV.setColumns(10);
		
		JLabel lblNgay = new JLabel("Ngày: ");
		GridBagConstraints gbc_lblNgay = new GridBagConstraints();
		gbc_lblNgay.anchor = GridBagConstraints.WEST;
		gbc_lblNgay.insets = new Insets(0, 0, 5, 5);
		gbc_lblNgay.gridx = 20;
		gbc_lblNgay.gridy = 4;
		plNorth.add(lblNgay, gbc_lblNgay);
			
		GridBagConstraints gbc_txtNgay = new GridBagConstraints();
		gbc_txtNgay.gridwidth = 1;
		gbc_txtNgay.insets = new Insets(0, 0, 5, 5);
		gbc_txtNgay.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNgay.gridx = 21;
		gbc_txtNgay.gridy = 4;
		//Lay gio he thong
//        Date todayD=new Date(System.currentTimeMillis()); 
//        //Khai bao dinh dang ngay thang
//        SimpleDateFormat dayFormat= new SimpleDateFormat("dd/MM/yyyy"); 
//        //parse ngay thang sang dinh dang va chuyen thanh string.
//        String todayS=dayFormat.format(todayD.getTime());
//        JFormattedTextField defaultDateField = new JFormattedTextField(todayS);
//        this.plNorth.add(defaultDateField,gbc_txtNgay);
				
		
		JDateChooser dateStart = new JDateChooser();
		dateStart.setDateFormatString("dd/MM/yyyy");
		plNorth.add(dateStart,gbc_txtNgay);
		
		
		
		JLabel lblThanhToan = new JLabel("Điều Khoản Thanh Toán:");
		GridBagConstraints gbc_lblThanhToan = new GridBagConstraints();
		gbc_lblThanhToan.anchor = GridBagConstraints.WEST;
		gbc_lblThanhToan.insets = new Insets(0, 0, 0, 5);
		gbc_lblThanhToan.gridx = 1;
		gbc_lblThanhToan.gridy = 5;
		plNorth.add(lblThanhToan, gbc_lblThanhToan);
		
		txtThanhToan = new JComboBox();
		GridBagConstraints gbc_txtThanhToan = new GridBagConstraints();
		gbc_txtThanhToan.gridwidth = 17;
		gbc_txtThanhToan.insets = new Insets(0, 0, 0, 5);
		gbc_txtThanhToan.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtThanhToan.gridx = 2;
		gbc_txtThanhToan.gridy = 5;
		plNorth.add(txtThanhToan, gbc_txtThanhToan);
		//txtThanhToan.setColumns(10);
		
		JLabel lblHanThanhToan = new JLabel("Hạn Thanh Toán:");
		GridBagConstraints gbc_lblHanThanhToan = new GridBagConstraints();
		gbc_lblHanThanhToan.anchor = GridBagConstraints.WEST;
		gbc_lblHanThanhToan.insets = new Insets(0, 0, 0, 5);
		gbc_lblHanThanhToan.gridx = 20;
		gbc_lblHanThanhToan.gridy = 5;
		plNorth.add(lblHanThanhToan, gbc_lblHanThanhToan);
		
		txtHanThanhToan = new JTextField();
		GridBagConstraints gbc_txtHanThanhToan = new GridBagConstraints();
		gbc_txtHanThanhToan.gridwidth = 1;
		gbc_txtHanThanhToan.insets = new Insets(0, 0, 0, 5);
		gbc_txtHanThanhToan.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHanThanhToan.gridx = 21;
		gbc_txtHanThanhToan.gridy = 5;
		plNorth.add(txtHanThanhToan, gbc_txtHanThanhToan);
		txtHanThanhToan.setColumns(10);
	
		plCenter = new JPanel();
		add(plCenter,BorderLayout.CENTER);
		plCenter.setLayout(new BorderLayout());
    	JScrollPane scrollPane = new JScrollPane();
    	plCenter.add(scrollPane);
		
		JTable table = new JTable(data,colunms);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		scrollPane.setViewportView(table);
		
		
		plSouth = new JPanel();
		plSouth.setLayout(new BorderLayout());
		add(plSouth,BorderLayout.SOUTH);
		JPanel plSouth1 = new JPanel();
		plSouth1.setLayout(new FlowLayout(FlowLayout.LEFT));
		plSouth.add(plSouth1,BorderLayout.CENTER);
		JLabel lbMaHang = new JLabel("Mã Hàng: ");
		plSouth1.add(lbMaHang);
		JTextField txtMaHang = new JTextField(8);
		plSouth1.add(txtMaHang);
		JLabel lbTenHang = new JLabel("Tên Hàng: ");
		plSouth1.add(lbTenHang);
		JTextField txtTenHang = new JTextField(15);
		plSouth1.add(txtTenHang);
		JLabel lbKhoHang = new JLabel("Kho Hàng: ");
		plSouth1.add(lbKhoHang);
		JTextField txtKhoHang = new JTextField(10);
		plSouth1.add(txtKhoHang);
		JLabel lbDonVi = new JLabel("Đơn Vị: ");
		plSouth1.add(lbDonVi);
		JTextField txtDonVi = new JTextField(5);
		plSouth1.add(txtDonVi);
		JLabel lbDonGia = new JLabel("Đơn Giá: ");
		plSouth1.add(lbDonGia);
		JTextField txtDonGia = new JTextField(7);
		plSouth1.add(txtDonGia);
		JLabel lbSoLuong = new JLabel("Số Lượng: ");
		plSouth1.add(lbSoLuong);
		JTextField txtSoLuong = new JTextField(3);
		plSouth1.add(txtSoLuong);
		JLabel lbThanhTien = new JLabel("Thành Tiền: ");
		plSouth1.add(lbThanhTien);
		JTextField txtThanhTien = new JTextField(7);
		plSouth1.add(txtThanhTien);
		
		JPanel plSouth2 = new JPanel();
		plSouth.add(plSouth2,BorderLayout.SOUTH);
		
		plSouth2.setLayout(new FlowLayout(FlowLayout.LEFT));
		btnTaoMoi = new JButton("Tạo Mới");
		plSouth2.add(btnTaoMoi);
		btnLuuvaThem = new JButton("Lưu và Thêm");
		plSouth2.add(btnLuuvaThem);
		JLabel lblTong = new JLabel("Thanh Toán: ");
		plSouth2.add(lblTong);
		txtTong = new JTextField(50);
		plSouth2.add(txtTong);
		
		
    }
}
