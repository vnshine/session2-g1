
--------------------------------
--Bảng NhaSanXuat
--------------------------------


-----------Proc thêm NhaSanXuat             
if(OBJECT_ID('sp_tblNhaSanXuat_Insert','p') is not null)
begin
	drop proc  sp_tblNhaSanXuat_Insert
end
GO

CREATE proc sp_tblNhaSanXuat_Insert
	@sTenNhaSanXuat varchar(50),
	@sTenNhaSanXuatEng nvarchar(50),
	@sGhiChu nvarchar(100)
as
begin
	insert INTO tbl_NhaSanXuat VALUES(@sTenNhaSanXuat,@sTenNhaSanXuatEng,@sGhiChu,1)
end
go

-----------Proc sửa NhaSanXuat
if(OBJECT_ID('sp_tblNhaSanXuat_Update','p') is not null)
begin
	drop proc  sp_tblNhaSanXuat_Update
end
GO

CREATE proc sp_tblNhaSanXuat_Update
	@PK_iNhaSanXuatID int,
	@sTenNhaSanXuat varchar(50),
	@sTenNhaSanXuatEng nvarchar(50),
	@sGhiChu nvarchar(100)
as
begin
	update tbl_NhaSanXuat SET 
	  sTenNhaSanXuat = @sTenNhaSanXuat,
	  sTenNhaSanXuatEng = @sTenNhaSanXuatEng,
	  sGhiChu = @sGhiChu
	where PK_iNhaSanXuatID = @PK_iNhaSanXuatID
end
go

-----------Proc xóa NhaSanXuat
if(OBJECT_ID('sp_tblNhaSanXuat_Delete','p') is not null)
begin
	drop proc  sp_tblNhaSanXuat_Delete
end
GO

CREATE proc sp_tblNhaSanXuat_Delete
	@PK_iNhaSanXuatID int
as
begin
	update tbl_NhaSanXuat SET iTrangThai = 2 where PK_iNhaSanXuatID = @PK_iNhaSanXuatID
end
go


-----------Proc kiểm tra có tồn tại NhaSanXuat
if(OBJECT_ID('sp_tblNhaSanXuat_duplicate','p') is not null)
begin
	drop proc  sp_tblNhaSanXuat_duplicate
end
GO

CREATE proc sp_tblNhaSanXuat_duplicate
	@sTenNhaSanXuat varchar(50)
as
begin
	Select count(*) from (select * FROM tbl_NhaSanXuat WHERE sTenNhaSanXuat = @sTenNhaSanXuat and iTrangThai = 1)dupli
end
go


-----------Proc kiểm tra có tồn tại NhaSanXuat (da sua)
if(OBJECT_ID('sp_tblNhaSanXuat_duplicate2','p') is not null)
begin
	drop proc  sp_tblNhaSanXuat_duplicate2
end
GO

CREATE proc sp_tblNhaSanXuat_duplicate2
	@sTenNhaSanXuat varchar(50),
	@sTenNhaSanXuat2 varchar(50)
as
begin
	Select count(*) from (select * FROM tbl_NhaSanXuat WHERE sTenNhaSanXuat = @sTenNhaSanXuat2 and iTrangThai = 1 and sTenNhaSanXuat <> @sTenNhaSanXuat)dupli2
end
go

-----------Proc lay danh sach

GO
if(OBJECT_ID('DanhSach_NhaSanXuat','p') is not null)
begin
	drop proc  DanhSach_NhaSanXuat
end
GO
CREATE PROCEDURE DanhSach_NhaSanXuat 
	@soTrang int
AS
BEGIN
	select * from (
	select top ((
				Select count(*) from (SELECT top (10*@soTrang) *
				FROM [NhatQuang].[dbo].[tbl_NhaSanXuat] where iTrangThai<2)d
				)-(10*(@soTrang-1)))
	*from (		
	select top (10*@soTrang) *
	from [NhatQuang].[dbo].[tbl_NhaSanXuat] where iTrangThai<2 order by PK_sNhaSanXuatID ASC
	) a	order by PK_sNhaSanXuatID DESC
	) b	order by PK_sNhaSanXuatID ASC
		
END

GO


-----------Proc Select số lượng NhaSanXuat
if(OBJECT_ID('SoLuong_NhaSanXuat','p') is not null)
begin
	drop proc  SoLuong_NhaSanXuat
end
GO
CREATE PROCEDURE SoLuong_NhaSanXuat 
AS
BEGIN
	Select count(*) FROM [NhatQuang].[dbo].[tbl_NhaSanXuat] where iTrangThai <2
END

GO
