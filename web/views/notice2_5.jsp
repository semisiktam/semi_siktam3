<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.semi.notice.model.vo.*"%>
    
<%
	Notice n = (Notice)request.getAttribute("notice");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>공지사항</title>
    <link rel="stylesheet" href="/siktam/resources/css/headerfooterLayout.css">
    <link rel="stylesheet" href="/siktam/resources/css/notice2_5.css">
    <script src="/siktam/resources/js/jquery-3.4.1.min.js"></script>
</head>
<body>
    <!-- 헤더 시작 -->
    <%@ include file="common/header.jsp" %>

    <!-- 이 안에 작업하기 -->
    <div class="wrap" align="center">
            <div class="noticeTitle">
                <h1>공지사항</h1>
            </div>
            <div class="tableDiv">
                   <table>
                       <thead>
                        <tr>
                            <th>
                                <div class="tb-center"><%= n.getnTitle() %></div>
                            </th>
                        </tr>
                       </thead>
                       <tbody>
                           <tr>
                               <td class="line">
                                   <div class="line-sub">
                                       <div>
                                           <span>
                                               <em>작성일 :</em>
                                               <%= n.getnDate() %>
                                           </span>
                                       </div>
                                       <div>
                                           <span>
                                               <em>작성자 : </em>
                                               <%= n.getnWriter() %>
                                           </span>
                                       </div>
                                       <div class="hit">
                                           <span>
                                               <em>조회수 : </em>
                                               <%= n.getnCount() %>
                                           </span>
                                       </div>
                                   </div>
                               </td>
                           </tr>
                           <tr>
                               <td>
                                   <div class="data-cont">
                                       <%= n.getnContext() %>
                                   </div>
                               </td>
                           </tr>
                       </tbody>
                   </table>
                   <div class="list">
                   		<% if(m != null && m.getUserId().equals("4dich")){ %>
                   	   <input type="button" value="수정" onclick="location.href='nUpView.no?nno=<%=n.getnNo()%>'">
                   	   <% } %>
                       <input type="button" value="목록" onclick="location.href='nselectList.no?currentPage=1'">
                   </div>
            </div>
            
    </div>






   


    

    <!-- 푸터 시작 -->
    <%@ include file="common/footer.jsp" %>
</body>
</html>
