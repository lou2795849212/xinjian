package com.oracle.book.web;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.oracle.book.biz.BookAddBiz;
import com.oracle.book.biz.impl.BookAddBizImpl;
import com.oracle.book.entity.Book;
import com.oracle.book.util.MyBeanUtils;
import com.oracle.book.util.StringEscapeUtils;

/**
 * Servlet implementation class BookAddServlet
 */
@WebServlet("/bookAdd")
@MultipartConfig
public class BookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  Book book=new Book();
	  MyBeanUtils.populate(book, request.getParameterMap(), "yyyy-MM-dd");
	  String newFile=null;
	    Part part=request.getPart("photo");
	   if (part.getHeader("Content-Disposition").contains("; filename=")) {
			// 如果包含的话就是个文本文件开始写
			
		if(part.getSubmittedFileName()!=null&&!part.getSubmittedFileName().equals("")) {
			
			//从这个请求头里面截取最后一个点因为包含它自己所以加一
			 String   ext=part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf(".")+1);
			//因为这个UUID.randomUUID()是随机的所以不会重复
			    newFile=UUID.randomUUID()+"."+ext;
			part.write(request.getServletContext().getRealPath("/upload/"+newFile)); 
		}  
			
		}
	   //把得到的头像文件放进去
	   book.setPhoto(newFile);
	   book.setDescri(StringEscapeUtils.htmlEncode(book.getDescri()));
      BookAddBiz bookAddBiz=new  BookAddBizImpl();	
	  boolean ret=bookAddBiz.save(book);
	  if(ret) {
		  response.sendRedirect("bookList");
	  }else {
		  request.setAttribute("book", book);
		  request.getRequestDispatcher("bookAdd.jsp").forward(request, response);
	  }
	}

}
