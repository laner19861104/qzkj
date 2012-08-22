package com.bip.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import com.bip.sys.codediction.dmzd.po.SysDmzd;

public class Tool {
	static Log log = LogFactory.getLog(Tool.class);

	public static final String replace(String line, String oldString,
			String newString) {
		if (line == null) {
			return null;
		}
		int i = 0;
		if ((i = line.indexOf(oldString, i)) >= 0) {
			char[] line2 = line.toCharArray();
			char[] newString2 = newString.toCharArray();
			int oLength = oldString.length();
			StringBuffer buf = new StringBuffer(line2.length);
			buf.append(line2, 0, i).append(newString2);
			i += oLength;
			int j = i;
			while ((i = line.indexOf(oldString, i)) > 0) {
				buf.append(line2, j, i - j).append(newString2);
				i += oLength;
				j = i;
			}
			buf.append(line2, j, line2.length - j);
			return buf.toString();
		}
		return line;
	}

	public Tool() {
	}

	/**
	 * ��li�ָ�str�ַ����������ַ�������
	 */
	public static String[] explode(String li, String str) {
		if (str == null) {
			String[] rs = new String[0];
			return rs;
		}
		int num = 1;
		String temp = str;
		for (int i = temp.indexOf(li); i > -1; i = temp.indexOf(li)) {
			temp = temp.substring(i + li.length());
			num++;
		}
		// if (num == 1)
		// return new String[0];
		int j = 0;
		temp = str;
		String[] rs = new String[num];
		for (int i = 1; i < num; i++) {
			int p = temp.indexOf(li);
			rs[j] = temp.substring(0, p);
			temp = temp.substring(p + li.length());
			j++;
		}
		rs[j] = temp;
		return rs;
	}

	/**
	 * ��li�ָ�str�ַ����������ַ�������
	 */
	public static String[] split(String li, String str) {
		if ((str == null) || (str.trim().length() == 0))
			str = null;
		return explode(li, str);
	}

	/**
	 * ��li�ָ�str�ַ����������ַ�������
	 */
	public static String[] explode_new(String li, String str) {
		StringTokenizer st = new StringTokenizer(str, li);
		int rssize = 0;
		if (str.startsWith(li))
			rssize++;
		if (str.endsWith(li))
			rssize++;
		String[] rs = new String[st.countTokens() + rssize];
		int i = 0;
		if (str.startsWith(li)) {
			rs[i] = "";
			i++;
		}
		while (st.hasMoreTokens()) {
			rs[i] = st.nextToken();
			i++;
		}
		if (str.endsWith(li)) {
			rs[i] = "";
		}
		return rs;
	}

	/**
	 * Joins the elements of the provided array into a single string containing
	 * a list of CSV elements.
	 * 
	 * @param list
	 *            The list of values to join together.
	 * @param separator
	 *            The separator character.
	 * @return The CSV text.
	 */
	public static String join(String separator, String[] list) {
		if (list == null)
			list = new String[0];
		StringBuffer csv = new StringBuffer();
		for (int i = 0; i < list.length; i++) {
			if (i > 0) {
				csv.append(separator);
			}
			csv.append(list[i]);
		}
		return csv.toString();
	}

	/**
	 * ��str�ַ���ת��������
	 */
	public static int StrToInt(String str) {
		int rs = 0;
		if (str != null) {
			try {
				Integer in = new Integer(str);
				rs = in.intValue();
			} catch (NumberFormatException e) {
				rs = 0;
			}
		}
		return rs;
	}

	/**
	 * ��ʽ�����ڣ����������λ��ƴ��0��
	 */
	public static String getTwoDate(int rq) {
		String temp = "" + rq;
		if (rq > 0 && rq < 10)
			temp = "0" + rq;
		return temp;
	}

	/**
	 * ���㲢������������֮������� 2006��1��1��
	 */
	public static int subSecond(java.util.Date d1, java.util.Date d2) {

		long mss = d2.getTime() - d1.getTime();
		long ss = mss / 1000;

		return (int) ss;
	}

	/**
	 * ���㲢������������֮�������
	 */

	public static int subDate(java.util.Date d1, java.util.Date d2) {
		// GregorianCalendar gc1= new GregorianCalendar();
		// GregorianCalendar gc2= new GregorianCalendar();
		// gc1.setTime(d1);
		// gc2.setTime(d2);
		// gc1.computFields();
		long mss = d2.getTime() - d1.getTime();
		long ss = mss / 1000;
		long ms = ss / 60;
		long hs = ms / 60;
		long ds = hs / 24;
		return (int) ds;
	}

