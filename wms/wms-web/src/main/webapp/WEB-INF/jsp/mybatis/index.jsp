<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>singleparam</title>
		
		<%-- <link href="${basePath }/css/bootstrap/bootstrap.min.css" rel="stylesheet"> --%>
	</head>
	<body>
		<h1>springmvc 和 mybatis</h1>
		<h3>Controller: org.springframework.samples.web.controller.MybatisController</h3>
		<h3>page:WEB-INF/jsp/mybatis/index.jsp</h3>
		
		<ol>
			<li>
				<span>【requestMybatisTest】mybatis整合测试【User】表查询</span><br/><br/>
				<span>username:</span><input type="text" id="id01"/>
				<input type="button" value="DB Test" onclick="requestMybatisTest()"/><br/><br/>
			</li>
			<li>
				<span>【requestMybatisAssociation】mybatis中collection使用测试【Blog,Author】表查询</span><br/><br/>
				<input type="button" value="association Test" onclick="requestMybatisAssociation()"/><br/><br/>
			</li>
		</ol>
		
		<!-- js文件 -->
		<script type="text/javascript" src="<c:url value='/js/jquery-1.11.2.min.js'/>"></script>
		<script type="text/javascript">
		
			function User (username, password, age, currentDate){
				this.username = username;
				this.password = password;
				this.age = age == null ? 0 : age;			// ajax key/value方式传递时，后台bean的int类型的属性不能接受null值，必须有个默认值0
				this.currentDate = null;
				this.toString = function(){
					return this.username;
				}
			}
			
			// requestMybatisTest测试mybatis是否整合成功
			function requestMybatisTest(){
				var username = $("#id01").val();
				var user = new User();
				user.username = username;
				alert("请求参数:" + JSON.stringify(user));
				var currentDate = "2015-09-30";
				$.ajax({
		            type:"POST", 
		            url:"requestMybatisTest", 
		            dataType:"json",      						 	// 返回界面的数据类型
		            data: user,
		            success:function(data){
		            	alert("查询到的User age:" + JSON.stringify(data.age)+",时间:" + data.currentDate);                       
		            }
		         });
			}
			
			// requestMybatisAssociation测试collection方式返回数据集合
			function requestMybatisAssociation(){
				$.ajax({
		            type:"POST", 
		            url:"requestMybatisAssociation", 
		            dataType:"json",      						 	// 返回界面的数据类型
		            //data: user,
		            success:function(data){
		            	alert(JSON.stringify(data));                       
		            } 
		         });
			}
	</script>
	</body>  
</html>