
-----------Proc kiểm tra đăng nhập
if(OBJECT_ID('sp_tblNhanVien_Login','p') is not null)
begin
	drop proc  sp_tblNhanVien_Login
end
GO

CREATE proc sp_tblNhanVien_Login
	@MaNhanVien varchar(6),
	@MatKhau varchar(50)
as
begin
	select * FROM tbl_NhanVien WHERE PK_sNhanVienID = @MaNhanVien AND sMatKhau = @MatKhau
end
go

--------------------------------
--Bảng chức năng
--------------------------------

-----------Proc Select danh sách các chức năng
if(OBJECT_ID('sp_tblChucNang_Select','p') is not null)
begin
	drop proc  sp_tblChucNang_Select
end
GO

CREATE proc sp_tblChucNang_Select
as
begin
	select * FROM tbl_ChucNang
end
go


-----------Proc Select danh sách các chức năng
if(OBJECT_ID('sp_tblChucNang_Find','p') is not null)
begin
	drop proc  sp_tblChucNang_Find
end
GO

CREATE proc sp_tblChucNang_Find
	@id varchar(15),
	@ten varchar(50),
	@ghichu varchar(100)
as
begin
	select * FROM tbl_ChucNang WHERE PK_sChucNangID LIKE '%' + @id + '%' OR sTenChucNang LIKE '%' + @ten + '%' OR sGhiChu LIKE '%' + @ghichu + '%'
end
go



-----------Proc thêm chức năng
if(OBJECT_ID('sp_tblChucNang_Insert','p') is not null)
begin
	drop proc  sp_tblChucNang_Insert
end
GO

CREATE proc sp_tblChucNang_Insert
	@id varchar(15),
	@ten varchar(50),
	@tenEng varchar(50),
	@ghichu varchar(100)
as
begin
	insert INTO tbl_ChucNang VALUES(@id, @ten, @tenEng, @ghichu)
end
go

-----------Proc sửa chức năng
if(OBJECT_ID('sp_tblChucNang_Update','p') is not null)
begin
	drop proc  sp_tblChucNang_Update
end
GO

CREATE proc sp_tblChucNang_Update
	@old_id varchar(15),
	@new_id varchar(15),
	@ten varchar(50),
	@ghichu varchar(100)
as
begin
	update tbl_ChucNang SET PK_sChucNangID = @new_id, sTenChucNang = @ten, sGhiChu = @ghichu WHERE PK_sChucNangID = @old_id
end
go


-----------Proc xóa chức năng
if(OBJECT_ID('sp_tblChucNang_Delete','p') is not null)
begin
	drop proc  sp_tblChucNang_Delete
end
GO

CREATE proc sp_tblChucNang_Delete
	@id varchar(15)
as
begin
	Delete FROM tbl_ChucNang WHERE PK_sChucNangID = @id
end
go


-----------Proc kiểm tra có tồn tại ID
if(OBJECT_ID('sp_tblChucNang_duplicate','p') is not null)
begin
	drop proc  sp_tblChucNang_duplicate
end
GO

CREATE proc sp_tblChucNang_duplicate
	@id varchar(15),
	@ten varchar(50)
as
begin
	select * FROM tbl_ChucNang WHERE PK_sChucNangID = @id OR sTenChucNang = @ten
end
go


--------------------------------
--Bảng Quyền
--------------------------------

-----------Proc Select danh sách các quyền
if(OBJECT_ID('sp_tblQuyen_Select','p') is not null)
begin
	drop proc  sp_tblQuyen_Select
end
GO

CREATE proc sp_tblQuyen_Select
as
begin
	select * FROM tbl_Quyen
end
go


-----------Proc tìm kiếm quyền
if(OBJECT_ID('sp_tblQuyen_Find','p') is not null)
begin
	drop proc  sp_tblQuyen_Find
end
GO

CREATE proc sp_tblQuyen_Find
	@ten nvarchar(50),
	@ghichu nvarchar(100)
as
begin
	IF (@ghichu = '')
		begin
			print 'ghi chu null'
			select * FROM tbl_Quyen WHERE sTenQuyen LIKE '%' + @ten + '%'
		end
	ELSE
		begin
			print 'ghi chu not null'
			select * FROM tbl_Quyen WHERE sTenQuyen LIKE '%' + @ten + '%' OR sGhiChu LIKE '%' + @ghichu + '%'
		end
end
go



-----------Proc thêm quyền
if(OBJECT_ID('sp_tblQuyen_Insert','p') is not null)
begin
	drop proc  sp_tblQuyen_Insert
end
GO

CREATE proc sp_tblQuyen_Insert
	@ten nvarchar(50),
	@ghichu nvarchar(100)
as
begin
	insert INTO tbl_Quyen(sTenQuyen, sGhiChu) VALUES(@ten, @ghichu)
end
go

-----------Proc sửa quyền
if(OBJECT_ID('sp_tblQuyen_Update','p') is not null)
begin
	drop proc  sp_tblQuyen_Update
end
GO

CREATE proc sp_tblQuyen_Update
	@old_name nvarchar(50),
	@ten nvarchar(50),
	@ghichu nvarchar(100)
as
begin
	update tbl_Quyen SET sTenQuyen = @ten, sGhiChu = @ghichu WHERE sTenQuyen = @old_name
end
go


-----------Proc xóa quyền
if(OBJECT_ID('sp_tblQuyen_Delete','p') is not null)
begin
	drop proc  sp_tblQuyen_Delete
end
GO

CREATE proc sp_tblQuyen_Delete
	@name nvarchar(50)
