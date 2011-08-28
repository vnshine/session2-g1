package validate;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;

import module.ThongBao;

public class CheckString {

	public boolean isPhoneFormat(String strValue) {
        String regex = "^[+]?[01]?[- .]?(\\([2-9]\\d{2}\\)|[2-9]\\d{2})[- .]?\\d{3}[- .]?\\d{4}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(strValue);
        return m.matches();
        //return strValue.matches();
    }
	public boolean OnlytextAndNumber(String str,Integer max,Integer min,JLabel lblThongBao,String nhan) {
		Integer loi = 0;
		str = str.trim();//xoa khoang trang dau duoi
		if (str.length() < min) {//kiem tra do dai ten toi thieu
			loi = 1;
			new ThongBao(lblThongBao, Color.RED,nhan + "S\u1ED1 l\u01B0\u1EE3ng k\u00FD t\u1EF1 kh\u00F4ng h\u1EE3p l\u1EC7 !");
		}
		if (str.length() > max) {//kiem tra do dai ten toi da
			loi = 1;
			new ThongBao(lblThongBao, Color.RED,nhan + "S\u1ED1 l\u01B0\u1EE3ng k\u00FD t\u1EF1 kh\u00F4ng h\u1EE3p l\u1EC7 !");
		}
		if (str.matches("[A-z0-9]+") == false) {
			loi = 1;
			new ThongBao(lblThongBao, Color.RED,nhan + "K\u00FD t\u1EF1 nh\u1EADp v\u00E0o kh\u00F4ng h\u1EE3p l\u1EC7 !");
		}
		if (loi == 1) {
			return false;
		} else {
			return true;
		}
	}
	
	
	public boolean Onlytext(String name,Integer max,Integer min) {
		String str,str2;
		str2 = name;
		Integer loi = 0;
		
		str2 = str2.trim();//xoa khoang trang dau duoi
		while (str2.contains("  ")) {//chuyen khoang trang dai thanh dau cach
			str2 = str2.substring(0,str2.indexOf("  ")+1) + str2.substring(str2.indexOf("  ")+2);
		}
		
		
		if (name.length() < min) loi = 1;//kiem tra do dai ten toi thieu
		if (name.length() > max) loi = 1;//kiem tra do dai ten toi da
		char arrChar[] = name.toCharArray();
		for (int i = 0; i < (arrChar.length); i++) {//kiem tra ky tu nhap vao
			str = name.substring(i,i+1);
			//if (str.matches("[A-z]")) {}else loi = 1;
			switch(arrChar[i]){
				case ' ':
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
				case 'q':
				case 'w':
				case 'e':
				case 'r':
				case 't':
				case 'y':
				case 'u':
				case 'i':
				case 'o':
				case 'p':
				case 'a':
				case 's':
				case 'd':
				case 'f':
				case 'g':
				case 'h':
				case 'j':
				case 'k':
				case 'l':
				case 'z':
				case 'x':
				case 'c':
				case 'v':
				case 'b':
				case 'n':
				case 'm':
				case '\u00E1':
				case '\u00E0':
				case '\u1EA3':
				case '\u00E3':
				case '\u1EA1':
				case '\u0103':
				case '\u1EAF':
				case '\u1EB1':
				case '\u1EB3':
				case '\u1EB5':
				case '\u1EB7':
				case '\u00E2':
				case '\u1EA5':
				case '\u1EA7':
				case '\u1EA9':
				case '\u1EAB':
				case '\u1EAD':
				case '\u0203':
				case '\u01CE':

				case '\u00E9':
				case '\u00E8':
				case '\u1EBB':
				case '\u1EBD':
				case '\u1EB9':
				case '\u00EA':
				case '\u1EBF':
				case '\u1EC1':
				case '\u1EC3':
				case '\u1EC5':
				case '\u1EC7':
				case '\u0207':

				case '\u00ED':
				case '\u00EC':
				case '\u1EC9':
				case '\u0129':
				case '\u1ECB':

				case '\u00F3':
				case '\u00F2':
				case '\u1ECF':
				case '\u00F5':
				case '\u1ECD':
				case '\u00F4':
				case '\u1ED1':
				case '\u1ED3':
				case '\u1ED5':
				case '\u1ED7':
				case '\u1ED9':
				case '\u01A1':
				case '\u1EDB':
				case '\u1EDD':
				case '\u1EDF':
				case '\u1EE1':
				case '\u1EE3':
				case '\u020F':

				case '\u00FA':
				case '\u00F9':
				case '\u1EE7':
				case '\u0169':
				case '\u1EE5':
				case '\u01B0':
				case '\u1EE9':
				case '\u1EEB':
				case '\u1EED':
				case '\u1EEF':
				case '\u1EF1':

				case '\u00FD':
				case '\u1EF3':
				case '\u1EF7':
				case '\u1EF9':
				case '\u1EF5':

				case '\u0111':

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
				System.out.println("nhay vao ko lam j ");
			break;
			}
			default:
//			result[i] = arrChar[i];
				System.out.println("nhay vao default ");
				loi = 1;
			}
			
		}
		
