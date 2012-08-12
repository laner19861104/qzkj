package com.bip.sys.user.daoimpl;

import org.springframework.stereotype.Repository;

import com.bip.common.dao.GenericDao;
import com.bip.sys.user.dao.UserRoleDao;
import com.bip.sys.user.po.SysUserroles;
import com.bip.sys.user.po.SysUserrolesId;
@Repository
public class UserRoleDaoImpl extends GenericDao<SysUserroles, SysUserrolesId>  implements UserRoleDao {
	
}
