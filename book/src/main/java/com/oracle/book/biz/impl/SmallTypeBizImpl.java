package com.oracle.book.biz.impl;

import java.util.List;

import com.oracle.book.biz.SmallTypeBiz;
import com.oracle.book.dao.SmallTypeDao;
import com.oracle.book.dao.impl.SmallTypeDaoJdbc;
import com.oracle.book.entity.SmallType;

public class SmallTypeBizImpl implements SmallTypeBiz {

	@Override
	public boolean save(SmallType smallType) {
		SmallTypeDao smallTypeDao=new SmallTypeDaoJdbc();
		
		return smallTypeDao.save(smallType);
	}

	@Override
	public List<SmallType> find(int bid) {
		SmallTypeDao smallTypeDao=new SmallTypeDaoJdbc();
		return smallTypeDao.find(bid);
	}

	@Override
	public int findBySid(int sid) {
		SmallTypeDao smallTypeDao=new SmallTypeDaoJdbc();
		return smallTypeDao.findBySid(sid);
	}

}
