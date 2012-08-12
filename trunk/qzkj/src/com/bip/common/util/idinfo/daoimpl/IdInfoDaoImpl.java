package com.bip.common.util.idinfo.daoimpl;

import org.springframework.stereotype.Repository;

import com.bip.common.dao.GenericDao;
import com.bip.common.util.idinfo.dao.IdInfoDao;
import com.bip.common.util.idinfo.po.*;
@Repository
public class IdInfoDaoImpl extends GenericDao<SysIdinfo, SysIdinfoId> implements
IdInfoDao {

}
