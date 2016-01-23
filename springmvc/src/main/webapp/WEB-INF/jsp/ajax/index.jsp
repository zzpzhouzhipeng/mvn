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
		<h1>Controller: AjaxController; page:WEB-INF/jsp/ajax/index.jsp</h1>
		<%-- <c:forEach items="${hashMap}" var="mymap" >  
			<c:out value="${mymap.key}" />  
			<c:out value="${mymap.value}" />  
		</c:forEach>   --%>
		
		<span>requestJsonToJson： 请求json字符串数组，返回List 的json对象</span><br/>
		<span>username:</span><input type="text" id="id01"/>
		<span>password:</span><input type="text" id="id02"/>
		<span>age:</span><input type="text" id="id03"/>
		<input type="button" value="jsonArrayStr-jsonArrayObj" onclick="requestJsonToJson()"/><br/><br/>
		
		<span>requestJsonObjToJson： 请求json字符串对象，返回T类型的json对象</span><br/>
		<span>username:</span><input type="text" id="id07"/>
		<span>age:</span><input type="text" id="id08"/>
		<input type="button" value="jsonObjStr-jsonObj" onclick="requestJsonObjToJson()"/><br/><br/>
		
		<span>requestKeyvalueToJson： 请求key/value，返回javabean的对应的json对象</span><br/>
		<span>username:</span><input type="text" id="id04"/>
		<span>password:</span><input type="text" id="id05"/>
		<span>age:</span><input type="text" id="id06"/>
		<input type="button" value="key/value-json" onclick="requestKeyvalueToJson()"/> <br/><br/>
		
		
		<span>requestDateConvert： 时间格式转换的方式</span><br/>
		<input type="button" value="时间格式转化" onclick="requestDateConvert()"/>
		
		<!-- js文件 -->
		<script type="text/javascript" src="<c:url value='/js/jquery-1.11.2.min.js'/>"></script>
		<script type="text/javascript">
		
		/* 	$(document).ready(function(){
				var user = new User("chen", "liang", 23);
				var jsonUser = JSON.stringify(user);
				alert(user);
			}); */
		
			// js 面向对象编程
			// var user = new User();
			function User (username, password, age, currentDate){
				this.username = username;
				this.password = password;
				this.age = age;
				this.currentDate = currentDate == null ? "2015-09-30" : currentDate;
				
				this.toString = function(){
					return this.username;
				}
			}
			
			// requestJsonToJson 请求json 返回json
			function requestJsonToJson(){
				var username = $("#id01").val();
				var password = $("#id02").val();
				var age = $("#id03").val();
				
				var users = new Array();
				// 方式一
				/* var user = new User();
				user.username = username;
				user.password = password;
				user.age = age; */
				
				// 方式二
				var user = new User(username, password, age);
				users.push(user);
				
				alert("请求参数:" + JSON.stringify(users));
				
				$.ajax({
		            type:"POST", 
		            url:"requestJsonToJson", 
		            dataType:"json",      						   // springmvc中ajax若以json请求，则dataType："josn"
		            contentType:"application/json;charset=UTF-8",  // contentType:必须指定为此格式         
		            data: JSON.stringify(users), 
		            success:function(data){
		            	alert("返回参数:" + JSON.stringify(data));                       
		            } 
		         });
			}
			
			function requestJsonObjToJson(){
				var username = $("#id07").val();
				var age = $("#id08").val();
				// 注意: 构建对象，请求json字符串返回json对象的请求的方式
					// 1. JS 对象中的属性要和bean中的属性名一样
					// 2. JS 对对象可以不包含bean中的属性，但不能包含bean中没有的属性名
				// 方式一
				/* var user = new User();
				user.username = username;
				user.password = password;
				user.age = age; */
				
				// 方式二
				var user = new User();
				user.username=username;
				//user.age = age;
				//user.password = "liang";
				
				alert("请求参数:" + JSON.stringify(user));
				
				$.ajax({
		            type:"POST", 
		            url:"requestJsonObjToJson", 
		            dataType:"json",      						   // springmvc中ajax若以json请求，则dataType："josn"
		            contentType:"application/json;charset=UTF-8",  // contentType:必须指定为此格式         
		            data: JSON.stringify(user), 
		            success:function(data){
		            	alert("返回参数:" + JSON.stringify(data));                       
		            } 
		         });
			}
			
			// requestKeyvalueToJson 请求json 返回json
			function requestKeyvalueToJson(){
				// 注意: ajax中 key/value 方式请求，返回json
					// 1. js对象中，属性名和bean中属性名一直
					// 2. js对象中的属性可以多也可以少
				
				var username = $("#id04").val();
				var password = $("#id05").val();
				var age = $("#id06").val();
				
				var user = new User();
				user.username = username;
				user.password = password;
				user.age = age;
				user.address = "dd";
				alert("请求参数:" + JSON.stringify(user));
				$.ajax({
		            type:"POST", 
		            url:"requestKeyvalueToJson", 
		            //data: {username: "chenliang"}, 
		            data: user,							// 以对象键值对方式传递数据
		            success:function(data){
		            	alert("返回参数:" + JSON.stringify(data));                       
		            } 
		         });
			}
			
			// requestKeyvalueToJson 请求json 返回json
			function requestDateConvert(){
				var currentDate = "2015-09-30";
				
				alert("请求参数currentDate:" + currentDate);
				
				$.ajax({
		            type:"POST", 
		            url:"requestDateConvert", 
		            data: {currentDate: currentDate, username: "dateStringTest"}, 
		            success:function(data){
		            	alert("返回参数:" + data);                       
		            } 
		         });
			}
	</script>
	</body>  
</html>