<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title></title>
<!-- Bootstrap Core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/blog-post.css" rel="stylesheet">

<tiles:useAttribute name="cssitems" />
<c:forEach var="href" items="${cssitems}">
	<link type="text/css" rel="stylesheet" href="${href}" />
</c:forEach>
</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Start Bootstrap</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="category.html">Category</a></li>
			<li><a href="blog.html">Blog</a></li>
					<li><a href="user.html">User</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

	<!-- Page Content -->
	<div class="container">
		<!-- /.row -->
   <tiles:insertAttribute name="body" />
		<hr>

		<!-- Footer -->

		<div class="row">
			<div class="col-lg-12">
				<p>Copyright &copy; Your Website 2015</p>
			</div>
		</div>
		<!-- /.row --> </footer>

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<!-- Bootstrap Core JavaScript -->
	<script src="../js/jquery.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	
  <tiles:useAttribute name="jsitems" />
  
	<c:forEach var="src" items="${jsitems}">
		<script type="text/javascript" src="${src}"></script>
	</c:forEach>
</body>

</html>
