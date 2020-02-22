<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.semi.eventBanner.model.vo.*"%>

<%
	ArrayList<EventBanner> list = (ArrayList<EventBanner>)request.getAttribute("list");
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

  
  <style>
    .tbl td{
      height: 200px;
    }
  </style>
</head>
<body style="height:1080px">

<%@ include file="common/admin_header.jsp" %>

<div class="container" style="margin-top:50px">
  <div class="title">
    <h1><b>이벤트배너 관리</b></h1>
  </div>

  <div class="pagesearch">
    <!-- <div class="search">
      <input class="form-control input-lg" id="inputlg" type="text">
      <button style="border-radius: 6px;" ><span class="glyphicon glyphicon-search" style="color: white; font-size: 18px;"></span></button>
    </div> -->
    
    <!-- <div class="page">
      <ul class="pagination">
        <li class="active"><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li><a href="#">6</a></li>
        <li><a href="#">7</a></li>
        <li><a href="#">8</a></li>
        <li><a href="#">9</a></li>
        <li><a href="#">></a></li>
        <li><a href="#">>></a></li>
      </ul>
    </div>
    class page -->
    
  </div>

  <div class="tbl">
    <table class="table table-hover" id="tbl">
      <tr>
        <th class="eventInfo" colspan="2">이벤트명</th>
        <th class="eventInfo" colspan="2">이벤트이미지</th>
        <th class="text-right">
          <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#addevent" id="registerBtn" style="width: 55px;">등록</button>
          <div id="addevent" class="modal fade" role="dialog">
            <div class="modal-dialog">
              <!-- Modal content-->
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title">이벤트 등록</h4>
                </div>
                
                
                <!-- 이벤트 insert -->
	            <form action="/siktam/eInsert.ev" method="post">    
	                <div class="modal-body">                
	                  <label>이벤트명</label><br>
	                  <input type="text" name="eventName" id="modalEventName"><br><br>
	                  <label>이벤트 대표이미지</label>
	                  <input type="text" name="eventImg" id="modalEventImg">
	                </div>
	                <div class="modal-footer">
	                	<input type="submit" class="btn btn-danger" data-dismiss="modal" value="등록">
	                	<input type="reset" class="btn btn-danger" data-dismiss="modal" value="취소">
	                </div>
                </form>
                
              </div>

            </div>
          </div>
        </th>
      </tr>
      
      <% for(EventBanner eb : list) { %>
      <tr>
      	<td style="display:none;"><%=eb.getEventNo() %></td>
        <td colspan="2"><%=eb.getEventName() %></td>
        
        <td colspan="2">
          <img src="<%=eb.getEventImg() %>" alt="" style="width: 300px; height: 300px;">
        </td>
        <td class="text-right">
          <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delmember">삭제</button>

          <!-- Modal -->
          <div id="delmember" class="modal fade" role="dialog">
            <div class="modal-dialog">
              <!-- Modal content-->
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title">배너 삭제</h4>
                </div>
                <div class="modal-body">
                  <p>해당배너를 삭제하시겠습니까?</p>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-danger" data-dismiss="modal">확인</button>
                  <button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
                </div>
              </div>

            </div>
          </div>
        </td>
      </tr>
      <% } %>
      
    </table>
  </div>
  <!-- class tbl -->

</div>
<!-- class container -->
<script>

$(function(){
	
	$("#tbl td").mouseenter(function(){
		$(this).parent().css({"background":"lightgray", "cursor":"pointer"});
	}).mouseout(function(){
		$(this).parent().css({"background":"white"});
	}).click(function(){
		//console.log($(this).parent().children().eq(0).text());
		var eno = $(this).parent().children().eq(0).text();
		location.href="<%=request.getContextPath()%>/esList.es?eno=" + eno;
	});
});


</script>


</body>
</html>
