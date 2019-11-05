package com.example.demo.datasecure;

import java.util.Base64;

public class EncryptionDecryption {
	public String dataEncode(String originalData) {
		String encodeData=Base64.getEncoder().encodeToString(originalData.getBytes());
		return encodeData;
	}
	
	public String decodeData(String encodedData) {
		if(encodedData==null) {
			encodedData="W0VtcHR5XQ==";  
		
		byte[] decode=Base64.getDecoder().decode(encodedData);
		String decodeData=new String(decode);
		return decodeData;
		}else {
			byte[] decode=Base64.getDecoder().decode(encodedData);
			String decodeData=new String(decode);
			return decodeData;
		}
	}
	

}
