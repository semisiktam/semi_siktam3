<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.semi.pay.model.vo.*, com.kh.semi.coupon.model.vo.*, java.util.*"%>
    <%Coupon c = (Coupon)request.getAttribute("c");
      ArrayList<PayInfo>list = (ArrayList<PayInfo>)request.getAttribute("list");%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>pay5</title>
    <link rel="stylesheet" href="/siktam/resources/css/headerfooterLayout.css">
    <link rel="stylesheet" href="/siktam/resources/css/pay_5.css">
    <script src="/siktam/resources/js/jquery-3.4.1.min.js"></script>
</head>
<body>
    <!-- 헤더 시작 -->
    <%@ include file="common/header.jsp" %>
<form action="/siktam/views/payResult.jsp" method="post">
    <!-- 이 안에 작업하기 -->
    <div id="area1">
    <div id="StoreTitle">
        <div id="titleImg">
            <img src="/siktam/resources/images/udon.png" alt="">
        </div>
        <div id="titleText">
            <h1><b><%= list.get(0).getRshopName() %></b>(결제하기)</h1>
            <p><%= list.get(0).getRshopAddr() %></p>
            <input type=hidden id="rNo" name="rNo" value=<%=list.get(0).getrNo()%>>
        </div>
    </div>

    <hr>


    <div id="wrap">
        <div id="contentBox">    
            <div id="content1" class="content">
                <div id="content1-1">
                    <div id="title">
                        <p class="title-1"><b>결제하기</b></p>
                    </div>
                    <div id="sub-title">
                        <p class="title-1"><b>결제수단 선택</b></p>
                    </div>
                    <p class="sub-sub-title">온라인 결제</p><hr>
                    <table >
                        <tbody>
                            <tr>
                                <th class="paytableth">일반결제</th>
                                <td class="noline">
                                    <input type="radio" id="creditcard1" name="payType" class="pay" value="cardPay"><label for="creditcard1">신용카드</label>
                                </td>
                            </tr>
                            <tr>
                                <th class="paytableth">네이버페이 결제</th>
                                <td class="noline">
                                    <label for="creditcard2"><input type="radio" id="creditcard2" name="payType" value="naverPay" class="pay">
                                    <img src="/siktam/resources/images/네이버페이_로고_(800px_X_400px).jpg" id="naver" alt="네이버페이로고"></label>
                                </td>
                            </tr>
                            <tr>
                                <th class="paytableth">카카오페이 결제</th>
                                <td class="noline">
                                    <label for="creditcard3"><input type="radio" id="creditcard3" name="payType" value="kakaoPay" class="pay">
                                    <img src="/siktam/resources/images/카카오페이.png"  id="kakao" alt="카카오페이"></label>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div id="content1-2">
                <div id="sub-title">
                    <p class="title-1"><b>마일리지 사용</b></p>
                </div>    
                    <div id="mileageDiv">
                        <div>
                            <input type="text" class="mileage" id="useMile" name="mileage" value="0"><label id="won1">원 <--</label>
                            <input type="text" class="mileage" id="getMile" name="getMile" value='<%= m.getMileage() %>' style="text-align: left;"><label id="won2">원</label>
                        	<p>(사용가능 마일리지)</p>
                        </div>
                    </div>
                    <button type="button" id="appliance" >적용</button>
                    
                </div>
                <div id="content1-3">
                    <div id="sub-title">
                        <p class="title-1"><b>할인쿠폰 선택</b></p>
                    </div>
                    <input type="text" list="mylist" id="coupon" value="0" style="width: 75%;height: 30px;font-size: 15px;">
                    <input type="hidden" list="mylist" id="coupon" name="couponNo" value='<%=c.getCouponNo() %>' style="width: 75%;height: 30px;font-size: 15px;">
                    <datalist id="mylist">
                        <option value="0">쿠폰 없음</option>
                        <option value='<%=c.getDiscount() %>'><%=c.getCouponName() %></option>
                    </datalist>
                    <button type="button" id="couponclick">적용</button>
                    
                </div>
            </div>
            
           
            <div id="content2" class="content">
                <div id="content1-1">
                    <div id="sub-title">
                        <p class="title-1"><b>주문내역</b></p>
                    </div>
                    <div id="sub-sub-title2">
                        <p class="title-1"><b><%= list.get(0).getRshopName() %></b></p>
                    </div>
                    <div id="menulist">
                        <table id="menutable" >
                        <%for(PayInfo pi : list){ %>
                            <tr class="menupan">
                                <td class="menu"><%= pi.getRmenuName() %> X <%= pi.getRmenuCount()%>개</td>
                                <td><%= pi.getRmenuPrice() %></td>
                            </tr>
                        <%} %>    
                        </table>
                    </div>
                    <table id="menutable2">
                        <tr class="menupan2">
                            <td class="allpay"><b>총 결제 금액</b></td>
                            <td><b><%=list.get(0).getTotalPay()%></b></td>
                    		<td><input type="hidden" id="total"name="totalPay" value="<%=list.get(0).getTotalPay()%>">
                        </tr>
                    </table>
                </div>
                <div id="content1-4">
                  <ul id="agree">
                      <li><label for="all_chk" class="chk_label" id="all_chk"><input type="checkbox" id="all_chk" class="chk" onclick="allselect(this.checked)">전체동의</label><a href="termsOfUse2_5.jsp" target="_blank"><small>내용보기</small></a></li><hr>
                      <li><label for="sms_agree" class="chk_label"><input type="checkbox" id="sms_agree" name="agree" class="chk">SMS 수신동의</label></li>
                      <li><label for="use_agree" class="chk_label"><input type="checkbox" id="use_agree" name="agree" class="chk">이용약관 동의(필수)</label><a href="termsOfUse2_5.jsp" target="_blank"><small>내용보기</small></a></li>
                      <li><label for="collect_chk" class="chk_label"><input type="checkbox" id="collect_agree" name="agree" class="chk">개인정보 수집 및 이용동의(필수)</label><a href="termsOfUse2_5.jsp" target="_blank"><small>내용보기</small></a></li>
                      <li><label for="third_agree" class="chk_label"><input type="checkbox" id="third_agree" name="agree" class="chk">개인정보 제3자 제공동의(필수)</label><a href="termsOfUse2_5.jsp" target="_blank"><small>내용보기</small></a></li>
                      <li><label for="electronic_agree" class="chk_label"><input type="checkbox" id="electronic_agree" name="agree" class="chk">전자금융거래 이용약관(필수)</label><a href="termsOfUse2_5.jsp" target="_blank"><small>내용보기</small></a></li>
                      <li><label for="fourteen_agree" class="chk_label"><input type="checkbox" id="fourteen_agree" name="agree" class="chk">만 14세 이상 사용자(필수)</label><a href="termsOfUse2_5.jsp" target="_blank"><small>내용보기</small></a></li>
                  </ul>
                  <input type="submit" id="payment" value="결제하기">
                  <input type="button" id="payment" name="cancle" value="취소하기" onclick="location.href = 'reservationdelete.rc'">
                </div>
            </div>
        </div>
        
    </div>
    </div>
    </form>
    <script>
    	$('input[name="cancle"]').click(function(){
    		location.href="<%=request.getContextPath()%>/reservationdelete.rc?rNo="+'<%=list.get(0).getrNo()%>'
    	});
    </script>
    
    <script>
    	$('#couponclick').click(function(){
    		var coupon = $('#coupon').val();
    		var useMile = $('#useMile').val();
			var getMile = '<%=c.getMileage()%>'
    		var total = <%=list.get(0).getTotalPay()%>;
    		$.ajax({
    			url:"/siktam/coupon.cc",
    			type:"get",
    			data:{
    				"coupon" : coupon,
    				"useMile" : useMile,
					"getMile" : getMile,
    				"total" : total
    			},success:function(data){
    				console.log(data);
    				$('#menutable2').find('tr').remove();
    				var $b1 = $('<b>').text("총 결제 금액");
    				var $b2 = $('<b>').text(data.totalPay);
    				var $td0 = $('<td class="allpay">');
    				var $td1 = $('<td>');
    				var $td2 = $('<td>');
    				var $tr = $('<tr>');
    				var $input = $('<input type="hidden" id="total"name="totalPay" value="'+data.totalPay+'">');
    				$td0.append($b1);
    				$td1.append($b2);
    				$td2.append($input);
    				$tr.append($td0).append($td1).append($td2);
    				$('#menutable2').append($tr)
    				
    				console.log($('#total').val());
    			}
    		});
    	});
    </script>

	<script>
		
	
		$('#appliance').click(function(){
			var coupon = $('#coupon').val();
    		var useMile = $('#useMile').val();
			var getMile = '<%=c.getMileage()%>'
    		var total = <%=list.get(0).getTotalPay()%>;
			
			$.ajax({
				url:"/siktam/coupon.cc",
				type:"get",
				data:{
					"coupon" : coupon,
					"useMile" : useMile,
					"getMile" : getMile,
					"total" : total
				},success:function(data){
    				
    				if(data.useMile <= data.getMile && data.useMile <= data.totalPay){
						$('#menutable2').find('tr').remove();
    					$('#mileageDiv').find('div').remove();
        				var $b1 = $('<b>').text("총 결제 금액");
        				var $b2 = $('<b>').text(data.totalPay);
        				var $td0 = $('<td class="allpay">');
        				var $td1 = $('<td>');
        				var $td2 = $('<td>');
        				var $tr = $('<tr>');
        				var $input = $('<input type="hidden" id="total"name="totalPay" value="'+data.totalPay+'">');
        				$td0.append($b1);
        				$td1.append($b2);
        				$td2.append($input);
        				$tr.append($td0).append($td1).append($td2);
        				$('#menutable2').append($tr)
	    				
    					var $div = $('<div>');
	    				var $usemile = $('<input type="text" class="mileage" id="useMile" name="useMile" value="'+data.useMile+'">');
	    				var $label = $('<label id="won1">').text("원 <--");
	    				var $mile = $('<input type="text" class="mileage" id="getMile" name="getMile" value="'+data.mile+'" style="text-align: left;">');
	    				var $label2 = $('<label id="won2">').text("원");
	    				var $p = $('<p>').text("(사용가능 마일리지)");
	    				
	    				$div.append($usemile);
	    				$div.append($label);
	    				$div.append($mile);
	    				$div.append($label2);
	    				$div.append($p)
	    				$('#mileageDiv').append($div);
    				}else{
    					alert("마일리지 다시입력");
    				}
				}
			});
		});
	</script>
    <script>
     
    // 전체동의 체크박스
        function allselect(chd) {
            var agree = document.getElementsByName("agree");
            for (var i = 0; i < agree.length; i++) {
                agree[i].checked = chd;
            }
        }

       /*  function newOpen(){
            var popupX = (document.body.offsetWidth / 2) - (200 / 2);// 초기값 var popupX = (document.body.offsetWidth / 2) - (200 / 2);
            var popupY = (document.body.offsetHeight / 2);
        
        window.open('payPrint_1.jsp','예약완료','width=1000px, height=800px, scrollbars= no, toolbar=no, menubar=no,location=no,left='+ popupX + ', top='+ popupY+"'");
        } */

    </script>

    <!-- 푸터 시작 -->
    <%@ include file="common/footer.jsp" %>
</body>
</html>



