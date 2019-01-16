package com.oracle.book.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.oracle.book.biz.BigTypeAdd;
import com.oracle.book.biz.impl.BigTypeAddImpl;
import com.oracle.book.entity.BigType;

/**
 * Servlet implementation class FindBigTypeAllServlet
 */
@WebServlet("/findBigTypeAll")
public class FindBigTypeAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindBigTypeAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String callback=request.getParameter("callback");
		 BigTypeAdd bigTypeAdd=new BigTypeAddImpl();
		List<BigType> ls=bigTypeAdd.findAll();
		JSONArray jsonArray=new JSONArray(ls);	
		 PrintWriter out=    response.getWriter();
		 out.println(callback+"("+jsonArray.toString()+")");
		 out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
