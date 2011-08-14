/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import connect.ioconnection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import module.MD5;

/**
 *
 * @author liemmaster
 */
public class LoginCode 
{
    public boolean ValidLogin(String userName, String passWord)
    {
        Boolean result = false;
        MD5 md5 = new MD5();
        String md5Pass = MD5.MD5Password(passWord);
        System.out.println(md5Pass);
        
        Connection con = ioconnection.getConnection();
        try
        {
            PreparedStatement pr = con.prepareCall("{call sp_tblNhanVien_Login (?,?)}");
            pr.setString(1, userName);
            pr.setString(2, md5Pass);
            
            ResultSet rs = pr.executeQuery();
            
            if(rs.next())
            {
                result = true;
            }
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi kết nối cơ sở dữ liệu",JOptionPane.ERROR_MESSAGE);
        }
        finally
        {
            ioconnection.closeConnection(con);
            return result;
        }
    }
    public LoginCode()
    {
        super();
    }
}
