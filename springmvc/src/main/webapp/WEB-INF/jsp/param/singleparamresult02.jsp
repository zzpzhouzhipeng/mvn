<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
		<title>singleparam</title>  
	</head>
	<body>
		<p>后台通过ModelAndView对象传递Map类型的参数</p>
		<c:forEach items="${hashMap}" var="mymap" >  
			<c:out value="${mymap.key}" />  
			<c:out value="${mymap.value}" />  
			</c:forEach>  
	</body>  
</html>