<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%
	String msg = (String)request.getAttribute("msg");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align:center; margin: auto; margin-top: 10%; padding: 50px; border: 3px dotted firebrick; width: 40%" >
		<img src="/siktam/resources/images/error_icon.png" style="height: 100px; width: 100px">
		<h1><b>페이지 오류 안내</b></h1><br>
		<h3>뭔가 잘못된게 아닐까요? <br> 당신의 손을 의심해보세요!</h3>
		<h4><%= msg %></h4>
	</div>
</body>
</html>