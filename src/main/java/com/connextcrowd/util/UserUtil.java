package com.connextcrowd.util;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public class UserUtil {
	public static String encodePwd(String input) throws Exception {
		// http://www.devarticles.com/c/a/Java/Password-Encryption-Rationale-and-Java-Example
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA");
			md.update(input.getBytes("UTF-8"));
		} catch (Exception e) {
			
			throw e;
		}
		byte raw[] = md.digest();
		@SuppressWarnings("restriction")
		String decryptedInput = (new BASE64Encoder()).encode(raw);
		return decryptedInput;
	}
}
