
--------------------------------
--Bảng Nhom Hang
--------------------------------


-----------Proc tim nhom hang

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
if(OBJECT_ID('SEARCH_NhomHang','p') is not null)
begin
	drop proc  SEARCH_NhomHang
end
GO
CREATE PROCEDURE SEARCH_NhomHang
	@soTrang int ,
	@key nvarchar(200)
AS
BEGIN
	SET @key = '%' + @key + '%';
	Select top
	((Select count(*) From
		(
		SELECT
		*
		FROM  dbo.tbl_NhomHang
		where  
		sTenNhomHang like @key or
		sTenNhomHangEng like @key or
		sGhiChu like @key
		)ui
	) -(10*(@soTrang-1)))
	* From
	(select top (10*@soTrang) *
	from
	(SELECT top(Select count(*) From 
		(
		SELECT
		*
		FROM  dbo.tbl_NhomHang
		where  
		sTenNhomHang like @key or
		sTenNhomHangEng like @key or
		sGhiChu like @key
		)uiq
	) * FROM 
		(
		SELECT
		*
		FROM  dbo.tbl_NhomHang
		where  
		sTenNhomHang like @key or
		sTenNhomHangEng like @key or
		sGhiChu like @key
		)uio
	 order by PK_iNhomHangID ASC
	)a order by PK_iNhomHangID DESC
	) b	order by PK_iNhomHangID ASC
END
GO

-----------Proc Select số lượng Ket qua tim kiem
if(OBJECT_ID('SoLuong_KQ_NhomHang','t') is not null)
begin
	drop proc  SoLuong_KQ_NhomHang
end
GO
CREATE PROCEDURE SoLuong_KQ_NhomHang 
@key nvarchar(200)
AS
BEGIN
	SET @key = '%' + @key + '%';
	Select count(*) From
		(
		SELECT
		*
		FROM  dbo.tbl_NhomHang
		where  
		sTenNhomHang like @key or
		sTenNhomHangEng like @key or
		sGhiChu like @key
		)soluongkq
END



-----------Proc thêm nhom hang             
if(OBJECT_ID('sp_tblNhomHang_Insert','p') is not null)
begin
	drop proc  sp_tblNhomHang_Insert
end
GO

CREATE proc sp_tblNhomHang_Insert
	@sTenNhomHang varchar(50),
	@sTenNhomHangEng nvarchar(50),
	@sGhiChu nvarchar(100)
as
begin
	insert INTO tbl_NhomHang VALUES(@sTenNhomHang,@sTenNhomHangEng,@sGhiChu	)
end
go

-----------Proc sửa nhom hang
if(OBJECT_ID('sp_tblNhomHang_Update','p') is not null)
begin
	drop proc  sp_tblNhomHang_Update
end
GO

CREATE proc sp_tblNhomHang_Update
	@PK_iNhomHangID int,
	@sTenNhomHang varchar(50),
	@sTenNhomHangEng nvarchar(50),
	@sGhiChu nvarchar(100)
as
begin
	update tbl_NhomHang SET 
	  sTenNhomHang = @sTenNhomHang,
	  sTenNhomHangEng = @sTenNhomHangEng,
	  sGhiChu = @sGhiChu
	where PK_iNhomHangID = @PK_iNhomHangID
end
go


-----------Proc xóa Nhom Hang
if(OBJECT_ID('sp_tblNhomHang_Delete','p') is not null)
begin
	drop proc  sp_tblNhomHang_Delete
end
GO

CREATE proc sp_tblNhomHang_Delete
	@PK_iNhomHangID int
as
begin
	Delete FROM [NhatQuang].[dbo].[tbl_NhomHang] WHERE PK_iNhomHangID = @PK_iNhomHangID
end
go


-----------Proc kiểm tra có tồn tại nhom hang
if(OBJECT_ID('sp_tblNhomHang_duplicate','p') is not null)
begin
	drop proc  sp_tblNhomHang_duplicate
end
GO

CREATE proc sp_tblNhomHang_duplicate
	@sTenNhomHang varchar(6)
as
begin
	Select count(*) from (select * FROM tbl_NhomHang WHERE sTenNhomHang = @sTenNhomHang)dupli
end
go

-----------Proc lay danh sach

GO
if(OBJECT_ID('DanhSach_NhomHang','p') is not null)
begin
	drop proc  DanhSach_NhomHang
end
GO
CREATE PROCEDURE DanhSach_NhomHang 
	@soTrang int
AS
BEGIN
	select * from (
	select top ((
				Select count(*) from (SELECT top (10*@soTrang) *
				FROM [NhatQuang].[dbo].[tbl_NhomHang])d
				)-(10*(@soTrang-1)))
	*from (		
	select top (10*@soTrang) *
	from [NhatQuang].[dbo].[tbl_NhomHang] order by PK_iNhomHangID ASC
	) a	order by PK_iNhomHangID DESC
	) b	order by PK_iNhomHangID ASC
		
END

GO


-----------Proc Select số lượng nhom hang
if(OBJECT_ID('SoLuong_NhomHang','p') is not null)
begin
	drop proc  SoLuong_NhomHang
end
GO
CREATE PROCEDURE SoLuong_NhomHang 
AS
BEGIN
	Select count(*) FROM [NhatQuang].[dbo].[tbl_NhomHang]
END

GO

-----------Proc Select tu khoa goi y Ket qua tim kiem
if(OBJECT_ID('SuggestData_NhomHang','p') is not null)
begin
	drop proc  SuggestData_NhomHang
end
GO
CREATE PROCEDURE SuggestData_NhomHang 
@key nvarchar(200)
AS
BEGIN
	SET @key = @key + '%';
	Select top 5 * FROM (SELECT * FROM [NhatQuang].[dbo].[tbl_NhomHang] WHERE 
												sTenNhomHang like @key or
												sTenNhomHangEng like @key or
												sGhiChu like @key
												)kqt
END

GO