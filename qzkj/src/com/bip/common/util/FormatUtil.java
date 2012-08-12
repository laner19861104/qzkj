package com.bip.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatUtil {
	static NumberFormat numberFormat=NumberFormat.getInstance();
	static NumberFormat formatter2 = new DecimalFormat("0.00");

	static Format formatter = new SimpleDateFormat("yyyyMMdd");
	static{
		
		numberFormat.setMaximumFractionDigits(2);
		numberFormat.setMinimumFractionDigits(2);
		
	}
	
	
	
	/**
	 * 
	 * @param number
	 * @return ��������ֻ����λС�����ַ�
	 */
	public static String getNumber(Object number){
		return numberFormat.format(number);
		
	}
	/**
	 * 
	 * @param number
	 * @return ��������ֻ����λС�����ַ�
	 */
	public	static String getNumber(double number){
		return numberFormat.format(number);
		
	}
	/**
	 *���ݳ��Ȳ��뿪ʼλ��λ��
	 *��   filNumber(1,2,"0") ������ 01
	 * @param value ��Ҫ�����ֵ
	 * @param length �ܳ���
	 * @param filSymbol �������
	 * @return ������string
	 */
	public static String  filNumber(int value,int length,String filSymbol){
		String str=String.valueOf(value);
		int strlength=str.length();
		if(strlength<length){
			strlength=length-strlength;
			StringBuilder strb=new StringBuilder();
		 for(int i=0;i<strlength;i++){
			 strb.append(filSymbol);
		 }
		 strb.append(str);
		 return strb.toString();
		}else
		return str;
		
	}
	/**
	 *���ݳ��Ȳ��뿪ʼλ��λ��
	 *��   filNumber(1,2,"0") ������ 01
	 * @param value ��Ҫ�����ֵ
	 * @param length �ܳ���
	 * @param filSymbol �������
	 * @return ������string
	 */
	public static String  filNumber(String value,int length,String filSymbol){
		String str=value;
		int strlength=str.length();
		if(strlength<length){
			strlength=length-strlength;
			StringBuilder strb=new StringBuilder();
		 for(int i=0;i<strlength;i++){
			 strb.append(filSymbol);
		 }
		 strb.append(str);
		 return strb.toString();
		}else
		return str;
		
	}
	/**
	 * ���� yyyyMMdd���ڸ�ʽ�ĵ�ǰ����
	 * @return  yyyyMMdd���ڸ�ʽ�ĵ�ǰ����
	 */
	public static String stringDateTime() {
		return formatter.format(new java.util.Date());
	}
	/**
	 * ���� yyyyMMdd���ڸ�ʽ
	 * @return  yyyyMMdd���ڸ�ʽ�ĵ�ǰ����
	 */
	public static String stringDateTime(Date date) {
		return formatter.format(date);
	}
	/**
	 * ���� yyyyMMdd���ڸ�ʽ
	 * @return  yyyyMMdd���ڸ�ʽ�ĵ�ǰ����
	 */
	public static String stringDateTime(String date) {
		return formatter.format(Tool.stringToDate(date));
	}
	
	public static String getNumber2(Object amt){
		return formatter2.format(amt);
		
		
	}
	
	public static String replaceBlank(String str) 
	{ 
	   Pattern p = Pattern.compile("\\s*|\t|\r|\n"); 
	 //  String str="I am a, I am Hello ok, \n new line ffdsa!"; 
	 //  System.out.println("before:"+str); 
	   Matcher m = p.matcher(str); 
	   String after = m.replaceAll(""); 
	   return after;
	} 
	
}
