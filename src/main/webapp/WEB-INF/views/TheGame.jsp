<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%> <%@ taglib prefix = "c" uri =
        "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Akatsuki!</title>

    <link href="${pageContext.request.contextPath}/styles/styles.css" rel="stylesheet" type="text/css">

</head>
<body>

<table class="table table-bordered">
    <thead>
    <tr>
        <th scope="col" colspan="9">Plansza gry!</th>
    </tr>

    <c:forEach begin="0" end="8" step="1" varStatus="i">
    <tr>
        <c:forEach begin="0" end="8" step="1" varStatus="j">
            <td>
                <button x="${i.index}" y="${j.index}">_</button>
            </td>
        </c:forEach>
    </tr>
    </c:forEach>
    </thead>
</table>

<script src="${pageContext.request.contextPath}/js/OnClick.js" type="text/javascript"></script>

</body>
</html>
