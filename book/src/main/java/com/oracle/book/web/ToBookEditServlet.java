package com.oracle.book.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.book.biz.BookAddBiz;
import com.oracle.book.biz.SmallTypeBiz;
import com.oracle.book.biz.impl.BookAddBizImpl;
import com.oracle.book.biz.impl.SmallTypeBizImpl;
import com.oracle.book.entity.Book;

/**
 * Servlet implementation class ToBookEditServlet
 */
@WebServlet("/toBookEdit")
public class ToBookEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToBookEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String strid=request.getParameter("id");
	int id=Integer.parseInt(strid);
	BookAddBiz bookAddBiz=new  BookAddBizImpl();	
	Book book=bookAddBiz.findById(id);
	SmallTypeBiz smallTypeBiz=new SmallTypeBizImpl();
	int bid=smallTypeBiz.findBySid(book.getSid());
	request.setAttribute("book", book);
	request.setAttribute("bid", bid);
	request.getRequestDispatcher("bookEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
