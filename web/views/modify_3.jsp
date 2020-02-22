<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="https://code.jquery.com/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
    <!-- timepicker -->
    <link rel="stylesheet" href="https://cdn.rawgit.com/fgelinas/timepicker/master/jquery.ui.timepicker.css">
    <script src='https://cdn.rawgit.com/fgelinas/timepicker/master/jquery.ui.timepicker.js'></script>
    <link rel="stylesheet" href="/siktam/resources/css/modify_3.css">
    <script>
        $(function() {
            $( "#datepicker1" ).datepicker({
                dateFormat: 'yy.mm.dd',
                prevText: '이전 달',
                nextText: '다음 달',
                monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                dayNames: ['일','월','화','수','목','금','토'],
                dayNamesShort: ['일','월','화','수','목','금','토'],
                dayNamesMin: ['일','월','화','수','목','금','토'],
                showMonthAfterYear: true,
                changeMonth: true,
                changeYear: true,
                yearSuffix: '년'
            });
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
    <form method="POST" target="_self" action="pay_5.jsp">
    <div id="title">
        <div id="titleImg">
            <img src="/siktam/resources/images/udon.png" alt="">
        </div>
        <div id="titleText">
            <h1><b>역전우동</b>(예약변경)</h1>
            <p>서울특별시 서초구 양재동 역전우동 양재점</p>
        </div>
    </div>

    <hr>
    
    <div id="date-time">
        <div id="date">
            <p><span class="glyphicon glyphicon-calendar"></span> 예약 일자</p>    
            <p><input type="date" value="2020-01-16" min="2020-01-16" max="2020-03-31"></p>
            <!-- <input type="text" id="datepicker1" placeholder="예약 일자"> -->
        </div>
        
        <div id="time">
            <p><span class="glyphicon glyphicon-time"></span> 예약 시간</p>
            <p><input type="time" value="14:00"></p>
            <!-- <input type="text" class='timepicker' placeholder="예약 시간"> -->
        </div>
    </div>

    <div id="menu-result">
        <div id="menu1">
        <p><span class="glyphicon glyphicon-list-alt"></span> 메뉴</p>
        <div id="menuType">
            <ul class="tabs">
                <li class="tab-link current" data-tab="tab-1">치킨</li>
                <li class="tab-link" data-tab="tab-2">피자</li>
                <li class="tab-link" data-tab="tab-3">짜장면</li>
            </ul>
        </div>
        <div id="tab-1" class="tab-content current">
            <table id="tbl">
                <tr>
                    <td><img src="/siktam/resources/images/03.png" style="width:100px" alt="Image" class="img-thumbnail"></td>
                    <td>후라이드 치킨</td>
                    <td>5000원</td>
                    <td>
                        <img src="/siktam/resources/images/leftArrow.png" alt="" width="10" height="10" class="bt_down" />
                        <input type="text" name="num" value="0" id="" class="num" size="1"/>
                        <img src="/siktam/resources/images/rightArrow.png" alt="" width="10" height="10" class="bt_up"/>
                    </td>
                </tr>
                <tr>
                    <td><img src="/siktam/resources/images/03.png" style="width:100px" alt="Image" class="img-thumbnail"></td>
                    <td>후라이드 치킨</td>
                    <td>5000원</td>
                    <td>
                        <img src="/siktam/resources/images/leftArrow.png" alt="" width="10" height="10" class="bt_down" />
                        <input type="text" name="num" value="0" id="" class="num" size="1"/>
                        <img src="/siktam/resources/images/rightArrow.png" alt="" width="10" height="10" class="bt_up"/>
                    </td>
                </tr>

                <tr>
                    <td><img src="/siktam/resources/images/03.png" style="width:100px" alt="Image" class="img-thumbnail"></td>
                    <td>후라이드 치킨</td>
                    <td>5000원</td>
                    <td>
                        <img src="/siktam/resources/images/leftArrow.png" alt="" width="10" height="10" class="bt_down" />
                        <input type="text" name="num" value="0" id="" class="num" size="1"/>
                        <img src="/siktam/resources/images/rightArrow.png" alt="" width="10" height="10" class="bt_up"/>
                    </td>
                </tr>

                <tr>
                    <td><img src="/siktam/resources/images/03.png" style="width:100px" alt="Image" class="img-thumbnail"></td>
                    <td>후라이드 치킨</td>
                    <td>5000원</td>
                    <td>
                        <img src="/siktam/resources/images/leftArrow.png" alt="" width="10" height="10" class="bt_down" />
                        <input type="text" name="num" value="0" id="" class="num" size="1"/>
                        <img src="/siktam/resources/images/rightArrow.png" alt="" width="10" height="10" class="bt_up"/>
                    </td>                   
                </tr>

                <tr>
                    <td><img src="/siktam/resources/images/03.png" style="width:100px" alt="Image" class="img-thumbnail"></td>
                    <td>후라이드 치킨</td>
                    <td>5000원</td>
                    <td>
                        <img src="/siktam/resources/images/leftArrow.png" alt="" width="10" height="10" class="bt_down" />
                        <input type="text" name="num" value="0" id="" class="num" size="1"/>
                        <img src="/siktam/resources/images/rightArrow.png" alt="" width="10" height="10" class="bt_up"/>
                    </td>
                </tr>

                <tr>
                    <td><img src="/siktam/resources/images/03.png" style="width:100px" alt="Image" class="img-thumbnail"></td>
                    <td>후라이드 치킨</td>
                    <td>5000원</td>
                    <td>
                        <img src="/siktam/resources/images/leftArrow.png" alt="" width="10" height="10" class="bt_down" />
                        <input type="text" name="num" value="0" id="" class="num" size="1"/>
                        <img src="/siktam/resources/images/rightArrow.png" alt="" width="10" height="10" class="bt_up"/>
                    </td>
                </tr>
            </table>
        </div>

        <div id="tab-2" class="tab-content">
            <table id="tbl">
                <tr>
                    <td><img src="/siktam/resources/images/10.png" style="width:100px" alt="Image" class="img-thumbnail"></td>
                    <td>콤비네이션 피자</td>
                    <td>5000원</td>
                    <td>
                        <img src="/siktam/resources/images/leftArrow.png" alt="" width="10" height="10" class="bt_down" />
                        <input type="text" name="num" value="0" id="" class="num" size="1"/>
                        <img src="/siktam/resources/images/rightArrow.png" alt="" width="10" height="10" class="bt_up"/>
                    </td>
                </tr>
                <tr>
                    <td><img src="/siktam/resources/images/10.png" style="width:100px" alt="Image" class="img-thumbnail"></td>
                    <td>콤비네이션 피자</td>
                    <td>5000원</td>
                    <td>
                        <img src="/siktam/resources/images/leftArrow.png" alt="" width="10" height="10" class="bt_down" />
                        <input type="text" name="num" value="0" id="" class="num" size="1"/>
                        <img src="/siktam/resources/images/rightArrow.png" alt="" width="10" height="10" class="bt_up"/>
                    </td>
                </tr>

                <tr>
                    <td><img src="/siktam/resources/images/10.png" style="width:100px" alt="Image" class="img-thumbnail"></td>
                    <td>콤비네이션 피자</td>
                    <td>5000원</td>
                    <td>
                        <img src="/siktam/resources/images/leftArrow.png" alt="" width="10" height="10" class="bt_down" />
                        <input type="text" name="num" value="0" id="" class="num" size="1"/>
                        <img src="/siktam/resources/images/rightArrow.png" alt="" width="10" height="10" class="bt_up"/>
                    </td>
                </tr>

                <tr>
                    <td><img src="/siktam/resources/images/10.png" style="width:100px" alt="Image" class="img-thumbnail"></td>
                    <td>콤비네이션 피자</td>
                    <td>5000원</td>
                    <td>
                        <img src="/siktam/resources/images/leftArrow.png" alt="" width="10" height="10" class="bt_down" />
                        <input type="text" name="num" value="0" id="" class="num" size="1"/>
                        <img src="/siktam/resources/images/rightArrow.png" alt="" width="10" height="10" class="bt_up"/>
                    </td>                   
                </tr>

                <tr>
                    <td><img src="/siktam/resources/images/10.png" style="width:100px" alt="Image" class="img-thumbnail"></td>
                    <td>콤비네이션 피자</td>
                    <td>5000원</td>
                    <td>
                        <img src="/siktam/resources/images/leftArrow.png" alt="" width="10" height="10" class="bt_down" />
                        <input type="text" name="num" value="0" id="" class="num" size="1"/>
                        <img src="/siktam/resources/images/rightArrow.png" alt="" width="10" height="10" class="bt_up"/>
                    </td>
                </tr>

                <tr>
                    <td><img src="/siktam/resources/images/10.png" style="width:100px" alt="Image" class="img-thumbnail"></td>
                    <td>콤비네이션 피자</td>
                    <td>5000원</td>
                    <td>
                        <img src="/siktam/resources/images/leftArrow.png" alt="" width="10" height="10" class="bt_down" />
                        <input type="text" name="num" value="0" id="" class="num" size="1"/>
                        <img src="/siktam/resources/images/rightArrow.png" alt="" width="10" height="10" class="bt_up"/>
                    </td>
                </tr>
            </table>
        </div>

        <div id="tab-3" class="tab-content">
            <table id="tbl">
                <tr>
                    <td><img src="/siktam/resources/images/04.png" style="width:100px" alt="Image" class="img-thumbnail"></td>
                    <td>간짜장</td>
                    <td>5000원</td>
                    <td>
                        <img src="/siktam/resources/images/leftArrow.png" alt="" width="10" height="10" class="bt_down" />
                        <input type="text" name="num" value="0" id="" class="num" size="1"/>
                        <img src="/siktam/resources/images/rightArrow.png" alt="" width="10" height="10" class="bt_up"/>
                    </td>
                </tr>
                <tr>
                    <td><img src="/siktam/resources/images/04.png" style="width:100px" alt="Image" class="img-thumbnail"></td>
                    <td>간짜장</td>
                    <td>5000원</td>
                    <td>
                        <img src="/siktam/resources/images/leftArrow.png" alt="" width="10" height="10" class="bt_down" />
                        <input type="text" name="num" value="0" id="" class="num" size="1"/>
                        <img src="/siktam/resources/images/rightArrow.png" alt="" width="10" height="10" class="bt_up"/>
                    </td>
                </tr>

                <tr>
                    <td><img src="/siktam/resources/images/04.png" style="width:100px" alt="Image" class="img-thumbnail"></td>
                    <td>간짜장</td>
                    <td>5000원</td>
                    <td>
                        <img src="/siktam/resources/images/leftArrow.png" alt="" width="10" height="10" class="bt_down" />
                        <input type="text" name="num" value="0" id="" class="num" size="1"/>
                        <img src="/siktam/resources/images/rightArrow.png" alt="" width="10" height="10" class="bt_up"/>
                    </td>
                </tr>

                <tr>
                    <td><img src="/siktam/resources/images/04.png" style="width:100px" alt="Image" class="img-thumbnail"></td>
                    <td>간짜장</td>
                    <td>5000원</td>
                    <td>
                        <img src="/siktam/resources/images/leftArrow.png" alt="" width="10" height="10" class="bt_down" />
                        <input type="text" name="num" value="0" id="" class="num" size="1"/>
                        <img src="/siktam/resources/images/rightArrow.png" alt="" width="10" height="10" class="bt_up"/>
                    </td>                   
                </tr>

                <tr>
                    <td><img src="/siktam/resources/images/04.png" style="width:100px" alt="Image" class="img-thumbnail"></td>
                    <td>간짜장</td>
                    <td>5000원</td>
                    <td>
                        <img src="/siktam/resources/images/leftArrow.png" alt="" width="10" height="10" class="bt_down" />
                        <input type="text" name="num" value="0" id="" class="num" size="1"/>
                        <img src="/siktam/resources/images/rightArrow.png" alt="" width="10" height="10" class="bt_up"/>
                    </td>
                </tr>

                <tr>
                    <td><img src="/siktam/resources/images/04.png" style="width:100px" alt="Image" class="img-thumbnail"></td>
                    <td>간짜장</td>
                    <td>5000원</td>
                    <td>
                        <img src="/siktam/resources/images/leftArrow.png" alt="" width="10" height="10" class="bt_down" />
                        <input type="text" name="num" value="0" id="" class="num" size="1"/>
                        <img src="/siktam/resources/images/rightArrow.png" alt="" width="10" height="10" class="bt_up"/>
                    </td>
                </tr>
            </table>
        </div>
        </div>

        <div id="result1">
            <p><span class="glyphicon glyphicon-check"></span> 주문표</p>
            <div id="result2">
                <div id="result3">
                    <table id="resultTable">
                        <tr>                            
                            <td>후라이드 치킨</td>
                            <td>5000원</td>
                        </tr>
                        <tr>                            
                            <td>후라이드 치킨</td>
                            <td>5000원</td>
                        </tr>
                        
                        <tr>                            
                            <td>후라이드 치킨</td>
                            <td>5000원</td>
                        </tr>
                        
                        <tr>                            
                            <td>콤비네이션 피자</td>
                            <td>5000원</td>
                        </tr>
                        
                        <tr>                            
                            <td>콤비네이션 피자</td>
                            <td>5000원</td>
                        </tr>

                        <tr>                            
                            <td>콤비네이션 피자</td>
                            <td>5000원</td>
                        </tr>
                    </table>
                </div>
                
                <div id="result5">
                    <table id="tblSum">
                        <tr>
                            <td>결제 금액</td>
                            <td>30000원</td>
                        </tr>
                    </table>
                </div>

                <div id="result4">
                    <input type="submit" value="변경" id="btnSubmit" class="btn">
                    <input type="reset" value="취소" id="btnReset" class="btn" onclick="test1();">
                </div>

                
            </div>
        </div>
    </div>
    </form>


    <!-- 메뉴 수량 -->
    <script>
        $(function(){ 
            $('.bt_up').click(function(){ 
                var n = $('.bt_up').index(this);
                var num = $(".num:eq("+n+")").val();
                num = $(".num:eq("+n+")").val(num*1+1); 
            });
            $('.bt_down').click(function(){ 
                var n = $('.bt_down').index(this);
                var num = $(".num:eq("+n+")").val();
                if(parseInt(num) > 0){
                    num = $(".num:eq("+n+")").val(num*1-1); 
                }
            });
        }); 

        function test1(){
            if(confirm("정말 취소 하시겠습니까?\n(취소시 주문 내역은 삭제 됩니다)")){
                location.href='mypagePerson_5.jsp';
            }
        };

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
