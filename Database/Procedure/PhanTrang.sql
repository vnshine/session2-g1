

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
GO
CREATE PROCEDURE Search_CongTy

		@id varchar(6),
		@name varchar(100),
		@diachi varchar(100),
		@sdt varchar(12),
		@email varchar(45),
		@tt varchar(3),
		@web varchar(45),
		@sl int

AS
BEGIN
	IF  EXISTS 
	(
		SELECT * FROM INFORMATION_SCHEMA.TABLES
            WHERE TABLE_NAME = 'search' 
                AND TABLE_TYPE = 'VIEW'
                AND TABLE_SCHEMA = 'dbo'
	)
	DROP view dbo.search
	EXEC('
		CREATE view dbo.search
		WITH SCHEMABINDING
		AS
		select * from dbo.tbl_ThongTinCongTy
				where  
					PK_sCongTyID like ''%@id%'' and
					sTenCongTyEng like ''%@name%'' and
					sDiaChiEng like ''%@diachi%'' and
					sSoDienThoai like ''%@sdt%'' and
					sEmail like ''%@email%'' and
					sWebsite like ''%@web%'' and
					FK_sTienTeID like ''%@tt%'' and
					iTienMat like ''%@sl%''
	')	
END
---------------------------------------------------------------
GO
CREATE PROCEDURE SearchPhanTrang_CongTy
		@trang int
AS
BEGIN
	select top 8 * 
	from 
		(select top (@trang*8) * from dbo.search order by PK_sCongTyID ASC) c  
	order by PK_sCongTyID DESC
END
---------------------------------------------------------------
GO
CREATE PROCEDURE PhanTrang_TienTe
		@trang int
AS
BEGIN
	select top 8 * 
	from 
		(select top (@trang*8) * from dbo.tbl_TienTe order by PK_sTienTeID ASC) c  
	order by PK_sTienTeID DESC
END
---------------------------------------------------------------
GO
CREATE PROCEDURE SearchPhanTrang_TienTe
		@trang int
AS
BEGIN
	select top 8 * 
	from 
		(select top (@trang*8) * from dbo.search2 order by PK_sTienTeID ASC) c  
	order by PK_sTienTeID DESC
END
---------------------------------------------------------------