package com.bip.sys.wwwuser.service;

import java.io.Serializable;

import com.bip.common.util.QueryJson;
import com.bip.sys.wwwuser.po.WwwUsers;

public interface WwwUsersService {

	QueryJson findPageByQuery(String conditions, int row, int i);

	WwwUsers get(int id);

	Serializable save(WwwUsers po);

	void update(WwwUsers po);

	void delete(String string, String string2);

}
