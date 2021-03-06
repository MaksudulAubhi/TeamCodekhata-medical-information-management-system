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
				return"";
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
	//For integer.............................
	public int encryptInt(int data) {
		String value=String.valueOf(data);
		try {
			IvParameterSpec iv=new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec secretkey= new SecretKeySpec(key.getBytes("UTF-8"), "AES");
			Cipher cipher=Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, secretkey,iv);
			
			byte[]encrypted=cipher.doFinal(value.getBytes("UTF-8"));
			
			return Integer.parseInt(Base64.encodeBase64String(encrypted));
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}
	
	public int decryptInt(int data) {
		String encrypted=String.valueOf(data);
		try {
			if(encrypted==null) {
				return 0;
			}
			IvParameterSpec iv=new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec secretkey= new SecretKeySpec(key.getBytes("UTF-8"), "AES");
			Cipher cipher=Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretkey,iv);
			
			byte[]original=cipher.doFinal(Base64.decodeBase64(encrypted));
			
			return Integer.parseInt(new String(original));
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}
	
	public int dataEncodeInt(int data) {
		return encryptInt(data);
	}
	public int decodeDataInt(int data) {
		return decryptInt(data);
	}
	
	
	
	
	
	
	
	

}
