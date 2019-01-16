package com.oracle.book.biz;

import java.util.List;

import com.oracle.book.entity.BigType;

public interface BigTypeAdd {

	boolean save(String name);

	List<BigType> findAll();

}
