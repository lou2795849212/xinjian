package com.oracle.book.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.book.biz.BookAddBiz;
import com.oracle.book.biz.impl.BookAddBizImpl;
import com.oracle.book.entity.Book;
import com.oracle.book.util.PageYeShu;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/bookList")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strcurrentPage=request.getParameter("currentPage");
		String name=request.getParameter("name");
		String strSid=request.getParameter("sid")==null?"-1":request.getParameter("sid");
		int sid=Integer.parseInt(strSid);
		String strBid=request.getParameter("bid")==null?"-1":request.getParameter("bid");
		int bid=Integer.parseInt(strBid);
		if(strcurrentPage==null) {
			strcurrentPage="1";
		}
		int currentPage=Integer.parseInt(strcurrentPage);
		BookAddBiz bookAddBiz=new  BookAddBizImpl();	
		  List<Book> ls=bookAddBiz.findAll(currentPage,name,sid);
		  int totalRow=bookAddBiz.totalRow(name,sid);
		  int totalPage=totalRow%PageYeShu.PAGE_SIZ==0?totalRow/PageYeShu.PAGE_SIZ:totalRow/PageYeShu.PAGE_SIZ+1;
		  request.setAttribute("ls", ls);
		  request.setAttribute("sid", sid);
		  request.setAttribute("bid", bid);
		  request.setAttribute("name", name);
		  request.setAttribute("currentPage", currentPage);
		  request.setAttribute("totalPage", totalPage);
		request.getRequestDispatcher("bookList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
