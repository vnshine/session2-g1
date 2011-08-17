/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myobject;

/**
 *
 * @author liemmaster
 */
public class ObjQuyen 
{
    private Integer id;
    private String ten;
    private String ghiChu;

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public ObjQuyen(){};
    
    public ObjQuyen(Integer id, String ten, String ghichu)
    {
        this.id = id;
        this.ten = ten;
        this.ghiChu = ghichu;
    }
}
