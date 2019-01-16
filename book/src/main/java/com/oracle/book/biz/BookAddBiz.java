package com.oracle.book.biz;

import java.util.List;

import com.oracle.book.entity.Book;

public interface BookAddBiz {

	boolean save(Book book);

	List<Book> findAll(int currentPage, String name, int sid);

	int totalRow(String name, int sid);

	int delById(int id);

	Book findById(int id);

	boolean update(Book book);

}
