package quan_li_khach_hang;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import conection.OpenConection;

public class KhachHang_Process {
	public boolean insertKhachHang(KhachHang khachHang) {
		boolean dm = false;
		Connection con =OpenConection.getConnection();
		try {
//			CallableStatement cst = con.prepareCall("{call PRO_INSERT_KHACHHANG(?,?,?,?,?)}");
			
			PreparedStatement cst = con.prepareStatement("insert into dbo.tbl_KhachHang(PK_KhachHang,sHoTen,sSoDienThoai,sDiaChi,iTrangThai) values (?,?,?,?,?)");
			
			cst.setString(1, khachHang.getPK_KhachHang());
			cst.setString(2, khachHang.getsHoTen());
//			cst.setDate(3, khachHang.getdNgaySinh());
			cst.setString(3, khachHang.getsSoDienThoai());
			cst.setString(4, khachHang.getsDiaChi());
			cst.setInt(5, khachHang.getiTrangThai());
//			cst.setInt(7, khachHang.getiDonVi());
			
			if (khachHang.getiDonVi() != null) {
				dm = true;
			}
//			System.out.println("dmm");
			cst.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			OpenConection.closeConnection(con);
		}
		
		return dm;
	}
	
	public Vector<KhachHang> getList(){
		Vector<KhachHang> u = new Vector<KhachHang>();
		Connection con = OpenConection.getConnection();
		try {
			CallableStatement cst = con.prepareCall("{call PRO_SELECT_KHACHHANG ()}");
			ResultSet rs = cst.executeQuery();
			while (rs.next()) {
				KhachHang user = new KhachHang();
				user.setPK_KhachHang(rs.getString(1));
				user.setsHoTen(rs.getString(2));
				user.setdNgaySinh(rs.getDate(3));
				user.setsSoDienThoai(rs.getString(4));
				user.setsDiaChi(rs.getString(5));
				user.setiTrangThai(rs.getInt(6));
				user.setiDonVi(rs.getInt(7));
				u.add(user);
			}
		} catch (Exception e) {
			
		}finally{
			OpenConection.closeConnection(con);
		}
		
		return u;

	}
	
	public Vector<KhachHang> getListSearch(String srt){
		Vector<KhachHang> u = new Vector<KhachHang>();
		Connection con = OpenConection.getConnection();
		try {
			CallableStatement cst = con.prepareCall("{call PRO_SEARCH_KHACHHANG ()}");
			cst.setString(1, srt);
			ResultSet rs = cst.executeQuery();
//			PreparedStatement cst = con.prepareStatement("select * from dbo.tbl_KhachHang where sHoTen like '%"+srt+"%'");
//			ResultSet rs = cst.executeQuery();
			while (rs.next()) {
				KhachHang user = new KhachHang();
				user.setPK_KhachHang(rs.getString(1));
				user.setsHoTen(rs.getString(2));
				user.setdNgaySinh(rs.getDate(3));
				user.setsSoDienThoai(rs.getString(4));
				user.setsDiaChi(rs.getString(5));
				user.setiTrangThai(rs.getInt(6));
				user.setiDonVi(rs.getInt(7));
				u.add(user);
			}
		} catch (Exception e) {
			
		}finally{
			OpenConection.closeConnection(con);
		}
		
		return u;

	}
}
