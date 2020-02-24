<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.semi.member.model.vo.*" %>
<%
	Member m = (Member)request.getAttribute("member");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세정보</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/siktam/resources/css/admin_4.css">

<style>
	td{
		width: 100px;
	}
	tr{
		height: 40px;
		border-radius: 5px;
	}

	.inputInfo{
		width: 300px;
	}
	
	#container1{
		text-align: center;
		margin-top: 40px;
		margin-bottom: 40px;
	}
	
	#container2{
		min-width:100%; 
		min-height:100%; 
		_height:100%; 
		text-align:center; 
		vertical-align:middle;
	}
	
	#container3{
		text-align: center;
	}
</style>

</head>
<body>
	<%@ include file="common/admin_header.jsp" %>
	
	<form action="<%=request.getContextPath()%>/mAdminUpdate.me" method="post" onsubmit="return validate();">
	<div id="container1">
		<h1>회원 정보</h1>
		<br>
		<input type="submit" class="btn" value="수정완료">
        <input type="reset" class="btn" value="취소" onclick="location.href='selectList.me'">
	</div>
	
	<input type="hidden" class="inputInfo" name="userId" value="<%= m.getUserId() %>">
	<input type="hidden" class="inputInfo" name="password" value="<%= m.getPassword() %>">
	<input type="hidden" class="inputInfo" name="enrolldate" value="<%= m.getEnrolldate() %>">
	<div id="container2">
		<table style='width: 500px; border-style: solid; border-width: 1px; left: 50%; position: absolute; height: 200px; text-align: center; margin: 0px 0pt 0pt -250px; border-color:gray' cellspacing="0" cellpadding="0">
			<tr>
				<td>아이디</td>
				<td style="text-align: left"><%= m.getUserId() %></td>
			</tr>
			<tr>
				<td>주소</td>
				<td style="text-align: left"> <input type="text" class="inputInfo" name="addr" value="<%= m.getAddr() %>"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td style="text-align: left"> <input type="text" class="inputInfo" name="name" value="<%= m.getName() %>"></td>
			</tr>
			<tr>
				<td>주민번호</td>
				<td style="text-align: left"> <input type="text" class="inputInfo" name="pid" value="<%= m.getPid() %>"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td style="text-align: left"> <input type="text" class="inputInfo" name="phone" value="<%= m.getPhone() %>"></td>
			</tr>
			<tr>
				<td>업체</td>
				<td style="text-align: left"> <input type="text" class="inputInfo" name="shopyn" value="<%= m.getShopYN() %>"></td>
			</tr>
			<tr>
				<td>마일리지</td>
				<td style="text-align: left"> <input type="text" class="inputInfo" name="mileage" value="<%= m.getMileage() %>"></td>
			</tr>
			<tr>
				<td>쿠폰</td>
				<td style="text-align: left"> <input type="text" class="inputInfo" name="couponno" value="<%= m.getCouponNo() %>"></td>
			</tr>
			<tr>
				<td>블랙리스트</td>
				<td style="text-align: left"><input type="text" class="inputInfo" name="blackyn" value="<%= m.getBlackYN() %>"></td>
			</tr>
			<tr>
				<td>회원탈퇴</td>
				<td style="text-align: left"> <input type="text" class="inputInfo" name="outyn" value="<%= m.getOutYN() %>"></td>
			</tr>
			<tr>
				<td>가입일</td>
				<td style="text-align: left"><%= m.getEnrolldate() %></td>
			</tr>
		</table>
	</div>
	
	<input type="hidden" name="banTerm">
	<input type="hidden" name="banReason">
	

	</form>
	
	<script>  
		$(function(){
			$("#listArea td").mouseenter(function(){
				$(this).parent().css({"background":"lightgray", "cursor":"pointer"});
			}).mouseout(function(){
				$(this).parent().css({"background":"white"});
			});
		});
		
		$('.inputInfo').click(function(){
			$(this).select();
		});
		
        $(function(){
			$('input:text[name="blackyn"]').click(function(){
				if($(this).val()=='Y'){
					$(this).val('N');
				}else{
					$(this).val('Y');
					var banTerm = prompt("정지기간(일)을 입력하세요");
					var banReason = prompt("정지사유를 입력하세요");
 					$('input:hidden[name=banTerm]').val(banTerm);
					$('input:hidden[name=banReason]').val(banReason); 
				}
			});
        });
	</script>
</body>
</html>