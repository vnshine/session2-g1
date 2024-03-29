


use NhatQuang
--------------------------------
--Bảng Hang Hoa
--------------------------------


-----------Proc thêm Hang Hoa             
if(OBJECT_ID('sp_tblHangHoa_Insert','p') is not null)
begin
	drop proc  sp_tblHangHoa_Insert
end
GO

CREATE proc sp_tblHangHoa_Insert
	@sTenHangHoa nvarchar(100),
	@sTenHangHoaEng varchar(100),
	@iDonGia float,
	@sNgayNhap date,
	@sGhiChu nvarchar(200),
	@FK_sDoiTacID varchar(6),
	@FK_sNhaSanXuatID varchar(6),
	@FK_iDonViTinhID int,
	@FK_iNhomHangID int
as
begin
	insert INTO tbl_HangHoa (sTenHangHoa,
							sTenHangHoaEng,
							iDonGia,
							sNgayNhap,
							sGhiChu,
							FK_sDoiTacID,
							FK_sNhaSanXuatID,
							FK_iDonViTinhID,
							FK_iNhomHangID,
							iTrangThai,
							iSoLuong
	) VALUES(   @sTenHangHoa,
				@sTenHangHoaEng,
				@iDonGia,
				@sNgayNhap,
				@sGhiChu,
				@FK_sDoiTacID,
				@FK_sNhaSanXuatID,
				@FK_iDonViTinhID,
				@FK_iNhomHangID,
				1,
				0
				)
end
go

-----------Proc sửa Hang Hoa
if(OBJECT_ID('sp_tblHangHoa_Update','p') is not null)
begin
	drop proc  sp_tblHangHoa_Update
end
GO

CREATE proc sp_tblHangHoa_Update
	@PK_iHangHoaID int,
	@sTenHangHoa nvarchar(100),
	@sTenHangHoaEng nvarchar(100),
	@iGiaMua int,
	@iGiaBanBuon int,
	@iGiaBanLe int,
	@sNgayNhap varchar(10),
	@sNgayHetHan varchar(10),
	@sGhiChu nvarchar(200),
	@iVAT int,
	@FK_sDoiTacID varchar(6),
	@FK_sNhaSanXuatID varchar(6),
	@FK_iDonViTinhID int,
	@FK_iNhomHangID int
as
begin
	update tbl_HangHoa SET 
		@sTenHangHoa = @sTenHangHoa,
		@sTenHangHoaEng =@sTenHangHoaEng,
		@iGiaMua = @iGiaMua,
		@iGiaBanBuon =@iGiaBanBuon,
		@iGiaBanLe =@iGiaBanLe,
		@sNgayNhap = @sNgayNhap,
		@sNgayHetHan = @sNgayHetHan,
		@sGhiChu = @sGhiChu,
		@iVAT = @iVAT,
		@FK_sDoiTacID = @FK_sDoiTacID,
		@FK_sNhaSanXuatID = @FK_sNhaSanXuatID,
		@FK_iDonViTinhID = @FK_iDonViTinhID,
		@FK_iNhomHangID = @FK_iNhomHangID
	where PK_iHangHoaID = @PK_iHangHoaID
end
go

-----------Proc xóa Hang Hoa
if(OBJECT_ID('sp_tblHangHoa_Delete','p') is not null)
begin
	drop proc  sp_tblHangHoa_Delete
end
GO

CREATE proc sp_tblHangHoa_Delete
	@PK_iHangHoaID int
as
begin
	update tbl_HangHoa SET iTrangThai = 2 where PK_iHangHoaID = @PK_iHangHoaID
end
go


-----------Proc kiểm tra có tồn tại Hang Hoa
if(OBJECT_ID('sp_tblHangHoa_duplicate','p') is not null)
begin
	drop proc  sp_tblHangHoa_duplicate
end
GO

CREATE proc sp_tblHangHoa_duplicate
	@sTenHangHoa nvarchar(100)
as
begin
	Select count(*) from (select * FROM tbl_HangHoa WHERE sTenHangHoa = @sTenHangHoa and iTrangThai = 1)dupli
end
go


-----------Proc kiểm tra có tồn tại Hang Hoa (da sua)
if(OBJECT_ID('sp_tblHangHoa_duplicate2','p') is not null)
begin
	drop proc  sp_tblHangHoa_duplicate2
end
GO

CREATE proc sp_tblHangHoa_duplicate2
	@sTenHangHoa nvarchar(100),
	@sTenHangHoa2 nvarchar(100)
as
begin
	Select count(*) from (select * FROM tbl_HangHoa WHERE sTenHangHoa = @sTenHangHoa2 and iTrangThai = 1 and sTenHangHoa <> @sTenHangHoa)dupli2
end
go

-----------Proc lay danh sach
/*
SELECT     tbl_HangHoa.*, tbl_DoiTac.sTenDoiTac, tbl_NhaSanXuat.sTenNhaSanXuat, tbl_DonViTinh.sTenDonViTinh, tbl_NhomHang.sTenNhomHang
FROM         tbl_HangHoa INNER JOIN
                      tbl_DoiTac ON tbl_HangHoa.FK_sDoiTacID = tbl_DoiTac.PK_sDoiTacID INNER JOIN
                      tbl_NhaSanXuat ON tbl_HangHoa.FK_sNhaSanXuatID = tbl_NhaSanXuat.PK_sNhaSanXuatID INNER JOIN
                      tbl_DonViTinh ON tbl_HangHoa.FK_iDonViTinhID = tbl_DonViTinh.PK_iDonViTinhID INNER JOIN
                      tbl_NhomHang ON tbl_HangHoa.FK_iNhomHangID = tbl_NhomHang.PK_iNhomHangID
WHERE tbl_HangHoa.iTrangThai <2
*/
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


