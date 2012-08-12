package com.bip.common.excel.serviceimpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.apache.struts2.ServletActionContext;
import com.bip.common.excel.dao.ExcelDao;
import com.bip.common.excel.service.ExcelService;
import com.bip.common.util.Tool;
import com.bip.common.util.UniContant;
import com.bip.sys.dept.po.SysDepartment;
import com.bip.sys.user.po.SysUsers;

public class ExcelServiceImpl implements ExcelService {
	/*
	 * ����dao
	 */
	private ExcelDao excelDao;

	public boolean DataMove(InputStream in) {
		/*
		 * ��һ������������������excel
		 */
		boolean f = false;
		Workbook workbook = null;

		try {

			workbook = Workbook.getWorkbook(in);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (BiffException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
			return false;
		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
		/*
		 * �ڶ��������excel���е�sheet���������ݿ�
		 * 
		 * @param:sheetname�ĸ�ʽΪ����sys_dmzd|�����ֵ䡯
		 */
		/*
		 * 2.1:�õ�ÿ��sheet��sheetname
		 */
		Sheet[] shet = workbook.getSheets();

		for (int i = 0; i < shet.length; i++) {
			Sheet st = workbook.getSheet(i);
			String sheetname = st.getName();
			if (sheetname.indexOf("|") > -1) {
				sheetname = sheetname.substring(0, sheetname.lastIndexOf("|"));
			}
			/*
			 * 2.2:�ж�sheetname�Ƿ��Ѷ���
			 */
			if (Content(sheetname) == true) {
				/*
				 * 2.3:����sheet��ת����list�б�
				 */
				List list = getSheet(st, sheetname);
				if (list == null) {
					f = false;
				} else {
					/*
					 * 2.4:�����ݵ������ݿ�
					 */
					excelDao.addBatchByUuid(list, sheetname);
					f = true;
				}

			}
		}
		return f;
	}

	/*
	 * (non-Javadoc)���ָ����ϵ����
	 * 
	 * @see com.bip.common.excel.service.ExcelService#analyseBudgetsys(java.io.InputStream)
	 */
	public String[] analyseBudgetsys(InputStream in) {
		/*
		 * ��һ������������������excel
		 */
		boolean f = false;
		Workbook workbook = null;

		try {
			workbook = Workbook.getWorkbook(in);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (BiffException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		/*
		 * �ڶ�������sheet�л������
		 * 
		 * @param:sheetname�ĸ�ʽΪ����sys_dmzd|�����ֵ䡯
		 */
		Sheet[] shet = workbook.getSheets();
		String[] str = new String[6];
		str[0] = shet[0].getCell(2, 1).getContents().trim();// ���
		str[1] = shet[0].getCell(4, 1).getContents().trim();// ��ҵ
		str[2] = shet[0].getCell(6, 1).getContents().trim();// ��ҵ����
		//str[3] = shet[0].getCell(8, 1).getContents().trim();// ��������
		str[4] = shet[0].getCell(10, 1).getContents().trim();// ����汾
		if (str[0] == null || str[0].equals("") || str[1] == null
				|| str[1].equals("") || str[2] == null || str[2].equals("")
				|| str[4] == null
				|| str[4].equals("")) {
			return null;
		}
		String deptno = shet[0].getCell(12, 1).getContents().trim();// ��������
		if (deptno == null || deptno.equals("")) {
			str[5] = "";
		} else {
			str[5] = deptno;
		}
		System.out.println("deptno is " + str[5]);
		return str;
	}

//	public List<JocBgtsystobgt> analyseBgtsystobgt(String bscode,
//			String cccode, InputStream in) {
//		/*
//		 * ��һ������������������excel
//		 */
//		Workbook workbook = null;
//
//		try {
//			workbook = Workbook.getWorkbook(in);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (BiffException e) {
//			// TODO �Զ����� catch ��
//			e.printStackTrace();
//			return null;
//		} catch (IOException e) {
//			e.printStackTrace();
//			return null;
//		}
//		/*
//		 * �ڶ�������sheet�л������
//		 */
//		Sheet sheet = workbook.getSheet(0);
//		List<JocBgtsystobgt> list = new ArrayList();
//		int rows = sheet.getRows();
//		for (int k = 3; k < rows; k++) {
//			String[] str = new String[8];
//			for (int j = 1; j < 8; j++) {
//				System.out.println(k + "j is " + j);
//				str[j] = sheet.getCell(j, k).getContents().trim();
//			}
//			JocBgtsystobgt bgtsystobgt = new JocBgtsystobgt();
//			bgtsystobgt.setUuid(Tool.getStringUUid());
//			bgtsystobgt.setBscode(bscode);
//			bgtsystobgt.setBgtname(str[1]);
//			bgtsystobgt.setCccode(cccode);
//			//��ָ��Ϊ�գ�����ѭ��
//			if(str[1]==null||str[1].equals("")){
//				break;
//			}
//			//��Ȩ��Ϊ�ջ���Ϊ0����׼ֵȫΪ0
//			if(str[2].equals("") || str[2] == null ||str[2].equals("0")){
//				str[3]="0";
//				str[4]="0";
//				str[5]="0";
//				str[6]="0";
//				str[7]="0";
//			}
//			//����׼ֵΪ�գ���Ϊ0
//			if (str[3].equals("")|| str[3] == null) {
//				str[3]="0";
//			}
//			if (str[4].equals("")|| str[4] == null) {
//				str[4]="0";
//			}
//			if (str[5].equals("")|| str[5] == null) {
//				str[5]="0";
//			}
//			if (str[6].equals("")|| str[6] == null) {
//				str[6]="0";
//			}
//			if (str[7].equals("")|| str[7] == null) {
//				str[7]="0";
//			}
//			//���аٷֺţ����ٷֺ�ȥ��������100
//			if(str[3].indexOf("%")>0){
//				str[3]=str[3].replaceAll("%", "");
//				str[3]=String.valueOf(Double.valueOf(str[3])/100);
//			}
//			if(str[4].indexOf("%")>0){
//				str[4]=str[4].replaceAll("%", "");
//				str[4]=String.valueOf(Double.valueOf(str[4])/100);
//			}
//			if(str[5].indexOf("%")>0){
//				str[5]=str[5].replaceAll("%", "");
//				str[5]=String.valueOf(Double.valueOf(str[5])/100);
//			}
//			if(str[6].indexOf("%")>0){
//				str[6]=str[6].replaceAll("%", "");
//				str[6]=String.valueOf(Double.valueOf(str[6])/100);
//			}
//			if(str[7].indexOf("%")>0){
//				str[7]=str[7].replaceAll("%", "");
//				str[7]=String.valueOf(Double.valueOf(str[7])/100);
//			}
//			bgtsystobgt.setWeights(Double.valueOf(str[2]));
//			bgtsystobgt.setStvalue1(Double.valueOf(str[3]));
//			bgtsystobgt.setStvalue2(Double.valueOf(str[4]));
//			bgtsystobgt.setStvalue3(Double.valueOf(str[5]));
//			bgtsystobgt.setStvalue4(Double.valueOf(str[6]));
//			bgtsystobgt.setStvalue5(Double.valueOf(str[7]));
//			list.add(bgtsystobgt);
//		}
//		return list;
//	}

	/*
	 * (non-Javadoc)�˷���Ϊ����ϵ����ָ��
	 * 
	 * @see com.bip.common.excel.service.ExcelService#BudgetsysDataMove(java.io.InputStream)
	 */
	public boolean BudgetsysDataMove(InputStream in) {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String bscode = (String) session.getAttribute("bscode");
		if (bscode == null || "".equals(bscode)) {
			return false;
		} else {
			session.setAttribute("bscode", bscode);
		}
		/*
		 * ��һ������������������excel
		 */
		boolean f = false;
		Workbook workbook = null;

		try {
			workbook = Workbook.getWorkbook(in);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (BiffException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		/*
		 * �ڶ��������excel���е�sheet���������ݿ�
		 * 
		 * @param:sheetname�ĸ�ʽΪ����sys_dmzd|�����ֵ䡯
		 */
		/*
		 * 2.1:�õ�ÿ��sheet��sheetname
		 */
		Sheet[] shet = workbook.getSheets();

		for (int i = 0; i < shet.length; i++) {
			Sheet st = workbook.getSheet(i);
			String sheetname = st.getName();
			if (sheetname.indexOf("|") > -1) {
				sheetname = sheetname.substring(0, sheetname.lastIndexOf("|"));
			}
			System.out.println("sheetname is " + sheetname);
			/*
			 * 2.2:�ж�sheetname�Ƿ��Ѷ���
			 */
			if (Content(sheetname) == true) {
				/*
				 * 2.3:����sheet��ת����list�б�
				 */
				List list = getBgtSheet(st, sheetname);
				if (list == null) {
					f = false;
				} else {
					/*
					 * 2.4:�����ݵ������ݿ�
					 */
					excelDao.addBatchByUuid(list, sheetname);
					f = true;
				}
			}
		}
		return f;
	}

	/**
	 * �жϵ���ģ���Ƿ����
	 * 
	 * @param sname
	 * @return
	 */
	public boolean Content(String sname) {
		String str = UniContant.exceltemplate;
		System.out.println(str);
		String[] sz = Tool.split(",", str);
		boolean f = false;
		for (int i = 0; i < sz.length; i++) {
			if (sname.equals(sz[i])) {
				f = true;
			}
		}
		return f;

	}

	/*
	 * ģ��ѭ��(��)
	 */
	public List getSheet(Sheet sheet, String sheetname) {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		SysUsers sysuser = (SysUsers) session.getAttribute("sysuser");
		String entname = (String) session.getAttribute("entname");
		String projcode = (String) session.getAttribute("projcode");
		SysDepartment department = (SysDepartment) session
				.getAttribute("sysdept");
		List list = new ArrayList();
		int cc = sheet.getColumns();

		int rows = sheet.getRows();
		int dd = 0;

		for (int k = 0; k < rows; k++) {
			if ("1".equals(sheet.getCell(0, k).getContents())) {
				dd = k;
			}
		}

		Map map = null;
		for (int i = dd; i < rows; i++) {
			map = new HashMap();
			for (int j = 1; j < cc; j++) {// ��ѭ��
				map.put(sheet.getCell(j, 0).getContents(), sheet.getCell(j, i)
						.getContents().trim());
			}
			map.put("projcode", session.getAttribute("projcode"));
			map.put("ischeck", "0");
			if (sysuser != null)
				map.put("cruser", sysuser.getUserxm());
			else
				map.put("cruser", entname);
			map.put("crdate", Tool.stringOfDate());
			if (sheet.getCell(1, i).getContents().trim() != null
					&& !sheet.getCell(1, i).getContents().trim().equals("")) {
				list.add(map);
			}
		}

		return list;
	}

	/*
	 * ��ϵģ��
	 */
	public List getBgtSheet(Sheet sheet, String sheetname) {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		String bscode = (String) session.getAttribute("bscode");
		SysDepartment department = (SysDepartment) session
				.getAttribute("sysdept");
		if (department == null || bscode == null || "".equals(bscode)) {
			return null;
		}
		List list = new ArrayList();
		int cc = sheet.getColumns();

		int rows = sheet.getRows();
		int dd = 0;

		for (int k = 0; k < rows; k++) {
			if ("1".equals(sheet.getCell(0, k).getContents())) {
				dd = k;
			}
		}

		Map map = null;
		for (int i = dd; i < rows; i++) {
			map = new HashMap();
			for (int j = 1; j < cc; j++) {// ��ѭ��
				map.put(sheet.getCell(j, 0).getContents(), sheet.getCell(j, i)
						.getContents().trim());
			}
			map.put("projcode", session.getAttribute("projcode"));
			if ("01".equals(department.getDepttype())) {
				map.put("cccode", "");
			} else {
				map.put("cccode", department.getDeptno().substring(0, 4));
			}
			map.put("bscode", bscode);
			if (sheet.getCell(1, i).getContents().trim() != null
					&& !sheet.getCell(1, i).getContents().trim().equals("")) {
				list.add(map);
			}
		}

		return list;
	}

	/*
	 * ��ȡ�������ݣ������������еø��š���ֵ�����š������
	 */
	public List getcwSheet(Sheet sheet, String sheetname) {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		SysUsers sysuser = (SysUsers) session.getAttribute("sysuser");
		String entname = (String) session.getAttribute("entname");
		SysDepartment department = (SysDepartment) session
				.getAttribute("sysdept");
		List list = new ArrayList();
		int cc = sheet.getColumns();

		int rows = sheet.getRows();
		int dd = 0;

		for (int k = 0; k < rows; k++) {
			if ("start".equals(sheet.getCell(3, k).getContents())) {
				dd = k;
			}
		}
		Map map = null;
		for (int i = 4; i < 8; i++) {
			System.out.println("=====i is " + i);
			if (!sheet.getCell(i, 4).getContents().trim().equals("")
					&& sheet.getCell(i, 4).getContents().trim() != null) {
				map = new HashMap();
				for (int j = dd; j < rows; j++) {// ��ѭ��
					if (!"ei999".equals(sheet.getCell(0, j).getContents())) {
						if (sheet.getCell(i, j).getContents().trim() == null
								|| "".equals(sheet.getCell(i, j).getContents()
										.trim())) {
							map.put(sheet.getCell(0, j).getContents(), 0);
						} else {
							String str = sheet.getCell(i, j).getContents()
									.trim();
							// �ж��Ƿ��ַ����к���(),���ʾ��ֵΪ��
							if (sheet.getCell(i, j).getContents().trim()
									.indexOf("(") != -1) {
								str = str.replace("(", "");
								str = str.replace(")", "");
							}
							// �ж��Ƿ��ж���
							for (int k = 0; k < str.length() / 3; k++) {
								if (sheet.getCell(i, j).getContents().trim()
										.indexOf(",") != -1) {
									str = str.replace(",", "");
								}
							}
							map.put(sheet.getCell(0, j).getContents(), str);
						}
					}
				}
				map.put("projcode", session.getAttribute("projcode"));
				map.put("acctyear", sheet.getCell(i, 4).getContents().trim());
				map.put("ischeck", "0");
				if (sysuser != null)
					map.put("cruser", sysuser.getUserxm());
				else
					map.put("cruser", entname);
				map.put("crdate", Tool.stringOfDate());
				String tablename = "";
				if (sheetname.equals("job_income")) {
					tablename = "JobIncome";
					for (int k = 21; k < 61; k++)
						map.put("ei0" + String.valueOf(k), 0);
				}
				if (sheetname.equals("job_incomeold")) {
					tablename = "JobIncome";
					for (int k = 39; k < 61; k++)
						map.put("ei0" + String.valueOf(k), 0);
				}
				if (sheetname.equals("job_balance")) {
					tablename = "JobBalance";
					for (int k = 66; k < 91; k++)
						map.put("ei0" + String.valueOf(k), 0);
				}
				if (sheetname.equals("job_balanceold")) {
					tablename = "JobBalance";
					for (int k = 77; k < 91; k++)
						map.put("ei0" + String.valueOf(k), 0);
				}
				if (sheetname.equals("job_cashflow")) {
					tablename = "JobCashflow";
					for (int k = 67; k < 81; k++)
						map.put("ei0" + String.valueOf(k), 0);
				}
				if (sheetname.equals("job_cashflowold")) {
					tablename = "JobCashflow";
					for (int k = 54; k < 81; k++)
						map.put("ei0" + String.valueOf(k), 0);
				}
				if (sheetname.equals("job_finstatappend")) {
					tablename = "job_finstatappend";
					for (int k = 20; k < 61; k++)
						map.put("ei0" + String.valueOf(k), 0);
				}
				if (sheetname.equals("job_finstatappendold")) {
					tablename = "job_finstatappend";
					for (int k = 20; k < 61; k++)
						map.put("ei0" + String.valueOf(k), 0);
				}
				if (sheetname.equals("job_balance")
						|| sheetname.equals("job_income")
						|| sheetname.equals("job_cashflow")
						|| sheetname.equals("job_finstatappend"))
					map.put("finstat", "1");
				else
					map.put("finstat", "0");
				map.put("ccstandby4", 0);
				map.put("ccstandby5", 0);
				if (!sheet.getCell(i, 4).getContents().trim().equals("")
						&& sheet.getCell(i, 4).getContents().trim() != null
						&& !tablename.equals("")) {
					list.add(map);
				}
			}
		}
		if (list.size() > 4) {
			return null;
		}
		System.out.println("list is " + list.size());
		return list;

	}

	/*
	 * ��ҵ��Ϣ���ݵĵ��� (non-Javadoc)
	 * 
	 * @see com.bip.common.excel.service.EnterpinfoService#DataMove1(java.io.InputStream)
	 */
	public boolean DataMove1(InputStream in) {

		boolean f = false;
		Workbook workbook = null;

		try {

			workbook = Workbook.getWorkbook(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (BiffException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
			return false;
		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
		try {
			Sheet[] shet = workbook.getSheets();

			for (int i = 0; i < shet.length; i++) {
				Sheet st = workbook.getSheet(i);
				String sheetname = st.getName();
				if (sheetname.indexOf("|") > -1) {
					sheetname = sheetname.substring(0, sheetname
							.lastIndexOf("|"));
				}
				if (Content(sheetname) == true) {
					if ("job_enterinfo01".equals(sheetname)) {
						List list = getJobenterinfo01(st);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
						}
						System.out.println("111111111111111111");
					} else if ("job_enterinfo02".equals(sheetname)) {
						List list = getSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
						}
						System.out.println("222222222222222222");
					} else if ("job_enterinfo03".equals(sheetname)) {
						List list = getSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
						}
						System.out.println("222222222222222222");
					} else if ("job_enterinfo04".equals(sheetname)) {
						List list = getSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
						}
						System.out.println("222222222222222222");
					} else if ("job_enterinfo05".equals(sheetname)) {
						List list = getJobenterinfo05(st);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
						}
					} else if ("job_enterinfo18".equals(sheetname)) { // �ӱ����в�ֶ���
						List list = getSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
						}
					} else if ("job_enterinfo06".equals(sheetname)) {
						List list = getSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
						}
					} else if ("job_enterinfo19".equals(sheetname)) { // �ӱ����в�ֶ���
						List list = getJobenterinfo19(st);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
						}
					} else if ("job_enterinfo07".equals(sheetname)) {
						List list = getSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
						}
					} else if ("job_enterinfo08".equals(sheetname)) { // �ӱ����в�ֶ���
						List list = getSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
						}
					} else if ("job_enterinfo09".equals(sheetname)) {
						List list = getSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
						}
					} else if ("job_enterinfo10".equals(sheetname)) {
						List list = getSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
						}
					} else if ("job_enterinfo11".equals(sheetname)) {
						List list = getSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
						}
					}

