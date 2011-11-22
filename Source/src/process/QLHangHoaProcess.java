
package process;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import myobject.DonViTinh;
import myobject.HangHoa;
import myobject.NhaSanXuat;
import myobject.NhomHang;
import connect.ioconnection;


public class QLHangHoaProcess 
{
	
	public Vector<NhomHang> getListNhomHang() throws Exception
    {
            Vector<NhomHang> result = new Vector<NhomHang>();
            Connection con = ioconnection.getConnection();
            try
            {
                    CallableStatement cst = con.prepareCall("SELECT *  FROM tbl_NhomHang where iTrangThai <2");
                    ResultSet rs =  cst.executeQuery();

                    while(rs.next())
                    {
                    	NhomHang varNhomHang = new NhomHang();
                    	varNhomHang.setID(rs.getInt("PK_iNhomHangID"));
                    	varNhomHang.setsTenNhomHang(rs.getString("sTenNhomHang"));
                    	varNhomHang.setsTenNhomHangEng(rs.getString("sTenNhomHangEng"));
                    	varNhomHang.setsGhiChu(rs.getString("sGhiChu"));
                        result.add(varNhomHang);
                    }
            }
            catch (Exception e)
            {
                    e.printStackTrace();
                    result = null;
            }
            finally
            {
                    ioconnection.closeConnection(con);	
                    return result;
            }
    }
	
	public Vector<NhaSanXuat> getListNhaSanXuat() throws Exception
    {
            Vector<NhaSanXuat> result = new Vector<NhaSanXuat>();
            Connection con = ioconnection.getConnection();
            try
            {
                    CallableStatement cst = con.prepareCall("SELECT * FROM tbl_NhaSanXuat where iTrangThai<2");
                    ResultSet rs =  cst.executeQuery();

                    while(rs.next())
                    {
                    	NhaSanXuat varNhaSanXuat = new NhaSanXuat();
                    	varNhaSanXuat.setPK_sNhaSanXuatID(rs.getString("PK_sNhaSanXuatID"));
                    	varNhaSanXuat.setsTenNhaSanXuat(rs.getString("sTenNhaSanXuat"));
                    	varNhaSanXuat.setsTenNhaSanXuatEng(rs.getString("sTenNhaSanXuatEng"));
                    	varNhaSanXuat.setsGhiChu(rs.getString("sGhiChu"));
                        result.add(varNhaSanXuat);
                    }
            }
            catch (Exception e)
            {
                    e.printStackTrace();
                    result = null;
            }
            finally
            {
                    ioconnection.closeConnection(con);	
                    return result;
            }
    }
	
