package com.bip.sys.user.serviceimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bip.common.util.PaginationSupport;
import com.bip.sys.user.service.UserService;
import com.bip.sys.user.po.SysUsers;
import com.bip.sys.user.dao.UserDao;
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao UserDao) {
		this.userDao = UserDao;
	}

	public UserServiceImpl() {
	}

	public boolean validate(String username, String password) {
		// TODO Auto-generated method stub
		boolean rtn = false;
		rtn = userDao.validate(username, password);
		return rtn;
	}

	public boolean validate(String username) {
		// TODO Auto-generated method stub
		boolean rtn = false;
		rtn = userDao.validate(username);
		return rtn;
	}

	public SysUsers getUserByUserName(String userName) {
		return userDao.getUserByUserName(userName);
	}

	public SysUsers getUserByUserid(String userid) {
		return userDao.getUserByUserid(userid);
	}

	/**
	 * ����û�
	 * 
	 * @param dept
	 * @return
	 */
	public Serializable save(SysUsers t) throws DataAccessException {
		try {

			return userDao.save(t);
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * �����������û�
	 * 
	 * @return
	 */
	public SysUsers get(Integer id) {
		SysUsers sr = new SysUsers();
		sr = userDao.get(id);
		return sr;
	}

	public List find(String queryString) {
		List rlist = new ArrayList();
		rlist = userDao.find("FROM SysUsers " + queryString);
		return rlist;
	}

	/**
	 * ��ҳ����
	 * 
	 * @param PaginationSupport
	 * 
	 * @return
	 */
	public PaginationSupport findPageByQuery(String hql, String countHql,
			int pageSize, int startIndex) {
		PaginationSupport ps = new PaginationSupport(null, 0, 0, 0);
		ps = userDao.findPageByQuery("FROM SysUsers " + hql, "FROM SysUsers "
				+ countHql, pageSize, startIndex);
		return ps;
	}

	/**
	 * �޸��û���Ϣ
	 * 
	 * @param SysUsers
	 * @return
	 * @throws Exception
	 */
	public void update(SysUsers t) throws Exception {
		userDao.update(t);
	}

	public int update(final String sql) throws Exception {
		return userDao.update(sql);
	}

	/**
	 * ɾ���û�
	 * 
	 * @param id
	 * @return
	 */
	public void delete(SysUsers t) {
		userDao.delete(t);
	}

	public Boolean delete(String table, String where) {
		return userDao.delete("sys_users", where);

	}
}
