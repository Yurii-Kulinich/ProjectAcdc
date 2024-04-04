<%--
  Created by IntelliJ IDEA.
  User: kulinichyr
  Date: 31/03/2024
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        margin: 0;
        padding: 0;
        text-align: center;
      }

      .button-container {
        display: flex;
        justify-content: center;
        margin-top: 20px;
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

      .button-container button {
        margin: 0 10px;
        padding: 20px 30px; /* Match padding with list items */
        background-color: #f9f9f9; /* Match background color with list items */
        color: #333; /* Match text color with list items */
        border: 1px solid #ccc;
        border-radius: 10px; /* Match border-radius with list items */
        cursor: pointer;
        transition: background-color 0.3s ease, transform 0.2s ease;
        font-size: 20px; /* Increase font size */
        font-weight: bold; /* Use bold font weight */
      }

      .button-container button:hover {
        background-color: #e0e0e0;
        transform: translateY(-3px);
      }

      h1.question-heading {
        color: #007bff; /* Text color */
        margin-top: 30px; /* Top margin */
        font-size: 24px; /* Font size */
        font-weight: bold; /* Font weight */
      }

      .message {
        font-size: 26px;
        margin-bottom: 10px;
      }

      .congrats-container {
        margin-top: 30px;
      }

      .congrats-message {
        font-size: 26px;
        margin-bottom: 10px;
      }

      .final-score {
        font-size: 24px;
        font-weight: bold;
        color: #007bff;
        margin-bottom: 20px;
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
<c:if test="${not empty requestScope.description}">

    <div>
        <h1 class="welcome-heading">
                ${requestScope.description}
        </h1>
        <div class="button-container">
            <!-- Button to /quest servlet -->
            <form action="${pageContext.request.contextPath}/quest" method="get">
                <input type="hidden" name="questId" value="1">
                <input type="hidden" name="stageId" value="1">
                <input type="hidden" name="score" value="0">
                <button type="submit">Go to Quest</button>
            </form>

            <!-- Button to /start servlet -->
            <form action="/start" method="get">
                <button type="submit">Start</button>
            </form>
        </div>
    </div>

</c:if>
<c:if test="${not empty requestScope.congrats}">
    <div class="congrats-container">
        <h1 class="welcome-heading">
                ${requestScope.congrats}
        </h1>
        <div class="final-score">
            Your final score is ${sessionScope.score}!
        </div>
        <div class="button-container">
            <!-- Button to restart quest -->
            <form action="${pageContext.request.contextPath}/quest" method="get">
                <input type="hidden" name="questId" value="1">
                <input type="hidden" name="stageId" value="0">
                <input type="hidden" name="score" value="0">
                <button type="submit">Restart Quest</button>
            </form>

            <!-- Button to go to quest selection -->
            <form action="/start" method="get">
                <button type="submit">To Quest Selection</button>
            </form>
        </div>
    </div>
</c:if>
<c:if test="${empty requestScope.description && empty requestScope.congrats}">
    <h1 class="welcome-heading">${requestScope.question.text}</h1>
    <ul class="menu">
        <c:forEach var="answer" items="${requestScope.question.answers}">
            <li>
            <li><a class="menu-item" href="/quest?stageId=${requestScope.stageId}&score=${answer.score}">${answer.text}</a>
            </li>
        </c:forEach>
    </ul>
</c:if>
</body>
</html>
