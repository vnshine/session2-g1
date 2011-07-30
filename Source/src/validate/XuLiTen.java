/*
 Cắt khoảng trắng, chuyển ký tự đầu tiên mỗi
 chữ thành chữ hoa
 */
package validate;
import java.util.Vector;
import java.util.regex.*;
public class XuLiTen {
	public String xuLiTen(String name){
		name = name.trim();//xoa khoang trang dau duoi
		while (name.contains("  ")) {//chuyen khoang trang dai thanh dau cach
			name = name.substring(0,name.indexOf("  ")+1) + name.substring(name.indexOf("  ")+2);
		}
		name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();//chuyen chu cai dau thanh Hoa va cac chu con lai thanh thuong
		while (name.contains(" ")) {//xoa het cac dau cach va chuyen ky tu sau dau cach thanh chu Hoa
			name = name.substring(0,name.indexOf(" ")) 
			+ name.substring(name.indexOf(" ")+1,name.indexOf(" ")+2).toUpperCase()
			+ name.substring(name.indexOf(" ")+2);
		}
		String str;
		for (int i = 1; i < (name.length()); i++) {//Them dau cach vao truoc cac chu in Hoa ke tu chu cai thu 2
			str = name.substring(i,i+1);
			if (str.matches("[A-Z]")) {
				name = name.substring(0,i) + " " + name.substring(i);
				i=i+1;
			}
		}
		return name;
	}
	public static void main(String[] args) {
		XuLiTen a = new XuLiTen();
		System.out.println(a.xuLiTen("   NguyEn   Van   ABC   "));
	}
}
