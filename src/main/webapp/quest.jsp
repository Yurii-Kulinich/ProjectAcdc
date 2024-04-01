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
      .button-container {
        display: flex; /* Use flexbox layout */
        justify-content: space-evenly; /* Distribute space evenly between buttons */

      }
      .button-container button {
        margin-right: 10px; /* Add some margin between buttons */
      }
    </style>
</head>
<body>
<c:if test="${not empty requestScope.description}">

  <div>
    ${requestScope.description}
      <!-- Button to /quest servlet -->
        <div class="button-container">
            <!-- Button to /quest servlet -->
            <form action="${pageContext.request.contextPath}/quest" method="get">
                <input type="hidden" name="questId" value="1">
                <input type="hidden" name="stageId" value="1">
                <button type="submit">Go to Quest</button>
            </form>

            <!-- Button to /start servlet -->
            <form action="/start?questId=1" method="get">
                <button type="submit">Start</button>
            </form>
        </div>
  </div>

</c:if>
<c:if test="${empty requestScope.description}">
<h1>${requestScope.question.text}</h1>
    <ul>
    <c:forEach var="answer" items="${requestScope.question.answers}">
        <li>${answer.text}</li>
    </c:forEach>
    </ul>
</c:if>
</body>
</html>
