<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.kh.semi.shop.model.vo.*"%>

<%
	
	ArrayList<Shop> list = (ArrayList<Shop>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>admin mode</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/siktam/resources/css/admin_4.css">
<link rel="stylesheet" href="/siktam/resources/css/admin_eventSelect.css">


<style>
.tbl td {
	height: 200px;
}
</style>
</head>
<body style="height: 1080px">

	<%@ include file="common/admin_header.jsp"%>

	<div class="container" style="margin-top: 50px">
		<div class="title">
			<h1>
				<b>이벤트배너별 매장 관리</b>
			</h1>
		</div>

		<div class="pagesearch"></div>

		<div class="tbl">
			<table class="table table-hover" id="tbl">
				<tr>
					<th class="eventInfo" colspan="2">이벤트명</th>
					<th class="eventInfo" colspan="2">이벤트이미지</th>
					<th class="text-right">
						<button type="button" class="btn btn-danger" data-toggle="modal"
							data-target="#addevent" id="registerBtn" style="width: 55px;">등록</button>
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
											<label>이벤트명</label><br> <input type="text"
												name="eventName" id="modalEventName"><br>
											<br> <label>이벤트 대표이미지</label> <input type="text"
												name="eventImg" id="modalEventImg">
										</div>
										<div class="modal-footer">
											<input type="submit" class="btn btn-danger"
												data-dismiss="modal" value="등록"> <input type="reset"
												class="btn btn-danger" data-dismiss="modal" value="취소">
										</div>
									</form>

								</div>

							</div>
						</div>
					</th>
				</tr>

				<% for(Shop s : list){ %>
				<div>
					<table id="eventShopList" border="1px" id="tbl">
						<tr>
							<td style="display: none">E2</td>
							<td id="eventShopListImg"><img
								src="/siktam/resources/images/tamlove1.png" style="width: 100%"
								alt="Image" class="img-thumbnail"></td>
							<td id="eventShopListTxt" style="word-break: break-all">
								<h4>
									<b><%=s.getShopName() %></b>
								</h4>
								<ul>
									<li><span class="area"><%=s.getsAddr() %></span><br>
									<span class="tableInfo"><%=s.getTableType() %></span><br>
									<span class="sectors"><%=s.getMenuCategory() %></span></li>
									
								</ul> <input id="eventShopButton" type="button" value="삭제">
							</td>
						</tr>
					</table>
				</div>
				<%} %>

			</table>
		</div>
		<!-- class tbl -->

	</div>
	<!-- class container -->
	<%-- <script>

$(function(){
	
	$("#tbl td").mouseenter(function(){
		$(this).parent().css({"background":"lightgray", "cursor":"pointer"});
	}).mouseout(function(){
		$(this).parent().css({"background":"white"});
	}).click(function(){
		//console.log($(this).parent().children().eq(0).text());
		var eno = $(this).parent().children().eq(0).text();
		location.href="<%=request.getContextPath()%>/eSelctOne.ev?eno=" + eno;
	});
});


</script> --%>


</body>
</html>