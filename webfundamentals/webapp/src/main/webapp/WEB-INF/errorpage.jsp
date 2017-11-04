<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Page</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/metro.min.css" rel="stylesheet">
</head>
<body>
	<h2>Error Page</h2>
	<%= exception.getMessage() %>
	<%= exception.printStackTrace() %>
</body>
</html>