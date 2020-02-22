<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
            <h1>2020 전국 쌀국수 맛집</h1> <br>
            <h2>TOP 5</h2>
        </div>
    
        <div id="viewBody">
            
            <div class="bannerMenu">
                <div class="menuImg">
                    <img src="/siktam/resources/images/tamhate1.jpg" alt="">
                </div>
                <div class="menuText">
                    <h3 class="rank">TOP 1</h3>
                    <h3 class="storeName">에머이</h3>
                    <p>서울 강남구 테헤란로2길 27</p>
                    <input type="button" value="업체정보" onclick="location.href = 'productDetailPage_6.jsp'">
                    <input type="button" value="예약하기" onclick="location.href = 'reservation_4.jsp'">
                </div>
            </div>
            <div class="bannerMenu">
                <div class="menuImg">
                    <img src="/siktam/resources/images/ssal1.jpg" alt="">
                </div>
                <div class="menuText">
                    <h3 class="rank">TOP 2</h3>
                    <h3 class="storeName">리틀파파포</h3>
                    <p>서울 마포구 독막로3길 7</p>
                    <input type="button" value="업체정보" onclick="location.href = 'productDetailPage_6.jsp'">
                    <input type="button" value="예약하기" onclick="location.href = 'reservation_4.jsp'">
                </div>
            </div>
            <div class="bannerMenu">
                <div class="menuImg">
                    <img src="/siktam/resources/images/ssal2.png" alt="">
                </div>
                <div class="menuText">
                    <h3 class="rank">TOP 3</h3>
                    <h3 class="storeName">미스사이공</h3>
                    <p>서울 강남구 도산대로30길 29</p>
                    <input type="button" value="업체정보" onclick="location.href = 'productDetailPage_6.jsp'">
                    <input type="button" value="예약하기" onclick="location.href = 'reservation_4.jsp'">
                </div>
            </div>
            <div class="bannerMenu">
                <div class="menuImg">
                    <img src="/siktam/resources/images/ssal3.jpg" alt="">
                </div>
                <div class="menuText">
                    <h3 class="rank">TOP 4</h3>
                    <h3 class="storeName">안녕베트남</h3>
                    <p>서울 관악구 관악로14길 70</p>
                    <input type="button" value="업체정보" onclick="location.href = 'productDetailPage_6.jsp'">
                    <input type="button" value="예약하기" onclick="location.href = 'reservation_4.jsp'">
                </div>
            </div>
            <div class="bannerMenu">
                <div class="menuImg">
                    <img src="/siktam/resources/images/ssal4.jpg" alt="">
                </div>
                <div class="menuText">
                    <h3 class="rank">TOP 5</h3>
                    <h3 class="storeName">분짜라붐</h3>
                    <p>서울 용산구 이태원로 247</p>
                    <input type="button" value="업체정보" onclick="location.href = 'productDetailPage_6.jsp'">
                    <input type="button" value="예약하기" onclick="location.href = 'reservation_4.jsp'">
                </div>
            </div>

        </div>


    </div>


    <!-- 푸터 시작 -->
    <%@ include file="common/footer.jsp" %>
</body>
</html>
