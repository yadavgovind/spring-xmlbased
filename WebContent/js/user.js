var table=null;
$(function(){
	table =  $('#user_table').dataTable();
	getAllUser();
});
function saveUser(user)
{
	$.ajax({
		contentType : "application/json",
		processData : true,
		data : JSON.stringify(user),
		async : true,
		url : 'userRegistration.html',
		type : "GET",
		dataType : "json",
		cache : true,
		async : true,
		
		success : function(response){
			if(response.status==1){
				getAllUser(user);
				toastr.success("message reply successfully!");
			}
			else{
				toastr.E("message reply successfully!");
			}
		}
	});	
}


function getAllUser(){ 
$.ajax({
	contentType : "application/json",
	processData : true,
	url : 'getUser.html',
	type : "GET",
	dataType : "json",
	cache : false,
	async : true,	
	success : function(response){
		table.fnClearTable();
		$.each(response.data,function(index,row){
			addRow(row);
		});
	}
});	
}

function addRow(row){
table.fnAddData({
	"0":row.username,
	"1":row.firstName,
	"2":row.lastName,
	"3":row.email,
	"4":row.embded,
	"5":row.aboutMe,
	/*"6": "<input type='button' value= 'edit'  class='edit' userId='"+row.id+"'  username=\""+row.username+"\"" +
	" email=\""+row.email+"\"lastName=\""+row.lastName+"\"firstName=\""+row.firstName+"\"embded=\""+row.embded+"\">" +"\" aboutMe=\""+row.aboutMe+
			" <input type='button' value= 'delete' class='delete'  userId='"+row.id+"' />"*/
	"6":"Action",
});
}
$("body").on("click",".newuser",function(){

	$('#btnSaveUser').show();
	$('#btnUpdateUser').hide();
	//$("#user_dialog").modal({backdrop : true});
	
	
	$("#user_dialog").modal({backdrop:true});
});
$(document).on("click", '#btnSaveUser', function() {
	
	var user={};
	user.username=$("#userName").val();
	user.email=$("#emailId").val();
	user.lastName=$("#lastName").val();
	user.firstName=$("#firstName").val();
	user.aboutMe=$("#about_me").val();
	user.password=$("#txtPassword").val();
	//user.confirm=$("#txtconfirmpassword").val();
	var sts=$("#ddlStatus option:selected").val();
	if(sts=="true"){
		user.status='ACTIVE';
	}else{
		user.status='INACTIVE';
	}
	user.enabled=$("#ddlStatus option:selected").val();
	user.userPic="default.png";
	saveUser(user);
	$("#user_dialog").modal("hide");
	
});