	public Vector<DonViTinh> getListDonViTinh() throws Exception
    {
            Vector<DonViTinh> result = new Vector<DonViTinh>();
            Connection con = ioconnection.getConnection();
            try
            {
                    CallableStatement cst = con.prepareCall("SELECT * FROM tbl_DonViTinh");
                    ResultSet rs =  cst.executeQuery();

                    while(rs.next())
                    {
                    	DonViTinh varDonViTinh = new DonViTinh();
                    	varDonViTinh.setPK_sDonViTinhID(rs.getString("PK_iDonViTinhID"));
                    	varDonViTinh.setsTenDonViTinh(rs.getString("sTenDonViTinh"));
                    	varDonViTinh.setsTenDonViTinhEng(rs.getString("sTenDonViTinhEng"));
                    	varDonViTinh.setsGhiChu(rs.getString("sGhiChu"));
                        result.add(varDonViTinh);
                    }
            }
            catch (Exception e)
            {
                    e.printStackTrace();
                    result = null;
            }
            finally
            {
                    ioconnection.closeConnection(con);	
                    return result;
            }
    }
	public Vector<HangHoa> getListHangHoa(Integer soTrang) throws SQLException
    {
            Vector<HangHoa> result = new Vector<HangHoa>();
            Connection con = ioconnection.getConnection();
            try
            {
                    CallableStatement cst = con.prepareCall("{call DanhSach_HangHoa(?)}");
					cst.setInt(1, soTrang);
                    ResultSet rs =  cst.executeQuery();

                    while(rs.next())
                    {
                    	HangHoa varHangHoa = new HangHoa();
                    	varHangHoa.setPK_iHangHoaID(rs.getInt("PK_iHangHoaID"));
                    	varHangHoa.setsTenHangHoa(rs.getString("sTenHangHoa"));
                    	varHangHoa.setsTenHangHoaEng(rs.getString("sTenHangHoaEng"));
                    	varHangHoa.setiGiaMua(rs.getInt("iGiaMua"));
                    	varHangHoa.setiGiaBanBuon(rs.getInt("iGiaBanBuon"));
                    	varHangHoa.setiGiaBanLe(rs.getInt("iGiaBanLe"));
                    	varHangHoa.setsNgayNhap(rs.getString("sNgayNhap"));
                    	varHangHoa.setsNgayHetHan(rs.getString("sNgayHetHan"));
                    	varHangHoa.setsGhiChu(rs.getString("sGhiChu"));
                    	varHangHoa.setiVAT(rs.getInt("iVAT"));
                    	varHangHoa.setFK_sDoiTacID(rs.getString("fK_sDoiTacID"));
                    	varHangHoa.setFK_sNhaSanXuatID(rs.getString("fK_sNhaSanXuatID"));
                    	varHangHoa.setFK_iDonViTinhID(rs.getInt("fK_iDonViTinhID"));
                    	varHangHoa.setFK_iNhomHangID(rs.getInt("fK_iNhomHangID"));
//con thieu thong tin chi tiet                    	
                        result.add(varHangHoa);
                    }
            }
            catch (Exception e)
            {
                    e.printStackTrace();
                    result = null;
            }
            finally
            {
                    ioconnection.closeConnection(con);	
                    return result;
            }
    }
    public Integer getsoHangHoa() throws SQLException
    {
    		Integer result = 0;
            Connection con = ioconnection.getConnection();
            try
            {           
                    CallableStatement soLuongRecod = con.prepareCall("{call SoLuong_HangHoa()}");
                    ResultSet rs1 =  soLuongRecod.executeQuery();
					rs1.next();
					result = rs1.getInt(1);
            }
            catch (Exception e)
            {
                    e.printStackTrace();
                    result = 0;
            }
            finally
            {
                    ioconnection.closeConnection(con);	
                    return result;
            }
    }
    
