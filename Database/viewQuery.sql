USE NhatQuang
GO

CREATE view view_TienTrongHang
as
	SELECT sum(tbl_HangHoa.iSoLuong*tbl_HangHoa.iGiaMua) as fTienTrongHang
	FROM tbl_HangHoa
GO

CREATE view view_TienMat
as
	SELECT fTienMat FROM tbl_ThongTinCongTy
GO

CREATE view view_TienNo
as
	SELECT ISNULL(sum(fSotien),0) as fTienNo FROM tbl_CongNo
GO


--Top 5 sản phẩm bán chạy trong ngày
CREATE view view_TopNamSanPhamBanChay
as
	SELECT top 5 FK_iHangHoaID as PK_iHangHoaID, sum(iSoLuong) as iSoLuongBan FROM tbl_ChiTietPhieuNhapXuat 
	WHERE fGiaGoc > 0 --AND FK_sPhieuNhapXuatID IN(SELECT FK_sPhieuNhapXuatID FROM tbl_PhieuNhapXuat WHERE convert(varchar, dNgayNhapXuat, 3) = convert(varchar, getdate(), 3))
	GROUP BY FK_iHangHoaID
	ORDER BY iSoLuongBan DESC
-----View top 5 nhân viên bán hàng

-----
CREATE view view_TopNamNhanVienBanHang
as
	SELECT top 5 FK_sNhanVienID, sum(fTongTien) as fSoTienBan
	from tbl_PhieuNhapXuat
	--WHERE convert(varchar, dNgayNhapXuat, 3) = convert(varchar, getdate(), 3)
	group by FK_sNhanVienID 
	ORDER BY fSoTienBan desc

---Số lượng hàng bán theo phiếu xuất
CREATE view view_SoLuongBanTheoPhieu
as
	SELECT FK_sPhieuNhapXuatID,sum(iSoLuong) as iSoLuongBan
	FROM tbl_ChiTietPhieuNhapXuat
	WHERE fGiaGoc>0
	GROUP BY FK_sPhieuNhapXuatID

SELECT FK_sNhanVienID,sum(iSoLuongBan) as iTongSoLuongBan
FROM tbl_PhieuNhapXuat INNER JOIN view_SoLuongBanTheoPhieu on view_SoLuongBanTheoPhieu.FK_sPhieuNhapXuatID = tbl_PhieuNhapXuat.PK_sPhieuNhapXuatID
GROUP BY FK_sNhanVienID




