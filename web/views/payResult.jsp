<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 중</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/siktam/resources/css/searchConditions_4.css">
<link rel="stylesheet" href="/siktam/resources/css/headerfooterLayout.css">

<style>
	header{
		display: none;
	}
</style>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<%	
	    String name = m.getName();
	    String phone = m.getPhone();
	    String address = m.getAddr();
	    /* int totalPrice = (int)request.getAttribute("totalPrice"); */
	    String payType = request.getParameter("payType");
	    String totalPrice = request.getParameter("totalPay");
	    String mileage = request.getParameter("mileage");
	    String couponNo = request.getParameter("couponNo");
	    String rNo = request.getParameter("rNo");
	%>	
	
    <script>
    $(function(){
        var IMP = window.IMP; // 생략가능
        IMP.init('imp26836745'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
        
        IMP.request_pay({
            pg : 'kakaopay',
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : '식탐,나에게 맞은 식당을 탐색하다',
            amount : '<%=totalPrice%>',
            buyer_name : '<%=name%>',
            buyer_tel : '<%=phone%>',
            buyer_addr : '<%=address%>',
            buyer_postcode : '123-456',
            //m_redirect_url : 'http://www.naver.com'
        }, function(rsp) {
            if ( rsp.success ) {
                //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
                jQuery.ajax({
                    url: "/payments/complete", //cross-domain error가 발생하지 않도록 주의해주세요
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        imp_uid : rsp.imp_uid
                        //기타 필요한 데이터가 있으면 추가 전달
                    }
                }).done(function(data) {
                    //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
                    if ( everythings_fine ) {
                        msg = '결제가 완료되었습니다.';
                        msg += '\n고유ID : ' + rsp.imp_uid;
                        msg += '\n상점 거래ID : ' + rsp.merchant_uid;
                        msg += '\결제 금액 : ' + rsp.paid_amount;
                        msg += '카드 승인번호 : ' + rsp.apply_num;
                        
                    } else {
                        //[3] 아직 제대로 결제가 되지 않았습니다.
                        //[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
                    }
                });
                <%-- var msg = "";
                msg +='<%= classNo %>';
                msg +='&mno=<%= m.getM_no()%>';
                msg +='&millage=<%= millage %>';
                msg +='&saveMillage=<%= finalPay*0.05%>';
                msg +='&csNo=<%= csNo %>';
                
        		location.href="/semi/paySuccess.cp?cno="+msg; --%>
        		
        		var msg = "";
                msg+='<%=payType%>';
                msg+='&totalPrice=<%=totalPrice%>';
                msg+='&mileage=<%=mileage%>';
                msg+='&couponNo=<%=couponNo%>';
                msg+='&rNo=<%=rNo%>';
                
                //성공시 이동할 페이지
                location.href="/siktam/pInsert.pa?payType="+msg;
            } else {
                msg = '결제에 실패하였습니다.';
                /* msg += '에러내용 : ' + rsp.error_msg; */
                //실패시 이동할 페이지
                location.href='<%=request.getContextPath()%>/views/common/errorPage.jsp?msg='+msg;
            }
        });
        
    });
    </script>
 	
 	<div style="text-align:center; margin: auto; margin-top: 10%; padding: 50px; border: 3px dotted rgb(13, 78, 100); width: 40%" >
		<img src="/siktam/resources/images/error_icon.png" style="height: 100px; width: 100px">
		<h1><b>결제가 진행중입니다</b></h1><br>
		<h3>결제창을 통해  결제를 진행해주세요</h3>
	</div>
 	
</body>
</html>
