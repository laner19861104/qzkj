package com.bip.common.excel.service;

import java.io.InputStream;
import java.util.List;


public interface ExcelService {
	boolean DataMove(InputStream in) ;
	boolean DataMove1(InputStream in) ;
	String[] analyseBudgetsys(InputStream in);//解析表头，返回指标体系所需数据
	//List<JocBgtsystobgt> analyseBgtsystobgt(String bscode,String cccode,InputStream in);
	boolean DataMove2(InputStream in,Boolean balanceflag,Boolean cashflag,Boolean incomeflag,Boolean finstatappendflag);
	boolean BudgetsysDataMove(InputStream in) ;
	boolean export(String projcode,List finallist,List dllist,List dxlist,List spelist);
}
