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

                    <script>
                        let msg = "${msg}";
                        if(msg=="WRT_ERR") alert("등록에 실패하였습니다.")
                    </script>
                    <div class="readpage">
                        <h1>게시판 ${mode=="new" ? "글쓰기" : "읽기"}</h1>
                        <form action="/ch3/board/board" id="form">
                            <input name="bno" type="hidden" value="${boardDto.bno}" readonly="readonly" >
                            <input name="title" type="text" value="${boardDto.title}" placeholder="제목을 입력해 주세요" ${mode=="new" ? '' :'readonly="readonly"'}/>
                            <textarea name="content" rows="20" cols="100" placeholder="내용을 입력해 주세요" ${mode=="new" ? '' :'readonly="readonly"'}>${boardDto.content}</textarea>
                            <div>
                                <button type="button" id="writeBtn">글쓰기</button>
                                <button type="button" id="modifyBtn">수정</button>
                                <button type="button" id="deleteBtn">삭제</button>
                                <button type="button" id="listBtn">목록</button>
                            </div>
                        </form>
                    </div>

                    <table summary="">
                        <caption>게시판 ${mode=="new" ? "작성" : "읽기"}</caption>
                        <colgroup>
                            <col width="95" />
                            <col width="190" />
                            <col width="90" />
                            <col />
                        </colgroup>
                        <tbody>
                        <form action="/product/inqWrite" id="inqform">
                        <tr>
                            <th><div>NAME</div></th>
                            <td>
                                <div>
                                    <input type='hidden' name='c_name' value="${inqDto.c_id}"  />
                                    <input id='inq_bw_input_writer' type='text' name='c_name' value=""  class="inq_MS_input_txt input_style"  />
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
                                    <input id='inq_bw_input_subject'  class="inq_MS_input_txt inq_input_style2" type='text' name='subject'  placeholder="내용을 입력해 주세요" ${mode=="new" ? '' :'readonly="readonly"'}>
<%--                                    <input type='checkbox' name='tag' value='ok'  /> HTML태그 허용<br>--%>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <div>CONTENT</div>
                            </th>
                            <td colspan="3">
                                <div>
                                    <textarea id='inq_MS_text_content' name='content' wrap="off" onfocus='clear_content()'  class="inq_MS_input_txt" style='font-family:굴림체;'    placeholder="내용을 입력해 주세요" ${mode=="new" ? '' :'readonly="readonly"'}>${inqDto.inq_content}</textarea>
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
                        </form>
                        </tbody>
                    </table>
                </fieldset>

                <div class="inq_bbs-link-btm">
                    <button class="inq_button02-wh" type="button" id="writeBtn">글쓰기</button>
<%--                    <button class="inq_button02-wh" type="button" id="modifyBtn">수정</button>--%>
<%--                    <button class="inq_button02-wh" type="button" id="deleteBtn">삭제</button>--%>
<%--                    <button class="inq_button02-wh" type="button" id="listBtn">목록</button>--%>
                </div>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function(){
            $('#listBtn').on("click", function(){
                alert("listBtn click")
                location.href="<c:url value="product/inqWrite"/>";
            })
        })

        $('#writeBtn').on("click", function (){
            let form = $('form');
            form.attr("action", "<c:url value='/product/inqWrite'/>");
            form.attr("metod", "post");
            form.submit();
        })
    </script>
</body>

<jsp:include page="footer.jsp"/>
</html>
