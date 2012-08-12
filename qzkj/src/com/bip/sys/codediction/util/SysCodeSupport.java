/**
 * ������SysCodeSupport.java
 *
 * ��𣺹�����
 * ���ܣ���ҳ֧��
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-24  CFIT-PM   syl         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */

package com.bip.sys.codediction.util;

public class SysCodeSupport {
	
	private String[] sysDmzdCcodeArray = null;

	private String[] sysDmzdNameArray = null;

	private String selectString = "";
	private String hybh="";
	private String sorttype="";

	public String getHybh() {
		return hybh;
	}

	public void setHybh(String hybh) {
		this.hybh = hybh;
	}


	public void setSelectString(String selectString) {
		this.selectString = selectString;
	}

	public String[] getSysDmzdCcodeArray() {
		return sysDmzdCcodeArray;
	}

	public void setSysDmzdCcodeArray(String[] sysDmzdCcodeArray) {
		this.sysDmzdCcodeArray = sysDmzdCcodeArray;
	}

	public String[] getSysDmzdNameArray() {
		return sysDmzdNameArray;
	}

	public void setSysDmzdNameArray(String[] sysDmzdNameArray) {
		this.sysDmzdNameArray = sysDmzdNameArray;
	}

	public String getSelectString() {
		StringBuilder str = new StringBuilder();
		str.append("<SELECT name=hybh >");
		str.append("<OPTION value=\"\">ȫ��</OPTION>");
     	for (int i = 0; i < this.getSysDmzdCcodeArray().length ; i++) {
		if(this.getHybh()!=null&&this.getHybh().equals(this.getSysDmzdCcodeArray()[i])){
     		str.append("<OPTION selected value=" ).append(this.getSysDmzdCcodeArray()[i]).append(">" ).append(this.getSysDmzdNameArray()[i]).append("</OPTION>");
		}else{
			str.append("<OPTION value=" ).append(this.getSysDmzdCcodeArray()[i]).append(">" ).append(this.getSysDmzdNameArray()[i]).append("</OPTION>");
				
		}
		}
	    str.append("</SELECT>");
		return str.toString();
	}


	public String getSorttype() {
		
		StringBuilder str = new StringBuilder();
		str.append("<SELECT name=sorttype >");
		str.append("<OPTION value=\"\">ȫ��</OPTION>");
     	for (int i = 0; i < this.getSysDmzdCcodeArray().length ; i++) {
		if(this.getHybh()!=null&&this.getHybh().equals(this.getSysDmzdCcodeArray()[i])){
     		str.append("<OPTION selected value=" ).append(this.getSysDmzdCcodeArray()[i]).append(">" ).append(this.getSysDmzdNameArray()[i]).append("</OPTION>");
		}else{
			str.append("<OPTION value=" ).append(this.getSysDmzdCcodeArray()[i]).append(">" ).append(this.getSysDmzdNameArray()[i]).append("</OPTION>");
				
		}
		}
	    str.append("</SELECT>");
		return str.toString();

	}

	public void setSorttype(String sorttype) {
		this.sorttype = sorttype;
	}

		
	
	
	
}
