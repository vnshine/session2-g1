package process;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
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
    public void Ghi(String name, String pass)
    {
    	try{
    	File file = new File("D:\\Document\\BAI TAP\\Java\\data.dat");
        FileOutputStream foStream = new FileOutputStream(file);
        
        PrintWriter pw= new PrintWriter(foStream);
        pw.println(name); 
        pw.println(pass); 
        pw.close();
        
        
        
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    public void Del()
    {
    	try{
    	File file = new File("D:\\Document\\BAI TAP\\Java\\data.dat");
    	FileOutputStream foStream = new FileOutputStream(file);
        
        PrintWriter pw= new PrintWriter(foStream);
        pw.println(""); 
        pw.close();
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    public String[] Load()
    {
    	String[] mang = new String[2];
    	try{
    	FileReader fr= new FileReader("D:\\Document\\BAI TAP\\Java\\data.dat"); 
        BufferedReader input= new BufferedReader(fr); 
        mang[0] = input.readLine();
        mang[1] = input.readLine();
        input.close();
    	}catch (Exception e) {
			// TODO: handle exception
		}
    	return mang;
    }
}
