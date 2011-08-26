-- Tao procedure cho dbo.tbl_ThongTinCongTy
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
---------------------------------------------------------------
GO
CREATE PROCEDURE DeleteCongTy
		@PK_sCongTyID varchar(6)
AS
BEGIN
	delete from dbo.tbl_ThongTinCongTy
	where
		PK_sCongTyID = @PK_sCongTyID
END
---------------------------------------------------------------
GO
CREATE PROCEDURE InsertCongTy
	@PK_sCongTyID varchar(6),
	@sTenCongTy nvarchar(100),
	@sDiaChi nvarchar(100),
	@sSoDienThoai varchar(12),
	@sEmail varchar(45),
	@sWebsite varchar(45),
	@FK_sTienTeID varchar(3),
	@iTienMat int
AS
BEGIN
	insert into dbo.tbl_ThongTinCongTy
	values
	(
		@PK_sCongTyID,
		@sTenCongTy,
		@sDiaChi,
		@sSoDienThoai,
		@sEmail,
		@sWebsite,
		@FK_sTienTeID,
		@iTienMat
	)
END
---------------------------------------------------------------
GO
CREATE PROCEDURE UpdateCongTy
	@PK_sCongTyID varchar(6),
	@sTenCongTy nvarchar(100),
	@sTenCongTyEng nvarchar(100),
	@sDiaChi nvarchar(100),
	@sDiaChiEng nvarchar(100),
	@sSoDienThoai varchar(12),
	@sEmail varchar(45),
	@sWebsite varchar(45),
	@FK_sTienTeID varchar(3),
	@iTienMat int
AS
BEGIN
	update dbo.tbl_ThongTinCongTy
	set
		sTenCongTy = @sTenCongTy,
		sTenCongTyEng = @sTenCongTyEng,
		sDiaChi = @sDiaChi,
		sDiaChiEng = @sDiaChiEng,
		sSoDienThoai = @sSoDienThoai,
		sEmail = @sEmail,
		sWebsite = @sWebsite,
		FK_sTienTeID = @FK_sTienTeID,
		iTienMat = @iTienMat
	where
		PK_sCongTyID = @PK_sCongTyID
END