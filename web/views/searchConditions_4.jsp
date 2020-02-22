<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.semi.shop.model.vo.*"%>
	<%
		ArrayList<ShopSearch> list = (ArrayList<ShopSearch>)request.getAttribute("list");
		String skeyword = (String)request.getAttribute("skeyword");
	%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>조건검색</title>
    <!-- 추가 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/siktam/resources/css/searchConditions_4.css">
    <link rel="stylesheet" href="/siktam/resources/css/headerfooterLayout.css">
    
</head>
<body>
    <!-- 헤더  -->
	<%@ include file="common/header.jsp" %>

    <!-- 이 안에 작업하기 -->
<div id="area1">
    <div id="container">
        <div id="search" class="component">
            <input type="text" placeholder="위치를 입력해주세요" id="search-text" class="form-control" style="display: inline-block;" <%-- value="<%= skeyword %>" --%>>
            
            <a class="btn btn-default btn-lg" id="searchbtn">
                <span class="glyphicon glyphicon-ok" onclick='search();'></span> 검색
            </a>
        </div>
    	
        <table id="table1">
            <!-- border="1px solid black" -->
            <tr id="tr1">
                <td class="table-rowName">테이블</td>
                <td><input type="checkbox" value="1인석" id='a1' class="table-check" name="table" ><label for='a1'>1인석</label></td>
                <td><input type="checkbox" value="2인석" id='a2' class="table-check" name="table" ><label for='a2'>2인석</label></td>
                <td><input type="checkbox" value="칸막이" id='a3' class="table-check" name="table" ><label for='a3'>칸막이</label></td>
                <td><input type="checkbox" value="바테이블" id='a4' class="table-check" name="table" ><label for='a4'>바테이블</label></td>
                <td><input type="checkbox" value="셀프주문" id='a5' class="table-check" name="table" ><label for='a5'>셀프주문</label></td>
                
            </tr>
            <tr id="tr2">
                <td class="table-rowName">음식</td>
                <td><input type="checkbox" value="한식" id='b1' class="table-check" name="category" ><label for='b1'>한식</label></td>
                <td><input type="checkbox" value="중식" id='b2' class="table-check" name="category" ><label for='b2'>중식</label></td>
                <td><input type="checkbox" value="분식" id='b3' class="table-check" name="category" ><label for='b3'>분식</label></td>
                <td><input type="checkbox" value="양식" id='b4' class="table-check" name="category" ><label for='b4'>양식</label></td>
                <td><input type="checkbox" value="일식" id='b5' class="table-check" name="category" ><label for='b5'>일식</label></td>
            </tr>
            <tr>
            	<td></td>
                <td><input type="checkbox" value="카페/디저트" id='b6' class="table-check" name="category" ><label for='b6'>카페/디저트</label></td>
                <td><input type="checkbox" value="치킨" id='b7' class="table-check" name="category" ><label for='b7'>치킨</label></td>
                <td><input type="checkbox" value="피자" id='b8' class="table-check" name="category" ><label for='b8'>피자</label></td>
                <td><input type="checkbox" value="족발/보쌈" id='b9' class="table-check" name="category" ><label for='b9'>족발/보쌈</label></td>
                <td><input type="checkbox" value="도시락" id='b10' class="table-check" name="category" ><label for='b10'>도시락</label></td>
            </tr>
            <tr>
            	<td></td>
                <td><input type="checkbox" value="찜탕" id='b11' class="table-check" name="category" ><label for='b11'>찜/탕</label></td>
                <td><input type="checkbox" value="프랜차이즈" id='b12' class="table-check" name="category" ><label for='b12'>프랜차이즈</label></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            
            <tr id="tr3">
                <td class="table-rowName">가격대</td>
                <td><input type="checkbox" value="10000" id='c1' class="table-check" name="price" ><label for='c1'>10,000원 이하</label></td>
                <td><input type="checkbox" value="10000~20000" id='c2' class="table-check" name="price" ><label for='c2'>10,000 ~ 20,000원</label></td>
                <td><input type="checkbox" value="20000~30000" id='c3' class="table-check" name="price" ><label for='c3'>20,000 ~ 30,000원</label></td>
                <td><input type="checkbox" value="30000" id='c4' class="table-check" name="price" ><label for='c4'>30,000원 이상</label></td>
                <td></td>
            </tr>
        </table>
        
        <br>

        <table id="table2">
            <!-- class="table table-condensed" -->
            <tr>
                <td class="table-rowName"><h5>선택내용</h5></td>
                <td id="table-result"></td>
            </tr>
        </table>


        <div id="list-sort" class="component">
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" data-toggle="dropdown" id="sortbtn">정렬 방법
                <span class="caret"></span></button>
                <ul id="line_up" class="dropdown-menu dropdown-menu-right">
                    <li>리뷰 순</li>
                    <li>방문 순</li>
                    <li>평점 순</li>
                </ul>
            </div>
        </div>
   

    <hr>

    <div id="result">
        <table border="1px" id="tbl">
        <% for(ShopSearch sc : list){ %>
	       <tr>
	         <td style="display:none"><%=sc.getShopPid() %></td>
	         <td id="img"><img src="/siktam/resources/images/<%= sc.getShopImg() %>"  style="width:100%" alt="Image" class="img-thumbnail"></td>
	         <td id="txt"  style="word-break:break-all">
	            <h4><b><%= sc.getShopName() %> </b></h4>
	            <ul>
	              <li><span class="star">★<%= sc.getStar() %></span><span class="review_num">리뷰 <%= sc.getReviewCount() %></span><span class="reserve_num">예약 <%= sc.getReviewCount() %></span></li>
	              <li><span class="area"><%= sc.getShopAddr() %></span><span class="tableInfo"> <%= sc.getTableType()%></span><span class="sectors"> <%= sc.getMenuCategory() %></span></li>
	              <li><span class="mainMenu">대표메뉴 : 역전우동, 김치우동, 어묵우동 등</span></li>
	            </ul>
	         </td>
	      </tr>
        <% } %>
        </table>
    </div>
	<script>
		function search(){
	 		 location.href="<%=request.getContextPath()%>/searchMain.sc?keyword="+$('#search-text').val(); 
		}
		$(function(){
			
			$("#tbl td").mouseenter(function(){
				$(this).parent().css({"background":"lightgray", "cursor":"pointer"});
			}).mouseout(function(){
				$(this).parent().css({"background":"white"});
			}).click(function(){
				//console.log($(this).parent().children().eq(0).text());
				var shopPid = $(this).parent().children().eq(0).text();
				location.href="<%=request.getContextPath()%>/sSelect.so?shopPid=" + shopPid;
			});
		});
	</script>
	
	<script>
		$('#line_up').children().click(function(){
			var index = $('#line_up').children().index(this);
			var line = $('#line_up').children().eq(index).text();
			
			 var key = '<%=skeyword%>'
			 var tlist = [];
		     var clist = [];
		     var plist = [];
		     
		     console.log(line);
		     $("input[name='table']:checked").each(function(i){
		            tlist.push($(this).val());
		     });
		     $("input[name='category']:checked").each(function(i){
		            clist.push($(this).val());
		     });
		     $("input[name='price']:checked").each(function(i){
		            plist.push($(this).val());
		     });
			
			$.ajax({
				url:"/siktam/SearchCondition.sc",
				type:"get",	
				traditional : true, 
		        data:{
		        	"tlist" : tlist,
		            "clist" : clist,
		            "plist" : plist,
		        	"line" : line,
		        	"key" : key
		        },success:function(data){
		               console.log(data);
		               $('#tbl').find('tr').remove();
		               for(var i=0; i<data.length; i++){
		            	   var $tr = $('<tr>');
		            	   var $shopPid = $('<td style="display:none">').text(data[i].shopPid);
		            	   var $tdI = $('<td id="img">');
		            	   var $shopImg = $('<img src="/siktam/resources/images/'+data[i].shopImg+'"  style="width:100%" alt="Image" class="img-thumbnail">');
		            	   var $tdT = $('<td id="txt"  style="word-break:break-all">');
		            	   var $h4 = $('<h4>');
		            	   var $shopName = $('<b>').text(data[i].shopName);
		            	   var $ul = $('<ul>');
		            	   var $li = $('<li>');
		            	   var $li2 = $('<li>');
		            	   var $star = $('<span class="star">').text("★" +data[i].star);
		            	   var $reviewCount = $('<span class="review_num">').text("리뷰 " +data[i].reviewCount);
		            	   var $reservationCount = $('<span class="reserve_num">').text("예약 " + data[i].reservationCount);
		            	   var $shopAddr = $('<span class="area">').text(data[i].shopAddr);
		            	   var $tableType = $('<span class="tableInfo">').text(data[i].tableType);
		            	   var $MenuCategory = $('<span class="sectors">').text(data[i].MenuCategory);
		            	   /* var $li3 = $('<li>');
		            	   var $mainMenu = $('<span class="mainMenu">'); */
		            	   $tdI.append($shopImg);
		            	   
		            	   $h4.append($shopName);
		            	   
		            	   $li.append($star).append($reviewCount).append($reservationCount);
		            	   $li2.append($shopAddr).append($shopAddr).append($tableType).append($MenuCategory);
		            	   $ul.append($li);
		            	   $ul.append($li2);
		            	   
		            	   $tdT.append($h4);
		            	   $tdT.append($ul);
		            	   
		            	   $tr.append($shopPid);
		            	   $tr.append($tdI);
		            	   $tr.append($tdT);
		            	   
		            	   $('#tbl').append($tr);
		            	   
		            	   $(function(){
		           			
		           			$("#tbl td").mouseenter(function(){
		           				$(this).parent().css({"background":"lightgray", "cursor":"pointer"});
		           			}).mouseout(function(){
		           				$(this).parent().css({"background":"white"});
		           			}).click(function(){
		           				//console.log($(this).parent().children().eq(0).text());
		           				var shopPid = $(this).parent().children().eq(0).text();
		           				location.href="<%=request.getContextPath()%>/sSelect.so?shopPid=" + shopPid;
		           			});
		           		});
		               } 
		            },error:function(){
		            	 console.log("에러");
		            }
			});      
		});
	</script>
   <!--  <script>
         function check(){
            var result = document.getElementById('table-result');
            var tableCheck = document.getElementsByClassName("table-check");
            result.innerHTML = "";

            for(var i=0; i<tableCheck.length; i++){
                if(tableCheck[i].checked==true){
                    result.innerHTML += "<label for='" + tableCheck[i].id + "'>" + tableCheck[i].value + "</label>&nbsp;&nbsp;&nbsp;&nbsp;";
                }
            }            
        } 
    </script> -->
    <script>
    $(function(){
    	
    /* var line;
    $('#line_up').children().click(function(){
		var index = $('#line_up').children().index(this);
		line = $('#line_up').children().eq(index).text();	
    });	 */
    $('.table-check').click(function(){
        var tlist = [];
        var clist = [];
        var plist = [];
        
        var key = '<%=skeyword%>'
        
        $("input[name='table']:checked").each(function(i){
            tlist.push($(this).val());
         });
        $("input[name='category']:checked").each(function(i){
            clist.push($(this).val());
         });
        $("input[name='price']:checked").each(function(i){
            plist.push($(this).val());
         });
        <%-- location.href="<%=request.getContextPath()%>/SearchCondition.sc?tlist=" + tlist + "&clist=" + clist + "&plist=" +plist; --%>
        
         $.ajax({
            url:"/siktam/SearchCondition.sc",
            type:"get",
            traditional : true, 
            data:{
               "tlist" : tlist,
               "clist" : clist,
               "plist" : plist,
               "key" : key
            },success:function(data){
               console.log(data);
               $('#tbl').find('tr').remove();
               for(var i=0; i<data.length; i++){
            	   var $tr = $('<tr>');
            	   var $shopPid = $('<td style="display:none">').text(data[i].shopPid);
            	   var $tdI = $('<td id="img">');
            	   var $shopImg = $('<img src="/siktam/resources/images/'+data[i].shopImg+'"  style="width:100%" alt="Image" class="img-thumbnail">');
            	   var $tdT = $('<td id="txt"  style="word-break:break-all">');
            	   var $h4 = $('<h4>');
            	   var $shopName = $('<b>').text(data[i].shopName);
            	   var $ul = $('<ul>');
            	   var $li = $('<li>');
            	   var $li2 = $('<li>');
            	   var $star = $('<span class="star">').text("★" +data[i].star);
            	   var $reviewCount = $('<span class="review_num">').text("리뷰 " +data[i].reviewCount);
            	   var $reservationCount = $('<span class="reserve_num">').text("예약 " + data[i].reservationCount);
            	   var $shopAddr = $('<span class="area">').text(data[i].shopAddr);
            	   var $tableType = $('<span class="tableInfo">').text(data[i].tableType);
            	   var $MenuCategory = $('<span class="sectors">').text(data[i].MenuCategory);
            	   /* var $li3 = $('<li>');
            	   var $mainMenu = $('<span class="mainMenu">'); */
            	   $tdI.append($shopImg);
            	   
            	   $h4.append($shopName);
            	   
            	   $li.append($star).append($reviewCount).append($reservationCount);
            	   $li2.append($shopAddr).append($shopAddr).append($tableType).append($MenuCategory);
            	   $ul.append($li);
            	   $ul.append($li2);
            	   
            	   $tdT.append($h4);
            	   $tdT.append($ul);
            	   
            	   $tr.append($shopPid);
            	   $tr.append($tdI);
            	   $tr.append($tdT);
            	   
            	   $('#tbl').append($tr);
            	   
            	   $(function(){
           			
           			$("#tbl td").mouseenter(function(){
           				$(this).parent().css({"background":"lightgray", "cursor":"pointer"});
           			}).mouseout(function(){
           				$(this).parent().css({"background":"white"});
           			}).click(function(){
           				//console.log($(this).parent().children().eq(0).text());
           				var shopPid = $(this).parent().children().eq(0).text();
           				location.href="<%=request.getContextPath()%>/sSelect.so?shopPid=" + shopPid;
           			});
           		});
               } 
               	   	
            },error:function(){
            	 console.log("에러");
            }
          }); 
     }); 
    });
   
    </script>
    </div>
</div>
    <!-- 푸터 -->
    <%@ include file="common/footer.jsp" %>

</body>
</html>
