<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>admin mode</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="/siktam/resources/css/admin_4.css">

  <style>
  </style>
</head>
<body style="height:1080px">

<%@ include file="common/admin_header.jsp" %>

<div class="container" style="margin-top:50px">
  <div class="title">
    <h1><b>업체등록 관리</b></h1>
  </div>

  <div class="pagesearch">
    <div class="search">
      <input class="form-control input-lg" id="inputlg" type="text">
      <button style="border-radius: 6px;" ><span class="glyphicon glyphicon-search" style="color: white; font-size: 18px;"></span></button>
    </div>
    <div class="page">
      <ul class="pagination">
        <li class="active"><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li><a href="#">6</a></li>
        <li><a href="#">7</a></li>
        <li><a href="#">8</a></li>
        <li><a href="#">9</a></li>
        <li><a href="#">></a></li>
        <li><a href="#">>></a></li>
      </ul>
    </div>
    <!-- class page -->
  </div>

  <div class="tbl">
    <table class="table table-hover">
      <tr>
        <th>매장명</th>
        <th>주소</th>
        <th>전화번호</th>
        <th>사업자 등록번호</th>
        <th>영업시간</th>
        <th>카테고리</th>
        <th></th>
      </tr>
      <tr>
        <td>역전우동 0410</td>
        <td>서울시 강남구</td>
        <td>02-553-2111</td>
        <td>000-00-0000</td>
        <td>am10:00 ~ pm10:00</td>
        <td>일식,프랜차이즈</td>
        <td align="right">
  
          <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modmember">수락</button>

    
          <div id="modmember" class="modal fade" role="dialog">
            <div class="modal-dialog">

              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title">업체 수정</h4>
                </div>
                <div class="modal-body">
                  <p>업체정보를 수정하시겠습니까?</p>
                  <table class="modal-tbl">
                    <tr>
                      <td>매장명</td>
                      <td><input type="text" value="역전우동 0410" disabled></td>
                    </tr>
                    <tr>
                      <td>주소</td>
                      <td><input type="text" value="서울시 강남구"></td>
                    </tr>
                    <tr>
                      <td>전화번호</td>
                      <td><input type="text" value="02-553-2111"></td>
                    </tr>
                    <tr>
                      <td>사업자 등록번호</td>
                      <td><input type="text" value="000-00-0000"></td>
                    </tr>
                    <tr>
                      <td>영업시간</td>
                      <td><input type="text" value="am10:00 ~ pm10:00"></td>
                    </tr>
                    <tr>
                      <td>카테고리</td>
                      <td><input type="text" value="일식,프랜차이즈"></td>
                    </tr>
                  </table>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-danger" data-dismiss="modal">네</button>
                  <button type="button" class="btn btn-danger" data-dismiss="modal">아니요</button>
                </div>
              </div>

            </div>
          </div>

          <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delmember">거절</button>

          <!-- Modal -->
          <div id="delmember" class="modal fade" role="dialog">
            <div class="modal-dialog">

              <!-- Modal content-->
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title">업체 삭제</h4>
                </div>
                <div class="modal-body">
                  <p>해당 회원을 삭제하시겠습니까?</p>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-danger" data-dismiss="modal">네</button>
                  <button type="button" class="btn btn-danger" data-dismiss="modal">아니요</button>
                </div>
              </div>

            </div>
          </div>
        </td>
      </tr>
      <tr>
        <td>역전우동 0410</td>
        <td>서울시 강남구</td>
        <td>02-553-2111</td>
        <td>000-00-0000</td>
        <td>am10:00 ~ pm10:00</td>
        <td>일식,프랜차이즈</td>
        <td align="right">
  
          <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modmember">수락</button>

    
          <div id="modmember" class="modal fade" role="dialog">
            <div class="modal-dialog">

              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title">회원 수정</h4>
                </div>
                <div class="modal-body">
                  <p>회원정보를 수정하시겠습니까?</p>
                  <table class="modal-tbl">
                    <tr>
                      <td>아이디</td>
                      <td><input type="text" value="hansol" disabled></td>
                    </tr>
                    <tr>
                      <td>비밀번호</td>
                      <td><input type="text" value="123123"></td>
                    </tr>
                    <tr>
                      <td>주소</td>
                      <td><input type="text" value="경기도 안양시"></td>
                    </tr>
                    <tr>
                      <td>이름</td>
                      <td><input type="text" value="장한솔"></td>
                    </tr>
                    <tr>
                      <td>주민번호</td>
                      <td><input type="text" value="891222-1******"></td>
                    </tr>
                    <tr>
                      <td>휴대폰번호</td>
                      <td><input type="text" value="010-8947-7489"></td>
                    </tr>
                  </table>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-danger" data-dismiss="modal">네</button>
                  <button type="button" class="btn btn-danger" data-dismiss="modal">아니요</button>
                </div>
              </div>

            </div>
          </div>

          <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delmember">거절</button>

          <!-- Modal -->
          <div id="delmember" class="modal fade" role="dialog">
            <div class="modal-dialog">

              <!-- Modal content-->
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title">회원 삭제</h4>
                </div>
                <div class="modal-body">
                  <p>해당 회원을 삭제하시겠습니까?</p>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-danger" data-dismiss="modal">네</button>
                  <button type="button" class="btn btn-danger" data-dismiss="modal">아니요</button>
                </div>
              </div>

            </div>
          </div>
        </td>
      </tr>
      <tr>
        <td>역전우동 0410</td>
        <td>서울시 강남구</td>
        <td>02-553-2111</td>
        <td>000-00-0000</td>
        <td>am10:00 ~ pm10:00</td>
        <td>일식,프랜차이즈</td>
        <td align="right">
  
          <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modmember">수락</button>

    
          <div id="modmember" class="modal fade" role="dialog">
            <div class="modal-dialog">

              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title">회원 수정</h4>
                </div>
                <div class="modal-body">
                  <p>회원정보를 수정하시겠습니까?</p>
                  <table class="modal-tbl">
                    <tr>
                      <td>아이디</td>
                      <td><input type="text" value="hansol" disabled></td>
                    </tr>
                    <tr>
                      <td>비밀번호</td>
                      <td><input type="text" value="123123"></td>
                    </tr>
                    <tr>
                      <td>주소</td>
                      <td><input type="text" value="경기도 안양시"></td>
                    </tr>
                    <tr>
                      <td>이름</td>
                      <td><input type="text" value="장한솔"></td>
                    </tr>
                    <tr>
                      <td>주민번호</td>
                      <td><input type="text" value="891222-1******"></td>
                    </tr>
                    <tr>
                      <td>휴대폰번호</td>
                      <td><input type="text" value="010-8947-7489"></td>
                    </tr>
                  </table>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-danger" data-dismiss="modal">네</button>
                  <button type="button" class="btn btn-danger" data-dismiss="modal">아니요</button>
                </div>
              </div>

            </div>
          </div>

          <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delmember">거절</button>

          <!-- Modal -->
          <div id="delmember" class="modal fade" role="dialog">
            <div class="modal-dialog">

              <!-- Modal content-->
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title">회원 삭제</h4>
                </div>
                <div class="modal-body">
                  <p>해당 회원을 삭제하시겠습니까?</p>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-danger" data-dismiss="modal">네</button>
                  <button type="button" class="btn btn-danger" data-dismiss="modal">아니요</button>
                </div>
              </div>

            </div>
          </div>
        </td>
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
    </table>
  </div>
  <!-- class tbl -->

</div>
<!-- class container -->

</body>
</html>
    