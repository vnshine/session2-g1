/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myobject;

/**
 *
 * @author liemmaster
 */
public class ChucNang 
{
    private String id;
    private String tenChucNang;
    private String ghiChu;

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenChucNang() {
        return tenChucNang;
    }

    public void setTenChucNang(String tenChucNang) {
        this.tenChucNang = tenChucNang;
    }
    
    public ChucNang(){};
    
    public ChucNang(String id, String ten, String ghichu)
    {
        this.id = id;
        this.tenChucNang = ten;
        this.ghiChu = ghichu;
    }
}
