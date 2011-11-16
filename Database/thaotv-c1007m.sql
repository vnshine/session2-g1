USE NhatQuang
GO
--------------------------------
--Bảng đối tác
--------------------------------


-----------Proc timmf đối tác

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
if(OBJECT_ID('SEARCH_DOITAC','p') is not null)
begin
	drop proc  SEARCH_DOITAC
end
GO
CREATE PROCEDURE SEARCH_DOITAC
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
		FROM  dbo.tbl_DoiTac
		where  
		PK_sDoiTacID like @key or
		sTenDoiTac like @key or
		sTenDoiTacEng like @key or
		sSoDienThoai like @key or
		sDiaChi like @key or
		sNguoiLienHe like @key or
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
		FROM  dbo.tbl_DoiTac
		where  
		PK_sDoiTacID like @key or
		sTenDoiTac like @key or
		sTenDoiTacEng like @key or
		sSoDienThoai like @key or
		sDiaChi like @key or
		sNguoiLienHe like @key or
		sGhiChu like @key
		)uiq
	) * FROM 
		(
		SELECT
		*
		FROM  dbo.tbl_DoiTac
		where  
		PK_sDoiTacID like @key or
		sTenDoiTac like @key or
		sTenDoiTacEng like @key or
		sSoDienThoai like @key or
		sDiaChi like @key or
		sNguoiLienHe like @key or
		sGhiChu like @key
		)uio
	 order by PK_sDoiTacID ASC
	)a order by PK_sDoiTacID DESC
	) b	order by PK_sDoiTacID ASC
END
GO
	/*
	Select top
	((Select count(*) From
		(
		SELECT
		*
		FROM  dbo.tbl_DoiTac
		where  
		PK_sDoiTacID like '%lovan%' or
		sTenDoiTac like '%lovan%' or
		sTenDoiTacEng like '%lovan%' or
		sSoDienThoai like '%lovan%' or
		sDiaChi like '%lovan%' or
		sNguoiLienHe like '%lovan%' or
		sGhiChu like '%lovan%'
		)ui
	) -(10*(1-1)))
	* From
	(select top (10*1) *
	from
	(SELECT top(Select count(*) From 
		(
		SELECT
		*
		FROM  dbo.tbl_DoiTac
		where  
		PK_sDoiTacID like '%lovan%' or
		sTenDoiTac like '%lovan%' or
		sTenDoiTacEng like '%lovan%' or
		sSoDienThoai like '%lovan%' or
		sDiaChi like '%lovan%' or
		sNguoiLienHe like '%lovan%' or
		sGhiChu like '%lovan%'
		)uiq
	) * FROM 
		(
		SELECT
		*
		FROM  dbo.tbl_DoiTac
		where  
		PK_sDoiTacID like '%lovan%' or
		sTenDoiTac like '%lovan%' or
		sTenDoiTacEng like '%lovan%' or
		sSoDienThoai like '%lovan%' or
		sDiaChi like '%lovan%' or
		sNguoiLienHe like '%lovan%' or
		sGhiChu like '%lovan%'
		)uio
	 order by PK_sDoiTacID ASC
	)a order by PK_sDoiTacID DESC
	) b	order by PK_sDoiTacID ASC
	*/



-----------Proc Select số lượng Ket qua tim kiem
if(OBJECT_ID('SoLuong_KQ','t') is not null)
begin
	drop proc  SoLuong_KQ
end
GO
CREATE PROCEDURE SoLuong_KQ 
@key nvarchar(200)
AS
BEGIN
	SET @key = '%' + @key + '%';
	Select count(*) From
		(
		SELECT
		*
		FROM  dbo.tbl_DoiTac
		where  
		PK_sDoiTacID like @key or
		sTenDoiTac like @key or
		sTenDoiTacEng like @key or
		sSoDienThoai like @key or
		sDiaChi like @key or
		sNguoiLienHe like @key or
		sGhiChu like @key
		)soluongkq
END



-----------Proc thêm đối tác             
if(OBJECT_ID('sp_tblDoiTac_Insert','p') is not null)
begin
	drop proc  sp_tblDoiTac_Insert
end
GO

CREATE proc sp_tblDoiTac_Insert
	@PK_sDoiTacID varchar(6),
	@sTenDoiTac nvarchar(45),
	@sTenDoiTacEng varchar(45),
	@sSoDienThoai varchar(16),
	@sDiaChi nvarchar(100),
	@iTrangThai int,
	@sNguoiLienHe nvarchar(45),
	@sGhiChu nvarchar(100)
