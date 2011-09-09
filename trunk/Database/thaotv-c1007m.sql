
--------------------------------
--Bảng đối tác
--------------------------------


-----------Proc timmf đối tác
set ANSI_NULLS ON
set QUOTED_IDENTIFIER ON
GO
if(OBJECT_ID('SEARCH_DOITAC','p') is not null)
begin
	drop proc  SEARCH_DOITAC
end
GO
CREATE PROCEDURE SEARCH_DOITAC  
	@soTrang int,
	@key nvarchar
AS
BEGIN
	SET @key  = '%' + @key + '%'
	--
	
	select * from (
	select top ((
				Select count(*) from (SELECT top (10*@soTrang) *
				FROM (SELECT * FROM [NhatQuang].[dbo].[tbl_DoiTac] WHERE 
												PK_sDoiTacID like @key or
												sTenDoiTac like @key or
												sTenDoiTacEng like @key or
												sSoDienThoai like @key or
												sDiaChi like @key or
												sNguoiLienHe like @key or
												sGhiChu like @key)thao)d
				)-(10*(@soTrang-1)))
	*from (		
	select top (10*@soTrang) *
	from (SELECT * FROM [NhatQuang].[dbo].[tbl_DoiTac] WHERE 
												PK_sDoiTacID like @key or
												sTenDoiTac like @key or
												sTenDoiTacEng like @key or
												sSoDienThoai like @key or
												sDiaChi like @key or
												sNguoiLienHe like @key or
												sGhiChu like @key)causelec order by PK_sDoiTacID ASC
	) a	order by PK_sDoiTacID DESC
	) b	order by PK_sDoiTacID ASC
	--
	

END

set ANSI_NULLS ON
set QUOTED_IDENTIFIER ON

-----------Proc Select số lượng Ket qua tim kiem
if(OBJECT_ID('SoLuong_KQ','p') is not null)
begin
	drop proc  SoLuong_KQ
end
GO
CREATE PROCEDURE SoLuong_KQ 
@key nvarchar
AS
BEGIN
	SET @key = '%' + @key + '%'
	Select count(*) FROM (SELECT * FROM [NhatQuang].[dbo].[tbl_DoiTac] WHERE 
												PK_sDoiTacID like @key or
												sTenDoiTac like @key or
												sTenDoiTacEng like @key or
												sSoDienThoai like @key or
												sDiaChi like @key or
												sNguoiLienHe like @key or
												sGhiChu like @key)kqt
END

GO

Select count(*) FROM (SELECT * FROM [NhatQuang].[dbo].[tbl_DoiTac] WHERE 
												PK_sDoiTacID like '%ttn112sd%' or
												sTenDoiTac like '%ttn112dd%' or
												sTenDoiTacEng like '%ttn112sd%' or
												sSoDienThoai like '%ttn112sd%' or
												sDiaChi like '%ttn112sd%' or
												sNguoiLienHe like '%ttn112sd%' or
												sGhiChu like '%ttn112sd%')kqt

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

SELECT * FROM [NhatQuang].[dbo].[tbl_DoiTac] WHERE MATCH(sTenDoiTacEng) AGAINST('tho')







































--------------------------------
--------------------------------
--------------------------------
--------------------------------
--------------------------------
--------------------------------
--------------------------------
--------------------------------
--------------------------------
--------------------------------
--------------------------------
--------------------------------
--------------------------------
--------------------------------
--------------------------------
--------------------------------

--------------------------------
--Bảng Quyền
--------------------------------

-----------Proc Select danh sách các quyền
if(OBJECT_ID('sp_tblQuyen_Select','p') is not null)
begin
	drop proc  sp_tblQuyen_Select
end
GO

CREATE proc sp_tblQuyen_Select
as
begin
	select * FROM tbl_Quyen
end
go


-----------Proc tìm kiếm quyền
if(OBJECT_ID('sp_tblQuyen_Find','p') is not null)
begin
	drop proc  sp_tblQuyen_Find
end
GO

CREATE proc sp_tblQuyen_Find
	@ten nvarchar(50),
	@ghichu nvarchar(100)
as
begin
	IF (@ghichu = '')
		begin
			print 'ghi chu null'
			select * FROM tbl_Quyen WHERE sTenQuyen LIKE '%' + @ten + '%'
		end
	ELSE
		begin
			print 'ghi chu not null'
			select * FROM tbl_Quyen WHERE sTenQuyen LIKE '%' + @ten + '%' OR sGhiChu LIKE '%' + @ghichu + '%'
		end
