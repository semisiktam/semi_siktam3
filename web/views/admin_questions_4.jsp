<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.semi.qna.model.vo.*, java.util.*"%>

<% 
	ArrayList<Qna> list = (ArrayList<Qna>)request.getAttribute("list"); 
	QPageInfo qpi = (QPageInfo)request.getAttribute("qpi");
	int listCount = qpi.getListCount();
	int currentPage = qpi.getCurrentPage();
	int maxPage = qpi.getMaxPage();
	int startPage = qpi.getStartPage();
	int endPage = qpi.getEndPage();	
%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <title>문의사항</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="/siktam/resources/css/admin_4.css">
  <link rel="stylesheet" href="/siktam/resources/css/notice_5.css">
	
  <style>
.wrap {
	padding-top: 50px;
}

#searchBtn{
	background: rgb(110, 0, 0);
}

table thead tr{
    border-bottom: 2px solid rgb(110, 0, 0);
}

.pagination{
	cursor: pointer;
}

</style>
</head>

<body style="height:1080px">

<%@ include file="common/admin_header.jsp" %>

	<div class="wrap" align="center">
            <div class="noticeTitle">
                <h1>답변을 기다리는 문의사항</h1>
            </div>
            <div class="tableDiv">
                    <table id="listArea">
                        <thead>
                            <tr>
                              <th>글번호</th>
                              <th>아이디</th>
                              <th>제목</th>
                              <th>내용</th>
                              <th>작성일</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for(Qna qna : list){ %>
							<tr>
								<td><%= qna.getqNo() %></td>
								<td><%= qna.getUserId() %></td>		
								<td><%= qna.getqTitle() %></td>				
								<td><%= qna.getqContext() %></td>		
								<td><%= qna.getqDate() %></td>
							</tr>
							<% } %>
                        </tbody>
                    </table>
            </div>
            
            <br>
            
            <%-- 페이지 처리 --%>
			<div class="pagingArea" align="center">
				<div class="page">
			      <ul class="pagination">
			      	<li><a onclick="location.href='<%= request.getContextPath() %>/qAdminList.qna?currentPage=1'"><<</a></li>
			        <li>
			        	<%  if(currentPage <= 1){  %>
			        	<a><</a>
						<%  }else{ %>
						<a onclick="location.href='<%= request.getContextPath() %>/qAdminList.qna?currentPage=<%=currentPage - 1 %>'"><</a>
						<%  } %>
			        </li>
			        
			        <% for(int p = startPage; p <= endPage; p++){
							if(p == currentPage){
					%>
						<li><a style="background: rgb(110, 0, 0); color: white"><%= p %></a><li>
					<%      }else{ %>
						<li><a onclick="location.href='<%= request.getContextPath() %>/qAdminList.qna?currentPage=<%= p %>'"><%= p %></a><li>
					<%      } %>
					<% } %>
					
			        <li>
			        	<%  if(currentPage >= maxPage){  %>
						<a>></a>
						<%  }else{ %>
						<a onclick="location.href='<%= request.getContextPath() %>/qAdminList.qna?currentPage=<%=currentPage + 1 %>'">></a>
						<%  } %>
			        </li>
			        <li><a onclick="location.href='<%= request.getContextPath() %>/qAdminList.qna?currentPage=<%= maxPage %>'">>></a></li>
			      </ul>
			    </div>
				
			</div>
            
            <fieldset>
                <!--<label for="name"><input type="radio" name="search" value="writer">작성자</label>
                <label for="title"><input type="radio" name="search" value="title">제목</label>
                <label for="text"><input type="radio" name="search" value="text">내용</label>  -->
                <select id="searchCondition">
                	<option>---</option>
                	<option value="userId">아이디</option>
                	<option value="name">이름</option>
                	<option value="phone">전화번호</option>
                </select>
                <input type="text" id="keyword">
                <input type="button" id="searchBtn" value="검색">
            </fieldset>
    </div>

	<script>  
		$(function(){
			
			$("#listArea td").mouseenter(function(){
				$(this).parent().css({"background":"lightgray", "cursor":"pointer"});
			}).mouseout(function(){
				$(this).parent().css({"background":"white"});
			}).click(function(){
				var qno = $(this).parent().children().eq(0).text();
				location.href="<%=request.getContextPath()%>/qAdminSelect.qna?qno=" + qno;
			});
		});
		
		$('#searchBtn').click(function(){
			location.href="<%=request.getContextPath()%>/mAdminSearch.me?con="+$('#searchCondition').val()+"&keyword="+$('#keyword').val();
		});
	</script>
</body>


</html>
    