<%--
  Created by IntelliJ IDEA.
  User: nbh
  Date: 06/04/2021
  Time: 10.52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1> velkomme du er nu logget ind !</h1>
Dit brugernavn er:
${requestScope.brugernavn}
</br>
Dit session-id er:
${requestScope.sessionId}

<form action="TilføjEmne" method="post">
    <label for="emne">Tilføj emne </label><br>
    <input type="text" id="emne" name="emne" value="nyt emne"><br>
    <input type="submit" value="Submit">

</form>
<br>
Du har nu tilføjet ${sessionScope.emneListeLængde} elementer

<c:forEach items="${sessionScope.emneListe}" var="element">
    ${element}
    <br>

</c:forEach>

<form action="TilføjEmne" method="get">

    <input type="submit" value="gå til oversigt">

</form>


<%--<%=request.getAttribute("brugernavn")%>   // scriptlets  nogo--%>

</body>
</html>