-----------Proc Select số lượng Hang Hoa
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
	@key varchar(200)
AS
BEGIN
	SET @key = '%' + @key + '%';
	Select top
	((Select count(*) From ( SELECT * FROM tbl_HangHoa WHERE iTrangThai <2 and sTenHangHoaEng like @key	)joi
	) -(10*(@soTrang-1)))
	* From
	(select top (10*@soTrang) *
	from
	(SELECT top(Select count(*) From 
		(
		SELECT
		*
		FROM  dbo.tbl_HangHoa where
		iTrangThai <2 and sTenHangHoaEng like @key
		)uiq
	) * FROM 
		(
		SELECT
		*
		FROM  dbo.tbl_HangHoa where
		iTrangThai <2 and sTenHangHoaEng like @key
		)uio
	 order by sTenHangHoa ASC
	)a order by sTenHangHoa DESC
	) b	order by sTenHangHoa ASC
END
GO
	



-----------Proc Select số lượng Ket qua tim kiem
if(OBJECT_ID('SoLuong_KQhh','t') is not null)
begin
	drop proc  SoLuong_KQhh
end
GO
CREATE PROCEDURE SoLuong_KQhh
@key varchar(200)
AS
BEGIN
	SET @key = '%' + @key + '%';
	Select count(*) From
		(
		SELECT
		*
		FROM  dbo.tbl_HangHoa
		where  sTenHangHoaEng like @key and iTrangThai<2
		)o
END

go

------Proc ds

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
if(OBJECT_ID('ds_HangHoa','p2') is not null)
begin
	drop proc  ds_HangHoa
end
GO
CREATE PROCEDURE ds_HangHoa
	@soTrang int 
AS
BEGIN
	Select top
	((Select count(*) From (  SELECT     tbl_HangHoa.*, tbl_DoiTac.sTenDoiTac, tbl_NhaSanXuat.sTenNhaSanXuat, tbl_DonViTinh.sTenDonViTinh, tbl_NhomHang.sTenNhomHang
		   FROM       tbl_HangHoa INNER JOIN
                      tbl_DoiTac ON tbl_HangHoa.FK_sDoiTacID = tbl_DoiTac.PK_sDoiTacID INNER JOIN
                      tbl_DonViTinh ON tbl_HangHoa.FK_iDonViTinhID = tbl_DonViTinh.PK_iDonViTinhID INNER JOIN
                      tbl_NhaSanXuat ON tbl_HangHoa.FK_sNhaSanXuatID = tbl_NhaSanXuat.PK_sNhaSanXuatID INNER JOIN
                      tbl_NhomHang ON tbl_HangHoa.FK_iNhomHangID = tbl_NhomHang.PK_iNhomHangID
			WHERE tbl_HangHoa.iTrangThai <2
)joined2
	) -(10*(@soTrang-1)))
	* From
	(select top (10*@soTrang) *
	from
	(SELECT top(Select count(*) From 
		(
		SELECT
		*
		FROM  (  SELECT     tbl_HangHoa.*, tbl_DoiTac.sTenDoiTac, tbl_NhaSanXuat.sTenNhaSanXuat, tbl_DonViTinh.sTenDonViTinh, tbl_NhomHang.sTenNhomHang
		   FROM       tbl_HangHoa INNER JOIN
                      tbl_DoiTac ON tbl_HangHoa.FK_sDoiTacID = tbl_DoiTac.PK_sDoiTacID INNER JOIN
                      tbl_DonViTinh ON tbl_HangHoa.FK_iDonViTinhID = tbl_DonViTinh.PK_iDonViTinhID INNER JOIN
                      tbl_NhaSanXuat ON tbl_HangHoa.FK_sNhaSanXuatID = tbl_NhaSanXuat.PK_sNhaSanXuatID INNER JOIN
                      tbl_NhomHang ON tbl_HangHoa.FK_iNhomHangID = tbl_NhomHang.PK_iNhomHangID
			WHERE tbl_HangHoa.iTrangThai <2
)joined3
		)uiq
	) * FROM 
		(  SELECT     tbl_HangHoa.*, tbl_DoiTac.sTenDoiTac, tbl_NhaSanXuat.sTenNhaSanXuat, tbl_DonViTinh.sTenDonViTinh, tbl_NhomHang.sTenNhomHang
		   FROM       tbl_HangHoa INNER JOIN
                      tbl_DoiTac ON tbl_HangHoa.FK_sDoiTacID = tbl_DoiTac.PK_sDoiTacID INNER JOIN
                      tbl_DonViTinh ON tbl_HangHoa.FK_iDonViTinhID = tbl_DonViTinh.PK_iDonViTinhID INNER JOIN
                      tbl_NhaSanXuat ON tbl_HangHoa.FK_sNhaSanXuatID = tbl_NhaSanXuat.PK_sNhaSanXuatID INNER JOIN
                      tbl_NhomHang ON tbl_HangHoa.FK_iNhomHangID = tbl_NhomHang.PK_iNhomHangID
			WHERE tbl_HangHoa.iTrangThai <2
)joined4
	 order by sTenHangHoa ASC
	)a order by sTenHangHoa DESC
	) b	order by sTenHangHoa ASC
END
GO
	



-----------Proc Select số lượng 
if(OBJECT_ID('SoLuong_hh','t') is not null)
begin
	drop proc  SoLuong_hh
end
GO
CREATE PROCEDURE SoLuong_hh
AS
BEGIN
	Select count(*) From
		(
		SELECT
		*
		FROM  [NhatQuang].[dbo].[tbl_HangHoa]
		where  iTrangThai<2
		)o
END

go