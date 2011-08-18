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
	
	public void insertTienTe (String name, Float mua, Float ban )  throws SQLException{
		Connection con =ioconnection.getConnection();
		Integer a = 0;
		String id;
		try {
			PreparedStatement ps = con.prepareStatement("select count(*) from dbo.tbl_TienTe");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = rs.getInt(1);
			}
			if (a<10) {
				id = "T0" + (a+1);
			}else {
				id = "T" + (a+1);
			}
			CallableStatement cst = con.prepareCall("{call InsertTienTe(?,?,?,?)}");
			
			cst.setString(1, id);
			cst.setString(2, name.toUpperCase());
			cst.setFloat(3, mua);
			cst.setFloat(4, ban);
			
			cst.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			ioconnection.closeConnection(con);
		}
		
	}
}
