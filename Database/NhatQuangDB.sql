-- =============================================
-- Co so du lieu: NHAT QUANG
-- =============================================
USE master
GO

IF  EXISTS 
(
	SELECT name 
		FROM sys.databases 
		WHERE name = N'NhatQuang'
)
DROP DATABASE NhatQuang
GO

CREATE DATABASE NhatQuang
GO

use NhatQuang
go

-- =============================================
-- Tao bang
-- =============================================

-----------Bang tbl_Quyen
if(OBJECT_ID('tbl_Quyen','U') is not null)
begin
	drop table tbl_Quyen
end
create table tbl_Quyen
(
	PK_iQuyenID int identity primary key,
	sTenQuyen nvarchar(50) not null,
	sGhiChu nvarchar(100)
)
go

-----------Bang tbl_ChucNang
if(OBJECT_ID('tbl_ChucNang','U') is not null)
begin
	drop table tbl_ChucNang
end
create table tbl_ChucNang
(
	PK_sChucNangID varchar(15) primary key,
	sTenChucNang nvarchar(50) not null
)
go

-----------Bang tbl_ChucNang_Quyen
if(OBJECT_ID('tbl_ChucNang_Quyen','U') is not null)
begin
	drop table tbl_ChucNang_Quyen
end
create table tbl_ChucNang_Quyen
(
	FK_iQuyenID int references tbl_Quyen(PK_iQuyenID) not null,
	FK_sChucNangID varchar(15) references tbl_ChucNang(PK_sChucNangID) not null
	primary key(FK_iQuyenID,FK_sChucNangID)
)
go

-----------Bang tbl_NhanVien
if(OBJECT_ID('tbl_NhanVien','U') is not null)
begin
	drop table tbl_NhanVien
end
create table tbl_NhanVien
(
	PK_sNhanVienID varchar(6) primary key,
	sMatKhau varchar(50) not null,
	sHoTen nvarchar(45) not null,
	sSoDienThoai varchar(12) not null,
	sNgaySinh varchar(10) not null,
	bGioiTinh bit not null,
	sGhiChu nvarchar(100),
	FK_iQuyenID int references tbl_Quyen(PK_iQuyenID) not null
)
go

-----------Bang tbl_DoiTac
if(OBJECT_ID('tbl_DoiTac','U') is not null)
begin
	drop table tbl_DoiTac
end
create table tbl_DoiTac
(
	PK_sDoiTacID varchar(6) primary key,
	sTenDoiTac nvarchar(45) not null,
	sSoDienThoai varchar(12),
	sDiaChi nvarchar(100),
	iTrangThai int not null,
	sNguoiLienHe nvarchar(45),
	sGhiChu nvarchar(100)
)
go

-----------Bang tbl_NhomHang
if(OBJECT_ID('tbl_NhomHang','U') is not null)
begin
	drop table tbl_NhomHang
end
create table tbl_NhomHang
(
	PK_iNhomHangID int identity primary key,
	sTenNhomHang nvarchar(50) not null,
	sGhiChu nvarchar(100)
)
go

-----------Bang tbl_NhaSanXuat
if(OBJECT_ID('tbl_NhaSanXuat','U') is not null)
begin
	drop table tbl_NhaSanXuat
end
create table tbl_NhaSanXuat
(
	PK_sNhaSanXuatID varchar(6) primary key,
	sTenNhaSanXuat nvarchar(50) not null,
	sGhiChu nvarchar(100)
)
go


-----------Bang tbl_DonViTinh
if(OBJECT_ID('tbl_DonViTinh','U') is not null)
begin
	drop table tbl_DonViTinh
end
create table tbl_DonViTinh
(
	PK_iDonViTinhID int identity primary key,
	sTenDonViTinh nvarchar(45) not null,
	sGhiChu nvarchar(100)
)
go

-----------Bang tbl_HangHoa
if(OBJECT_ID('tbl_HangHoa','U') is not null)
begin
	drop table tbl_HangHoa