    public boolean checkTenHangHoa( String Name) throws SQLException
    {
    		Integer result = 0;
            Connection con = ioconnection.getConnection();
            try
            {
                    CallableStatement cst = con.prepareCall("{call sp_tblHangHoa_duplicate(?)}");
                    cst.setString(1, Name);
                    ResultSet rs =  cst.executeQuery();
                    rs.next();
					result = rs.getInt(1);
					//System.out.println(result);
            }
            catch (Exception e)
            {
                    e.printStackTrace();
                    result = 0;
            }
            finally
            {
                    ioconnection.closeConnection(con);	
                    if (result > 0) {
                    	return false;
					}
                    return true;
            }
    }
    public boolean checkTenHangHoaEdit( String tenTruoc, String tenSau) throws SQLException
    {
    		Integer result = 0;
            Connection con = ioconnection.getConnection();
            try
            {
                    CallableStatement cst = con.prepareCall("{call sp_tblHangHoa_duplicate2(?,?)}");
                    cst.setString(1, tenTruoc);
                    cst.setString(2, tenSau);
                    ResultSet rs =  cst.executeQuery();
                    rs.next();
					result = rs.getInt(1);
					//System.out.println(result);
            }
            catch (Exception e)
            {
                    e.printStackTrace();
                    result = 0;
            }
            finally
            {
                    ioconnection.closeConnection(con);	
                    if (result > 0) {
                    	return false;
					}
                    return true;
            }
    }
    public boolean ThemHangHoa(HangHoa HangHoa) throws SQLException
    {
            Connection cn = ioconnection.getConnection();
            Boolean success = true;
            try 
            {
                    CallableStatement cst = cn.prepareCall("{call sp_tblHangHoa_Insert (?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                    cst.setString(1,  HangHoa.getsTenHangHoa           ());
                    cst.setString(2,  HangHoa.getsTenHangHoaEng        ());
                    cst.setInt(3,  HangHoa.getiGiaMua               ());
                    cst.setInt(4,  HangHoa.getiGiaBanBuon           ());
                    cst.setInt(5,  HangHoa.getiGiaBanLe             ());
                    cst.setString(6,  HangHoa.getsNgayNhap             ());
                    cst.setString(7,  HangHoa.getsNgayHetHan           ());
                    cst.setString(8,  HangHoa.getsGhiChu               ());
                    cst.setInt(9,  HangHoa.getiVAT                  ());
                    cst.setString(10, HangHoa.getFK_sDoiTacID          ());
                    cst.setString(11, HangHoa.getFK_sNhaSanXuatID      ());
                    cst.setInt(12, HangHoa.getFK_iDonViTinhID       ());
                    cst.setInt(13, HangHoa.getFK_iNhomHangID        ());
 
                    cst.execute();
            } 
            catch (SQLException e)
            {
                    e.printStackTrace();
                    //cn.rollback();
                    success = false;
            }
            finally
            {
                    ioconnection.closeConnection(cn);
                    return success;
            }
    }
    
//chua lam sua
    public boolean SuaHangHoa(HangHoa HangHoa,Integer id) throws SQLException
    {
            Connection cn = ioconnection.getConnection();
            Boolean success = true;
            try 
            {
                CallableStatement cst = cn.prepareCall("{call sp_tblHangHoa_Update (?,?,?,?)}");
                cst.setInt(1, id);
                cst.setString(2, HangHoa.getsTenHangHoa());
                cst.setString(3, HangHoa.getsTenHangHoaEng());
                cst.setString(4, HangHoa.getsGhiChu());
                cst.execute();
            } 
            catch (SQLException e)
            {
                e.printStackTrace();
                success = false;
            }
            finally
            {
                    ioconnection.closeConnection(cn);
                    return success;
            }
    }
    public boolean XoaHangHoa(Integer maHangHoa) throws SQLException
    {
            Connection con = (Connection) ioconnection.getConnection();
            try
            {
                CallableStatement cst = con.prepareCall("{call sp_tblHangHoa_Delete (?)}");         
                cst.setInt(1,maHangHoa);
                cst.execute();
            }
            catch (Exception e)
            {
                    e.printStackTrace();
                    return false;
            }
            finally
            {
                ioconnection.closeConnection(con);
                return true;
            }    
    }
    public Vector<String> getSuggestData(String key) throws SQLException
    {
            //Vector<HangHoa> result = new Vector<HangHoa>();
            Vector<String> result = new Vector<String>();
            Connection con = ioconnection.getConnection();
            try
            {
            		key = key.toLowerCase();
                    CallableStatement cst = con.prepareCall("{call SuggestData(?)}");
					cst.setString(1, key);
                    ResultSet rs =  cst.executeQuery();
                    while(rs.next())
                    {
                    	if (rs.getString("sTenHangHoa").startsWith(key)) {result.add(rs.getString("sTenHangHoa"));}
                    	if (((rs.getString("sTenHangHoaEng")).toLowerCase()).startsWith(key)) {result.add(rs.getString("sTenHangHoaEng"));}
                    	if (((rs.getString("sGhiChu")).toLowerCase()).startsWith(key)) {result.add(rs.getString("sGhiChu"));}
                    }

            }
            catch (Exception e)
            {
                    e.printStackTrace();
                    result = null;
            }
            finally
            {
                    ioconnection.closeConnection(con);	
                    return result;
            }
    }
    
    
    
    public static void main(String[] args) throws SQLException {
    	QLHangHoaProcess a = new QLHangHoaProcess();
    	System.out.println(a.checkTenHangHoa("bdff"));
//    	System.out.println(a.getListHangHoa(1));
//    	System.out.println(a.getListSearched(1, "dgdsb"));
//    	System.out.println(a.getSoLuongKQ("hsdhjd"));
//    	System.out.println(a.getsoHangHoa());
//    	System.out.println(a.getSuggestData("shsh"));
    }
}
