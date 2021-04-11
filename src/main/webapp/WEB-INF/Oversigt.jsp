<%--
  Created by IntelliJ IDEA.
  User: thorb
  Date: 10-04-2021
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Oversigt</title>
</head>
<body>

<h1>Oversigt over emner </h1>



Du har selv tilføjet følgende elementer:
<c:forEach items="${sessionScope.emneListe}" var="element">
    <br>
    ${element}

</c:forEach>

    <br>
    <br>

her kan du se emner alle brugere har tilføjet
<c:forEach items="${applicationScope.emneListeContext}" var="fælleselement">
    <br>
    ${fælleselement}


</c:forEach>
    <br>
<h2>Fjern et emne fra listen </h2>
<form action="FjernEmne" method="post">
    <input type="text" id="fjernemne" name="fjernemne" value=""><br>
    <input type="submit" value="Fjern emne">

</form>


</body>
</html>
