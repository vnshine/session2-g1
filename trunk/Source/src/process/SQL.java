package process;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.ResultSetMetaData;
	import java.sql.Statement;
	import java.util.Vector;
	import javax.swing.text.DefaultEditorKit.InsertBreakAction;
	
public class SQL {
	
	/**
	 * @param args
	 */
	
	public  Vector<Object> getListNhanVien(String sql){
		Vector<Object> result = new Vector<Object>();
		Connection con =UtilDelegate.getConnection();
		try{
			Statement stmt = con.createStatement();
			ResultSet cursor = stmt.executeQuery(sql);
			ResultSetMetaData rsm = cursor.getMetaData();
			while (cursor.next()) {
				Vector<String> phantu = new Vector<String>();
				for (int i = 1; i <= rsm.getColumnCount(); i++) {
					phantu.add(cursor.getString(i));
				}
				result.add(phantu);
			}			
		}catch (Exception e) {
		}finally{
			UtilDelegate.closeConnection(con);
		}
		return result;
	}	
	public Vector<String> columnName(String sql) {
			Connection con =UtilDelegate.getConnection();
			Vector<String> columnN = new Vector<String>();
		try{
			Statement stmt = con.createStatement();
			ResultSet cursor = stmt.executeQuery(sql);
			ResultSetMetaData rsm = cursor.getMetaData();
		    Vector<String> columnName = new Vector<String>();
			for (int i = 1; i <= rsm.getColumnCount(); i++) {
				columnN.add(rsm.getColumnName(i));
			}
		}catch (Exception e) {
		}finally{
			UtilDelegate.closeConnection(con);
		}
		return columnN;
	}
	public void runNhanVien(String sql) {
		Connection con =UtilDelegate.getConnection();
		PreparedStatement callP;
			try{
				callP = con.prepareStatement(sql);
			    callP.execute(); 
			}catch (Exception e) {			
			}finally{
				UtilDelegate.closeConnection(con);
			}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SQL nv = new SQL();
		//nv.getListNhanVien("SELECT * FROM dbo.tbl_NhanVien where PK_NhanVien = 'a0039'");
	}

}
