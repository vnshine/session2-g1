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
	sTenQuyenEng varchar(50) not null,
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
	sTenChucNang nvarchar(50) not null,
	sTenChucNangEng varchar(50) not null,
	sGhiChu varchar(100)
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
	sHoTenEng varchar(45),
	sSoDienThoai varchar(12) not null,
	sNgaySinh varchar(10) not null,
	bGioiTinh bit not null,
	sGhiChu nvarchar(100),
	FK_iQuyenID int references tbl_Quyen(PK_iQuyenID) not null,
	iTrangThai int
)
go
ALTER table tbl_NhanVien alter column FK_iQuyenID int null
ALTER table tbl_NhanVien drop column sNgaySinh
ALTER table tbl_NhanVien add dNgaySinh datetime
GO
-----------Bang tbl_NhanVien_Quyen
if(OBJECT_ID('tbl_NhanVien_Quyen','U') is not null)
begin
	drop table tbl_NhanVien_Quyen
end
create table tbl_NhanVien_Quyen
(
	FK_sNhanVienID varchar(6) references tbl_NhanVien(PK_sNhanVienID) not null,
	FK_iQuyenID int references tbl_Quyen(PK_iQuyenID) not null,
	primary key(FK_sNhanVienID, FK_iQuyenID)
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
	sTenDoiTacEng varchar(45) not null,
	sSoDienThoai varchar(15),
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
	sTenNhomHangEng varchar(50) not null,
	sGhiChu nvarchar(100),
	iTrangThai int default 1 --- Chu y: neu iTrangThai la 2 thi coi nhu nhom hang da bi xoa va ko cho show ra
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
	sTenNhaSanXuatEng varchar(50) not null,
	sGhiChu nvarchar(100),
	iTrangThai int
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
	sTenDonViTinhEng varchar(45) not null,
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
	sTenHangHoaEng varchar(100) not null,
	iDonGia float not null,
	sNgayNhap datetime not null,
	sGhiChu nvarchar(200),
	FK_sDoiTacID varchar(6) references tbl_DoiTac(PK_sDoiTacID) not null,
	FK_sNhaSanXuatID varchar(6) references tbl_NhaSanXuat(PK_sNhaSanXuatID) not null,
	FK_iDonViTinhID int references tbl_DonViTinh(PK_iDonViTinhID) not null,
	FK_iNhomHangID int references tbl_NhomHang(PK_iNhomHangID) not null,
	iTrangThai int,
	iSoLuong int default 0,
)
go

--Đặt lại giá trị của cột là null
--ALTER TABLE tbl_HangHoa alter column sNgayHetHan datetime NULL


-----------Bang tbl_PhieuNhapXuat
if(OBJECT_ID('tbl_PhieuNhapXuat','U') is not null)
begin
	drop table tbl_PhieuNhapXuat
end
create table tbl_PhieuNhapXuat
(
	PK_sPhieuNhapXuatID varchar(6) primary key,
	iTrangThai int default 0,
	dNgayNhapXuat datetime default(GETDATE()),
	FK_sNhanVienID varchar(6) references tbl_NhanVien(PK_sNhanVienID) not null,
	FK_sDoiTacID varchar(6) references tbl_DoiTac(PK_sDoiTacID) not null,
	fTongTien int,
	fConNo int,
	sGhiChu nvarchar(100)
)
GO
-----------Bang tbl_ChiTietPhieuNhapXuat
if(OBJECT_ID('tbl_ChiTietPhieuNhapXuat','U') is not null)
begin
	drop table tbl_ChiTietPhieuNhapXuat
end
create table tbl_ChiTietPhieuNhapXuat
(
	FK_sPhieuNhapXuatID varchar(6) references tbl_PhieuNhapXuat(PK_sPhieuNhapXuatID) not null,
	FK_iHangHoaID int references tbl_HangHoa(PK_iHangHoaID) not null,
	iSoLuong int not null,
	fGiaGoc float,
	fGiaBan float,
	primary key(FK_sPhieuNhapXuatID, FK_iHangHoaID),
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
	iTrangThai int not null,
	sLyDo nvarchar(150) not null,
	fSoTien float,
	sNgayThuChi datetime default(GETDATE()),
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
	sTenTienEng varchar(20) not null,
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
	PK_sCongTyID varchar(10) primary key,
	sTenCongTy nvarchar(100) not null,
	sTenCongTyEng varchar(100),
	sDiaChi nvarchar(100),
	sDiaChiEng varchar(100),
	sSoDienThoai varchar(15),
	sEmail varchar(45),
	sWebsite varchar(45),
	FK_sTienTeID varchar(3) references tbl_TienTe(PK_sTienTeID),
	fTienMat float
)
go

-- =============================================
-- Tao view
-- =============================================

