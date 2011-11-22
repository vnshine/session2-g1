USE NhatQuang
GO

SET dateformat dmy
GO
----Thông tin công ty
INSERT INTO tbl_ThongTinCongTy(PK_sCongTyID,sTenCongTy,sTenCongTyEng,sDiaChi,sDiaChiEng,sSoDienThoai,sEmail,sWebsite,fTienMat) VALUES('NHATQUANG',N'HỢP TÁC XÃ CÔNG NGHIỆP NHẬT QUANG','HOP TAC XA CONG NGHIEP NHAT QUANG',N'Lô 03 - 9B KCN Hoàng Mai','LO 03 - 9B KHU CONG NGHIEP HOANG MAI','0912.465.422','nhatquang@vnn.vn','',500000000.0)
GO
----Nhân viên
SELECT * FROM tbl_NhanVien
INSERT INTO tbl_NhanVien(PK_sNhanVienID,sMatKhau,sHoTen,sHoTenEng,sSoDienThoai,bGioiTinh,sGhiChu,iTrangThai,dNgaySinh) VALUES('NV0001','123',N'Quang Liêm','QUANG LIEM','0989320758',1,'',0,'05/02/1990')
INSERT INTO tbl_NhanVien(PK_sNhanVienID,sMatKhau,sHoTen,sHoTenEng,sSoDienThoai,bGioiTinh,sGhiChu,iTrangThai,dNgaySinh) VALUES('NV0002','123',N'Việt Anh','VIET ANH','0989320758',1,'',0,'06/02/1990')
INSERT INTO tbl_NhanVien(PK_sNhanVienID,sMatKhau,sHoTen,sHoTenEng,sSoDienThoai,bGioiTinh,sGhiChu,iTrangThai,dNgaySinh) VALUES('NV0003','123',N'Tạ Việt Thảo','TA VIET THAO','0989320758',1,'',0,'03/02/1991')
INSERT INTO tbl_NhanVien(PK_sNhanVienID,sMatKhau,sHoTen,sHoTenEng,sSoDienThoai,bGioiTinh,sGhiChu,iTrangThai,dNgaySinh) VALUES('NV0004','123',N'Trần Tuấn Sơn','TRAN TUAN SON','0989320758',1,'',0,'06/02/1990')
INSERT INTO tbl_NhanVien(PK_sNhanVienID,sMatKhau,sHoTen,sHoTenEng,sSoDienThoai,bGioiTinh,sGhiChu,iTrangThai,dNgaySinh) VALUES('NV0005','123',N'Nguyễn Thế Vinh','NGUYEN THE VINH','0989320358',1,'',0,'05/06/1990')
----Nhom hang
INSERT INTO tbl_NhomHang(sTenNhomHang,sTenNhomHangEng,sGhiChu,iTrangThai) VALUES(N'Đồ gia dụng','DO GIA DUNG','',0)
INSERT INTO tbl_NhomHang(sTenNhomHang,sTenNhomHangEng,sGhiChu,iTrangThai) VALUES(N'Vật liệu xây dựng','Vat lieu xay dung','',0)
INSERT INTO tbl_NhomHang(sTenNhomHang,sTenNhomHangEng,sGhiChu,iTrangThai) VALUES(N'Thiết bị văn phòng','Thiet bi van phong','',0)
INSERT INTO tbl_NhomHang(sTenNhomHang,sTenNhomHangEng,sGhiChu,iTrangThai) VALUES(N'Thiết bị điện tử','Thiet bi dien tu','',0)
GO
------Nhà sản xuất
INSERT INTO tbl_NhaSanXuat VALUES('NSX001',N'Song Long','SONG LONG', '',0)
INSERT INTO tbl_NhaSanXuat VALUES('NSX002',N'Sơn Hà','SON HA', '',0)
INSERT INTO tbl_NhaSanXuat VALUES('NSX003',N'SONY','SONY', '',0)
INSERT INTO tbl_NhaSanXuat VALUES('NSX004',N'VIGLACERA','VIGLACERA', '',0)
-----Đơn vị tính
INSERT INTO tbl_DonViTinh(sTenDonViTinh,sTenDonViTinhEng,sGhiChu) VALUES(N'Cái','CAI','')
INSERT INTO tbl_DonViTinh(sTenDonViTinh,sTenDonViTinhEng,sGhiChu) VALUES(N'Thùng','THUNG','')
INSERT INTO tbl_DonViTinh(sTenDonViTinh,sTenDonViTinhEng,sGhiChu) VALUES(N'Bao','BAO','')
INSERT INTO tbl_DonViTinh(sTenDonViTinh,sTenDonViTinhEng,sGhiChu) VALUES(N'Cân','CAN','')
INSERT INTO tbl_DonViTinh(sTenDonViTinh,sTenDonViTinhEng,sGhiChu) VALUES(N'Tạ','TA','')
INSERT INTO tbl_DonViTinh(sTenDonViTinh,sTenDonViTinhEng,sGhiChu) VALUES(N'Hộp','HOP','')
INSERT INTO tbl_DonViTinh(sTenDonViTinh,sTenDonViTinhEng,sGhiChu) VALUES(N'Lít','LIT','')
INSERT INTO tbl_DonViTinh(sTenDonViTinh,sTenDonViTinhEng,sGhiChu) VALUES(N'Ống','ONG','')
-------Đối tác
INSERT INTO tbl_DoiTac VALUES('DT0001','Công ty AHD','CONG TY AHD', '043123980',N'120 Thái Hà',0,'Trần Thái Dương','')
INSERT INTO tbl_DoiTac VALUES('DT0002','Công ty An Bình','CONG TY AN BINH', '043123980',N'120 Lê Duẩn',0,'Nguyễn Văn Phú','')
INSERT INTO tbl_DoiTac VALUES('DT0003','Công ty Hà Việt','CONG TY HA VIET', '043123932',N'12 Nguyễn Chí Thanh',0,'Trần Thái Dương','')
INSERT INTO tbl_DoiTac VALUES('DT0004','Công ty TCI','CONG TY TCI', '043123980',N'34 Hoàng Hoa Thám',0,'Trần Tiến Hải','')
INSERT INTO tbl_DoiTac VALUES('DT0005','Công ty VTI','CONG TY VTI', '043123980',N'46 Lê Duẩn',0,'Lê Quang Khải','')
INSERT INTO tbl_DoiTac VALUES('DT0006','Công ty M&C','CONG TY M&C', '043123980',N'111 Trường Chinh',0,'Phạm Huyền Trang','')

