<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="icon" type="image/x-icon" href="/img/icon_logo.png">
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Title</title>
</head>

<body>
<div class="QnAContainer" id="QnAContainer">
    <h2>제품문의</h2>
    <table class="QnATable" name="QnATable">
        <thead>
        <tr>
            <th class="number">번호</th>
            <th class="title">제목</th>
            <th class="writer">작성자</th>
            <th class="regdate">등록일</th>
            <th class="status">상태</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="inq" items="${pageList}">
            <tr>
                <td><span>${inq.inq_id}</span></td>
                    <%--                <td>${inqDto.inq_title}</td>--%>
                <td><a href="/product/read?pd_id=${pd_id}&inq_id=${inq.inq_id}">${inq.inq_title}</a></td>
                <td>${inq.c_name}</td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${inq.inq_dt}"/></td>
                <td>답변대기중</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <c:if test="${ph.showPrev}">
        <a href="<c:url value='/product/detail?page=${ph.beginPage-1}&pageSize=${ph.pageSize}&pd_id=${pd_id}'/>&lt</a>
        </c:if>
    <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
        <a href="<c:url value='/product/detail?page=${i}&pageSize=${ph.pageSize}&pd_id=${pd_id}'/>">${i}</a>
        </c:forEach>
        <c:if test="${ph.showNext}">
        <a href="<c:url value='/product/detail?page=${ph.endPage+1}&pageSize=${ph.pageSize}&pd_id=${pd_id}'/>&gt</a>
    </c:if>

    <button type=" button" id="wBtn" class="writeQnABtn">문의작성</button>
    </div>
</div>
<script>
    $(document).ready(function () {
        $('#wBtn').on("click", function () {
            location.href = "<c:url value='/product/inqWrite'/>?pd_id=${pd_id}";
        })
    })
</script>
</body>
</html>