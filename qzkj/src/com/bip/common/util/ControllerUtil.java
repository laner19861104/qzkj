package com.bip.common.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;

public class ControllerUtil {
	/*
	 * 回写页面
	 */
	static public void responseWriter(String msg, HttpServletResponse response) {
		try {
//			response.setHeader("Pragma", "no-cache");
//			response.setHeader("Cache-Control", "no-cache");
//			response.setDateHeader("Expires", 0);
//			response.setContentType("text/javascript;charset=GBK");
			Writer out = response.getWriter();
			out.write(msg != null ? msg : "");
			response.flushBuffer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 获取页面参数值并将之转换成map对象
	 */
	static public Map getRequestParameterMap(HttpServletRequest request) {
		Enumeration parameterNames = request.getParameterNames();
		HashMap map = new HashMap();
		Object value = null;
		while (parameterNames.hasMoreElements()) {
			String key = (String) parameterNames.nextElement();
			value = request.getParameter(key);
			if (!key.equals("action") && value != null)
				map.put(key, value);
		}
		return map;
	}

	/*
	 * 获取页面参数值并将之转换成对应的PO对象
	 */
	static public Object getRequestParameterObject(HttpServletRequest request,
			Object object) {
		if (object == null)
			return null;
		try {
			Class myclass = object.getClass();
			BeanInfo info = Introspector.getBeanInfo(myclass);
			PropertyDescriptor pd[] = info.getPropertyDescriptors();
			String name = null;
			String value = null;
			for (int i = 0; i < pd.length; i++) {
				name = pd[i].getName();
				value = request.getParameter(name);
				if (value != null
						&& (!value.equals("") || pd[i].getPropertyType() == String.class)) {
					try {
						if (pd[i].getPropertyType() == Date.class)
							BeanUtils.setProperty(object, name, Tool
									.isDate(value));
						else
							BeanUtils.setProperty(object, name, value);
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
			return object;
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
			return null;
		} catch (IntrospectionException e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * 获取页面参数值并将之转换成对应的PO对象列
	 */
	static public Object[] getParameterObjectAndName(
			HttpServletRequest request, Object object) {
		if (object == null)
			return null;
		List<String> names = new ArrayList<String>();
		try {
			Class myclass = object.getClass();
			BeanInfo info = Introspector.getBeanInfo(myclass);
			PropertyDescriptor pd[] = info.getPropertyDescriptors();
			String name = null;
			Object value = null;
			for (int i = 0; i < pd.length; i++) {
				name = pd[i].getName();
				value = request.getParameter(name);
				if (value != null) {
					try {
						names.add(name);
						BeanUtils.setProperty(object, name, value);
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
			return new Object[] { object, names };
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
			return null;
		} catch (IntrospectionException e) {
			e.printStackTrace();
			return null;
		}

	}

	/*
	 * 操作对象json类型转换成string
	 */
	static public String getJsonMsg(boolean isSuccess, String info) {
		Map viewMap = new JSONObject();
		viewMap.put("success", isSuccess);
		viewMap.put("info", info);
		return viewMap.toString();
	}

	
	/*
	 * 操作对象json类型转换成string  将编码方式从gbk转到iso-8859-1
	 */
	static public String getJsonMsgToIso(boolean isSuccess, String info) {
		Map viewMap = new JSONObject();
		try {
			viewMap.put("success", isSuccess);
			viewMap.put("info", new String(info.getBytes("gbk"),"iso-8859-1"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return viewMap.toString();
	}
	/*
	 * 操作对象json类型转换成string
	 */
	static public String getJsonString(int total, List list) {
		Map<String ,Object> viewMap = new HashMap<String,Object>();
		viewMap.put("total", total);
		viewMap.put("rows", list);
		return JSONObject.fromObject(viewMap).toString();
	}
	static public String getJsonString(int total,List list,List footList) {
		Map<String ,Object> viewMap = new HashMap<String,Object>();
		viewMap.put("total", total);
		viewMap.put("rows", list);
		viewMap.put("footer", footList);
		return JSONObject.fromObject(viewMap).toString();
	}
	static public String getJsonMsg(boolean isSccess) {
		return getJsonMsg(isSccess, isSccess ? "操作成功" : "操作失败");
	}

	static public Object getRequestParameterObject(HttpServletRequest request,
			Class myclass) {
		if (myclass == null)
			return null;
		try {
			return getRequestParameterObject(request, myclass.newInstance());
		} catch (InstantiationException e) {

			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {

			e.printStackTrace();
			return null;
		}
	}
}
