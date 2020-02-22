<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="/siktam/resources/css/ShopPidCheck.css">
<title>사업자 번호 조회</title>
</head>
<body>
<div>
<form action="/siktam/spc.me" method="post">
사업자번호 : <input type="text" class="form-control" name="Shoppid">
사업장명 :<input type="text" class="form-control" name="Shopname">
                    <button id="shopNum">확인</button>
</form>
</div>
</body>
</html>