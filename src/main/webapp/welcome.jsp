<%--
  Created by IntelliJ IDEA.
  User: kulinichyr
  Date: 31/03/2024
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>test</title>
</head>
<body>
<h1>Welcome</h1>
<ul>
    <c:forEach var="quest" items="${requestScope.quests}">
        <li>
            <a href="/quest?questId=${quest.id}">${quest.name}</a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
