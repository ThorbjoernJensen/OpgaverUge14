<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1> "Velkommen til index" </h1>
<br/>

<h2>Her kan du logge ind </h2>
${requestScope.loginBesked}
<form action="LoginServlet" method="get">
    <label for="navn">navn:</label><br>
    <input type="text" id="navn" name="navn" value=""><br>

    <label for="password">password:</label><br>
    <input type="password" id="password" name="password"><br><br>

    <input type="submit" value="login">
</form>


<h2>Eller opret dig som ny bruger</h2>
${requestScope.messageNyBruger}
<form action="LoginServlet" method="post">
    <label for="nytbrugernavn">navn:</label><br>
    <input type="text" id="nytbrugernavn" name="nytbrugernavn" value=""><br>

    <label for="nytpassword">password:</label><br>
    <input type="password" id="nytpassword" name="nytpassword" ><br>

    <label for="nytpassword2">gentag password:</label><br>
    <input type="password" id="nytpassword2" name="nytpassword2" ><br><br>

    <input type="submit" value="opret bruger">
</form>

</body>
</html>