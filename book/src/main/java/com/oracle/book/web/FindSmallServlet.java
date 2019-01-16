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

import com.oracle.book.biz.SmallTypeBiz;
import com.oracle.book.biz.impl.SmallTypeBizImpl;
import com.oracle.book.entity.SmallType;

/**
 * Servlet implementation class FindBigAllServlet
 */
@WebServlet("/findSmallAll")
public class FindSmallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindSmallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	 	String strBid=request.getParameter("bid");
	 	int bid=Integer.parseInt(strBid);
		String callback=request.getParameter("callback");
		SmallTypeBiz smallTypeBiz=new SmallTypeBizImpl();
		List<SmallType> ls=smallTypeBiz.find(bid);
		
		JSONArray jsonArray=new JSONArray(ls);	
		 PrintWriter out=    response.getWriter();
		 out.println(callback+"("+jsonArray.toString()+")");
			System.out.println(jsonArray.toString());
			System.out.println("-------");
		 out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
