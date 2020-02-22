<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.semi.black.model.vo.*, java.util.*"%>

<% 
	ArrayList<BlackList> list = (ArrayList<BlackList>)request.getAttribute("list"); 
	BlackPageInfo bpi = (BlackPageInfo)request.getAttribute("bpi");
	int listCount = bpi.getListCount();
	int currentPage = bpi.getCurrentPage();
	int maxPage = bpi.getMaxPage();
	int startPage = bpi.getStartPage();
	int endPage = bpi.getEndPage();	
%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <title>블랙리스트</title>
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
                <h1>블랙리스트</h1>
            </div>
            <div class="tableDiv">
                    <table id="listArea">
                        <thead>
                            <tr>
                              <th>아이디</th>
                              <th>차단일자</th>
                              <th>차단기간(일)</th>
                              <th>차단사유</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for(BlackList bl : list){ %>
							<tr>
								<td><%= bl.getUserId() %></td>
								<td><%= bl.getBanDate() %></td>
								<td><%= bl.getBanTerm() %></td>
								<td><%= bl.getBanReason() %></td>
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
			      	<li><a onclick="location.href='<%= request.getContextPath() %>/bList.bl?currentPage=1'"><<</a></li>
			        <li>
			        	<%  if(currentPage <= 1){  %>
			        	<a><</a>
						<%  }else{ %>
						<a onclick="location.href='<%= request.getContextPath() %>/bList.bl?currentPage=<%=currentPage - 1 %>'"><</a>
						<%  } %>
			        </li>
			        
			        <% for(int p = startPage; p <= endPage; p++){
							if(p == currentPage){
					%>
						<li><a style="background: rgb(110, 0, 0); color: white"><%= p %></a><li>
					<%      }else{ %>
						<li><a onclick="location.href='<%= request.getContextPath() %>/bList.bl?currentPage=<%= p %>'"><%= p %></a><li>
					<%      } %>
					<% } %>
					
			        <li>
			        	<%  if(currentPage >= maxPage){  %>
						<a>></a>
						<%  }else{ %>
						<a onclick="location.href='<%= request.getContextPath() %>/bList.bl?currentPage=<%=currentPage + 1 %>'">></a>
						<%  } %>
			        </li>
			        <li><a onclick="location.href='<%= request.getContextPath() %>/bList.bl?currentPage=<%= maxPage %>'">>></a></li>
			      </ul>
			    </div>
				
			</div>
            
            <fieldset>
                <!--<label for="name"><input type="radio" name="search" value="writer">작성자</label>
                <label for="title"><input type="radio" name="search" value="title">제목</label>
                <label for="text"><input type="radio" name="search" value="text">내용</label>  -->
                <select id="searchCondition">
                	<option>---</option>
                	<option value="writer">아이디</option>
                	<option value="title">이름</option>
                	<option value="context">전화번호</option>
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
				//console.log($(this).parent().children().eq(0).text());
				var userId = $(this).parent().children().eq(0).text();
				location.href="<%=request.getContextPath()%>/bSelect.bl?userId=" + userId;
			});
		});
		
		$('#searchBtn').click(function(){
			location.href="<%=request.getContextPath()%>/searchMember.me?con="+$('#searchCondition').val()+"&keyword="+$('#keyword').val();
		});
	</script>
</body>


</html>