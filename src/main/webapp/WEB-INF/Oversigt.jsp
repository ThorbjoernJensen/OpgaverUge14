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
her kan du se alle de emner folk har tilføjet
<c:forEach items="${applicationScope.emneListeContext}" var="fælleselement">
    <br>
    ${fælleselement}


</c:forEach>
</body>
</html>
