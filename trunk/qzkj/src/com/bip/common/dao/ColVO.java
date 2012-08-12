/************************************************************
 * ������ColVo.java
 *
 * ���ͨ����
 * ���ܣ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2011-5-20  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2011 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.common.dao;

import com.bip.common.util.FormatUtil;

public class ColVO {
	String name = "";
	boolean isnumber = false;
	boolean isKey = false;
	String defVal = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isKey() {
		return isKey;
	}

	public void setKey(boolean isKey) {
		this.isKey = isKey;
	}

	public boolean isIsnumber() {
		return isnumber;
	}

	public void setIsnumber(boolean isnumber) {
		this.isnumber = isnumber;
	}

	public String getDefVal() {
		return defVal;
	}

	public void setDefVal(String defVal) {
		this.defVal = (defVal == null ? null : FormatUtil.replaceBlank(defVal));
	}

}
