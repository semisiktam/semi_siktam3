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

<div class="container" style="margin-top:50px">
  <div class="title"><h1><b>새로 온 소식</b></h1></div>
    <div class="card1">
      <div class="cardsum">
        <a href="admin_storeRegister_4.jsp">
          <div class="card2">
            <div class="cardTop">
              <img src="/siktam/resources/images/shop.png" alt="image">
              업체 등록 요청
            </div> 
            <div class="cardBottom"> 
              15건
            </div> 
          </div>
        </a>
        <a href="admin_questions_4.jsp">
          <div class="card2"> 
            <div class="cardTop">
              <img src="/siktam/resources/images/qna.png" alt="image">
              문의 사항
            </div> 
            <div class="cardBottom"> 
              89건
            </div> 
          </div>
        </a>
        <div class="card2"> 
          <div class="cardTop">
            area1
          </div> 
          <div class="cardBottom"> 
            area2
          </div> 
        </div>
        <div class="card2"> 
          <div class="cardTop">
            area1
          </div> 
          <div class="cardBottom"> 
            area2
          </div> 
        </div>
    </div>
  </div>
</div>


</body>
</html>
    