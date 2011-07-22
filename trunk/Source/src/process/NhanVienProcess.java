package process;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.util.Vector;
	import javax.swing.text.DefaultEditorKit.InsertBreakAction;
public class NhanVienProcess {

	/**
	 * @param args
	 */
	public  Vector<NhanVien> getListNhanVien(){
		Vector<NhanVien> result = new Vector<NhanVien>();
		Connection con =UtilDelegate.getConnection();
		try{
			Statement stmt = con.createStatement();
			ResultSet cursor = stmt.executeQuery("SELECT * FROM dbo.tbl_NhanVien ");
			while (cursor.next()) { 
				String pk = cursor.getString("PK_NhanVien");
				String name = cursor.getString("sHoTen");
				Integer sex = cursor.getInt("iGioiTinh");
				String date = cursor.getString("dNgaySinh");
				String phone = cursor.getString("sSoDienThoai");
				Integer status = cursor.getInt("iTrangThai");
				
				NhanVien person = new NhanVien();
				
				person.setpK(pk);
				person.setName(name);
				person.setSex(sex);
				person.setDate(date);
				person.setPhone(phone);
				person.setTrangthai(status);
				System.out.println(name);
				result.add(person);
			}
			
			System.out.println();
			
		}catch (Exception e) {
			
		}finally{
			UtilDelegate.closeConnection(con);
		}
		return result;
	}	
	public void insertNhanVien(String pk,String name,Integer sex,String date,String phone,Integer status) {
		Connection con =UtilDelegate.getConnection();
		PreparedStatement callP;
			try{
				callP = con.prepareStatement("{call insertNhanVien(?,?,?,?,?,?)}");
				callP.setString(1,pk);
				callP.setString(2,name);
				callP.setInt(3,sex);
				callP.setString(4,date);
				callP.setString(5,phone);
				callP.setInt(6,status);
			    callP.execute(); 
			
			}catch (Exception e) {
				
			}finally{
				UtilDelegate.closeConnection(con);
			}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NhanVienProcess nv = new NhanVienProcess();
		nv.getListNhanVien();
	}

}