end
go



-----------Proc thêm quyền
if(OBJECT_ID('sp_tblQuyen_Insert','p') is not null)
begin
	drop proc  sp_tblQuyen_Insert
end
GO

CREATE proc sp_tblQuyen_Insert
	@ten nvarchar(50),
	@ghichu nvarchar(100)
as
begin
	insert INTO tbl_Quyen(sTenQuyen, sGhiChu) VALUES(@ten, @ghichu)
end
go

-----------Proc sửa quyền
if(OBJECT_ID('sp_tblQuyen_Update','p') is not null)
begin
	drop proc  sp_tblQuyen_Update
end
GO

CREATE proc sp_tblQuyen_Update
	@old_name nvarchar(50),
	@ten nvarchar(50),
	@ghichu nvarchar(100)
as
begin
	update tbl_Quyen SET sTenQuyen = @ten, sGhiChu = @ghichu WHERE sTenQuyen = @old_name
end
go


-----------Proc xóa quyền
if(OBJECT_ID('sp_tblQuyen_Delete','p') is not null)
begin
	drop proc  sp_tblQuyen_Delete
end
GO

CREATE proc sp_tblQuyen_Delete
	@id int
as
begin
	Delete FROM tbl_Quyen WHERE sTenQuyen = @name
end
go


-----------Proc kiểm tra có tồn tại ID
if(OBJECT_ID('sp_tblQuyen_duplicate','p') is not null)
begin
	drop proc  sp_tblQuyen_duplicate
end
GO

CREATE proc sp_tblQuyen_duplicate
	@ten varchar(50)
as
begin
	select * FROM tbl_Quyen WHERE sTenQuyen = @ten
end
go


--+++++++++++++++++++++++++++++++
--------------------------------+
--Thêm cơ sở dữ liệu            +
--------------------------------+
--+++++++++++++++++++++++++++++++


--------------------------------
--Bảng quyền
--------------------------------

INSERT INTO tbl_Quyen(sTenQuyen,sGhiChu) VALUES(N'Quản trị', N'Quản trị hệ thống')
--------------------------------
--Bảng nhân viên
--------------------------------

INSERT INTO tbl_NhanVien values('NV0001','nv001',N'Quang Liem', '0989320758','05/02/1990','1','',1)

UPDATE tbl_NhanVien SET sMatKhau = '73acd9a5972130b75066c82595a1fae3' WHERE PK_sNhanVienID = 'NV0001'

exec sp_tblNhanVien_Login 'NV0001', 'admin'


-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------
-----------------------------------------------------------

-- Tao procedure cho dbo.tbl_SanPham 
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
---------------------------------------------------------------
GO
CREATE PROCEDURE InsertSanPham 
	@sTenSanPham nvarchar(100),
	@sDonViTinh nvarchar(20)
AS
BEGIN
	insert into dbo.tbl_SanPham 
	values
	(
	@sTenSanPham,
	@sDonViTinh
	)
END
---------------------------------------------------------------
GO
CREATE PROCEDURE UpdateSanPham
	@PK_SanPham int,
	@sTenSanPham varchar(100),
	@sDonViTinh nvarchar(20)
AS
BEGIN
	UPDATE dbo.tbl_SanPham
	SET sTenSanPham = @sTenSanPham,
		sDonViTinh = @sDonViTinh
	WHERE PK_SanPham = @PK_SanPham
END
---------------------------------------------------------------
GO
-------------------------------------------------------------------------------------------------------
--CREATE PROCEDURE DeleteSanPham 
--	@PK_NhanVien varchar(5)
--AS
--BEGIN
--	UPDATE dbo.tbl_NhanVien
--	SET iTrangThai = (iTrangThai + 9000) 
--	WHERE PK_SanPham = @PK_SanPham
--END
-------------------------------------------------------------------------------------------------------
---------------------------------------------------------------
GO
CREATE PROCEDURE XemTrangSanPham 
	@soTrang int
AS
BEGIN
	select * from (
	select top 10 * from (		
	select top (10*@soTrang) *
	from dbo.tbl_SanPham order by PK_SanPham ASC
	) a	order by PK_SanPham DESC
	) b	order by PK_SanPham ASC	
