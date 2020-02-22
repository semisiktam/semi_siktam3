<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/siktam/resources/js/jquery-3.4.1.min.js"></script>
 <link rel="stylesheet" href="/siktam/resources/css/ShopPidCheck.css">
<title>사업자 번호 조회</title>
</head>
<body>
<div>

사업자번호 : <input type="text" class="form-control" name="Shoppid" id="pid">
사업장명 :<input type="text" class="form-control" name="Shopname" id="name">
                    <button id="shopNum">확인</button>

</div>
<script>
	$("#shopNum").click(function(){
		$.ajax({
			url:"/siktam/spc.me",
			type:"post",
			data:{
				Shoppid:$("#pid").val(),
				Shopname:$("#name").val()
			},
			datatype:"json",
			success:function(data){
				console.log(data);
				list = data;
				console.log(list["response"]["body"]["items"]["item"][0]["wkplNm"]);
				console.log(typeof(list["data"]));
				
			},error:function(){
				alert("에러");
			}
			
			
		});
	});
	

</script>
</body>
</html>