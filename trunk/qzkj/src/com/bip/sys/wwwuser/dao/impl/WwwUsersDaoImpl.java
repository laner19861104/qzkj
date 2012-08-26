package com.bip.sys.wwwuser.dao.impl;

import org.springframework.stereotype.Repository;

import com.bip.common.dao.GenericDao;
import com.bip.sys.wwwuser.dao.WwwUsersDao;
import com.bip.sys.wwwuser.po.WwwUsers;
@Repository
public class WwwUsersDaoImpl extends GenericDao< WwwUsers, String> implements WwwUsersDao{

}
