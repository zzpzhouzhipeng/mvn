<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
		<title>paramobjvc</title>  
	</head>
	<body>
		<p>直接return 复合对象user</p>
		<form name="form" action="paramobjvc02" method="post">
     		<input type="text" name="username"/>
     		<input type="text" name="password"/>
     		<input type="submit" value="submit" />
        </form>
        <br />
        <p>ModelAndView 返回对象user</p>
        <form name="form" action="paramobjvc03" method="post">
     		<input type="text" name="username"/>
     		<input type="text" name="password"/>
     		<input type="submit" value="submit" />
        </form>
        
        <br />
        <p>Model 返回对象user</p>
        <form name="form" action="paramobjvc04" method="post">
     		<input type="text" name="username"/>
     		<input type="text" name="password"/>
     		<input type="submit" value="submit" />
        </form>
	</body>  
</html>