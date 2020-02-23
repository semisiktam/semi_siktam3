<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.semi.shop.model.vo.*"%>

<%
	ArrayList<Shop> list = (ArrayList<Shop>) request.getAttribute("list");
	String eno = (String)request.getParameter("eno");
	String ename = (String)request.getParameter("ename");
 %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>eventView_6</title>
    <link rel="stylesheet" href="/siktam/resources/css/headerfooterLayout.css" type="text/css"/>
    <link rel="stylesheet" href="/siktam/resources/css/eventView_6.css" type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Black+Han+Sans&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Fredoka+One&display=swap" rel="stylesheet">
</head>
<body>
    <!-- 헤더 시작 -->
    <%@ include file="common/header.jsp" %>

    <!-- 이 안에 작업하기 -->
    <div id="mainBanner">
        <div id="mainImg">

        </div>
        <div id="mainText">
            <h1><%=ename%></h1><br>
            <h2>TOP 5</h2>
        </div>
    
        <div id="viewBody">
            <% for(Shop s : list) { %>
	            <div class="bannerMenu">
	                <div class="menuImg">
	                    <img src="/siktam/resources/images/<%= s.getShopImg() %>" alt="">
	                </div>
	                <div class="menuText">
	                    <!-- <h3 class="rank">TOP 1</h3> -->
	                    <h3 class="storeName"><%=s.getShopName() %></h3>
	                    <p><%=s.getsAddr() %></p>
	                    <input type="button" value="업체정보" class="pdPage"onclick="location.href = '/siktam/sSelect.so?shopPid=<%=s.getShopPid()%>'">
	                    <input type="button" value="예약하기" onclick="location.href = '/siktam/reservation.rc?ShopId=<%=s.getShopPid()%>'">
	                </div>
	            </div>
            <% } %>

        </div>


    </div>
    
    <script>
    
    </script>


    <!-- 푸터 시작 -->
    <%@ include file="common/footer.jsp" %>
</body>
</html>
