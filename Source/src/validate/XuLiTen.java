/*
 Cáº¯t khoáº£ng tráº¯ng, chuyá»ƒn kÃ½ tá»± Ä‘áº§u tiÃªn má»—i
 chá»¯ thÃ nh chá»¯ hoa
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
		String str; 
		
		
		while (name.contains(" ")) {//xoa het cac dau cach va chuyen ky tu sau dau cach thanh chu Hoa
			name = name.substring(0,name.indexOf(" ")) 
			+ name.substring(name.indexOf(" ")+1,name.indexOf(" ")+2).toUpperCase()
			+ name.substring(name.indexOf(" ")+2);
		}
		char arrChar[] = name.toCharArray();
		Vector<String> vname = new Vector<String>();
		for (int i = 0; i < (arrChar.length); i++) {//Them dau cach vao truoc cac chu in Hoa ke tu chu cai thu 2			
				switch(arrChar[i]){
				case 'Q':
				case 'W':
				case 'E':
				case 'R':
				case 'T':
				case 'Y':
				case 'U':
				case 'I':
				case 'O':
				case 'P':
				case 'A':
				case 'S':
				case 'D':
				case 'F':
				case 'G':
				case 'H':
				case 'J':
				case 'K':
				case 'L':
				case 'Z':
				case 'X':
				case 'C':
				case 'V':
				case 'B':
				case 'N':
				case 'M':
				case '\u00C1':
				case '\u00C0':
				case '\u1EA2':
				case '\u00C3':
				case '\u1EA0':
				case '\u0102':
				case '\u1EAE':
				case '\u1EB0':
				case '\u1EB2':
				case '\u1EB4':
				case '\u1EB6':
				case '\u00C2':
				case '\u1EA4':
				case '\u1EA6':
				case '\u1EA8':
				case '\u1EAA':
				case '\u1EAC':
				case '\u0202':
				case '\u01CD':

				case '\u00C9':
				case '\u00C8':
				case '\u1EBA':
				case '\u1EBC':
				case '\u1EB8':
				case '\u00CA':
				case '\u1EBE':
				case '\u1EC0':
				case '\u1EC2':
				case '\u1EC4':
				case '\u1EC6':
				case '\u0206':

				case '\u00CD':
				case '\u00CC':
				case '\u1EC8':
				case '\u0128':
				case '\u1ECA':

				case '\u00D3':
				case '\u00D2':
				case '\u1ECE':
				case '\u00D5':
				case '\u1ECC':
				case '\u00D4':
				case '\u1ED0':
				case '\u1ED2':
				case '\u1ED4':
				case '\u1ED6':
				case '\u1ED8':
				case '\u01A0':
				case '\u1EDA':
				case '\u1EDC':
				case '\u1EDE':
				case '\u1EE0':
				case '\u1EE2':
				case '\u020E':

				case '\u00DA':
				case '\u00D9':
				case '\u1EE6':
				case '\u0168':
				case '\u1EE4':
				case '\u01AF':
				case '\u1EE8':
				case '\u1EEA':
				case '\u1EEC':
				case '\u1EEE':
				case '\u1EF0':

				case '\u00DD':
				case '\u1EF2':
				case '\u1EF6':
				case '\u1EF8':
				case '\u1EF4':

				case '\u0110':
				case '\u00D0':
				case '\u0089':
				{
					vname.add(" ");
					vname.add(Character.toString( arrChar[i] ));
					break;
					
				}
					default:vname.add(Character.toString( arrChar[i] ));
					
				}
		}
		name = "";
		for (int j = 0; j < vname.size(); j++) {
			name = name + vname.get(j) ;
		}
		return name;
	}
	public static void main(String[] args) {
		XuLiTen a = new XuLiTen();
		System.out.println(a.xuLiTen("  Nguyễn NguyEn   Van   ABC   "));
	}
}
