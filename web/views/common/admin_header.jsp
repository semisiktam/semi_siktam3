<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
.container-fluid {
  padding: 10px;
  padding-left: 15%;
  padding-right: 15%;
  height: 70px;
}

.navbar-inverse .navbar-nav>.active>a, .navbar-inverse .navbar-nav>.active>a:focus, .navbar-inverse .navbar-nav>.active>a:hover {
    color: #fff;
    background-color: #080808;
    height: 60px;
    margin: 0px;
}

.navbar-inverse .navbar-nav>li>a {
    color: white;
    height: 60px;
}

.navbar-inverse .navbar-nav>.active>a{
	color: white;
}

.nav{
    margin-right: 0;
    /* border: 1px solid black; */
    text-align: right;
    vertical-align: top;
    float: right;
}

</style>
    
<header>
  <nav class="navbar navbar-inverse">
  
    <div class="container-fluid">
      <div class="navbar-header">
        <div id="logodiv"><a href="/siktam/views/main_6.jsp"><img id="logo" src="/siktam/resources/images/KakaoTalk_20200101_193858750.png" alt="" style="width:50px; height:50px"></a></div>
      </div>
      <ul class="nav navbar-nav">
        <li class=""><a href="/siktam/views/admin_main_4.jsp">관리자메인</a></li>
        <li class="dropdown active">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">회원관리 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="/siktam/selectList.me">회원리스트</a></li>
            <li><a href="/siktam/sAdminList.sh">업체리스트</a></li>
            <li><a href="/siktam/bList.bl">블랙리스트</a></li>
            <li><a href="/siktam/views/admin_storeRegister_4.jsp">업체등록관리</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">사이트관리 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="/siktam/nselectList.no">공지사항</a></li>
            <li><a href="/siktam/eSelectList.ev">이벤트배너</a></li>
            <li><a href="/siktam/views/admin_questions_4.jsp">문의사항</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </nav>
</header>