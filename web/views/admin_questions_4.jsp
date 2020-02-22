<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
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
    <h1><b>문의사항 관리</b></h1>
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
    <table class="table table-hover" id="tbl">
      <tr>
        <th colspan="2">제목</th>
        <th colspan="4">내용</thcolspan="4">
        <th></th>
      </tr>
      <tr>
        <td colspan="2">13cm 사이즈 재입고는 언제 되나요? 상품명 : [한국배송] 프리츠한센 이케바나 화병 3종 / Fritz hansen Ikebana Vases 
        </td>
        <td colspan="4" style="overflow: auto;">
          혜택가가 아니라도 좋습니다. 13cm 사이즈 재입고는 언제 되나요?
        </td>
        <td align="right">
          <a href="/siktam/resources/api/smarteditor/SmartEditor2Skin.html"><button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modmember">답변</button></a>
          <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delmember">삭제</button>
          <!-- Modal -->
          <div id="delmember" class="modal fade" role="dialog">
            <div class="modal-dialog">

              <!-- Modal content-->
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title">문의 삭제</h4>
                </div>
                <div class="modal-body">
                  <p>해당 답변을 삭제하시겠습니까?</p>
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
      
      <!-- 1행끝 -->

      <tr>
        <td colspan="2">설치문의 상품명 : [거울] [Schonbuch]View Mirror M (75_1281804) </td>
        <td colspan="4" style="overflow: auto;">
          설치도 해주시나요?

          이제품은 거는거와 기대세우는 거 다 가능한거죠?

          화면상에보이는 벽고리도 함께 제공되는건가요?
        </td>
        <td align="right">
          <a href="/siktam/resources/api/smarteditor/SmartEditor2Skin.html"><button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modmember">답변</button></a>
          <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delmember">삭제</button>

          <!-- Modal -->
          <div id="delmember" class="modal fade" role="dialog">
            <div class="modal-dialog">

              <!-- Modal content-->
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title">문의 삭제</h4>
                </div>
                <div class="modal-body">
                  <p>해당 문의를 삭제하시겠습니까?</p>
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
      <!-- 2행끝 -->

      <tr>
        <td colspan="2">문의있어요~ 
          상품명 : [천장후드] Luxus Deckenhaube 120cm/Aus Edelstahl/Inklusive Saugstarken  
          
        </td>
        <td colspan="4" style="overflow: auto;">
          천정에 붙어있으면 후드 작동은 리모컨으로 하는거죠?
          시공시 천정고 얼마나 필요한걸까요?
          시공하기위해 목공작업이 필요할까요?
          시공자 조인 부탁드려요
          지금 주문하면 언제 받을까요?
          맘이 급합니다

        </td>
        <td align="right">
          <a href="/siktam/resources/api/smarteditor/SmartEditor2Skin.html"><button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modmember">답변</button></a>
          <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delmember">삭제</button>

          <!-- Modal -->
          <div id="delmember" class="modal fade" role="dialog">
            <div class="modal-dialog">

              <!-- Modal content-->
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title">문의 삭제</h4>
                </div>
                <div class="modal-body">
                  <p>해당 답변을 삭제하시겠습니까?</p>
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
      <!-- 3행끝 -->
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
      </tr><tr>
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
    