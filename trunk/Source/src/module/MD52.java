package module;
import java.math.*;
import java.security.*;
public class MD52 {
	public String md5(String value) throws NoSuchAlgorithmException {		
		String toEnc = value; // Value to encrypt
		MessageDigest mdEnc = MessageDigest.getInstance("MD5"); // Encryption algorithm
		mdEnc.update(toEnc.getBytes(), 0, toEnc.length());
		String md5 = new BigInteger(1, mdEnc.digest()).toString(16); // Encrypted string
		return md5;
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		MD52 md5 = new MD52();
		System.out.println(md5.md5("mat khau"));
	}
}
