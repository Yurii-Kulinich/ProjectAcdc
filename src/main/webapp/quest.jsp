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
</head>
<body>
<c:if test="${not empty requestScope.description}">

  <div>
    ${requestScope.description}
  </div>

</c:if>
<ul>
  <c:forEach var="question" items="${requestScope.questions}">
    <li>
      <span>${question.text}</span>
      <ul>
        <c:forEach var="answer" items="${question.answers}">
          <li>
            <span>${answer.text}</span>
          </li>
        </c:forEach>
      </ul>
    </li>
  </c:forEach>
</ul>
</body>
</html>
