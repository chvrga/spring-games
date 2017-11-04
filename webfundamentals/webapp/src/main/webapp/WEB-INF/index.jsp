<!DOCTYPE html>
<%@page import="java.util.Calendar"%>
<%@page import="com.chvrg.User"%>
<%@page import="com.chvrg.ApplicationSettings"%>
<%@page import="com.chvrg.CssClass"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://chvrga.com/simple" prefix="m"%>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Bootstrap 101 Template</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>

</head>
<body>
	<%@include file="header.jsp"%>
	<%-- 	<c:import url="header.jsp" var="_header" /> --%>
	<%-- 	${ _header } --%>
	<section class="main container-fluid">
		<%
			Calendar calendar = Calendar.getInstance();
		%>
		<div class="container">
			<div class="row-fluid">
				<div class="col-sm-4">
					<h2>Home</h2>
					<c:out value="Hello world" />
					<br />
					<%=calendar.getTime().toString()%>
				</div>

				<div class="col-sm-8">
					<ul class="nav nav-tabs">
						<c:forEach items="${app.tabs}" var="onetab">
							<c:choose>
								<c:when test="${ onetab.url eq '#signin'  }">
									<li class="active"><a href="${ onetab.url }" data-toggle="tab">${ onetab.name }</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="${ onetab.url }" data-toggle="tab">${ onetab.name }</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>

					<div class="tab-content">
						<div class="tab-pane active" id="signin">
							<div class="${app.formClass.name}">
								<c:choose>
									<c:when test="${ !empty user.name }">
										<h2>Welcome ${user.name}!</h2>
									</c:when>
									<c:otherwise>
										<h2>Welcome who ever you are!</h2>
									</c:otherwise>
								</c:choose>
								<!-- 								<form action="home" method="post"> -->
								<!-- 									<p> -->
								<!-- 										Name: <input type="text" name="name" /> -->
								<!-- 									</p> -->
								<!-- 									<p> -->
								<!-- 										email: <input type="text" name="email" /> -->
								<!-- 									</p> -->
								<!-- 									<p> -->
								<!-- 										<input type="submit" value="Enter name" /> -->
								<!-- 									</p> -->
								<!-- 								</form> -->
							</div>
						</div>
						<div class="tab-pane" id="home">
							<m:priority user="${ user }">
								<jsp:attribute name="normalPriority">
									<li>
										<span>${ description }</span>
										<span>${ priority }</span>
									</li>
								</jsp:attribute>
								<jsp:attribute name="highPriority">
									<li class="bg-danger">
										<span>${ description }</span>
										<span>${ priority }</span>
									</li>								
								</jsp:attribute>
							</m:priority>
						</div>
						<div class="tab-pane" id="profile">
							<m:helloworld name="${ user.name }"></m:helloworld>
							<c:if test="${ !empty user.name }">
								<m:profile user="${ user }" />
							</c:if>
						</div>
						<div class="tab-pane" id="messages"></div>
						<div class="tab-pane" id="settings"></div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>


