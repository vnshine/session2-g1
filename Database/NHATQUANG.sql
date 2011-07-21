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
insert into dbo.tbl_NhanVien values('A0000',N' Bùi Văn An',1,10/10/1990,'85464653727',1)
insert into dbo.tbl_NhanVien values('A0001',N' Nguyễn Phùng Nhật Anh',2,11/10/1986,'81680575284',1)
insert into dbo.tbl_NhanVien values('A0002',N' Lê Đình Chinh',1,9/9/1989,'81277922541',1)
insert into dbo.tbl_NhanVien values('A0003',N' Võ Thị Thùy Dung',1,28/03/90,'81352672158',2)
insert into dbo.tbl_NhanVien values('A0004',N' Đường Trung Hậu',1,3/9/1989,'81582231377',1)
insert into dbo.tbl_NhanVien values('A0005',N' Nguyễn Thị Hòa',2,13/06/89,'81503121262',1)
insert into dbo.tbl_NhanVien values('A0006',N' Phùng Thị Hòa',2,18/11/88,'81255935474',1)
insert into dbo.tbl_NhanVien values('A0007',N' Phan Văn Hơn',1,18/11/89,'81199715193',1)
insert into dbo.tbl_NhanVien values('A0008',N' Hồ Anh Khoa',1,3/8/1990,'81953757776',2)
insert into dbo.tbl_NhanVien values('A0009',N' Nguyễn Thị Liểu',2,16/07/89,'81624527696',3)
insert into dbo.tbl_NhanVien values('A0010',N' Phan Văn Lôi',1,10/10/1986,'81552087396',2)
insert into dbo.tbl_NhanVien values('A0011',N' Lê Hữu Lộc',1,25/04/90,'81159540263',2)
insert into dbo.tbl_NhanVien values('A0012',N' Trần Thị Kim Lợi',2,27/10/85,'81195137386',3)
insert into dbo.tbl_NhanVien values('A0013',N' Dương Trọng Lượng',1,27/10/86,'81487212554',3)
insert into dbo.tbl_NhanVien values('A0014',N' Nguyễn Thị Kim Ngân',2,19/05/89,'81666157750',2)
insert into dbo.tbl_NhanVien values('A0015',N' Thái Thị Hồng Nhung',2,5/3/1990,'81149728661',1)
insert into dbo.tbl_NhanVien values('A0016',N' Lý Minh Nhựt',2,20/07/89,'81984343541',1)
insert into dbo.tbl_NhanVien values('A0017',N' Trần Cữu Nương',2,6/4/1985,'81909688531',3)
insert into dbo.tbl_NhanVien values('A0018',N' Trần Thanh Phong',1,3/2/1989,'81559592775',2)
insert into dbo.tbl_NhanVien values('A0019',N' Đàm Minh Phú',1,14/04/89,'81669944274',3)
insert into dbo.tbl_NhanVien values('A0020',N' Nguyễn Thanh Phương',1,29/04/89,'81443427274',1)
insert into dbo.tbl_NhanVien values('A0021',N' Lâm Thành Phước',1,13/03/88,'81972580028',1)
insert into dbo.tbl_NhanVien values('A0022',N' Nguyễn Đình Quí',1,13/05/88,'81604424182',2)
insert into dbo.tbl_NhanVien values('A0023',N' Huỳnh Văn Quốc',1,21/04/90,'81899310231',2)
insert into dbo.tbl_NhanVien values('A0024',N' Ngô Bảo Quốc',1,19/10/90,'81368964445',2)
insert into dbo.tbl_NhanVien values('A0025',N' Dương Nhật Quyện',1,5/5/1987,'81850337688',1)
insert into dbo.tbl_NhanVien values('A0026',N' Huỳnh Hữu Tâm',1,5/5/1988,'81514042053',1)
insert into dbo.tbl_NhanVien values('A0027',N' Phạm Thị Minh Tâm',2,22/07/89,'81429506763',3)
insert into dbo.tbl_NhanVien values('A0028',N' Nguyễn Văn Thanh',1,22/07/88,'81354538932',3)
insert into dbo.tbl_NhanVien values('A0029',N' Nguyễn Hữu Thái',1,4/3/1988,'81201464904',3)
insert into dbo.tbl_NhanVien values('A0030',N' Võ Thị Kim Thoa',2,3/2/1986,'81468429046',2)
insert into dbo.tbl_NhanVien values('A0031',N' Nguyễn Thị Ngọc Thúy',2,3/2/1987,'81367709784',2)
insert into dbo.tbl_NhanVien values('A0032',N' Trần Thị Diệu Tín',2,4/4/1989,'81586695003',1)
insert into dbo.tbl_NhanVien values('A0033',N' Lâm Thái Toàn',1,4/4/1990,'81034860485',3)
insert into dbo.tbl_NhanVien values('A0034',N' Võ Thị Kiều Trinh',2,3/2/1988,'81151279605',2)
insert into dbo.tbl_NhanVien values('A0035',N' Mai Văn Trọng',1,3/2/1989,'81211477888',2)
insert into dbo.tbl_NhanVien values('A0036',N' Trần Thanh Tùng',1,5/11/1988,'81821607875',2)
insert into dbo.tbl_NhanVien values('A0037',N' Nguyễn Phước Vinh',1,5/11/1989,'81195832413',3)
insert into dbo.tbl_NhanVien values('A0038',N' Huỳnh Ngọc Thúy Vy',2,14/06/90,'81490262771',3)
insert into dbo.tbl_NhanVien values('A0039',N' Huỳnh Tô Xinh',2,19/07/89,'81224832231',2)


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
	select * from (
	select top 10 * from (		
	select top (10*@soTrang) *
	from dbo.tbl_NhanVien order by PK_NhanVien ASC
	) a	order by PK_NhanVien DESC
	) b	order by PK_NhanVien ASC	
END

	
