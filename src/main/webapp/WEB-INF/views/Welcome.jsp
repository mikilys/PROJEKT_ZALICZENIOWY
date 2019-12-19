<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%> <%@ taglib prefix = "c" uri =
        "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Welcome</title>
</head>
<body>

<H2>Witamy w grze!</H2>
<br/>
<hr/>
<br/>

<form method="post" action="/">
    X player name: <input type="text" name="Xplayer">
    O player name: <input type="text" name="Oplayer">
    <input type="submit" value="Rozpocznij grę!">
</form>

<br/>
<hr/>
<br/>
<p align="right" ><font size="1">...by mikilys...</font></p>

</body>
</html>
