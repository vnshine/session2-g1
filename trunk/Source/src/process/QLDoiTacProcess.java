
package process;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import myobject.DoiTac;
import connect.ioconnection;


public class QLDoiTacProcess 
{
	public Vector<DoiTac> getListSearched(Integer soTrang,String key) throws SQLException
    {
            Vector<DoiTac> result = new Vector<DoiTac>();
            Connection con = ioconnection.getConnection();
            try
            {
                    CallableStatement cst = con.prepareCall("{call SEARCH_DOITAC(?,?)}");
//					System.out.println(getsoDoiTac());

					cst.setInt(1, soTrang);
					cst.setString(2, key);
                    ResultSet rs =  cst.executeQuery();

                    while(rs.next())
                    {
                    	DoiTac varDoiTac = new DoiTac();
                    	varDoiTac.setPK_sDoiTacID(rs.getString("PK_sDoiTacID"));
                    	varDoiTac.setsTenDoiTac(rs.getString("sTenDoiTac"));
                    	varDoiTac.setsSoDienThoai(rs.getString("sSoDienThoai"));
                    	varDoiTac.setsNguoiLienHe(rs.getString("sNguoiLienHe"));
                    	varDoiTac.setsGhiChu(rs.getString("sGhiChu"));
                    	varDoiTac.setsDiaChi(rs.getString("sDiaChi"));
                    	varDoiTac.setiTrangThai(rs.getInt("iTrangThai"));
                    	varDoiTac.setsTenDoiTacEng(rs.getString("sTenDoiTacEng"));
                        
                        result.add(varDoiTac);
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
	public Integer getSoLuongKQ(String key) throws SQLException
    {
    		Integer result = null;
            Connection con = ioconnection.getConnection();
            try
            {
                    
	            	CallableStatement soLuongRecod = con.prepareCall("{call SoLuong_KQ(?)}");
	            	soLuongRecod.setString(1, key);

                    ResultSet rs1 =  soLuongRecod.executeQuery();
					rs1.next();
					System.out.println(rs1.getInt(1));
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
	public Vector<DoiTac> getListDoiTac(Integer soTrang) throws SQLException
    {
            Vector<DoiTac> result = new Vector<DoiTac>();
            Connection con = ioconnection.getConnection();
            try
            {
                    CallableStatement cst = con.prepareCall("{call DanhSach_DoiTac(?)}");
//					System.out.println(getsoDoiTac());
                    /*
					if (getsoDoiTac() < soTrang*25||soTrang*25<=0) {
                    	cst.setInt(1, 0);
					}else cst.setInt(1, soTrang);
                    */
					cst.setInt(1, soTrang);
                    ResultSet rs =  cst.executeQuery();

                    while(rs.next())
                    {
                    	DoiTac varDoiTac = new DoiTac();
                    	varDoiTac.setPK_sDoiTacID(rs.getString("PK_sDoiTacID"));
                    	varDoiTac.setsTenDoiTac(rs.getString("sTenDoiTac"));
                    	varDoiTac.setsSoDienThoai(rs.getString("sSoDienThoai"));
                    	varDoiTac.setsNguoiLienHe(rs.getString("sNguoiLienHe"));
                    	varDoiTac.setsGhiChu(rs.getString("sGhiChu"));
                    	varDoiTac.setsDiaChi(rs.getString("sDiaChi"));
                    	varDoiTac.setiTrangThai(rs.getInt("iTrangThai"));
                    	varDoiTac.setsTenDoiTacEng(rs.getString("sTenDoiTacEng"));
                        
                        result.add(varDoiTac);
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
    public Integer getsoDoiTac() throws SQLException
    {
    		Integer result = null;
            Connection con = ioconnection.getConnection();
            try
            {
                    
                    CallableStatement soLuongRecod = con.prepareCall("{call SoLuong_DoiTac()}");
                    ResultSet rs1 =  soLuongRecod.executeQuery();
					rs1.next();
//					System.out.println(rs1.getInt(1));
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
    
    public boolean checkPK( String PK) throws SQLException
    {
    		Integer result = 0;
            Connection con = ioconnection.getConnection();
            try
            {
                    CallableStatement cst = con.prepareCall("{call sp_tblDoiTac_duplicate(?)}");
                    cst.setString(1, PK);
                    ResultSet rs =  cst.executeQuery();
                    rs.next();
//					System.out.println(rs.getInt(1));
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
    
    public boolean ThemDoiTac(DoiTac doiTac) throws SQLException
    {
            Connection cn = ioconnection.getConnection();
            Boolean success = true;
            try 
            {
                   // cn.setAutoCommit(false);
                    CallableStatement cst = cn.prepareCall("{call sp_tblDoiTac_Insert (?,?,?,?,?,?,?,?)}");
                    
                    cst.setString(1, doiTac.getPK_sDoiTacID());
                    cst.setString(2, doiTac.getsTenDoiTac());
                    cst.setString(3, doiTac.getsTenDoiTacEng());
                    cst.setString(4, doiTac.getsSoDienThoai());
                    cst.setString(5, doiTac.getsDiaChi());
                    cst.setInt(6, doiTac.getiTrangThai());
                    cst.setString(7, doiTac.getsNguoiLienHe());
                    cst.setString(8, doiTac.getsGhiChu());
                    
                    
                    cst.execute();
                    //cst.clearBatch();
                    //cn.commit();
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
    
    public boolean SuaDoiTac(DoiTac doiTac,String PK) throws SQLException
    {
            Connection cn = ioconnection.getConnection();
            Boolean success = true;
            try 
            {
                   // cn.setAutoCommit(false);
                    CallableStatement cst = cn.prepareCall("{call sp_tblDoiTac_Update (?,?,?,?,?,?,?,?,?)}");
                    cst.setString(1, PK);
                    cst.setString(2, doiTac.getPK_sDoiTacID());
                    cst.setString(3, doiTac.getsTenDoiTac());
                    cst.setString(4, doiTac.getsTenDoiTacEng());
                    cst.setString(5, doiTac.getsSoDienThoai());
                    cst.setString(6, doiTac.getsDiaChi());
                    cst.setInt(7, doiTac.getiTrangThai());
                    cst.setString(8, doiTac.getsNguoiLienHe());
                    cst.setString(9, doiTac.getsGhiChu());
                    
                    
                    cst.execute();
                    //cst.clearBatch();
                    //cn.commit();
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
    public boolean XoaDoiTac(String maDoiTac) throws SQLException
    {
            Connection con = (Connection) ioconnection.getConnection();
            try
            {
                    //con.setAutoCommit(false);
                    CallableStatement cst = con.prepareCall("{call sp_tblDoiTac_Delete (?)}");         
                    cst.setNString(1,maDoiTac);
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
            //Vector<DoiTac> result = new Vector<DoiTac>();
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
                    	if (rs.getString("sTenDoiTac").startsWith(key)) {
                    	result.add(rs.getString("sTenDoiTac"));
                    	}
                    	if (((rs.getString("sNguoiLienHe")).toLowerCase()).startsWith(key)) {result.add(rs.getString("sNguoiLienHe"));}
                    	if (((rs.getString("sTenDoiTacEng")).toLowerCase()).startsWith(key)) {result.add(rs.getString("sTenDoiTacEng"));}
                    	if (((rs.getString("PK_sDoiTacID")).toLowerCase()).startsWith(key)) {result.add(rs.getString("PK_sDoiTacID"));}
                    	if (((rs.getString("sSoDienThoai")).toLowerCase()).startsWith(key)) {result.add(rs.getString("sSoDienThoai"));}
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
    /*
    public Vector<ObjQuyen> TimQuyen(ObjQuyen varQuyen) throws SQLException
    {
            Vector<ObjQuyen> result = new Vector<ObjQuyen>();
            Connection con = ioconnection.getConnection();
            try
            {
                    CallableStatement cst = con.prepareCall("{call sp_tblQuyen_Find (?,?)}");
                    
                    cst.setNString(1, varQuyen.getTen());
                    cst.setNString(2, varQuyen.getGhiChu());
                    
                    ResultSet rs =  cst.executeQuery();

                    while(rs.next())
                    {
                            ObjQuyen temp = new ObjQuyen();
                            varQuyen.setTen(rs.getNString("sTenQuyen"));
                            varQuyen.setGhiChu(rs.getNString("sGhiChu"));
                            
                            result.add(temp);
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

    
    public Boolean TrungQuyen(String ten)
    {
            Connection con = ioconnection.getConnection();
            Boolean result = false;
            try
            {
                    CallableStatement cst = con.prepareCall("{call sp_tblQuyen_duplicate (?)}");
                    
                    cst.setNString(1, ten);
                    
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
    
    */
    
    /**/
    
/*    
    public boolean SuaQuyen(ObjQuyen varQuyen, String old_name) throws SQLException
    {
            Connection cn = ioconnection.getConnection();
            Boolean success = true;
            try 
            {
                    cn.setAutoCommit(false);
                    CallableStatement cst = cn.prepareCall("{call sp_tblQuyen_Update (?,?,?)}");
                    
                    cst.setNString(1, old_name);
                    cst.setNString(2, varQuyen.getTen());
                    cst.setNString(3, varQuyen.getGhiChu());
                    
                    success = cst.execute();
                    cst.clearBatch();
                    cn.commit();
            } 
            catch (SQLException e)
            {
                    e.printStackTrace();
                    cn.rollback();
                    success = false;
            }
            finally
            {
                    ioconnection.closeConnection(cn);
                    return success;
            }
    }
*/
    public static void main(String[] args) throws SQLException {
    	QLDoiTacProcess a = new QLDoiTacProcess();
    	//System.out.println(a.checkPK("appp"));
    	//System.out.println(a.getListSearched(1, "lo427272727272").get(0).getsTenDoiTac());
    	System.out.println(a.getSoLuongKQ("l7272727272o"));
    }
}
