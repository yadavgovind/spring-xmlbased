<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
</script>
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
		Category Name:<input type="text" name="name" id="catName" /> <input
			type="submit" value="add " id="catadd" class="btn btn-sm btn-primary" />
	</div>
	<hr>
	<table
		class="table table-condensed table-striped table-bordered table-hover no-margin"
		id="category">
		<thead>
			<tr>
				<th>Category name</th>
				<th>update</th>
				<th>delete</th>
			</tr>
		</thead>
	</table>
	<div class="modal fade" id="category_modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">Edit category</h4>
				</div>

				<div class="modal-body">
					<label>Category Name</label> <input type="hidden" name="id"
						id="cat_id" /> <input type="text" name="name" id="edit_catName" />
					<input type="button" value="submit" id="editable_catName" /> <input
						type="button" value="cancel" data-dismiss="modal" />
				</div>

				<div class=" modal-footer">
					<!-- <button id="save-btn" class="btn btn-success" type="button">Log Activity</button> -->
				</div>
			</div>
		</div>
	</div>

	<!--delete bloger-->
	<div class="modal fade" id="delete_category_modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">Delete Category</h4>
				</div>
				<div class="model_body">
					<center>
						<div class="m">Are you sure to delete this category.</div>
					</center>
				</div>
				<div class=" modal-footer">
					<input type="button" name="btndeletecategory"
						id="btndeletecategory" value="OK" class="btn btn-sm btn-primary">
					<input type="button" value="cancel" data-dismiss="modal"
						class="btn btn-sm btn-primary">
				</div>
			</div>
		</div>
	</div>
	<!-- == delete dialog box start == -->
</body>
</html>