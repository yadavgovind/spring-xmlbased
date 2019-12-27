
 
 
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	/* $("#managerclientMenu").addClass("active"); */
</script>
</head>
<body>
		<div>
			<a href="javascript:void(0)" class="btn btn-info pull-left   newuser"><i class="ico-plus "></i>User</a>
		</div>
		<br>
		<hr>
		
			<table class="table dynatable table-bordered" border="0"
				id="user_table">
				<thead>
					<tr>
						 <th>User Name</th> 
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
	
<!-- edit User Modal Dailog Starts -->
	<div class="modal width35 fade " id="user_dialog" tabindex="-1" role="dialog">
	
	  <div class="modal-dialog">
	   <div class="modal-content">
	    <div class="modal-header">
	       <button type="button" class="close" data-dismiss="modal" id="crosh" aria-hidden="true">&times;</button>
	       <h4 class="modal-title">Add/Edit User</h4>
	    </div>
	    <div class="modal-body pb0">
	      <form class="form-horizontal" id="frmUser"  name="frmUser" >
		      <table width="100%" height="100%" cellpadding="1">
		            
		        <tr class="control-group" id="usernametr">   
				   <td class="control-label">User Name :</td>
				   <td class="controls">
				        <input type="hidden"  id="userid" name="user"/> 
						<input class="form-control required ml10" type="text" id="userName" name="userName" placeholder=" User Name" minlength="4" />
					</td> 
				</tr> 
				 
				<tr class="control-group">
				   <td class="control-label">First Name :</td>
				   <td class="controls">
						<input class="form-control required ml10" type="text" id="firstName" name="firstName" placeholder=" First Name" />
					</td>
				</tr>
				<tr class="control-group">
				   <td class="control-label">Last Name : </td>
				   <td class="controls">
						<input class="form-control required  ml10" type="text" id="lastName" name="lastName" placeholder=" Last Name"/>
					</td>
				</tr>
		        
				<tr class="control-group">
				   <td class="control-label">Email :</td>
				   <td class="controls">
						<input type="text" class="form-control required email ml10" id="emailId" name="emailId" placeholder=" Email"/>
					</td>
				</tr> 
				
				<tr class="control-group">   
				   <td class="control-label">Password : </td>
				   <td class="controls">
						<input class="form-control ml10" type="password" id="txtPassword" name="txtPassword"  />
					</td>
				</tr>
				<tr class="control-group">   
				   <td class="control-label">Confirm Password : </td>
				   <td class="controls">
						<input class="form-control ml10" type="password" id="txtconfirmpassword" name="txtconfirmpassword"  />
					</td>
				</tr>
				<tr class="control-group"> 
				   <td class="control-label">Status : </td>
				   <td class="controls">
						<select id="ddlStatus" style="width: 156px;" class="ml10" >
							<option value="true" >Enabled</option>
							<option value="false">Disabled</option>
						</select>
					</td>
				</tr>
				<tr class="control-group">
				   <td class="control-label">About me : </td>
				   <td class="controls">
						<input type="text" class="form-control required  ml10" id="about_me" name="aboutme" placeholder=" About me"/>
					</td>
				</tr> 
				<tr class="control-group">
				   <td class="control-label">Pic : </td>
				   <td class="controls">
						<input type="file" class="form-control required  ml10" id="pic_id" name="pic"/>
					</td>
				</tr> 
				</table>
				</form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" id="btnCloseUser" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary"  id="btnUpdateUser">Update</button>
		      <button type="button" class="btn btn-primary"  id="btnSaveUser">Save</button>
		      </div>                       
	     </div>
	  </div>
	 </div>
<!-- Edit User Modal Dialog Ends -->
<!--delete bloger-->
<div class="modal fade" id="delete_user_modal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
				<h4 class="modal-title">Delete Blog</h4>
			</div>
			<div class="model_body">
				<center>
					<div class="m">Are you sure to delete this blog.</div>
				</center>
			</div>
			<div class=" modal-footer">
				<input type="button" name="btndeleteuser" id="btndeleteuser" value="OK">
				<input type="button" value="cancel" data-dismiss="modal">
			</div>
		</div>
	</div>
</div>
<!-- == delete dialog box start == -->
</body>
</html>
 
 
