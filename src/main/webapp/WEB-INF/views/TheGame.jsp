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

<h3>Active player:</h3>
<h3 ><c:if test="${activePlayer==1}">${game.xplayer}</c:if><c:if test="${activePlayer==0}">${game.oplayer}</c:if></h3>
<p id="actPlayer" style="visibility: hidden">${activePlayer}</p>

<table class="table table-bordered">
    <thead>
    <tr>
        <th scope="col" colspan="3">Plansza gry!</th>
    </tr>
    <tr>
        <td><button id="00">_</button></td>
        <td><button id="01">_</button></td>
        <td><button id="02">_</button></td>
    </tr>
    <tr>
        <td><button id="10">_</button></td>
        <td><button id="11">_</button></td>
        <td><button id="12">_</button></td>
    </tr>
    <tr>
        <td><button id="20">_</button></td>
        <td><button id="21">_</button></td>
        <td><button id="22">_</button></td>
    </tr>
    </thead>
</table>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>

<script src="${pageContext.request.contextPath}/js/OnClick.js" type="text/javascript"></script>

</body>
</html>
