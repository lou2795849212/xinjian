package com.oracle.book.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.book.biz.SmallTypeBiz;
import com.oracle.book.biz.impl.SmallTypeBizImpl;
import com.oracle.book.entity.SmallType;
import com.oracle.book.util.MyBeanUtils;

/**
 * Servlet implementation class SmallTypeAddServlet
 */
@WebServlet("/smallTypeAdd")
public class SmallTypeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SmallTypeAddServlet() {
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
		SmallType smallType=new SmallType();
		MyBeanUtils.populate(smallType, request.getParameterMap());
		
		SmallTypeBiz smallTypeBiz=new SmallTypeBizImpl();
		
	   boolean ret=smallTypeBiz.save(smallType);
	   
	   if(ret) {
		   response.sendRedirect("main.jsp");
	   }else {
		   request.setAttribute("smallType", smallType);
		   request.getRequestDispatcher("smallTypeAdd.jsp").forward(request, response);
	   }
		
	}

}
