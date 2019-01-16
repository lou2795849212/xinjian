package com.oracle.book.dao;

import java.util.List;

import com.oracle.book.entity.BigType;

public interface BigAddDao {

	boolean save(String name);

	List<BigType> findAll();

}
