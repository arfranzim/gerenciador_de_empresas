<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
	Bem vindo ao nosso gerenciador de empresas!<br/>
	
<c:if test="${not empty usuarioLogado}">
	Logado como ${usuarioLogado.email}<br/>
</c:if>


<form action="executa" method="post">
	<input type="hidden" name="tarefa" value="NovaEmpresa" />
	Nome: <input type="text" name="nome" /><br/>
	<input type="submit" value="Enviar" />
</form>

<form action="executa" method="post">
	<input type="hidden" name="tarefa" value="Login"/>
   	Email: <input type="text" name="email" /><br />
   	Senha: <input type="password" name="senha" /><br />
   	<input type="submit" value="Login" />
</form>

<form action="executa" method="post">
	<input type="hidden" name="tarefa" value="Logout"  />
	<input type="submit" value="Deslogar" />
</form>

</body>
</html>