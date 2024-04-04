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
    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        margin: 0;
        padding: 0;
        text-align: center;
      }

      ul {
        list-style-type: none;
        padding: 0;
      }

      li {
        margin-bottom: 10px;
      }

      a {
        text-decoration: none;
        color: #007bff;
        transition: color 0.3s ease;
      }

      a:hover {
        color: #0056b3;
      }

      .menu {
        list-style: none;
        padding: 0;
        margin: 0;
      }

      .menu-item {
        color: #333;
        text-decoration: none;
        background: #f9f9f9;
        border: 1px solid #ccc;
        padding: 20px 30px;
        display: block;
        margin-bottom: 10px;
        border-radius: 10px;
        transition: background-color 0.3s ease, transform 0.2s ease;
      }

      .menu-item:hover {
        background-color: #e0e0e0;
        transform: translateY(-3px);
      }

      h1.welcome-heading {
        color: #2760a3;
        margin-top: 30px;
        font-size: 20px;
        font-weight: bold;
      }
    </style>
</head>
<body>
<h1 class="welcome-heading">Welcome</h1>
<ul class="menu">
    <c:forEach var="quest" items="${requestScope.quests}">
        <li>
            <a class="menu-item" href="/quest?questId=${quest.id}&stageId=0">${quest.name}</a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
