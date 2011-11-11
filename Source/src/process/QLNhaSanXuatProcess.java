
package process;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import myobject.NhaSanXuat;
import connect.ioconnection;


public class QLNhaSanXuatProcess 
{
	/*
	public Integer getSoLuongKQ(String key) throws SQLException
    {
    		Integer result = null;
            Connection con = ioconnection.getConnection();
            try
            {                    
	            	CallableStatement soLuongRecod = con.prepareCall("{call SoLuong_KQ_NhaSanXuat(?)}");
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
    */
	public Vector<NhaSanXuat> getListNhaSanXuat(Integer soTrang) throws SQLException
    {
            Vector<NhaSanXuat> result = new Vector<NhaSanXuat>();
            Connection con = ioconnection.getConnection();
            try
            {
                    CallableStatement cst = con.prepareCall("{call DanhSach_NhaSanXuat(?)}");
					cst.setInt(1, soTrang);
                    ResultSet rs =  cst.executeQuery();

                    while(rs.next())
                    {
                    	NhaSanXuat varNhaSanXuat = new NhaSanXuat();
                    	varNhaSanXuat.setPK_sNhaSanXuatID(rs.getString("PK_iNhaSanXuatID"));
                    	varNhaSanXuat.setsTenNhaSanXuat(rs.getString("sTenNhaSanXuat"));
                    	varNhaSanXuat.setsTenNhaSanXuatEng(rs.getString("sTenNhaSanXuatEng"));
                    	varNhaSanXuat.setsGhiChu(rs.getString("sGhiChu"));              
                        result.add(varNhaSanXuat);
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
    public Integer getsoNhaSanXuat() throws SQLException
    {
    		Integer result = 0;
            Connection con = ioconnection.getConnection();
            try
            {           
                    CallableStatement soLuongRecod = con.prepareCall("{call SoLuong_NhaSanXuat()}");
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
    
    public boolean checkTenNhaSanXuat( String Name) throws SQLException
    {
    		Integer result = 0;
            Connection con = ioconnection.getConnection();
            try
            {
                    CallableStatement cst = con.prepareCall("{call sp_tblNhaSanXuat_duplicate(?)}");
                    cst.setString(1, Name);
                    ResultSet rs =  cst.executeQuery();
                    rs.next();
					result = rs.getInt(1);
					//System.out.println(result);
            }
            catch (Exception e)
            {
                    e.printStackTrace();
                    result = 0;
            }
            finally
            {
                    ioconnection.closeConnection(con);	
                    if (result > 0) {
                    	return false;
					}
                    return true;
            }
    }
    public boolean checkTenNhaSanXuatEdit( String tenTruoc, String tenSau) throws SQLException
    {
    		Integer result = 0;
            Connection con = ioconnection.getConnection();
            try
            {
                    CallableStatement cst = con.prepareCall("{call sp_tblNhaSanXuat_duplicate2(?,?)}");
                    cst.setString(1, tenTruoc);
                    cst.setString(2, tenSau);
                    ResultSet rs =  cst.executeQuery();
                    rs.next();
					result = rs.getInt(1);
					//System.out.println(result);
            }
            catch (Exception e)
            {
                    e.printStackTrace();
                    result = 0;
            }
            finally
            {
                    ioconnection.closeConnection(con);	
                    if (result > 0) {
                    	return false;
					}
                    return true;
            }
    }
    public boolean ThemNhaSanXuat(NhaSanXuat NhaSanXuat) throws SQLException
    {
            Connection cn = ioconnection.getConnection();
            Boolean success = true;
            try 
            {
                    CallableStatement cst = cn.prepareCall("{call sp_tblNhaSanXuat_Insert (?,?,?)}");
                    cst.setString(1, NhaSanXuat.getsTenNhaSanXuat());
                    cst.setString(2, NhaSanXuat.getsTenNhaSanXuatEng());
                    cst.setString(3, NhaSanXuat.getsGhiChu());  
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
    
    public boolean SuaNhaSanXuat(NhaSanXuat NhaSanXuat,Integer id) throws SQLException
    {
            Connection cn = ioconnection.getConnection();
            Boolean success = true;
            try 
            {
                CallableStatement cst = cn.prepareCall("{call sp_tblNhaSanXuat_Update (?,?,?,?)}");
                cst.setInt(1, id);
                cst.setString(2, NhaSanXuat.getsTenNhaSanXuat());
                cst.setString(3, NhaSanXuat.getsTenNhaSanXuatEng());
                cst.setString(4, NhaSanXuat.getsGhiChu());
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
    public boolean XoaNhaSanXuat(Integer maNhaSanXuat) throws SQLException
    {
            Connection con = (Connection) ioconnection.getConnection();
            try
            {
                CallableStatement cst = con.prepareCall("{call sp_tblNhaSanXuat_Delete (?)}");         
                cst.setInt(1,maNhaSanXuat);
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
            //Vector<NhaSanXuat> result = new Vector<NhaSanXuat>();
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
                    	if (rs.getString("sTenNhaSanXuat").startsWith(key)) {result.add(rs.getString("sTenNhaSanXuat"));}
                    	if (((rs.getString("sTenNhaSanXuatEng")).toLowerCase()).startsWith(key)) {result.add(rs.getString("sTenNhaSanXuatEng"));}
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
    	QLNhaSanXuatProcess a = new QLNhaSanXuatProcess();
    	System.out.println(a.checkTenNhaSanXuat("bdff"));
//    	System.out.println(a.getListNhaSanXuat(1));
//    	System.out.println(a.getListSearched(1, "dgdsb"));
//    	System.out.println(a.getSoLuongKQ("hsdhjd"));
//    	System.out.println(a.getsoNhaSanXuat());
//    	System.out.println(a.getSuggestData("shsh"));
    }
}