as
begin
	insert INTO tbl_DoiTac VALUES(@PK_sDoiTacID,
								  @sTenDoiTac,
								  @sTenDoiTacEng,
								  @sSoDienThoai,
								  @sDiaChi,
								  @iTrangThai,
								  @sNguoiLienHe,
								  @sGhiChu	
									)
end
go

-----------Proc sửa đối tác
if(OBJECT_ID('sp_tblDoiTac_Update','p') is not null)
begin
	drop proc  sp_tblDoiTac_Update
end
GO

CREATE proc sp_tblDoiTac_Update
	@PK_sDoiTacIDCu varchar(6),
	@PK_sDoiTacID varchar(6),
	@sTenDoiTac nvarchar(45),
	@sTenDoiTacEng varchar(45),
	@sSoDienThoai varchar(16),
	@sDiaChi nvarchar(100),
	@iTrangThai int,
	@sNguoiLienHe nvarchar(45),
	@sGhiChu nvarchar(100)
as
begin
	update tbl_DoiTac SET 
	  PK_sDoiTacID = @PK_sDoiTacID,
	  sTenDoiTac = @sTenDoiTac,
	  sTenDoiTacEng = @sTenDoiTacEng,
	  sSoDienThoai =@sSoDienThoai,
	  sDiaChi = @sDiaChi,
	  iTrangThai = @iTrangThai,
	  sNguoiLienHe = @sNguoiLienHe,
	  sGhiChu = @sGhiChu
	where PK_sDoiTacID = @PK_sDoiTacIDCu
end
go


-----------Proc xóa đối tác
if(OBJECT_ID('sp_tblDoiTac_Delete','p') is not null)
begin
	drop proc  sp_tblDoiTac_Delete
end
GO

CREATE proc sp_tblDoiTac_Delete
	@PK_sDoiTacIDCu varchar(6)
as
begin
	Delete FROM [NhatQuang].[dbo].[tbl_DoiTac] WHERE PK_sDoiTacID = @PK_sDoiTacIDCu
end
go


-----------Proc kiểm tra có tồn tại ID
if(OBJECT_ID('sp_tblDoiTac_duplicate','p') is not null)
begin
	drop proc  sp_tblDoiTac_duplicate
end
GO

CREATE proc sp_tblDoiTac_duplicate
	@PK_sDoiTacIDCu varchar(6)
as
begin
	Select count(*) from (select * FROM tbl_DoiTac WHERE PK_sDoiTacID = @PK_sDoiTacIDCu)dup
end
go

-----------Proc lay danh sach

GO
if(OBJECT_ID('DanhSach_DoiTac','p') is not null)
begin
	drop proc  DanhSach_DoiTac
end
GO
CREATE PROCEDURE DanhSach_DoiTac 
	@soTrang int
AS
BEGIN
	select * from (
	select top ((
				Select count(*) from (SELECT top (10*@soTrang) *
				FROM [NhatQuang].[dbo].[tbl_DoiTac])d
				)-(10*(@soTrang-1)))
	*from (		
	select top (10*@soTrang) *
	from [NhatQuang].[dbo].[tbl_DoiTac] order by PK_sDoiTacID ASC
	) a	order by PK_sDoiTacID DESC
	) b	order by PK_sDoiTacID ASC
		
END

GO


-----------Proc Select số lượng đối tác
if(OBJECT_ID('SoLuong_DoiTac','p') is not null)
begin
	drop proc  SoLuong_DoiTac
end
GO
CREATE PROCEDURE SoLuong_DoiTac 
AS
BEGIN
	Select count(*) FROM [NhatQuang].[dbo].[tbl_DoiTac]
END

GO

-----------Proc Select tu khoa goi y Ket qua tim kiem
if(OBJECT_ID('SuggestData','p') is not null)
begin
	drop proc  SuggestData
end
GO
CREATE PROCEDURE SuggestData 
@key nvarchar(200)
AS
BEGIN
	SET @key = @key + '%';
	Select top 5 * FROM (SELECT * FROM [NhatQuang].[dbo].[tbl_DoiTac] WHERE 
												PK_sDoiTacID like @key or
												sTenDoiTac like @key or
												sTenDoiTacEng like @key
												)kqt
END

GO