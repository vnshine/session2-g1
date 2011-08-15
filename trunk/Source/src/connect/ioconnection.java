package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class IOConnection {

	public static Connection getConnection()
        {
		Connection con = null;
		try
                {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=NHATQUANG;user=sa;password=123456";
			con = DriverManager.getConnection(connectionUrl);
		}
                catch (ClassNotFoundException cE)
                {
			System.out.println("Class Not Found Exception: "+ cE.toString());
			
		}
                catch (SQLException e) 
                {
			
			System.out.println("SQL Exception: "+ e.toString());
		}
		return con;
	}
	
	public static void closeConnection(Connection connection)
        {
		try
                {
			if(connection!=null)
                        {
				connection.close();
			}
		}
                catch (Exception e) 
                {
			System.out.println("SQL Exception: "+ e.toString());
		}
	}
	
}
