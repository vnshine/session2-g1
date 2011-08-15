package process;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import connect.IOConnection;
import myobject.TienTe;

public class TienTe_Process {
	public void insertTienTe (String name, Float mua, Float ban ){
		Connection con = IOConnection.getConnection();
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
			IOConnection.closeConnection(con);
		}
		
	}
	
	public Vector<TienTe> showList(){
		Connection con = IOConnection.getConnection();
		Vector<TienTe> u = new Vector<TienTe>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from dbo.tbl_TienTe");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TienTe tienTe = new TienTe();
				tienTe.setIdTienTe(rs.getString(1));
				tienTe.setTenTienTe(rs.getString(2));
				tienTe.setTyGiaMuaVao(rs.getFloat(3));
				tienTe.setTyGiaBanRa(rs.getFloat(4));
				u.add(tienTe);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			IOConnection.closeConnection(con);
		}
		
		return u;
	}
	public void updateTienTe(String id, String name, Float mua, Float ban){
		Connection con = IOConnection.getConnection();
		try {
			CallableStatement cst = con.prepareCall("{call UpdateTienTe(?,?,?,?)}");
			
			cst.setString(1, id);
			cst.setString(2, name.toUpperCase());
			cst.setFloat(3, mua);
			cst.setFloat(4, ban);
			
			cst.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			IOConnection.closeConnection(con);
		}
		
	}
}