					else if ("job_enterinfo12".equals(sheetname)) {
						List list = getSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
						}
					} else if ("job_enterinfo13".equals(sheetname)) {
						List list = getSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
						}
					} else if ("job_enterinfo14".equals(sheetname)) {
						List list = getSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
						}
					} else if ("job_enterinfo15".equals(sheetname)) {
						List list = getSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
						}
					} else if ("job_enterinfo16".equals(sheetname)) {
						List list = getSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
						}
					} else if ("job_enterinfo17".equals(sheetname)) {
						List list = getSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
						}
					} else if ("job_enterinfo19".equals(sheetname)) {
						List list = getJobenterinfo19(st);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
						}
					} else if ("job_enterinfo20".equals(sheetname)) {
						List list = getSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
						}
					} else if ("job_enterinfo21".equals(sheetname)) {
						List list = getJobenterinfo15(st);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
						}
					} else if ("job_enterinfo22".equals(sheetname)) {
						List list = getSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
						}
					} else if ("job_enterinfo23".equals(sheetname)) {
						List list = getSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
						}
					} else if ("job_enterinfo24".equals(sheetname)) {
						List list = getSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return f;

	}

	/*
	 * ������Ϣ�ĵ��� (non-Javadoc)
	 * 
	 * @see com.bip.common.excel.service.EnterpinfoService#DataMove2(java.io.InputStream)
	 */
	public boolean DataMove2(InputStream in, Boolean balanceflag,
			Boolean cashflag, Boolean incomeflag, Boolean finstatappendflag) {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		String finstat = (String) session.getAttribute("finstat");
		System.out.println("finstat is " + finstat);
		if (finstat == null || "".equals(finstat)) {
			System.out.println("======error");
			return false;
		}
		boolean f = false;
		Workbook workbook = null;
		System.out.println("===============2");
		try {

			workbook = Workbook.getWorkbook(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (BiffException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		try {
			Sheet[] shet = workbook.getSheets();

			for (int i = 0; i < shet.length; i++) {

				Sheet st = workbook.getSheet(i);
				String sheetname = st.getName();
				System.out.println("=============3" + sheetname);
				if (sheetname.indexOf("|") > -1) {
					sheetname = sheetname.substring(0, sheetname
							.lastIndexOf("|"));
				}
				System.out.println("=============4" + sheetname);
				if (Content(sheetname) == true) {
					if ("job_balance".equals(sheetname)) {
						if (finstat.equals("0"))
							return false;
						List list = getcwSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
							/*
							 * ԭʼ���������ݣ������ݵ���
							 */
							if (balanceflag == false)
								excelDao.addBatchByUuid(list,
										"job_balanceoriginal");
						}
					} else if ("job_income".equals(sheetname)) {
						if (finstat.equals("0"))
							return false;
						List list = getcwSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
							/*
							 * ԭʼ���������ݣ������ݵ���
							 */
							if (incomeflag == false)
								excelDao.addBatchByUuid(list,
										"job_incomeoriginal");
						}
					} else if ("job_cashflow".equals(sheetname)) {
						if (finstat.equals("0"))
							return false;
						List list = getcwSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
							/*
							 * ԭʼ���������ݣ������ݵ���
							 */
							if (cashflag == false)
								excelDao.addBatchByUuid(list,
										"job_cashfloworiginal");
						}
					} else if ("job_finstatappend".equals(sheetname)) {
						if (finstat.equals("0"))
							return false;
						List list = getcwSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, sheetname);
							f = true;
							/*
							 * ԭʼ���������ݣ������ݵ���
							 */
							if (finstatappendflag == false)
								excelDao.addBatchByUuid(list,
										"job_finstatappendoriginal");
						}
					} else if ("job_balanceold".equals(sheetname)) {
						if (finstat.equals("1"))
							return false;
						List list = getcwSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, "job_balance");
							f = true;
							/*
							 * ԭʼ���������ݣ������ݵ���
							 */
							if (balanceflag == false)
								excelDao.addBatchByUuid(list,
										"job_balanceoriginal");
						}
					} else if ("job_incomeold".equals(sheetname)) {
						if (finstat.equals("1"))
							return false;
						List list = getcwSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, "job_income");
							f = true;
							/*
							 * ԭʼ���������ݣ������ݵ���
							 */
							if (incomeflag == false)
								excelDao.addBatchByUuid(list,
										"job_incomeoriginal");
						}
					} else if ("job_cashflowold".equals(sheetname)) {
						if (finstat.equals("1"))
							return false;
						List list = getcwSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, "job_cashflow");
							f = true;
							/*
							 * ԭʼ���������ݣ������ݵ���
							 */
							if (cashflag == false)
								excelDao.addBatchByUuid(list,
										"job_cashfloworiginal");
						}
					} else if ("job_finstatappendold".equals(sheetname)) {
						if (finstat.equals("1"))
							return false;
						List list = getcwSheet(st, sheetname);
						if (list != null) {
							excelDao.addBatchByUuid(list, "job_finstatappend");
							f = true;
							/*
							 * ԭʼ���������ݣ������ݵ���
							 */
							if (cashflag == false)
								excelDao.addBatchByUuid(list,
										"job_finstatappendoriginal");
						}
					}
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return f;

	}

	/*
	 * �̶���ʽ�ı�һ
	 */
	public List getJobenterinfo01(Sheet sheet) {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		SysUsers sysuser = (SysUsers) session.getAttribute("sysuser");
		String entname = (String) session.getAttribute("entname");
		String projcode = (String) session.getAttribute("projcode");
		SysDepartment department = (SysDepartment) session
				.getAttribute("sysdept");

		List list = new ArrayList();

		Map map = null;

		map = new HashMap();
		map.put("ei001", sheet.getCell(1, 1).getContents().trim());
		map.put("ei002", sheet.getCell(5, 1).getContents().trim());
		map.put("ei003", sheet.getCell(1, 2).getContents().trim());// ע���ַ
		map.put("ei004", sheet.getCell(5, 2).getContents().trim());
		map.put("ei005", sheet.getCell(1, 3).getContents().trim());
		map.put("ei006", sheet.getCell(5, 3).getContents().trim());
		map.put("ei007", sheet.getCell(1, 4).getContents().trim());
		map.put("ei008", sheet.getCell(5, 4).getContents().trim());
		map.put("ei009", sheet.getCell(1, 5).getContents().trim());
		map.put("ei010", sheet.getCell(5, 5).getContents().trim());
		map.put("ei011", sheet.getCell(1, 6).getContents().trim());
		map.put("ei012", sheet.getCell(1, 7).getContents().trim());
		map.put("ei013", sheet.getCell(1, 8).getContents().trim());
		map.put("ei014", sheet.getCell(1, 9).getContents().trim());
		map.put("ei015", sheet.getCell(3, 9).getContents().trim());
		map.put("ei016", sheet.getCell(5, 9).getContents().trim());
		map.put("ei017", sheet.getCell(1, 10).getContents().trim());
		map.put("ei018", sheet.getCell(3, 10).getContents().trim());
		map.put("ei019", sheet.getCell(5, 10).getContents().trim());
		map.put("ei020", sheet.getCell(1, 11).getContents().trim());
		map.put("ei021", sheet.getCell(3, 11).getContents().trim());
		map.put("ei022", sheet.getCell(5, 11).getContents().trim());
		map.put("ei023", sheet.getCell(7, 11).getContents().trim());
		map.put("ei036", sheet.getCell(1, 12).getContents().trim());
		map.put("projcode", session.getAttribute("projcode"));
		map.put("ischeck", "0");
		if (sysuser != null)
			map.put("cruser", sysuser.getUserxm());
		else
			map.put("cruser", entname);
		map.put("crdate", Tool.stringOfDate());
		System.out.println("====" + entname);
		if (sheet.getCell(1, 1).getContents().trim() != null
				&& !sheet.getCell(1, 1).getContents().trim().equals("")) {
			list.add(map);
		}
		return list;
	}

	/*
	 * �����в�ֶ���
	 */
	public List getJobenterinfo05(Sheet sheet) {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		SysUsers sysuser = (SysUsers) session.getAttribute("sysuser");
		String entname = (String) session.getAttribute("entname");
		String projcode = (String) session.getAttribute("projcode");
		SysDepartment department = (SysDepartment) session
				.getAttribute("sysdept");

		List list = new ArrayList();

		Map map = null;

		map = new HashMap();
		map.put("ei001", sheet.getCell(1, 6).getContents().trim());
		map.put("ei002", sheet.getCell(1, 7).getContents().trim());
		map.put("ei003", sheet.getCell(2, 6).getContents().trim());
		map.put("ei004", sheet.getCell(2, 7).getContents().trim());
		map.put("ei005", sheet.getCell(3, 6).getContents().trim());
		map.put("ei006", sheet.getCell(3, 7).getContents().trim());
		map.put("ei007", sheet.getCell(4, 6).getContents().trim());
		map.put("ei008", sheet.getCell(4, 7).getContents().trim());
		map.put("ei009", sheet.getCell(5, 6).getContents().trim());
		map.put("ei010", sheet.getCell(5, 7).getContents().trim());
		map.put("ei011", sheet.getCell(6, 6).getContents().trim());
		map.put("ei012", sheet.getCell(6, 7).getContents().trim());
		map.put("ei013", sheet.getCell(7, 6).getContents().trim());
		map.put("ei014", sheet.getCell(7, 7).getContents().trim());
		map.put("ei015", sheet.getCell(8, 6).getContents().trim());
		map.put("ei016", sheet.getCell(8, 7).getContents().trim());
		map.put("ei017", sheet.getCell(9, 6).getContents().trim());
		map.put("ei018", sheet.getCell(9, 7).getContents().trim());
		map.put("ei019", sheet.getCell(10, 6).getContents().trim());
		map.put("ei020", sheet.getCell(10, 7).getContents().trim());
		map.put("projcode", session.getAttribute("projcode"));
		map.put("ischeck", "0");
		if (sysuser != null)
			map.put("cruser", sysuser.getUserxm());
		else
			map.put("cruser", entname);
		map.put("crdate", Tool.stringOfDate());
		if (sheet.getCell(1, 6).getContents().trim() != null
				&& !sheet.getCell(1, 6).getContents().trim().equals("")) {
			list.add(map);
		}
		return list;
	}

	/*
	 * �����в�ֶ���
	 */
	public List getJobenterinfo15(Sheet sheet) {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		SysUsers sysuser = (SysUsers) session.getAttribute("sysuser");
		String entname = (String) session.getAttribute("entname");
		String projcode = (String) session.getAttribute("projcode");
		SysDepartment department = (SysDepartment) session
				.getAttribute("sysdept");

		List list = new ArrayList();

		Map map = null;

		map = new HashMap();
		map.put("ei001", sheet.getCell(2, 1).getContents().trim());
		map.put("ei002", sheet.getCell(2, 2).getContents().trim());
		map.put("ei003", sheet.getCell(2, 3).getContents().trim());
		map.put("ei004", sheet.getCell(2, 4).getContents().trim());
		map.put("ei005", sheet.getCell(3, 1).getContents().trim());
		map.put("ei006", sheet.getCell(3, 2).getContents().trim());
		map.put("ei007", sheet.getCell(3, 3).getContents().trim());
		map.put("ei008", sheet.getCell(3, 4).getContents().trim());
		map.put("projcode", session.getAttribute("projcode"));
		map.put("ischeck", "0");
		if (sysuser != null)
			map.put("cruser", sysuser.getUserxm());
		else
			map.put("cruser", entname);
		map.put("crdate", Tool.stringOfDate());
		if (sheet.getCell(2, 1).getContents().trim() != null
				&& !sheet.getCell(2, 1).getContents().trim().equals("")) {
			list.add(map);
		}
		return list;
	}

	/*
	 * ���н��������ϸ��
	 */
	public List getJobenterinfo19(Sheet sheet) {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		SysUsers sysuser = (SysUsers) session.getAttribute("sysuser");
		String entname = (String) session.getAttribute("entname");
		String projcode = (String) session.getAttribute("projcode");
		SysDepartment department = (SysDepartment) session
				.getAttribute("sysdept");

		List list = new ArrayList();

		Map map = null;
		for (int i = 4; i < 16; i++) {
			map = new HashMap();
			map.put("ei001", sheet.getCell(1, i).getContents().trim());
			map.put("ei002", sheet.getCell(2, i).getContents().trim());
			map.put("ei003", sheet.getCell(3, i).getContents().trim());
			map.put("ei004", sheet.getCell(4, i).getContents().trim());
			map.put("ei005", sheet.getCell(5, i).getContents().trim());
			map.put("ei006", sheet.getCell(6, i).getContents().trim());
			map.put("ei007", sheet.getCell(7, i).getContents().trim());
			map.put("ei008", sheet.getCell(8, i).getContents().trim());
			map.put("ei009", sheet.getCell(9, i).getContents().trim());
			map.put("ei010", sheet.getCell(10, i).getContents().trim());

			map.put("ei011", sheet.getCell(2, 16).getContents().trim());// �����ѻ������
			map.put("ei012", sheet.getCell(7, 16).getContents().trim());// �����ۼ�Ӧ�黹�Ĵ����
			map.put("ei013", sheet.getCell(2, 17).getContents().trim());// �����ѻ�������Ϣ
			map.put("ei014", sheet.getCell(7, 17).getContents().trim());// �����ۼ�Ӧ�����Ĵ�����Ϣ

			map.put("projcode", session.getAttribute("projcode"));
			map.put("ischeck", "0");
			if (sysuser != null)
				map.put("cruser", sysuser.getUserxm());
			else
				map.put("cruser", entname);
			map.put("crdate", Tool.stringOfDate());
			if (!sheet.getCell(2, i).getContents().trim().equals("")
					&& sheet.getCell(2, i).getContents().trim() != null) {
				list.add(map);
			}
		}
		return list;
	}

	/*
	 * ���յ÷���ϸ
	 */
	public boolean export(String projcode, List finallist, List dllist,
			List dxlist, List spelist) {
		try {
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public ExcelDao getExcelDao() {
		return excelDao;
	}

	public void setExcelDao(ExcelDao excelDao) {
		this.excelDao = excelDao;
	}

}
