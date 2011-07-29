		/*
		 Nếu : min <= số ký tự <=max && không chứa
		 chữ số, ký tự lạ thì trả lại true ngược lại trả
		 lại false
		 */
package validate;
public class  KiemTraTen {
	public boolean kiemTraTen(String name, Integer min,Integer max){
		Integer dung = 1;
		Integer soKyTu=0;
		name = name.trim();//xoa khoang trang thua
		if (name == ""){
			dung = 0;
		}else {
			XuLiTen ten = new XuLiTen();
			name = ten.xuLiTen(name);    //xu li ten
		}
		if (name.length() < min) dung = 0;//kiem tra do dai ten toi thieu
		if (name.length() > max) dung = 0;//kiem tra do dai ten toi da
		for (int i = 1; i < (name.length()); i++) {
			String str = name.substring(i,i+1);
			if (str.matches("[a-zA-Z ]") == false) dung =0;//kiem tra tung ky tu
			if (str.matches("[a-zA-Z] ")) soKyTu = soKyTu+1;//dem so ky tu
		}
		if (dung == 1)return true;// neu khong co loi thi tra ve true
		return false;// neu ko tra ve true thi tra ve false
	}
//	public static void main(String[] args) {
//	KiemTraTen a = new KiemTraTen();
//	System.out.println(a.kiemTraTen("      c     c c1   ", 6, 100));
//	}
}
