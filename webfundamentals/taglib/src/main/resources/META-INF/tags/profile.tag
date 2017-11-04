<%@tag body-content="empty"%>
<%@attribute name="user" required="true" type="com.chvrg.User" %>

<table class="table table-centered">
	<tr>
		<td>Name: </td>
		<td>${user.name}</td>
	</tr>
	<tr>
		<td>email: </td>
		<td>${ user.email }</td>
	</tr>
</table>