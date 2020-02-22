<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.semi.qna.model.vo.*"%>
    
<% ArrayList<Qna> list = (ArrayList<Qna>)request.getAttribute("list");
	QPageInfo pi = (QPageInfo)request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>문의사항</title>
    <link rel="stylesheet" href="/siktam/resources/css/headerfooterLayout.css">
    <link rel="stylesheet" href="/siktam/resources/css/qna_5.css">
    <script src="/siktam/resources/js/jquery-3.4.1.min.js"></script>
    
</head>
<body>
    <!-- 헤더 시작 -->
    <%@ include file="common/header.jsp" %>

    <!-- 이 안에 작업하기 -->
    <div class="wrap" align="center">
            <div class="noticeTitle">
                <h1>문의사항</h1>
            </div>
            <div class="tableDiv">
                    <table id="listArea">
                        <thead>
                            <tr>
                              <th>번호</th>
                              <th style="width:70%">제목</th>
                              <th>작성자</th>
                              <th>작성일</th>
                            </tr>
                        </thead>
                        <tbody>
                        <% for(Qna q : list){ %>
                            <tr>
                              <td><%= q.getqNo() %></td>
                              <td><%= q.getqTitle() %></td>
                              <td><%= q.getUserId() %></td>
                              <td><%= q.getqDate() %></td>
                            </tr>
                         <% } %>
                            
                        </tbody>
                    </table>
            </div>
            <div class="pagingArea" align="center">
			<button onclick="location.href='<%= request.getContextPath() %>/QnaListServlet?currentPage=1'"><<</button>
			<%  if(currentPage <= 1){  %>
			<button disabled><</button>
			<%  }else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/QnaListServlet?currentPage=<%=currentPage - 1 %>'"><</button>
			<%  } %>
			
			<% for(int p = startPage; p <= endPage; p++){
					if(p == currentPage){	
			%>
				<button disabled><%= p %></button>
			<%      }else{ %>
				<button onclick="location.href='<%= request.getContextPath() %>/QnaListServlet?currentPage=<%= p %>'"><%= p %></button>
			<%      } %>
			<% } %>
				
			<%  if(currentPage >= maxPage){  %>
			<button disabled>></button>
			<%  }else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/QnaListServlet?currentPage=<%=currentPage + 1 %>'">></button>
			<%  } %>
			<button onclick="location.href='<%= request.getContextPath() %>/QnaListServlet?currentPage=<%= maxPage %>'">>></button>
		
            
        </div>    
            
            
            <fieldset>
                <select id="searchCondition">
                	<option>---</option>
                	<option value="writer">작성자</option>
                	<option value="title">제목</option>
                	<option value="context">내용</option>
                </select>
                <input type="text" id="keyword">
                <input type="button" id="searchBtn" value="검색">
                <input type="button" id="insertBtn" value="글쓰기" onclick="location.href='views/qna_form_5.jsp'">
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
				var qno = $(this).parent().children().eq(0).text();
				location.href="<%=request.getContextPath()%>/qSelectOne.qn?qno=" + qno;
			});
		});
		
		$('#searchBtn').click(function(){
			location.href="<%=request.getContextPath()%>/searchQno.qo?qon="+$('#searchCondition').val()+"&keyword="+$('#keyword').val();
		});
	</script>




   


    

    <!-- 푸터 시작 -->
    <%@ include file="common/footer.jsp" %>
</body>
</html>
