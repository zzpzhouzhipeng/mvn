<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
		<title>singleparam</title>  
	</head>
	<body>
		<h3>传递非对对象作为参数</h3>
		
		<p>表单提交单个参数【post】其中input name=name, Model返回参数</p>
		<form name="form" action="singleparam01" method="post">
     		<input type="text" name="name"/>
     		<input type="submit" value="submit" />
        </form>
		
		<p>表单提交单个参数【post】, ModelAndView返回参数</p>
		<form name="form" action="singleparam02" method="post">
     		<input type="text" name="name"/>
     		<input type="submit" value="submit" />
        </form>
		
	</body>  
</html>