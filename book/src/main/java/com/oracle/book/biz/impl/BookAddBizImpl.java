package com.oracle.book.biz.impl;

import java.util.List;

import com.oracle.book.biz.BookAddBiz;
import com.oracle.book.dao.BookAddDao;
import com.oracle.book.dao.impl.BookAddDaoImpl;
import com.oracle.book.entity.Book;

public class BookAddBizImpl implements BookAddBiz {

	@Override
	public boolean save(Book book) {
		BookAddDao bookAddDao=new BookAddDaoImpl();
		return bookAddDao.save(book);
	}

	@Override
	public List<Book> findAll(int currentPage,String name, int sid) {
		BookAddDao bookAddDao=new BookAddDaoImpl();
		return bookAddDao.findAll(currentPage,name,sid);
	}

	@Override
	public int totalRow(String name, int sid) {
		BookAddDao bookAddDao=new BookAddDaoImpl();
		return bookAddDao.total(name,sid);
	}

	@Override
	public int delById(int id) {
		BookAddDao bookAddDao=new BookAddDaoImpl();
		return bookAddDao.delById(id);
	}

	@Override
	public Book findById(int id) {
		BookAddDao bookAddDao=new BookAddDaoImpl();
		return bookAddDao.findById(id);
	}

	@Override
	public boolean update(Book book) {
		BookAddDao bookAddDao=new BookAddDaoImpl();
		return bookAddDao.update(book);
	}

}
