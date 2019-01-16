package com.oracle.book.dao;

import java.util.List;

import com.oracle.book.entity.SmallType;

public interface SmallTypeDao {

	boolean save(SmallType smallType);

	List<SmallType> find(int bid);

	int findBySid(int sid);

}