END
---------------------------------------------------------------
-- Tao procedure Nhan Vien

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
---------------------------------------------------------------
GO
CREATE PROCEDURE InsertNhanVien 
	@PK_NhanVien varchar(5),
	@sHoTen nvarchar(50),
	@iGioiTinh int,
	@dNgaySinh datetime,
	@sSoDienThoai nchar(15),
	@iTrangThai int
AS
BEGIN
	insert into dbo.tbl_NhanVien 
	values
	(
	@PK_NhanVien,
	@sHoTen,
	@iGioiTinh,
	@dNgaySinh,
	@sSoDienThoai,
	@iTrangThai
	)
END
---------------------------------------------------------------
GO
CREATE PROCEDURE UpdateNhanVien 
	@PK_NhanVien varchar(5),
	@sHoTen nvarchar(50),
	@iGioiTinh int,
	@dNgaySinh datetime,
	@sSoDienThoai nchar(15),
	@iTrangThai int
AS
BEGIN
	UPDATE dbo.tbl_NhanVien
	SET sHoTen = @sHoTen,
		iGioiTinh = @iGioiTinh,
		dNgaySinh = @dNgaySinh,
		sSoDienThoai = @sSoDienThoai,
		iTrangThai = @iTrangThai
	WHERE PK_NhanVien = @PK_NhanVien
END
---------------------------------------------------------------
GO
CREATE PROCEDURE DeleteNhanVien 
	@PK_NhanVien varchar(5)
AS
BEGIN
	UPDATE dbo.tbl_NhanVien
	SET iTrangThai = (iTrangThai + 9000) 
	WHERE PK_NhanVien = @PK_NhanVien
END
---------------------------------------------------------------

GO
CREATE PROCEDURE XemTrangNhanVien 
	@soTrang int
AS
BEGIN
	select * from (
	select top 10 * from (		
	select top (10*@soTrang) *
	from dbo.tbl_NhanVien order by PK_NhanVien ASC
	) a	order by PK_NhanVien DESC
	) b	order by PK_NhanVien ASC	
END
---------------------------------------------------------------
		
--	SELECT * FROM dbo.tbl_NhanVien where PK_NhanVien = 'a0040'
--	SELECT Convert(datetime,'11/10/1986')
--	SELECT Convert(datetime,'31/12/2007',103)
--
--	SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS 
--	where TABLE_NAME = 'tbl_NhanVien' 





