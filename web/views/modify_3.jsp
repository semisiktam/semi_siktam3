<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.semi.shop.model.vo.*, com.kh.semi.menu.model.vo.*"%>
<%
	ArrayList<MemberReservationList> mr = (ArrayList<MemberReservationList>)request.getAttribute("mrList");
	ArrayList<Menu> menu = (ArrayList<Menu>)request.getAttribute("mList");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>예약변경</title>
    <link rel="stylesheet" href="/siktam/resources/css/headerfooterLayout.css">
    <!-- 추가 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <!-- x버튼 -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- datepicker -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <!-- timepicker -->
	<link rel="stylesheet"	href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
	<script	src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
    <link rel="stylesheet" href="/siktam/resources/css/modify_3.css">
    <script>
    $(function() {
		//input을 datepicker로 선언
		$("#datepicker1").datepicker(
			{
				dateFormat : 'yy-mm-dd' //Input Display Format 변경
				,showOtherMonths : true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
				,showMonthAfterYear : true //년도 먼저 나오고, 뒤에 월 표시
				,changeYear : true //콤보박스에서 년 선택 가능
				,changeMonth : true //콤보박스에서 월 선택 가능                
				,showOn : "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
				,buttonImage : "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
				,buttonImageOnly : true //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
				,buttonText : "선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
				,yearSuffix : "년" //달력의 년도 부분 뒤에 붙는 텍스트
				,monthNamesShort : [ '1', '2', '3', '4', '5', '6',
									'7', '8', '9', '10', '11', '12' ] //달력의 월 부분 텍스트
				,monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월',
							  '7월', '8월', '9월', '10월', '11월', '12월' ] //달력의 월 부분 Tooltip 텍스트
				,dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ] //달력의 요일 부분 텍스트
				,dayNames : [ '일요일', '월요일', '화요일', '수요일', '목요일','금요일', '토요일' ] //달력의 요일 부분 Tooltip 텍스트
				,minDate : "0" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
				,maxDate : "+1M" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)
				,beforeShowDay : function(date) {
					var day = date.getDay();
					<%int shopDay=0;%>
					<% if(mr.get(0).getsDay().equals("일")){
					shopDay = 0;
					}
					if(mr.get(0).getsDay().equals("월")){
					shopDay = 1;
					}
					if(mr.get(0).getsDay().equals("화")){
					shopDay = 2;
					}
					if(mr.get(0).getsDay().equals("수")){
					shopDay = 3;
					}
					if(mr.get(0).getsDay().equals("목")){
					shopDay = 4;
					}
					if(mr.get(0).getsDay().equals("금")){
					shopDay = 5;
					}
					if(mr.get(0).getsDay().equals("토")){
					shopDay = 6;
					}
					if(mr.get(0).getsDay().equals("연중무휴")){
					shopDay = 7;
					}%>
					return [ (day != '<%=shopDay%>'
					)];
				 }
		});
		//초기값을 오늘 날짜로 설정
		$('#datepicker').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)        
	});
    </script>

    <script>
        $(function() {
            $('.timepicker').timepicker();
        });
    </script>
    
