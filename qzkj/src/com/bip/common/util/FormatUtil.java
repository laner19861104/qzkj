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
	 * @return 返回有且只有两位小数的字符
	 */
	public static String getNumber(Object number){
		return numberFormat.format(number);
		
	}
	/**
	 * 
	 * @param number
	 * @return 返回有且只有两位小数的字符
	 */
	public	static String getNumber(double number){
		return numberFormat.format(number);
		
	}
	/**
	 *根据长度补齐开始位数位数
	 *如   filNumber(1,2,"0") 将返回 01
	 * @param value 需要补齐的值
	 * @param length 总长度
	 * @param filSymbol 补齐符号
	 * @return 补齐后的string
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
	 *根据长度补齐开始位数位数
	 *如   filNumber(1,2,"0") 将返回 01
	 * @param value 需要补齐的值
	 * @param length 总长度
	 * @param filSymbol 补齐符号
	 * @return 补齐后的string
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
	 * 返回 yyyyMMdd日期格式的当前日期
	 * @return  yyyyMMdd日期格式的当前日期
	 */
	public static String stringDateTime() {
		return formatter.format(new java.util.Date());
	}
	/**
	 * 返回 yyyyMMdd日期格式
	 * @return  yyyyMMdd日期格式的当前日期
	 */
	public static String stringDateTime(Date date) {
		return formatter.format(date);
	}
	/**
	 * 返回 yyyyMMdd日期格式
	 * @return  yyyyMMdd日期格式的当前日期
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
