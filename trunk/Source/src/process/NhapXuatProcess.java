
package process;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import myobject.NhomHang;
import connect.ioconnection;


public class NhapXuatProcess 
{
	public Vector<NhomHang> getListNhomHang(Integer soTrang) throws SQLException
    {
            Vector<NhomHang> result = new Vector<NhomHang>();
            Connection con = ioconnection.getConnection();
            try
            {
                    CallableStatement cst = con.prepareCall("{call DanhSach_NhomHang(?)}");
					cst.setInt(1, soTrang);
                    ResultSet rs =  cst.executeQuery();

                    while(rs.next())
                    {
                    	NhomHang varNhomHang = new NhomHang();
                    	varNhomHang.setID(rs.getInt("PK_iNhomHangID"));
                    	varNhomHang.setsTenNhomHang(rs.getString("sTenNhomHang"));
                    	varNhomHang.setsTenNhomHangEng(rs.getString("sTenNhomHangEng"));
                    	varNhomHang.setsGhiChu(rs.getString("sGhiChu"));              
                        result.add(varNhomHang);
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
	
	public Integer getsoNhomHang() throws SQLException
    {
    		Integer result = 0;
            Connection con = ioconnection.getConnection();
            try
            {           
                    CallableStatement soLuongRecod = con.prepareCall("{call SoLuong_NhomHang()}");
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
	            	CallableStatement soLuongRecod = con.prepareCall("{call SoLuong_KQ_nhomHang(?)}");
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
	
	public Vector<NhomHang> getListNhomHangcombo() throws SQLException
    {
            Vector<NhomHang> result = new Vector<NhomHang>();
            Connection con = ioconnection.getConnection();
            try
            {
                    CallableStatement cst = con.prepareCall("{call DanhSachall_NhomHang()}");
                    ResultSet rs =  cst.executeQuery();

                    while(rs.next())
                    {
                    	NhomHang varNhomHang = new NhomHang();
                    	varNhomHang.setID(rs.getInt("PK_iNhomHangID"));
                    	varNhomHang.setsTenNhomHang(rs.getString("sTenNhomHang"));
                    	varNhomHang.setsTenNhomHangEng(rs.getString("sTenNhomHangEng"));
                    	varNhomHang.setsGhiChu(rs.getString("sGhiChu"));              
                        result.add(varNhomHang);
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
    
    
    public static void main(String[] args) throws SQLException {
    	NhapXuatProcess a = new NhapXuatProcess();
    	System.out.println(a.checkTenNhomHang("bdff"));
//    	System.out.println(a.getListNhomHang(1));
//    	System.out.println(a.getListSearched(1, "dgdsb"));
//    	System.out.println(a.getSoLuongKQ("hsdhjd"));
//    	System.out.println(a.getsoNhomHang());
//    	System.out.println(a.getSuggestData("shsh"));
    }
}