SELECT * FROM tbl_HangHoa

-------Hàng hóa
INSERT INTO tbl_HangHoa(sTenHangHoa,sTenHangHoaEng,iDonGia,sNgayNhap,sGhiChu,FK_sDoiTacID,FK_sNhaSanXuatID,FK_iDonViTinhID,FK_iNhomHangID,iTrangThai,iSoLuong) VALUES(N'Ống nước PVC','ONG NUOC PVC', 50.0,'20/11/2011','','DT0001','NSX001',8,2,0,200)
INSERT INTO tbl_HangHoa(sTenHangHoa,sTenHangHoaEng,iDonGia,sNgayNhap,sGhiChu,FK_sDoiTacID,FK_sNhaSanXuatID,FK_iDonViTinhID,FK_iNhomHangID,iTrangThai,iSoLuong) VALUES(N'Vòi hoa sen','VOI SEN', 50.0,'20/11/2011','','DT0001','NSX004',1,2,0,100)
INSERT INTO tbl_HangHoa(sTenHangHoa,sTenHangHoaEng,iDonGia,sNgayNhap,sGhiChu,FK_sDoiTacID,FK_sNhaSanXuatID,FK_iDonViTinhID,FK_iNhomHangID,iTrangThai,iSoLuong) VALUES(N'Chậu rửa mặt','CHAU RUA MAT', 210.3,'20/11/2011','','DT0002','NSX004',8,1,0,200)
-------Phiếu nhập xuất
INSERT INTO tbl_PhieuNhapXuat(PK_sPhieuNhapXuatID,iTrangThai,FK_sNhanVienID,FK_sDoiTacID,fTongTien,fConNo,sGhiChu) VALUES('PN0001',0,'NV0001','DT0001',780000,0,'')
INSERT INTO tbl_PhieuNhapXuat(PK_sPhieuNhapXuatID,iTrangThai,FK_sNhanVienID,FK_sDoiTacID,fTongTien,fConNo,sGhiChu) VALUES('PN0002',0,'NV0002','DT0002',5000000,0,'')
INSERT INTO tbl_PhieuNhapXuat(PK_sPhieuNhapXuatID,iTrangThai,FK_sNhanVienID,FK_sDoiTacID,fTongTien,fConNo,sGhiChu) VALUES('PN0003',0,'NV0003','DT0003',200000,0,'')
INSERT INTO tbl_PhieuNhapXuat(PK_sPhieuNhapXuatID,iTrangThai,FK_sNhanVienID,FK_sDoiTacID,fTongTien,fConNo,sGhiChu) VALUES('PX0001',1,'NV0001','DT0001',250000,300,'')
INSERT INTO tbl_PhieuNhapXuat(PK_sPhieuNhapXuatID,iTrangThai,FK_sNhanVienID,FK_sDoiTacID,fTongTien,fConNo,sGhiChu) VALUES('PX0002',1,'NV0001','DT0002',2500000,0,'')
INSERT INTO tbl_PhieuNhapXuat(PK_sPhieuNhapXuatID,iTrangThai,FK_sNhanVienID,FK_sDoiTacID,fTongTien,fConNo,sGhiChu) VALUES('PX0003',1,'NV0002','DT0002',1250000,5000000,'')
-------Chi tiết phiếu nhập xuất

