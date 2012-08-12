package com.bip.sys.user.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bip.common.dao.GenericDao;
import com.bip.common.util.Encoding;
import com.bip.sys.user.dao.UserDao;
import com.bip.sys.user.po.SysUsers;
@Repository
public class UserDaoImpl extends GenericDao<SysUsers, Integer> implements
		UserDao {

	public boolean validate(String userName, String passWord) {
		// TODO Auto-generated method stub

		List ulist = new ArrayList();
		String sql = "FROM SysUsers where userName='" + userName + "' and state='0' ";
		ulist = this.getHibernateTemplate().find(sql);
		if (ulist == null || ulist.size() == 0)
			return false;
		else {
			if (Encoding.encodeCmd(passWord).equals(
					((SysUsers) ulist.get(0)).getPassword()))
				return true;
			else
				return false;
		}
	}

	public boolean validate(String userName) {
		// TODO Auto-generated method stub
		List ulist = new ArrayList();
		String sql = "FROM SysUsers where userName='" + userName + "'";
		ulist = this.getHibernateTemplate().find(sql);
		if (ulist == null || ulist.size() == 0)
			return false;
		else {
			if (ulist.size() == 1)
				return true;
			else
				return false;
		}
	}

	public SysUsers getUserByUserName(String userName) {
		List ulist = new ArrayList();
		String sql = "FROM SysUsers where userName='" + userName + "'";
		ulist = this.getHibernateTemplate().find(sql);
		if (ulist == null || ulist.size() == 0)
			return null;
		else {
			return (SysUsers) ulist.get(0);
		}
	}
	public SysUsers getUserByUserid(String userid) {
		List ulist = new ArrayList();
		String sql = "FROM SysUsers where userid=" + userid + "";
		ulist = this.getHibernateTemplate().find(sql);
		if (ulist == null || ulist.size() == 0)
			return null;
		else {
			return (SysUsers) ulist.get(0);
		}
	}
}
