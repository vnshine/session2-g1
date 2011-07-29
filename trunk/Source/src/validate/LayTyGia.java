	/* 
	 * Class Vector<tyGia> layTyGia()
	 * Tạo một class để lấy tỷ giá ngoại tệ từ ngân
	   hàng ViệtCombank (Vector tyGia: String kyHieu, Float giaTri), 
	   tự động cập nhật sau 5 phút.
	 */
package validate;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;
import javax.swing.Timer;
import myobject.TyGia;
public class LayTyGia {
	public Vector<TyGia> layTyGia(){
		Vector<TyGia> tyGiaNgoaiTe = new Vector<TyGia>();
		try {
			URL tyGia = new URL("http://www.vietcombank.com.vn/");
	        URLConnection yc = tyGia.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
	        String inputLine;
	        String str1,aud1,aud2,aud3;
	        while ((inputLine = in.readLine()) != null){
	        	if(inputLine.contains("AUD</td><td>"))	        	{
	        		TyGia tyGiaNT = new TyGia();
	        		tyGiaNT.setLoaiNgoaiTe("AUD");
	        		str1 = inputLine.substring(inputLine.indexOf("AUD</td><td>")+12);
	        		aud1 = str1.substring(0, str1.indexOf("</td><td>"));
	        		if (aud1.contains(",")) aud1 = aud1.substring(0, aud1.indexOf(",")) + aud1.substring(aud1.indexOf(",")+1);
	        		tyGiaNT.setMuaTienMat(Float.valueOf(aud1));
	        		str1 = str1.substring(str1.indexOf("</td><td>")+10);
	        		aud2 = str1.substring(0, str1.indexOf("</td><td>"));
	        		if (aud2.contains(",")) aud2 = aud2.substring(0, aud2.indexOf(",")) + aud2.substring(aud2.indexOf(",")+1);
	        		tyGiaNT.setMuaChuyenKhoan(Float.valueOf(aud2));
	        		str1 = str1.substring(str1.indexOf("</td><td>")+10);
	        		aud3 = str1.substring(0, str1.indexOf("</td>"));
	        		if (aud3.contains(","))	aud3 = aud3.substring(0, aud3.indexOf(",")) + aud3.substring(aud3.indexOf(",")+1);
	        		tyGiaNT.setBanRa(Float.valueOf(aud3));
	        		tyGiaNgoaiTe.add(tyGiaNT);
	        	}
	        	if(inputLine.contains("EUR</td><td>"))	        	{
	        		TyGia tyGiaNT = new TyGia();
	        		tyGiaNT.setLoaiNgoaiTe("EUR");
	        		str1 = inputLine.substring(inputLine.indexOf("EUR</td><td>")+12);
	        		aud1 = str1.substring(0, str1.indexOf("</td><td>"));
	        		if (aud1.contains(",")) aud1 = aud1.substring(0, aud1.indexOf(",")) + aud1.substring(aud1.indexOf(",")+1);
	        		tyGiaNT.setMuaTienMat(Float.valueOf(aud1));
	        		str1 = str1.substring(str1.indexOf("</td><td>")+10);
	        		aud2 = str1.substring(0, str1.indexOf("</td><td>"));
	        		if (aud2.contains(",")) aud2 = aud2.substring(0, aud2.indexOf(",")) + aud2.substring(aud2.indexOf(",")+1);
	        		tyGiaNT.setMuaChuyenKhoan(Float.valueOf(aud2));
	        		str1 = str1.substring(str1.indexOf("</td><td>")+10);
	        		aud3 = str1.substring(0, str1.indexOf("</td>"));
	        		if (aud3.contains(","))	aud3 = aud3.substring(0, aud3.indexOf(",")) + aud3.substring(aud3.indexOf(",")+1);
	        		tyGiaNT.setBanRa(Float.valueOf(aud3));
	        		tyGiaNgoaiTe.add(tyGiaNT);
	        	}
	        	if(inputLine.contains("GBP</td><td>"))	        	{
	        		TyGia tyGiaNT = new TyGia();
	        		tyGiaNT.setLoaiNgoaiTe("GBP");
	        		str1 = inputLine.substring(inputLine.indexOf("GBP</td><td>")+12);
	        		aud1 = str1.substring(0, str1.indexOf("</td><td>"));
	        		if (aud1.contains(",")) aud1 = aud1.substring(0, aud1.indexOf(",")) + aud1.substring(aud1.indexOf(",")+1);
	        		tyGiaNT.setMuaTienMat(Float.valueOf(aud1));
	        		str1 = str1.substring(str1.indexOf("</td><td>")+10);
	        		aud2 = str1.substring(0, str1.indexOf("</td><td>"));
	        		if (aud2.contains(",")) aud2 = aud2.substring(0, aud2.indexOf(",")) + aud2.substring(aud2.indexOf(",")+1);
	        		tyGiaNT.setMuaChuyenKhoan(Float.valueOf(aud2));
	        		str1 = str1.substring(str1.indexOf("</td><td>")+10);
	        		aud3 = str1.substring(0, str1.indexOf("</td>"));
	        		if (aud3.contains(","))	aud3 = aud3.substring(0, aud3.indexOf(",")) + aud3.substring(aud3.indexOf(",")+1);
	        		tyGiaNT.setBanRa(Float.valueOf(aud3));
	        		tyGiaNgoaiTe.add(tyGiaNT);
	        	}
	        	if(inputLine.contains("JPY</td><td>"))   	{
	        		TyGia tyGiaNT = new TyGia();
	        		tyGiaNT.setLoaiNgoaiTe("JPY");
	        		str1 = inputLine.substring(inputLine.indexOf("JPY</td><td>")+12);
	        		aud1 = str1.substring(0, str1.indexOf("</td><td>"));
	        		if (aud1.contains(",")) aud1 = aud1.substring(0, aud1.indexOf(",")) + aud1.substring(aud1.indexOf(",")+1);
	        		tyGiaNT.setMuaTienMat(Float.valueOf(aud1));
	        		str1 = str1.substring(str1.indexOf("</td><td>")+10);
	        		aud2 = str1.substring(0, str1.indexOf("</td><td>"));
	        		if (aud2.contains(",")) aud2 = aud2.substring(0, aud2.indexOf(",")) + aud2.substring(aud2.indexOf(",")+1);
	        		tyGiaNT.setMuaChuyenKhoan(Float.valueOf(aud2));
	        		str1 = str1.substring(str1.indexOf("</td><td>")+10);
	        		aud3 = str1.substring(0, str1.indexOf("</td>"));
	        		if (aud3.contains(","))	aud3 = aud3.substring(0, aud3.indexOf(",")) + aud3.substring(aud3.indexOf(",")+1);
	        		tyGiaNT.setBanRa(Float.valueOf(aud3));
	        		tyGiaNgoaiTe.add(tyGiaNT);
	        	}
	        	if(inputLine.contains("USD</td><td>"))	        	{
	        		TyGia tyGiaNT = new TyGia();
	        		tyGiaNT.setLoaiNgoaiTe("USD");
	        		str1 = inputLine.substring(inputLine.indexOf("USD</td><td>")+12);
	        		aud1 = str1.substring(0, str1.indexOf("</td><td>"));
	        		if (aud1.contains(",")) aud1 = aud1.substring(0, aud1.indexOf(",")) + aud1.substring(aud1.indexOf(",")+1);
	        		tyGiaNT.setMuaTienMat(Float.valueOf(aud1));
	        		str1 = str1.substring(str1.indexOf("</td><td>")+10);
	        		aud2 = str1.substring(0, str1.indexOf("</td><td>"));
	        		if (aud2.contains(",")) aud2 = aud2.substring(0, aud2.indexOf(",")) + aud2.substring(aud2.indexOf(",")+1);
	        		tyGiaNT.setMuaChuyenKhoan(Float.valueOf(aud2));
	        		str1 = str1.substring(str1.indexOf("</td><td>")+10);
	        		aud3 = str1.substring(0, str1.indexOf("</td>"));
	        		if (aud3.contains(","))	aud3 = aud3.substring(0, aud3.indexOf(",")) + aud3.substring(aud3.indexOf(",")+1);
	        		tyGiaNT.setBanRa(Float.valueOf(aud3));
	        		tyGiaNgoaiTe.add(tyGiaNT);
	        		break;
	        	}
	        }	        
	            in.close();
	        //    return tyGiaNgoaiTe;
		} catch (Exception e) {
			
	        	for (int i = 0; i < 5; i++) {
	        		TyGia tyGiaNT = new TyGia();
	        		tyGiaNT.setLoaiNgoaiTe("Error");
	        		tyGiaNgoaiTe.add(tyGiaNT);
				}
        		return tyGiaNgoaiTe;			
		}
		return tyGiaNgoaiTe;
	}
//	public static void main(String[] args) {
//		LayTyGia a = new LayTyGia();
//		Vector<TyGia> b = new Vector<TyGia>();
//		b = a.layTyGia();
//		System.out.println(b.get(4).getLoaiNgoaiTe());
//	}
}
