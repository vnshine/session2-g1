
--------------------------------
--Bảng Nhan Vien
--------------------------------


-----------Proc timmf nhan vien

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
if(OBJECT_ID('SEARCH_NHANVIEN','p') is not null)
begin
	drop proc  SEARCH_NHANVIEN
end
GO
CREATE PROCEDURE SEARCH_NHANVIEN
	@soTrang int ,
	@key varchar
AS
BEGIN
	SET @key = '%' + @key + '%'
	Select top
	((Select count(*) From
		(
		SELECT
		*
		FROM  dbo.tbl_NhanVien
		where  
		PK_sNhanVienID like @key or
		sHoTen like @key or
		sHoTenEng like @key or
		sSoDienThoai like @key or
		sNgaySinh like @key
		)ui
	) -(10*(@soTrang-1)))
	* From
	(select top (10*@soTrang) *
	from
	(SELECT top(Select count(*) From 
		(
		SELECT
		*
		FROM  dbo.tbl_NhanVien
		where  
		PK_sNhanVienID like @key or
		sHoTen like @key or
		sHoTenEng like @key or
		sSoDienThoai like @key or
		sNgaySinh like @key
		)uiq
	) * FROM 
		(
		SELECT
		*
		FROM  dbo.tbl_NhanVien
		where  
		PK_sNhanVienID like @key or
		sHoTen like @key or
		sHoTenEng like @key or
		sSoDienThoai like @key or
		sNgaySinh like @key
		)uio
	 order by PK_sNhanVienID ASC
	)a order by PK_sNhanVienID DESC
	) b	order by PK_sNhanVienID ASC
END
GO
	



-----------Proc Select số lượng Ket qua tim kiem
if(OBJECT_ID('SoLuong_KQ','t') is not null)
begin
	drop proc  SoLuong_KQ
end
GO
CREATE PROCEDURE SoLuong_KQ 
@key nvarchar
AS
BEGIN
	SET @key = '%' + @key + '%'
	Select count(*) From
		(
		SELECT
		*
		FROM  dbo.tbl_NhanVien
		where  
		PK_sNhanVienID like @key or
		sTenNhanVien like @key or
		sTenNhanVienEng like @key or
		sSoDienThoai like @key or
		sDiaChi like @key or
		sNguoiLienHe like @key or
		sGhiChu like @key
		)soluongkq
		/*
		Select count(*) From
		(
		SELECT
		*
		FROM  dbo.tbl_NhanVien
		where  
		PK_sNhanVienID like '%16%' or
		sTenNhanVien like '%16%' or
		sTenNhanVienEng like '%16%' or
		sSoDienThoai like '%16%' or
		sDiaChi like '%16%' or
		sNguoiLienHe like '%16%' or
		sGhiChu like '%16%'
		)soluongkq
		*/
END



-----------Proc thêm đối tác             
if(OBJECT_ID('sp_tblNhanVien_Insert','p') is not null)
begin
	drop proc  sp_tblNhanVien_Insert
end
GO

CREATE proc sp_tblNhanVien_Insert
	@PK_sNhanVienID varchar(6),
	@sTenNhanVien nvarchar(45),
	@sTenNhanVienEng varchar(45),
	@sSoDienThoai varchar(16),
	@sDiaChi nvarchar(100),
	@iTrangThai int,
	@sNguoiLienHe nvarchar(45),
	@sGhiChu nvarchar(100)
as
begin
	insert INTO tbl_NhanVien VALUES(@PK_sNhanVienID,
								  @sTenNhanVien,
								  @sTenNhanVienEng,
								  @sSoDienThoai,
								  @sDiaChi,
								  @iTrangThai,
								  @sNguoiLienHe,
								  @sGhiChu	
									)
end
go

-----------Proc sửa đối tác
if(OBJECT_ID('sp_tblNhanVien_Update','p') is not null)
begin
	drop proc  sp_tblNhanVien_Update
end
GO

