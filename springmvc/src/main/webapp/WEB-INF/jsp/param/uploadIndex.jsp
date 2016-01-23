<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
		<title>FileUpload</title>  
	</head>
	<body>
		<h3>文件上传测试</h3>
		<form id="itemForm" action="${pageContext.request.contextPath }/param/upload" method="post" enctype="multipart/form-data">
		<c:if test="${itempic != null}">
			<img src="/pic/${itempic}" width=100 height=100/>
			<br/>
		</c:if>
			<input type="file"  name="pic"/> 
			<input type="submit" value="提交"/>
		</form>
	</body>  
</html>