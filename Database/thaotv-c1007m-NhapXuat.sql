


use NhatQuang
--------------------------------
--Bảng Nhap Xuat
--------------------------------


if(OBJECT_ID('DanhSach_HangHoa','p') is not null)
begin
	drop proc  DanhSach_HangHoa
end
GO
CREATE PROCEDURE DanhSach_HangHoa 
	@soTrang int
AS
BEGIN
	select * from (
	select top ((
				Select count(*) from (SELECT top (10*@soTrang) *
				FROM [NhatQuang].[dbo].[tbl_HangHoa] where iTrangThai<2)d
				)-(10*(@soTrang-1)))
	*from (		
	select top (10*@soTrang) *
	from (  SELECT    tbl_HangHoa.*, tbl_HangHoa.sTenHangHoa, tbl_NhaSanXuat.sTenNhaSanXuat, tbl_DonViTinh.sTenDonViTinh, tbl_NhomHang.sTenNhomHang
			FROM      tbl_HangHoa INNER JOIN
                      tbl_HangHoa ON tbl_HangHoa.FK_sHangHoaID = tbl_HangHoa.PK_sHangHoaID INNER JOIN
                      tbl_NhaSanXuat ON tbl_HangHoa.FK_sNhaSanXuatID = tbl_NhaSanXuat.PK_sNhaSanXuatID INNER JOIN
                      tbl_DonViTinh ON tbl_HangHoa.FK_iDonViTinhID = tbl_DonViTinh.PK_iDonViTinhID INNER JOIN
                      tbl_NhomHang ON tbl_HangHoa.FK_iNhomHangID = tbl_NhomHang.PK_iNhomHangID
			WHERE tbl_HangHoa.iTrangThai <2
)joined2 order by PK_iHangHoaID ASC
	) a	order by PK_iHangHoaID DESC
	) b	order by PK_iHangHoaID ASC
		
END

GO


-----------Proc Select số lượng Nhap Xuat
if(OBJECT_ID('SoLuong_HangHoa','p') is not null)
begin
	drop proc  SoLuong_HangHoa
end
GO
CREATE PROCEDURE SoLuong_HangHoa 
AS
BEGIN
	Select count(*) FROM [NhatQuang].[dbo].[tbl_HangHoa] where iTrangThai <2
END

GO

----------Proc tim kiem

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
if(OBJECT_ID('SEARCH_HangHoa','p2') is not null)
begin
	drop proc  SEARCH_HangHoa
end
GO
CREATE PROCEDURE SEARCH_HangHoa
	@soTrang int ,
	@key nvarchar(200)
AS
BEGIN
	BEGIN TRANSACTION;
	BEGIN TRY
		DECLARE @Sql varchar(1000);
		DECLARE @Min varchar(3);
		DECLARE @Max varchar(3);
		DECLARE @cId varchar(3);
		SET @cId = CAST(@ComId AS varchar(3));
		SET @Min = CAST((@Record*(@Page-1)) AS varchar(3));
		SET @Max = CAST((@Record*@Page+1) AS varchar(3));
		IF @flag = 'true' -- true la theo chieu be -> lon 
			SET @Sql = 'SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY '+@Sort+' ASC) AS rownum, 
							* FROM vi_SB WHERE Dep_Com = '+@cId+') AS a WHERE rownum >'+@Min+' AND rownum < '+@Max+'';
		ELSE -- false la tu lon -> be
			SET @Sql = 'SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY '+@Sort+' DESC) AS rownum, 
							* FROM vi_SB WHERE Dep_Com = '+@cId+') AS a WHERE rownum >'+@Min+' AND rownum < '+@Max+'';
		EXEC (@Sql)
		COMMIT TRANSACTION
	END TRY
	BEGIN CATCH
		ROLLBACK TRANSACTION
	END CATCH
END
GO
	/*
	Select top
	((Select count(*) From
		(
		SELECT
		*
		FROM  dbo.tbl_HangHoa
		where  
		PK_sHangHoaID like '%lovan%' or
		sTenHangHoa like '%lovan%' or
		sTenHangHoaEng like '%lovan%' or
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
		FROM  dbo.tbl_HangHoa
		where  
		PK_sHangHoaID like '%lovan%' or
		sTenHangHoa like '%lovan%' or
		sTenHangHoaEng like '%lovan%' or
		sSoDienThoai like '%lovan%' or
		sDiaChi like '%lovan%' or
		sNguoiLienHe like '%lovan%' or
		sGhiChu like '%lovan%'
		)uiq
	) * FROM 
		(
		SELECT
		*
		FROM  dbo.tbl_HangHoa
		where  
		PK_sHangHoaID like '%lovan%' or
		sTenHangHoa like '%lovan%' or
		sTenHangHoaEng like '%lovan%' or
		sSoDienThoai like '%lovan%' or
		sDiaChi like '%lovan%' or
		sNguoiLienHe like '%lovan%' or
		sGhiChu like '%lovan%'
		)uio
	 order by PK_sHangHoaID ASC
	)a order by PK_sHangHoaID DESC
	) b	order by PK_sHangHoaID ASC
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
		FROM  dbo.tbl_HangHoa
		where  
		PK_sHangHoaID like @key or
		sTenHangHoa like @key or
		sTenHangHoaEng like @key or
		sSoDienThoai like @key or
		sDiaChi like @key or
		sNguoiLienHe like @key or
		sGhiChu like @key
		)soluongkq
END

