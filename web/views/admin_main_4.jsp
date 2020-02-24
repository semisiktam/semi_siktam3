<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>admin mode</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="/siktam/resources/css/admin_4.css">

  <style type="text/css">
    
   </style>
</head>
<body style="height:1080px">

<%@ include file="common/admin_header.jsp" %>
   
<div style="text-align:center; margin: auto; margin-top: 10%; padding: 50px; border: 3px dotted firebrick; width: 50%" >
	<img src="/siktam/resources/images/admin_icon.png" style="height: 100px; width: 100px">
	<h1><b>관리자 페이지</b></h1><br>
	<h5>관리자 페이지에서는 회원관리(회원리스트/업체리스트/블랙리스트)와</h5>
	<h5>사이트관리(공지사항/문의사항/이벤트배너)가 상단바를 통해 가능합니다</h5><br>
	<p onclick="location.href='/siktam/listMain.ma'" style="background:firebrick; color:white; width: 40%; margin: auto">식탐 메인으로</p>
</div>

</body>
</html>
    