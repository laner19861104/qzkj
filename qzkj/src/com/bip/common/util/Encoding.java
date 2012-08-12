package com.bip.common.util;
/**************************************************************
 * Encoding.java
 *
 * ���ܣ� ���ݼ�����
 * ������ Encoding
 *
 *  version  �����                 ����        ������     �������
 *  ��������������������������������������������������������������������������������������
 *  V1.00   2010-8-10    CFIT   ��ʤ��      ���հ�
 *   
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 * LICENSE INFORMATION
 ****************************************************************/
import java.security.*;
import javax.crypto.*;
public class Encoding {
	private static String Algorithm = "DES"; // ���� �����㷨,���� DES,DESede,Blowfish

	private static boolean debug = false;

	/**
	 * �㷨�ṩ��
	 */
	static {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
	}

	/**
	 * ���췽��
	 */
	public Encoding() {
	}

	/**
	 * ���ܣ��ڲ�ʹ��
	 * 
	 * @author sun
	 * @since 1.0
	 * @param input
	 * @param key
	 * @return
	 * @throws Exception
	 */
	private static byte[] encode(byte[] input, byte[] key) throws Exception {
		SecretKey deskey = new javax.crypto.spec.SecretKeySpec(key, Algorithm);
		if (debug) {
			System.out.println("����ǰ�Ķ�����:" + byte2hex(input));
			System.out.println("����ǰ���ַ���:" + (new String(input)));
		}
		Cipher c1 = Cipher.getInstance(Algorithm);
		c1.init(Cipher.ENCRYPT_MODE, deskey);
		byte[] cipherByte = c1.doFinal(input);
		if (debug) {
			System.out.println("���ܺ�Ķ�����:" + byte2hex(cipherByte));
			System.out.println("���ܺ���ַ���:'" + byte2string(cipherByte) + "'");
		}
		// return byte2string(cipherByte);
		return cipherByte;

	}

	// ����
	private static byte[] decode(byte[] input, byte[] key) throws Exception {
		SecretKey deskey = new javax.crypto.spec.SecretKeySpec(key, Algorithm);
		if (debug)
			System.out.println("����ǰ����Ϣ:" + byte2hex(input));
		Cipher c1 = Cipher.getInstance(Algorithm);
		c1.init(Cipher.DECRYPT_MODE, deskey);
		byte[] clearByte = c1.doFinal(input);
		if (debug) {
			System.out.println("���ܺ�Ķ�����:" + byte2hex(clearByte));
			System.out.println("���ܺ���ַ���:" + byte2string(clearByte));
		}
		return clearByte;
	}

	// md5()��ϢժҪ, ������
	private static String md5(byte[] input) throws Exception {
		java.security.MessageDigest alg = java.security.MessageDigest
				.getInstance("MD5"); // or "SHA-1"
		if (debug) {
			System.out.println("MD5ժҪǰ�Ķ�����:" + byte2hex(input));
			System.out.println("MD5ժҪǰ���ַ���:" + new String(input));
		}
		alg.update(input);
		byte[] digest = alg.digest();
		if (debug) {
			System.out.println("MD5ժҪ��Ķ�����:" + byte2hex(digest));
			// System.out.println("ժҪ����ַ���:"+new String(digest));
		}
		return byte2string(digest);
	}

	/**
	 * �ֽ���ת����16�����ַ��� �ڲ�����ʹ��
	 * 
	 * @param b
	 * @return
	 */
	private static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
			if (n < b.length - 1)
				hs = hs + ":";
		}
		return hs.toUpperCase();
	}

	/**
	 * �ֽ���ת�����Զ����ַ��� �ڲ�����ʹ��
	 * 
	 * @param b
	 * @return
	 */
	private static String byte2string(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
			// if (n<b.length-1) hs=hs+":";
		}
		return hs.toUpperCase();
	}

	private static byte[] string2byte(String hs) {
		byte[] b = new byte[hs.length() / 2];
		for (int i = 0; i < hs.length(); i = i + 2) {
			String sub = hs.substring(i, i + 2);
			byte bb = new Integer(Integer.parseInt(sub, 16)).byteValue();
			b[i / 2] = bb;
		}
		return b;
	}

	/**
	 * ���ܽӿ�
	 * 
	 * @author sun
	 * @since 1.0
	 * @param text
	 * @return
	 */
	public static String encodeCmd(String text) {
		return encodeCmd("wudi" + text + "yt", false);
	}

	/**
	 * MD5���ܵĽӿڣ�������
	 * 
	 * @author sun
	 * @since 1.0
	 * @param text
	 * @param newDebug
	 * @return
	 */
	public static String encodeCmd(String text, boolean newDebug) {
		String encodedText = new String();

		try {
			encodedText = md5(text.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("����Encoding.java:" + e.toString());
		}
		return encodedText;
	}

	/**
	 * ���ܣ����棩
	 * 
	 * @param inputText
	 * ԭʼ�ı�
	 * @param newDebug
	 * �Ƿ�ۿ����ܹ���
	 * @return
	 */
	public static String encodingCanDecode(String inputText, boolean newDebug) {
		byte[] key;
		debug = newDebug;
		String keyText = "CFIT-Weifang";
		String encodedText = null;
		key = keyText.getBytes();
		try {
			encodedText = byte2string(encode(inputText.getBytes(), key));
			if (debug) {
				System.out.println("���ܺ���Ϣ�����ȣ�" + encodedText.length());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("����Encoding.java:" + e.toString());
		}
		return encodedText;
	}

	/**
	 * ����
	 * 
	 * @param encodedText
	 * ���ܵ��ı�
	 * @param newDebug
	 * �Ƿ�ۿ����ܹ���
	 * @return
	 */
	public static String decoding(String encodedText, boolean newDebug) {
		byte[] key;
		debug = newDebug;
		String keyText = "CFIT-Weifang";
		String decodedText = null;
		key = keyText.getBytes();
		byte[] b = string2byte(encodedText);
		try {
			byte[] bb = decode(b, key);
			String temp = byte2string(bb);
			decodedText = new String(bb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decodedText;
	}

	/**
	 * ����ֽڵĸ�λΪ�㣬��Ϊ1
	 * 
	 * @param byt
	 */
	public static String fixupByte(byte byt[]) {
		String result = null;
		for (int i = 0; i < byt.length; i++) {
			if ((int) byt[i] < 0x80)
				byt[i] |= (byte) 0x80;
		}
		try {
			result = new String(byt, "GBK");
		} catch (java.io.UnsupportedEncodingException ex) {
			ex.printStackTrace();
		}

		return result;
	}
}
