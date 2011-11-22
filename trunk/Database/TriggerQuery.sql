USE NhatQuang
GO

SET dateformat dmy
GO

-----Trigger cập nhật tiền mặt trong kho ki thu/chi
CREATE trigger trigger_CapNhatTienMat
on tbl_PhieuThuChi
for insert
as
begin
	IF((select iTrangThai FROM inserted) = 0)
		update tbl_ThongTinCongTy SET fTienMat = ((SELECT fTienMat from tbl_ThongTinCongTy) + (select fSoTien from inserted))
	else
		update tbl_ThongTinCongTy SET fTienMat = ((SELECT fTienMat from tbl_ThongTinCongTy) - (select fSoTien from inserted))
end


-----Trigger cập nhật số lượng hàng
CREATE trigger trigger_CapNhatSoLuongHang
on tbl_ChiTietPhieuNhapXuat
for insert
as
begin
	IF((select fGiaGoc from INSERTED) is NULL)
		UPDATE tbl_HangHoa SET iSoLuong = iSoLuong + (select iSoLuong from INSERTED) WHERE PK_iHangHoaID = (SELECT FK_iHangHoaID from INSERTED)
	else
		UPDATE tbl_HangHoa SET iSoLuong = iSoLuong - (select iSoLuong from INSERTED) WHERE PK_iHangHoaID = (SELECT FK_iHangHoaID from INSERTED)
end
-----Trigger cập nhật công nợ
CREATE trigger trigger_CongNoTuDong
on tbl_PhieuNhapXuat
for insert
as
begin
	IF(select * FROM tblCongNo where FK_sDoiTacID = (select FK_sDoiTacID from INSERTED) IS NOT NULL)
		IF(select iTrangThai from INSERTED = 0)
			IF(SELECT fConNo from inserted > 0)
				UPDATE tbl_CongNo SET fSoTien = (select fSoTien from tblCongNo WHERE FK_sDoiTacID = SELECT FK_sDoiTacID from INSERTED + SELECT fSoTien from INSERTED)
	else
end

-----Trigger cập nhật tiền mặt trong kho ki thu/chi
CREATE trigger trigger_PhieuThuChiTuDong
on tbl_PhieuNhapXuat
for insert
as
begin
	IF((select iTrangThai FROM inserted) = 0)
		INSERT INTO tbl_PhieuThuChi(PK_sPhieuThuChiID,iTrangThai,sLyDo,fSoTien,sGhiChu,FK_sNhanVienID,FK_sPhieuNhapXuatID,FK_sDoiTacID) VALUES(SELECT 'PC_'+PK_sPhieuNhapXuatID FROM inserted,1,'Trả tiền mua hàng',SELECT fTongTien-fConNo from INSERTED,'',select FK_sNhanVienID from INSERTED,select PK_sPhieuNhapXuatID from INSERTED,select FK_sDoiTacID from inserted)
	else
		INSERT INTO tbl_PhieuThuChi(PK_sPhieuThuChiID,iTrangThai,sLyDo,fSoTien,sGhiChu,FK_sNhanVienID,FK_sPhieuNhapXuatID,FK_sDoiTacID) VALUES(SELECT 'PT_'+PK_sPhieuNhapXuatID FROM inserted,0,'Thu tiền khách hàng',SELECT fTongTien-fConNo from INSERTED,'',select FK_sNhanVienID from INSERTED,select PK_sPhieuNhapXuatID from INSERTED,select FK_sDoiTacID from inserted)
end
