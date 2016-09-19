<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Сообщения</title>
    <link rel="stylesheet" href=href="<%=request.getContextPath()%>/css/myStyles.css/>
</head>
<body>
<div id="allUsers">
    <c:forEach items="${userJSP}" var="user">
        <div class="user">
                ${user};
        </div>
        <div id="allUserMessages">
            <c:forEach items="${user.getMessagesById()}" var="message">
                <div class="message">
                        ${message};
                </div>
            </c:forEach>
        </div>
    </c:forEach>
</div>
</body>
</html>