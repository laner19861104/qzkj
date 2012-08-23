package com.bip.sys.wwwuser.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bip.common.service.BaseService;
import com.bip.common.util.QueryJson;
import com.bip.sys.wwwuser.dao.WwwUsersDao;
import com.bip.sys.wwwuser.po.WwwUsers;
import com.bip.sys.wwwuser.service.WwwUsersService;
@Service
public class WwwUsersServiceImpl extends BaseService implements WwwUsersService{
private WwwUsersDao wwwUsersDao;

public WwwUsersDao getWwwUsersDao() {
	return wwwUsersDao;
}
@Resource
public void setWwwUsersDao(WwwUsersDao wwwUsersDao) {
	this.wwwUsersDao = wwwUsersDao;
}
@Override
public QueryJson findPageByQuery(String conditions, int row, int i) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public WwwUsers get(int id) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Serializable save(WwwUsers po) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public void update(WwwUsers po) {
	// TODO Auto-generated method stub
	
}
@Override
public void delete(String string, String string2) {
	// TODO Auto-generated method stub
	
}
}
