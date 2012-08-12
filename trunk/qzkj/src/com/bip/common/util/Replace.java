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
 * 功能描述:返回comboTree格式
 * @param List<SysDepartment> t;从部门表中取得数据
 * @return：JSon对象[{"id":2,"text":"人民银行山东分行","iconCls":"ok"},{"id":9,"text":"华信","iconCls":"ok"},{"id":10,"text":"中诚信","iconCls":"ok"},{"id":11,"text":"华信一部","iconCls":"ok"},{"id":12,"text":"华信二部","iconCls":"ok"},{"id":13,"text":"ef","iconCls":"ok"}]
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
	          //String filter = String.format(" {0}='{1}' ", pField, pValue);//获取顶级目录	         
             //boolean flag=DB.isHaveChild(list1.getDeptid());
	         sb = "{"                 
	        	 + "'id':"+list1.getDeptid()+","         
	        	 + "'text':'" + list1.getDeptname() + "',"               
	        	 +"'iconCls':'ok'}";
	         return sb;
   }
/**
 * 功能描述:返回combogrid格式
 * @param:List<SysDepartment> t;从部门表中取得数据
 * @return:Json对象[{"code":"rh","name":"人民银行山东分行"},{"code":"37","name":"华信"},{"code":"38","name":"中诚信"},{"code":"3701","name":"华信一部"},{"code":"3702","name":"华信二部"},{"code":"35","name":"ef"}]
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