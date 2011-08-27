
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
    public Vector<DoiTac> getListDoiTac(Integer soTrang) throws SQLException
    {
            Vector<DoiTac> result = new Vector<DoiTac>();
            Connection con = ioconnection.getConnection();
            try
            {
                    CallableStatement cst = con.prepareCall("{call DanhSach_DoiTac(?)}");
					System.out.println(getsoDoiTac());
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
    
    public boolean ThemQuyen(DoiTac doiTac) throws SQLException
    {
            Connection cn = ioconnection.getConnection();
            Boolean success = true;
            try 
            {
                    cn.setAutoCommit(false);
                    CallableStatement cst = cn.prepareCall("{call sp_tblDoiTac_Insert (?,?,?,?,?,?,?,?)}");
                    
                    cst.setNString(1, doiTac.getPK_sDoiTacID());
                    cst.setNString(1, doiTac.getPK_sDoiTacID());
                    cst.setNString(1, doiTac.getPK_sDoiTacID());
                    cst.setNString(1, doiTac.getPK_sDoiTacID());
                    cst.setNString(1, doiTac.getPK_sDoiTacID());
                    cst.setNString(1, doiTac.getPK_sDoiTacID());
                    cst.setNString(1, doiTac.getPK_sDoiTacID());
                    cst.setNString(1, doiTac.getPK_sDoiTacID());
                    
                    
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
    
    /*public boolean XoaQuyen(String _tenQuyen) throws SQLException
    {
            boolean result = true;
            Connection con = (Connection) ioconnection.getConnection();
            try
            {
                    con.setAutoCommit(false);
                    CallableStatement cst = con.prepareCall("{call sp_tblQuyen_Delete (?)}");
                    
                    cst.setNString(1,_tenQuyen);
                    
                    result = cst.execute();
                    cst.clearBatch();
                    con.commit();
            }
            catch (Exception e)
            {
                    e.printStackTrace();
                    result = false;
            }
            finally
            {
                    ioconnection.closeConnection(con);
                    return result;
            }
            
    }*/
    
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
    	System.out.println(a.getListDoiTac(2).size());
    }
}
