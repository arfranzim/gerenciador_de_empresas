<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<c:if test="${not empty usuario}">
	Usuario: ${usuario.email}
</c:if>

<c:if test="${not empty resultado}">
	${resultado} <br/>
</c:if>


</body>
</html>