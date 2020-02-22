<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.semi.notice.model.vo.*"%>
    
    <%
    	Notice n = (Notice)request.getAttribute("notice");
    %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>공지사항 입력</title>
    <link rel="stylesheet" href="/siktam/resources/css/headerfooterLayout.css">
    <link rel="stylesheet" href="/siktam/resources/css/qna_form_5.css">
    <script src="/siktam/resources/js/jquery-3.4.1.min.js"></script>
    
    
</head>
<body>
    <!-- 헤더 시작 -->
    <%@ include file="common/header.jsp" %>

    <!-- 이 안에 작업하기 -->
    <div class="wrap" align="center">
    
            <div class="noticeTitle">
                <h1>공지사항 입력</h1>
            </div>
            <div class="qnaDiv">
                <form id="updateForm" method="post">
                    <div id="qna_write">
                        <table class="qna_tab">
                            <tbody>
                                <tr>
                                    <td class="qna_write_td">작성자</td>
                                    <td><input type="text" name="nwriter" value="<%=m.getUserId()%>" readonly></td>
                                </tr>
                                <tr>
                                    <td class="qna_write_td">제목</td>
                                    <td>
                                        <input type="text" name="ntitle" id="qna_write_title_input" value="<%=n.getnTitle()%>">
                                    </td>
                                </tr>
                                <tr>
                                    <td class="qna_write_td">내용</td>
                                    <td>
                                        <textarea name="ncontext" class="qna_write_textarea"><%=n.getnContext()%></textarea>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <div id="confirm">
                            <button id="submitBtn" value="수정하기" onclick="complete();">수정하기</button>
                            <button id="submitBtn" value="수정하기" onclick="deleteNotice();">삭제하기</button>
                        </div>
                    </div>
	<script>
		function complete(){
			$("#updateForm").attr("action","<%= request.getContextPath()%>/nUpdate.no?nno=<%=n.getnNo()%>");
		};
		function deleteNotice(){
			var confirm_check = confirm("정말 삭제 하시겠습니까?");
			if(confirm_check){				
				$("#updateForm").attr("action","<%= request.getContextPath() %>/nDelete.no?nno=<%=n.getnNo()%>");
			}else{
				$("#updateForm").attr("action","<%= request.getContextPath()%>/nUpView.no?nno=<%=n.getnNo()%>");
			}
		};
	</script>
                </form>
            </div>
            
    </div>





   


    

    <!-- 푸터 시작 -->
    <%@ include file="common/footer.jsp" %>
</body>
</html>
    