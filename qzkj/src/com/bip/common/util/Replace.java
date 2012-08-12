package com.bip.common.util;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
import java.lang.String;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.bip.sys.dept.po.SysDepartment;

public final class Replace {
	public static java.lang.String replace(String strSource, String strFrom,
			String strTo) {
		java.lang.String strDest = "";
		int intFromLen = strFrom.length();
		int intPos;

		while ((intPos = strSource.indexOf(strFrom)) != -1) {
			strDest = strDest + strSource.substring(0, intPos);
			strDest = strDest + strTo;
			strSource = strSource.substring(intPos + intFromLen);
		}
		strDest = strDest + strSource;

		return strDest;
	}

	public static java.lang.String replaceDate(java.util.Date date) {

		java.text.SimpleDateFormat datef = new java.text.SimpleDateFormat(
				"yyyyMMdd");
		String strdate = datef.format(date);
		return strdate;
	}

	public static java.lang.String getCurDate(java.util.Date date)
			throws ParseException {

		java.text.SimpleDateFormat datef = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");
		String strdate = datef.format(date);
		return strdate;
	}

	public static String initStr(String str) {
		return str == null ? " " : str;
	}

	public static List replaceStringToList(String str) {
		str = str.trim();
		List rlist = new ArrayList();
		int flag = 0;
		if (str.length() > 1) {
			for (int i = 1; i < str.length(); i++) {
				if (",".equals(str.substring(i - 1, i))) {
					rlist.add(str.substring(flag, i - 1));
					flag = i;
				}
			}
			rlist.add(str.substring(flag, str.length()));
		}
		return rlist;
	}
/**
 * ��������:����comboTree��ʽ
 * @param List<SysDepartment> t;�Ӳ��ű���ȡ������
 * @return��JSon����[{"id":2,"text":"��������ɽ������","iconCls":"ok"},{"id":9,"text":"����","iconCls":"ok"},{"id":10,"text":"�г���","iconCls":"ok"},{"id":11,"text":"����һ��","iconCls":"ok"},{"id":12,"text":"���Ŷ���","iconCls":"ok"},{"id":13,"text":"ef","iconCls":"ok"}]
 */
	public static String GetJson(List<SysDepartment> t)   
	{       
		String json = "[";   
		//List list1=DB.getChild(list1.getDeptid());
		for( SysDepartment model : t)      
		{           
			if (model != t.get(t.size() - 1))      
			{              
				json += GetJsonByList(model) + ",";      
			}          
			else         
			{               
				json += GetJsonByList(model);        
			}      
			}       
		json += "]";       
		json = json.replace("'", "\"");    
		return json;    
		}
	   public static String GetJsonByList(SysDepartment list1)
	   {     
		   String sb = "";
	          //String filter = String.format(" {0}='{1}' ", pField, pValue);//��ȡ����Ŀ¼	         
             //boolean flag=DB.isHaveChild(list1.getDeptid());
	         sb = "{"                 
	        	 + "'id':"+list1.getDeptid()+","         
	        	 + "'text':'" + list1.getDeptname() + "',"               
	        	 +"'iconCls':'ok'}";
	         return sb;
   }
/**
 * ��������:����combogrid��ʽ
 * @param:List<SysDepartment> t;�Ӳ��ű���ȡ������
 * @return:Json����[{"code":"rh","name":"��������ɽ������"},{"code":"37","name":"����"},{"code":"38","name":"�г���"},{"code":"3701","name":"����һ��"},{"code":"3702","name":"���Ŷ���"},{"code":"35","name":"ef"}]
 */
	   public static String GetJson1(List<SysDepartment> t)   
		{       
			String json = "[";      
			for( SysDepartment model : t)      
			{           
				if (model != t.get(t.size() - 1))      
				{              
					json += GetJsonByList1(model) + ",";      
				}          
				else         
				{               
					json += GetJsonByList1(model);        
				}      
				}       
			json += "]";       
			json = json.replace("'", "\"");    
			return json;    
			}
		   public static String GetJsonByList1(SysDepartment list1)
		   {           
			     String sb = "";     
		         sb = "{"                 
		        	 + "'code':'"+list1.getDeptno()+"',"         
		        	 + "'name':'" + list1.getDeptname() + "'"                             
		        	 + "}";
		         return sb;
	   }
	   

}