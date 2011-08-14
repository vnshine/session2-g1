
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