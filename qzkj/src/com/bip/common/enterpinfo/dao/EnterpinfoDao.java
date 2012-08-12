package com.bip.common.enterpinfo.dao;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jxl.Sheet;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface EnterpinfoDao  {

	boolean DataMove(InputStream in) ;
	boolean EneryDataMove(InputStream in) ;
	public boolean getDysjb(String dyb);
	public boolean getEneryDysjb(String dyb);
}
