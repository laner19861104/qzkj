package com.bip.common.enterpinfo.serviceimpl;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jxl.Sheet;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.bip.common.enterpinfo.dao.EnterpinfoDao;
import com.bip.common.enterpinfo.service.EnterpinfoService;



public class EnterpinfoServiceImpl implements EnterpinfoService {
	private EnterpinfoDao enterpinfoDao;

	public EnterpinfoDao getEnterpinfoDao() {
		return enterpinfoDao;
	}

	public void setEnterpinfoDao(EnterpinfoDao enterpinfoDao) {
		this.enterpinfoDao = enterpinfoDao;
	}

	public boolean DataMove(InputStream in) {
		return enterpinfoDao.DataMove(in);
	}
	public boolean EneryDataMove(InputStream in) {
		return enterpinfoDao.EneryDataMove(in);
	}
	public boolean getDysjb(String dyb){
		return enterpinfoDao.getDysjb(dyb);
	}
	
	public boolean getEneryDysjb(String dyb){
		return enterpinfoDao.getDysjb(dyb);
	}

	
	
}
