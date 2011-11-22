
package process;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import myobject.HangHoa;
import connect.ioconnection;


public class NhapXuatProcess 
{
	public Vector<HangHoa> getListHangHoa(Integer soTrang) throws SQLException
    {
            Vector<HangHoa> result = new Vector<HangHoa>();
            Connection con = ioconnection.getConnection();
            try
            {
                    CallableStatement cst = con.prepareCall("{call ds_HangHoa(?)}");
					cst.setInt(1, soTrang);
                    ResultSet rs =  cst.executeQuery();

                    while(rs.next())
                    {
                    	HangHoa varHangHoa = new HangHoa();
                    	varHangHoa.setPK_iHangHoaID    (rs.getInt("PK_iHangHoaID"))  ;  
                    	varHangHoa.setsTenHangHoa       (rs.getString("sTenHangHoa")) ;   
                    	varHangHoa.setsTenHangHoaEng    (rs.getString("sTenHangHoaEng")) ;   
                    	varHangHoa.setiDonGia          (rs.getFloat("iDonGia"))  ;  
                    	varHangHoa.setsNgayNhap         (rs.getString("sNgayNhap")) ;   
                    	varHangHoa.setsGhiChu           (rs.getString("sGhiChu")) ;   
                    	varHangHoa.setFK_sDoiTacID      (rs.getString("FK_sDoiTacID")) ;   
                    	varHangHoa.setFK_sNhaSanXuatID  (rs.getString("FK_sNhaSanXuatID")) ;   
                    	varHangHoa.setFK_iDonViTinhID  (rs.getInt("FK_iDonViTinhID"))  ;  
                    	varHangHoa.setFK_iNhomHangID    (rs.getString("FK_iNhomHangID")) ;   
                    	varHangHoa.setsTenDoiTac        (rs.getString("sTenDoiTac")) ;   
                    	varHangHoa.setsTenNhaSanXuat    (rs.getString("sTenNhaSanXuat")) ;   
                    	varHangHoa.setsTenDonViTinh     (rs.getString("sTenDonViTinh")) ;   
                    	varHangHoa.setsTenNhomHang      (rs.getString("sTenNhomHang")) ; 	
                    	varHangHoa.setiSoLuong          (rs.getInt("iSoLuong"))  ;  
                        result.add(varHangHoa);
                    }
            }
            catch (Exception e)
            {
                    e.printStackTrace();
                    result = null;
            }
            finally
            {
                    ioconnection.closeConnection(con);	
                    return result;
            }
    }
	
	public Integer getsoHangHoa() throws SQLException
    {
    		Integer result = 0;
            Connection con = ioconnection.getConnection();
            try
            {           
                    CallableStatement soLuongRecod = con.prepareCall("{call SoLuong_hh()}");
                    ResultSet rs1 =  soLuongRecod.executeQuery();
					rs1.next();
					result = rs1.getInt(1);
            }
            catch (Exception e)
            {
                    e.printStackTrace();
                    result = 0;
            }
            finally
            {
                    ioconnection.closeConnection(con);	
                    return result;
            }
    }
	
	public Integer getSoLuongKQ(String key) throws SQLException
    {
    		Integer result = null;
            Connection con = ioconnection.getConnection();
            try
            {                    
	            	CallableStatement soLuongRecod = con.prepareCall("{call SoLuong_KQ_HangHoa(?)}");
	            	soLuongRecod.setString(1, key);
                    ResultSet rs1 =  soLuongRecod.executeQuery();
					rs1.next();
					//System.out.println(rs1.getInt(1));
					result = rs1.getInt(1);
            }
            catch (Exception e)
            {
                    e.printStackTrace();
                    result = null;
            }
            finally
            {
                    ioconnection.closeConnection(con);	
                    return result;
            }
    }
	
	
    
    
    public static void main(String[] args) throws SQLException {
    	NhapXuatProcess a = new NhapXuatProcess();
//    	System.out.println(a.checkTenHangHoa("bdff"));
    	System.out.println(a.getListHangHoa(1).get(0).getsTenHangHoa());
//    	System.out.println(a.getListSearched(1, "dgdsb"));
//    	System.out.println(a.getSoLuongKQ("hsdhjd"));
    	System.out.println(a.getsoHangHoa());
//    	System.out.println(a.getSuggestData("shsh"));
    }
}
