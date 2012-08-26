package com.bip.sys.wwwuser.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bip.common.service.BaseService;
import com.bip.common.util.QueryJson;
import com.bip.sys.wwwuser.dao.WwwUsersDao;
import com.bip.sys.wwwuser.po.WwwUsers;
import com.bip.sys.wwwuser.service.WwwUsersService;
@Service
public class WwwUsersServiceImpl extends BaseService implements WwwUsersService{
@Resource
private WwwUsersDao wwwUsersDao;

public WwwUsersDao getWwwUsersDao() {
	return wwwUsersDao;
}

public void setWwwUsersDao(WwwUsersDao wwwUsersDao) {
	this.wwwUsersDao = wwwUsersDao;
}
@Override
public QueryJson findPageByQuery(String conditions, int row, int i) {
	return super.PageQuery(wwwUsersDao, null, conditions, row, i);
}
@Override
public WwwUsers get(String id) {
	return this.wwwUsersDao.get(id);
}
@Override
public Serializable save(WwwUsers po) {
	return this.wwwUsersDao.save(po);
}
@Override
public void update(WwwUsers po) {
	this.wwwUsersDao.saveOrUpdate(po);
	
}
@Override
public void delete(String ids) {
	List list=this.wwwUsersDao.find("from WwwUsers t where t.uuid in ("+ids+")");
	this.wwwUsersDao.deleteAll(list);
}
}
