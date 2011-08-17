/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package process;

import java.util.Vector;
import connect.ioconnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import myobject.ObjQuyen;

/**
 *
 * @author liemmaster
 */
public class QuyenProcess 
{
    public Vector<ObjQuyen> LayDanhSachQuyen() throws SQLException
    {
            Vector<ObjQuyen> result = new Vector<ObjQuyen>();
            Connection con = ioconnection.getConnection();
            try
            {
                    CallableStatement cst = con.prepareCall("{call sp_tblQuyen_Select ()}");
                    ResultSet rs =  cst.executeQuery();

                    while(rs.next())
                    {
                            ObjQuyen varQuyen = new ObjQuyen();
                            varQuyen.setTen(rs.getNString("sTenQuyen"));
                            varQuyen.setGhiChu(rs.getNString("sGhiChu"));
                            
                            result.add(varQuyen);
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
    
    public boolean ThemQuyen(ObjQuyen _quyen) throws SQLException
    {
            Connection cn = ioconnection.getConnection();
            Boolean success = true;
            try 
            {
                    cn.setAutoCommit(false);
                    CallableStatement cst = cn.prepareCall("{call sp_tblQuyen_Insert (?,?)}");
                    
                    cst.setNString(1, _quyen.getTen());
                    cst.setNString(2, _quyen.getGhiChu());
                    
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
    
    public boolean XoaQuyen(String _tenQuyen) throws SQLException
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
            
    }
    
    
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

}
