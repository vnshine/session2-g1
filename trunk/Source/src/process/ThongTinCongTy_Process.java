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
	public Vector<ThongTinCongTy> showList() throws SQLException{
		Connection con =ioconnection.getConnection();
		Vector<ThongTinCongTy> u = new Vector<ThongTinCongTy>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from dbo.tbl_ThongTinCongTy");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ThongTinCongTy congTy = new ThongTinCongTy();
				congTy.setIdCongTy(rs.getString(1));
				congTy.setTenCongTy(rs.getString(2));
				congTy.setDiaChiCongTy(rs.getString(3));
				congTy.setSdtCongTy(rs.getString(4));
				congTy.setEmailCongTy(rs.getString(5));
				congTy.setWebCongTy(rs.getString(6));
				congTy.setIdTienTe(rs.getString(7));
				congTy.setSlTienMat(rs.getInt(8));
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
			CallableStatement cst = con.prepareCall("{call UpdateCongTy(?,?,?,?,?,?,?,?)}");
			
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
}
