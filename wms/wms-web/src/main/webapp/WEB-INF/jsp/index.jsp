<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
	<head>  
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
		<title>Hello World</title>
		<style type="text/css">
			.anounderline{text-decoration: none}
			a:hover{text-decoration: underline; color: red}
		</style>
	</head>
	<body>
		<hr/>
		<h3>1. 页面跳转方式</h3>
			<a class="anounderline" href="login/helloWorld"> 1.1 返回字符串</a><br />
			<a class="anounderline" href="login/helloWorld02"> 1.2 返回ModeAndView</a><br />
			<a class="anounderline" href="login/front/admin/hello/helloWorld05"> 1.3 返回ModeAndView</a><br />
			<a class="anounderline" href="login/helloWorld04"> 1.4 返回ModeAndView</a>
		<h3>2. 参数传递</h3>
		<a class="anounderline" href="param/singleparam"> 2.1 view &lt;====> controller: 传递【非对象】作为参数</a><br/><br/>
		<a class="anounderline" href="param/paramobjvc"> 2.2 view &lt;====> controller: 传递【对象】作为参数</a><br/><br/>
		<a class="anounderline" href="param/fileUploadIndex"> 2.3 文件上传页面</a>
		
		<h3>3. AJAX参数传递</h3>
		<a class="anounderline" href="ajax/index"> 3.1 AJAX 传递参数</a><br/><br/>
		
		<h3>4. AJAX参数传递</h3>
		<a class="anounderline" href="mybatis/index"> 4.1 springmvc 和 mybatis </a><br/><br/>
	</body>
</html>