		if (loi == 1) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean Address(String name,Integer max,Integer min) {
		String str,str2;
		str2 = name;
		Integer loi = 0;
		
		str2 = str2.trim();//xoa khoang trang dau duoi
		while (str2.contains("  ")) {//chuyen khoang trang dai thanh dau cach
			str2 = str2.substring(0,str2.indexOf("  ")+1) + str2.substring(str2.indexOf("  ")+2);
		}
		
		
		if (name.length() < min) loi = 1;//kiem tra do dai ten toi thieu
		if (name.length() > max) loi = 1;//kiem tra do dai ten toi da
		char arrChar[] = name.toCharArray();
		for (int i = 0; i < (arrChar.length); i++) {//kiem tra ky tu nhap vao
			str = name.substring(i,i+1);
			//if (str.matches("[A-z]")) {}else loi = 1;
			switch(arrChar[i]){
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
				case '-':
				case '_':
				case '/':
				case ' ':
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
				case 'q':
				case 'w':
				case 'e':
				case 'r':
				case 't':
				case 'y':
				case 'u':
				case 'i':
				case 'o':
				case 'p':
				case 'a':
				case 's':
				case 'd':
				case 'f':
				case 'g':
				case 'h':
				case 'j':
				case 'k':
				case 'l':
				case 'z':
				case 'x':
				case 'c':
				case 'v':
				case 'b':
				case 'n':
				case 'm':
				case '\u00E1':
				case '\u00E0':
				case '\u1EA3':
				case '\u00E3':
				case '\u1EA1':
				case '\u0103':
				case '\u1EAF':
				case '\u1EB1':
				case '\u1EB3':
				case '\u1EB5':
				case '\u1EB7':
				case '\u00E2':
				case '\u1EA5':
				case '\u1EA7':
				case '\u1EA9':
				case '\u1EAB':
				case '\u1EAD':
				case '\u0203':
				case '\u01CE':

				case '\u00E9':
				case '\u00E8':
				case '\u1EBB':
				case '\u1EBD':
				case '\u1EB9':
				case '\u00EA':
				case '\u1EBF':
				case '\u1EC1':
				case '\u1EC3':
				case '\u1EC5':
				case '\u1EC7':
				case '\u0207':

				case '\u00ED':
				case '\u00EC':
				case '\u1EC9':
				case '\u0129':
				case '\u1ECB':

				case '\u00F3':
				case '\u00F2':
				case '\u1ECF':
				case '\u00F5':
				case '\u1ECD':
				case '\u00F4':
				case '\u1ED1':
				case '\u1ED3':
				case '\u1ED5':
				case '\u1ED7':
				case '\u1ED9':
				case '\u01A1':
				case '\u1EDB':
				case '\u1EDD':
				case '\u1EDF':
				case '\u1EE1':
				case '\u1EE3':
				case '\u020F':

				case '\u00FA':
				case '\u00F9':
				case '\u1EE7':
				case '\u0169':
				case '\u1EE5':
				case '\u01B0':
				case '\u1EE9':
				case '\u1EEB':
				case '\u1EED':
				case '\u1EEF':
				case '\u1EF1':

				case '\u00FD':
				case '\u1EF3':
				case '\u1EF7':
				case '\u1EF9':
				case '\u1EF5':

				case '\u0111':

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
				System.out.println("nhay vao ko lam j ");
			break;
			}
			default:
//			result[i] = arrChar[i];
				System.out.println("nhay vao default ");
				loi = 1;
			}
			
		}
		
		if (loi == 1) {
			return false;
		} else {
			return true;
		}
	}
	

	    public static boolean PhoneNumber(String str) {
	    	String regex ="^[+]?[0-9]?[0-9]?[- .]?([0-9]{3})[- .]?[0-9]{3}[- .]?[0-9]{4}$";
	    	String regex2 ="^[+]?[0-9]?[0-9]?[- .]?([0-9]{3})[- .]?[0-9]{3}[- .]?[0-9]{4}$";
	        if ((Pattern.matches(regex, str) == true )||(Pattern.matches(regex2, str) == true )) {
	        	return true;
			}
	        return false;
	    }
	
	public void main(String[] args) {
//		CheckString a = new CheckString();
//		String regex = "^[+]?[01]?[- .]?(\\([2-9]\\d{2}\\)|[2-9]\\d{2})[- .]?\\d{3}[- .]?\\d{4}$";
//		String b = "+01666679449";
//		System.out.println(b.matches(regex));
		String [] phoneNumbersToValidate={
				"02116270928",
				"+84-988-403-946",
				"2-309-778-4234",
				"2-309-778-4234",
                "1-309-778-4423",
                "309-778-4235",
                "3097784234",
                "309.778.4234",
                "01-309-798-4234",
                "001-309-798-4234",
                "0-309-798-4234",
                "+1-309-798-4235",
                "1-3097980577",
                "1-309.7980578",
                "1-(309)-788-8978"};

		for(int index=0;index<phoneNumbersToValidate.length;index++) {
		String number=phoneNumbersToValidate[index];
		boolean isValid=PhoneNumber(phoneNumbersToValidate[index]);
		System.out.println(number+" : "+(isValid?"Valid":"Invalid"));
		}
	}
}
