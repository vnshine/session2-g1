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