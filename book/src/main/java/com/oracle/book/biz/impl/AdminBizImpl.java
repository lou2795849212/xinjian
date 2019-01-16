package com.oracle.book.biz.impl;

import com.oracle.book.biz.AdminBiz;
import com.oracle.book.dao.AdminDao;
import com.oracle.book.dao.impl.AdminDaoJdbc;
import com.oracle.book.entity.Admin;

public class AdminBizImpl implements AdminBiz {

	@Override
	public boolean findByNameAndPwd(Admin admin) {
		AdminDao adminDao=new AdminDaoJdbc();
		return adminDao.find(admin);
	}

}
