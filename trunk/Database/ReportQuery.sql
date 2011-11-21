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
SELECT * FROM tbl_ThongTinCongTy