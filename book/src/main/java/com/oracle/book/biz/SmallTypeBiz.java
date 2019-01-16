package com.oracle.book.biz;

import java.util.List;

import com.oracle.book.entity.SmallType;

public interface SmallTypeBiz {

	boolean save(SmallType smallType);

	List<SmallType> find(int bid);

	int findBySid(int sid);

}
