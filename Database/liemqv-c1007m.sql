
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
	@ghichu varchar(100)
as
begin
	insert INTO tbl_ChucNang VALUES(@id, @ten, @ghichu)
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


--+++++++++++++++++++++++++++++++
--------------------------------+
--Thêm cơ sở dữ liệu            +
--------------------------------+
--+++++++++++++++++++++++++++++++


--------------------------------
--Bảng quyền
--------------------------------

INSERT INTO tbl_Quyen(sTenQuyen,sGhiChu) VALUES(N'Quản trị', N'Quản trị hệ thống')
--------------------------------
--Bảng nhân viên
--------------------------------

INSERT INTO tbl_NhanVien values('NV0001','nv001',N'Quang Liem', '0989320758','05/02/1990','1','',1)

UPDATE tbl_NhanVien SET sMatKhau = '73acd9a5972130b75066c82595a1fae3' WHERE PK_sNhanVienID = 'NV0001'

exec sp_tblNhanVien_Login 'NV0001', 'admin'