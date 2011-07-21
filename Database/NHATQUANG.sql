SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Co so du lieu: NHATQUANG
-- =============================================
USE master
GO

IF  EXISTS (
	SELECT name 
		FROM sys.databases 
		WHERE name = N'NHATQUANG'
)
DROP DATABASE NHATQUANG
GO

CREATE DATABASE NHATQUANG
GO

use NHATQUANG
go

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tbl_SanPham]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[tbl_SanPham](
	[PK_SanPham] [int] IDENTITY(1,1) NOT NULL,
	[sTenSanPham] [nvarchar](100) NOT NULL,
	[sDonViTinh] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_tbl_SanPham] PRIMARY KEY CLUSTERED 
(
	[PK_SanPham] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tbl_DonVi]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[tbl_DonVi](
	[PK_DonVi] [int] IDENTITY(1,1) NOT NULL,
	[sTenDonVi] [nvarchar](100) NOT NULL,
	[sDiaChi] [nvarchar](200) NULL,
	[sSoDienThoai] [varchar](13) NULL,
 CONSTRAINT [PK_tbl_DonVi] PRIMARY KEY CLUSTERED 
(
	[PK_DonVi] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tbl_NhanVien]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[tbl_NhanVien](
	[PK_NhanVien] [varchar](5) NOT NULL,
	[sHoTen] [nvarchar](50) NOT NULL,
	[iGioiTinh] [int] NOT NULL,
	[dNgaySinh] [datetime] NULL,
	[sSoDienThoai] [nchar](15) NULL,
	[iTrangThai] [int] NOT NULL,
 CONSTRAINT [PK_tbl_NguoiDung] PRIMARY KEY CLUSTERED 
(
	[PK_NhanVien] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tbl_TrietKhau]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[tbl_TrietKhau](
	[PK_TrietKhau] [int] NOT NULL,
	[fSoTien] [float] NOT NULL,
	[iPhanTram] [int] NOT NULL,
 CONSTRAINT [PK_tbl_TrietKhau] PRIMARY KEY CLUSTERED 
(
	[PK_TrietKhau] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tbl_Phieu]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[tbl_Phieu](
	[PK_Phieu] [varchar](10) NOT NULL,
	[dNgayThang] [datetime] NOT NULL,
	[fDonGia] [float] NOT NULL,
	[fThanhTien] [float] NOT NULL,
	[fConNo] [float] NOT NULL,
	[iTrangThai] [int] NOT NULL,
	[FK_DonVi] [int] NULL,
	[FK_KhachHang] [varchar](5) NOT NULL,
	[FK_NhanVien] [varchar](5) NOT NULL,
 CONSTRAINT [PK_tbl_Phieu] PRIMARY KEY CLUSTERED 
(
	[PK_Phieu] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tbl_ChiTietPhieu]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[tbl_ChiTietPhieu](
	[FK_Phieu] [varchar](10) NOT NULL,
	[FK_SanPham] [int] NOT NULL,
	[iSoLuong] [int] NOT NULL,
 CONSTRAINT [PK_tbl_ChiTietPhieu] PRIMARY KEY CLUSTERED 
(
	[FK_Phieu] ASC,
	[FK_SanPham] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tbl_KhachHang]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[tbl_KhachHang](
	[PK_KhachHang] [varchar](5) NOT NULL,
	[sHoTen] [nvarchar](50) NULL,
	[dNgaySinh] [datetime] NULL,
	[sSoDienThoai] [varchar](13) NULL,
	[sDiaChi] [nvarchar](200) NULL,
	[iTrangThai] [int] NOT NULL,
	[FK_DonVi] [int] NULL,
 CONSTRAINT [PK_tbl_KhachHang] PRIMARY KEY CLUSTERED 
(
	[PK_KhachHang] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_tbl_Phieu_tbl_DonVi]') AND parent_object_id = OBJECT_ID(N'[dbo].[tbl_Phieu]'))
ALTER TABLE [dbo].[tbl_Phieu]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Phieu_tbl_DonVi] FOREIGN KEY([FK_DonVi])
REFERENCES [dbo].[tbl_DonVi] ([PK_DonVi])
GO
ALTER TABLE [dbo].[tbl_Phieu] CHECK CONSTRAINT [FK_tbl_Phieu_tbl_DonVi]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_tbl_Phieu_tbl_KhachHang]') AND parent_object_id = OBJECT_ID(N'[dbo].[tbl_Phieu]'))
ALTER TABLE [dbo].[tbl_Phieu]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Phieu_tbl_KhachHang] FOREIGN KEY([FK_KhachHang])
REFERENCES [dbo].[tbl_KhachHang] ([PK_KhachHang])
GO
ALTER TABLE [dbo].[tbl_Phieu] CHECK CONSTRAINT [FK_tbl_Phieu_tbl_KhachHang]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_tbl_Phieu_tbl_NhanVien]') AND parent_object_id = OBJECT_ID(N'[dbo].[tbl_Phieu]'))
ALTER TABLE [dbo].[tbl_Phieu]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Phieu_tbl_NhanVien] FOREIGN KEY([FK_NhanVien])
REFERENCES [dbo].[tbl_NhanVien] ([PK_NhanVien])
GO
ALTER TABLE [dbo].[tbl_Phieu] CHECK CONSTRAINT [FK_tbl_Phieu_tbl_NhanVien]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_tbl_ChiTietPhieu_tbl_Phieu]') AND parent_object_id = OBJECT_ID(N'[dbo].[tbl_ChiTietPhieu]'))
ALTER TABLE [dbo].[tbl_ChiTietPhieu]  WITH CHECK ADD  CONSTRAINT [FK_tbl_ChiTietPhieu_tbl_Phieu] FOREIGN KEY([FK_Phieu])
REFERENCES [dbo].[tbl_Phieu] ([PK_Phieu])
GO
ALTER TABLE [dbo].[tbl_ChiTietPhieu] CHECK CONSTRAINT [FK_tbl_ChiTietPhieu_tbl_Phieu]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_tbl_ChiTietPhieu_tbl_SanPham]') AND parent_object_id = OBJECT_ID(N'[dbo].[tbl_ChiTietPhieu]'))
ALTER TABLE [dbo].[tbl_ChiTietPhieu]  WITH CHECK ADD  CONSTRAINT [FK_tbl_ChiTietPhieu_tbl_SanPham] FOREIGN KEY([FK_SanPham])
REFERENCES [dbo].[tbl_SanPham] ([PK_SanPham])
GO
ALTER TABLE [dbo].[tbl_ChiTietPhieu] CHECK CONSTRAINT [FK_tbl_ChiTietPhieu_tbl_SanPham]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_tbl_KhachHang_tbl_DonVi]') AND parent_object_id = OBJECT_ID(N'[dbo].[tbl_KhachHang]'))
ALTER TABLE [dbo].[tbl_KhachHang]  WITH CHECK ADD  CONSTRAINT [FK_tbl_KhachHang_tbl_DonVi] FOREIGN KEY([FK_DonVi])
REFERENCES [dbo].[tbl_DonVi] ([PK_DonVi])
GO
ALTER TABLE [dbo].[tbl_KhachHang] CHECK CONSTRAINT [FK_tbl_KhachHang_tbl_DonVi]
-- Du lieu Nhan Vien
insert into dbo.tbl_NhanVien values('A0000',N' Bùi Văn An',10/10/1990,1,'88132251576',2)
insert into dbo.tbl_NhanVien values('A0001',N' Nguyễn Phùng Nhật Anh',11/10/1986,2,'81250406520',2)
insert into dbo.tbl_NhanVien values('A0002',N' Lê Đình Chinh',9/9/1989,1,'81938137809',2)
insert into dbo.tbl_NhanVien values('A0003',N' Võ Thị Thùy Dung',28/03/90,1,'81551571778',2)
insert into dbo.tbl_NhanVien values('A0004',N' Đường Trung Hậu',3/9/1989,1,'81746237583',1)
insert into dbo.tbl_NhanVien values('A0005',N' Nguyễn Thị Hòa',13/06/89,2,'81017201180',3)
insert into dbo.tbl_NhanVien values('A0006',N' Phùng Thị Hòa',18/11/88,2,'81998194589',3)
insert into dbo.tbl_NhanVien values('A0007',N' Phan Văn Hơn',18/11/89,1,'81598880211',2)
insert into dbo.tbl_NhanVien values('A0008',N' Hồ Anh Khoa',3/8/1990,1,'81499884051',1)
insert into dbo.tbl_NhanVien values('A0009',N' Nguyễn Thị Liểu',16/07/89,2,'81285779737',2)
insert into dbo.tbl_NhanVien values('A0010',N' Phan Văn Lôi',10/10/1986,1,'81539997799',2)
insert into dbo.tbl_NhanVien values('A0011',N' Lê Hữu Lộc',25/04/90,1,'81977432124',1)
insert into dbo.tbl_NhanVien values('A0012',N' Trần Thị Kim Lợi',27/10/85,2,'81125678855',2)
insert into dbo.tbl_NhanVien values('A0013',N' Dương Trọng Lượng',27/10/86,1,'81409535163',3)
insert into dbo.tbl_NhanVien values('A0014',N' Nguyễn Thị Kim Ngân',19/05/89,2,'81169072343',2)
insert into dbo.tbl_NhanVien values('A0015',N' Thái Thị Hồng Nhung',5/3/1990,2,'81348671071',1)
insert into dbo.tbl_NhanVien values('A0016',N' Lý Minh Nhựt',20/07/89,2,'81391010864',2)
insert into dbo.tbl_NhanVien values('A0017',N' Trần Cữu Nương',6/4/1985,2,'81600352803',2)
insert into dbo.tbl_NhanVien values('A0018',N' Trần Thanh Phong',3/2/1989,1,'81674644717',1)
insert into dbo.tbl_NhanVien values('A0019',N' Đàm Minh Phú',14/04/89,1,'81873585366',2)
insert into dbo.tbl_NhanVien values('A0020',N' Nguyễn Thanh Phương',29/04/89,1,'81961550371',3)
insert into dbo.tbl_NhanVien values('A0021',N' Lâm Thành Phước',13/03/88,1,'81895679752',3)
insert into dbo.tbl_NhanVien values('A0022',N' Nguyễn Đình Quí',13/05/88,1,'81706564320',3)
insert into dbo.tbl_NhanVien values('A0023',N' Huỳnh Văn Quốc',21/04/90,1,'81177141642',2)
insert into dbo.tbl_NhanVien values('A0024',N' Ngô Bảo Quốc',19/10/90,1,'81847109277',3)
insert into dbo.tbl_NhanVien values('A0025',N' Dương Nhật Quyện',5/5/1987,1,'81321320123',2)
insert into dbo.tbl_NhanVien values('A0026',N' Huỳnh Hữu Tâm',5/5/1988,1,'81393870633',1)
insert into dbo.tbl_NhanVien values('A0027',N' Phạm Thị Minh Tâm',22/07/89,2,'81711857400',2)
insert into dbo.tbl_NhanVien values('A0028',N' Nguyễn Văn Thanh',22/07/88,1,'81739938147',2)
insert into dbo.tbl_NhanVien values('A0029',N' Nguyễn Hữu Thái',4/3/1988,1,'81339647837',3)
insert into dbo.tbl_NhanVien values('A0030',N' Võ Thị Kim Thoa',3/2/1986,2,'81394988846',3)
insert into dbo.tbl_NhanVien values('A0031',N' Nguyễn Thị Ngọc Thúy',3/2/1987,2,'81630314378',2)
insert into dbo.tbl_NhanVien values('A0032',N' Trần Thị Diệu Tín',4/4/1989,2,'81139618433',1)
insert into dbo.tbl_NhanVien values('A0033',N' Lâm Thái Toàn',4/4/1990,1,'81259058493',2)
insert into dbo.tbl_NhanVien values('A0034',N' Võ Thị Kiều Trinh',3/2/1988,2,'81555325345',3)
insert into dbo.tbl_NhanVien values('A0035',N' Mai Văn Trọng',3/2/1989,1,'81971778487',1)
insert into dbo.tbl_NhanVien values('A0036',N' Trần Thanh Tùng',5/11/1988,1,'81700714978',3)
insert into dbo.tbl_NhanVien values('A0037',N' Nguyễn Phước Vinh',5/11/1989,1,'81104257475',2)
insert into dbo.tbl_NhanVien values('A0038',N' Huỳnh Ngọc Thúy Vy',14/06/90,2,'81369309668',1)
insert into dbo.tbl_NhanVien values('A0039',N' Huỳnh Tô Xinh',19/07/89,2,'81240280026',2)


-- Tao procedure Nhan Vien
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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

GO
CREATE PROCEDURE DeleteNhanVien 
	@PK_NhanVien varchar(5)
AS
BEGIN
	UPDATE dbo.tbl_NhanVien
	SET iTrangThai = (iTrangThai + 9000) 
	WHERE PK_NhanVien = @PK_NhanVien
END


GO
CREATE PROCEDURE XemTrang 
	@soTrang int
AS
BEGIN
	
	select top 10 * from (
		select top 2*10 *
		from dbo.tbl_NhanVien order by PK_NhanVien ASC
	) c order by column_name DESC	
END


