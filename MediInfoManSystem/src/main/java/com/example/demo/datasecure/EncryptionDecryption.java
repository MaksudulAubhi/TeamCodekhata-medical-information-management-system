package com.example.demo.datasecure;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

public class EncryptionDecryption {
	private static final String key="aesEncryptionKey";
	private static final String initVector="encryptionIntVec";
	
	
	public String encrypt(String value) {
		try {
			IvParameterSpec iv=new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec secretkey= new SecretKeySpec(key.getBytes("UTF-8"), "AES");
			Cipher cipher=Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, secretkey,iv);
			
			byte[]encrypted=cipher.doFinal(value.getBytes("UTF-8"));
			
			return Base64.encodeBase64String(encrypted);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public String decrypt(String encrypted) {
		try {
			if(encrypted==null) {
				return"[Empty]";
			}
			IvParameterSpec iv=new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec secretkey= new SecretKeySpec(key.getBytes("UTF-8"), "AES");
			Cipher cipher=Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretkey,iv);
			
			byte[]original=cipher.doFinal(Base64.decodeBase64(encrypted));
			
			return new String(original);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public String dataEncode(String data) {
		return encrypt(data);
	}
	public String decodeData(String data) {
		return decrypt(data);
	}
	
	
	
	
	
	
	
	

}
