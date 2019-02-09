<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Table</title>
</head>
<body>
<table>
    <c:forEach items="${data}" var="row">
        <tr>
            <c:forEach items="${row}" var="cell">
                <td>${cell}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>