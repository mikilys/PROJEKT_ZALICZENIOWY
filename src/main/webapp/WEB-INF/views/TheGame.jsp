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
<div class="container">
    <div class="row justify-content-start">

        <div class="col-4">
            <h3>Active player: <c:if test="${activePlayer==1}">${game.xplayer}</c:if><c:if test="${activePlayer==0}">${game.oplayer}</c:if></h3>
            <p id="actPlayer" style="visibility: hidden">${activePlayer}</p>
            <hr/>
            <br/>
        </div>
        <div class="col-4">
            <p style="visibility: hidden" id="gameId">${game.id}</p>
        </div>

        <div class="row justify-content-center">
            <div class="col-4">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col" colspan="3">Plansza gry!</th>
                    </tr>
                    <tr>
                        <td><button data-x="0" data-y="0" id="00"> </button></td>
                        <td><button id="01"> </button></td>
                        <td><button id="02"> </button></td>
                    </tr>
                    <tr>
                        <td><button id="10"> </button></td>
                        <td><button id="11"> </button></td>
                        <td><button id="12"> </button></td>
                    </tr>
                    <tr>
                        <td><button id="20"> </button></td>
                        <td><button id="21"> </button></td>
                        <td><button id="22"> </button></td>
                    </tr>
                    </thead>
                </table>
            </div>
            <div class="col-4">
                <%--miejsce na dużą planszę--%>
            </div>
        </div>

    </div>
    <br/>
    <hr/>
    <br/>
    <p align="right" ><font size="1">...by mikilys...</font></p>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>

<script src="${pageContext.request.contextPath}/js/OnClick.js" type="text/javascript"></script>

</body>
</html>
