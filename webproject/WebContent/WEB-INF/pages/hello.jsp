<%@ page %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui" %>
<ui:html>
	<h1>Hello, ${param.sname} ${param.pname} ${param.patronymic}!</h1><br>
	<h1>Info:</h1><br>
	<h1>Age: ${param.age }</h1><br>
	<h1>Sex: ${param.sex }</h1><br>
	<h1>Email: ${param.email }</h1>
</ui:html>

