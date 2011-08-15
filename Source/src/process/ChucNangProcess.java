/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package process;

import java.util.Vector;
import connect.IOConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import myobject.ChucNang;

/**
 *
 * @author liemmaster
 */
public class ChucNangProcess 
{
    public Vector<ChucNang> LayDanhSachChucNang() throws SQLException
    {
            Vector<ChucNang> result = new Vector<ChucNang>();
            Connection con = IOConnection.getConnection();
            try
            {
                    CallableStatement cst = con.prepareCall("{call sp_tblChucNang_Select ()}");
                    ResultSet rs =  cst.executeQuery();

                    while(rs.next())
                    {
                            ChucNang chuc_nang = new ChucNang();
                            chuc_nang.setId(rs.getString("PK_sChucNangID"));
                            chuc_nang.setTenChucNang(rs.getString("sTenChucNang"));
                            chuc_nang.setGhiChu(rs.getString("sGhiChu"));
                            
                            result.add(chuc_nang);
                    }

            }
            catch (Exception e)
            {
                    e.printStackTrace();
                    result = null;
            }
            finally
            {
                
                    IOConnection.closeConnection(con);	
                    return result;
            }
    }
    
    
    public Vector<ChucNang> TimChucNang(ChucNang chuc_nang) throws SQLException
    {
            Vector<ChucNang> result = new Vector<ChucNang>();
            Connection con = IOConnection.getConnection();
            try
            {
                    CallableStatement cst = con.prepareCall("{call sp_tblChucNang_Find (?,?,?)}");
                    
                    cst.setString(1, chuc_nang.getId());
                    cst.setString(2, chuc_nang.getTenChucNang());
                    cst.setString(3, chuc_nang.getGhiChu());
                    
                    ResultSet rs =  cst.executeQuery();

                    while(rs.next())
                    {
                            ChucNang temp = new ChucNang();
                            chuc_nang.setId(rs.getString("PK_sChucNangID"));
                            chuc_nang.setTenChucNang(rs.getString("sTenChucNang"));
                            chuc_nang.setGhiChu(rs.getString("sGhiChu"));
                            
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
                
                    IOConnection.closeConnection(con);	
                    return result;
            }
    }

    
    public Boolean TrungChucNang(String id, String ten)
    {
            Connection con = IOConnection.getConnection();
            Boolean result = false;
            try
            {
                    CallableStatement cst = con.prepareCall("{call sp_tblChucNang_duplicate (?,?)}");
                    
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
                
                    IOConnection.closeConnection(con);	
                    return result;
            }
    }
    
    public boolean ThemChucNang(ChucNang chuc_nang) throws SQLException
    {
            Connection cn = IOConnection.getConnection();
            Boolean success = true;
            try 
            {
                    cn.setAutoCommit(false);
                    CallableStatement cst = cn.prepareCall("{call sp_tblChucNang_Insert (?,?,?)}");
                    
                    cst.setString(1, chuc_nang.getId());
                    cst.setString(2, chuc_nang.getTenChucNang());
                    cst.setString(3, chuc_nang.getGhiChu());
                    
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
                    IOConnection.closeConnection(cn);
                    return success;
            }
    }
    
    public boolean XoaChucNang(String id) throws SQLException
    {
            boolean result = true;
            Connection con = (Connection) IOConnection.getConnection();
            try
            {
                    con.setAutoCommit(false);
                    CallableStatement cst = con.prepareCall("{call sp_tblChucNang_Delete (?)}");
                    
                    cst.setString(1, id);
                    
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
                    IOConnection.closeConnection(con);
                    return result;
            }
            
    }
    
    
    public boolean SuaChucNang(ChucNang chuc_nang, String old_id) throws SQLException
    {
            Connection cn = IOConnection.getConnection();
            Boolean success = true;
            try 
            {
                    cn.setAutoCommit(false);
                    CallableStatement cst = cn.prepareCall("{call sp_tblChucNang_Update (?,?,?,?)}");
                    
                    cst.setString(1, old_id);
                    cst.setString(2, chuc_nang.getId());
                    cst.setString(3, chuc_nang.getTenChucNang());
                    cst.setString(4, chuc_nang.getGhiChu());
                    
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
                    IOConnection.closeConnection(cn);
                    return success;
            }
    }

}
