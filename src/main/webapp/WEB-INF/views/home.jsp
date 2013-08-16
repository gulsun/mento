<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
	<title> Home </title>
</head>
<body>
<h1>
	Hello world! 
</h1>

<P>  The time on the server is ${serverTime}. </P>
	<form action="access" name="logFrm" method="post">
	<table border="1" width="300" height="60" cellpadding="1">
		<tr>
			<td width="80" colspan="4">Attribute</td>
		</tr>
		<tr cellpadding="1">
			<td width="80">로그인</td>
			<td>
				<input type="text" name="id" value="">
				<input type="password" name="pwd" value="">
			</td>
			</td><td>ACCESS</td>
		</tr>
		
	</table>
	<table>
		<tr>
			<td>
			<input type="submit" name="" value="로그인">
			<input type="button" onclick="location.href='memJoin'" value="회원가입">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>


