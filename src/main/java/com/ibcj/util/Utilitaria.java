package com.ibcj.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utilitaria {

	public static String md5(String senha) {
		MessageDigest m = null;
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.update(senha.getBytes(),0, senha.length());
		String hash = new BigInteger(1,m.digest()).toString(16);
		return hash;
	}
}
