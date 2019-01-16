
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 1.不让缩放 -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- 2.css样式 -->
<link href="bower_components/bootswatch/dist/lumen/bootstrap.css" rel="stylesheet" type="text/css"/>
<!-- 3.日期样式-->
<link href="bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker3.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
.custom-file-label::after{content:"浏览"}
</style>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
			<div class="card">
  <div class="card-body">
      
				<form action="login" method="post" id="formId">
				
					  <div class="form-group row">
						<label for="inputName" class="col-sm-2 col-form-label text-right">用户名</label>
						<div class="col-sm-10">
							
							<c:choose>
							  <c:when test="${not empty  requestScope.error.name }">
							  <input type="text" class="form-control is-invalid" id="inputName" placeholder="用户名" name="name" value="${requestScope.admin.name}">
								<div class="invalid-feedback">
								
								${requestScope.error.name }
								</div>
							  </c:when>
							  <c:otherwise>
							  <input type="text" class="form-control" id="inputName" placeholder="用户名" name="name" value="${requestScope.admin.name}">
							  
							  </c:otherwise>
							
							</c:choose>
								
								
						
						</div>
					</div>
					<div class="form-group row">
						<label for="inputPwd" class="col-sm-2 col-form-label text-right">密码</label>
						<div class="col-sm-10">
				
						  <div class="invalid-feedback">
						  </div>
						  <c:choose>
						    <c:when test="${not empty requestScope.error.pwd }">
			 <input type="password" class="form-control is-invalid" id="inputPwd" placeholder="密码" name="pwd" >
						    <div class="invalid-feedback">
								
								${requestScope.error.pwd }
								</div>
						    </c:when>
						    <c:otherwise>
						    <input type="password" class="form-control" id="inputPwd"
								placeholder="密码" name="pwd">
						    </c:otherwise>
						  </c:choose>
							
						
						</div>
					</div>
					 	<div class="form-group row">
						<label for="inputVcode" class="col-sm-2 col-form-label text-right">验证码</label>
						<div class="col-sm-5">
						<c:choose>
						 <c:when test="${ not empty requestScope.error.vcode }">
						 	 <input class="form-control is-invalid" id="inputVcode" 
							
							placeholder="验证码" name="vcode">
							<div class="invalid-feedback">
							${requestScope.error.vcode }
							</div>
						 
						 </c:when>
						  <c:otherwise>
						  <input class="form-control" id="inputVcode" 
							
							placeholder="验证码" name="vcode">
						  </c:otherwise>
						</c:choose>
						
			
						
						</div>
						 <div class="col-sm-5">
							<img src="vcode.png" id="imgVcode">
						</div>
					
					</div>

					<div class="form-group row">
					   <div class="col-sm-2"></div>
						<div class="col-sm-10">
							<button type="submit" class="btn btn-primary">提交</button>
						</div>
					</div>
			
				
				</form>
				 
					
				</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 样式脚本 -->
<script type="text/javascript"src="bower_components/jquery/dist/jquery.js"></script>
<!-- 样式脚本 -->
<script type="text/javascript"src="bower_components/bootstrap/dist/js/bootstrap.js"></script>
<script type="text/javascript">
   $(function(){
        $("#imgVcode").click(function(){

                 $(this).attr("src","vcode.png?t="+Math.random());
         

            });

	   });


</script>
<script type="text/javascript" src="bower_components/jquery-validation/dist/jquery.validate.js"></script>
<script type="text/javascript" src="bower_components/jquery-validation/src/localization/messages_zh.js"></script>
<script type="text/javascript">
$(function(){
   $("#formId").validate({  //

	      rules:{ //规则
               
          name:{
        	  required:true,
              maxlength:252,
              minlength:3
               },
          pwd:{
        	  required:true,
              maxlength:252,
              minlength:3   
            },
            vcode:{
            	 required:true,
            	 maxlength:4,
                 minlength:4 
                } 
                
		      },
            
			     
           messages:{  //错误信息
        	   price:{
                   required:"必须填写",
                   number:"必须为数字"

                       },
                       photo:{
                    	
                    	   accept:"只能是图片"   
                    }
                   
               },
               errorElement:"div",
               errorClass:"valid-feedback",
               validClass:"is-valid",
               highlight: function(element, errorClass, validClass) {
            	    $(element).addClass("is-invalid").removeClass(validClass);
            	   // $(element.form).find("label[for=" + element.id + "]")
            	      //.addClass(errorClass);
            	  },
            	  unhighlight: function(element, errorClass, validClass) {
            	    $(element).removeClass("is-invalid").addClass(validClass);
            	   // $(element.form).find("label[for=" + element.id + "]")
            	     // .removeClass(errorClass);
            	  }
            	               
     

               

	   });

	
});


</script>


</body>
</html>