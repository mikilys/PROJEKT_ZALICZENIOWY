<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%> <%@ taglib prefix = "c" uri =
        "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Winner of this odd game!</title>
</head>
<body>

    <h2 id="winnerPlayerH3">And the winner is: ${winnerPlayer}!</h2>
    <br/>
    <hr/>
    <br/>
    <a href="../"><input type="button" value="New game" name="new game"/></a>
    <br/>
    <br/>
    <hr/>
    <br/>
    <p align="right" ><font size="1">...by mikilys...</font></p>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>

</body>
</html>
