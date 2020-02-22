<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.semi.shop.model.vo.*, java.util.*"%>

<% 
	ArrayList<Shop> list = (ArrayList<Shop>)request.getAttribute("list"); 
	ShopPageInfo spi = (ShopPageInfo)request.getAttribute("spi");
	int listCount = spi.getListCount();
	int currentPage = spi.getCurrentPage();
	int maxPage = spi.getMaxPage();
	int startPage = spi.getStartPage();
	int endPage = spi.getEndPage();
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
.wrap {
	padding-top: 50px;
}

#searchBtn{
	background: rgb(110, 0, 0);
}

table thead tr{
    border-bottom: 2px solid rgb(110, 0, 0);
}
</style>
</head>

<body style="height:1080px">

<%@ include file="common/admin_header.jsp" %>

	<div class="wrap" align="center">
            <div class="noticeTitle">
                <h1>업체리스트</h1>
            </div>
            <div class="tableDiv">
                    <table id="listArea">
                        <thead>
                            <tr>
                              <th>매장등록번호</th>
                              <th>사용자아이디</th>
                              <th>매장명</th>
                              <th>매장주소</th>
                              <th>매장전화번호</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for(Shop s : list){ %>
							<tr>
								<td><%= s.getShopPid() %></td>
								<td><%= s.getUserId() %></td>		
								<td><%= s.getShopName() %></td>		
								<td><%= s.getsAddr() %></td>		
								<td><%= s.getsPhone() %></td>			
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
			      	<li><a onclick="location.href='<%= request.getContextPath() %>/sAdminList.sh?currentPage=1'"><<</a></li>
			        <li>
			        	<%  if(currentPage <= 1){  %>
			        	<a><</a>
						<%  }else{ %>
						<a onclick="location.href='<%= request.getContextPath() %>/sAdminList.sh?currentPage=<%=currentPage - 1 %>'"><</a>
						<%  } %>
			        </li>
			        
			        <% for(int p = startPage; p <= endPage; p++){
							if(p == currentPage){
					%>
						<li><a style="background: rgb(110, 0, 0); color: white"><%= p %></a><li>
					<%      }else{ %>
						<li><a onclick="location.href='<%= request.getContextPath() %>/sAdminList.sh?currentPage=<%= p %>'"><%= p %></a><li>
					<%      } %>
					<% } %>
					
			        <li>
			        	<%  if(currentPage >= maxPage){  %>
						<a>></a>
						<%  }else{ %>
						<a onclick="location.href='<%= request.getContextPath() %>/sAdminList.sh?currentPage=<%=currentPage + 1 %>'">></a>
						<%  } %>
			        </li>
			        <li><a onclick="location.href='<%= request.getContextPath() %>/sAdminList.sh?currentPage=<%= maxPage %>'">>></a></li>
			      </ul>
			    </div>
				
			</div>
            
            <fieldset>
                <!--<label for="name"><input type="radio" name="search" value="writer">작성자</label>
                <label for="title"><input type="radio" name="search" value="title">제목</label>
                <label for="text"><input type="radio" name="search" value="text">내용</label>  -->
                <select id="searchCondition">
                	<option>---</option>
                	<option value="writer">매장등록번호</option>
                	<option value="title">사용자아이디</option>
                	<option value="context">매장명</option>
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
				var shopPid = $(this).parent().children().eq(0).text();
				location.href="<%=request.getContextPath()%>/sAdminSelect.sh?shopPid=" + shopPid;
			});
		});
		
		$('#searchBtn').click(function(){
			location.href="<%=request.getContextPath()%>/searchMember.me?con="+$('#searchCondition').val()+"&keyword="+$('#keyword').val();
		});
	</script>
</body>


</html>
    