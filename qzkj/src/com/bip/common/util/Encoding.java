package com.bip.common.util;
/**************************************************************
 * Encoding.java
 *
 * 功能： 数据加密类
 * 类名： Encoding
 *
 *  version  变更日                 部门        担当者     变更内容
 *  ───────────────────────────────────────────
 *  V1.00   2010-8-10    CFIT   赵胜运      最终版
 *   
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 * LICENSE INFORMATION
 ****************************************************************/
import java.security.*;
import javax.crypto.*;
public class Encoding {
	private static String Algorithm = "DES"; // 定义 加密算法,可用 DES,DESede,Blowfish

	private static boolean debug = false;

	/**
	 * 算法提供商
	 */
	static {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
	}

	/**
	 * 构造方法
	 */
	public Encoding() {
	}

	/**
	 * 加密，内部使用
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
			System.out.println("加密前的二进串:" + byte2hex(input));
			System.out.println("加密前的字符串:" + (new String(input)));
		}
		Cipher c1 = Cipher.getInstance(Algorithm);
		c1.init(Cipher.ENCRYPT_MODE, deskey);
		byte[] cipherByte = c1.doFinal(input);
		if (debug) {
			System.out.println("加密后的二进串:" + byte2hex(cipherByte));
			System.out.println("加密后的字符串:'" + byte2string(cipherByte) + "'");
		}
		// return byte2string(cipherByte);
		return cipherByte;

	}

	// 解密
	private static byte[] decode(byte[] input, byte[] key) throws Exception {
		SecretKey deskey = new javax.crypto.spec.SecretKeySpec(key, Algorithm);
		if (debug)
			System.out.println("解密前的信息:" + byte2hex(input));
		Cipher c1 = Cipher.getInstance(Algorithm);
		c1.init(Cipher.DECRYPT_MODE, deskey);
		byte[] clearByte = c1.doFinal(input);
		if (debug) {
			System.out.println("解密后的二进串:" + byte2hex(clearByte));
			System.out.println("解密后的字符串:" + byte2string(clearByte));
		}
		return clearByte;
	}

	// md5()信息摘要, 不可逆
	private static String md5(byte[] input) throws Exception {
		java.security.MessageDigest alg = java.security.MessageDigest
				.getInstance("MD5"); // or "SHA-1"
		if (debug) {
			System.out.println("MD5摘要前的二进串:" + byte2hex(input));
			System.out.println("MD5摘要前的字符串:" + new String(input));
		}
		alg.update(input);
		byte[] digest = alg.digest();
		if (debug) {
			System.out.println("MD5摘要后的二进串:" + byte2hex(digest));
			// System.out.println("摘要后的字符串:"+new String(digest));
		}
		return byte2string(digest);
	}

	/**
	 * 字节码转换成16进制字符串 内部调试使用
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
	 * 字节码转换成自定义字符串 内部调试使用
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
	 * 加密接口
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
	 * MD5加密的接口，不可逆
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
			System.out.println("加密Encoding.java:" + e.toString());
		}
		return encodedText;
	}

	/**
	 * 加密（可逆）
	 * 
	 * @param inputText
	 * 原始文本
	 * @param newDebug
	 * 是否观看加密过程
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
				System.out.println("加密后信息串长度：" + encodedText.length());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("加密Encoding.java:" + e.toString());
		}
		return encodedText;
	}

	/**
	 * 解密
	 * 
	 * @param encodedText
	 * 加密的文本
	 * @param newDebug
	 * 是否观看解密过程
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
	 * 如果字节的高位为零，则补为1
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
