

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
---------------------------------------------------------------
GO
CREATE PROCEDURE PhanTrang_CongTy
		@trang int
AS
BEGIN
	select top 8 * 
	from 
		(select top (@trang*8) * from dbo.tbl_ThongTinCongTy order by PK_sCongTyID ASC) c  
	order by PK_sCongTyID DESC
END
---------------------------------------------------------------