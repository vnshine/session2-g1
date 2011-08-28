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
import myobject.ChucNang;
import myobject.NhanVienRutGon;

/**
 *
 * @author liemmaster
 */
public class PhanQuyenProcess 
{
    public Vector<NhanVienRutGon> TimNhanVienGutGon(NhanVienRutGon temp, Integer soTrang) throws SQLException
    {
            Vector<NhanVienRutGon> result = new Vector<NhanVienRutGon>();
            Connection con = ioconnection.getConnection();
            try
            {
                    CallableStatement cst = con.prepareCall("{call sp_tblNhanVien_FindRutGon (?,?,?,?,?)}");
                    
                    cst.setInt(1, soTrang);
                    cst.setString(2, temp.getsNhanVienID());
                    cst.setString(3, temp.getsHoTen());
                    cst.setString(4, temp.getsSoDienThoai());
                    cst.setBoolean(5, temp.getbGioiTinh());
                    
                    ResultSet rs =  cst.executeQuery();

                    while(rs.next())
                    {
                            NhanVienRutGon newTemp = new NhanVienRutGon();
                            newTemp.setsNhanVienID(rs.getString("PK_sNhanVienID"));
                            newTemp.setsHoTen(rs.getString("sHoTen"));
                            newTemp.setsSoDienThoai(rs.getString("sSoDienThoai"));
                            newTemp.setbGioiTinh(rs.getBoolean("bGioiTinh"));
                            
                            result.add(newTemp);
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
}
