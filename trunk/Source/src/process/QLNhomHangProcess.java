
package process;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import myobject.NhomHang;
import connect.ioconnection;


public class QLNhomHangProcess 
{
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
    
    public boolean checkTenNhomHang( String Name) throws SQLException
    {
    		Integer result = 0;
            Connection con = ioconnection.getConnection();
            try
            {
                    CallableStatement cst = con.prepareCall("{call sp_tblNhomHang_duplicate(?)}");
                    cst.setString(1, Name);
                    ResultSet rs =  cst.executeQuery();
                    rs.next();
					result = rs.getInt(1);
            }
            catch (Exception e)
            {
                    e.printStackTrace();
                    result = 0;
            }
            finally
            {
                    ioconnection.closeConnection(con);	
                    if (result == 1) {
                    	return false;
					}
                    return true;
            }
    }
    
    public boolean ThemNhomHang(NhomHang NhomHang) throws SQLException
    {
            Connection cn = ioconnection.getConnection();
            Boolean success = true;
            try 
            {
                    CallableStatement cst = cn.prepareCall("{call sp_tblNhomHang_Insert (?,?,?)}");
                    cst.setString(1, NhomHang.getsTenNhomHang());
                    cst.setString(2, NhomHang.getsTenNhomHangEng());
                    cst.setString(3, NhomHang.getsGhiChu());  
                    cst.execute();
            } 
            catch (SQLException e)
            {
                    e.printStackTrace();
                    //cn.rollback();
                    success = false;
            }
            finally
            {
                    ioconnection.closeConnection(cn);
                    return success;
            }
    }
    
    public boolean SuaNhomHang(NhomHang NhomHang,String ID) throws SQLException
    {
            Connection cn = ioconnection.getConnection();
            Boolean success = true;
            try 
            {
                CallableStatement cst = cn.prepareCall("{call sp_tblNhomHang_Update (?,?,?,?)}");
                cst.setString(1, ID);
                cst.setString(2, NhomHang.getsTenNhomHang());
                cst.setString(3, NhomHang.getsTenNhomHangEng());
                cst.setString(4, NhomHang.getsGhiChu());
                cst.execute();
            } 
            catch (SQLException e)
            {
                e.printStackTrace();
                success = false;
            }
            finally
            {
                    ioconnection.closeConnection(cn);
                    return success;
            }
    }
    public boolean XoaNhomHang(Integer maNhomHang) throws SQLException
    {
            Connection con = (Connection) ioconnection.getConnection();
            try
            {
                CallableStatement cst = con.prepareCall("{call sp_tblNhomHang_Delete (?)}");         
                cst.setInt(1,maNhomHang);
                cst.execute();
            }
            catch (Exception e)
            {
                    e.printStackTrace();
                    return false;
            }
            finally
            {
                ioconnection.closeConnection(con);
                return true;
            }    
    }
    public Vector<String> getSuggestData(String key) throws SQLException
    {
            //Vector<NhomHang> result = new Vector<NhomHang>();
            Vector<String> result = new Vector<String>();
            Connection con = ioconnection.getConnection();
            try
            {
            		key = key.toLowerCase();
                    CallableStatement cst = con.prepareCall("{call SuggestData(?)}");
					cst.setString(1, key);
                    ResultSet rs =  cst.executeQuery();
                    while(rs.next())
                    {
                    	if (rs.getString("sTenNhomHang").startsWith(key)) {result.add(rs.getString("sTenNhomHang"));}
                    	if (((rs.getString("sTenNhomHangEng")).toLowerCase()).startsWith(key)) {result.add(rs.getString("sTenNhomHangEng"));}
                    	if (((rs.getString("sGhiChu")).toLowerCase()).startsWith(key)) {result.add(rs.getString("sGhiChu"));}
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
    	QLNhomHangProcess a = new QLNhomHangProcess();
    	System.out.println(a.getListNhomHang(1));
    	System.out.println(a.getListSearched(1, "dgdsb"));
    	System.out.println(a.getSoLuongKQ("hsdhjd"));
    	System.out.println(a.getsoNhomHang());
    	System.out.println(a.getSuggestData("shsh"));
    }
}
