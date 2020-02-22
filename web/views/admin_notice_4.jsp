<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.semi.notice.model.vo.*"%>


<% 
ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
PageInfo pi = (PageInfo)request.getAttribute("pi");
int listCount = pi.getListCount();
int currentPage = pi.getCurrentPage();
int maxPage = pi.getMaxPage();
int startPage = pi.getStartPage();
int endPage = pi.getEndPage();
%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <title>admin mode</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="/siktam/resources/css/admin_4.css">
  <link rel="stylesheet" href="/siktam/resources/css/notice_5.css">

  
  <style>

  </style>
</head>
<body style="height:1080px">

<%@ include file="common/admin_header.jsp" %>


<div class="wrap" align="center">
            <div class="noticeTitle">
                <h1>공지사항</h1>
            </div>
            <div class="tableDiv">
                    <table id="listArea">
                        <thead>
                            <tr>
                              <th>번호</th>
                              <th style="width:70%">제목</th>
                              <th>작성자</th>
                              <th>작성일</th>
                              <th>조회</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for(Notice n : list){ %>
							<tr>
								<td><%= n.getnNo() %></td>
								<td><%= n.getnTitle() %></td>
								<td><%= n.getnWriter() %></td>
								<td><%= n.getnDate() %></td>
								<td><%= n.getnCount() %></td>
							</tr>
							<% } %>
                        </tbody>
                    </table>
            </div>
            <br>
            <%-- 페이지 처리 --%>


	<div class="wrap" align="center">
		<div class="noticeTitle">
			<h1>공지사항</h1>
		</div>
		<div class="tableDiv">
			<table id="listArea">
				<thead>
					<tr>
						<th>번호</th>
						<th style="width: 70%">제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (Notice n : list) {
					%>
					<tr>
						<td><%=n.getnNo()%></td>
						<td><%=n.getnTitle()%></td>
						<td><%=n.getnWriter()%></td>
						<td><%=n.getnDate()%></td>
						<td><%=n.getnCount()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>

		<%-- 페이지 처리 --%>

		<div class="pagingArea" align="center">
			<button
				onclick="location.href='<%=request.getContextPath()%>/nselectList.no?currentPage=1'"><<</button>
			<%
				if (currentPage <= 1) {
			%>
			<button disabled></button>
			<%
				} else {
			%>
			<button
				onclick="location.href='<%=request.getContextPath()%>/nselectList.no?currentPage=<%=currentPage - 1 %>'"><</button>
			<%  } %>

			<% for(int p = startPage; p <= endPage; p++){
					if(p == currentPage){	
			%>
			<button disabled><%= p %></button>
			<%      }else{ %>
			<button
				onclick="location.href='<%= request.getContextPath() %>/nselectList.no?currentPage=<%= p %>'"><%= p %></button>
			<%      } %>
			<% } %>

			<%  if(currentPage >= maxPage){  %>
			<button disabled>></button>
			<%  }else{ %>
			<button
				onclick="location.href='<%= request.getContextPath() %>/nselectList.no?currentPage=<%=currentPage + 1 %>'">></button>
			<%  } %>
			<button
				onclick="location.href='<%= request.getContextPath() %>/nselectList.no?currentPage=<%= maxPage %>'">>></button>

		</div>

            
            <fieldset>
                <!--<label for="name"><input type="radio" name="search" value="writer">작성자</label>
                <label for="title"><input type="radio" name="search" value="title">제목</label>
                <label for="text"><input type="radio" name="search" value="text">내용</label>  -->
                <select id="searchCondition">
                	<option>---</option>
                	<option value="writer">작성자</option>
                	<option value="title">제목</option>
                	<option value="context">내용</option>
                </select>
                <input type="text" id="keyword">
                <input type="button" id="searchBtn" value="검색">
            </fieldset>
    </div>



		<fieldset>
			<!--<label for="name"><input type="radio" name="search" value="writer">작성자</label>
	        <label for="title"><input type="radio" name="search" value="title">제목</label>
	        <label for="text"><input type="radio" name="search" value="text">내용</label>  -->
			<select id="searchCondition">
				<option>---</option>
				<option value="writer">작성자</option>
				<option value="title">제목</option>
				<option value="context">내용</option>
			</select> <input type="text" id="keyword"> <input type="button"
				id="searchBtn" value="검색">
		</fieldset>
	</div>


	<script>  
		$(function(){
			
			$("#listArea td").mouseenter(function(){
				$(this).parent().css({"background":"lightgray", "cursor":"pointer"});
			}).mouseout(function(){
				$(this).parent().css({"background":"white"});
			}).click(function(){
				//console.log($(this).parent().children().eq(0).text());
				var nno = $(this).parent().children().eq(0).text();

				location.href="<%=request.getContextPath()%>/nselectOne.no?nno=" + nno;
			});
		});
		
		$('#searchBtn').click(function(){
			location.href="<%=request.getContextPath()%>/nsearchNotice.no?con="+$('#searchCondition').val()+"&keyword="+$('#keyword').val();
		});
	</script>


</body>
</html>
    