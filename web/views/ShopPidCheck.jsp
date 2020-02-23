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

		사업자번호 : <input type="text" class="form-control" name="Shoppid"
			id="ShopPid_pop" placeholder="앞자리 6자리만 입력하세요" maxlength="6"> 사업장명 :<input
			type="text" class="form-control" name="Shopname" id="name"
			placeholder="매장명을 입력하세요"><br>
		<center>
		<input type="submit" id="shopNum" value="입력"> &nbsp;
		<input type="button" onclick="window.close()" value="창닫기"> </center>

	</div>
<!--  	<form action="spi.me">
	 <table id="a">
	 	<tr>
	 	</tr>
	 </table>
	</form> -->
	
	<script>
	$("#shopNum").click(function(){
		$.ajax({
			url:"/siktam/spc.me",
			type:"post",
			data:{
				Shoppid:$("#ShopPid_pop").val(),
				Shopname:$("#name").val()
			},
			datatype:"json",
			success:function(data){
				console.log(data);
				list = data;
				if(list["response"]["body"]["items"]!=""){
					console.log(list["response"]["body"]["items"]["item"][0]["wkplNm"]);
					console.log(list["response"]["body"]["items"]["item"][0]["bzowrRgstNo"]);
					var chkedpid = list["response"]["body"]["items"]["item"][0]["bzowrRgstNo"];
					console.log(chkedpid);
					alert("확인 완료!")
 						if(typeof chkedpid === "string"){
						/*alert("확인완료"); */
						opener.document.getElementById('ShopPid_reg').value=$('#ShopPid_pop').val();
 						}else if(chkedpid != null){
							alert("에러"); 
							
						}
					
				}else{
					
					alert("해당하는 매장이 없습니다");
					
				}
				
					
					//console.log(typeof(list["data"]));
	/*   			 	var $bno = $('<input type=hidden id="bno" name="bno" value="'+data[0].bzowrRgstNo+'">');
	 				console.log(bno);
	 				var $tr = $('<tr>');
					var $td = $('<td>');
					$td.append($bno);
					$tr.append($td);
					$('#a').append($bno);  */
				
			},error:function(){
				alert("오류")

			}
		});
	});
	

 // 숫자만 나오도록 str.replace("[^0-9]", ""); 449850
	
 //입력 된 pid, name이 json객체에 있으면 [확인버튼] -> pid값이 registerCompany_2.jsp 사업자번호체크란에 자동입력됨
 // 입력 된 pid, name이 json객체에 없으면 alert으로 해당하는 매장이 없습니다.
 // registerCompany_2.jsp창의 사업자번호란은 키보드로 직접입력 불가능하게 -> 완료
 

</script>

</body>
</html>