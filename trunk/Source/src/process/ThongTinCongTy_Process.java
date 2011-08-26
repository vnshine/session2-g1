package process;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import myobject.ThongTinCongTy;
import myobject.TienTe;
import connect.ioconnection;

public class ThongTinCongTy_Process {
	public Integer soPhanTu(){
		Connection con =ioconnection.getConnection();
		Integer count = null;
		try {
			PreparedStatement ps = con.prepareStatement("select count(*) from dbo.tbl_ThongTinCongTy");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			ioconnection.closeConnection(con);
		}
		
		return count;
	}
	
	public Vector<ThongTinCongTy> showList(Integer trang) throws SQLException{
		Connection con =ioconnection.getConnection();
		Vector<ThongTinCongTy> u = new Vector<ThongTinCongTy>();
		try {
			CallableStatement cst = con.prepareCall("{call PhanTrang_CongTy(?)}");
			cst.setInt(1, trang);
			
			ResultSet rs = cst.executeQuery();
			while (rs.next()) {
				ThongTinCongTy congTy = new ThongTinCongTy();
				congTy.setIdCongTy(rs.getString(1));
				congTy.setTenCongTy(rs.getString(2));
				congTy.setDiaChiCongTy(rs.getString(4));
				congTy.setSdtCongTy(rs.getString(6));
				congTy.setEmailCongTy(rs.getString(7));
				congTy.setWebCongTy(rs.getString(8));
				congTy.setIdTienTe(rs.getString(9));
				congTy.setSlTienMat(rs.getInt(10));
				u.add(congTy);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			ioconnection.closeConnection(con);
		}
		
		return u;
	}
	
	public void insertCongTy (String id, String name, String diaChi, String sdt, String email, String web, String tienTe, Integer soLuong)  throws SQLException{
		Connection con =ioconnection.getConnection();
		try {
			CallableStatement cst = con.prepareCall("{call InsertCongTy(?,?,?,?,?,?,?,?)}");
			
			cst.setString(1, id);
			cst.setString(2, name.toUpperCase());
			cst.setString(3, diaChi);
			cst.setString(4, sdt);
			cst.setString(5, email);
			cst.setString(6, web);
			cst.setString(7, tienTe);
			cst.setInt(8, soLuong);
			
			cst.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			ioconnection.closeConnection(con);
		}
		
	}
	
	public void deleteCongTy(String id)  throws SQLException{
		Connection con =ioconnection.getConnection();
		try {
			CallableStatement cst = con.prepareCall("{call DeleteCongTy(?)}");
			
			cst.setString(1, id);
			
			cst.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			ioconnection.closeConnection(con);
		}
		
	}
	
	public void updateCongTy(String id, String name, String diaChi, String sdt, String email, String web, String tienTe, Integer soLuong)  throws SQLException{
		Connection con =ioconnection.getConnection();
		try {
			CallableStatement cst = con.prepareCall("{call UpdateCongTy(?,?,?,?,?,?,?,?,?,?)}");
			
			cst.setString(1, id);
			cst.setString(2, name.toUpperCase());
			cst.setString(3, name.toUpperCase().trim());
			cst.setString(4, diaChi);
			cst.setString(5, diaChi.toUpperCase().trim());
			cst.setString(6, sdt);
			cst.setString(7, email);
			cst.setString(8, web);
			cst.setString(9, tienTe);
			cst.setInt(10, soLuong);
			
			cst.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			ioconnection.closeConnection(con);
		}
		
	}
}