as
begin
	Delete FROM tbl_Quyen WHERE sTenQuyen = @name
end
go


-----------Proc kiểm tra có tồn tại ID
if(OBJECT_ID('sp_tblQuyen_duplicate','p') is not null)
begin
	drop proc  sp_tblQuyen_duplicate
end
GO

CREATE proc sp_tblQuyen_duplicate
	@ten varchar(50)
as
begin
	select * FROM tbl_Quyen WHERE sTenQuyen = @ten
end
go

--------------------------------
--Phân quyền
--------------------------------

--Phân trang thông tin rút gọn nhân viên
if(OBJECT_ID('sp_tblNhanVien_FindRutGon','p') is not null)
begin
	drop proc  sp_tblNhanVien_FindRutGon
end
GO
CREATE proc sp_tblNhanVien_FindRutGon
	@iSoTrang int,
	@sNhanVienID varchar(6),
	@sHoTenEng varchar(50),
	@sSoDienThoai varchar(13),
	@bGioiTinh bit
as
	begin
		DECLARE @iSoBanGhi int = 5
		SELECT TOP (@iSoBanGhi) * FROM (SELECT TOP ((@iSoBanGhi) * @iSoTrang) PK_sNhanVienID, sHoTen, sSoDienThoai, bGioiTinh FROM tbl_NhanVien WHERE PK_sNhanVienID LIKE '%' + @sNhanVienID + '%' and sSoDienThoai LIKE '%' + @sSoDienThoai + '%' AND bGioiTinh = 1 AND sHoTenEng LIKE '%' + @sHoTenEng + '%' ORDER BY PK_sNhanVienID DESC) c ORDER BY PK_sNhanVienID DESC
	END

SELECT * FROM tbl_NhanVien ORDER BY PK_sNhanVienID DESC
EXEC sp_tblNhanVien_FindRutGon 3,'','','',1


--+++++++++++++++++++++++++++++++
--------------------------------+
--Thêm cơ sở dữ liệu            +
--------------------------------+
--+++++++++++++++++++++++++++++++


--------------------------------
--Bảng quyền
--------------------------------

INSERT INTO tbl_Quyen(sTenQuyen,sTenQuyenEng,sGhiChu) VALUES(N'Quản trị', 'QUANTRI', N'Quản trị hệ thống')
--------------------------------
--Bảng nhân viên
--------------------------------
INSERT INTO tbl_Quyen (sTenQuyen,sTenQuyenEng,sGhiChu) values(N'Quản trị','QUANTRI',N'Quản trị hệ thống')
INSERT INTO tbl_Quyen (sTenQuyen,sTenQuyenEng,sGhiChu) values(N'Bán hàng','BANHANG',N'')
INSERT INTO tbl_Quyen (sTenQuyen,sTenQuyenEng,sGhiChu) values(N'Thủ kho','THUKHO',N'')


INSERT INTO tbl_NhanVien values('NV0001','8359a83a944fbaf05f5e94ca606ba264',N'Quang Liem','QUANGLIEM', '0989320758','05/02/1990','1','',2)
INSERT INTO tbl_NhanVien values('NV0002','735e679351d2d7331c32b26d7f90bfbf',N'Bui Minh', 'BUIMINH','0989320758','05/02/1990','1','',2)
INSERT INTO tbl_NhanVien values('NV0003','7fdf435d494afa9f83342ee571c326ee',N'Trong Ninh', 'TRONGNINH', '0989320758','05/02/1990','1','',2)
INSERT INTO tbl_NhanVien values('NV0004','96b1c8f7cb0b3177f2fa570e10dd3110',N'Hoang Anh', 'HOANGANH', '0989320758','05/02/1990','1','',3)
INSERT INTO tbl_NhanVien values('NV0005','8359a83a944fbaf05f5e94ca606ba264',N'Quang Liem','QUANGLIEM', '0989320758','05/02/1990','1','',2)
INSERT INTO tbl_NhanVien values('NV0006','735e679351d2d7331c32b26d7f90bfbf',N'Bui Minh', 'BUIMINH','0989320758','05/02/1990','1','',2)
INSERT INTO tbl_NhanVien values('NV0007','7fdf435d494afa9f83342ee571c326ee',N'Trong Ninh', 'TRONGNINH', '0989320758','05/02/1990','1','',2)
INSERT INTO tbl_NhanVien values('NV0008','96b1c8f7cb0b3177f2fa570e10dd3110',N'Hoang Anh', 'HOANGANH', '0989320758','05/02/1990','1','',3)
INSERT INTO tbl_NhanVien values('NV0009','8359a83a944fbaf05f5e94ca606ba264',N'Quang Liem','QUANGLIEM', '0989320758','05/02/1990','1','',2)
INSERT INTO tbl_NhanVien values('NV0010','735e679351d2d7331c32b26d7f90bfbf',N'Bui Minh', 'BUIMINH','0989320758','05/02/1990','1','',2)
INSERT INTO tbl_NhanVien values('NV0011','7fdf435d494afa9f83342ee571c326ee',N'Trong Ninh', 'TRONGNINH', '0989320758','05/02/1990','1','',2)
INSERT INTO tbl_NhanVien values('NV0012','96b1c8f7cb0b3177f2fa570e10dd3110',N'Hoang Anh', 'HOANGANH', '0989320758','05/02/1990','1','',3)

--UPDATE tbl_NhanVien SET sMatKhau = '73acd9a5972130b75066c82595a1fae3' WHERE PK_sNhanVienID = 'NV0001'

--exec sp_tblNhanVien_Login 'NV0001', 'admin'


-- 