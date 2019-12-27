
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blog</title>

<style>
div.m {
	margin-top: 30px;
	margin-bottom: 30px;
	margin-right: 10px;
	margin-left: 10px;
}
</style>
</head>
<body>

	<div>
		<a href="newblog.html" class="btn btn-sm btn-primary addnewblog   catId=${catid }"><i
			class="ico-plus"></i> Add New Blog</a>
	</div>
	<hr>
	<table class="table dynatable table-bordered" border="0"
		id="blog_table_id">
		<thead>
			<tr>
				<th>Title</th>
				<th>Date</th>
				<th>user</th>
				<th>Content</th>
				<th>Meta Blog</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>


	
		<!--delete bloger-->
		<div class="modal fade" id="delete_blog_modal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">Delete Blog</h4>
					</div>
					<div class="model_body">
						<center>
							<div class="m">Are you sure to delete this blog.</div>
						</center>
					</div>
					<div class=" modal-footer">
						<input type="button" name="btndeleteblog" id="btndeleteblog"
							value="OK"> <input type="button" value="cancel"
							data-dismiss="modal">
					</div>
				</div>
			</div>
		</div>
		<!-- == delete dialog box start == -->
</body>
</html>