package com.oracle.book.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.book.biz.BigTypeAdd;
import com.oracle.book.biz.impl.BigTypeAddImpl;

/**
 * Servlet implementation class BigTypeServlet
 */
@WebServlet("/bigTypeAdd")
public class BigTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BigTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8"); 
		String name=request.getParameter("name");
            BigTypeAdd bigTypeAdd=new BigTypeAddImpl();
            boolean ret=bigTypeAdd.save(name);
            if(ret) {
            	response.sendRedirect("main.jsp");
            }else {
            	request.setAttribute("name", name);
            	request.getRequestDispatcher("bigTypeAdd.jsp").forward(request, response);
            }
            	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
