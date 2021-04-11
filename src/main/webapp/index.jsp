<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1> "Velkommen til index side!" </h1>
<br/>

<h2>Her kan du oprette dig som bruger</h2>
${requestScope.msg}
<form action="hello-servlet" method="post">
    <label for="navn">Navn:</label><br>
    <input type="text" id="navn" name="navn" value="John"><br>

    <label for="password">password:</label><br>
    <input type="password" id="password" name="password" ><br><br>

    <label for="password2">password2:</label><br>
    <input type="password" id="password2" name="password2" ><br><br>



    <input type="submit" value="Submit">
</form>





<a href="hello-servlet">Hello Servlet</a>
</body>
</html>