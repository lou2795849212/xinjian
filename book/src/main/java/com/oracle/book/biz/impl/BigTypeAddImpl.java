package com.oracle.book.biz.impl;

import java.util.List;

import com.oracle.book.biz.BigTypeAdd;
import com.oracle.book.dao.BigAddDao;
import com.oracle.book.dao.impl.BigDaoJdbcImpl;
import com.oracle.book.entity.BigType;

public class BigTypeAddImpl implements BigTypeAdd {

	@Override
	public boolean save(String name) {
		BigAddDao bookAddDao=new BigDaoJdbcImpl();
				
		return bookAddDao.save(name);
	}

	@Override
	public List<BigType> findAll() {
		BigAddDao bookAddDao=new BigDaoJdbcImpl();
		return bookAddDao.findAll();
	}


}
