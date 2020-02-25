<%@page import="com.kh.semi.menu.model.vo.Menu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%ArrayList<Menu> mlist=null;
      String shopPid;
      if(request.getAttribute("mlist")!=null){
    	  mlist=new ArrayList<Menu>();
    	  mlist=(ArrayList)request.getAttribute("mlist");
    	  shopPid=mlist.get(0).getShopPid();
      }else{
    	  shopPid=(String)request.getAttribute("shopPid");
      }
    %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메뉴 등록하기</title>
    <link rel="stylesheet" href="/siktam/resources/css/headerfooterLayout.css">
    <link rel="stylesheet" href="/siktam/resources/css/registerMenu_5.css">
	<script src="/siktam/resources/js/jquery-3.4.1.min.js"></script>
	<script>
	 	
	 	
	 	function insertBtn(obj){
	 		$('#fr').attr('action','/siktam/InsertMenuServlet').submit();
	 	}
	 	
	 	$(function(){
	 		$("#insert").click(function(){
				var shopPid = $(this).parent().parent().children().eq(0).children().val();
				
				/* var menuNo = $(this).parent().parent().children().eq(1).children().val(); */

				
				var menuName = $(this).parent().parent().children().eq(1).children().val();
				/* var menuImg = $(this).parent().parent().children().eq(3).children().val(); */
				var menuImg = 'shop.png';
				var menuPrice = $(this).parent().parent().children().eq(3).children().val();
				var menuInfo = $(this).parent().parent().children().eq(4).children().val();
				console.log(shopPid+menuName+menuImg+menuPrice+menuInfo);
				if(confirm("메뉴를 등록하시겠습니까?")){
					location.href="<%=request.getContextPath()%>/InsertMenuServlet?shopPid="+shopPid +
																					"&menuName=" + menuName +
																					"&menuImg=" + menuImg +
																					"&menuPrice=" + menuPrice + 
																					"&menuInfo=" + menuInfo;
				}
	 		});
	 	});
	 	
	 	$(function(){
			$(".btnModify").click(function(){
				//console.log($(this).parent().children().eq(0).text());
				var shopPid = $(this).parent().parent().children().eq(0).children().val();
				
				var menuNo = $(this).parent().parent().children().eq(1).children().val();

				
				var menuName = $(this).parent().parent().children().eq(2).children().val();
				/* var menuImg = $(this).parent().parent().children().eq(3).children().val(); */
				var menuImg = 'shop.png';
				var menuPrice = $(this).parent().parent().children().eq(4).children().val();
				var menuInfo = $(this).parent().parent().children().eq(5).children().val();
				
				if(confirm("메뉴를 수정하시겠습니까?")){
					location.href="<%=request.getContextPath()%>/UpdateMenuServlet?shopPid="+shopPid + 
																					"&menuNo=" + menuNo +
																					"&menuName=" + menuName +
																					"&menuImg=" + menuImg +
																					"&menuPrice=" + menuPrice + 
																					"&menuInfo=" + menuInfo;
				}
			});
		});
	 	$(function(){
			$(".btnDelete").click(function(){
				var menuNo=$(this).parent().parent().children().eq(1).children().val();
				/* console.log(menuNo); */
				var shopPid = $(this).parent().parent().children().eq(0).children().val();
				if(confirm("메뉴를 삭제하시겠습니까?")){
					location.href="<%=request.getContextPath()%>/DeleteMenuServlet?shopPid="+shopPid + 
																						"&menuNo=" + menuNo;
				}
			});
			
	 	});
	 	
	 	
	</script>
	
</head>
<body>
    <!-- 헤더 시작 -->
    <%@ include file="common/header.jsp" %>

    <!-- 이 안에 작업하기 -->
    <div id="wrap">
        <div id="modal1">
            <div class="modal_content">
                <h2>메뉴 등록 및 수정</h2>
                <br><br>

                <table id="reservationTb1">
                    <thead>
                        <tr class="reservationTr">
                        	<th style="display:none">가게고유번호</th>
                        	<th style="display:none">메뉴번호</th>
                            <th>메뉴명</th>
                            <th>메뉴 사진</th> 
                            <th>메뉴 가격</th> 
                            <th>설명</th> 
                            <th colspan="2">메뉴 수정/삭제</th>
                         </tr>
                    </thead>
                    <tbody>
                    <%if(mlist!=null){ %>
                    	<%for(Menu me: mlist){ %>
                        <tr class="reservationTr">
	                      	<td style="display:none"><input type="text" name="shopPid" value="<%=me.getShopPid() %>"></td>
	                      	<td style="display:none"><input type="text" name="menuNo" value="<%=me.getMenuNo() %>"></td>
                            <td><input type="text" name="menuName" value="<%=me.getMenuName()%>"></td>
                            <td><input type="file" name="menuImg" value="<%=me.getMenuImg()%>"></td>
                            <td><input type="text" name="menuPrice" value="<%=me.getMenuPrice()%>"></td>
                            <td><input type="text" name="menuInfo" value="<%=me.getMenuInfo()%>"></td>
                            <td><input type="submit" value="수정" class="btn btnModify" id="modify">
                            	<input type="submit" value="삭제" class="btn2 btnDelete" id="delete">
                            </td>
                        </tr>
                        <%} %>
                        <tr class="reservationTr">
	                      	<td style="display:none"><input type="text" name="shopPid" value="<%=shopPid%>"></td>
                            <td><input type="text" name="menuName" placeholder="메뉴명을 입력해주세요"></td>
                            <td><input type="file" name="menuImg" placeholder="메뉴사진"></td>
                            <td><input type="text" name="menuPrice" placeholder="메뉴 가격"></td>
                            <td><input type="text" name="menuInfo" placeholder="메뉴에 관한 간단한 설명"></td>
                            <td><input style="width:130px" type="submit" value="메뉴 등록하기" class="btn btnInsert" id="insert"></td>
                        </tr>
                    <%}else{%>
                    	<tr class="reservationTr">
	                      	<td style="display:none"><input type="text" name="shopPid" value="<%=shopPid%>"></td>
                            <td><input type="text" name="menuName" placeholder="메뉴명을 입력해주세요"></td>
                            <td><input type="file" name="menuImg" placeholder="메뉴사진"></td>
                            <td><input type="text" name="menuPrice" placeholder="메뉴 가격"></td>
                            <td><input type="text" name="menuInfo" placeholder="메뉴에 관한 간단한 설명을 입력해주세요"></td>
                            <td><input style="width:130px" type="submit" value="메뉴 등록하기" class="btn btnInsert" id="insert"></td>
                            
                        </tr>
                    <%} %>
                    	
                        
                    </tbody>
                </table><br><!-- 
                <button id="plus" class="btn" name="plus">추가하기</button><br><br><br> -->
                <a href="/siktam/views/mypageShop_5.jsp"><button class="btn3">마이페이지로 돌아가기</button></a>
            </div>
        </div>
        </div>
    <!-- 푸터 시작 -->
    <%@ include file="common/footer.jsp" %>
</body>
</html>

