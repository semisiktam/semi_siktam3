<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>문의사항 수정</title>
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
                <h1>문의사항</h1>
            </div>
            <div class="qnaDiv">
                <form action="<%= request.getContextPath() %>/qInsert.qn" method="post">
                    <div id="qna_write">
                        <table class="qna_tab">
                            <tbody>
                                <tr>
                                    <td class="qna_write_td">작성자</td>
                                    <td><input type="text" name="writer" value="<%=m.getUserId() %>"></td>
                                </tr>
                                <tr>
                                    <td class="qna_write_td">제목</td>
                                    <td>
                                        <input type="text" name="qtitle" id="qna_write_title_input">
                                    </td>
                                </tr>
                                <tr>
                                    <td class="qna_write_td">내용</td>
                                    <td>
                                        <textarea name="qcontext" class="qna_write_textarea"></textarea>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <div id="confirm">
                            <input type="submit" id="submitBtn" value="등록하기">
                        </div>
                    </div>
                </form>
            </div>
            
    </div>






   


    

    <!-- 푸터 시작 -->
    <%@ include file="common/footer.jsp" %>
</body>
</html>
    