CREATE proc sp_tblNhanVien_Update
	@PK_sNhanVienIDCu varchar(6),
	@PK_sNhanVienID varchar(6),
	@sTenNhanVien nvarchar(45),
	@sTenNhanVienEng varchar(45),
	@sSoDienThoai varchar(16),
	@sDiaChi nvarchar(100),
	@iTrangThai int,
	@sNguoiLienHe nvarchar(45),
	@sGhiChu nvarchar(100)
as
begin
	update tbl_NhanVien SET 
	  PK_sNhanVienID = @PK_sNhanVienID,
	  sTenNhanVien = @sTenNhanVien,
	  sTenNhanVienEng = @sTenNhanVienEng,
	  sSoDienThoai =@sSoDienThoai,
	  sDiaChi = @sDiaChi,
	  iTrangThai = @iTrangThai,
	  sNguoiLienHe = @sNguoiLienHe,
	  sGhiChu = @sGhiChu
	where PK_sNhanVienID = @PK_sNhanVienIDCu
end
go


-----------Proc xóa đối tác
if(OBJECT_ID('sp_tblNhanVien_Delete','p') is not null)
begin
	drop proc  sp_tblNhanVien_Delete
end
GO

CREATE proc sp_tblNhanVien_Delete
	@PK_sNhanVienIDCu varchar(6)
as
begin
	Delete FROM [NhatQuang].[dbo].[tbl_NhanVien] WHERE PK_sNhanVienID = @PK_sNhanVienIDCu
end
go


-----------Proc kiểm tra có tồn tại ID
if(OBJECT_ID('sp_tblNhanVien_duplicate','p') is not null)
begin
	drop proc  sp_tblNhanVien_duplicate
end
GO

CREATE proc sp_tblNhanVien_duplicate
	@PK_sNhanVienIDCu varchar(6)
as
begin
	Select count(*) from (select * FROM tbl_NhanVien WHERE PK_sNhanVienID = @PK_sNhanVienIDCu)dup
end
go

-----------Proc lay danh sach

GO
if(OBJECT_ID('DanhSach_NhanVien','p') is not null)
begin
	drop proc  DanhSach_NhanVien
end
GO
CREATE PROCEDURE DanhSach_NhanVien 
	@soTrang int
AS
BEGIN
	select * from (
	select top ((
				Select count(*) from (SELECT top (10*@soTrang) *
				FROM [NhatQuang].[dbo].[tbl_NhanVien])d
				)-(10*(@soTrang-1)))
	*from (		
	select top (10*@soTrang) *
	from [NhatQuang].[dbo].[tbl_NhanVien] order by PK_sNhanVienID ASC
	) a	order by PK_sNhanVienID DESC
	) b	order by PK_sNhanVienID ASC
		
END

GO


-----------Proc Select số lượng đối tác
if(OBJECT_ID('SoLuong_NhanVien','p') is not null)
begin
	drop proc  SoLuong_NhanVien
end
GO
CREATE PROCEDURE SoLuong_NhanVien 
AS
BEGIN
	Select count(*) FROM [NhatQuang].[dbo].[tbl_NhanVien]
END

GO

-----------Proc Select tu khoa goi y Ket qua tim kiem
if(OBJECT_ID('SuggestData','p') is not null)
begin
	drop proc  SuggestData
end
GO
CREATE PROCEDURE SuggestData 
@key nvarchar
AS
BEGIN
	SET @key = @key + '%'
	Select top 5 * FROM (SELECT * FROM [NhatQuang].[dbo].[tbl_NhanVien] WHERE 
												PK_sNhanVienID like @key or
												sTenNhanVien like @key
												)kqt
END

GO
--SELECT * FROM [NhatQuang].[dbo].[tbl_NhanVien] WHERE sDiaChi like N'40 cao%'

--SELECT * FROM [NhatQuang].[dbo].[tbl_NhanVien] WHERE MATCH(sTenNhanVienEng) AGAINST('tho')


