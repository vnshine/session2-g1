package process;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import connect.ioconnection;
import myobject.ThongTinCongTy;
import myobject.TienTe;

public class TienTe_Process  {
	
	public Integer soPhanTu(){
		Connection con =ioconnection.getConnection();
		Integer count = null;
		try {
			PreparedStatement ps = con.prepareStatement("select count(*) from dbo.tbl_TienTe");
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
	
	public Integer soPhanTuSearch(){
		Connection con =ioconnection.getConnection();
		Integer count = null;
		try {
			PreparedStatement ps = con.prepareStatement("select count(*) from dbo.search2");
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
	
	public Vector<TienTe> showList(Integer trang) throws SQLException{
		Connection con =ioconnection.getConnection();
		Vector<TienTe> u = new Vector<TienTe>();
		try {
			CallableStatement cst = con.prepareCall("{call PhanTrang_TienTe(?)}");
			cst.setInt(1, trang);
			
			ResultSet rs = cst.executeQuery();
			while (rs.next()) {
				TienTe tienTe = new TienTe();
				tienTe.setIdTienTe(rs.getString(1));
				tienTe.setTenTienTe(rs.getString(2));
				tienTe.setTyGiaMuaVao(rs.getFloat(4));
				tienTe.setTyGiaBanRa(rs.getFloat(5));
				System.out.println(tienTe.getIdTienTe());
				u.add(tienTe);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			ioconnection.closeConnection(con);
		}
		
		return u;
	}
	
	public Vector<TienTe> searchList(Integer trang) throws SQLException{
		Connection con =ioconnection.getConnection();
		Vector<TienTe> u = new Vector<TienTe>();
		try {
			
			CallableStatement cst = con.prepareCall("{call SearchPhanTrang_TienTe(?)}");
			cst.setInt(1, trang);
			
			ResultSet rs = cst.executeQuery();
			while (rs.next()) {
				TienTe tienTe = new TienTe();
				tienTe.setIdTienTe(rs.getString(1));
				tienTe.setTenTienTe(rs.getString(2));
				tienTe.setTyGiaMuaVao(rs.getFloat(4));
				tienTe.setTyGiaBanRa(rs.getFloat(5));
				u.add(tienTe);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			ioconnection.closeConnection(con);
		}
		return u;
	}
	
	public Vector<TienTe> searchTienTe(String id, String name) throws SQLException{
		Connection con =ioconnection.getConnection();
		Vector<TienTe> u = new Vector<TienTe>();
		
		try {
			String str = "IF EXISTS ";
			str = str + "(SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'search2' AND TABLE_TYPE = 'VIEW' AND TABLE_SCHEMA = 'dbo') ";
			str = str + "DROP VIEW dbo.search2 ";
			str = str + "EXEC(' CREATE view dbo.search2 AS select * from dbo.tbl_TienTe where ";
			str = str + "PK_sTienTeID like ''%"+id+"%'' and ";
			name = name.replace(" ", "");
			str = str + "sTenTienEng like ''%"+name.toUpperCase()+"%'' ";
//			str = str + "fMuaVao like ''%"+muaVao+"%'' and ";
//			str = str + "fBanRa like ''%"+banRa+"%'' ";
			str = str + "')";
			PreparedStatement pr = con.prepareStatement(str);
			ResultSet rs = pr.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			ioconnection.closeConnection(con);
		}
		
		return u;
	}
	
	public void insertTienTe (String id , String name, Float mua, Float ban )  throws SQLException{
		Connection con =ioconnection.getConnection();
		try {
			CallableStatement cst = con.prepareCall("{call InsertTienTe(?,?,?,?,?)}");
			
			
			
			cst.setString(1, id);
			cst.setString(2, name.toUpperCase());
			name.replace(" ", "");
			cst.setString(3, name.toUpperCase());
			cst.setFloat(4, mua);
			cst.setFloat(5, ban);
			
			cst.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			ioconnection.closeConnection(con);
		}
		
	}
	
	
	public void updateTienTe(String id, String name, Float mua, Float ban)  throws SQLException{
		Connection con =ioconnection.getConnection();
		try {
			CallableStatement cst = con.prepareCall("{call UpdateTienTe(?,?,?,?,?)}");
			
			cst.setString(1, id);
			cst.setString(2, name.toUpperCase());
			cst.setString(3, name.toUpperCase().trim());
			cst.setFloat(4, mua);
			cst.setFloat(5, ban);
			
			cst.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			ioconnection.closeConnection(con);
		}
		
	}
	
	public Boolean TrungMa(String id, String ten)
    {
            Connection con = ioconnection.getConnection();
            Boolean result = false;
            try
            {
                    CallableStatement cst = con.prepareCall("{call TrungTienTe (?,?)}");
                    
                    cst.setString(1, id);
                    cst.setString(2, ten);
                    
                    ResultSet rs =  cst.executeQuery();

                    if(rs.next())
                    {
                            result = true;
                    }

            }
            catch (Exception e)
            {
                    e.printStackTrace();
            }
            finally
            {
                
                    ioconnection.closeConnection(con);	
                    return result;
            }
    }
	
	public void deleteTienTe(String id)  throws SQLException{
		Connection con =ioconnection.getConnection();
		try {
			CallableStatement cst = con.prepareCall("{call XoaTienTe(?)}");
			
			cst.setString(1, id);
			
			cst.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			ioconnection.closeConnection(con);
		}
		
	}
}