end
create table tbl_HangHoa
(
	PK_iHangHoaID int identity primary key,
	sTenHangHoa nvarchar(100) not null,
	iGiaMua int not null,
	iGiaBanBuon int not null,
	iGiaBanLe int not null,
	sNgayNhap varchar(10) not null,
	sNgayHetHan varchar(10) not null,
	sGhiChu nvarchar(200),
	iVAT int not null,
	FK_sDoiTacID varchar(6) references tbl_DoiTac(PK_sDoiTacID) not null,
	FK_sNhaSanXuatID varchar(6) references tbl_NhaSanXuat(PK_sNhaSanXuatID) not null,
	FK_iDonViTinhID int references tbl_DonViTinh(PK_iDonViTinhID) not null,
	FK_iNhomHangID int references tbl_NhomHang(PK_iNhomHangID) not null
)
go

-----------Bang tbl_PhieuNhapXuat
if(OBJECT_ID('tbl_PhieuNhapXuat','U') is not null)
begin
	drop table tbl_PhieuNhapXuat
end
create table tbl_PhieuNhapXuat
(
	PK_sPhieuNhapXuatID varchar(6) primary key,
	iTrangThaiID int not null,
	sNgayNhapXuat varchar(10) not null,
	sGioNhapXuat varchar(8) not null,
	FK_sNhanVienID varchar(6) references tbl_NhanVien(PK_sNhanVienID) not null,
	FK_sDoiTacID varchar(6) references tbl_DoiTac(PK_sDoiTacID) not null,
	iTongTien int not null,
	iConNo int not null,
	sGhiChu nvarchar(100)
)
go

-----------Bang tbl_ChiTietPhieuNhapXuat
if(OBJECT_ID('tbl_ChiTietPhieuNhapXuat','U') is not null)
begin
	drop table tbl_ChiTietPhieuNhapXuat
end
create table tbl_ChiTietPhieuNhapXuat
(
	FK_sPhieuNhapXuatID varchar(6) references tbl_PhieuNhapXuat(PK_sPhieuNhapXuatID) not null,
	FK_iHangHoaID int references tbl_HangHoa(PK_iHangHoaID) not null,
	iSoLuong int not null
	primary key(FK_sPhieuNhapXuatID, FK_iHangHoaID)
)
go

-----------Bang tbl_PhieuThuChi
if(OBJECT_ID('tbl_PhieuThuChi','U') is not null)
begin
	drop table tbl_PhieuThuChi
end
create table tbl_PhieuThuChi
(
	PK_sPhieuThuChiID varchar(6) primary key,
	iTrangThaiID int not null,
	sLyDo nvarchar(150) not null,
	sSoTien int not null,
	sNgayThuChi varchar(10) not null,
	sGioThuChi varchar(10) not null,
	sGhiChu nvarchar(150),
	FK_sNhanVienID varchar(6) references tbl_NhanVien(PK_sNhanVienID) not null,
	FK_sPhieuNhapXuatID varchar(6) references tbl_PhieuNhapXuat(PK_sPhieuNhapXuatID) not null,
	FK_sDoiTacID varchar(6) references tbl_DoiTac(PK_sDoiTacID) not null
)
go

-----------Bang tbl_TienTe
if(OBJECT_ID('tbl_TienTe','U') is not null)
begin
	drop table tbl_TienTe
end
create table tbl_TienTe
(
	PK_sTienTeID varchar(3) primary key,
	sTenTien nvarchar(20) not null,
	fMuaVao float not null,
	fBanRa float not null
)
go


-----------Bang tbl_ThongTinCongTy
if(OBJECT_ID('tbl_ThongTinCongTy','U') is not null)
begin
	drop table tbl_ThongTinCongTy
end
create table tbl_ThongTinCongTy
(
	PK_sCongTyID varchar(6) primary key,
	sTenCongTy nvarchar(100) not null,
	sDiaChi nvarchar(100),
	sSoDienThoai varchar(12),
	sEmail varchar(45),
	sWebsite varchar(45),
	FK_sTienTeID varchar(3) references tbl_TienTe(PK_sTienTeID) not null,
	iTienMat int
)
go


-- =============================================
-- Tao view
-- =============================================