	// �ӷ�������ȡ�õ�ǰ����
	// ��ʽ��2002��04��25�� ������
	public static String get_current_date() {
		String[] week = new String[7];
		week[0] = "��";
		week[1] = "һ";
		week[2] = "��";
		week[3] = "��";
		week[4] = "��";
		week[5] = "��";
		week[6] = "��";
		java.util.Date d1 = new java.util.Date();
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d1);
		return gc.get(Calendar.YEAR) + "��" + (gc.get(Calendar.MONTH) + 1) + "��"
				+ gc.get(Calendar.DAY_OF_MONTH) + "�� ����"
				+ week[gc.get(Calendar.DAY_OF_WEEK) - Calendar.SUNDAY];
	}

	public static String stringOfTime() {
		return stringOfTime(new java.util.Date());
	}

	public static String stringOfTime(java.util.Date date) {
		Format formatter = new SimpleDateFormat("HH:mm");
		return formatter.format(date);
	}

	/**
	 * ��ǰ�����ַ���
	 */
	public static String stringOfDateTime() {
		return stringOfDateTime(new java.util.Date());
	}

	public static String stringOfDateTime(java.util.Date date) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(date);
	}

	public static String stringTime() {
		return stringTime(new java.util.Date());
	}

	public static String stringTime(java.util.Date date) {
		Format formatter = new SimpleDateFormat("HHmmss");
		return formatter.format(date);
	}

	// �������ַ���ת��Ϊ���ڱ���,���������,���ص�ǰ����
	public static java.util.Date stringToDateTime(String str) {
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return (java.util.Date) formatter.parse(str);
		} catch (ParseException e) {
			return new java.util.Date();
		}
	}

	// �������ַ���ת��Ϊ���ڱ���,���������,���ص�ǰ����
	public static java.util.Date stringToDate(String str) {
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			return (java.util.Date) formatter.parse(str);
		} catch (ParseException e) {
			return new java.util.Date();
		}
	}
	
	// �������ڸ�ʽ�ַ����������ַ���ת��Ϊ���ڱ���,���������,���ص�ǰ����
	public static java.util.Date stringToDate(String str, String formatstring) {
		try {
			DateFormat formatter = new SimpleDateFormat(formatstring);
			return (java.util.Date) formatter.parse(str);
		} catch (ParseException e) {
			return new java.util.Date();
		}
	}

	/**
	 * ��ǰ�����ַ���
	 */

	public static String stringOfCnDateTime() {
		return stringOfCnDateTime(new java.util.Date());
	}

	public static String stringOfCnDateTime(java.util.Date date) {
		Format formatter = new SimpleDateFormat("yyyy��M��d�� Hʱm��s��");
		return formatter.format(date);
	}

	/**
	 * ��ǰ�����ַ���
	 */
	public static String stringOfCnDate() {
		return stringOfCnDate(new java.util.Date());
	}

	public static String stringOfCnDate(java.util.Date date) {
		Format formatter = new SimpleDateFormat("yyyy��M��d��");
		return formatter.format(date);
	}

	/**
	 * ��ǰ�����ַ���
	 */
	public static String stringOfDate() {
		return stringOfDate(new java.util.Date());
	}

	public static String stringOfDate(java.util.Date date) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}

	/**
	 * ��ǰ�����ַ���
	 */
	public static String stringOfDate1() {
		return stringOfDate1(new java.util.Date());
	}

	public static String stringOfDate1(java.util.Date date) {
		Format formatter = new SimpleDateFormat("yyyyMMdd");
		return formatter.format(date);
	}
	/**
	 * ����ʱ���ʽ�ַ�����õ�ǰ�����ַ���
	 */
	public static String getStringOfDate(String formatstring) {
		return stringOfDate(new java.util.Date(), formatstring);
	}

	public static String stringOfDate(java.util.Date date, String formatstring) {
		Format formatter = new SimpleDateFormat(formatstring);
		return formatter.format(date);
	}

	/**
	 * ���㲢���ظ������µ����һ��
	 */
	public static String lastDateOfMonth(int year, int month) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(Calendar.YEAR, year);
		gc.set(Calendar.MONTH, month - 1);
		int maxDate = gc.getActualMaximum(Calendar.DAY_OF_MONTH);
		gc.set(Calendar.DATE, maxDate);
		return stringOfDate(gc.getTime());
	}

	/**
	 * ���㲢���������е����ڼ�
	 */

	public static int weekOfDate(java.util.Date d1) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d1);
		return gc.get(Calendar.DAY_OF_WEEK);
	}

	public static String amorPmTime() {

		return amorPmTime(new java.util.Date());
	}

	public static String amorPmTime(java.util.Date d1) {

		SimpleDateFormat formatter2 = new SimpleDateFormat(" a hh:mm");
		return formatter2.format(d1);
	}

	/**
	 * ���������е����ڼ�
	 */
	public static String weekOfDate() {
		String[] week = new String[7];
		week[0] = "��";
		week[1] = "һ";
		week[2] = "��";
		week[3] = "��";
		week[4] = "��";
		week[5] = "��";
		week[6] = "��";
		return week[weekOfDate(new java.util.Date())];
	}

	/**
	 * ���㲢���������е���
	 */
	public static int dayOfDate(java.util.Date d1) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d1);
		return gc.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * ���㲢���������е���
	 */
	public static int monthOfDate(java.util.Date d1) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d1);
		return gc.get(Calendar.MONTH) + 1;
	}

	/**
	 * ���㲢���������е���
	 */
	public static int yearOfDate(java.util.Date d1) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d1);
		return gc.get(Calendar.YEAR);
	}

	/**
	 * ���㲢���������е�ʱ
	 */
	public static int hourOfDate(java.util.Date d1) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d1);
		return gc.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * ���㲢���������еķ�
	 */
	public static int minuteOfDate(java.util.Date d1) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d1);
		return gc.get(Calendar.MINUTE);
	}

	/**
	 * ���㲢���������е���
	 */
	public static int secondOfDate(java.util.Date d1) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d1);
		return gc.get(Calendar.SECOND);
	}

	/**
	 * �������º������
	 */
	public static java.util.Date addDateByMonth(java.util.Date d, int mcount) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d);
		gc.add(Calendar.MONTH, mcount);
		gc.add(Calendar.DATE, -1);
		return new java.util.Date(gc.getTime().getTime());
	}

	/**
	 * �������պ������
	 */
	public static java.util.Date addDateByDay(java.util.Date d, int dcount) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d);
		gc.add(Calendar.DATE, dcount);
		return new java.util.Date(gc.getTime().getTime());
	}

	/**
	 * ��������������
	 */
	public static java.util.Date addDateBySecond(java.util.Date d, int scount) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d);
		gc.add(Calendar.SECOND, scount);
		return gc.getTime();
	}

	/**
	 * zhurx 20040224 ������ַ�ת��Ϊʱ������
	 */
	public static java.sql.Date isTime(String shijian) {
		java.sql.Date time = null;
		try {
			time = java.sql.Date.valueOf(shijian);
			return time;
		} catch (IllegalArgumentException myException) {
			return time;
		}
	}

	/**
	 * zhurx 20040306 ������ַ�Ϊyyyy-MM-dd HH:mm:ss���� ת��Ϊ��java.util.Date
	 */

	public static java.util.Date isDateTime(String datestr) {
		// Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// return formatter.format(date);
		java.util.Date rdatetime = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			// DateFormat formatter = new DateFormat("yyyy-MM-dd HH:mm:ss");
			ParsePosition pos = new ParsePosition(0);
			rdatetime = formatter.parse(datestr, pos);
			return rdatetime;
		} catch (IllegalArgumentException myException) {
			return rdatetime;
		}

	}
	
	
	/**
	 * ���ݿ�ʼʱ�䣨��ʽ��yyyy-MM���ͽ���ʱ�䣨��ʽ��yyyy-MM������ʱ����ڵ�����ʱ�䣨��ʽ��yyyy-MM���б�
	 * ���ݵ�ǰʱ�� Date ��ȡ ��ǰ���·�
	 * @param begintime
	 * @param endtime
	 * @return
	 */
		public static String getNowYYYYMMDate() {
			  Date currentTime = new Date();
			  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
			  String dateString = formatter.format(currentTime);
			  return dateString;
			 }
	
		
		public static String getFirstYYYYMMDate() {
			  Date currentTime = new Date();
			  SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
			  String dateString = formatter.format(currentTime);
			  
			  return dateString+"-01";
			 }
		
	/////////////////////////////////////////////���ڼ��㷽��///////////////////////////////////////////////////

	/**
	 * ���������ڵ��ַ����ָ�Ϊ�������µ���������
	 * 
	 * @param date
	 * @return
	 */
	public static int[] splitYMD(String date) {
		date = date.replace("-", "");
		int[] ymd = { 0, 0 };
		ymd[0] = Integer.parseInt(date.substring(0, 4));
		ymd[1] = Integer.parseInt(date.substring(4, 6));
		return ymd;
	}
	/**
	 * ���������ڵ��ַ����ָ�Ϊ�������µ���������
	 * 
	 * @param date
	 * @param interval ���������'-'��'.'��
	 * @return
	 */
	public static int[] splitYMD(String date,String interval) {
		date = date.replace(interval, "");
		int[] ymd = { 0, 0 };
		ymd[0] = Integer.parseInt(date.substring(0, 4));
		ymd[1] = Integer.parseInt(date.substring(4, 6));
		return ymd;
	}
	
	/**
	 * �ж�ʱ��date1�Ƿ���ʱ��date2֮ǰ
	 * @param date1
	 * @param date2
	 * @param formatstring
	 * @return
	 */
	public static boolean isDateBefore(String date1,String date2,String formatstring){   
		try{   
		  //DateFormat df = DateFormat.getDateTimeInstance(); 
		  DateFormat df = new SimpleDateFormat(formatstring);
		  return df.parse(date1).before(df.parse(date2));    
		}catch(ParseException e){   
		  System.out.print(e.getMessage());   
		  return false;   
		}   
	} 
	/**
	 * �жϵ�ǰʱ���Ƿ���ʱ��date2֮ǰ
	 * @param date2
	 * @return
	 */
	public static boolean isDateBefore(String date2){   
		 try{   
		  Date date1 = new Date();   
		  DateFormat df = DateFormat.getDateTimeInstance();   
		  return date1.before(df.parse(date2));    
		 }catch(ParseException e){   
		  System.out.print("[SYS] " + e.getMessage());   
		  return false;   
		 }   
	} 
	/**
	 * ��������λ���·ݻ����ڲ���Ϊ��λ
	 * 
	 * @param decimal
	 * @return
	 */
	public static String formatMonthDay(int decimal) {
		DecimalFormat df = new DecimalFormat("00");
		return df.format(decimal);
	}

	/**
	 * ��������λ����ݲ���Ϊ��λ
	 * 
	 * @param decimal
	 * @return
	 */
	public static String formatYear(int decimal) {
		DecimalFormat df = new DecimalFormat("0000");
		return df.format(decimal);
	}

	/**
	 * ������������֮�����������
	 * 
	 * @param begin
	 * @param end
	 * @return
	 * @throws ParseException
	 */
	public static long countDay(String begin, String end) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate, endDate;
		long day = 0;
		try {
			beginDate = format.parse(begin);
			endDate = format.parse(end);
			day = (endDate.getTime() - beginDate.getTime())
					/ (24 * 60 * 60 * 1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return day;
	}
	//��ȡ���µ�һ������
	public static String getPreviousMonthFirst(){
		String str = "";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE,1);//��Ϊ��ǰ�µ�1��
		lastDate.add(Calendar.MONTH,-1);//��һ���£���Ϊ���µ�1��
		//lastDate.add(Calendar.DATE,-1);//��ȥһ�죬��Ϊ�������һ��
		str=sdf.format(lastDate.getTime());	
		return str;
	}

	public static String HtmlSelect(String value[], String text[],
			String selected) {
		StringBuffer htmlSelect = new StringBuffer();
		try {
			for (int i = 0; i < text.length; i++) {

				if (selected != null && selected.trim().equals(value[i].trim())) {
					htmlSelect.append("<OPTION value=\"");
					htmlSelect.append(value[i]);
					htmlSelect.append("\"  selected>");
					htmlSelect.append(text[i]);
					htmlSelect.append(" </OPTION>");
				} else {
					htmlSelect.append("<OPTION value=\"");
					htmlSelect.append(value[i]);
					htmlSelect.append("\" >");
					htmlSelect.append(text[i]);
					htmlSelect.append(" </OPTION>");
				}
			}

		} catch (Exception e) {

			// TODO �Զ����� catch ��
			log.error("�쳣:" + e.getMessage());
		}

		return htmlSelect.toString();

	}

	/**
	 * ��double���͵���ֵ����С�������λ���
	 */
	public static double round(double d) {
		DecimalFormat nf = new DecimalFormat("0.00");
		return Double.parseDouble(nf.format(d));
	}

	public static synchronized int getNextSn(Connection con, String tname) {
		return getNextSn_oracle(con, tname);
	}

	public static synchronized int getNextSn_oracle(Connection con, String tname) {
		String SELECT = "SELECT " + tname + "_seq.nextval FROM dual";
		int iResult = 0;
		Statement pstmt = null;
		try {
			pstmt = con.createStatement();
			ResultSet rs = pstmt.executeQuery(SELECT);
			if (rs.next()) {
				iResult = rs.getInt(1);
			}
			rs = null;
		} catch (SQLException sqle) {
			log.debug("Tool.getNextSn_oracle:" + sqle.getMessage());
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
				log.debug("Tool.executeSql:" + e.getMessage());
			}
		}
		return iResult;
	}

	public static synchronized int getNextSn_mysql(Connection con,
			String tname, String keycol) {
		String SELECT = "SELECT max(" + keycol + ") FROM " + tname;
		int iResult = 0;
		Statement pstmt = null;
		try {
			pstmt = con.createStatement();
			ResultSet rs = pstmt.executeQuery(SELECT);
			if (rs.next()) {
				iResult = rs.getInt(1);
			}
			rs = null;
		} catch (SQLException sqle) {
			log.debug("Tool.getNextSn_mysql:" + sqle.getMessage());
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {

				log.debug("Tool.executeSql:" + e.getMessage());
			}
		}
		log.debug(tname + ":" + keycol + ":" + (iResult + 1));
		return (iResult + 1);
	}

	public static java.util.Date getDate() {
		return new java.util.Date();
	}

	public static String[] getYearList(int startY, int len) {
		String[] list = new String[len];
		for (int i = startY; i < len + startY; i++)
			list[i - startY] = "" + (i + 1);
		return list;
	}

	public static String[] getMonDayList(int len) {
		String[] list = new String[len];
		for (int i = 0; i < len; i++) {
			if (i < 9)
				list[i] = "0" + (1 + i);
			else
				list[i] = "" + (1 + i);
		}
		return list;
	}

	public static boolean inArray(String str, String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(str)) {
				return true;
			}
		}
		return false;
	}

	public static boolean inArray(Object o, List arr) {
		int size = arr.size();
		for (int i = 0; i < size; i++) {
			if (arr.get(i).equals(o)) {
				return true;
			}
		}
		return false;
	}

	public static String getFilePath(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String realpath = session.getServletContext().getRealPath("/");
		realpath = realpath.substring(0, realpath.length() - 1);
		return realpath;
	}

	public static void setVal(int idx, int type, ResultSet rs,
			PreparedStatement pstmt) throws SQLException {
		switch (type) {
		case Types.TINYINT:
		case Types.SMALLINT:
			pstmt.setShort(idx, rs.getShort(idx));
			break;
		case Types.INTEGER:
			pstmt.setInt(idx, rs.getInt(idx));
			break;
		case Types.BIGINT:
			pstmt.setLong(idx, rs.getLong(idx));
			break;
		case Types.BOOLEAN:
			pstmt.setBoolean(idx, rs.getBoolean(idx));
			break;
		case Types.CHAR:
		case Types.VARCHAR:
			pstmt.setString(idx, rs.getString(idx));
			break;
		case Types.DATE:
			pstmt.setDate(idx, rs.getDate(idx));
			break;
		case Types.DECIMAL:
			pstmt.setBigDecimal(idx, rs.getBigDecimal(idx));
			break;
		case Types.DOUBLE:
			pstmt.setDouble(idx, rs.getDouble(idx));
			break;
		case Types.FLOAT:
			pstmt.setFloat(idx, rs.getFloat(idx));
			break;
		case Types.NUMERIC:
			pstmt.setFloat(idx, rs.getFloat(idx));
			break;
		case Types.REAL:
			pstmt.setFloat(idx, rs.getFloat(idx));
			break;
		case Types.TIME:
			pstmt.setTime(idx, rs.getTime(idx));
			break;
		case Types.TIMESTAMP:
			pstmt.setTimestamp(idx, rs.getTimestamp(idx));
			break;
		default:
			pstmt.setString(idx, rs.getString(idx));
		}
	}

	public static String toUtf8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {
					System.out.println(ex);
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}

	/**
	 * ��Session��ȡ��UserInfo
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */

	// ��ñ���ip
	public static String getip() {
		String lname = null;
		String lip = null;
		try {
			InetAddress add = InetAddress.getLocalHost();
			lip = add.getHostAddress();
			lname = add.getHostName();
			// System.out.println(add.getHostName()+": "+add.getHostAddress());
			return lip;
		} catch (Exception e) {
			// System.out.print(e.getMessage());
			return lip;
		}
	}

	// ͨ��IP��ȡ������ַ
	public static void main(String args[]) {
//		System.out.println(System.getProperty("user.timezone"));
//		System.out.println(TimeZone.getDefault());
		String[] idlist =explode(",","rh,02,03");
		System.out.println(idlist[0]);
		System.out.println(idlist[1]);
		System.out.println(idlist[2]);
//		TimeZone tz = TimeZone.getTimeZone("ETC/GMT-8");
//		System.out.println(tz);
//		System.out.println(stringOfDateTime());

	}

	public static String getMacAddressIP(String remotePcIP) {
		String str = "";
		String macAddress = "";
		try {
			Process pp = Runtime.getRuntime().exec("nbtstat -A " + remotePcIP);
			InputStreamReader ir = new InputStreamReader(pp.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			for (int i = 1; i < 100; i++) {
				str = input.readLine();
				if (str != null) {
					if (str.indexOf("MAC Address") > 1) {
						macAddress = str.substring(
								str.indexOf("MAC Address") + 14, str.length());
						break;
					}
				}
			}
		} catch (IOException ex) {
		}
		return macAddress;
	}

	// ͨ����������ȡ������ַ
	public static String getMacAddressName(String remotePcIP) {
		String str = "";
		String macAddress = "";
		try {
			Process pp = Runtime.getRuntime().exec("nbtstat -a " + remotePcIP);
			InputStreamReader ir = new InputStreamReader(pp.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			for (int i = 1; i < 100; i++) {
				str = input.readLine();
				if (str != null) {
					if (str.indexOf("MAC Address") > 1) {
						macAddress = str.substring(
								str.indexOf("MAC Address") + 14, str.length());
						break;
					}
				}
			}
		} catch (IOException ex) {
		}
		return macAddress;
	}

	// ��ָ��Ŀ¼�µ��ļ����ֱ�Ϊ��д��Сд��u--��Ϊ��д��l-��ΪСд
	public static void changePathName(String path, String up) {
		// System.out.println("->->->changepathname Begin...");
		File d = new File(path); // ȡ�õ�ǰ�ļ����������ļ���Ŀ¼���б�
		File lists[] = d.listFiles();
		String pathss = new String("");
		// �Ե�ǰĿ¼���������ļ����м���
		for (int i = 0; i < lists.length; i++) {
			if (lists[i].isFile()) {
				String filename = lists[i].getName();
				if (up.equals("u"))
					filename = upCase(filename);
				else
					filename = lowerCase(filename);

				String toName = new String(path + filename);
				File tempf = new File(toName);
				lists[i].renameTo(tempf);
				// System.out.println("new fullfilename is:" + toName);
			} else {
				pathss = path;
				// ������һ��Ŀ¼
				pathss = pathss + lists[i].getName() + "\\";
				// �ݹ��������Ŀ¼
				changePathName(pathss, up);
			}
		}
		// System.out.println("->->->changepathname End...");
	}

	public static String lowerCase(String filename) {
		// System.out.println("=>to lowerCase Begin...");
		String tempstr = new String("");
		char tempch = ' ';
		for (int i = 0; i < filename.length(); i++) {
			tempch = filename.charAt(i);
			if (64 < filename.charAt(i) && filename.charAt(i) < 91)// �Ǵ�д��ĸ
				tempch += 32;
			tempstr += tempch;
		}
		// System.out.println("new filename is:" + tempstr);
		// System.out.println("=>tolowerCase End...");
		return tempstr;
	}

	public static String upCase(String filename) {
		// System.out.println("=>to upCase Begin...");
		String tempstr = new String("");
		char tempch = ' ';
		for (int i = 0; i < filename.length(); i++) {
			tempch = filename.charAt(i);
			if (97 < filename.charAt(i) && filename.charAt(i) < 122)// �Ǵ�д��ĸ
				tempch -= 32;
			tempstr += tempch;
		}
		return tempstr;
	}

	/* ����Ҵ�дת�� */

	/**
	 * �ж��Ƿ�������
	 * 
	 * @param str
	 * @return
	 */
	public static boolean pandNumber(String str) {
		int length = str.length();
		int v = 0;

		for (int i = 0; i < length; i++) {
			v = str.charAt(i);
			if (v < 49 || v > 57)
				return false;
		}
		return true;
	}

	public static String[] StringNumber(String str) {
		int length = str.length();
		char v = 0;
		StringBuffer string = new StringBuffer();
		StringBuffer number = new StringBuffer();
		for (int i = 0; i < length; i++) {
			v = str.charAt(i);
			if (v < 49 || v > 57)
				string.append(v);
			else
				number.append(v);
		}
		return new String[] { string.toString(), number.toString() };
	}

	/**
	 * MD5���ܷ���
	 * 
	 * @param s
	 * @return
	 */
	public final static String MD5(String s) {
		if (s == null)
			return null;
		char hexDigits[] = { 'D', 'E', 'F', '0', 'A', 'B', 'C', '1', '2', '3',
				'4', '5', '6', '7', '8', '9' };
		try {
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();

			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// public static void main(String args[]) {
	// System.out.println(MD5("cskh"));
	// }
	public static Object convert(String value, Class t)

	{
		if (value == null) {
			if (t.equals(java.lang.Boolean.class) || t.equals(Boolean.TYPE)) {
				value = "false";
				return new Boolean(value);

			} else {
				return null;
			}
		}

		if (t.equals(java.lang.Boolean.class) || t.equals(Boolean.TYPE)) {

			if (value.equals("1") || value.equalsIgnoreCase("on")
					|| value.equalsIgnoreCase("true"))
				value = "true";
			else
				value = "false";

			return new Boolean(value);
		}

		if (t.equals(java.lang.Byte.class) || t.equals(Byte.TYPE))
			return new Byte(value);
		if (t.equals(java.lang.Character.class) || t.equals(Character.TYPE))
			return value.length() <= 0 ? null : new Character(value.charAt(0));
		if (t.equals(java.lang.Short.class) || t.equals(Short.TYPE))
			return new Short(value);
		if (t.equals(java.lang.Integer.class) || t.equals(Integer.TYPE))
			return new Integer(value);
		if (t.equals(java.lang.Float.class) || t.equals(Float.TYPE))
			return new Float(value);
		if (t.equals(java.lang.Long.class) || t.equals(Long.TYPE))
			return new Long(value);
		if (t.equals(java.lang.Double.class) || t.equals(Double.TYPE))
			return new Double(value);
		if (t.equals(java.lang.String.class))
			return value;
		if (t.equals(java.io.File.class))
			return new File(value);
		return null;

	}

	public static int maxIntArray(int[] args) {
		if (args == null)
			return 0;
		int max = 0;
		for (int i = 0; i < args.length; i++) {
			max += args[i];

		}
		return max;
	}

	public static boolean ArrayCheck(String[] Array, String str) {
		if (Array == null)
			return false;
		for (int i = 0; i < Array.length; i++) {
			if (str == null || Array[i] == null) {
				return false;
			} else {
				if (str.trim().equals(Array[i].trim()))
					return true;
			}

		}
		return false;
	}

	public static boolean ArrayCheck(List Array, Object str) {
		if (Array == null)
			return false;
		int size = Array.size();
		for (int i = 0; i < size; i++) {
			if (str == null || Array.get(i) == null) {
				return false;
			} else {
				if (str.equals(Array.get(i)))
					return true;
			}

		}
		return false;
	}

	public static String ObjectOutput(Object Object) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos;

		try {
			oos = new ObjectOutputStream(baos);
			oos.writeObject(Object);
			String out = new String(baos.toByteArray());

			return out;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static Object ObjectInput(String str) {

		try {
			ByteArrayInputStream input = new ByteArrayInputStream(str
					.getBytes());
			ObjectInputStream in = new ObjectInputStream(input);
			return in.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static long getQuot(String time1, String time2) {
		long quot = 0;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1 = ft.parse(time1);
			Date date2 = ft.parse(time2);
			quot = date1.getTime() - date2.getTime();
			quot = quot / 1000 / 60 / 60 / 24;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return quot;
	}

	public static String NumberFormat(double c) {
		DecimalFormat format = new DecimalFormat

		("#0.00");
		String formatedNumber = format.format(c);

		return formatedNumber;
	}

	/**
	 * ȡdiff��֮ǰ��֮�������
	 * 
	 * @param diff
	 *            ʱ����
	 * @param aorb
	 *            "a"֮ǰ��"b"֮��
	 * @return
	 */
	public static String dateOfSomeDayDiff(int diff, String aorb) {
		String dd = "";
		Date date = null;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		long day = (long) diff * 24 * 60 * 60 * 1000;
		long current = System.currentTimeMillis();
		if ("a".equalsIgnoreCase(aorb))
			date = new Date(current + day);
		if ("b".equalsIgnoreCase(aorb))
			date = new Date(current - day);
		return dd = ft.format(date);
	}

	/**
	 * ȡ�̶����ȵ��ַ���
	 * 
	 * @param resource
	 *            ԭ��
	 * @param length
	 *            ����
	 * @return
	 */
	public static String fixedLengthString(String resource, int length) {
		if (resource.length() < length)
			return resource;

		return resource.subSequence(0, length) + "...";
	}

	/**
	 * �������16������ɫ��
	 * @return
	 */
	public static String getRandomColor(){
		String s="123456789ABCDEF";
		 StringBuffer sb = new StringBuffer();   
		 Random rs=new Random();
		 for(int i=0 ;i<6;i++){
			sb.append(s.charAt(rs.nextInt(s.length())));
		 }
		 return sb.toString();
	}
	
	/**
	 * ���ݿ�ʼʱ�䣨��ʽ��yyyy-MM���ͽ���ʱ�䣨��ʽ��yyyy-MM������ʱ����ڵ�����ʱ�䣨��ʽ��yyyy-MM���б�
	 * @param begintime
	 * @param endtime
	 * @return
	 */
	public static List<String> getYM(String begintime, String endtime){
		//System.out.println("getYM:begintime  endtime:--------"+begintime+"----"+endtime);	
		List<String> list = null;
		int[] bt = Tool.splitYMD(begintime);
		int[] et = Tool.splitYMD(endtime);
		int yearnum = et[0]-bt[0];
		if(yearnum>=0){
			int byear = bt[0];//��ʼ��
			int bmonth = bt[1];//��ʼ��
			int eyear = et[0];//������
			int emonth = et[1];//������
			list = new ArrayList();
			for(int i=0;i<=yearnum;i++){
				if(yearnum==0){
					for(int j=bmonth;j<=emonth;j++){
						list.add(String.valueOf(byear+i)+"-"+Tool.formatMonthDay(j));
					}
				}else{
					if((byear+i)==eyear){
						for(int j=1;j<=emonth;j++){
							list.add(String.valueOf(byear+i)+"-"+Tool.formatMonthDay(bmonth++));
						}
					}else{
						for(int j=bmonth;j<=12;j++){
							list.add(String.valueOf(byear+i)+"-"+Tool.formatMonthDay(bmonth++));
						}
						bmonth = 1;
					}					
				}																
			}
		}
		return list;
	}
	
	/**
	 * ����ַ�����������ַ���Ϊ0����ȥ���ַ�����������0�����򲻱�(Ӧ���ڸ�ʽ���������)
	 * @param str
	 * @return
	 */
	public static String formatZero(String str){
		String s = "";
		int len = 0;
		if(str!=null){
			len = str.length();
			if(len>2&&"00".equals(str.substring(len-2,len))){
				s = str.substring(0,len-2);
			}else{
				s = str;
			}
		}
		return s;
	}
	/**
	 * ����ַ���Ϊ��������0/1/2/3/4���򷵻ذ��������ֵĶ������ӵĴ���0С�ڴ����ֵ��ַ�������"0,1,2"��Ӧ���ڸ�ʽ����ҵ�ص����ͱ��룩
	 * @param str
	 * @return
	 */
	public static String formatZDLX(String str){
		String s = "0";//Ĭ��Ϊ�����ص㡱
		if(str!=null){
			if("2".equals(str.trim())){//ȫ���ص�
				s = "'2'";
			}else if("1".equals(str.trim())){//ʡ�ص�
				s = "'1','2'";
			}else if("0".equals(str.trim())){//���ص�
				s = "'0','1','2'";
			}
		}
		return s;
	}
	public static String replaceToNull(String resource, String[] replace) {
		if (null == replace)
			return resource;
		String temp = resource;
		for (int i = 0; i < replace.length; i++) {
			temp = temp.replaceAll(replace[i], " ");
		}
		return temp;
	}

	public static String stareKeyword(String res, String keyword) {
		String tmp = res;
		tmp = tmp.replaceAll(keyword, "<font color=\"red\">" + keyword
				+ "</font>");
		return tmp;
	}

	/**
	 * ������ָ�Ϊ1,2,3�ĸ�ʽ
	 * 
	 * �����ַ���String
	 * 
	 * author��syl
	 * 
	 * 
	 */

	static public String getPlListForString(String[] reource) {
		// System.out.println(reource);
		if (reource == null)
			return "";
		StringBuffer tmp = new StringBuffer();
		String shenhe = "";
		for (int i = 0; i < reource.length; i++) {
			tmp.append("'").append(reource[i].trim()).append("',");
		}
		shenhe = tmp.toString().substring(0, tmp.length() - 1);

		return shenhe;

	}	
	
	
	
	
	
	static public String getPlListForString(List<SysDmzd> reource) {
		// System.out.println(reource);
		if (reource == null)
			return "";
		StringBuffer tmp = new StringBuffer();
		String shenhe = "";
		for (int i = 0; i < reource.size(); i++) {
			tmp.append("'").append(reource.get(i).getBh()).append("',");
		}
		shenhe = tmp.toString().substring(0, tmp.length() - 1);

		return shenhe;

	}
	
	static public String getPlStrListForString(List<String> reource) {
		// System.out.println(reource);
		if (reource == null)
			return "";
		StringBuffer tmp = new StringBuffer();
		String shenhe = "";
		for (int i = 0; i < reource.size(); i++) {
			tmp.append("'").append(reource.get(i)).append("',");
		}
		shenhe = tmp.toString().substring(0, tmp.length() - 1);

		return shenhe;

	}
	/**
	 * ������ָ�Ϊ1,2,3�ĸ�ʽ
	 * 
	 * �����ַ���String
	 * 
	 * author��syl
	 * 
	 * 
	 */	
	
	public static char toLowerCase(char c) {
		  int i = (int) c;
		  if (i >= 65 && i <= 90) {//65-90��A-Z��ASCII����
		   c = (char) (i + 32);//A��65��a��97���ò�32
		  }
		  return c;
		 }
	


	 public static String html(String content) {  

	     if(content==null) return "";          

	     String html = content;  

	     html = StringUtils.replace(html, "'", "&apos;");  

	     html = StringUtils.replace(html, "\"", "\"");  

	     html = StringUtils.replace(html, "\t", "  ");// �滻����  

	     html = StringUtils.replace(html, " ", " ");// �滻�ո�  

	     html = StringUtils.replace(html, "%", "%");

	     html = StringUtils.replace(html, "<", "<");  

	     html = StringUtils.replace(html, ">", ">");  

	    return html;  

	} 


	
	

	/**
     * �ж��ַ����Ƿ�������ڸ�ʽ
     * 
     * @param str
     *            �ַ���ʱ��
     * @return
     */
    public static boolean isDate(String strDate) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                "yyyy-MM-dd");
        java.text.SimpleDateFormat sdf1 = new java.text.SimpleDateFormat(
        "yyyy/MM/dd");
        sdf.setLenient(false);
        sdf1.setLenient(false);
        try {
            sdf.parse(strDate);
            return true;
        } catch (ParseException ex) {
        	try {
				sdf1.parse(strDate);
				return true;
			} catch (ParseException e) {
				return false;
			}
        }
    }
	
	
    public static boolean isNumber(String str) {
        try {
            new BigDecimal(str);
            return true;
        } catch (Exception ex) {
        	return false;
        }
    }
	
    /**
	 *���ݿ�ͨ��uuid
	
	 */
	public static String getStringUUid() {
		return UUID.randomUUID().toString();

	}
	
	public static String getToGbk(String str) {
		String strs="";
		
			try {
				if(!"".equals(str)){
				strs= new String(str.getBytes("iso-8859-1"),"GBK");
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return strs;
	}
	/**
	 * ���ص�ǰ��
	 */

	public static String getNowYear() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		return formatter.format(currentTime);

	}

	public static Integer getNowMonth() {
		String date = getNowYYYYMMDate();
		String month = date.substring(5, 7);

		return Integer.parseInt(month);
	}
	public static List getYearList(String begintime, String endTime) {
		// TODO Auto-generated method stub
		List time_list = new ArrayList();

		if (begintime != null && endTime != null) {
			Date date1 = stringToDate2(begintime);
			Date date2 = stringToDate2(endTime);
			Calendar cal1 = new GregorianCalendar();
			cal1.setTime(date1);
			Calendar cal2 = new GregorianCalendar();
			cal2.setTime(date2);
			int c = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);
			for (int i = 0; i <= c; i++) {
				if (i == 0) {
					cal1.add(Calendar.YEAR, 0);
				} else {
					cal1.add(Calendar.YEAR, 1);
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy");
				time_list.add(format.format(cal1.getTime()));
			}
		}
		return time_list;
	}
	public static List getTimeList(String begintime, String endTime) {
		// TODO Auto-generated method stub
		List time_list = new ArrayList();

		if (begintime != null && endTime != null) {
			Date date1 = stringToDate1(begintime);
			Date date2 = stringToDate1(endTime);
			Calendar cal1 = new GregorianCalendar();
			cal1.setTime(date1);
			Calendar cal2 = new GregorianCalendar();
			cal2.setTime(date2);
			int c = (cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR)) * 12
					+ cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH);
			cal1.add(Calendar.MONTH, -1);
			for (int i = 0; i <= c; i++) {
				cal1.add(Calendar.MONTH, 1);
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
				time_list.add(format.format(cal1.getTime()));
			}
		}
		return time_list;
	}
	// �������ַ���ת��Ϊ���ڱ���,���������,���ص�ǰ����
	public static java.util.Date stringToDate1(String str) {
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM");
			return (java.util.Date) formatter.parse(str);
		} catch (ParseException e) {
			return new java.util.Date();
		}
	}
	public static java.util.Date stringToDate2(String str) {
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy");
			return (java.util.Date) formatter.parse(str);
		} catch (ParseException e) {
			return new java.util.Date();
		}
	}
	// ���ö��Ÿ������ַ���תΪ����;
	public static String[] split(String source) {
		if (source == null || source.trim().equals(""))
			return null;
		StringTokenizer commaToker = new StringTokenizer(source, ",");
		String[] result = new String[commaToker.countTokens()];
		int i = 0;
		while (commaToker.hasMoreTokens()) {
			result[i] = commaToker.nextToken();
			i++;
		}

		return result;
	}
	/**
	 * 
	 * ���ܣ���¡�����ֵ����һ������<br>
	 * author��zj<br>
	 * ���ڣ�2012-7-7 <br>
	 * @param source
	 * @param target
	 * @return
	 */
	public static Object cloneObj(Object source,Object target)
	{
		Field [] fields=target.getClass().getDeclaredFields();
		for(Field field :fields)
		{
			try {
				Method method1=source.getClass().getDeclaredMethod("get"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1),new Class[0]);
				Method method2=target.getClass().getDeclaredMethod("set"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1), field.getType());
				method2.invoke(target, method1.invoke(source, null));
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return target;
	}
	/**
	 * 
	 * ���ܣ�Map�е�key��Ӧʵ��field���и�ֵ<br>
	 * author��zj<br>
	 * ���ڣ�2012-7-7 <br>
	 * @param source
	 * @param target
	 * @return
	 */
	public static Object cloneMapToObj(Map source,Object target)
	{
		Field [] fields=target.getClass().getDeclaredFields();
		for(Field field :fields)
		{

			if(source.get(field.getName().toLowerCase())==null)
				continue;
			try {
				Method method2=target.getClass().getDeclaredMethod("set"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1), field.getType());
				//System.out.println(field.getType().toString()+"   "+field.getType().toString().equals(String.class.toString()));
				if(field.getType().toString().equals(String.class.toString()))
				{
					method2.invoke(target, source.get(field.getName().toLowerCase()).toString());
				}
				if(field.getType().toString().equals(int.class.toString())||field.getType().toString().equals(Integer.class.toString()))
				{
					method2.invoke(target, Integer.valueOf(source.get(field.getName().toLowerCase()).toString()));
				}
				if(field.getType().toString().equals(long.class.toString())||field.getType().toString().equals(Long.class.toString()))
				{
					method2.invoke(target, Long.valueOf(source.get(field.getName().toLowerCase()).toString()));
				}
				if(field.getType().toString().equals(double.class.toString())||field.getType().toString().equals(Double.class.toString()))
				{
					method2.invoke(target, Double.valueOf(source.get(field.getName().toLowerCase()).toString()));
				}
				if(field.getType().toString().equals(Date.class.toString()))
				{
					try {
						method2.invoke(target, new SimpleDateFormat("yyyy-MM-dd").parse(source.get(field.getName().toLowerCase()).toString()));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if(field.getType().toString().equals(boolean.class.toString()))
				{
					method2.invoke(target, Boolean.parseBoolean(source.get(field.getName().toLowerCase()).toString()));
				}
				//method2.invoke(target, source.get(field.getName()));
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return target;
	}
}
