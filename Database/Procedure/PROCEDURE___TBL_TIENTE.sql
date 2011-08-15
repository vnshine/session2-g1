-- Tao procedure cho dbo.tbl_TienTe
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
---------------------------------------------------------------
GO
CREATE PROCEDURE InsertTienTe
		@PK_sTienTeID varchar(3),
		@sTenTien nvarchar(20),
		@fMuaVao float,
		@fBanRa float
AS
BEGIN
	insert into dbo.tbl_TienTe
	values
	(
		@PK_sTienTeID,
		@sTenTien,
		@fMuaVao,
		@fBanRa
	)
END
---------------------------------------------------------------
GO
CREATE PROCEDURE UpdateTienTe
	@PK_sTienTeID varchar(3),
	@sTenTien nvarchar(20),
	@fMuaVao float,
	@fBanRa float
AS
BEGIN
	update dbo.tbl_TienTe
	set
	
		sTenTien = @sTenTien,
		fMuaVao = @fMuaVao,
		fBanRa = @fBanRa

	where
		PK_sTienTeID = @PK_sTienTeID
END