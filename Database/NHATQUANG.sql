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