-- Du lieu Nhan Vien ----------------------------------------------------------------------------------------------------------------
insert into dbo.tbl_NhanVien values('A0000',N' Bùi Văn An',1,Convert(datetime,'10/10/1986',103),'87818699279',3)
insert into dbo.tbl_NhanVien values('A0001',N' Nguyễn Phùng Nhật Anh',2,Convert(datetime,'25/04/1990',103),'81812020480',2)
insert into dbo.tbl_NhanVien values('A0002',N' Lê Đình Chinh',1,Convert(datetime,'27/10/1985',103),'81031286729',2)
insert into dbo.tbl_NhanVien values('A0003',N' Võ Thị Thùy Dung',1,Convert(datetime,'27/10/1986',103),'81864247945',1)
insert into dbo.tbl_NhanVien values('A0004',N' Đường Trung Hậu',1,Convert(datetime,'19/05/1989',103),'81032247423',2)
insert into dbo.tbl_NhanVien values('A0005',N' Nguyễn Thị Hòa',2,Convert(datetime,'05/03/1990',103),'81920374323',2)
insert into dbo.tbl_NhanVien values('A0006',N' Phùng Thị Hòa',2,Convert(datetime,'20/07/1989',103),'81613110425',2)
insert into dbo.tbl_NhanVien values('A0007',N' Phan Văn Hơn',1,Convert(datetime,'06/04/1985',103),'81049998270',3)
insert into dbo.tbl_NhanVien values('A0008',N' Hồ Anh Khoa',1,Convert(datetime,'03/02/1989',103),'81038798319',1)
insert into dbo.tbl_NhanVien values('A0009',N' Nguyễn Thị Liểu',2,Convert(datetime,'14/04/1989',103),'81018944765',2)
insert into dbo.tbl_NhanVien values('A0010',N' Phan Văn Lôi',1,Convert(datetime,'29/04/1989',103),'81576081899',3)
insert into dbo.tbl_NhanVien values('A0011',N' Lê Hữu Lộc',1,Convert(datetime,'13/03/1988',103),'81250258140',1)
insert into dbo.tbl_NhanVien values('A0012',N' Trần Thị Kim Lợi',2,Convert(datetime,'13/05/1988',103),'81383422966',2)
insert into dbo.tbl_NhanVien values('A0013',N' Dương Trọng Lượng',1,Convert(datetime,'21/04/1990',103),'81239973871',2)
insert into dbo.tbl_NhanVien values('A0014',N' Nguyễn Thị Kim Ngân',2,Convert(datetime,'19/10/1990',103),'81101633623',1)
insert into dbo.tbl_NhanVien values('A0015',N' Thái Thị Hồng Nhung',2,Convert(datetime,'05/05/1987',103),'81193029880',2)
insert into dbo.tbl_NhanVien values('A0016',N' Lý Minh Nhựt',2,Convert(datetime,'05/05/1988',103),'81300375025',3)
insert into dbo.tbl_NhanVien values('A0017',N' Trần Cữu Nương',2,Convert(datetime,'22/07/1989',103),'81104603016',2)
insert into dbo.tbl_NhanVien values('A0018',N' Trần Thanh Phong',1,Convert(datetime,'22/07/1988',103),'81775415591',3)
insert into dbo.tbl_NhanVien values('A0019',N' Đàm Minh Phú',1,Convert(datetime,'04/03/1988',103),'81388851004',1)
insert into dbo.tbl_NhanVien values('A0020',N' Nguyễn Thanh Phương',1,Convert(datetime,'03/02/1986',103),'81899775498',2)
insert into dbo.tbl_NhanVien values('A0021',N' Lâm Thành Phước',1,Convert(datetime,'03/02/1987',103),'81642491106',2)
insert into dbo.tbl_NhanVien values('A0022',N' Nguyễn Đình Quí',1,Convert(datetime,'04/04/1989',103),'81306477313',3)
insert into dbo.tbl_NhanVien values('A0023',N' Huỳnh Văn Quốc',1,Convert(datetime,'04/04/1990',103),'81516402175',2)
insert into dbo.tbl_NhanVien values('A0024',N' Ngô Bảo Quốc',1,Convert(datetime,'03/02/1988',103),'81983751629',3)
insert into dbo.tbl_NhanVien values('A0025',N' Dương Nhật Quyện',1,Convert(datetime,'03/02/1989',103),'81410100411',1)
insert into dbo.tbl_NhanVien values('A0026',N' Huỳnh Hữu Tâm',1,Convert(datetime,'05/11/1988',103),'81271508414',1)
insert into dbo.tbl_NhanVien values('A0027',N' Phạm Thị Minh Tâm',2,Convert(datetime,'05/11/1989',103),'81871795189',1)
insert into dbo.tbl_NhanVien values('A0028',N' Nguyễn Văn Thanh',1,Convert(datetime,'14/06/1990',103),'81065468886',1)
insert into dbo.tbl_NhanVien values('A0029',N' Nguyễn Hữu Thái',1,Convert(datetime,'19/07/1989',103),'81020473009',1)
insert into dbo.tbl_NhanVien values('A0030',N' Võ Thị Kim Thoa',2,Convert(datetime,'14/04/1989',103),'81759724205',1)
insert into dbo.tbl_NhanVien values('A0031',N' Nguyễn Thị Ngọc Thúy',2,Convert(datetime,'29/04/1989',103),'81653218768',2)
insert into dbo.tbl_NhanVien values('A0032',N' Trần Thị Diệu Tín',2,Convert(datetime,'13/03/1988',103),'81483041285',2)
insert into dbo.tbl_NhanVien values('A0033',N' Lâm Thái Toàn',1,Convert(datetime,'13/05/1988',103),'81508431119',2)
insert into dbo.tbl_NhanVien values('A0034',N' Võ Thị Kiều Trinh',2,Convert(datetime,'21/04/1990',103),'81985861539',2)
insert into dbo.tbl_NhanVien values('A0035',N' Mai Văn Trọng',1,Convert(datetime,'19/10/1990',103),'81650988777',2)
insert into dbo.tbl_NhanVien values('A0036',N' Trần Thanh Tùng',1,Convert(datetime,'05/05/1987',103),'81728052940',2)
insert into dbo.tbl_NhanVien values('A0037',N' Nguyễn Phước Vinh',1,Convert(datetime,'05/05/1988',103),'81968702610',2)
insert into dbo.tbl_NhanVien values('A0038',N' Huỳnh Ngọc Thúy Vy',2,Convert(datetime,'22/07/1989',103),'81549414890',1)
insert into dbo.tbl_NhanVien values('A0039',N' Huỳnh Tô Xinh',2,Convert(datetime,'22/07/1988',103),'81994711599',3)
insert into dbo.tbl_NhanVien values('A0040',N' Đàm Minh Phú',1,Convert(datetime,'04/03/1988',103),'81944859860',2)
insert into dbo.tbl_NhanVien values('A0041',N' Nguyễn Thanh Phương',1,Convert(datetime,'03/02/1986',103),'81532565199',3)
insert into dbo.tbl_NhanVien values('A0042',N' Lâm Thành Phước',1,Convert(datetime,'03/02/1987',103),'81097914985',3)
insert into dbo.tbl_NhanVien values('A0043',N' Nguyễn Đình Quí',1,Convert(datetime,'04/04/1989',103),'81482629256',2)
insert into dbo.tbl_NhanVien values('A0044',N' Huỳnh Văn Quốc',1,Convert(datetime,'04/04/1990',103),'81137015225',3)
insert into dbo.tbl_NhanVien values('A0045',N' Ngô Bảo Quốc',1,Convert(datetime,'03/02/1988',103),'81177139522',2)
insert into dbo.tbl_NhanVien values('A0046',N' Dương Nhật Quyện',1,Convert(datetime,'03/02/1989',103),'81806212861',2)
insert into dbo.tbl_NhanVien values('A0047',N' Huỳnh Hữu Tâm',1,Convert(datetime,'05/11/1988',103),'81255630924',3)
insert into dbo.tbl_NhanVien values('A0048',N' Phạm Thị Minh Tâm',2,Convert(datetime,'05/11/1989',103),'81075750028',3)
insert into dbo.tbl_NhanVien values('A0049',N' Nguyễn Văn Thanh',1,Convert(datetime,'14/06/1990',103),'81134984639',2)
insert into dbo.tbl_NhanVien values('A0050',N' Nguyễn Hữu Thái',1,Convert(datetime,'19/07/1989',103),'81325162819',3)
insert into dbo.tbl_NhanVien values('A0051',N' Võ Thị Kim Thoa',2,Convert(datetime,'03/02/1988',103),'81994535377',3)
insert into dbo.tbl_NhanVien values('A0052',N' Nguyễn Thị Ngọc Thúy',2,Convert(datetime,'04/04/1991',103),'81068916803',3)
insert into dbo.tbl_NhanVien values('A0053',N' Trần Thị Diệu Tín',2,Convert(datetime,'04/04/1992',103),'81615035653',2)
insert into dbo.tbl_NhanVien values('A0054',N' Lâm Thái Toàn',1,Convert(datetime,'03/02/1990',103),'81425997375',1)
insert into dbo.tbl_NhanVien values('A0055',N' Võ Thị Kiều Trinh',2,Convert(datetime,'03/02/1991',103),'81038155561',2)
insert into dbo.tbl_NhanVien values('A0056',N' Mai Văn Trọng',1,Convert(datetime,'05/11/1990',103),'81637387829',2)
insert into dbo.tbl_NhanVien values('A0057',N' Trần Thanh Tùng',1,Convert(datetime,'05/11/1991',103),'81750350092',1)
insert into dbo.tbl_NhanVien values('A0058',N' Nguyễn Phước Vinh',1,Convert(datetime,'14/06/1991',103),'81329711029',3)
insert into dbo.tbl_NhanVien values('A0059',N' Huỳnh Ngọc Thúy Vy',2,Convert(datetime,'19/07/1990',103),'81715557195',1)
insert into dbo.tbl_NhanVien values('A0060',N' Huỳnh Tô Xinh',2,Convert(datetime,'03/02/1989',103),'81892340151',2)




































INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0000',N' Bùi Van An',							'hfsbjfusgufs','87818699279','dgdughudjgb',3,'nguoi lien he','ghi chu')   
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0001',N' Nguy?n Phùng Nh?t Anh',	'hfsbjfusgufs','81812020480','dgdughudjgb',2,'nguoi lien he','ghi chu')     
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0002',N' Lê Ðình Chinh',					'hfsbjfusgufs','81031286729','dgdughudjgb',2,'nguoi lien he','ghi chu')     
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0003',N' Võ Th? Thùy Dung',				'hfsbjfusgufs','81864247945','dgdughudjgb',1,'nguoi lien he','ghi chu')   
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0004',N' Ðu?ng Trung H?u',				'hfsbjfusgufs','81032247423','dgdughudjgb',2,'nguoi lien he','ghi chu')     
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0005',N' Nguy?n Th? Hòa',					'hfsbjfusgufs','81920374323','dgdughudjgb',2,'nguoi lien he','ghi chu')   
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0006',N' Phùng Th? Hòa',					'hfsbjfusgufs','81613110425','dgdughudjgb',2,'nguoi lien he','ghi chu')     
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0007',N' Phan Van Hon',						'hfsbjfusgufs','81049998270','dgdughudjgb',3,'nguoi lien he','ghi chu')   
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0008',N' H? Anh Khoa',						'hfsbjfusgufs','81038798319','dgdughudjgb',1,'nguoi lien he','ghi chu')     
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0009',N' Nguy?n Th? Li?u',				'hfsbjfusgufs','81018944765','dgdughudjgb',2,'nguoi lien he','ghi chu')     
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0010',N' Phan Van Lôi',						'hfsbjfusgufs','81576081899','dgdughudjgb',3,'nguoi lien he','ghi chu')   
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0011',N' Lê H?u L?c',							'hfsbjfusgufs','81250258140','dgdughudjgb',1,'nguoi lien he','ghi chu')   
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0012',N' Tr?n Th? Kim L?i',				'hfsbjfusgufs','81383422966','dgdughudjgb',2,'nguoi lien he','ghi chu')   
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0013',N' Duong Tr?ng Lu?ng',			'hfsbjfusgufs','81239973871','dgdughudjgb',2,'nguoi lien he','ghi chu')     
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0014',N' Nguy?n Th? Kim Ngân',		'hfsbjfusgufs','81101633623','dgdughudjgb',1,'nguoi lien he','ghi chu')     
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0015',N' Thái Th? H?ng Nhung',		'hfsbjfusgufs','81193029880','dgdughudjgb',2,'nguoi lien he','ghi chu')     
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0016',N' Lý Minh Nh?t',						'hfsbjfusgufs','81300375025','dgdughudjgb',3,'nguoi lien he','ghi chu')   
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0017',N' Tr?n C?u Nuong',					'hfsbjfusgufs','81104603016','dgdughudjgb',2,'nguoi lien he','ghi chu')   
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0018',N' Tr?n Thanh Phong',				'hfsbjfusgufs','81775415591','dgdughudjgb',3,'nguoi lien he','ghi chu')   
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0019',N' Ðàm Minh Phú',						'hfsbjfusgufs','81388851004','dgdughudjgb',1,'nguoi lien he','ghi chu')   
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0020',N' Nguy?n Thanh Phuong',		'hfsbjfusgufs','81899775498','dgdughudjgb',2,'nguoi lien he','ghi chu')     
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0021',N' Lâm Thành Phu?c',				'hfsbjfusgufs','81642491106','dgdughudjgb',2,'nguoi lien he','ghi chu')     
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0022',N' Nguy?n Ðình Quí',				'hfsbjfusgufs','81306477313','dgdughudjgb',3,'nguoi lien he','ghi chu')     
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0023',N' Hu?nh Van Qu?c',					'hfsbjfusgufs','81516402175','dgdughudjgb',2,'nguoi lien he','ghi chu')   
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0024',N' Ngô B?o Qu?c',						'hfsbjfusgufs','81983751629','dgdughudjgb',3,'nguoi lien he','ghi chu')   
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0025',N' Duong Nh?t Quy?n',				'hfsbjfusgufs','81410100411','dgdughudjgb',1,'nguoi lien he','ghi chu')   
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0026',N' Hu?nh H?u Tâm',					'hfsbjfusgufs','81271508414','dgdughudjgb',1,'nguoi lien he','ghi chu')     
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0027',N' Ph?m Th? Minh Tâm',			'hfsbjfusgufs','81871795189','dgdughudjgb',1,'nguoi lien he','ghi chu')     
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0028',N' Nguy?n Van Thanh',				'hfsbjfusgufs','81065468886','dgdughudjgb',1,'nguoi lien he','ghi chu')   
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0029',N' Nguy?n H?u Thái',				'hfsbjfusgufs','81020473009','dgdughudjgb',1,'nguoi lien he','ghi chu')     
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0030',N' Võ Th? Kim Thoa',				'hfsbjfusgufs','81759724205','dgdughudjgb',1,'nguoi lien he','ghi chu')     
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0031',N' Nguy?n Th? Ng?c Thúy',		'hfsbjfusgufs','81653218768','dgdughudjgb',2,'nguoi lien he','ghi chu')   
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0032',N' Tr?n Th? Di?u Tín',			'hfsbjfusgufs','81483041285','dgdughudjgb',2,'nguoi lien he','ghi chu')     
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0033',N' Lâm Thái Toàn',					'hfsbjfusgufs','81508431119','dgdughudjgb',2,'nguoi lien he','ghi chu')     
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0034',N' Võ Th? Ki?u Trinh',			'hfsbjfusgufs','81985861539','dgdughudjgb',2,'nguoi lien he','ghi chu')     
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0035',N' Mai Van Tr?ng',					'hfsbjfusgufs','81650988777','dgdughudjgb',2,'nguoi lien he','ghi chu')     
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0036',N' Tr?n Thanh Tùng',				'hfsbjfusgufs','81728052940','dgdughudjgb',2,'nguoi lien he','ghi chu')     
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0037',N' Nguy?n Phu?c Vinh',			'hfsbjfusgufs','81968702610','dgdughudjgb',2,'nguoi lien he','ghi chu')     
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0038',N' Hu?nh Ng?c Thúy Vy',			'hfsbjfusgufs','81549414890','dgdughudjgb',1,'nguoi lien he','ghi chu')   
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A0039',N' Hu?nh Tô Xinh',					'hfsbjfusgufs','81994711599','dgdughudjgb',3,'nguoi lien he','ghi chu')     


                                                                                                                                                                       
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1100',N' Bùi Van An',							'hfsbjfusgufs','87818699279','dgdughudjgb',3,'nguoi lien he','ghi chu')        
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1101',N' Nguy?n Phùng Nh?t Anh',	'hfsbjfusgufs','81812020480','dgdughudjgb',2,'nguoi lien he','ghi chu')          
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1102',N' Lê Ðình Chinh',					'hfsbjfusgufs','81031286729','dgdughudjgb',2,'nguoi lien he','ghi chu')          
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1103',N' Võ Th? Thùy Dung',				'hfsbjfusgufs','81864247945','dgdughudjgb',1,'nguoi lien he','ghi chu')        
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1104',N' Ðu?ng Trung H?u',				'hfsbjfusgufs','81032247423','dgdughudjgb',2,'nguoi lien he','ghi chu')          
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1105',N' Nguy?n Th? Hòa',					'hfsbjfusgufs','81920374323','dgdughudjgb',2,'nguoi lien he','ghi chu')        
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1106',N' Phùng Th? Hòa',					'hfsbjfusgufs','81613110425','dgdughudjgb',2,'nguoi lien he','ghi chu')          
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1107',N' Phan Van Hon',						'hfsbjfusgufs','81049998270','dgdughudjgb',3,'nguoi lien he','ghi chu')        
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1108',N' H? Anh Khoa',						'hfsbjfusgufs','81038798319','dgdughudjgb',1,'nguoi lien he','ghi chu')          
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1109',N' Nguy?n Th? Li?u',				'hfsbjfusgufs','81018944765','dgdughudjgb',2,'nguoi lien he','ghi chu')          
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1110',N' Phan Van Lôi',						'hfsbjfusgufs','81576081899','dgdughudjgb',3,'nguoi lien he','ghi chu')        
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1111',N' Lê H?u L?c',							'hfsbjfusgufs','81250258140','dgdughudjgb',1,'nguoi lien he','ghi chu')        
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1112',N' Tr?n Th? Kim L?i',				'hfsbjfusgufs','81383422966','dgdughudjgb',2,'nguoi lien he','ghi chu')        
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1113',N' Duong Tr?ng Lu?ng',			'hfsbjfusgufs','81239973871','dgdughudjgb',2,'nguoi lien he','ghi chu')          
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1114',N' Nguy?n Th? Kim Ngân',		'hfsbjfusgufs','81101633623','dgdughudjgb',1,'nguoi lien he','ghi chu')          
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1115',N' Thái Th? H?ng Nhung',		'hfsbjfusgufs','81193029880','dgdughudjgb',2,'nguoi lien he','ghi chu')          
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1116',N' Lý Minh Nh?t',						'hfsbjfusgufs','81300375025','dgdughudjgb',3,'nguoi lien he','ghi chu')        
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1117',N' Tr?n C?u Nuong',					'hfsbjfusgufs','81104603016','dgdughudjgb',2,'nguoi lien he','ghi chu')        
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1118',N' Tr?n Thanh Phong',				'hfsbjfusgufs','81775415591','dgdughudjgb',3,'nguoi lien he','ghi chu')        
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1119',N' Ðàm Minh Phú',						'hfsbjfusgufs','81388851004','dgdughudjgb',1,'nguoi lien he','ghi chu')        
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1120',N' Nguy?n Thanh Phuong',		'hfsbjfusgufs','81899775498','dgdughudjgb',2,'nguoi lien he','ghi chu')          
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1121',N' Lâm Thành Phu?c',				'hfsbjfusgufs','81642491106','dgdughudjgb',2,'nguoi lien he','ghi chu')          
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1122',N' Nguy?n Ðình Quí',				'hfsbjfusgufs','81306477313','dgdughudjgb',3,'nguoi lien he','ghi chu')          
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1123',N' Hu?nh Van Qu?c',					'hfsbjfusgufs','81516402175','dgdughudjgb',2,'nguoi lien he','ghi chu')        
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1124',N' Ngô B?o Qu?c',						'hfsbjfusgufs','81983751629','dgdughudjgb',3,'nguoi lien he','ghi chu')        
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1125',N' Duong Nh?t Quy?n',				'hfsbjfusgufs','81410100411','dgdughudjgb',1,'nguoi lien he','ghi chu')        
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1126',N' Hu?nh H?u Tâm',					'hfsbjfusgufs','81271508414','dgdughudjgb',1,'nguoi lien he','ghi chu')          
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1127',N' Ph?m Th? Minh Tâm',			'hfsbjfusgufs','81871795189','dgdughudjgb',1,'nguoi lien he','ghi chu')          
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1128',N' Nguy?n Van Thanh',				'hfsbjfusgufs','81065468886','dgdughudjgb',1,'nguoi lien he','ghi chu')        
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1129',N' Nguy?n H?u Thái',				'hfsbjfusgufs','81020473009','dgdughudjgb',1,'nguoi lien he','ghi chu')          
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1130',N' Võ Th? Kim Thoa',				'hfsbjfusgufs','81759724205','dgdughudjgb',1,'nguoi lien he','ghi chu')          
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1131',N' Nguy?n Th? Ng?c Thúy',		'hfsbjfusgufs','81653218768','dgdughudjgb',2,'nguoi lien he','ghi chu')        
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1132',N' Tr?n Th? Di?u Tín',			'hfsbjfusgufs','81483041285','dgdughudjgb',2,'nguoi lien he','ghi chu')          
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1133',N' Lâm Thái Toàn',					'hfsbjfusgufs','81508431119','dgdughudjgb',2,'nguoi lien he','ghi chu')          
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1134',N' Võ Th? Ki?u Trinh',			'hfsbjfusgufs','81985861539','dgdughudjgb',2,'nguoi lien he','ghi chu')          
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1135',N' Mai Van Tr?ng',					'hfsbjfusgufs','81650988777','dgdughudjgb',2,'nguoi lien he','ghi chu')          
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1136',N' Tr?n Thanh Tùng',				'hfsbjfusgufs','81728052940','dgdughudjgb',2,'nguoi lien he','ghi chu')          
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1137',N' Nguy?n Phu?c Vinh',			'hfsbjfusgufs','81968702610','dgdughudjgb',2,'nguoi lien he','ghi chu')          
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1138',N' Hu?nh Ng?c Thúy Vy',			'hfsbjfusgufs','81549414890','dgdughudjgb',1,'nguoi lien he','ghi chu')        
INSERT INTO [NhatQuang].[dbo].[tbl_DoiTac] VALUES ('A1139',N' Hu?nh Tô Xinh',					'hfsbjfusgufs','81994711599','dgdughudjgb',3,'nguoi lien he','ghi chu')          