INSERT INTO tbl_ChiTietPhieuNhapXuat VALUES('PX0001',10,10,50,55)
INSERT INTO tbl_ChiTietPhieuNhapXuat VALUES('PX0001',11,5,50,55)

INSERT INTO tbl_ChiTietPhieuNhapXuat VALUES('PX0002',11,4,50,55)
INSERT INTO tbl_ChiTietPhieuNhapXuat VALUES('PX0002',12,5,210.3,250)

INSERT INTO tbl_ChiTietPhieuNhapXuat(FK_sPhieuNhapXuatID,FK_iHangHoaID,iSoLuong) VALUES('PN0001',10,10)
INSERT INTO tbl_ChiTietPhieuNhapXuat(FK_sPhieuNhapXuatID,FK_iHangHoaID,iSoLuong) VALUES('PN0001',11,5)
INSERT INTO tbl_ChiTietPhieuNhapXuat(FK_sPhieuNhapXuatID,FK_iHangHoaID,iSoLuong) VALUES('PN0001',12,20)

------Phiếu thu chi
SELECT fTienMat from tbl_ThongTinCongTy
DELETE tbl_PhieuThuChi
SET dateformat dmy
go
INSERT INTO tbl_PhieuThuChi(PK_sPhieuThuChiID,iTrangThai,sLyDo,fSoTien,sGhiChu,FK_sNhanVienID,FK_sPhieuNhapXuatID,FK_sDoiTacID,dNgayThuChi) VALUES('PT0001',0,'Thu tiền xuất hàng',24700000,'','NV0001','PX0001','DT0001','21/11/2011')
INSERT INTO tbl_PhieuThuChi(PK_sPhieuThuChiID,iTrangThai,sLyDo,fSoTien,sGhiChu,FK_sNhanVienID,FK_sPhieuNhapXuatID,FK_sDoiTacID,dNgayThuChi) VALUES('PT0002',0,'Thu tiền xuất hàng',12000000,'','NV0002','PX0003','DT0002','21/11/2011')
INSERT INTO tbl_PhieuThuChi(PK_sPhieuThuChiID,iTrangThai,sLyDo,fSoTien,sGhiChu,FK_sNhanVienID,FK_sPhieuNhapXuatID,FK_sDoiTacID) VALUES('PT0003',0,'Thu tiền nợ khách hàng',300,'','NV0001','PX0001','DT0001')
INSERT INTO tbl_PhieuThuChi(PK_sPhieuThuChiID,iTrangThai,sLyDo,fSoTien,sGhiChu,FK_sNhanVienID,FK_sPhieuNhapXuatID,FK_sDoiTacID) VALUES('PT0004',0,'Thu tiền nợ khách hàng',500000,'','NV0002','PX0003','DT0002')

INSERT INTO tbl_PhieuThuChi(PK_sPhieuThuChiID,iTrangThai,sLyDo,fSoTien,sGhiChu,FK_sNhanVienID,FK_sPhieuNhapXuatID,FK_sDoiTacID,dNgayThuChi) VALUES('PC0001',0,'Trả tiền nhập hàng',780000,'','NV0001','PN0001','DT0001','21/11/2011')
INSERT INTO tbl_PhieuThuChi(PK_sPhieuThuChiID,iTrangThai,sLyDo,fSoTien,sGhiChu,FK_sNhanVienID,FK_sPhieuNhapXuatID,FK_sDoiTacID,dNgayThuChi) VALUES('PC0002',0,'Trả tiền nhập hàng',500000,'','NV0002','PN0002','DT0002','21/11/2011')
INSERT INTO tbl_PhieuThuChi(PK_sPhieuThuChiID,iTrangThai,sLyDo,fSoTien,sGhiChu,FK_sNhanVienID,FK_sPhieuNhapXuatID,FK_sDoiTacID,dNgayThuChi) VALUES('PC0003',0,'Trả tiền nhập hàng',200000,'','NV0003','PN0003','DT0003','21/11/2011')





