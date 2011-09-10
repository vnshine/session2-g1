package process;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import module.MD5;
import connect.ioconnection;

public class LoginProcess {
	public boolean Login(String userName, String passWord)
    {
        Boolean result = false;
        MD5 md5 = new MD5();
        String md5Pass = MD5.MD5Password(passWord);
//        System.out.println(md5Pass);
        
        Connection con = ioconnection.getConnection();
        try
        {
        	CallableStatement cst = con.prepareCall("{call sp_tblNhanVien_Login (?,?)}");
            cst.setString(1, userName);
            cst.setString(2, md5Pass);
            
            ResultSet rs = cst.executeQuery();
            
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
    public LoginProcess()
    {
        super();
    }
}
