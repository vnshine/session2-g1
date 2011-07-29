package process;

import java.sql.Date;

public class KhachHang {
	private String 	PK_KhachHang;
	private String 	sHoTen;
	private Date 	dNgaySinh;
	private String	sSoDienThoai;
	private String 	sDiaChi;
	private Integer	iTrangThai;
	private Integer iDonVi;
	
	
	
	
	public String getPK_KhachHang() {
		return PK_KhachHang;
	}
	public void setPK_KhachHang(String pK_KhachHang) {
		PK_KhachHang = pK_KhachHang;
	}
	public String getsHoTen() {
		return sHoTen;
	}
	public void setsHoTen(String sHoTen) {
		this.sHoTen = sHoTen;
	}
	public Date getdNgaySinh() {
		return dNgaySinh;
	}
	public void setdNgaySinh(Date dNgaySinh) {
		this.dNgaySinh = dNgaySinh;
	}
	public String getsSoDienThoai() {
		return sSoDienThoai;
	}
	public void setsSoDienThoai(String sSoDienThoai) {
		this.sSoDienThoai = sSoDienThoai;
	}
	public String getsDiaChi() {
		return sDiaChi;
	}
	public void setsDiaChi(String sDiaChi) {
		this.sDiaChi = sDiaChi;
	}
	public Integer getiTrangThai() {
		return iTrangThai;
	}
	public void setiTrangThai(Integer iTrangThai) {
		this.iTrangThai = iTrangThai;
	}
	public Integer getiDonVi() {
		return iDonVi;
	}
	public void setiDonVi(Integer iDonVi) {
		this.iDonVi = iDonVi;
	}
	
	
	
	
}
