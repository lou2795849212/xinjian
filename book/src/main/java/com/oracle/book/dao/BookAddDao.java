package com.oracle.book.dao;

import java.util.List;

import com.oracle.book.entity.Book;

public interface BookAddDao {

	boolean save(Book book);

	List<Book> findAll(int currentPage, String name, int sid);

	int total(String name, int sid);

	int delById(int id);

	Book findById(int id);

	boolean update(Book book);

}
