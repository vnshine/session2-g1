-- Tao procedure cho dbo.tbl_TienTe
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
---------------------------------------------------------------
GO
CREATE PROCEDURE InsertTienTe
		@PK_sTienTeID varchar(3),
		@sTenTien nvarchar(20),
		@sTenTienEng nvarchar(20),
		@fMuaVao float,
		@fBanRa float
AS
BEGIN
	insert into dbo.tbl_TienTe
	values
	(
		@PK_sTienTeID,
		@sTenTien,
		@sTenTienEng,
		@fMuaVao,
		@fBanRa
	)
END
---------------------------------------------------------------
GO
CREATE PROCEDURE UpdateTienTe
	@PK_sTienTeID varchar(3),
	@sTenTien nvarchar(20),
	@sTenTienEng nvarchar(20),
	@fMuaVao float,
	@fBanRa float
AS
BEGIN
	update dbo.tbl_TienTe
	set
	
		sTenTien = @sTenTien,
		sTenTienEng	= @sTenTienEng,
		fMuaVao = @fMuaVao,
		fBanRa = @fBanRa

	where
		PK_sTienTeID = @PK_sTienTeID
END
---------------------------------------------------------------
GO

CREATE proc TrungTienTe
	@PK_sTienTeID varchar(3),
	@sTenTien nvarchar(20)
as
begin
	select * FROM dbo.tbl_TienTe WHERE PK_sTienTeID = @PK_sTienTeID OR sTenTien = @sTenTien
end
---------------------------------------------------------------
GO
CREATE PROCEDURE XoaTienTe
		@PK_sTienTeID varchar(3)
AS
BEGIN
	delete from dbo.tbl_TienTe 
	where
		PK_sTienTeID = @PK_sTienTeID
END
