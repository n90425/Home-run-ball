<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <link rel="icon" type="image/x-icon" href="/img/icon_logo.png">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">

    <link href="<c:url value='/css/reset.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/inqWrite.css'/>" type="text/css" rel="stylesheet"/>

    <%--   다니님 header, footer --%>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" rel="stylesheet"/>
    <link href="<c:url value='/css/header.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/search.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/footer.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/css/nav.css'/>" type="text/css" rel="stylesheet"/>

<%-- jquery --%>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <title>QNA</title>
</head>
<jsp:include page="header.jsp"/>
<body class="inq">
    <div id="contentWrapper">
        <div id="contentWrap">
                <div class="inq_bbs-table-write" id="inq_content">
                <fieldset>
                    <table summary="">
                        <caption>게시판 글쓰기</caption>
                        <colgroup>
                            <col width="95" />
                            <col width="190" />
                            <col width="90" />
                            <col />
                        </colgroup>
                        <tbody>
                        <tr>
                            <th><div>NAME</div></th>
                            <td>
                                <div>
                                    <input id='inq_bw_input_writer' type='text' name='hname'  class="inq_MS_input_txt input_style"  />
                                </div>
                            </td>
                            <th><div></div></th>
                            <td>
                                <div>
                                    PASSWORD <input id='inq_bw_input_passwd' type='password' name='passwd'  class="inq_MS_input_txt input_style" />
                                    <font color="red">자동 잠금 기능</font>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <div>TITLE</div>
                            </th>
                            <td colspan="3">
                                <div class="inq_title">
                                    <input id='inq_bw_input_subject'  disabled='disabled'   class="inq_MS_input_txt inq_input_style2" type='text' name='subject' value='상품관련 문의 드립니다' />
                                    <input type='checkbox' name='tag' value='ok'  /> HTML태그 허용<br>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <div>CONTENT</div>
                            </th>
                            <td colspan="3">
                                <div>
                                    <textarea id='inq_MS_text_content' name='content' wrap="off" onfocus='clear_content()'  class="inq_MS_input_txt" style='font-family:굴림체;' ></textarea>
                                    <iframe frameborder="0" scrolling="no" src="SmartEditor2Skin.html?type=i&amp;clearw=Y&amp;writeword_use=N" style="width: 100%; height: 359px;"></iframe>
                                    <input type='hidden' name='mobile_content_type' value='' />
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <div>FILE</div>
                            </th>
                            <td colspan="3">
                                <div class="title">
                                    <input type='text'  class="inq_MS_input_txt input_style2" name='file_name1' value='' onfocus='this.blur();upalert()' /><a class="button04-s-wh" href="javascript:upload('file_name1');">파일첨부</a>
                                    <input type='text'  class="inq_MS_input_txt input_style2" name='file_name2' value='' onfocus='this.blur();upalert()' /><a class="button04-s-wh" href="javascript:upload('file_name2');">파일첨부</a>
                                    <input type='text'  class="inq_MS_input_txt input_style2" name='file_name3' value='' onfocus='this.blur();upalert()' /><a class="button04-s-wh" href="javascript:upload('file_name3');">파일첨부</a>
                                    <input type='text'  class="inq_MS_input_txt input_style2" name='file_name4' value='' onfocus='this.blur();upalert()' /><a class="button04-s-wh" href="javascript:upload('file_name4');">파일첨부</a>
                                </div>
                            </td>
                        </tr>

                        </tbody>
                    </table>
                </fieldset>

                <div class="inq_bbs-link-btm">
                    <a class="inq_button02-wh" href="JavaScript:send();">등록</a>
                    <a class="inq_button02-wh" href="/board/board.html?code=xexymix_board1&page=1&board_cate=&s_id=&stext=&ssubject=&scontent=&shname=&sbrand=&sgid=&branduid=2066959">목록보기</a>
                </div>
            </div>
        </div>
    </div>
</body>
<jsp:include page="footer.jsp"/>
</html>
