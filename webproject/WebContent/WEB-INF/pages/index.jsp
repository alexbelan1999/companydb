<%@ page %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui" %>
<ui:html>
	<h1>Registration</h1>
	<form action="hello.html" method="POST">
  	<div class="form-group">
  		<label for="surname">Your surname: </label>
    	<input type="text" name="sname" placeholder="Enter surname"><br>
    	<label for="name">Your name: </label>
    	<input type="text" name="pname" placeholder="Enter name"><br>
    	<label for="patronymic">Your patronymic: </label>
    	<input type="text" name="patronymic" placeholder="Enter patronymic"><br>
    	<label for="age">Your age: </label>
    	<input type="number" name="age" placeholder="Enter age"><br>
    	<label for="sex">Your sex: </label>
    	<p><input type="radio" name="sex" value="Male"> Male<Br>
   		<input type="radio" name="sex" value="Female"> Female<Br></p>
   		<label for="email">Your email: </label>
    	<input type="email" name="email" placeholder="Enter email">
  	</div>
  	<ui:submit></ui:submit>
	</form>
</ui:html>
