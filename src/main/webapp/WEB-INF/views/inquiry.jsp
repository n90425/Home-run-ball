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

        <c:forEach var="inq" items="${inqList}">
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
    <p> <a href="">&lt</a>
        <a href="">1</a>
        <a href="">2</a>
        <a href="">3</a>
        <a href="">4</a>
        <a href="">5</a>
        <a href="">6</a>
        <a href="">7</a>
        <a href="">8</a>
        <a href="">9</a>
        <a href="">10</a>
        <a href="">&gt</a></p>
    <a href="/product/inqWrite?pd_id=${pd_id}" class="writeQnABtn">문의작성</a>
</div>
</body>
</html>