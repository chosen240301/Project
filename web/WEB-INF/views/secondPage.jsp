<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Second Page</title>
</head>
<body>
<c:forEach items="${messageJSP}" var="item">
    ${item};<br>
</c:forEach>
</body>
</html>