</head>
<body>
    <!-- 헤더 시작 -->
    <%@ include file="common/header.jsp" %>

    <!-- 이 안에 작업하기 -->
    <form method="POST" target="_self" action="payModify.pc">
    <div id="title">
        <div id="titleImg">
            <img src="/siktam/resources/images/udon.png" alt="">
        </div>
        <div id="titleText">
            <h1><b><%=mr.get(0).getShopName() %></b>(예약변경)</h1>
            <p><%=mr.get(0).getsAddr() %></p>
            <input type="hidden" name="shopPid" value="<%= mr.get(0).getShopPid() %>"/>
			<input type="hidden" name="shopName" value="<%=mr.get(0).getShopName()%>"/>
			<input type="hidden" name="shopAddr" value="<%=mr.get(0).getsAddr()%>"/>
        </div>
    </div>

    <hr>
    
    <div id="date-time">
        <div id="date">
            <p><span class="glyphicon glyphicon-calendar"></span> 예약 일자</p>    
            <p><input type="text" id="datepicker1" placeholder="<%=mr.get(0).getrDate() %>"><p>
        </div>
        
        <div id="time">
            <p><span class="glyphicon glyphicon-time"></span> 예약 시간</p>
            <p><input type="text" id='timepicker' name="time"><p>
        </div>
    </div>

    <div id="menu-result">
        <div id="menu1">
        <p><span class="glyphicon glyphicon-list-alt"></span> 메뉴</p>
        <div id="menuType">

        </div>
        <div id="tab-1" class="tab-content current">
            <table id="tbl">
            <%for (Menu me : menu) {%> 
                <tr>
                    <td><img src="<%=me.getMenuImg() %>" style="width:100px" alt="Image" class="img-thumbnail"></td>
                    <td><%=me.getMenuName() %></td>
                    <td><%=me.getMenuPrice() %></td>
                    <td>0</td>
                    <td>
                        <img src="/siktam/resources/images/leftArrow.png" alt="" width="10" height="10" class="bt_down" />
                        <img src="/siktam/resources/images/rightArrow.png" alt="" width="10" height="10" class="bt_up"/>
                    </td>
                </tr>
                <%
					}
				%> 
            </table>
        </div>
        </div>

        <div id="result1">
            <p><span class="glyphicon glyphicon-check"></span> 주문표</p>
            <div id="result2">
                <div id="result3">
                    <table id="resultTable">
                    </table>
                </div>
                
                <div id="result5">
                    <table id="tblSum">
                        <tr>
                            <td>결제 금액</td>
                            <td></td>
                        </tr>
                    </table>
                </div>

                <div id="result4">
                    <input type="submit" value="변경" id="btnSubmit" class="btn">
                    <input type="reset" value="뒤로" id="btnReset" class="btn" onclick="location.href='mypageMember.mm'">
                </div>

                
            </div>
        </div>
    </div>
    </form>

	<script>
	$(function() {
		$('#timepicker').timepicker({
			timeFormat : 'HH:mm',
			interval : 30,
			minTime :'<%=mr.get(0).getrTime()%>',
			maxTime :'<%=mr.get(0).getsEndTime()%>',
			defaultTime : '<%=mr.get(0).getrTime()%>',
			startTime : '00:00',
			dynamic : false,
			dropdown : true,
			scrollbar : true
		});
	});
	
	</script>

    <!-- 메뉴 수량 -->
    <script>
    $(function() {
		$('.bt_up').click(function() {
			var n = $('.bt_up').index(this);
			var num = $('#tbl tr:eq('+ n +')').children().eq(3).text();
			num = $('#tbl tr:eq('+ n +')').children().eq(3).text(num * 1 + 1);
			
			var m0 = []
			for(var i=0; i<$('#tbl tr').length; i++){
				m0.push($('#tbl tr:eq('+i+')').children().eq(1).text());
			    m0.push($('#tbl tr:eq('+i+')').children().eq(2).text());
				m0.push($('#tbl tr:eq('+i+')').children().eq(3).text());
			}
				
			$.ajax({
				 url:"/siktam/reservationPay.rc",
		         type:"get",
		         traditional : true,
		         dataType:"json",
		         data:{
		               "m0list" : m0
		         },success:function(data){
		           console.log(data);
		         
		        $('#resultTable').find('tr').remove(); 
		        $('#tblSum').find('td:eq(1)').remove();
		       
		        $('#hdtotal').remove();
		        $('#menuName').remove();
		        $('#menuCount').remove();
		        $('#menuPrice').remove();
		          
		        for(var i=0; i<data.length; i++){
		        	var $tr = $('<tr>');
		        	var $menuName = $('<td>').text(data[i].menuName);
		        	var $menuCount = $('<td>').text(data[i].menuCount);
		        	var $menuPrice = $('<td>').text(data[i].menuPrice);
		        	var $hdN = $('<input type="hidden" id="menuName" name="menuName" value="'+data[i].menuName+'">')
		        	var $hdC = $('<input type="hidden" id="menuCount" name="menuCount" value="'+data[i].menuCount+'">')
		        	var $hdP = $('<input type="hidden" id="menuPrice" name="menuPrice" value="'+data[i].menuPrice+'">')
		        	   
		        	$tr.append($menuName);
		        	$tr.append($hdN)
		        	$tr.append($menuCount);
		        	$tr.append($hdC)
		        	$tr.append($menuPrice);
		        	$tr.append($hdP)
		        	   
		        	$('#resultTable').append($tr);
		        	   
		        	$td = $('<td>'); 
		        	$total = $('<td>').text(data[data.length-1].total);
		        	$hdTag = $('<input type="hidden" id="hdtotal" name="hdtotal" value="'+data[data.length-1].total+'">');
		        }
		        	$('#tblSum').append($total).append($hdTag);
		        	  
		           
		         },error:function(){
		         }
			});
				
		});
		$('.bt_down').click(function() {
			var n = $('.bt_down').index(this);
			var num = $('#tbl tr:eq('+ n +')').children().eq(3).text();
			if (parseInt(num) > 0) {
				num = $('#tbl tr:eq('+ n +')').children().eq(3).text(num * 1 - 1);
				
			var m0 = []
			for(var i=0; i<$('#tbl tr').length; i++){
				m0.push($('#tbl tr:eq('+i+')').children().eq(1).text());
				m0.push($('#tbl tr:eq('+i+')').children().eq(2).text());
				m0.push($('#tbl tr:eq('+i+')').children().eq(3).text());
			}
					 
			$.ajax({
				 url:"/siktam/reservationPay.rc",
		         type:"get",
		         traditional : true,
		         dataType:"json",
		         data:{
		        	 "m0list" : m0
		         }
		         ,success:function(data){
		           console.log(data);
		            $('#resultTable').find('tr').remove(); 
			        $('#tblSum').find('td:eq(1)').remove();
			        $('#hdtotal').remove();
			        $('#menuName').remove();
			        $('#menuCount').remove();
			        $('#menuPrice').remove();
			          
			        for(var i=0; i<data.length; i++){
			        	var $tr = $('<tr>');
			        	var $menuName = $('<td>').text(data[i].menuName);
			        	var $menuCount = $('<td>').text(data[i].menuCount);
			        	var $menuPrice = $('<td>').text(data[i].menuPrice);
			        	var $hdN = $('<input type="hidden" id="menuName" name="menuName" value="'+data[i].menuName+'">')
			        	var $hdC = $('<input type="hidden" id="menuCount" name="menuCount" value="'+data[i].menuCount+'">')
			        	var $hdP = $('<input type="hidden" id="menuPrice" name="menuPrice" value="'+data[i].menuPrice+'">')
			        	   
			        	$tr.append($menuName);
			        	$tr.append($hdN)
			        	$tr.append($menuCount);
			        	$tr.append($hdC)
			        	$tr.append($menuPrice);
			        	$tr.append($hdP)
			        	   
			        	$('#resultTable').append($tr);
			        	   
			        	$td = $('<td>'); 
			        	$total = $('<td>').text(data[data.length-1].total);
			        	$hdTag = $('<input type="hidden" id="hdtotal" name="hdtotal" value="'+data[data.length-1].total+'">');
			        }
			        	$('#tblSum').append($total).append($hdTag);
			         },error:function(){
			        	 console.log("에러");
		         }
			});
			}
		});
	})
     

    </script>

    <!-- 메뉴탭키 -->
    <script>
        $(document).ready(function(){
	
        $('ul.tabs li').click(function(){
            var tab_id = $(this).attr('data-tab');

            $('ul.tabs li').removeClass('current');
            $('.tab-content').removeClass('current');

            $(this).addClass('current');
            $("#"+tab_id).addClass('current');
        })

    });
    </script>

    <!-- 푸터 시작 -->
    <%@ include file="common/footer.jsp" %>
</body>
</html>
