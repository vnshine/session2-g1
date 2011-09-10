package module;

public class SysouPass {

	public static void main(String args[]){
		
		String md5Pass1 = MD5.MD5Password("nv001");
        System.out.println(md5Pass1);
        String md5Pass2 = MD5.MD5Password("nv002");
        System.out.println(md5Pass2);
        String md5Pass3 = MD5.MD5Password("nv003");
        System.out.println(md5Pass3);
        String md5Pass4 = MD5.MD5Password("nv004");
        System.out.println(md5Pass4);
        
	} 
}
