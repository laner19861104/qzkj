package com.bip.common.enterpinfo.daoimpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.struts2.ServletActionContext;

import org.hibernate.Session;

import com.bip.common.dao.BaseDAO;

import com.bip.common.enterpinfo.dao.EnterpinfoDao;


public class EnterpinfoDaoImpl extends BaseDAO implements EnterpinfoDao {

	public boolean DataMove(InputStream in) {
		
		boolean f = false;
		Workbook workbook = null;

		try {

			workbook = Workbook.getWorkbook(in);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (BiffException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
			return false;
		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}

		Sheet[] shet = workbook.getSheets();

		for (int i = 0; i < shet.length; i++) {
//			System.out.println("==========" + i);
			Sheet st = workbook.getSheet(i);
			String sheetname = st.getName();
			if (sheetname.indexOf("|") > -1) {

				sheetname = sheetname.substring(0, sheetname.lastIndexOf("|"));
			}
//			System.out.println("sheetname=====" + sheetname);
			if (Content(sheetname) == true) {

				List list=getSheet(st,sheetname);
				System.out.println(list==null);
				if(list==null){
					f=false;
				}else{
					
					addBatch(list, sheetname);
					f = true;
				}

			}

		}
//		System.out.println("uuuuuuuuuuuuuuuu========" + f);
		return f;

	}

	
	
      public boolean EneryDataMove(InputStream in) {
		
		boolean f = false;
		Workbook workbook = null;

		try {

			workbook = Workbook.getWorkbook(in);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (BiffException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
			return false;
		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}

		Sheet[] shet = workbook.getSheets();

		for (int i = 0; i < shet.length; i++) {
//			System.out.println("==========" + i);
			Sheet st = workbook.getSheet(i);
			String sheetname = st.getName();
			if (sheetname.indexOf("|") > -1) {

				sheetname = sheetname.substring(0, sheetname.lastIndexOf("|"));
			}
//			System.out.println("sheetname=====" + sheetname);
			if (Content(sheetname) == true) {

				List list=getEnerySheet(st,sheetname);
//				System.out.println(list==null);
				if(list==null){
					f=false;
				}else{
					
					addBatch(list, sheetname);
					f = true;
				}

			}

		}
//		System.out.println("uuuuuuuuuuuuuuuu========" + f);
		return f;

	}
	
	
	
	
	
	
	public boolean Content(String sname) {
		String[] sz = { "job_enterprise", "job_productprice", "job_qysbb", "job_cxzzb", "job_gyjjzbjmb", "job_gyzjzzzsdb", "job_jjzbb",
				"job_basic", "job_basicfb", "job_cpb", "job_sbb", "job_nyxfjgb", "job_jnkhb", "job_bhyssm", "job_jnmbwcb", "job_ysb", "job_basic_fgs"
				, "job_basic_gly", "job_basic_glzd", "job_basic_gyzb","job_cpzhnhb","sys_nhzbzd","sys_nyzd","sys_dmzd","job_enterprisejnl",
				"sys_zhcxzbzd","sys_zbfileld","sys_zhcxzbdyb","sys_qyxe","sys_rpttable"};

		boolean f = false;
		for (int i = 0; i < sz.length; i++) {
			if (sname.equals(sz[i])) {
				f = true;
			}

		}

		return f;

	}

	public List getEnerySheet(Sheet sheet,String sheetname) {
		HttpServletRequest request = ServletActionContext.getRequest();
		List list = new ArrayList();
		int cc = sheet.getColumns();

		int rows = sheet.getRows();
		int dd = 0;
//		System.out.println(rows + "===rows");

		for (int k = 0; k < rows; k++) {
			if ("1".equals(sheet.getCell(0, k).getContents())) {
				dd = k;
//				 System.out.println(dd+"=========================");
			}
		}

		Map map = null;
		for (int i = dd; i < rows; i++) {
			map = new HashMap();
			for (int j = 1; j < cc; j++) {// 列循环
				
				map.put(sheet.getCell(j, 0).getContents(), sheet.getCell(j, i)
							.getContents());
			}
			list.add(map);

		}
		return list;
	}
	
	

	public List getSheet(Sheet sheet,String sheetname) {
		HttpServletRequest request = ServletActionContext.getRequest();
		List list = new ArrayList();
		int cc = sheet.getColumns();

		int rows = sheet.getRows();
		int dd = 0;
//		System.out.println(rows + "===rows");

		for (int k = 0; k < rows; k++) {
			if ("1".equals(sheet.getCell(0, k).getContents())) {
				dd = k;
				// System.out.println(dd+"=========================");
			}
		}

		Map map = null;
		for (int i = dd; i < rows; i++) {
			map = new HashMap();
			for (int j = 1; j < cc; j++) {// 列循环
				if("job_qysbb".equals(sheetname)){
					if("res01".equals(sheet.getCell(j, 0).getContents().trim())){
						if("".equals(sheet.getCell(j, i).getContents().trim())){
							
							return null;
						}
					}
					map.put(sheet.getCell(j, 0).getContents(), sheet.getCell(j, i)
							.getContents().trim());
				}else{
					if("zbid".equals(sheet.getCell(j, 0).getContents().trim())){
//						System.out.println("sheet.getCell(j, i).getContents()======"+sheet.getCell(j, i).getContents());
						Long zid=getZbid(sheet.getCell(j, i).getContents().trim());
						if(zid==0){
							return null;
						}else{
						map.put(sheet.getCell(j, 0).getContents().trim(), zid);
						}
					}else{
						map.put(sheet.getCell(j, 0).getContents(), sheet.getCell(j, i)
							.getContents().trim());
					}
				}
				
				
//				System.out.println("sheet.getCell(j, 0).getContents()======"+j+"====="+sheet.getCell(j, 0).getContents());
//				System.out.println(" sheet.getCell(j, i).getContents()======"+i+"===="+ sheet.getCell(j, i)
//						.getContents());
			}
			list.add(map);

			// map.put("zbbh",sheet.getCell(0, i).getContents());
			// map.put("bh",sheet.getCell(1, i).getContents());
			// map.put("bm",sheet.getCell(2, i).getContents());
			// map.put("zbjg",sheet.getCell(3, i).getContents());
			// map.put("wh",sheet.getCell(4, i).getContents());

		}

		
		
		
		return list;
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
	public List getFacechm(String[] fieldname,String[] fieldold ,String[] fieldtype,String[] dyfield,String[] dyfieldtype,Long cid ){
		List list=new ArrayList();		
		Map map =null; 
		for (int i = 0; i < fieldname.length; i++) {
		map=new HashMap();
		
			map.put("fieldname",fieldname[i]);
			map.put("fieldold",fieldold[i]);
			map.put("fieldtype",fieldtype[i]);
			map.put("dyfield",dyfield[i]);
			map.put("dyfieldtype",dyfieldtype[i]);
			map.put("interid",cid);
		
			list.add(map);	
		}
		
		

		return list;
	}

	public Long getZbid(String jslzbid){
		Long f=null;
		String hql="select zbid from JobQysbb where res01='"+jslzbid+"'";
		List list=this.getHibernateTemplate().find(hql);
		
		f=Long.parseLong(list.get(0).toString()) ;
	
		return f;
	}
	public boolean getDysjb(String dyb){
		boolean f=false;
		int dybcount=0;
		String sql="select count(*) from JobInterfaceb where code='"+dyb+"'";
		List list=this.getHibernateTemplate().find(sql);
		dybcount=Integer.parseInt(list.get(0).toString()) ;

		if(dybcount==0){
			f=true;
		}else{
			f=false;
		}
		return f;
	}
	
	public boolean getEneryDysjb(String dyb){
		
		return getDysjb(dyb);
	}
}
