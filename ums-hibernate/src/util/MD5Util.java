package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5Util {
	public static String md5(String src){
		try {
			MessageDigest digest=MessageDigest.getInstance("MD5");
			
			byte[] b=digest.digest(src.getBytes());
			
//			return new String(b);
			BASE64Encoder encoder=new BASE64Encoder();
			return encoder.encode(b);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(md5("admin"));
		
	}
	
	
	
	
}
