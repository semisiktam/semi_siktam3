<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.kh.semi.qna.model.vo.*"%>
    
    <%
    	Qna q = (Qna)request.getAttribute("qna");
    %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>문의사항 폼</title>
    <link rel="stylesheet" href="/siktam/resources/css/headerfooterLayout.css">
    <link rel="stylesheet" href="/siktam/resources/css/qna_form_5.css">
    <script src="/siktam/resources/js/jquery-3.4.1.min.js"></script>
    
    
</head>
<body>
    <!-- 헤더 시작 -->
    <%@ include file="common/header.jsp" %>
    
	<% if(m != null && m.getUserId().equals(q.getUserId())){ %>
	
    <!-- 이 안에 작업하기 -->
    <div class="wrap" align="center">
    
            <div class="noticeTitle">
                <h1>문의사항</h1>
            </div>
            <div class="qnaDiv">
                <form id="updateForm" method="post">
                    <div id="qna_write">
                        <table class="qna_tab">
                            <tbody>
                                <tr>
                                	<input type="hidden" name="qno" value="<%=q.getqNo() %>">
                                    <td class="qna_write_td">작성자</td>
                                    <td><input type="text" name="writer" value="<%=q.getUserId()%>" disabled="disabled"></td>
                                </tr>
                                <tr>
                                    <td class="qna_write_td">제목</td>
                                    <td>
                                        <input type="text" name="qtitle" id="qna_write_title_input" value="<%=q.getqTitle()%>">
                                    </td>
                                </tr>
                                <tr>
                                    <td class="qna_write_td">내용</td>
                                    <td>
                                        <textarea name="qcontext" class="qna_write_textarea"><%=q.getqContext() %></textarea>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <div id="confirm">
                            <input type="submit" id="submitBtn" onclick="complete();" value="수정하기">
                            <button id="submitBtn" onclick="deleteQna();">삭제하기</button>
                            <!-- 인풋태그 하면 값이 삭제가 안되고 id deleteBtn으로 하고 submitBtn이랑 속성값 같게해도 id값 동일하게 하고 button으로 변경합니다. -->
                            <!-- <input type="button" id="deleteBtn" onclick="deleteQna();" value="삭제하기"> -->
                        </div>
                        <script>
                        
							function complete(){
								$("#updateForm").attr("action","<%=request.getContextPath() %>/qUpdate.qn");
								
							}
							function deleteQna(){
								$('#updateForm').attr("action","<%=request.getContextPath() %>/qDelete.qn");
							}
					
						</script>
                   
                    </div>
                </form>
            </div>
            
    </div>
	<% } else {
		request.setAttribute("msg", "관계자 외에 접근이 불가능한 페이지입니다.");
	 } %>





   


    

    <!-- 푸터 시작 -->
    <%@ include file="common/footer.jsp" %>
</body>
</html>
    