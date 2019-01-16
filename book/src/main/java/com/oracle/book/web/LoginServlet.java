package com.oracle.book.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.oracle.book.biz.AdminBiz;
import com.oracle.book.biz.impl.AdminBizImpl;
import com.oracle.book.entity.Admin;
import com.oracle.book.util.MyBeanUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin=new Admin();
		MyBeanUtils.populate(admin, request.getParameterMap());
		String vcode=request.getParameter("vcode");
		String servletValidateCode=(String) request.getSession().getAttribute("validateCode");
		Map<String, String> errors=new HashMap<>();
		if(!servletValidateCode.equalsIgnoreCase(vcode)) {
			request.setAttribute("msg", "验证码错误");
			errors.put("vcode", "验证码错误");
		}
		
	
		//验证规则
	 ValidatorFactory validatorFactory=Validation.buildDefaultValidatorFactory();
	 Validator validator=validatorFactory.getValidator();
		    Set<ConstraintViolation<Admin>>      validatResult=            validator.validate(admin);
		    if(validatResult.size()>0) {
		    	for(ConstraintViolation<Admin> cv:validatResult) {
		    		errors.put(cv.getPropertyPath().toString(), cv.getMessage());
		    	}
		    }
		
		if(errors.size()>0) {
			request.setAttribute("admin", admin);
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		
		
		AdminBiz adminBiz=new AdminBizImpl();
		
		boolean ret =adminBiz.findByNameAndPwd(admin);
		if(ret) {
			request.getSession().setAttribute("chenggong", true);
			response.sendRedirect("main.jsp");
		}else {
			request.setAttribute("admin", admin);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
