package validate;

import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

public class KiemTraNgay {

	public boolean KiemTraNgay(String date , boolean firstflag){
		
		boolean flag = true;
		
//		String[] str;
//		str = new String[4];
//		Date now = new Date();
//	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//	    SimpleDateFormat sdfD = new SimpleDateFormat("dd");
//	    SimpleDateFormat sdfM = new SimpleDateFormat("MM");
//	    SimpleDateFormat sdfY = new SimpleDateFormat("yyyy");
	    Date aDate = new Date(System.currentTimeMillis());
	    Calendar calendar = GregorianCalendar.getInstance();
	    calendar.setTime(aDate);
//	    for (int i = 0; i < 4; i++) {
//	    	str[i] = new String();
//		}
//	    str[0] = sdf.format(now);
//	    str[1] = sdfD.format(now);
//	    str[2] = sdfM.format(now);
//	    str[3] = sdfY.format(now);
	    

	    Integer nowYear = calendar.get(Calendar.YEAR);
	    Integer nowMonth = calendar.get(Calendar.MONTH);
	    Integer nowDay = calendar.get(Calendar.DATE);
	    
		
		Pattern pa=Pattern.compile("(([012][0-9])||([3][01]))[/](([0][0-9])||[1][0-2])[/](19||20)[0-9][0-9]");
		if (firstflag == true) {
			if(pa.matcher(date).matches()==false){
				System.out.println("Nhap khong dung, moi nhap lai . Nhao vao ngay thang nam voi dinh dang dd/mm/yyyy");
				flag = false;
			}else {
				flag = true;
			}
		}else if(firstflag == false){
			if(pa.matcher(date).matches()==false){
				System.out.println("Nhap khong dung, moi nhap lai . Nhao vao ngay thang nam voi dinh dang dd/mm/yyyy");
				flag = false;
			}else {
				String str = date;
			    int a= str.indexOf("/");
			    String strD = str.substring(0,a);
			    String temp = str.substring(a+1);
			    String strM = temp.substring(0,a);
			    String strY = temp.substring(a+1);
			    Integer day = Integer.parseInt(strD);
			    Integer month = Integer.parseInt(strM);
			    Integer year = Integer.parseInt(strY);
			    if (day > nowDay || month > nowMonth || year > nowYear ) {
			    	System.out.println("Ko duoc phep nhap ngay lon hon ngay hien tai !!!!");
			    	flag = false;
			    }else {
			    	flag = true;
				}
			    
			}
		}
		
		
		
		
		
		
		return flag;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KiemTraNgay kiemTraNgay = new KiemTraNgay();
		System.out.println(kiemTraNgay.KiemTraNgay("20/09/2019", false));
		
//		System.out.println("Now : " + );
		
		
		

	}

}
