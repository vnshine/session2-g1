USE NhatQuang
GO

SET dateformat dmy
GO
---/*
---Tính lợi nhuận bán hàng
---*/
SELECT     tbl_PhieuNhapXuat.PK_sPhieuNhapXuatID, tbl_PhieuNhapXuat.dNgayNhapXuat, tbl_HangHoa.PK_iHangHoaID, tbl_ChiTietPhieuNhapXuat.iSoLuong, 
                      tbl_ChiTietPhieuNhapXuat.fGiaGoc, tbl_ChiTietPhieuNhapXuat.fGiaBan, tbl_ChiTietPhieuNhapXuat.fGiaBan*tbl_ChiTietPhieuNhapXuat.iSoLuong as fThanhTien, tbl_ChiTietPhieuNhapXuat.iSoLuong*(tbl_ChiTietPhieuNhapXuat.fGiaBan-tbl_ChiTietPhieuNhapXuat.fGiaGoc) as fLoiNhuan
FROM         tbl_PhieuNhapXuat INNER JOIN
                      tbl_ChiTietPhieuNhapXuat ON tbl_PhieuNhapXuat.PK_sPhieuNhapXuatID = tbl_ChiTietPhieuNhapXuat.FK_sPhieuNhapXuatID INNER JOIN
                      tbl_HangHoa ON tbl_ChiTietPhieuNhapXuat.FK_iHangHoaID = tbl_HangHoa.PK_iHangHoaID
WHERE tbl_PhieuNhapXuat.iTrangThai = 1 AND datepart(mm,tbl_PhieuNhapXuat.dNgayNhapXuat) = datepart(mm,getdate())

--!
--Tách tháng từ ngày tháng
--select datepart(mm,getdate())
--*/

SELECT fTienTrongHang,tbl_ThongTinCongTy.fTienMat,fTienNo,sTenCongTy,sDiaChi,sSoDienThoai,sEmail from view_TienTrongHang,view_TienMat,view_TienNo,tbl_ThongTinCongTy

---/*
---Báo cáo doanh thu theo ngày
---*/

SELECT     tbl_NhanVien.PK_sNhanVienID,sum(fTongTien)+sum(fSoTien) as fThuTrenPhieu, sum(fTongTien-fConNo)+sum(fSoTien) as fThucThu
FROM         tbl_NhanVien INNER JOIN tbl_PhieuNhapXuat ON tbl_NhanVien.PK_sNhanVienID = tbl_PhieuNhapXuat.FK_sNhanVienID INNER JOIN tbl_PhieuThuChi ON tbl_NhanVien.PK_sNhanVienID = tbl_PhieuThuChi.FK_sNhanVienID
	AND tbl_PhieuNhapXuat.iTrangThai = 1 AND tbl_PhieuThuChi.iTrangThai = 0
GROUP BY tbl_NhanVien.PK_sNhanVienID


SELECT     tbl_NhanVien.PK_sNhanVienID,sum(fTongTien)+sum(fSoTien) as fChiTrenPhieu, sum(fTongTien-fConNo)+sum(fSoTien) as fThucChi
FROM         tbl_NhanVien INNER JOIN tbl_PhieuNhapXuat ON tbl_NhanVien.PK_sNhanVienID = tbl_PhieuNhapXuat.FK_sNhanVienID INNER JOIN tbl_PhieuThuChi ON tbl_NhanVien.PK_sNhanVienID = tbl_PhieuThuChi.FK_sNhanVienID
	AND tbl_PhieuNhapXuat.iTrangThai = 0 AND tbl_PhieuThuChi.iTrangThai = 1
GROUP BY tbl_NhanVien.PK_sNhanVienID

------
SELECT tbl_HangHoa.PK_iHangHoaID,sTenHangHoa,iSoLuongBan 
from view_TopNamSanPhamBanChay INNER JOIN tbl_HangHoa 
ON view_TopNamSanPhamBanChay.PK_iHangHoaID = tbl_HangHoa.PK_iHangHoaID

-----
SELECT tbl_NhanVien.sHoTen, view_TopNamNhanVienBanHang.fSoTienBan
FROM tbl_NhanVien INNER JOIN view_TopNamNhanVienBanHang ON tbl_NhanVien.PK_sNhanVienID = view_TopNamNhanVienBanHang.FK_sNhanVienID





