
-----------Proc kiểm tra đăng nhập
if(OBJECT_ID('sp_tblNhanVien_Login','p') is not null)
begin
	drop proc  sp_tblNhanVien_Login
end
GO

CREATE proc sp_tblNhanVien_Login
	@MaNhanVien varchar(6),
	@MatKhau varchar(50)
as
begin
	select * FROM tbl_NhanVien WHERE PK_sNhanVienID = @MaNhanVien AND sMatKhau = @MatKhau
end
go

--------------------------------
--Bảng chức năng
--------------------------------

-----------Proc Select danh sách các chức năng
if(OBJECT_ID('sp_tblChucNang_Select','p') is not null)
begin
	drop proc  sp_tblChucNang_Select
end
GO

CREATE proc sp_tblChucNang_Select
as
begin
	select * FROM tbl_ChucNang
end
go


-----------Proc Select danh sách các chức năng
if(OBJECT_ID('sp_tblChucNang_Find','p') is not null)
begin
	drop proc  sp_tblChucNang_Find
end
GO

CREATE proc sp_tblChucNang_Find
	@id varchar(15),
	@ten varchar(50),
	@ghichu varchar(100)
as
begin
	select * FROM tbl_ChucNang WHERE PK_sChucNangID LIKE '%' + @id + '%' OR sTenChucNang LIKE '%' + @ten + '%' OR sGhiChu LIKE '%' + @ghichu + '%'
end
go



-----------Proc thêm chức năng
if(OBJECT_ID('sp_tblChucNang_Insert','p') is not null)
begin
	drop proc  sp_tblChucNang_Insert
end
GO

CREATE proc sp_tblChucNang_Insert
	@id varchar(15),
	@ten varchar(50),
	@ghichu varchar(100)
as
begin
	insert INTO tbl_ChucNang VALUES(@id, @ten, @ghichu)
end
go

-----------Proc sửa chức năng
if(OBJECT_ID('sp_tblChucNang_Update','p') is not null)
begin
	drop proc  sp_tblChucNang_Update
end
GO

CREATE proc sp_tblChucNang_Update
	@old_id varchar(15),
	@new_id varchar(15),
	@ten varchar(50),
	@ghichu varchar(100)
as
begin
	update tbl_ChucNang SET PK_sChucNangID = @new_id, sTenChucNang = @ten, sGhiChu = @ghichu WHERE PK_sChucNangID = @old_id
end
go


-----------Proc xóa chức năng
if(OBJECT_ID('sp_tblChucNang_Delete','p') is not null)
begin
	drop proc  sp_tblChucNang_Delete
end
GO

CREATE proc sp_tblChucNang_Delete
	@id varchar(15)
as
begin
	Delete FROM tbl_ChucNang WHERE PK_sChucNangID = @id
end
go


-----------Proc kiểm tra có tồn tại ID
if(OBJECT_ID('sp_tblChucNang_duplicate','p') is not null)
begin
	drop proc  sp_tblChucNang_duplicate
end
GO

CREATE proc sp_tblChucNang_duplicate
	@id varchar(15),
	@ten varchar(50)
as
begin
	select * FROM tbl_ChucNang WHERE PK_sChucNangID = @id OR sTenChucNang = @ten
end
go


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
